import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpParams} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import { Stores } from '../classes/stores';

@Injectable({
  providedIn: 'root'
})
export class StoreserviceService {
  public API = '//localhost:1119/Stores';

  constructor(private http: HttpClient) {
  
   }
   addStore(logo: File, couverture: File, partner_id: number, store: any): Observable<any> {
    const formData = new FormData();
    formData.append('logo_path', logo);
    formData.append('couverture_path', couverture);
    formData.append('partner_id', partner_id.toString());
     // formData.append('store', JSON.stringify(store)); // COMMENTEE A CAUSE DE LA LIMITATION
     Object.keys(store).forEach(key => {
      formData.append(key, store[key]);
    });
    console.log(store);
    return this.http.post<any>(this.API + '/addStore', formData)
      .pipe(catchError(this.handleError));
  }
  addStores_Categories(store_id: number, categorie_id: number): Observable<any> {
    const formData = new FormData();
    formData.append('store_id', store_id.toString());
    formData.append('categorie_id', categorie_id.toString());
    return this.http.post<any>(this.API + '/addStores_Categories', formData)
      .pipe(catchError(this.handleError));
  }

  addPartner(user_id: number): Observable<any> {
    const formData = new FormData();
    formData.append('user_id', user_id.toString());
    return this.http.post<any>(this.API + '/addPartner', formData)
      .pipe(catchError(this.handleError));
  }
  getPartnerIdByUserId(user_id: number): Observable<any> {
    const params = new HttpParams().set('user_id', user_id.toString());
    return this.http.get<any>(this.API + '/getPartnerIdByUserId', {params})
      .pipe(catchError(this.handleError));
}
getStoreIdByPartnerId(partner_id: number): Observable<any> {
  const params = new HttpParams().set('partner_id', partner_id.toString());
  return this.http.get<any>(this.API + '/getStoreIdByPartnerId', {params})
    .pipe(catchError(this.handleError));
}
  
   private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  }
}

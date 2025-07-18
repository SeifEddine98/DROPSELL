import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpParams} from '@angular/common/http';
import {catchError, forkJoin, Observable, of, switchMap, throwError} from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CategorieserviceService {
  public API = '//localhost:1119/Categories';

  constructor(private http: HttpClient) { 

  }
  GetCategoriesIdByName(name: string): Observable<any> {
    const params = new HttpParams().set('name', name);
    return this.http.get<any>(this.API + '/GetCategoriesIdByName', {params})
      .pipe(catchError(this.handleError));
  }
  getSousCatégories(parent_id: number): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/' + parent_id);
  }
  getSousCatégoriesO(parent_id: number): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesOByParent_id/' + parent_id);
  }
  getAll(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesBy_id');
  }
  getAllO(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesOBy_id');
  }
  /*****/
  getAll1(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/1');
  }
  getAll2(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/2');
  }
  getAll3(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/3');
  }
  getAll4(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/4');
  }
  getAll5(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/5');
  }
  getAll6(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/6');
  }
  getAll7(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/7');
  }
   getAll8(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/8');
  }
  getAll9(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/9');
  }
  getAll10(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/10');
  }
  getAll11(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/11');
  }
  getAll12(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/12');
  }
  getAll13(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/13');
  }
  getAll14(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/14');
  }
  getAll15(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/15');
  }
  getAll16(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/16');
  }
  getAll17(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/17');
  }
    getAll18(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/18');
  }
  getAll19(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/19');
  }
  getAll20(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/20');
  }
  getAll84(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/84');
  }
  getAll85(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/85');
  }
  getAll86(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/86');
  }
  getAll87(): Observable<any> {
    return this.http.get(this.API + '/GetCategoriesByParent_id/87');
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

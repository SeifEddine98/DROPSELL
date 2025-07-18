import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpParams} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticleserviceService {
  public API = '//localhost:1119/Articles';

  constructor(private http: HttpClient) { 

  }
   getPointures(): Observable<any> {
    return this.http.get(this.API + '/GetPointures');
  }
  getTailles(): Observable<any> {
    return this.http.get(this.API + '/GetTailles');
  }
  addArticle(pictures: File[], category_id: number, store_id: number, status: string, article: any): Observable<any> {
    const formData = new FormData();
    
    for (let i = 0; i < pictures.length; i++) {
      formData.append('picture_path', pictures[i]);
    }
    
    formData.append('category_id', category_id.toString());
    formData.append('store_id', store_id.toString());
    formData.append('status', status);
    
    Object.keys(article).forEach(key => {
      formData.append(key, article[key]);
    });
    console.log(article);
    return this.http.post<any>(this.API + '/addArticle', formData)
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

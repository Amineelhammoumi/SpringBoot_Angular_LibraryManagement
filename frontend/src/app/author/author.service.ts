import { Injectable } from '@angular/core';
import  {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { Author } from './author';
const baseUrl = "http://localhost:8080/api/author"

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private httpClient : HttpClient) { }


  getallAuthors() : Observable<Author[]>{
    return this.httpClient.get<Author[]>(`${baseUrl}`)
  }


}

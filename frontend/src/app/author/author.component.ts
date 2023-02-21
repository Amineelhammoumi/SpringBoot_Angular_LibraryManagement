 import { Component, OnInit } from '@angular/core';
import { data } from 'jquery';
import { Author } from './author';
import { AuthorService } from './author.service';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.scss']
})
export class AuthorComponent implements OnInit {
authors? : Author[];

//constructor(private authorService : AuthorService) { }
 // ngOnInit(): void {
  //  this.getAllAuthors();
 // }

 constructor(private authorService : AuthorService){
  //get request from web api
  this.authorService.getallAuthors().subscribe({
    next:(data)=>{
      this.authors = data;
      console.log(data)
    }
  })
  setTimeout(()=>{
    $('#datatableexample').DataTable( {
      pagingType: 'full_numbers',
      pageLength: 5,
      processing: true,
      lengthMenu : [5, 10, 25]
  } );
  }, 1);
        }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
}

 /* getAllAuthors():void{
    this.authorService.getallAuthors().subscribe({
      next:(data)=>{
        this.authors = data;
        console.log(data)
      }
    })

  }*/




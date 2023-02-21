import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorComponent } from './author/author.component';
import { BookComponent } from './book/book.component';
import { CategoryComponent } from './category/category.component';
import { PublisherComponent } from './publisher/publisher.component';

const routes: Routes = [

{path: '',redirectTo : "/" , pathMatch : "full"},
{path: 'author', component : AuthorComponent},
{path: 'publisher', component : PublisherComponent},
{path: 'category', component : CategoryComponent},
{path: 'book', component : BookComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

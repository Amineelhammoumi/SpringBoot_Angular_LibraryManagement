import { Author } from "../author/author";
import { Category } from "../category/category";
import { Publisher } from "../publisher/publisher";

export class Book {

name : String;
isbn : String;
serialName : String;
description : String;
authors : Author[];
categories : Category[];
publishers : Publisher[];



constructor(name: String, isbn : String , serialName : String, description: string ,authors : Author[]  ,categories :Category[] , publishers: Publisher[] ) {
  this.name = name;
  this.isbn = isbn;
  this.serialName = serialName;
  this.description = description;
  this.authors = authors;
  this.categories = categories;
  this.publishers = publishers;

}

}

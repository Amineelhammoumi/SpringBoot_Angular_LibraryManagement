import { Book } from "../book/book";

export class Category {

  name : String;


  books : Book[];

   constructor(name: String, books : Book[] ) {
          this.name = name;

          this.books = books
  }
}

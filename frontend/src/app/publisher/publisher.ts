import { Book } from "../book/book";

export class Publisher {

  name : String;


  books : Book[];

   constructor(name: String, books : Book[] ) {
          this.name = name;

          this.books = books
  }
}

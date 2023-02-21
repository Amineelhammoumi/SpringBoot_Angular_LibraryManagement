import { Book } from "../book/book"

export class Author {

    name : String;
    description : String;
    books : Book[];

     constructor(name: String, description: string ,books : Book[] ) {
            this.name = name;
            this.description = description;
            this.books = books
    }
}

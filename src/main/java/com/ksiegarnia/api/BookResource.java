package com.ksiegarnia.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.ksiegarnia.domain.Book;
import com.ksiegarnia.service.BookManager;

@Path("books")
public class BookResource {
    @EJB
    BookManager bookStorage;

    @GET
    public List<Book> getAllBooksR() {
        return bookStorage.getAllBookR();
    }

    @GET
    @Path("{id}")
    public Book getR(@PathParam("id") Long id) {
        return bookStorage.getBookR(id);
    }

    @POST
    public void addBookR(
            @FormParam("title") String title,
            @FormParam("author") String author) {

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        
        bookStorage.addBookR(newBook);
    }

    @DELETE
    @Path("{id}")
    public void deleteR(@PathParam("id") Long id) {
        bookStorage.deleteBookR(id);
    }

    @POST
    @Path("{id}")
    public void editBookR(
            @PathParam("id") Long id,
            @FormParam("title") String title,
            @FormParam("author") String author) {

        Book book = bookStorage.getBookR(id);

        if (book != null) {
        	book.setTitle(title);
            book.setAuthor(author);

            bookStorage.updateBookR(book);
        }
    }
}
package com.ksiegarnia.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ksiegarnia.domain.Book;
import com.ksiegarnia.service.BookManager;

@Stateless
@Path("/books")
public class BookResource {
    @EJB
    BookManager bookStorage;

    @GET
    @Path("/showall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        return bookStorage.getAllBook();
    }

    @GET
    @Path("/details/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(@PathParam("id") long id) {
        return bookStorage.getBook(id);
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Book addBook(
            @FormParam("title") String title,
            @FormParam("author") String author) {

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
       
        
        bookStorage.addBook(book);
        return book;
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteBook(@PathParam("id") Long id) {
        bookStorage.deleteBook(id);
    }

    @PUT
    @Path("edit/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book editBook(
            @PathParam("id") Long id,
            @FormParam("title") String title,
            @FormParam("author") String author) {

        Book book = bookStorage.getBook(id);

        if (book != null) {
        	book.setTitle(title);
            book.setAuthor(author);

            bookStorage.updateBook(book, title, author);
        }
        return book;
    }
}
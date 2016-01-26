package com.ksiegarnia.api;

import java.util.Date;
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
import com.ksiegarnia.domain.Review;
import com.ksiegarnia.service.BookManager;

@Stateless
@Path("/reviews")
public class ReviewResource {
    @EJB
    BookManager bookStorage;

    @GET
    @Path("/showall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Review> getAllReviews() {
        return bookStorage.getAllReview();
    }

    @GET
    @Path("/details/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Review getReview(@PathParam("id") long id) {
        return bookStorage.getReview(id);
    }
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Review addReview(
            @FormParam("book") Long book,
            @FormParam("revAuthor") String revAuthor,
            @FormParam("text") String text)
    {
    	Review review = new Review();

    	review.setBook(bookStorage.getBook(book));
    	review.setAddDate(new Date());
    	review.setRevAuthor(revAuthor);
    	review.setText(text);

    	bookStorage.addReview(review);

       return review;
    }
      
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteReview(@PathParam("id") Long id) {
        bookStorage.deleteReview(id);
    }

    @PUT
    @Path("edit/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Review editReview(
            @PathParam("id") Long id,
            @FormParam("revAuthor") String revAuthor,
            @FormParam("text") String text) {

        Review review = bookStorage.getReview(id);
        Long bookID = review.getBook().getId();
        Book book = bookStorage.getBook(bookID);
        bookStorage.updateReview(book, review, revAuthor, text);
        return review;
    }
}

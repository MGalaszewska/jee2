package com.ksiegarnia.service;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ksiegarnia.domain.Book;
import com.ksiegarnia.domain.Review;

@Stateless
public class BookManager {
    @PersistenceContext
    EntityManager em;
    
    public Book get(Long id) {
        return em.find(Book.class, id);
    }
    
	public void addBook(Book book) {
		book.setId(null);
		em.persist(book);
	}
	public void updateBook(Long id, String title, String author) {
        Book book= em.find(Book.class, id);
        book.setTitle(title);
        book.setAuthor(author);

        em.merge(book);
    }
	
	public void deleteBook(Long id) {
		Book book = em.find(Book.class, id);
		em.remove(book);
	}
	
	public void addReview(Book book, Review review) {
        List<Review> reviews = book.getReviews();
        reviews.add(review);

        book.setReviews(reviews);

        em.merge(book);
    }

	@SuppressWarnings("unchecked")
	public List<Book> getAllBook() {
		return em.createNamedQuery("book.all").getResultList();
	}
}

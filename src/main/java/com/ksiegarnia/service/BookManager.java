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

	public Book getBook(Long id) {
		return em.find(Book.class, id);
	}

	public void addBook(Book book) {
		book.setId(null);
		em.persist(book);
		em.flush();
	}

	public void updateBook(Book book, String title, String author) {
		book = em.find(Book.class, book.getId());
		book.setTitle(title);
		book.setAuthor(author);

		em.merge(book);
	}

	public void deleteBook(Long id) {
		Book book = em.find(Book.class, id);
		em.remove(book);
	}

	@SuppressWarnings("unchecked")
	public List<Book> getAllBook() {
		return em.createNamedQuery("book.all").getResultList();
	}

// REVIEWS

	public Review getReview(Long id) {
		return em.find(Review.class, id);
	}

	public void addReview(Review review) {
		review.setId(null);
		em.persist(review);
	}

	public void updateReview(Book book, Review review, String revAuthor, String text) {
		review = em.find(Review.class, review.getId());
		review.setBook(book);
		review.setRevAuthor(revAuthor);
		review.setText(text);
		em.merge(review);
	}
	public void deleteReview(Long id) {
		Review review = em.find(Review.class, id);
		Book book = em.find(Book.class,  review.getBook().getId());
		book.getReviews().remove(review);
		em.remove(review);
	}

	@SuppressWarnings("unchecked")
	public List<Review> getAllReview() {
		return em.createNamedQuery("review.all").getResultList();
	}
}

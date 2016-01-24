package com.ksiegarnia.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ksiegarnia.domain.Book;

@Stateless
public class BookManager {
	@PersistenceContext
	EntityManager em;
	
	private List<Book> books = new ArrayList<Book>();

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
		/*
		books.set(books.indexOf(book), book);
		*/
	}

	public void deleteBook(Long id) {
		Book book = em.find(Book.class, id);
		em.remove(book);
	}

	@SuppressWarnings("unchecked")
	public List<Book> getAllBook() {
		return em.createNamedQuery("book.all").getResultList();
	}
}


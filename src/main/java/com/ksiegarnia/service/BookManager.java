package com.ksiegarnia.service;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ksiegarnia.domain.Book;

@Stateless
public class BookManager {
    @PersistenceContext
    EntityManager em;
    
	public void addBook(Book book) {
		book.setId(null);
		em.persist(book);
	}
	public void updateBook(Book book){
		book = em.find(Book.class, book.getId());
		em.merge(book);
	}
	
	public void deleteBook(Book book) {
		book = em.find(Book.class, book.getId());
		em.remove(book);
	}

	@SuppressWarnings("unchecked")
	public List<Book> getAllBook() {
		return em.createNamedQuery("book.all").getResultList();
	}
}

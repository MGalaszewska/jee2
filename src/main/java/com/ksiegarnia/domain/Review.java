package com.ksiegarnia.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries(@NamedQuery(name = "review.all", query = "Select r from Review r order by r.id"))
public class Review {

	
	private Long id;

	private String revAuthor = "";
	private String text = "";
	private Book book;
	
	public Review() { }
	
	public Review(String revAuthor, String text, Book book, Date addDate) {
		this.revAuthor = revAuthor;
		this.text = text;
		this.book = book;
		this.addDate = addDate;
	}

	
	private Date addDate = new Date();

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Temporal(TemporalType.DATE)
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	@ManyToOne
	@JoinColumn(name="id_book", nullable=false)
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	

	public String getRevAuthor() {
		return revAuthor;
	}

	public void setRevAuthor(String revAuthor) {
		this.revAuthor = revAuthor;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}

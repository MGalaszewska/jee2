package com.ksiegarnia.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@NamedQueries(@NamedQuery(name = "book.all", query = "select b from Book b order by b.id"))
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Long id;

	private String title;
	private String author;
	
	private List<Review> reviews = new ArrayList<Review>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "book")
	@JsonIgnore
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

	public Book() {
	}
	
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

    

}

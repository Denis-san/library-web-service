package br.com.san.weblibrary.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.san.weblibrary.entities.enums.Language;

public class Book {

	private Long id;
	private String title;
	private Integer year;
	private Integer language;
	private Integer isbn;
	
	private Set<Category> categories = new HashSet<Category>(); 
	
	private Set<Author> authors = new HashSet<Author>(); 
	
	private Set<OrderItem> orders = new HashSet<OrderItem>();
	
	public Book() {
	
	}


	public Book(Long id, String title, Integer year, Language language, Integer isbn) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		setLanguage(language);
		this.isbn = isbn;
	}


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


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public Language getLanguage() {
		return Language.valueOfCode(language);
	}

	public void setLanguage(Language language) {
		if(language != null) {
			this.language = language.getCode();
		}
	}

	public Integer getIsbn() {
		return isbn;
	}


	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public Set<Category> getCategories() {
		return categories;
	}
	
	public Set<Author> getAuthors() {
		return authors;
	}
	
	@JsonIgnore
	public Set<Order> getOrders(){
		Set<Order> set = new HashSet<Order>();
		for(OrderItem orderItem : orders) {
			set.add(orderItem.getOrder());
		}
		
		return set;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}

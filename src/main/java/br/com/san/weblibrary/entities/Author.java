package br.com.san.weblibrary.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.san.weblibrary.entities.enums.Nationality;

@Entity
@Table(name = "tb_author")
public class Author implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String shortBiography;
	private Integer nationality;
	
	@ManyToMany(mappedBy = "categories")
	private Set<Book> books = new HashSet<Book>();
	
	public Author() {
	}

	public Author(Long id, String name, Nationality nationality, String shortBiography) {
		super();
		this.id = id;
		this.name = name;
		setNationality(nationality);
		this.shortBiography = shortBiography;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortBiography() {
		return shortBiography;
	}

	public void setShortBiography(String shortBiography) {
		this.shortBiography = shortBiography;
	}

	public Nationality getNationality() {
		return Nationality.valueOfCode(nationality);
	}

	public void setNationality(Nationality nationality) {
		if(nationality != null) {
			this.nationality = nationality.getCode();
		}
	}
	
	public Set<Book> getBooks() {
		return books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Author other = (Author) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}

package kindle.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private int pages;
	@ManyToMany
	private List<Author> authors;
	@ManyToOne
	private Publisher publisher;
	
	public Book(String title, int pages, Publisher publisher) {
		super();
		this.title = title;
		this.pages = pages;
		this.authors = new ArrayList<Author>();
		this.publisher = publisher;
	}

	public void addAuthor(Author author) {
		if(author != null)
			authors.add(author);
	}
	
	public boolean verifyAuthorsList() {
		if (authors.size() < 1)
			return false;
		
		return true;
	}
	
	public boolean verifyPages() {
		if (pages < 0)
			return false;
		
		return true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
}

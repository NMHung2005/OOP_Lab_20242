package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private List<String> authors = new ArrayList<String>();

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public void addAuthor(String author) {
		if (!authors.contains(author)) {
			authors.add(author);
		} else {
			System.out.println("Da ton tai");
		}
	}

	public void removeAuthor(String author) {
		if (authors.contains(author)) {
			authors.remove(author);
			System.out.println("Da xoa phan tu");
		}
	}
}

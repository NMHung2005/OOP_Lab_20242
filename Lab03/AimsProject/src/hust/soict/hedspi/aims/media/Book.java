package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	private List<String> authors = new ArrayList<String>();

	public List<String> getAuthors() {
		return authors;
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

	public String toString() {
		return "BOOK - " + this.id + " - " + this.title + " - " + this.category + " - " + this.cost + " $";
	}
}

package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost);
		this.length = length;
		this.director = director;
	}

	public String toString() {
		return "Disc - " + this.id + " - " + this.title + " - " + this.category + " - " + this.director + " - "
				+ this.length + " - " + this.cost + " $";
	}
}

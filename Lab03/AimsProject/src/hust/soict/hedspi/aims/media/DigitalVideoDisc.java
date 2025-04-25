package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private int length;
	private String director;

	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
	}

	public String toString() {
		return "DVD - " + this.id + " - " + this.title + " - " + this.category + " - " + this.director + " - "
				+ this.length + " - " + this.cost + " $";
	}

	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
	private int id;
	private String title;
	private String category;
	private String director;
	private float cost;
	private int length;
	private static int nbDigitalVideoDiscs = 0;

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getDirector() {
		return director;
	}

	public float getCost() {
		return cost;
	}

	public int getLength() {
		return length;
	}

	public DigitalVideoDisc(String title) {
		this.title = title;
		nbDigitalVideoDiscs++;
		id = nbDigitalVideoDiscs;
	}

	public void setTitle(String title) {
		this.title = title;
		nbDigitalVideoDiscs++;
		id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String director, String category, String title, float cost) {
		this.director = director;
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this.length = length;
		this.director = director;
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		id = nbDigitalVideoDiscs;
	}

	public String toString() {
		return "DVD - " + this.title + " - " + this.category + " - " + this.director + " - " + this.length + " - "
				+ this.cost + " $";
	}

	public boolean isMatch(int id) {
		return this.id == id;
	}

	public boolean isMatch(String title) {
		return this.title.toLowerCase().contains(title.toLowerCase());
	}
}
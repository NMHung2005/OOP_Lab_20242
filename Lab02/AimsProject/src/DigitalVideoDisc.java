
public class DigitalVideoDisc {
	private int id;
	private String title;
	private String category;
	private String director;
	private double cost;
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

	public double getCost() {
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

	public DigitalVideoDisc(String title, String category, double cost) {
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String director, String category, String title, double cost) {
		this.director = director;
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
		this.length = length;
		this.director = director;
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		id = nbDigitalVideoDiscs;
	}
}

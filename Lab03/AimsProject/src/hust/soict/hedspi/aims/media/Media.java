package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
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

	public void setTitle(String tilte) {
		this.title = tilte;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public boolean isMatch(int id) {
		return this.id == id;
	}

	public boolean isMatch(String title) {
		return this.title.equalsIgnoreCase(title);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Media media = (Media) o;
		return this.title.equals(media.title);
	}

	public String toString() {
		return this.id + " - " + this.title + " - " + this.category + " - " + this.cost + " $";
	}
}

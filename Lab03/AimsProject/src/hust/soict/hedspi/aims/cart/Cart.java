package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private List<Media> itemsOrdered = new ArrayList<Media>();

	public void addMedia(Media media1) {
		itemsOrdered.add(media1);
		System.out.println("The disc has been added");

	}

	public void removeMedia(Media media1) {
		if (itemsOrdered.remove(media1)) {
			System.out.println("Remove SS");
		}
	}

	public double totalCost() {
		float sum = 0f;
		for (Media t : itemsOrdered) {
			sum += t.getCost();
		}
		return sum;
	}

	public void display() {
		for (Media t : itemsOrdered) {
			System.out.println(t.toString());
		}
		System.out.printf("Total cost: %.2f\n", totalCost());
	}

	public void searchId(int id) {
		for (Media t : itemsOrdered) {
			if (t.isMatch(id) == true) {
				System.out.println("Found DVD: " + t.toString());
				return;
			}
		}
		System.out.println("No found!");
	}

	public void searchTitle(String str) {
		for (Media t : itemsOrdered) {
			if (t.isMatch(str)) {
				System.out.println("Found DVD: " + t.toString());
				return;
			}
		}
		System.out.println("No found!");
	}
}

package hust.soict.hedspi.aims.cart;

import java.util.Collections;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public void sortByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}

	public void addMedia(Media media1) throws LimitExceededException {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			if (!itemsOrdered.equals(media1)) {
				itemsOrdered.add(media1);
				System.out.println("The media has been added");
			}
		} else {
			throw new LimitExceededException("ERROW: The number of " + "media has reached its limit");
		}
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
	}

	public Media searchId(int id) {
		for (Media t : itemsOrdered) {
			if (t.isMatch(id) == true) {
				System.out.println("Found DVD: " + t.toString());
				return t;
			}
		}
		System.out.println("No found!");
		return null;
	}

	public Media searchTitle(String str) {
		for (Media t : itemsOrdered) {
			if (t.isMatch(str)) {
				return t;
			}
		}
		System.out.println("No found!");
		return null;
	}

	public void sortCart(Scanner scanner) {
		System.out.println("\nChoose sort option for store:");
		System.out.println("1. Sort by Title then Cost");
		System.out.println("2. Sort by Cost then Title");
		System.out.print("Your choice: ");

		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
			System.out.println("Cart sorted by Title then Cost.");
			break;
		case 2:
			Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
			System.out.println("Cart sorted by Cost then Title.");
			break;
		default:
			System.out.println("Invalid choice. Store not sorted.");
		}

		display();
	}

	public void searchMedia(Scanner scanner) {
		System.out.println("\nSearch media in cart:");
		System.out.println("1. Search by ID");
		System.out.println("2. Search by Title");
		System.out.print("Your choice: ");

		int choice = scanner.nextInt();
		scanner.nextLine(); // bỏ dòng thừa sau khi nhập số

		switch (choice) {
		case 1:
			System.out.print("Enter media ID: ");
			int id = scanner.nextInt();
			scanner.nextLine(); // bỏ dòng thừa
			searchId(id); // đã in kết quả trong hàm
			break;

		case 2:
			System.out.print("Enter media title: ");
			String title = scanner.nextLine();
			Media found = searchTitle(title);
			if (found != null) {
				System.out.println("Found Media: " + found.toString());
			}
			// Nếu không tìm thấy thì hàm searchTitle đã in “No found!”
			break;

		default:
			System.out.println("Invalid choice.");
		}
	}

	public void removeMediaByTitle(Scanner scanner) {
		System.out.print("Enter the title of the media to remove: ");
		String title = scanner.nextLine();

		Media mediaToRemove = null;
		for (Media media : itemsOrdered) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				mediaToRemove = media;
				break;
			}
		}

		if (mediaToRemove != null) {
			itemsOrdered.remove(mediaToRemove);
			System.out.println("Media removed from cart: " + mediaToRemove.toString());
		} else {
			System.out.println("Media with title '" + title + "' not found in the cart.");
		}
	}

	public void playMediaByTitle(Scanner scanner) throws PlayerException {
		System.out.print("Enter the title of the media to play: ");
		String title = scanner.nextLine();

		Media media = null;
		for (Media item : itemsOrdered) {
			if (item.getTitle().equalsIgnoreCase(title)) {
				media = item;
				break;
			}
		}

		if (media == null) {
			System.out.println("Media not found in the cart.");
			return;
		}

		// Kiểm tra xem media có thể play hay không
		if (media instanceof Playable) {
			((Playable) media).play();
		} else {
			System.out.println("This media cannot be played.");
		}
	}

	public void placeOrder() {
		if (itemsOrdered.isEmpty()) {
			System.out.println("Your cart is empty. Cannot place an order.");
			return;
		}

		System.out.println("Your order has been placed successfully!");
		itemsOrdered.clear(); // Làm rỗng giỏ hàng
	}

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
}

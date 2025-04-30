package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class Store {
	public static final int MAX_NUMBERS_STORED = 999;
	private List<Media> itemsInStore = new ArrayList<Media>();

	public List<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void addMedia(Media media1) {
		itemsInStore.add(media1);
		System.out.println("The media has been added");
	}

	public void removeMedia(Media media1) {
		if (itemsInStore.remove(media1)) {
			System.out.println("Remove SS");
		}
	}

	public void display() {
		for (Media t : itemsInStore) {
			System.out.println(t.toString());
		}
	}

	public Media searchId(int id) {
		for (Media t : itemsInStore) {
			if (t.isMatch(id) == true) {
				System.out.println("Found DVD: " + t.toString());
				return t;
			}
		}
		System.out.println("No found!");
		return null;
	}

	public Media searchTitle(String str) {
		for (Media t : itemsInStore) {
			if (t.isMatch(str)) {
				return t;
			}
		}
		System.out.println("No found!");
		return null;
	}

	public void viewMediaDetails(Scanner scanner) {
		System.out.println("Nhap title ban muon xem thong tin");
		String titleF = scanner.nextLine();
		boolean found = false;
		for (Media t : itemsInStore) {
			if (t.getTitle().equalsIgnoreCase(titleF)) {
				System.out.println("\nMedia found:");
				System.out.println(t.toString());
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Not Found");
		}
	}

	public void addMediaToCart(Scanner scanner, Cart cart) {
		System.out.print("Enter the title of the media to add to cart: ");
		String title = scanner.nextLine();
		boolean found = false;

		for (Media media : itemsInStore) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				cart.addMedia(media);
				System.out.println("Added \"" + media.getTitle() + "\" to the cart.");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Media not found in the store.");
		}
	}

	public void playMedia(Cart cart, Scanner scanner) {
		System.out.print("Enter the title of the media you want to play: ");
		String title = scanner.nextLine();

		boolean found = false;
		for (Media media : itemsInStore) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				found = true;
				if (media instanceof Playable) { // Playable là interface do CD/DVD implement
					((Playable) media).play();
				} else {
					System.out.println("This media cannot be played!");
				}
				break;
			}
		}

		if (!found) {
			System.out.println("Media not found in the store.");
		}
	}

}

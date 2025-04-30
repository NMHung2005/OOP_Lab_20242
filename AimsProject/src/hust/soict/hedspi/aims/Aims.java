package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 124, "George Lucas");
		Book book1 = new Book(3, "Clean Code", "Programming", 15.99f);
		CompactDisc cd1 = new CompactDisc(4, "Back in Black", "Rock", 40.0f, 123, "AC/DC", "Hung");
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(book1);
		store.addMedia(cd1);

		while (true) {
			showMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				viewStore();
				break;
			case 2:
				updateStore();
				break;
			case 3:
				seeCurrentCart();
				break;
			case 0:
				System.out.println("Exit");
				return;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("\nOptions:");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: 0-1-2-3-4: ");
	}

	public static void mediaDetailsMenu() {
		System.out.println("\nOptions:");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: 0-1-2: ");
	}

	public static void cartMenu() {
		System.out.println("\nOptions:");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: 0-1-2-3-4-5: ");
	}

	// showMenu case1: View store
	public static void viewStore() {
		store.display();
		while (true) {
			storeMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				store.viewMediaDetails(scanner);
				break;
			case 2:
				store.addMediaToCart(scanner, cart);
				break;
			case 3:
				store.playMedia(cart, scanner);
				break;
			case 4:
				cart.display();
				break;
			case 0:
				return;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	// showMenu case2: Update store
	public static void updateStore() {
		System.out.println("Later");
	}

	public static void seeCurrentCart() {
		while (true) {
			cart.display();
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				cart.searchMedia(scanner);
				break;
			case 2:
				cart.sortCart(scanner);
				break;
			case 3:
				cart.removeMediaByTitle(scanner);
				break;
			case 4:
				cart.playMediaByTitle(scanner);
				break;
			case 5:
				cart.placeOrder();
				return;
			case 0:
				return;
			default:
				System.out.println("Invalid choice");
			}
		}
	}
}

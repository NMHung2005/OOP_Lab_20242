package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		initializeStore();
		showMenu();
	}

	private static void initializeStore() {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 124, "George Lucas");

		Book book1 = new Book(1, "Sherlock Holmes", "Detective", 15.5f);
		book1.addAuthor("Arthur Conan Doyle");

		CompactDisc cd1 = new CompactDisc(3, "Greatest Hits", "Music", 12.99f, 0, "Various Artists", null);
		cd1.addTrack(new Track("Track 1", 4));
		cd1.addTrack(new Track("Track 2", 3));

		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(book1);
		store.addMedia(cd1);
	}

	public static void showMenu() {
		int choice = -1;
		do {
			System.out.println("AIMS:");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.print("Please choose a number: 0-1-2-3: ");

			choice = scanner.nextInt();
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
				System.out.println("Exit AIMS");
				break;
			default:
				System.out.println("Invalid choice");
			}
		} while (choice != 0);
	}

	// ========== STORE ==========
	public static void viewStore() {
		store.display();
		storeMenu();
	}

	public static void storeMenu() {
		int choice;
		do {
			System.out.println("Options:");
			System.out.println("--------------------------------");
			System.out.println("1. See a media's details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.print("Please choose a number: 0-1-2-3-4: ");

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				seeMediaDetails();
				break;
			case 2:
				addMediaToCart();
				break;
			case 3:
				playMedia();
				break;
			case 4:
				seeCurrentCart();
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice != 0);
	}

	public static void seeMediaDetails() {
		System.out.print("Enter the title of the media: ");
		String title = scanner.nextLine();

		Media media = searchByTitle(title, store);
		if (media == null) {
			System.out.println("Media not found.");
			return;
		}

		System.out.println(media);
		mediaDetailsMenu(media);
	}

	public static void mediaDetailsMenu(Media media) {
		int choice;
		do {
			System.out.println("Options:");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			if (media instanceof Playable) {
				System.out.println("2. Play");
			}
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.print("Please choose a number: ");

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				cart.addMedia(media);
				break;
			case 2:
				if (media instanceof Playable) {
					((Playable) media).play();
				} else {
					System.out.println("Invalid choice.");
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}

	public static void addMediaToCart() {
		System.out.print("Enter the title of the media: ");
		String title = scanner.nextLine();

		Media media = searchByTitle(title, store);
		if (media == null) {
			System.out.println("Media not found.");
			return;
		}

		cart.addMedia(media);
	}

	public static void playMedia() {
		System.out.print("Enter the title of the media: ");
		String title = scanner.nextLine();

		Media media = searchByTitle(title, store);
		if (media == null) {
			System.out.println("Media not found.");
			return;
		}

		if (media instanceof Playable) {
			((Playable) media).play();
		} else {
			System.out.println("This media is not playable.");
		}
	}

	// ========== STORE UPDATE ==========
	public static void updateStore() {
		int choice;
		do {
			System.out.println("Update Store Options:");
			System.out.println("--------------------------------");
			System.out.println("1. Add a media to store");
			System.out.println("2. Remove a media from store");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.print("Please choose a number: 0-1-2: ");

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addMediaToStore();
				break;
			case 2:
				removeMediaFromStore();
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}

	public static void addMediaToStore() {
		System.out.println("What type of media do you want to add?");
		System.out.println("1. Book");
		System.out.println("2. DVD");
		System.out.println("3. CD");
		System.out.print("Choose a number: ");

		int choice = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter title: ");
		String title = scanner.nextLine();

		System.out.print("Enter category: ");
		String category = scanner.nextLine();

		System.out.print("Enter cost: ");
		float cost = scanner.nextFloat();
		scanner.nextLine();

		Media newMedia = null;

		switch (choice) {
		case 1:
			System.out.print("Enter ID: ");
			int bookId = scanner.nextInt();
			scanner.nextLine();

			newMedia = new Book(bookId, title, category, cost);

			System.out.print("Do you want to add authors? (y/n): ");
			String addAuthors = scanner.nextLine();

			while (addAuthors.equalsIgnoreCase("y")) {
				System.out.print("Enter author name (or 'exit' to finish): ");
				String author = scanner.nextLine();
				if (author.equalsIgnoreCase("exit"))
					break;
				((Book) newMedia).addAuthor(author);
			}
			break;

		case 2:
			System.out.print("Enter director: ");
			String director = scanner.nextLine();

			System.out.print("Enter length: ");
			int length1 = scanner.nextInt();
			scanner.nextLine();

			newMedia = new DigitalVideoDisc(0, title, category, cost, length1, director);
			break;

		case 3:
			System.out.print("Enter ID: ");
			int cdId = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter artist: ");
			String artist = scanner.nextLine();

			System.out.print("Enter director: ");
			String director1 = scanner.nextLine();

			System.out.print("Enter length: ");
			int length = scanner.nextInt();
			scanner.nextLine();

			newMedia = new CompactDisc(cdId, title, category, cost, length, director1, artist);

			System.out.print("Do you want to add tracks? (y/n): ");
			String addTracks = scanner.nextLine();

			while (addTracks.equalsIgnoreCase("y")) {
				System.out.print("Enter track title (or 'exit' to finish): ");
				String trackTitle = scanner.nextLine();
				if (trackTitle.equalsIgnoreCase("exit"))
					break;

				System.out.print("Enter track length: ");
				int trackLength = scanner.nextInt();
				scanner.nextLine();

				((CompactDisc) newMedia).addTrack(new Track(trackTitle, trackLength));
			}
			break;

		default:
			System.out.println("Invalid choice.");
			return;
		}

		store.addMedia(newMedia);
	}

	public static void removeMediaFromStore() {
		System.out.print("Enter the title of the media to remove: ");
		String title = scanner.nextLine();

		Media media = searchByTitle(title, store);
		if (media == null) {
			System.out.println("Media not found.");
			return;
		}

		store.removeMedia(media);
	}

	// ========== CART ==========
	public static void seeCurrentCart() {
		cart.display();
		cartMenu();
	}

	public static void cartMenu() {
		int choice;
		do {
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

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				filterMediaInCart();
				break;
			case 2:
				sortMediaInCart();
				break;
			case 3:
				removeMediaFromCart();
				break;
			case 4:
				playMediaFromCart();
				break;
			case 5:
				placeOrder();
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}

	public static void filterMediaInCart() {
		System.out.println("Filter options:");
		System.out.println("1. By ID");
		System.out.println("2. By title");
		System.out.print("Choose a filter option: ");

		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			System.out.print("Enter ID: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			cart.searchId(id);
			break;
		case 2:
			System.out.print("Enter title: ");
			String title = scanner.nextLine();
			cart.searchTitle(title);
			break;
		default:
			System.out.println("Invalid choice.");
		}
	}

	public static void sortMediaInCart() {
		System.out.println("Sort options:");
		System.out.println("1. By title");
		System.out.println("2. By cost");
		System.out.print("Choose a sort option: ");

		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			cart.sortByTitleCost();
			System.out.println("Cart has been sorted by title.");
			break;
		case 2:
			cart.sortByCostTitle();
			System.out.println("Cart has been sorted by cost.");
			break;
		default:
			System.out.println("Invalid choice.");
		}
		cart.display();
	}

	public static void removeMediaFromCart() {
		System.out.print("Enter the title of the media to remove: ");
		String title = scanner.nextLine();

		Media media = searchByTitle(title, cart);
		if (media == null) {
			System.out.println("Media not found in cart.");
			return;
		}

		cart.removeMedia(media);
	}

	public static void playMediaFromCart() {
		System.out.print("Enter the title of the media: ");
		String title = scanner.nextLine();

		Media media = searchByTitle(title, cart);
		if (media == null) {
			System.out.println("Media not found in cart.");
			return;
		}

		if (media instanceof Playable) {
			((Playable) media).play();
		} else {
			System.out.println("This media is not playable.");
		}
	}

	public static void placeOrder() {
		System.out.println("Order created successfully!");
		System.out.println("Total cost: $" + cart.totalCost());
		emptyCart();
		System.out.println("Cart has been emptied.");
	}

	private static void emptyCart() {
		// Logic để xóa giỏ hàng
	}

	private static Media searchByTitle(String title, Store store) {
		for (Media media : getAllMediaFromStore()) {
			if (media.isMatch(title))
				return media;
		}
		return null;
	}

	private static Media searchByTitle(String title, Cart cart) {
		return cart.searchTitle(title);
	}

	private static ArrayList<Media> getAllMediaFromStore() {
		return (ArrayList<Media>) store.getItemsInStore();
	}
}

package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_STORED = 999;
	private List<Media> itemsInStore = new ArrayList<Media>();

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

	public List<Media> getItemsInStore() {
		return itemsInStore;
	}
}

package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_STORED = 999;
	private DigitalVideoDisc itemInStore[] = new DigitalVideoDisc[MAX_NUMBERS_STORED];
	private int qtyStored = 0;

	public void addDVD(DigitalVideoDisc disc) {
		if (qtyStored < MAX_NUMBERS_STORED) {
			itemInStore[qtyStored] = disc;
			qtyStored++;
			System.out.println("The disc has been added");
		} else {
			System.out.println("The cart is almost full");
		}
	}

	public void removeDVD(DigitalVideoDisc disc) {
		int index = -1;
		for (int i = 0; i < qtyStored; i++) {
			if (itemInStore[i] != null && itemInStore[i].getTitle().equals(disc.getTitle())
					&& itemInStore[i].getId() == disc.getId()) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			for (int i = index; i < qtyStored - 1; i++) {
				itemInStore[i] = itemInStore[i + 1];
			}
			itemInStore[qtyStored - 1] = null;
			qtyStored--;
		}
	}

	public void display() {
		for (int i = 0; i < qtyStored; i++) {
			System.out.println((i + 1) + ". " + itemInStore[i].toString());
		}
	}
}

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		} else {
			System.out.println("The cart is almost full");
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.println("The disc has been added");
			} else {
				System.out.println("The cart is almost full");
			}
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			System.out.println("The disc has been added");
		} else {
			System.out.println("The cart is almost full");
		}
		if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered] = dvd2;
			qtyOrdered++;
			System.out.println("The disc has been added");
		} else {
			System.out.println("The cart is almost full");
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int index = -1;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemOrdered[i] != null && itemOrdered[i].getTitle().equals(disc.getTitle())
					&& itemOrdered[i].getCost() == disc.getCost()) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			for (int i = index; i < qtyOrdered - 1; i++) {
				itemOrdered[i] = itemOrdered[i + 1];
			}
			itemOrdered[qtyOrdered - 1] = null;
			qtyOrdered--;
		}
	}

	public double totalCost() {
		double sum = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemOrdered[i].getCost();
		}
		return sum;
	}

	public void display() {
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.printf("%-7d%-20s%6.2f\n", (i + 1), itemOrdered[i].getTitle(), itemOrdered[i].getCost());
		}
		System.out.printf("%17s%16.2f\n", "Total cost", totalCost());
	}
}

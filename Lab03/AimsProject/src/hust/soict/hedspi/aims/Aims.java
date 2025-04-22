package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
	public static void main(String args[]) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc[] disc = { dvd2, dvd3 };
		anOrder.addDigitalVideoDisc(dvd2, dvd3);
		System.out.println("Total cost is:");
		System.out.println(anOrder.totalCost());
		anOrder.display();
		anOrder.removeDigitalVideoDisc(dvd3);
		anOrder.display();
	}
}

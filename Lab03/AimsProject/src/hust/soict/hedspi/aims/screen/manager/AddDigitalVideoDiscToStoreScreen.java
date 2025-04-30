package hust.soict.hedspi.aims.screen.manager;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

	public AddDigitalVideoDiscToStoreScreen(Store store, StoreManagerScreen parentScreen) {
		super(store, "Add DVD", parentScreen);
	}

	@Override
	protected JPanel createCenter() {
		JPanel center = new JPanel(new GridLayout(6, 2, 5, 5));
		JTextField titleField = new JTextField();
		JTextField categoryField = new JTextField();
		JTextField costField = new JTextField();
		JTextField lengthField = new JTextField();
		JTextField directorField = new JTextField();

		center.add(new JLabel("Title:"));
		center.add(titleField);
		center.add(new JLabel("Category:"));
		center.add(categoryField);
		center.add(new JLabel("Cost:"));
		center.add(costField);
		center.add(new JLabel("Length:"));
		center.add(lengthField);
		center.add(new JLabel("Director:"));
		center.add(directorField);

		center.add(new JLabel());
		JButton addButton = new JButton("Add DVD");
		addButton.addActionListener(e -> {
			String title = titleField.getText();
			String category = categoryField.getText();
			float cost = Float.parseFloat(costField.getText());
			int length = Integer.parseInt(lengthField.getText());
			String director = directorField.getText();

			DigitalVideoDisc dvd = new DigitalVideoDisc(store.getItemsInStore().size() + 1, title, category, cost,
					length, director);
			store.addMedia(dvd);
			JOptionPane.showMessageDialog(this, "DVD added to store!");
		});
		center.add(addButton);
		return center;
	}
}

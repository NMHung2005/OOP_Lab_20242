package hust.soict.hedspi.aims.screen.manager;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

	public AddBookToStoreScreen(Store store, StoreManagerScreen parentScreen) {
		super(store, "Add Book", parentScreen);
	}

	@Override
	protected JPanel createCenter() {
		JPanel center = new JPanel(new GridLayout(4, 2, 5, 5));
		JTextField titleField = new JTextField();
		JTextField categoryField = new JTextField();
		JTextField costField = new JTextField();
		JTextField authorsField = new JTextField(); // multiple authors separated by comma

		center.add(new JLabel("Title:"));
		center.add(titleField);
		center.add(new JLabel("Category:"));
		center.add(categoryField);
		center.add(new JLabel("Cost:"));
		center.add(costField);
		center.add(new JLabel("Authors (comma separated):"));
		center.add(authorsField);

		center.add(new JLabel());
		JButton addButton = new JButton("Add Book");
		addButton.addActionListener(e -> {
			String title = titleField.getText();
			String category = categoryField.getText();
			float cost = Float.parseFloat(costField.getText());
			String[] authors = authorsField.getText().split(",");

			Book book = new Book(store.getItemsInStore().size() + 1, title, category, cost);
			for (String author : authors) {
				book.addAuthor(author.trim());
			}

			store.addMedia(book);
			JOptionPane.showMessageDialog(this, "Book added to store!");
		});
		center.add(addButton);
		return center;
	}
}

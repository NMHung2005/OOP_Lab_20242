package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
	protected Store store;
	protected StoreManagerScreen parentScreen;

	public AddItemToStoreScreen(Store store, String titleText, StoreManagerScreen parentScreen) {
		this.store = store;
		this.parentScreen = parentScreen;
		setTitle(titleText);
		setSize(600, 400);
		setLayout(new BorderLayout());

		setJMenuBar(createMenuBar()); // <-- thêm menu bar
		add(createHeader(titleText), BorderLayout.NORTH);
		add(createCenter(), BorderLayout.CENTER);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	// ------------------ Menu bar ----------------------
	protected JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");

		JMenuItem viewStore = new JMenuItem("View store");
		viewStore.addActionListener(e -> {
			parentScreen.setVisible(true); // Hiển thị lại màn hình Store cũ
			dispose(); // Đóng cửa sổ hiện tại
		});
		menu.add(viewStore);

		JMenu smUpdateStore = new JMenu("Update Store");

		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(e -> {
			new AddBookToStoreScreen(store, parentScreen);
			dispose();
		});

		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(e -> {
			new AddCompactDiscToStoreScreen(store, parentScreen);
			dispose();
		});

		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(e -> {
			new AddDigitalVideoDiscToStoreScreen(store, parentScreen);
			dispose();
		});

		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);

		menu.add(smUpdateStore);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}

	// ------------------ Header ----------------------
	protected JPanel createHeader(String titleText) {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		JLabel title = new JLabel(titleText);
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 40));
		title.setForeground(Color.BLUE);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		return header;
	}

	// ------------------ Content area to be overridden ----------------------
	protected abstract JPanel createCenter();
}

package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame {
	private Store store;

	public StoreManagerScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		Store store = new Store();

		// DVD
		store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers"));
		store.addMedia(new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 124, "George Lucas"));
		store.addMedia(new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, 90, "John Musker"));

		// CD
		CompactDisc cd1 = new CompactDisc(4, "Hybrid Theory", "Rock", 14.99f, 60, "Linkin Park", "afd");
		cd1.addTrack(new Track("In the End", 3));
		cd1.addTrack(new Track("Crawling", 3));
		store.addMedia(cd1);

		CompactDisc cd2 = new CompactDisc(5, "Thriller", "Pop", 16.50f, 45, "Michael Jackson", "cde");
		cd2.addTrack(new Track("Beat It", 4));
		cd2.addTrack(new Track("Billie Jean", 5));
		store.addMedia(cd2);

		// Book
		Book book1 = new Book(6, "Effective Java", "Programming", 45.00f);
		book1.addAuthor("Joshua Bloch");
		store.addMedia(book1);

		Book book2 = new Book(7, "Clean Code", "Programming", 39.99f);
		book2.addAuthor("Robert C. Martin");
		store.addMedia(book2);

		Book book3 = new Book(8, "1984", "Fiction", 12.99f);
		book3.addAuthor("George Orwell");
		store.addMedia(book3);

		Book book4 = new Book(9, "ABCDS", "gfda", 12.99f);
		book3.addAuthor("George Orwell");
		store.addMedia(book4);
		new StoreManagerScreen(store);
	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenuItem viewStore = new JMenuItem("View store");
		viewStore.addActionListener(e -> {
			new StoreManagerScreen(store);
			dispose();
		});
		menu.add(viewStore);

		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(e -> {
			this.setVisible(false);
			new AddBookToStoreScreen(store, this);
		});
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(e -> {
			this.setVisible(false);
			new AddCompactDiscToStoreScreen(store, this);
		});

		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(e -> {
			this.setVisible(false);
			new AddDigitalVideoDiscToStoreScreen(store, this);
		});
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);
		menu.add(smUpdateStore);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		return header;
	}

	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		ArrayList<Media> mediaInStore = (ArrayList<Media>) store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
	}

	public class MediaStore extends JPanel {
		private Media media;

		public MediaStore(Media media) {
			this.media = media;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
			title.setAlignmentX(CENTER_ALIGNMENT);
			JLabel cost = new JLabel("" + media.getCost() + " $");
			cost.setAlignmentX(CENTER_ALIGNMENT);
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			if (media instanceof Playable) {
				JButton playButton = new JButton("Play");
				playButton.addActionListener(e -> {
					JDialog dialog = new JDialog();
					dialog.setTitle("Playing");
					dialog.setSize(300, 100);
					JLabel playing = new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER);
					dialog.add(playing);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				});
				container.add(playButton);
			}
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}

}

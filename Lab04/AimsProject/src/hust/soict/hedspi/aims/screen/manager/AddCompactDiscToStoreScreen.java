package hust.soict.hedspi.aims.screen.manager;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

	public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen parentScreen) {
		super(store, "Add CD", parentScreen);
	}

	@Override
	protected JPanel createCenter() {
		JPanel center = new JPanel(new GridLayout(7, 2, 5, 5));
		JTextField titleField = new JTextField();
		JTextField categoryField = new JTextField();
		JTextField costField = new JTextField();
		JTextField directorField = new JTextField();
		JTextField artistField = new JTextField();
		JTextField tracksField = new JTextField(); // Format: name1-duration1,name2-duration2,...

		center.add(new JLabel("Title:"));
		center.add(titleField);
		center.add(new JLabel("Category:"));
		center.add(categoryField);
		center.add(new JLabel("Cost:"));
		center.add(costField);
		center.add(new JLabel("Director:"));
		center.add(directorField);
		center.add(new JLabel("Artist:"));
		center.add(artistField);
		center.add(new JLabel("Tracks (name-duration,...):"));
		center.add(tracksField);

		center.add(new JLabel());
		JButton addButton = new JButton("Add CD");
		addButton.addActionListener(e -> {
			String title = titleField.getText();
			String category = categoryField.getText();
			float cost = Float.parseFloat(costField.getText());
			String director = directorField.getText();
			String artist = artistField.getText();
			String trackInput = tracksField.getText();

			CompactDisc cd = new CompactDisc(store.getItemsInStore().size() + 1, title, category, cost, 0, director,
					artist);

			String[] trackEntries = trackInput.split(",");
			for (String entry : trackEntries) {
				String[] parts = entry.split("-");
				if (parts.length == 2) {
					String trackTitle = parts[0].trim();
					int trackLength = Integer.parseInt(parts[1].trim());
					cd.addTrack(new Track(trackTitle, trackLength));
				}
			}

			store.addMedia(cd);
			JOptionPane.showMessageDialog(this, "CD added to store!");
		});
		center.add(addButton);
		return center;
	}
}

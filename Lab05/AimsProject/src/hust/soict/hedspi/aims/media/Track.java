package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import javafx.scene.control.Alert;

public class Track implements Playable {
	private String title;
	private int length;

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Playing");
			alert.setHeaderText("Now playing: " + this.title);
			alert.setContentText("Length: " + this.length + " minutes");
			alert.showAndWait();
		} else {
			System.err.println("ERROR: Track length is non-positive!");
			throw new PlayerException("Error: Track length is not non-positive!");
		}
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Track track = (Track) o;
		return this.length == track.length && this.title.equals(track.title);
	}
}

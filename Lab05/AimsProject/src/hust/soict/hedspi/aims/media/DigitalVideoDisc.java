package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import javafx.scene.control.Alert;

public class DigitalVideoDisc extends Disc implements Playable {
	private int length;
	private String director;

	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
	}

	public String toString() {
		return "DVD - " + this.id + " - " + this.title + " - " + this.category + " - " + this.director + " - "
				+ this.length + " - " + this.cost + " $";
	}

	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Playing");
			alert.setHeaderText("Now playing: " + getTitle());
			alert.setContentText("Length: " + getLength() + " minutes");
			alert.showAndWait();
		} else {
			System.err.println("ERROR: DVD length is non-positive!");
			throw new PlayerException("Error: DVD length is not non-positive!");
		}
	}
}
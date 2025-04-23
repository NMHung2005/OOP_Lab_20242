package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}

	public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
		super(id, title, category, cost, length, director);
		this.artist = artist;
		this.tracks = new ArrayList<>();
	}

	public void addTrack(Track track1) {
		if (!tracks.contains(track1)) {
			tracks.add(track1);
		} else {
			System.out.println("Track da ton tai");
		}
	}

	public void removeTrack(Track track1) {
		if (tracks.contains(track1)) {
			tracks.remove(track1);
		} else {
			System.out.println("Track khong ton tai");
		}
	}

	public int getLength() {
		int total = 0;
		for (Track t : tracks) {
			total += t.getLength();
		}
		return total;
	}

	@Override
	public void play() {
		System.out.println("Playing CD: " + title + " by " + artist);
		for (Track t : tracks) {
			t.play();
		}
	}
}

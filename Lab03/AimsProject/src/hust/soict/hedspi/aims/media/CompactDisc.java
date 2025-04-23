package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}

	public CompactDisc(String artist, List<Track> tracks) {
		super();
		this.artist = artist;
		this.tracks = tracks;
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
}

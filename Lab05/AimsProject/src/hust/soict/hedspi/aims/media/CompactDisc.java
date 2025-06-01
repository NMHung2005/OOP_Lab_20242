package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}

	public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
		super(id, title, category, cost, length, director);
		this.artist = artist;
	}

	public void addTrack(Track track1) {
		if (!tracks.equals(track1)) {
			tracks.add(track1);
		} else {
			System.out.println("Track da ton tai");
		}
	}

	public void removeTrack(Track track1) {
		if (tracks.remove(track1)) {
			System.out.println("Remove track thanh cong");
		}

	}

	public int getLength() {
		int total = 0;
		for (Track t : tracks) {
			total += t.getLength();
		}
		return total;
	}

	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			// Phát tất cả track trong CD
			java.util.Iterator<Track> iter = tracks.iterator();
			while (iter.hasNext()) {
				Track nextTrack = iter.next();
				try {
					nextTrack.play();
				} catch (PlayerException e) {
					System.err.println("ERROR: Cannot play track - " + nextTrack.getTitle());
					throw e; // Ném lại ngoại lệ để báo lỗi ở cấp cao hơn
				}
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}

}

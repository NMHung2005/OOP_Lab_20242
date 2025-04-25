package hust.soict.hedspi.aims.media;

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
	public void play() {
		System.out.println("Playing Track: " + this.title);
		System.out.println("Track length: " + this.length);
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

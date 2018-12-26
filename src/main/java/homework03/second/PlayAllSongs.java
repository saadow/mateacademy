package homework03.second;

public interface PlayAllSongs {
	String[] playlist = { "first song", "second song", "last song" };

	default void playAllSongs() {
		for (String song : playlist) {
			System.out.println("Playing: " + song);
		}
	}
}

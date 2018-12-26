package homework03.first;

public interface PlayAllSongs extends PlaySong {
	String[] playlist = { "first song", "second song", "last song" };

	default void playAllSongs() {
		for (String song : playlist) {
			System.out.println("Playing: " + song);
		}
	}
	@Override
	public default void playSong() {
		System.out.println(playlist[0]);
	}
}

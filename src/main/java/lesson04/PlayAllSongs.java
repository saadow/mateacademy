package lesson04;

public interface PlayAllSongs extends Playsong {
	static String[] playlist = {"firstSong", "secondSong", "lastsong"};
	public void playAllSongs();
}

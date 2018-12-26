package homework03.first;

public class Player04 extends PlaySongsClass implements PlayAllSongs {

	public Player04(int price) {
		super(price);
	}
	@Override
	public void playSong() {
		System.out.println("Playing: " + playlist[playlist.length-1]);
	}
}

package homework03.second;

public class Player03 extends PlaySongClass implements PlayAllSongs {

	public Player03(int price) {
		super(price);
	}

	@Override
	public void playSong() {
		System.out.println("Playing: " + playlist[0]);
	}

}

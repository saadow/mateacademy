package homework03.second;

public class Player04 extends PlaySongClass implements PlayAllSongs{

	public Player04(int price) {
		super(price);
	}
	
	@Override
	public void playSong() {
		System.out.println("Playing: " + playlist[playlist.length-1]);
	}

}

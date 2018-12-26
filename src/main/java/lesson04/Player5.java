package lesson04;

public class Player5 extends PlaySongAbst implements PlayAllSongs{

	public Player5(int price) {
		super(price);
	}

	@Override
	public void playSong() {
		System.out.println(Player5.playlist[0]);
	}

	@Override
	public void playAllSongs() {
		for (int i=playlist.length; i >= 0; i--) {
			System.out.println(playlist[i]);
		}
	}

}

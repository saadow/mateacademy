package lesson04;

public class Player4 extends PlaySongAbst implements PlayAllSongs{
	
	public Player4(int price) {
		super(price);
	}

	@Override
	public void playSong() {
		System.out.println(Player4.playlist[-1]);
	}

	@Override
	public void playAllSongs() {
		for (int i=0; i <= playlist.length; i++) {
			System.out.println(playlist[i]);
		}
	}
}

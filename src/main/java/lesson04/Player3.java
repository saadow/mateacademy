package lesson04;

public class Player3 extends PlaySongAbst implements PlayAllSongs {

	public Player3(int price) {
		super(price);
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public void playSong() {
		System.out.println(Player3.playlist[0]);
	}

	@Override
	public void playAllSongs() {
		for (int i=0; i <= playlist.length; i++) {
			System.out.println(playlist[i]);
		}
	}

}

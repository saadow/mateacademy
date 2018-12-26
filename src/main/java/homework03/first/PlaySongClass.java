package homework03.first;

public abstract class PlaySongClass implements PlaySong {
	final int price;

	public PlaySongClass(int price) {
		this.price = price;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public void playSong() {
		System.out.println("Playing: " + song);
	}

}

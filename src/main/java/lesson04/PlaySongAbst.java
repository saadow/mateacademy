package lesson04;

public abstract class PlaySongAbst implements Playsong{
	final int price;
	public PlaySongAbst(int price) {
		this.price = price;
	}
	
	@Override
	public int getPrice() {
		return price;
	}
}

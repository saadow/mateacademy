package lesson04;

public class Player1 extends PlaySongAbst implements Playsong{
	
	public Player1(int price) {
		super(price);
	}

	@Override
	public int getPrice() {
		return price;
	}
	
	@Override
	public void playSong() {
		System.out.println(Player1.song);
	}
	
}

package lesson04;

public class Player2 extends PlaySongAbst implements Playsong{

	public Player2(int price) {
		super(price);
	}

	@Override
	public int getPrice() {
		return price;
	}
	
	@Override
	public void playSong() {
		System.out.println("error");
	}

}

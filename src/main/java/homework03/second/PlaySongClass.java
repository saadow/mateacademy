package homework03.second;

public abstract class PlaySongClass {
	String song = "One song";
	final int price;
	
	public PlaySongClass(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void playSong() {
		System.out.println("Playing: " + song);
	}
}

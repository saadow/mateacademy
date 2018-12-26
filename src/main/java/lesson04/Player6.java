package lesson04;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player6 extends PlaySongAbst implements PlayAllSongs{

	public Player6(int price) {
		super(price);
	}

	@Override
	public void playSong() {
		System.out.println(Player6.playlist[0]);
	}

	@Override
	public void playAllSongs() {
		for (int i=0; i <= playlist.length; i++) {
			System.out.println(playlist[i]);
		}
	}
	public String[] shuffle() {
		List <String> list = Arrays.asList(Player6.playlist);
		Collections.shuffle(list);
		return list.toArray(new String[list.size()]);
	}
}

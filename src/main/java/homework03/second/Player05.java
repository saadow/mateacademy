package homework03.second;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player05 extends PlaySongClass implements PlayAllSongs {

	public Player05(int price) {
		super(price);
	}

	@Override
	public void playSong() {
		System.out.println("Playing: " + playlist[0]);
	}

	@Override
	public void playAllSongs() {
		List <String> list = Arrays.asList(playlist);
		Collections.reverse(list);
		String[] newPlaylist = new String[list.size()];
		newPlaylist = list.toArray(newPlaylist);
		for (String song : newPlaylist) {
			System.out.println("Playing: " + song);
		}
	}

}

package homework03.second;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player06 extends PlaySongClass implements PlayAllSongs {

	public Player06(int price) {
		super(price);
	}

	@Override
	public void playSong() {
		System.out.println("Playing: " + playlist[0]);
	}

	public void shuffle() {
		List<String> list = Arrays.asList(playlist);
		Collections.shuffle(list);
		String[] newPlaylist = new String[list.size()];
		newPlaylist = list.toArray(newPlaylist);
		for (int i = 0; i<playlist.length; i++) {
			playlist[i] = newPlaylist[i];
		}
	}
}

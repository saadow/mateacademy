package homework03.second;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Player01 pl01 = new Player01(100);
		Player02 pl02 = new Player02(200);
		Player03 pl03 = new Player03(300);
		Player04 pl04 = new Player04(400);
		Player05 pl05 = new Player05(500);
		Player06 pl06 = new Player06(600);
		
		List<PlaySongClass> list1 = new ArrayList<PlaySongClass>();
		list1.add(pl01);
		list1.add(pl02);
		list1.add(pl03);
		list1.add(pl04);
		list1.add(pl05);
		list1.add(pl06);
		List<PlayAllSongs> list2 = new ArrayList<PlayAllSongs>();
		list2.add(pl03);
		list2.add(pl04);
		list2.add(pl05);
		list2.add(pl06);
		for (PlaySongClass psc : list1) {
			System.out.println(psc.getClass().getName());
			System.out.println(psc.price);
			psc.playSong();
			if (psc instanceof PlayAllSongs) {
				((PlayAllSongs) psc).playAllSongs();
			}
			if (psc instanceof Player06) {
				((Player06) psc).shuffle();
				System.out.println("Player06 after shuffle: ");
				((Player06) psc).playAllSongs();
			}
		}
	}

}

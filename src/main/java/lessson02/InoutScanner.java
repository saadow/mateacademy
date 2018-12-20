package lessson02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class InoutScanner 
{ 
  public static void main(String[] args) 
  { 
    // pass the path to the file as a parameter 
    File inFile = new File("src/resources/input.txt"); 
    Scanner sc;
	try {
		sc = new Scanner(inFile);
		while (sc.hasNextLine()) {
			String line = sc.nextLine().toUpperCase();
			line = line.replace("J", "!!!");
			System.out.println(line); 
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    
  } 
} 
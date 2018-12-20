package lessson02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Nio 
{ 
  public static void main(String[] args) 
  {
	 Path inPath = Paths.get("/home/vadim/git/Test1/src/resources/input.txt");
	 Path outPath = Paths.get("/home/vadim/git/Test1/src/resources/output.txt");
	 try {
		  List <String> list = Files.lines(inPath).map(str->str.toUpperCase().replace("J", "!!!!!!!!!"))
				  .collect(Collectors.toList());
		  Files.write(outPath, list);
	 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
	}
  } 
} 

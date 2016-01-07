import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class StringPermutations {
	
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				char[] characters = line.toCharArray();
				Arrays.sort(characters);
			}
		}
		scanner.close();
	}
}

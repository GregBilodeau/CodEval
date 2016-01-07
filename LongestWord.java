import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class LongestWord {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String longest = "";
				String words[] = line.split("\\s");
				for(int i = 0; i < words.length; i++){
					if(words[i].length() > longest.length()){
						longest = words[i];
					}
				}
				System.out.println(longest);
			}
		}
		
		fileScanner.close();

	}

}

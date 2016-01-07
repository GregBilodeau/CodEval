import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class BeautifulStrings {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				TreeMap<Character, Integer> characterMap = new TreeMap<Character, Integer>();
				char characters[] = line.toLowerCase().toCharArray();
				for(char c : characters){
					if(characterMap.containsKey(c)){
						characterMap.put(c, characterMap.get(c) + 1);
					}else{
						characterMap.put(c, 1);
					}
				}
				System.out.print(characterMap.get('a'));
			}
			System.out.println();
		}
		
		fileScanner.close();

	}

}

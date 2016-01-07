import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FindASquare {
	
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				
				String elements[] = line.split(",\\s");
				int xCoords[] = new int[4];
				int yCoords[] = new int[4];
				for(int i = 0; i < elements.length; i++){
					String element = elements[i];
					xCoords[i] = Integer.parseInt(element.substring(1, 2));
					yCoords[i] = Integer.parseInt(element.substring(3, 4));
				}
				if(hasDoubles(xCoords) && hasDoubles(yCoords)){
					System.out.println("true");
				}else{
					System.out.println("false");
				}
			}
		}
		fileScanner.close();
	}
	
	public static boolean hasDoubles(int array[]){
		int matches = 0;
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length; j++){
				if(i != j){
					if(array[i] == array[j]){
						matches++;
					}
				}
			}
		}
		if(matches == 4){
			return true;
		}else{
			return false;
		}
	}

}

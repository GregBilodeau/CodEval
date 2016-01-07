import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReverseGroups {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(";");
				String arrayStr = elements[0];
				String[] numArray = arrayStr.split(",");
				int window = Integer.parseInt(elements[1]) - 1;
				int numWins;
				if(numArray.length % window == 0){
					numWins = (numArray.length / window) - 2;
				}else{
					numWins = (numArray.length / window);
				}
				System.out.println(numWins);
				for(int j = 0; j < numWins; j++){
					for(int i = window; i >= 0; i--){
						int index = i * numWins;
						if(index < numArray.length){
							System.out.println(numArray[index]);
						}
					}
				}
			}
			System.out.println();
		}
		fileScanner.close();
	}
}

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
				int window = Integer.parseInt(elements[1]);
				int numWins;
				if(numArray.length % window == 0){
					numWins = (numArray.length / window) - 2;
				}else{
					numWins = (numArray.length / window);
				}
				StringBuilder sb = new StringBuilder();
				for(int i = 1; i <= numWins; i++){
					for(int j = 1; j <= window; j++){
						int index = (i * window) - j;
						if(index < numArray.length){
							sb.append(numArray[index] + " ");
						}
					}
				}
				for(int k = numWins * window; k < numArray.length; k++){
					sb.append(numArray[k] + " ");
				}
				System.out.println(sb.toString().trim());
			}
		}
		fileScanner.close();
	}
}

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class SwapCase {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				for(int i = 0; i < line.length(); i++){
					if(Character.isUpperCase(line.charAt(i))){
						System.out.print(Character.toLowerCase(line.charAt(i)));
					}else{
						System.out.print(Character.toUpperCase(line.charAt(i)));
					}
				}
			}
			System.out.println();
		}
		
		fileScanner.close();

	}

}

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class HiddenDigits {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				int found = 0;
				for(int i = 0; i < line.length(); i++){
					int asciiVal = (int)line.charAt(i);
					if((asciiVal >= 48 && asciiVal <= 57)){
						System.out.print(line.charAt(i));
						found++;
					}else if( (asciiVal >= 97 && asciiVal <= 106)){
						System.out.print(asciiVal - 97);
						found++;
					}
				}
				if(found == 0){
					System.out.println("NONE");
				}else{
					System.out.println();
				}
			}
		}
		fileScanner.close();

	}

}

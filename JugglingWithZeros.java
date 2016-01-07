import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JugglingWithZeros {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String zeros[] = line.split("\\s");
				String binaryString = "";
				for(int i = 0; i < zeros.length; i++){
					if(i == 0 || i % 2 == 0){
						// flag
						String flag = zeros[i];
						if(flag.equalsIgnoreCase("0")){
							// append to string
							binaryString += zeros[i+1];
						}else{
							int numOnes = zeros[i+1].length();
							for(int j = 0; j < numOnes; j++){
								binaryString += "1";
							}
						}
					}
				}
				System.out.print(Long.parseLong(binaryString, 2));
			}
			System.out.println();
		}
		
		fileScanner.close();

	}
}

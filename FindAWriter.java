import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class FindAWriter {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String codeAndKey[] = line.split("\\|");
				String code = codeAndKey[0].trim();
				String key = codeAndKey[1].trim();
				String keyNums[] = key.split("\\s");
				
				for(int i = 0; i < keyNums.length; i++){
					int keyCode = Integer.parseInt(keyNums[i]);
					System.out.print(code.charAt(keyCode - 1));
				}
				System.out.println();
			}
		}
		fileScanner.close();
	}

}

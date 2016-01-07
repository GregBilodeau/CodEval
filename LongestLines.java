import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LongestLines {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		int numLines = 0;
		ArrayList<String> lines = new ArrayList<String>();
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(numLines <= 0){
				numLines = Integer.parseInt(line);
			}else{
				lines.add(line);
			}
		}
		
		for(int i = 0; i < lines.size(); i++){
			
		}
		
		fileScanner.close();

	}

}

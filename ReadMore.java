import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadMore {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String formattedLine = line.trim();
				if(formattedLine.length() <= 55){
					System.out.println(formattedLine);
				}else{
					formattedLine = formattedLine.substring(0, 39);
					formattedLine = formattedLine.trim();
					System.out.println(formattedLine + "... <Read More>");
				}
			}
		}
		
		fileScanner.close();

	}

}

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NiceAngles {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				double angle = Double.parseDouble(line);
				System.out.println(angle);
				
				int fullAngle = (int)angle;
				System.out.println(fullAngle);
				
				int minutes = (60 * (int)((angle * 100) - (fullAngle * 100))) / 100;
				System.out.println(minutes);
				
				int seconds = (60 * ((int)(angle * 10000) % 100)) / 100;
				System.out.println(seconds);
			}
			System.out.println();
		}
		
		fileScanner.close();

	}

}

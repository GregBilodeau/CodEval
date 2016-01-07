import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MthToLastElement {
	
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				
				String elements[] = line.split("\\s");
				int mth = Integer.parseInt(elements[elements.length - 1]);
				mth = elements.length - mth - 1;
				if(mth >= 0){
					System.out.println(elements[mth]);
				}
				
			}
		}
		fileScanner.close();
	}

}

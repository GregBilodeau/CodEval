import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MultiplyLists {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String outputLine = "";
				String lists[] = line.split("\\|");
				lists[0] = lists[0].trim();
				lists[1] = lists[1].trim();
				String list1[] = lists[0].split("\\s");
				String list2[] = lists[1].split("\\s");
				
				for(int i = 0; i < list1.length; i++){
					int num1 = Integer.parseInt(list1[i]);
					int num2 = Integer.parseInt(list2[i]);
					outputLine += (num1 * num2) + " ";
				}
				outputLine = outputLine.trim();
				System.out.print(outputLine);
			}
			System.out.println();
		}
		
		fileScanner.close();

	}

}

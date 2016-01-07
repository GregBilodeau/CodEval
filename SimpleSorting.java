import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SimpleSorting {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String lineElements[] = line.split("\\s");
				ArrayList<Float> numbers = new ArrayList<Float>();
				for(String number : lineElements){
					float num = Float.parseFloat(number);
					numbers.add(num);
				}
				Collections.sort(numbers);
				for(float num : numbers){
					System.out.print(String.format("%.3f ", num));
				}
			}
			System.out.println();
		}
		
		fileScanner.close();

	}

}

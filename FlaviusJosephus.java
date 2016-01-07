import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlaviusJosephus {
	
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(",");
				int number = Integer.parseInt(elements[0]);
				int period = Integer.parseInt(elements[1]);
				ArrayList<Integer> people = new ArrayList<Integer>();
				for(int i = 0; i < number; i++){
					people.add(i);
				}
				6
			}
		}
		scanner.close();
	}

}

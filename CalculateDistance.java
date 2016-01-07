import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CalculateDistance {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String coords[] = line.split("\\)\\s");
				String coord1 = coords[0];
				String coord2 = coords[1];
				coord1 = coord1.substring(1, coord1.length());
				coord2 = coord2.substring(1, coord2.length() - 1);
				
				String coord1Values[] = coord1.split(",");
				String coord2Values[] = coord2.split(",");
				
				int x1, x2, y1, y2;
				x1 = Integer.parseInt(coord1Values[0].trim());
				y1 = Integer.parseInt(coord1Values[1].trim());
				x2 = Integer.parseInt(coord2Values[0].trim());
				y2 = Integer.parseInt(coord2Values[1].trim());
				
				System.out.println(findDistance(x1, x2, y1, y2));
			}
		}
		fileScanner.close();
	}
	
	public static int findDistance(int x1, int x2, int y1, int y2){
		int distance = 0;
		
		int base = Math.abs(x1 - x2);
		int height = Math.abs(y1 - y2);
		distance = (int)Math.sqrt(Math.pow(base, 2.0) + Math.pow(height, 2.0));
		
		return distance;
	}

}

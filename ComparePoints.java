import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ComparePoints {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);
		
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String coords[] = line.split("\\s");
				int origX = Integer.parseInt(coords[0]);
				int origY = Integer.parseInt(coords[1]);
				int destX = Integer.parseInt(coords[2]);
				int destY = Integer.parseInt(coords[3]);
				
				int diffX = destX - origX;
				int diffY = destY - origY;
				
				String longitude = "";
				String lattitude = "";
				
				if(diffY > 0){
					longitude = "N";
				}else if(diffY < 0){
					longitude = "S";
				}
				
				if(diffX > 0){
					lattitude = "E";
				}else if(diffX < 0){
					lattitude = "W";
				}
				
				String direction = longitude + lattitude;
				
				if(direction.equalsIgnoreCase("")){
					System.out.println("here");
				}else{
					System.out.println(direction);
				}
				
			}
		}

	}

}

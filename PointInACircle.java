import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Having coordinates of the center of a circle, it's radius and coordinates of a point you need to define whether this point is located inside of this circle.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Input example is the following

Center: (2.12, -3.48); Radius: 17.22; Point: (16.21, -5)
Center: (5.05, -11); Radius: 21.2; Point: (-31, -45)
Center: (-9.86, 1.95); Radius: 47.28; Point: (6.03, -6.42)
All numbers in input are between -100 and 100

OUTPUT SAMPLE:

Print results in the following way.

true
false
true*/

public class PointInACircle {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
				
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(";");
				
				String circleCenter = elements[0].substring(9, elements[0].length() - 1);
				String circleCoords[] = circleCenter.split(",\\s");
				float cirCoords[] = new float[2];
				cirCoords[0] = Float.parseFloat(circleCoords[0]);
				cirCoords[1] = Float.parseFloat(circleCoords[1]);
				
				String radius = elements[1].substring(8);
				float rad = Float.parseFloat(radius);
								
				String point = elements[2].substring(9, elements[2].length() - 1);
				String pointCoordPair[] = point.split(",\\s");
				float pointCoords[] = new float[2];
				pointCoords[0] = Float.parseFloat(pointCoordPair[0]);
				pointCoords[1] = Float.parseFloat(pointCoordPair[1]);
				
				if( Math.pow( (pointCoords[0] - cirCoords[0]), 2) + Math.pow( (pointCoords[1] - cirCoords[1]), 2) <= Math.pow(rad, 2)){
					System.out.println("true");
				}else{
					System.out.println("false");
				}
			}
		}		
		fileScanner.close();
	}

}
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * CHALLENGE DESCRIPTION:

You've decided to make a road trip across the country in a straight line. You have chosen the direction you'd like to travel and made a list of cities in that direction that have gas stations to stop at and fill up your tank. To make sure that this route is viable, you need to know the distances between the adjacent cities in order to be able to travel this distance on a single tank of gasoline, (No one likes running out of gas.) but you only know distances to each city from your starting point.

INPUT SAMPLE:

The first argument is a path to a filename. Each line in the file contains the list of cities and distances to them, comma delimited, from the starting point of your trip. You start your trip at point 0. The cities with their distances are separated by semicolon. E.g.

Rkbs,5453; Wdqiz,1245; Rwds,3890; Ujma,5589; Tbzmo,1303;
Vgdfz,70; Mgknxpi,3958; Nsptghk,2626; Wuzp,2559; Jcdwi,3761;
Yvnzjwk,5363; Pkabj,5999; Xznvb,3584; Jfksvx,1240; Inwm,5720;
Ramytdb,2683; Voclqmb,5236;
OUTPUT SAMPLE:

Print out the distance from the starting point to the nearest city, and the distances between two nearest cities separated by comma, in order they appear on the route. E.g.

1245,58,2587,1563,136
70,2489,67,1135,197
1240,2344,1779,357,279
2683,2553
Constrains: 
Cities are unique, and represented by randomly generated string containing latin characters [A-Z][a-z]. 
The route length is an integer in range [10000, 30000] 
The number of cities is in range [500, 600]*/

public class RoadTrip {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
				
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				TreeMap<String, Integer> distances = new TreeMap<String, Integer>();
				line = line.substring(0, line.length() - 1);
				String cityDistance[] = line.split("; ");
				for(String pair : cityDistance){
					int commaIndex = pair.indexOf(",");
					String cityName = pair.substring(0, commaIndex);
					int distance = Integer.parseInt(pair.substring(commaIndex + 1));
					distances.put(cityName, distance);
				}
				List<Integer> distanceList = new ArrayList<Integer>();
				for(Map.Entry<String, Integer> entry : distances.entrySet()){
					distanceList.add(entry.getValue());
				}
				Collections.sort(distanceList);
				int totalDistanceTraveled = 0;
				StringBuilder sb = new StringBuilder();
				for(int distance : distanceList){
					int distanceThisStep = distance - totalDistanceTraveled;
					totalDistanceTraveled = distance;
					sb.append(distanceThisStep + ",");
				}
				System.out.println(sb.substring(0, sb.length()-1).toString());
			}
		}
		
		fileScanner.close();

	}

}

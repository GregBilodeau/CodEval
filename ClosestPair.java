import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Credits: Programming Challenges by Steven S. Skiena and Miguel A. Revilla 

You will be given the x/y co-ordinates of several locations. You will be laying out 1 cable between two of these locations. In order to minimise the cost, your task is to find the shortest distance between a pair of locations, so that pair can be chosen for the cable installation.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. The input file contains several sets of input. Each set of input starts with an integer N (0<=N<=10000), which denotes the number of points in this set. The next N line contains the coordinates of N two-dimensional points. The first of the two numbers denotes the X-coordinate and the latter denotes the Y-coordinate. The input is terminated by a set whose N=0. This set should not be processed. The value of the coordinates will be less than 40000 and non-negative. eg.

1
2
3
4
5
6
7
5
0 2
6 67
43 71
39 107
189 140
0
OUTPUT SAMPLE:

For each set of input produce a single line of output containing a floating point number (with four digits after the decimal point) which denotes the distance between the closest two points. If there is no such two points in the input whose distance is less than 10000, print the line INFINITY. eg.

1
36.2215
*/

public class ClosestPair {

	public static ArrayList<NodePoint> nodes = new ArrayList<NodePoint>();
	
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			String[] numbers = line.split("\\s");
			if(numbers.length == 1){
				// one value; numPoints or 0?
				int value = Integer.parseInt(line);
				if(value == 0){
					// exit the program
					findMinDistance();
					break;
				}else{
					// end the program for this input
					if(!nodes.isEmpty()){
						findMinDistance();
						// setup new data set
						nodes.clear();
					}
				}
			}else{
				int x = Integer.parseInt(numbers[0]);
				int y = Integer.parseInt(numbers[1]);
				NodePoint newNode = new NodePoint(x, y);
				nodes.add(newNode);
			}
		}
		scanner.close();
	}
	
	public static void findMinDistance(){
		double minDistance = Double.MAX_VALUE;
		for(NodePoint node : nodes){
			for(NodePoint otherNode : nodes){
				if(node != otherNode){
					double distance = node.getDistance(otherNode);
					if(distance < minDistance){
						minDistance = distance;
					}
				}
			}
		}
		
		if(minDistance <= 10000){
			System.out.println(String.format("%.4f",minDistance));
		}else{
			System.out.println("INFINITY");
		}
	}
}

class NodePoint{
	
	private int myX, myY;
	
	public NodePoint(int x, int y) {
		myX = x;
		myY = y;
	}
	
	public double getDistance(NodePoint other){
		int x1, x2, y1, y2;
		x1 = myX;
		y1 = myY;
		x2 = other.getXCoord();
		y2 = other.getYCoord();
		
		int base = Math.abs(x1 - x2);
		int height = Math.abs(y1 - y2);
		double myDistance = Math.sqrt(Math.pow(base, 2.0) + Math.pow(height, 2.0));
		
		return myDistance;
	}
	
	public int getXCoord(){
		return myX;
	}
	
	public int getYCoord(){
		return myY;
	}
	
}

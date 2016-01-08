import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Write a program to determine the largest sum of contiguous integers in a list.

INPUT SAMPLE:

The first argument is a path to a filename containing a comma-separated list of integers, one per line.

For example:

1
2
-10,2,3,-2,0,5,-15
2,3,-2,-1,10
OUTPUT SAMPLE:

Print to stdout the largest sum. In other words, of all the possible contiguous subarrays for a given array, find the one with the largest sum, and print that sum.

For example:

1
2
8
12
*/

public class SumOfIntegers {
	
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		Scanner fileScanner = new Scanner(file);
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(",");
				if(elements.length == 1){
					System.out.println(elements[0]);
				}else{
					ArrayList<Integer> numbers = new ArrayList<Integer>();
					for(String number : elements){
						int intVal = Integer.parseInt(number);
						numbers.add(intVal);
					}
					int maxVal = Integer.MIN_VALUE;
					for(int i = 0; i < numbers.size(); i++){
						int firstDigit = numbers.get(i);
						if(firstDigit > maxVal){
							maxVal = firstDigit;
						}
						int tempSum = firstDigit;
						for(int j = i + 1; j < numbers.size(); j++){
							tempSum += numbers.get(j);
							//System.out.print(tempSum + ", ");
							if(tempSum > maxVal){
								maxVal = tempSum;
							}
						}
					}
					System.out.println(maxVal);
				}
			}
		}
		fileScanner.close();
	}

}

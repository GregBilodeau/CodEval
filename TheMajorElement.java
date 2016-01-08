import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * CHALLENGE DESCRIPTION:

The major element in a sequence with the length of L is the element which appears in a sequence more than L/2 times. The challenge is to find that element in a sequence.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line of the file contains a sequence of integers N separated by comma. E.g.

1
2
3
92,19,19,76,19,21,19,85,19,19,19,94,19,19,22,67,83,19,19,54,59,1,19,19
92,11,30,92,1,11,92,38,92,92,43,92,92,51,92,36,97,92,92,92,43,22,84,92
,92
4,79,89,98,48,42,39,79,55,70,21,39,98,16,96,2,10,24,14,47,0,50,95,20,95
,48,50,12,42
OUTPUT SAMPLE:

For each sequence print out the major element or print "None" in case there is no such element. E.g.

1
2
3
19
92
None
Constraints: 
N is in range [0, 100] 
L is in range [10000, 30000] 
The number of test cases <= 40*/

public class TheMajorElement {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String numbers[] = line.split(",");
				int n = numbers.length;
				Map<String, Integer> occurenceMap = new TreeMap<String, Integer>();
				for(String number : numbers){
					if(occurenceMap.containsKey(number)){
						occurenceMap.put(number, occurenceMap.get(number) + 1);
					}else{
						occurenceMap.put(number, 1);
					}
				}
				Map.Entry<String, Integer> maxVal = null;
				for(Map.Entry<String, Integer> entry : occurenceMap.entrySet()){
					if(maxVal == null || entry.getValue().compareTo(maxVal.getValue()) > 0){
						maxVal = entry;
					}
				}
				if(maxVal.getValue() > n/2){
					System.out.println(maxVal.getKey());
				}else{
					System.out.println("None");
				}
				
			}
			
		}
		
		fileScanner.close();

	}

}

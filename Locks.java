import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

There are N unlocked rooms located in a row along the corridor.

A security guard, who starts the beat at the beginning of the corridor, passes by and closes the lock of every second door (2nd, 4th, 6th…). Then he returns to the beginning of the corridor, and passes by again changing the state of every third door (3rd, 6th, 9th…) to the opposite state — if the door is closed, security guard opens it; if the door is open, he closes it.

One iteration consists of two beats (when the security guard closes each second door, and changes the state of each third door to the opposite state). The iteration repeats M-1 times.

During the last iteration, the security guard just changes the state of the last door in a row (closes it, if the door is open or opens it, if the door is closed).

Your task is to determine how many doors have been left unlocked.

INPUT SAMPLE:

Your program accepts a filename as its first argument.

Each line of input contains 2 integers separated by space. The first integer represents number of doors (N), the second — number of iterations (M).

1
2
3 1
100 100
OUTPUT SAMPLE:

For each line of input print out how many doors are left unlocked:

1
2
2
50
*/

public class Locks {
	
	static String[] hallWay;
	
	public static void main(String[] args) throws FileNotFoundException{
		File file = new File(args[0]);
		
		Scanner scanner = new Scanner(file);
		
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String[] elements = line.split("\\s");
				int doors = Integer.parseInt(elements[0]);
				int iterations = Integer.parseInt(elements[1]);
				
				hallWay = new String[doors];
				
				for(int i = 0; i < doors; i++){
					hallWay[i] = "U";
				}
				
				for(int i = 1; i < iterations; i++){
					doPatrol();
				}
				
				int lastIndex = hallWay.length - 1;
				hallWay[lastIndex] = invert(hallWay[lastIndex]);
				
				int unlocked = 0;
				for(String state : hallWay){
					if(state.equalsIgnoreCase("U")){
						unlocked++;
					}
				}
				System.out.println(unlocked);
			}
		}
		
		scanner.close();
		
	}
	
	public static void doPatrol(){
		for(int i = 1; i <= hallWay.length; i++){
			if(i % 2 == 0){
				hallWay[i - 1] = "L";
			}
			if(i % 3 == 0){
				hallWay[i - 1] = invert(hallWay[i - 1]);
			}
		}
	}
	
	public static String invert(String state){
		if(state.equalsIgnoreCase("U")){
			return "L";
		}else{
			return "U";
		}
	}

}

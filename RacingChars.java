import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

You are given a file where each line is a section of a race track with obstructions, gates, and checkpoints. Your task is to find a way to pass this track using the following information:

1. Each section contains either one single gate or one gate with a checkpoint. 
2. You should drive only through gates or checkpoints. 
3. You should drive through a checkpoint rather than a gate. 
4. An obstruction is represented by a number sign "#". 
5. A gate is represented by an underscore "_". 
6. A checkpoint is represented by a letter C.

INPUT SAMPLE:

Your program should accept a path to a filename as its first argument. Each line of the file is a new section of a race track.

1
2
3
4
5
6
7
8
9
10
#########_##
########C_##
#######_####
######_#C###
#######_C###
#######_####
######C#_###
######C_####
#######_####
#######_####
OUTPUT SAMPLE:

Print out the way of passing this race track starting from the first line in the file. Use a pipe "|" for the straight, use a slash "/" for the left turn, and use a backslash "\" for the right turn.

1
2
3
4
5
6
7
8
9
10
#########|##
########/_##
#######/####
######_#\###
#######_|###
#######/####
######/#_###
######|_####
#######\####
#######|####
CONSTRAINTS:

The number of lines in a file is 50.
The width of a section is 12 characters.*/

public class RacingChars {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		ArrayList<String> sections = new ArrayList<String>();
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				sections.add(line);
			}	
		}
		fileScanner.close();
		
		StringBuilder sb = new StringBuilder();
		int myPos = 0;
		int target = 0;
		
		String startingLine = sections.get(sections.size() - 1);
		myPos = startingLine.indexOf('_');
		
		for(int i = sections.size() - 1; i >= 0; i--){
			String currentSection = sections.get(i);
			String bestMove = "";
			if(i == 0){
				bestMove = currentSection.replace('_', '|');
				sb.insert(0, bestMove + "\n");
			}else{
				String nextSec = sections.get(i - 1);
				int cIndex = nextSec.indexOf('C');
				int gIndex = nextSec.indexOf('_');
				if(cIndex != -1){
					target = cIndex;
				}else if(gIndex != -1){
					target = gIndex;
				}
				int dir = myPos - target;
				String leftHand = "";
				String rightHand = "";
				leftHand = currentSection.substring(0, myPos);
				rightHand = currentSection.substring(myPos + 1);
				if(dir == -1){
					// go right
					bestMove = leftHand + "/" + rightHand;
				}else if(dir == 1){
					// go left
					bestMove = leftHand + "\\" + rightHand;
				}else{
					// go straight
					bestMove = leftHand + "|" + rightHand;
				}
				
				myPos = target;
				sb.insert(0, bestMove + "\n");
			}
		}
		System.out.println(sb.toString());
	}

}

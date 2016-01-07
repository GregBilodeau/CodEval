import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Flavius Josephus was a famous Jewish historian of the first century, at the time of the destruction of the Second Temple. According to legend, during the Jewish-Roman war he was trapped in a cave with a group of soldiers surrounded by Romans. Preferring death to capture, the Jews decided to form a circle and, proceeding around it, to kill every j'th person remaining until no one was left. Josephus found the safe spot in the circle and thus stayed alive. 
Write a program that returns a list of n people, numbered from 0 to n-1, in the order in which they are executed.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file contains two comma separated positive integers n and m, where n is the number of people and every m'th person will be executed. E.g.

10,3
5,2
OUTPUT SAMPLE:

Print out the list of n people (space delimited) in the order in which they will be executed. E.g.

2 5 8 1 6 0 7 4 9 3
1 3 0 4 2*/

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException{
		File file = new File(args[0]);
		
		Scanner scanner = new Scanner(file);
		
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String[] elements = line.split(",");
				int people = Integer.parseInt(elements[0]);
				int interval = Integer.parseInt(elements[1]) - 1;
				
				LinkedList<Integer> lineUp = new LinkedList<Integer>();
				
				for(int i = 0; i < people; i++){
					lineUp.add(i);
				}
				
				int currIndex = 0;
				while(lineUp.size() > 0){
					int nextIndex = currIndex + interval;
					while(nextIndex >= lineUp.size()){
						nextIndex -= lineUp.size();
					}
					System.out.print(lineUp.get(nextIndex) + " ");
					currIndex = nextIndex;
					lineUp.remove(nextIndex);
					
					if(lineUp.size() == 1){
						System.out.println(lineUp.get(0));
						break;
					}
				}
			}
		}
		
		scanner.close();
		
	}

}

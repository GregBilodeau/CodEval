import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

Credits: This challenge was contributed by Sam McCoy
Given a string S, and a list of strings of positive length, F1,R1,F2,R2,...,FN,RN, proceed to find in order the occurrences (left-to-right) of Fi in S and replace them with Ri. All strings are over alphabet { 0, 1 }. Searching should consider only contiguous pieces of S that have not been subject to replacements on prior iterations. An iteration of the algorithm should not write over any previous replacement by the algorithm.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file is one test case. Each test case will contain a string, then a semicolon and then a list of comma separated strings. E.g.

10011011001;0110,1001,1001,0,10,11
OUTPUT SAMPLE:

For each line of input, print out the string after substitutions have been made.eg.

11100110
For the curious, here are the transitions for the above example: 10011011001 => 10100111001 [replacing 0110 with 1001] => 10100110 [replacing 1001 with 0] => 11100110 [replacing 10 with 11]. So the answer is 11100110*/

public class StringSubstitution {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(";");
				String originalString = elements[0];
				
				List<StringChunk> outputString = new LinkedList<StringChunk>();
				outputString.add(new StringChunk(originalString));
				
				String replacementPairs[] = elements[1].split(",");
				for(int i = 0; i <= replacementPairs.length-2; i+=2){
					
					String findMe = replacementPairs[i];
										
					String replacement = replacementPairs[i+1];
					
					for(int j = 0; j < outputString.size(); j++){
						StringChunk chunk = outputString.get(j);
						if(!chunk.isReplacement()){
							if(chunk.getChunk().contains(findMe)){
								
								String tempChunk = chunk.getChunk();
								
								outputString.remove(chunk);
								
								int replaceStart = tempChunk.indexOf(findMe);
								int replaceEnd = replaceStart + findMe.length();
								
								String preFix = tempChunk.substring(0,replaceStart);
								String postFix = tempChunk.substring(replaceEnd);
								
								StringChunk prefixChunk = new StringChunk(preFix);
								StringChunk replacementChunk = new StringChunk(replacement);
								replacementChunk.setReplacement();
								StringChunk postfixChunk = new StringChunk(postFix);
								
								outputString.add(j, prefixChunk);
								outputString.add(j+1,replacementChunk);
								outputString.add(j+2,postfixChunk);
								
								tempChunk.replace(findMe, replacement);
								chunk.setChunk(tempChunk);
								chunk.setReplacement();
							}
						}
					}
				}
				for(StringChunk chunk : outputString){
					System.out.print(chunk.getChunk());
				}
			}
			System.out.println();
		}
		fileScanner.close();
	}
}

class StringChunk{
	
	private boolean replacement;
	private String chunk;
	
	public StringChunk(String frag){
		chunk = frag;
		replacement = false;
	}
	
	public void setReplacement(){
		replacement = true;
	}
	
	public boolean isReplacement(){
		return replacement;
	}
	
	public void setChunk(String frag){
		chunk = frag;
	}
	
	public String getChunk(){
		return chunk;
	}
}

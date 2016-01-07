import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class PrefixExpressions {
	
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		Scanner fileScanner = new Scanner(file);
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				Stack<String> stack = new Stack<String>();
				String elements[] = line.split("\\s");
				for(int i = 0; i < elements.length; i++){
					String token = elements[i];
					stack.push(token);
				}
			}
		}
		fileScanner.close();
	}

}

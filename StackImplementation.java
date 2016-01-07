import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class StackImplementation {
	
	static LinkedList<Integer> stack = new LinkedList<Integer>();
	static int stackSize;
	
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String tempStack[] = line.split("\\s");
				stackSize = tempStack.length;
				for(String tempInt : tempStack){
					push(Integer.parseInt(tempInt));
				}
				while(stack.size() > 0){
					pop();
				}
			}
			System.out.println();
		}
		fileScanner.close();

		
	}
	
	public static void push(int value){
		stack.add(value);
	}
	
	public static void pop(){
		
	}

}

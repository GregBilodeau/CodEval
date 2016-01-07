import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SetIntersection {
	
	public static void main(String[] args) throws IOException{
		File file = new File((String) args[0]);
		
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			if(line != ""){
				String elements[] = line.split(";");
				String array1[] = elements[0].split(",");
				String array2[] = elements[1].split(",");
				
				int lowerBound1 = Integer.parseInt(array1[0]);
				int upperBound1 = Integer.parseInt(array1[array1.length - 1]);
				
				int lowerBound2 = Integer.parseInt(array2[0]);
				int upperBound2 = Integer.parseInt(array2[array2.length - 1]);
				
				StringBuilder sb = new StringBuilder();
				
				if(lowerBound1 <= lowerBound2){
					int array2index = 0;
					for(int i = 0; i < array1.length; i++){
						String entry = array1[i];
						if(entry.equalsIgnoreCase(array2[array2index])){
							sb.append(entry + ",");
							if(array2index < array2.length - 1){
								array2index++;
							}
						}
					}
				}else{
					int array1index = 0;
					for(int i = 0; i < array2.length; i++){
						String entry = array2[i];
						if(entry.equalsIgnoreCase(array1[array1index])){
							sb.append(entry + ",");
							if(array1index < array1.length - 1){
								array1index++;
							}
						}
					}
				}
				if(sb.length() > 0){
					System.out.println(sb.toString().subSequence(0, sb.length() - 1));
				}else{
					System.out.println();
				}
			}
		}
		scanner.close();
	}
}

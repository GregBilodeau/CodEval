import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SlangFlavor {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		String slang[] = {", yeah!",", this is crazy, I tell ya.",", can U believe this?",", eh?",", aw yea.",", yo.","? No way!",". Awesome!"};
		int slangIndex = 0;
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			ArrayList<String> sentances = new ArrayList<String>();
			if(!line.equalsIgnoreCase("")){
				StringBuilder sb = new StringBuilder();
				int startIndex = 0;
				for(int i = 0; i < line.length(); i++){
					char c = line.charAt(i);
					if(c == 33 || c == 46 || c == 63){
						String sentance = line.substring(startIndex, i + 1);
						sentances.add(sentance);
						startIndex = i+2;
					}
				}
				for(int i = 0; i < sentances.size(); i++){
					if(i % 2 == 0 && i != 0){
						String outputString = sentances.get(i);
						outputString = outputString.substring(0, outputString.length() - 1);
						outputString = outputString + slang[slangIndex];
						slangIndex++;
						System.out.print(outputString + "* ");
					}else{
						System.out.print(sentances.get(i) + " ");
					}
				}
				
				System.out.println();
			}
		}
		
		fileScanner.close();

	}

}

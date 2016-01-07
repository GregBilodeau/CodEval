import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MorseCode {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		Map<String, String> morseAlphabet = new TreeMap<String, String>();
		morseAlphabet.put(".-", "A");
		morseAlphabet.put("-...", "B");
		morseAlphabet.put("-.-.", "C");
		morseAlphabet.put("-..", "D");
		morseAlphabet.put(".", "E");
		morseAlphabet.put("..-.", "F");
		morseAlphabet.put("--.", "G");
		morseAlphabet.put("....", "H");
		morseAlphabet.put("..", "I");
		morseAlphabet.put(".---", "J");
		morseAlphabet.put("-.-", "K");
		morseAlphabet.put(".-..", "L");
		morseAlphabet.put("--", "M");
		morseAlphabet.put("-.", "N");
		morseAlphabet.put("---", "O");
		morseAlphabet.put(".--.", "P");
		morseAlphabet.put("--.-", "Q");
		morseAlphabet.put(".-.", "R");
		morseAlphabet.put("...", "S");
		morseAlphabet.put("-", "T");
		morseAlphabet.put("..-", "U");
		morseAlphabet.put("...-", "V");
		morseAlphabet.put(".--", "W");
		morseAlphabet.put("-..-", "X");
		morseAlphabet.put("-.--", "Y");
		morseAlphabet.put("--..", "Z");
		morseAlphabet.put("-----", "0");
		morseAlphabet.put(".----", "1");
		morseAlphabet.put("..---", "2");
		morseAlphabet.put("...--", "3");
		morseAlphabet.put("....-", "4");
		morseAlphabet.put(".....", "5");
		morseAlphabet.put("-....", "6");
		morseAlphabet.put("--...", "7");
		morseAlphabet.put("---..", "8");
		morseAlphabet.put("----.", "9");
		morseAlphabet.put("", " ");
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String letters[] = line.split("\\s");
				for(String letter : letters){
					System.out.print(morseAlphabet.get(letter));
				}
			}
			System.out.println();
		}
		
		fileScanner.close();

	}

}

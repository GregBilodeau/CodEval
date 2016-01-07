import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

You are given a key and an enciphered message. The message was enciphered with the following vocabulary:

 !"#$%&'()*+,-./0123456789:<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
Note: The first symbol is space.

Your task is to decipher the message that was enciphered with the Gronsfeld cipher using the given key.

The Gronsfeld cipher is a kind of the Vigenère cipher and is similar to the Caesar cipher. The only difference is that in the Caesar cipher, each character is shifted along by the same number, while in the Gronsfeld cipher, each character has its own number of shifts. It means that the length of key for the Gronsfeld cipher must be the same as the length of the message. But since it is difficult to remember such a key, especially if the message is long, the key of the message is repeated until it has the same length as the message.

For example:

For the word "EXALTATION" and the key "31415", the ciphertext is the following:

Accordingly, enciphered message is the following:

HYEMYDUMPS
INPUT SAMPLE:

The first argument is a file with different test cases (there are possible test cases with spaces at enciphered message). Each test case contains a key and an enciphered message separated by semicolon.
For example:

1
2
3
31415;HYEMYDUMPS
45162;M%muxi%dncpqftiix"
14586214;Uix!&kotvx3
OUTPUT SAMPLE:

Print to stdout a deciphered message.
For example:

1
2
3
EXALTATION
I love challenges!
Test input.
CONSTRAINTS:

To decode a message, use the following alphabet: " !"#$%&'()*+,-./0123456789:<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
Number of test cases is 40.*/

public class GronsfeldCipher {
	
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);
		
		String alphabet = " !\"#$%&'()*+,-./0123456789:<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		
		char alphabetArray[] = alphabet.toCharArray();
		
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String[] elements = line.split(";");
				char offsets[] = elements[0].toCharArray();
				char message[] = elements[1].toCharArray();
				int offsetsCounter = 0;
				for(char c : message){
					
					int charIndex = alphabet.indexOf(c);
					
					int offset = Character.getNumericValue((offsets[offsetsCounter]));
					
					int newIndex = charIndex - offset;
					
					if(newIndex < 0){
						int diff = (alphabetArray.length) + newIndex;
						newIndex = alphabetArray.length + diff;
					}
					
					if(newIndex >= alphabetArray.length){
						newIndex = newIndex - alphabetArray.length;
					}
					
					System.out.print(alphabetArray[newIndex]);
					if(offsetsCounter >= offsets.length - 1){
						offsetsCounter = 0;
					}else{
						offsetsCounter++;
					}
				}
				System.out.println();
			}
		}
		scanner.close();
	}

}

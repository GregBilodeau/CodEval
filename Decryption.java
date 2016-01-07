public class Decryption {

	public static void main(String[] args){

		String message = "012222 1114142503 0313012513 03141418192102 0113 2419182119021713 06131715070119";
		String keyed_alphabet = "BHISOECRTMGWYVALUZDNFJKPQX";
		String key_array[] = keyed_alphabet.split("");
		
		// so each 2-digit number refers to an index of the array?
		
		String words[] = message.split("\\s");
		
		// frequency analysis suggests that these letters are vowels:
		
		// try first word
		for(String word : words){
			for(int i = 0; i < word.length(); i+=2){
				String letterNumber = word.charAt(i) + "" + word.charAt(i+1);
				int letterNum = Integer.parseInt(letterNumber);
				
				System.out.print(key_array[letterNum]);
				
			}
			System.out.print(" ");
		}
		
	}

}


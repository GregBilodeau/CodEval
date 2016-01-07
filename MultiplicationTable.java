
public class MultiplicationTable {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 12; i++){
			
			for(int j = 1; j <= 12; j++){
				
				// store the result in a variable
				int multiplicationResult = i * j;
				
				// apply proper spacing to maintain 4 digit size
				int numSpaces = 3;
				if(multiplicationResult >= 100){
					numSpaces = 1;
				}else if(multiplicationResult >= 10){
					numSpaces = 2;
				}
				
				// output the result with spacing
				do{
					numSpaces--;
					System.out.print(" ");
				}while(numSpaces > 0);
				System.out.print(multiplicationResult);
			}
			System.out.println();
		}

	}

}

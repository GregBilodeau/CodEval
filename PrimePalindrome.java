public class PrimePalindrome {

	public static void main(String[] args) {

		int largestPrimePalindrome = 0;
		for(int i = 2; i < 1000; i++){
			if(isPrime(i) && isPalindrome(i)){
				largestPrimePalindrome = i;
			}
		}
		System.out.println(largestPrimePalindrome);
	}
	
	public static boolean isPalindrome(int prime){
		String numString = String.valueOf(prime);
		if(numString.length() == 1){
			return true;
		}
		if(numString.length() == 2){
			if(numString.charAt(0) == numString.charAt(1)){
				return true;
			}
		}
		if(numString.length() == 3){
			if(numString.charAt(0) == numString.charAt(2)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPrime(int number){
		if (number <= 1) {
			return false;
	    }
	    for (int i = 2; i <= number/2; i++) {
	    	if (number % i == 0) {
	    		return false;
	        }
	    }
	    return true;
	}

}

public class SumOfPrimes {

	public static void main(String[] args) {

		int primeTotal = 0;
		int numPrimes = 0;
		int testNum = 2;
		while(numPrimes < 1000){
			if(isPrime(testNum)){
				numPrimes++;
				primeTotal += testNum;
			}
			testNum++;
		}
		System.out.println(primeTotal);
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

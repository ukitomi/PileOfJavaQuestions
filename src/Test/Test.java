package Test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sTest test1 = new Test();
		int[] array = new int[] {1, 2, 3, 4, 5};
		int left = 0;
		int right = array.length - 1;
		int i = 0;
		while (left < right - 1) {
			System.out.println(array[left]);
			left ++;
		}
		//System.out.println("My answer: " + test1.isPrime(3));
		// 4199 is not prime

	}

	public boolean isPrime(int n) {
		//boolean result = false;
		int temp = 2; // initialize
		if (n <= 1) { // corner case
			return false;
		} else { 
			for (temp = 2; temp < n; temp++) {
				if (n % temp != 0) {
					return true;}
			}
			//return result;
		}
		
		return false;
	}

}

package Intro;

public class Class02 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println("My Answer: " + s.sumOfSquares(1));
		System.out.println("Expected: 1");

	}

}

class Solution {

	// Calculate the sum of all square numbers between 1 and n (inclusive).
	// Example:
	// n = 3. Return 1;
	// n = 10. Return 14 (1 + 4 + 9);
	public int sumOfSquares(int n) {
		int solution = 0;
		if ( n == 1) {
			solution = 1;
		}
		for ( int i = 0; i < n; i ++ ) {
			if ( n >= (i * i)) { 
				solution += i*i;
			}
		}
		return solution;

	}



}

package Intro;

public class Class02 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println("My Answer: " + s.power(3, 4));
		System.out.println("Expected: 81");

	}

}

class Solution {

	// Calculate the sum of all square numbers between 1 and n (inclusive).
	// Example:
	// n = 3. Return 1;
	// n = 10. Return 14 (1 + 4 + 9);
	public int sumOfSquares(int n) {
		int solution = 0;
		if (n == 1) {
			solution = 1;
		}
		for (int i = 0; i < n; i++) {
			if (n >= (i * i)) {
				solution += i * i;
			}
		}
		return solution;
	}
	
	// Calculate factorial of n
	// n = 3, return 6
	// n = 4, return 24
	// n = 5, return 120
	public int factorial(int n) {
		if ( n == 1 ) {
			return 1;
		}
		else {
			return factorial(n-1) * n;	
		}
	}
	
	// Calculate a to the power of b
	// assumption: a > 0, b > 0
	// a = 3, b = 4  Return 81
	// a = 4, b = 2  Return 16
	public int power(int a, int b) {
		if ( b == 0) {
			return 1;
		}
		else {
			return (int) a * (power(a, b-1));
		}
	}

}

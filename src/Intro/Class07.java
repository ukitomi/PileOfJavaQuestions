package Intro;

public class Class07 {
	public static void main(String[] args) {
		Solution7 test = new Solution7();
		System.out.println(test.fibonacci2(6));	
	}
}

class Solution7 {
	/*
	 * Get the Kth number in the Fibonacci Sequence. 
	 * 0: 0, 1: 1, 2: 1, 3: 2, 6: 8
	 * (n-1) + (n-2)
	 */
	public long fibonacci(int K) {
		if ( K == 0 ) {
			return 0;
		}
		if ( K == 1) {
			return 1;
		}
		return fibonacci(K-1) + fibonacci(K-2);
		
	}
	
	// DP solution
	public long fibonacci2(int K) {
		if ( K <= 0 ) {
			return 0;
		}
		long[] array = new long[K+1];
		array[1] = 1;
		for (int i = 2; i <= K; i ++) {
			array[i] = array[i-1] + array[i-2];
		}
		return array[K];
	}
	
	// Evaluate a to the power of b, assuming both a and b are integers and b is non-negative. 
	public long power(int a, int b) {
		if ( b == 0) {
			return 1;
		}
		if ( a == 0) {
			return 0;
		}
		long half = power(a, b / 2);
		
		// if even, then half * half
		// if odd, then half * hlaf * a 
		return b % 2 == 0 ? half * half : half * half * a; 
		
	}
}

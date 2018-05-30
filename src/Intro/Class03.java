package Intro;

public class Class03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3 s = new Solution3();
		int[][] arr = {{2, 3},{4, 5}, {1, 0}};
		s.sum(arr);
//		for ( int i = 0; i < arr.length; i++ ) {
//			System.out.println(arr[i]);
//		}
		System.out.println(s.sum(arr));
		System.out.println("Expected: 15");

	}

}

class Solution3 {

	// Given an array, return its minimum value
	// array = [7, 3, 2], return 2
	// if the array is null or empty, return 0.
	public int min(int[] array) {
		int min = Integer.MAX_VALUE;
		if ( array == null || array.length == 0) { 
			min = 0;
		}
		for (int i = 0; i < array.length; i++) {
			if ( array[i] < min)
			{
				min = array[i];
			}
		}
		return min;
	}

	// Given an array, return sum of all elements.
	// array = [7, 3, 2], return 12
	public int sum(int[] array) {
		int sum = 0;
		if ( array == null || array.length == 0) {
			sum = 0; 
		}
		for ( int i = 0; i < array.length; i ++ ) {
			sum += array[i];
		}
		return sum;
	}
	
	// Given an array, and two indices i and j. 
	// Swap the element at position i and element at position j.
	// array = [7, 3, 2], i = 0, j = 2. 
	// Swap such that the array becomes [2, 3, 7]
	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	// Given an array, reverse all its elements.
	// array = [2, 3, 5, 7, 11]
	// result: [11, 7, 5, 3, 2]
	public void reverse(int[] array) {
		int left = 0;
		int right = array.length - 1;
		
		while ( left <= right ) {
			swap(array, left, right);
			left++;
			right--;
		}
	}
	
	// Given a two-dimensional array, calculate the sum of all its elements
	// array = {{ 2, 3}, {4, 5}, {1, 0}}
	// return 15 
	public int sum(int[][] array) {
	    int sum = 0;
	    for ( int i = 0; i < array.length; i ++) {
	    	for ( int j = 0; j < array[i].length; j ++ ) {
	    		sum += array[i][j];
	    	}
	    }
	    return sum;
	}

}
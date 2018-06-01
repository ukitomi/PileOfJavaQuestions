package Class02;

public class ClassicalBinarySearch {

	public static void main(String[] args) {
		ClassicalBinarySearch test = new ClassicalBinarySearch();
		int[] array = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(test.binarySearch2(array, 3));
		//System.out.println(array[array.length/2]);

	}

	// Given a target integer T and an integer array A sorted in ascending order,
	// find the index i such that A[i] == T or return -1 if there is no such index.
	// A = {1, 2, 3, 4, 5}, T = 3, return 2
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	public int binarySearch(int[] array, int target) {
		int result = 0;
		if (array.length < 1 || array == null) {
			result = -1;
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				result = i;
				break;
			} else {
				result = -1;
			}
		}
		return result;
	}
	
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	public int binarySearch2(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		
		while ( left <= right ) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			}
			else if ( array[mid] > target) {
				right = mid - 1;
			}
			else { // array[mid] < target
				left = mid + 1;
			}
		}
		
		return -1;
	}
}

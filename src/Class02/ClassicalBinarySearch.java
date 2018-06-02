package Class02;

public class ClassicalBinarySearch {

	public static void main(String[] args) {
		ClassicalBinarySearch test = new ClassicalBinarySearch();
		int[] array = new int[] { 1, 4, 6, 8};
		int[] result = test.kClosest(array, 3, 3);
		System.out.println();
		for ( int i = 0; i < result.length; i ++) {
			System.out.println(result[i]);
		}

	}

	// Given a target integer T and an integer array A sorted in ascending
	// order,
	// find the index i such that A[i] == T or return -1 if there is no such
	// index.
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

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				right = mid - 1;
			} else { // array[mid] < target
				left = mid + 1;
			}
		}

		return -1;
	}

	/*
	 * Given a target integer T and an integer array A sorted in ascending
	 * order, find the index of the first occurrence of T in A or return -1 if
	 * there is no such index. A = {1, 2, 3}, T = 2, return 1 A = {1, 2, 3}, T =
	 * 4, return -1
	 */
	public int firstOccurrence(int[] array, int target) {
		if (array.length < 1 || array == null) {
			return -1;
		}

		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) { // not left <= right
			int mid = left + (right - left) / 2; // avoid overflow
			if (array[mid] == target) {
				right = mid; // we don't stop here, we keep checking
			} else if (array[mid] < target) { // not array[mid] <= target
				left = mid;
			} else { // array[mid] > target
				right = mid;
			}
		}

		// post-accessing, check left first then right
		if (array[left] == target) {
			return left;
		}
		if (array[right] == target) {
			return right;
		}

		return -1;
	}

	/*
	 * Given a target integer T and an integer array A sorted in ascending
	 * order, find the index of the last occurrence of T in A or return -1 if
	 * there is no such index. A = {1, 2, 2, 2, 3}, T = 2, return 3
	 */
	public int lastOccurrence(int[] array, int target) {
		if (array.length < 1 || array == null) {
			return -1;
		}

		int left = 0;
		int right = array.length - 1;

		while (left < right - 1) {
			int mid = left + (right - left) / 2; // avoid overflow
			if (array[mid] == target) {
				left = mid;
			} else if (array[mid] < target) {
				left = mid;
			} else { // array[mid] > target
				right = mid;
			}
		}

		if (array[right] == target) {
			return right;
		}
		if (array[left] == target) {
			return left;
		}

		return -1;
	}

	/*
	 * Given a target integer T and an integer array A sorted in ascending
	 * order, find the index i in A such that A[i] is closest to T. A = {1, 2,
	 * 3}, T = 2, return 1 A = {1, 4, 6}, T = 3, return 1 A = {1, 4, 6}, T = 5,
	 * return 1 or 2 A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
	 */
	public int closest(int[] array, int target) {
		if (array.length < 1 || array == null) {
			return -1;
		}

		int left = 0;
		int right = array.length - 1;

		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid; // it is not right = mid, because you don't need to
							// ..
			} else if (array[mid] < target) {
				left = mid;
			} else { // array[mid] > target
				right = mid;
			}
		}

		// it can be < or <=
		if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) { 
			return left;
		}
		return right; // doesn't need to be -1 .. if there's only one element,
						// return right does the job too.
	}

	/*
	 * Given a target integer T, a non-negative integer K and an integer array A
	 * sorted in ascending order, find the K closest numbers to T in A.
	 * A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
	 * A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
	 */
	public int[] kClosest(int[] array, int target, int k) {
		if (array.length == 0 || array == null) {
			return array;
		}

		// if no requirements
		if ( k == 0) {
			return new int[0];
		}
		
		// this is similar to a lastOccurrence search
		int left = largestSmallerEqual(array, target);
		int right = left + 1;
		int[] result = new int[k];
		
		// fulfill k requirements
		for (int i = 0; i < k; i ++) {
			// two conditions where we can advance the left pointer:
			// 1. right is out of bound
			// 2. right is not out of bound, left pointer is not out of bound
			//    and array[left] is closer to target.
			if ( right >= array.length || left >= 0 && Math.abs(target - array[left]) <= Math.abs(target - array[right])) {
				result[i] = array[left--];
			} else { // second condition
				result[i] = array[right++];
			}
		}
		return result;
	}
	
	// find the largest smallest or equal element to target's index in the array
	public int largestSmallerEqual(int[] array, int target) {
		int left = 0, right = array.length - 1;
		
		while ( left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		
		if (array[right] <= target) {
			return right;
		}
		if (array[left] <= target) {
			return left;
		}
		return -1;
	}
}

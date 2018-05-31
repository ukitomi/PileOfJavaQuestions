package Intro;

public class Class05 {

	public static void main(String[] args) {
		MergeSort test = new MergeSort();
		int[] array = new int[] { 4, 2, -3, 6 };
		test.mergeSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		test.merge(array, 0, 2, 3);
	}
}

class SelectionSort {

	// Selection sort: find the global min and swap
	public int[] solve(int[] array) {

		for (int i = 0; i < array.length; i++) { // outer loop stay on current
													// position and swap

			// a global minimum index, we don't want global min value because we
			// are swapping with index
			int minindex = i;
			for (int j = i; j < array.length; j++) { // inner loop to find the
														// global min

				/// comparison: if global min index is greater than the current
				/// element, store that element as current global min
				if (array[j] < array[minindex]) {
					minindex = j;
				}
			}

			// passed in two index and swap them
			swap(array, i, minindex);
		}
		return array;
	}

	// swap based on given index
	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}

class MergeSort {

	// Mergesort: divide and concur
	public int[] mergeSort(int[] array) {
		// corner case
		if ( array.length <= 1 || array == null) {
			return array;
		}
		
		// start to divide, need helper function because current method can't be recursive call
		mergeSort(array, 0, array.length-1);
		return array;
	}

	// divide phase
	public void mergeSort(int[] array, int left, int right) {
		if ( left >= right ) {
			return;
		}
		// middle pivot
		int mid = left + ( right - left ) / 2;
		mergeSort(array, left, mid);  // dive down to the left half of the array
		mergeSort(array, mid + 1, right); // dive down to the right half of the array
		
		merge(array, left, mid, right); // merge left & right elements together
	}

	// merge/concur phase
	public void merge(int[] array, int left, int mid, int right) {
		int[] helper = new int[array.length];

		// copy all elements from array to helper, and merge from here
		for (int i = left; i <= right; i++) {
			helper[i] = array[i];
		}

		int leftIndex = left;
		int rightIndex = mid + 1;
		// compare elements in helper array, and modify in the actual array
		while ( leftIndex <= mid && rightIndex <= right) {  // check boundary
			if (helper[leftIndex] < helper[rightIndex]) { 
				array[left++] = helper[leftIndex++];
			}
			else {
				array[left++] = helper[rightIndex++];
			}
		}

		// if there are remaining elements...
		while ( leftIndex <= mid ) {
			array[left++] = helper[leftIndex++];
		}
		
	}
}
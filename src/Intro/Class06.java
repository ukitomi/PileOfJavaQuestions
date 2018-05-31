package Intro;

import java.util.Random;

public class Class06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort test = new QuickSort();
		int[] array = new int[] { 4, 2, -3, 6, 1 };
		test.quickSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}

class QuickSort {
	public int[] quickSort(int[] array) {
		if (array.length <= 1 || array == null) {
			return array;
		}
		quickSort(array, 0, array.length - 1); // need a helper method in order
												// to partition
		return array;
	}

	public void quickSort(int[] array, int left, int right) {
		// we know there's a leftbound(i) and a rightbound(j)
		if (left >= right) {
			return;
		}

		int pivotPos = partition(array, left, right);
		// everytime quickSort is called, the array area [left, right] ^ will
		// already be partitioned,
		// and pivotPos is the boundary where next sort should happen
		quickSort(array, left, pivotPos);
		quickSort(array, pivotPos + 1, right);
	}

	// quick select
	public int partition(int[] array, int left, int right) {
		// random pivot index
		int pivotIndex = left + (int) (Math.random() * (right - left + 1));
		int pivot = array[pivotIndex];
		// swap pivot to the rightmost position of the array
		swap(array, pivotIndex, right);

		int leftBound = left;
		int rightBound = right - 1;

		while (leftBound <= rightBound) {
			if (array[leftBound] < pivot) {
				leftBound++;
			} else if (array[rightBound] >= pivot) {
				rightBound--;
			} else { // array[leftBound] > pivot || array[rightBound] < pivot
				swap(array, leftBound, rightBound);
			}
		}

		// at this point, elts smaller than pivot are on the left side of the
		// pivot
		// elts larger than pivot are on the right side of the pivot
		// pivot should switch with the rightmost element.
		swap(array, leftBound, right);

		return leftBound;
	}

	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}

class RainbowSort {

	// -1, 0, 1
	public int[] rainbowSort(int[] array) {
		if (array.length <= 1 || array == null) {
			return array;
		}
		int i = 0, j = 0, k = array.length - 1;
		while (j <= k) {
			if (array[j] == -1) {
				swap(array, i, j);
				i++;
				j++;
			} else if (array[j] == 0) {
				j++;
			} else { // array[j] != -1 && array[j] != 0
				swap(array, j, k);
				k--;
			}
		}
		return array;
	}

	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}

class moveZero {

	public int[] moveZero(int[] array) {
		if ( array.length <= 1 || array == null) {
			return array;
		}
		int i = 0, k = array.length - 1;
		
		while ( i <= k) {
			if ( array[i] == 0) {
				swap(array, i, k);
				k--;
			} 
			else { // array[i] != 0 
				i++;
			}
		}
		return array;
	}
	
	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
package Class02;

public class SearchSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchSortedMatrix test = new SearchSortedMatrix();
		int[][] matrix = new int[][]{ {1, 2, 3}, {4, 5, 7}, {8, 9, 10} };
		int[] result = test.search(matrix, 7);
		
		for (int i = 0; i < result.length; i ++) {
			System.out.println(result[i]);
		}

	}

	/*
	 * Given a 2D matrix that contains integers only, which each row is sorted
	 * in an ascending order. The first element of next row is larger than (or
	 * equal to) the last element of previous row.
	 * 
	 * Given a target number, returning the position that the target locates
	 * within the matrix. If the target number does not exist in the matrix,
	 * return {-1, -1}.
	 * 
	 * matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
	 * target = 7, return {1, 2}
	 * target = 6, return {-1, -1} to represent the target number does not exist
	 * in the matrix.
	 */
	public int[] search(int[][] matrix, int target) {
		// Write your solution here
		int[] result = new int[] {-1, -1};
		if ( matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		
		//int left = 0;
		//int right = matrix[matrix.length].length;
		int row = matrix.length;
		int column = matrix[0].length;
		int left = 0;
		int right = row * column - 1; // what if i implement as the right var above?
		while (left <= right) {
			int mid = left + (right - left) / 2; 
			int r = mid / column;
			int c = mid % column;
			if (matrix[r][c] == target) {
				result[0] = r;
				result[1] = c;
				break;  // but this is not recommended to use in interview
				//return new int[]{r, c};
			}
			else if ( matrix[r][c] < target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return result;
		//return new int[]{-1, -1};
	}
}

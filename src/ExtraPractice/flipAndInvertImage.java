package ExtraPractice;

public class flipAndInvertImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[][] flipAndInvertImage(int[][] A) {
		
		//reverse every element in a row first
		
		int row = A.length;
		int column = A[0].length;
		
		int[][] result = new int[A.length][];
		for (int i = 0; i < row; i++) {
			int rev[] = reverseNum(A[i]);
			int inv[] = inverseNum(rev);
			result[i] = inv;
		}
		
		return result;
	}
	
	// num.length - i - 1 reaches the opposite end of the row
	public int[] reverseNum(int num[]) {
		int length = num.length;
		for (int i = 0; i < length / 2; i++) {
			int temp = num[i];
			num[i] = num[num.length - i - 1];
			num[num.length - i - 1] = temp;
		}
		
		return num;
	}
	
	public int[] inverseNum(int num[]) {
		
		// '^' is bitwise XOR
		for ( int i = 0; i < num.length; i++) {
			num[i] = num[i]^1;
		}
		
		return num;
	}

}

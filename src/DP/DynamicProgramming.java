package DP;

public class DynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicProgramming test = new DynamicProgramming();
		int[] array = new int[] {1, 0, 1, 1, 4};
		System.out.println(test.canJumpII(array));
	}

	public boolean canJumpII(int[] array) {
	    if (array.length == 1) return true;
	    boolean[] canJump = new boolean[array.length];
	    for (int i = array.length - 2; i >= 0; i--) {
	        // if from index i, it's aleady possible to jump to the
	        // end of the array
	        if (i + array[i] >= array.length - 1) {
	            canJump[i] = true;
	        }
	        else {
	            // if any of the reachable indices from index i 
	            // is reachable to the end of the array.
	            for (int j = array[i]; j >= 1; j--) {
	                if (canJump[j + i]) {
	                    canJump[i] = true;
	                    break;
	                }
	            }
	        }
	    }
	    return canJump[0];
	}
}

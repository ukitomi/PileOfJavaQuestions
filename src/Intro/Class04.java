package Intro;

public class Class04 {

	public static void main(String[] args) {
		Accumulator test = new Accumulator();
		
//		for ( int i = 0; i < 4; i ++ ) {
//			System.out.println()
//		}
		System.out.println(test.make(4));

	}

}

/* 
 * Design an accumulator, which can take a new integer using function “add”, 
 * and can return the sum of all taken integers up to now using function “sum”.
 */
class Accumulator2 {
	private int sum;
	
	public void add(int x) {
		sum += x;
	}
	public int sum() {
		return sum;
	}
}

/* 
 *  Given the following definition of “Tesla”,
 *  and an integer n (n > 0). 
 *  Make an array of n Tesla cars whose number of wheels is 4 
 *  and who “VIN” numbers are from 0 to n-1.
 */
class Tesla {
	int numOfWheels;
	int vin;
	public Tesla(int n, int v) {
		numOfWheels = n;
		vin = v;
	}
}

class Accumulator {
	public Tesla[] make(int n) {
		// initialize the array
		Tesla[] car = new Tesla[n];
		
		// assign values to each element in the array
        for ( int i = 0; i < n; i ++) {
        	car[i] = new Tesla(4, i);
        	System.out.println(car[i]);
        }
        
        return car;
	}
}

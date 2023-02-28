package cen3024;

/**
 * 
 * Module 5 Documentation Assignment.  
 *
 */
public class Module_5_Assignment {

	/**
	 * Main method to run the Fibonacci functions
	 * 
	 * @param args Strings passed into the main
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//instantiate objects for recursive and iterative
		FibonacciRecursion fr = new FibonacciRecursion();
		FibonacciIterative fi = new FibonacciIterative(); 

		//start iterative
		fi.start();
		
		//try to complete iterative thread before starting recursion thread
		try {
			fi.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//start recursion
		fr.start();	
	}

}

/**
 * 
 * Class to run the Fibonacci Recursion function. 
 * Extending Thread to run code at the same time to execute faster 
 *
 */
class FibonacciRecursion extends Thread{
	
	/**
	 * 
	 * Fibonacci Recursion function
	 * 
	 * @param n for the input to pass into the fibonacci function
	 * @return return the calculations of the fibonacci sequence
	 */
	public static int fibonacci(int n) {
		
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		return fibonacci(n-1) + fibonacci(n-2);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		double[] rTime = new double[20];
		double[] rInput = new double[20];
		
		System.out.println("**** Fibonacci Recursion ****");
		
		//loop through inputs to store values in array
		for(int i = 0; i < 20; i++) {
			
			long time = System.nanoTime(); //begin the time in nanoseconds
			fibonacci(i);
			time = System.nanoTime() - time;//end time the nanoseconds took to finish
			
			rInput[i] = i;
			rTime[i] = time;
		}
		
		//Create two column layout to see the input number and time results
		System.out.printf("\n%s\t\t%s", "Current number", "Nanoseconds");
		
		//output the input and time results
		for(int i = 0; i < 20; i++) {
			System.out.printf("\n%.2f\t\t\t%.2f", rInput[i], rTime[i]);
		}
		
		//output message showing loop complete
		System.out.println("\n\n**** Fibonacci Recursion Complete ****");
	}
	
}

/**
 * 
 * Class to run the Fibonacci Iterative function. 
 * Extending Thread to run code at the same time to execute faster 
 *
 */
class FibonacciIterative extends Thread{

	/**
	 * 
	 * Fibonacci Iterative function
	 * 
	 * @param n for the input to pass into the fibonacci function
	 * @return return the calculations of the fibonacci sequence
	 * 
	 *
	 */
	public static int fibonacci(int n) {
		
		if(n== 0 || n ==1) {
			return n;
		}
		
		int v1 = 0, v2 = 1, v3 = 0;
		
		for(int i = 2; i <= n; i++){
            v3 = v1 + v2;
            v1 = v2;
            v2 = v3;
        }
		
        return v3;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		double[] iTime = new double[20];
		double[] iInput = new double[20];
		
		System.out.println("**** Fibonacci Iterative ****");
		
		//loop through inputs to store values in array
		for(int i = 0; i < 20; i++) {
			
			long time = System.nanoTime(); //begin the time in nanoseconds
			fibonacci(i);
			time = System.nanoTime() - time;//end time the nanoseconds took to finish
			
			iInput[i] = i;
			iTime[i] = time;
		}
		
		//Create two column layout to see the input number and time results
		System.out.printf("\n%s\t\t%s", "Current number", "Nanoseconds");
		
		//output the input and time results
		for(int i = 0; i < 20; i++) {
			System.out.printf("\n%.2f\t\t\t%.2f", iInput[i], iTime[i]);
		}
		
		//output message showing loop complete
		System.out.println("\n\n**** Fibonacci Iterative Complete ****");
	}
}
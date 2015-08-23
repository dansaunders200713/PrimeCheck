/**
 * Created by Daniel Saunders on 2/6/15
 * PrimeCheck.java
 * A program that searches through each number < input integer, return a set of factors and
 * determines whether or not the input integer is prime. This program has a time complexity
 * of magnitude O(n/2), or O(n). 
 */

import java.util.*;

public class PrimeCheck {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("Enter a positive integer n, or \"exit\" to quit: "); // input number to perform factorization check on
			String input = sc.nextLine(); 
			if (input.equals("exit")) System.exit(0); // exits on "exit" input
			long n = 0;
			try {
				n = Long.parseLong(input); // accepts up to 2^64-1 size integers
			} catch (NumberFormatException e) {
				System.out.println("Not an integer. Try again!"); // too large, bad format, not a number...
				continue;
			}
			if (n <= 0) { // negative or zero input
				System.out.println("Negative or zero. Try again!"); 
				continue;
			}
			ArrayList<Long> factors = findFactors(n); // create list of factors from findFactors method
			if (factors.size() <= 2) {
				System.out.println(n + " is a prime number. Trivial factors: " + factors);
			}
			else {
				System.out.println(n + " is not a prime number. Factors: " + factors);
			}
		}
	}
	
	public static ArrayList<Long> findFactors(long n) {  // method that loops through each number < input / 2, adds factors to factor list
		ArrayList<Long> factors = new ArrayList<Long>();
		for (long i = 1; i <= n / 2; i++) { // only necessary to go up to input / 2!
			if (n % i == 0) { // no remainder = i divides input
				factors.add(i);
			}
		}
		factors.add(n); // add input number to factors, input is trivially a factor
		return factors;
	}
}
package _01_Bit_Shifting;

import _00_Binary_Conversion.DecimalToBinary;

public class BitShifter {
	public static void main(String[] args) {
		// 1. Jot down the value of num in binary.
		int num = 0b101101;
		int numShifted = num << 1;
		
		// 2. Print the value of numShifted, and convert that value to binary.
		System.out.println("      DECIMAL: " + num);
		System.out.println("      BINARY:  " + DecimalToBinary.d2b(num));
		System.out.println();
		
		System.out.println("<< x1 DECIMAL: " + numShifted);
		System.out.println("<< x1 BINARY:  " + DecimalToBinary.d2b(numShifted));
		System.out.println();
		
		
		
		// 3. Compare the two binary values. Can you figure out what the << operator is for?
		
		// 4. Try shifting num 3 places.

		System.out.println("<< x3 DECIMAL: " + (num<<3));
		System.out.println("<< x3 BINARY:  " + DecimalToBinary.d2b(num<<3));
		System.out.println();
		
		// FYI: Binary values can be shifted to the right as well using the >> operator.	

		System.out.println(">> x1 DECIMAL: " + (num>>1));
		System.out.println(">> x1 BINARY:  " + DecimalToBinary.d2b(num>>1));
		System.out.println();
		
		System.out.println(">> x3 DECIMAL: " + (num>>3));
		System.out.println(">> x3 BINARY:  " + DecimalToBinary.d2b(num>>3));
	}
}

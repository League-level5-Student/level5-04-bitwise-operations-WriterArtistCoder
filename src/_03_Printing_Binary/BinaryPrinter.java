package _03_Printing_Binary;

import _00_Binary_Conversion.DecimalToBinary;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Use bit shifting and bit masking to print the binary numbers.
	//Do not use the Integer.toBinaryString method!
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	public static void main(String[] args) {
		// TODO test the methods
	}
	
	public void printByteBinary(byte b) {
		System.out.println("DECIMAL: " + b);
		System.out.println("BINARY:  " + DecimalToBinary.d2b(b));
	}
	
	public void printShortBinary(short s) {
		System.out.println("DECIMAL: " + s);
		System.out.println("BINARY:  " + DecimalToBinary.d2b(s));
	}
	
	public void printIntBinary(int i) {
		System.out.println("DECIMAL: " + i);
		System.out.println("BINARY:  " + DecimalToBinary.d2b(i));
	}
	
	public void printLongBinary(long l) {
		// TODO make long converter
		System.out.println("DECIMAL: " + l);
		System.out.println("BINARY:  " + "???");
	}
}

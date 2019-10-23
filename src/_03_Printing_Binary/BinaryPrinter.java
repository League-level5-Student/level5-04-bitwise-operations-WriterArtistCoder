package _03_Printing_Binary;

import java.util.Random;

import _00_Binary_Conversion.DecimalToBinary;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Use bit shifting and bit masking to print the binary numbers.
	//Do not use the Integer.toBinaryString method!
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	public static void main(String[] args) {
		
		printByteBinary((byte) Math.abs(new Random().nextInt(128)));
		System.out.println();
		
		printShortBinary((short) Math.abs(new Random().nextInt(32768)));
		System.out.println();
		
		printIntBinary(Math.abs(new Random().nextInt()));
		System.out.println();
		
		printLongBinary(Math.abs(new Random().nextLong()));
		System.out.println();
		
	}
	
	public static void printByteBinary(byte b) {
		System.out.println("DECIMAL: " + b);
		System.out.println("BINARY:  " + DecimalToBinary.d2b(b));
	}
	
	public static void printShortBinary(short s) {
		System.out.println("DECIMAL: " + s);
		System.out.println("BINARY:  " + DecimalToBinary.d2b(s));
	}
	
	public static void printIntBinary(int i) {
		System.out.println("DECIMAL: " + i);
		System.out.println("BINARY:  " + DecimalToBinary.d2b(i));
	}
	
	public static void printLongBinary(long l) {
		System.out.println("DECIMAL: " + l);
		
		String b = "";
		while (l > 0) {
			b = l%2 + b;
			l = l/2;
		}
		
		System.out.println("BINARY:  " + b);
	}
}

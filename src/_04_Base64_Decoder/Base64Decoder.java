package _04_Base64_Decoder;

import java.util.ArrayList;

import _00_Binary_Conversion.BinaryToDecimal;
import _00_Binary_Conversion.DecimalToBinary;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text. Each number 0-63 is
	 * mapped to a character. NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE
	 * ENCODING! Since the numbers 0 through 63 can be represented using 6 bits,
	 * every four (4) characters will represent twenty four (24) bits of data. 4 * 6
	 * = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being
	 * converted do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML
	 * file (for web development), so that way a web site does not have to look for
	 * an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */

	final static char[] base64Chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '+', '/' };

	public static void main(String[] args) {
		byte[] bytes = convert4CharsTo24Bits("AB+/");
		
		System.out.println();
		for (byte b : bytes) {
			int i = Byte.toUnsignedInt(b)+64; // Unsigns and expands 
			String s = DecimalToBinary.d2b(i).substring(1); // Expands
			
			System.out.println("DEMASHED --/" + s + "\\--");
		}
	}

	// 1. Complete this method so that it returns the the element in
	// the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c) {
		ArrayList<Character> chars = new ArrayList<>();
		for (char ch : base64Chars) {
			chars.add(ch);
		}

		return (byte) chars.indexOf(c);

	}

	// 2. Complete this method so that it will take in a string that is 4
	// characters long and return an array of 3 bytes (24 bits). The byte
	// array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s) {
		ArrayList<Character> chars = new ArrayList<>();
		for (char ch : base64Chars) {
			chars.add(ch);
		}

		String result = "";
		System.out.println();
		for (char c : s.toCharArray()) {
			byte b = (byte) chars.indexOf(c);
			System.out.println("ORIGINAL --/" + DecimalToBinary.d2b(b) + "\\--");
			result += DecimalToBinary.d2b(b+64).substring(1);
		}
		
		System.out.println();
		System.out.println("MASHED --/" + result + "\\--");

		byte[] bytes = new byte[3];
		for (int i = 0; i < 3; i++) {
			String byteAsStr = result.substring(0, 8);
			System.out.println("\nRESIZING (STRING) --/" + byteAsStr + "\\--");
			
			byte b = (byte) BinaryToDecimal.b2d(byteAsStr);
			bytes[i] = b;
			
			System.out.println("RESIZING (BINARY) --/" + BinaryToDecimal.b2d(byteAsStr) + "\\--");
			System.out.println("RESIZING (BYTE)   --/" + b + "\\--");

			result = result.substring(8);
		}

		return bytes;
	}

	// 3. Complete this method so that it takes in a string of any length
	// and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		byte[] result = new byte[(int) (file.length()*0.75)];
		int index = 0;
		
		for (int i = 0; i < file.length(); i+=4) {
			String s = file.substring(i, i+4);
			byte[] convert = convert4CharsTo24Bits(s);
			
			for (byte b : convert) {
				result[index] = b;
				index++;
			}
		}
		return result;
	}
}

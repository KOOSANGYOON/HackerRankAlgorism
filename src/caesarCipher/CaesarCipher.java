package caesarCipher;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CaesarCipher {
	static String makeResult(int i, int ascii, String s) {
		if (i == 0) {
			return Character.toString((char) ascii) + s.substring(i + 1, s.length());
		}
		return s.substring(0, i) + Character.toString((char) ascii) + s.substring(i + 1, s.length());
	}
	
	static boolean isAlphabet(int ascii) {
		return (ascii < 65 || 122 < ascii || (90 < ascii && ascii < 97));
	}
	
	static int changeUpperOrLower(int ascii, int k) {
		ascii = ascii % 128;

		if (64 < ascii && ascii < 91) {
			ascii = (ascii - 65 + k) % 26 + 65;
			return ascii;
		}
		ascii = (ascii - 97 + k) % 26 + 97;
		return ascii;
	}

	static String caesarCipher(String s, int k) {
		for (int i = 0; i < s.length(); i++) {
			int ascii = (int) s.charAt(i);

			if (isAlphabet(ascii)) {
				continue;
			}

			ascii = changeUpperOrLower(ascii, k);

			s = makeResult(i, ascii, s);
		}
		return s;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		int k = in.nextInt();
		String result = caesarCipher(s, k);
		System.out.println(result);
		in.close();
	}
}

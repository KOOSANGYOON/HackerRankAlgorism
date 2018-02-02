package twoCharacter;

import java.util.Scanner;

public class TwoCharacter {
	static boolean checkResult(String input) {
		for (int i = input.length() - 1; i > 1; i--) {
			if (input.charAt(i) != input.charAt(i - 2)) {
				return false;
			}
		}
		return true;
	}

	static String makeResult(String input, char first, char second) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == first || input.charAt(i) == second) {
				result += input.charAt(i);
			}
		}
		return result;
	}

	static int twoCharaters(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				char first = s.charAt(i);
				char second = s.charAt(j);

				if (first == second) {
					continue;
				}
				String temp = makeResult(s, first, second);

				if (checkResult(temp)) {
					return temp.length();
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		String s = in.next();
		int result = twoCharaters(s);
		System.out.println(result);
		in.close();
	}
}

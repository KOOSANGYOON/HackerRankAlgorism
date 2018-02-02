package superReducedString;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SuperReducedString {
	static String super_reduced_string(String s){
		// Complete this function
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i+1)) {
				System.out.println("change first !!! index is " + i + " and " + (i + 1)  + " in " + s);
				System.out.println("delete back char is " + s.charAt(i + 1));
				System.out.println("delete front char is " + s.charAt(i));
				
				s = s.substring(0, i) + s.substring(i + 2, s.length());

				s = super_reduced_string(s);        //recursion

				return s;
			}
		}
		if (s.equals("")) {
			return "Empty String";
		}
		return s;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = super_reduced_string(s);
		System.out.println(result);
	}
}
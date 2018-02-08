package solution;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	static String timeConversion(String s) {
		// Complete this function
		if(s.contains("PM") && ! s.substring(0, 2).equals("12")) {
			String time = "" + s.charAt(0) + s.charAt(1);
			int timeNum = Integer.parseInt(time) + 12;
			time = "" + timeNum + s.substring(2, 8);
			return time;
		}else if (s.contains("PM") && s.substring(0, 2).equals("12")) {
			return s.substring(0, 8);
		}else if (s.contains("AM") && s.substring(0, 2).equals("12")) {
			return "00" + s.substring(2, 8);
		}
		return s.substring(0, 8);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = timeConversion(s);
		System.out.println(result);
	}
}
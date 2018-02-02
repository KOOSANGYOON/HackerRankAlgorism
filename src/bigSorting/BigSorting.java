package bigSorting;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BigSorting {
	static String[] returnBiggerLast(String[] arr, int i, int j) {
		String temp = "";
		for (int k = 0; k < arr[i].length(); k++) {
			if ((int) arr[i].charAt(k) == (int) arr[j].charAt(k)) {
				continue;
			}
			
			if ((int) arr[i].charAt(k) > (int) arr[j].charAt(k)) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				return arr;
			}else if ((int) arr[i].charAt(k) < (int) arr[j].charAt(k)) {
				return arr;
			}
		}
		return arr;
	}
	
	static String[] checkNum(String[] arr, int i, int j) {
		String temp = "";
		if (Long.parseLong(arr[i]) > Long.parseLong(arr[j])) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return arr;
	}
	
	static boolean checkWithLength(String inputOne, String inputTwo) {
		return inputOne.length() > inputTwo.length();
	}
	
	static boolean isLengthSame(String inputOne, String inputTwo) {
		return inputOne.length() == inputTwo.length();
	}
	
	static String[] bigSorting(String[] arr) {
		// Complete this function
		String temp = "";
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (isLengthSame(arr[i], arr[j]) && arr[i].length() > 18) {
					arr = returnBiggerLast(arr, i, j);
				}else if (isLengthSame(arr[i], arr[j]) && arr[i].length() <= 18) {
					arr = checkNum(arr, i, j);
				}
				if (checkWithLength(arr[i], arr[j])) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] arr = new String[n];
		for(int arr_i = 0; arr_i < n; arr_i++){
			arr[arr_i] = in.next();
		}
		String[] result = bigSorting(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");


		in.close();
	}
}

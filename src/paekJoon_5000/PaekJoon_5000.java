package paekJoon_5000;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaekJoon_5000 {
	static List<String> totalList = new ArrayList<String> ();
	
	static String makeString(String[] current) {
		String currentString = "";
		for (int i = 0; i < current.length; i++) {
			currentString += current[i];
		}
		return currentString;
	}
	
	static boolean checkExist(String current) {
		return totalList.contains(current);
	}
	
	public static void makeList(String[] current, int depth, int index) {
		if (depth > 3) {
			return;
		}
		
		String temp = "";
		temp = current[index];
		current[index] = current[index + 2];
		current[index + 2] = current[index + 1];
		current[index + 1] = temp;
		
		System.out.println("depth is " + depth);
		depth++;
		
		for (int i = 0; i < current.length - 2; i++) {
			makeList(current, depth, i);
		}
		
		String currentString = makeString(current);
		
		if (checkExist(currentString)) {
			System.out.println("exist so return");
			return;
		}
		
		System.out.println("add " + currentString);
		totalList.add(currentString);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		scan.nextLine();
		
		String[] current = scan.nextLine().split(" ");
		String[] hope = scan.nextLine().split(" ");
		
		int depth = 1;
//		makeList(current, depth, 0);
		for (int i = 0; i < current.length - 2; i++) {
			makeList(current, depth, i);
		}
		
		String result = "";
		for (int i = 0; i < hope.length; i++) {
			result += hope[i];
		}
		
		if (totalList.contains(result)) {
			System.out.println("Possible");
		}else {
			System.out.println("Impossible");
		}
		scan.close();
	}
}

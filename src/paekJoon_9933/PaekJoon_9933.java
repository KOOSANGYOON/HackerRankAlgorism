package paekJoon_9933;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaekJoon_9933 {
	static String reverseString(String s) {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(s);
		return strBuffer.reverse().toString();
	}
	
	static String checkWholeList(List<String> inputData) {
//		for (int i = 0; i < inputData.size() - 1; i++) {
//			for (int j = i; j < inputData.size(); j++) {
//				if (inputData.get(i).equals(reverseString(inputData.get(j)))) {
//					return inputData.get(i);
//				}
//			}
//		}
		for (String passwd : inputData) {
			if (inputData.contains(reverseString(passwd))) {
				return passwd;
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
		List<String> inputData = new ArrayList<String> ();
		
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		
		for (int i = 0; i < count; i++) {
			inputData.add(scan.next());
		}
		
		String result = checkWholeList(inputData);
		
		if (result.length() != 0) {
            System.out.println(result.length() + " " + result.charAt(result.length() / 2));
        }
	}
}
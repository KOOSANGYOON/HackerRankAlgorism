package separateTheNumbers;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SeparateTheNumbers {
	static void separateNumbers(String s) {
		for (int i = 0; i <= s.length() / 2; i++) {
			int count = 0;

			while(count + i < s.length()) {
				Long firstNum = Long.parseLong(s.substring(count, count + i));
				if ((firstNum + 1) % 10 == 0) {
					count++;
					Long secondNum = Long.parseLong(s.substring(count + i - 1, count + (i * 2)));
				}else {
					Long secondNum = Long.parseLong(s.substring(count + i, count + (i * 2)));
				}
				count++;
			}
			
		}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            separateNumbers(s);
        }
        in.close();
    }
}

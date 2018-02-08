package paekJoon_1463;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaekJoon_1463 {
	static List<Integer> countList = new ArrayList<Integer> ();
	
	static boolean isSmallestNull() {
		return smallestNow() == null;
	}
	
	static Integer smallestNow() {
		if (countList.size() == 0) {
			return null;
		}
		int temp = 0;
		
		for (int i = 0; i < countList.size(); i++) {
			if (i == 0) {
				temp = countList.get(i);
			}else {
				if (countList.get(i) < temp) {
					temp = countList.get(i);
				}
			}
		}
		return temp;
	}
	
	static boolean isCountEnough(int count) {
		return (!isSmallestNull() && count >= smallestNow());
	}
	
	static Integer makeOne(int input, int count) {
		int result = count;
		
		if (input == 1) {
			System.out.println("1이 되서 복귀합니다. 현재의 count 는 : " + count + ", input은 : " + input);
			countList.add(count);
			return count;
		}
		
		if (isCountEnough(count)) {
			return count;
		}
		
		count++;
		
		if (input % 3 == 0 && !isCountEnough(count)) {
			System.out.println("나누기 3을 진행합니다. 현재의 count 는 : " + count + ", input은 : " + input/3);
			result = makeOne(input / 3, count);
		}
		if (input % 2 == 0 && !isCountEnough(count)) {
			System.out.println("나누기 2를 진행합니다. 현재의 count 는 : " + count + ", input은 : " + input/2);
			result = makeOne(input / 2, count);
		}
		if (input > 1 && !isCountEnough(count)) {
			System.out.println("빼기 1을 진행합니다. 현재의 count 는 : " + count + ", input은 : " + (input - 1));
			input--;
			result = makeOne(input, count);
		}
		System.out.println("이번 층에서 할 것은 다 끝났습니다. 올라갑니다.");
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		makeOne(input, 0);
		int result = smallestNow();
		System.out.println(result);
	}
}

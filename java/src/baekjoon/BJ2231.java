package baekjoon;

import java.util.Scanner;

public class BJ2231 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int inputNum = Integer.parseInt(sc.nextLine());
		int startNum = inputNum - 9 * String.valueOf(inputNum).length();
		
		int result = 0;

		for(int i=startNum; i<inputNum; i++) {
			if( i+ digitSum(i) == inputNum ) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
	
	// 각 자리수 합하는 메서드
	private static int digitSum(int num) {
		int sum = 0;
		while( num > 0 ) {
			sum += num % 10;
			num = num / 10;
		} 
		return sum;
	}
}
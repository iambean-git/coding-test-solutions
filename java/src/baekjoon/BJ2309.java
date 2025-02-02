package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BJ2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> inputArr = new ArrayList<>();
		int totalSum = 0;
		for (int i=0; i<9; i++) {
			int tmp = sc.nextInt();
			inputArr.add(tmp);
			totalSum += tmp;
		}

//		System.out.println(inputArr);
//		System.out.println("totalSum : "+ totalSum);
		
		for (int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				if((totalSum - inputArr.get(i) - inputArr.get(j)) == 100) {
//					System.out.println("첫번째 fake : " + i + ", 두번째 fake : " + j);
//					System.out.println("첫번째 fake : " + inputArr.get(i) + ", 두번째 fake : " + inputArr.get(j));
					inputArr.remove(j);
					inputArr.remove(i);
					break;
				}
			}
			if(inputArr.size() != 9) break;
		}
		
		Collections.sort(inputArr);
//		System.out.println(inputArr);
		for(int num : inputArr) System.out.println(num);
	}
}

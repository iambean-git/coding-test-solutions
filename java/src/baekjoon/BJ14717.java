package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ14717 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 한 줄 입력받기
		String input = br.readLine();

		// 공백을 기준으로 문자열 분리
		String[] inputStr = input.split(" ");

		// 문자열을 정수로 변환
		int num1 = Integer.parseInt(inputStr[0]);
		int num2 = Integer.parseInt(inputStr[1]);

		// 전체 경우의 수
		int total = 18 * 17 / 2;

		// 땡을 뽑았을 경우
		if (num1 == num2) {
			double win = (double) (total - (10 - num1)) / total;
			System.out.printf("%.3f", win);
		}
		// 끗을 뽑았을 경우
		else {
			// 끗
			int num = (num1 + num2) % 10;
			// 0끗이면 이길 확률 0
			if (num == 0) {
				System.out.println("0.000");
				return;
			}

			// 그외에는 남은 카드 후보군 만들기
			int[] cards = new int[18];
			int idx = 0;
			for (int i = 1; i <= 10; i++) {
				cards[idx++] = i;
				if (i != num1 && i != num2)
					cards[idx++] = i;
			}

			// 카드 확인
//			for (int i = 0; i < 18; i++) {
//				System.out.print(cards[i] + " ");
//				
//			}System.out.println();

			int count = total;
			for (int i = 0; i < 17; i++) {
				for (int j = i + 1; j < 18; j++) {
					if(cards[i] == cards[j]) {
//						System.out.println("땡 : "+ cards[i] + " & " + cards[j]);
						count--; continue;
					}
					else if ((cards[i] + cards[j]) % 10 >= num) {
//						System.out.println(((cards[i] + cards[j]) % 10)+"끝 : "+cards[i] + " & " + cards[j]);
						count--;
					}
				}
			}
//			System.out.println("count : "+count);
			System.out.printf("%.3f", (double) (count) / total);
		}
	}
}

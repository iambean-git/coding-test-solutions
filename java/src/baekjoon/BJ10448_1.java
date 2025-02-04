package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10448_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ======= 입력받기 =======
		int inputNum = Integer.parseInt(br.readLine());
		int[] inputArr = new int[inputNum];
		for (int i = 0; i < inputNum; i++) {
			inputArr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < inputNum; i++) {
			System.out.println(getAnswer(inputArr[i]));
		}

	}

	public static int triNum(int num) {
		return num * (num + 1) / 2;
	}

	public static int getAnswer(int num) {
		int startNum = (int) Math.sqrt(num * 2) + 1;
		for (int i = startNum; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				for (int z = j; z > 0; z--) {
//					System.out.printf("i:%d / j:%d / z:%d => ", i, j, z);
//					System.out.printf("%d + %d + %d = %d \n", triNum(i), triNum(j), triNum(z),
//							triNum(i) + triNum(j) + triNum(z));
					if (triNum(i) + triNum(j) + triNum(z) == num) {
						return 1;
					}
					
				}
			}
		}
		return 0;
	}

}

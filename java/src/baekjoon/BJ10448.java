package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ10448 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ======= 입력받기 ======= 
		int inputNum = Integer.parseInt(br.readLine());
		int[] inputArr = new int[inputNum];
		for(int i=0; i<inputNum; i++) {
			inputArr[i] =Integer.parseInt(br.readLine()) ;
		}
		
		// 삼각수들을 담는 리스트 생성
		List<Integer> triList = new ArrayList<>();
		for (int i = 1; i * (i + 1) / 2 <= 1000; i++) {
            triList.add(i * (i + 1) / 2);
        }
		int limit = triList.size();

		
		for(int i=0; i<inputNum; i++) {
			System.out.println(getAnswer(inputArr[i], limit, triList));
		}

	}

	public static int getAnswer(int num, int limit, List<Integer> list) {
		for (int x = 0; x < limit; x++) {
			for (int y = x; y < limit; y++) {
				for (int z = y; z < limit; z++) {
//					System.out.printf("i:%d / j:%d / z:%d => ", x,y,z);
//					System.out.printf("%d + %d + %d = %d \n", list.get(x),list.get(y),list.get(z), list.get(x) + list.get(y) + list.get(z));
					if (list.get(x) + list.get(y) + list.get(z) == num) return 1;
					if (list.get(x) + list.get(y) + list.get(z) > num) 	break;
				}
			}
		}
		return 0;
	}
	
}

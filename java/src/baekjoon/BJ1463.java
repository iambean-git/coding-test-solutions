package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463 {
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        count = new int[N + 1];

        // Bottom-up 방식으로 계산
        for (int i = 2; i <= N; i++) {
            count[i] = count[i - 1] + 1; // 1을 빼는 경우 (항상 가능)

            if (i % 2 == 0) {
                count[i] = Math.min(count[i], count[i / 2] + 1); // 2로 나누는 경우
            }
            if (i % 3 == 0) {
                count[i] = Math.min(count[i], count[i / 3] + 1); // 3으로 나누는 경우
            }
        }

        System.out.println(count[N]);
    }
}
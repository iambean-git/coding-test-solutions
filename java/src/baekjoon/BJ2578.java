package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ2578 {
	static int N = 5;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<String> inputList = new ArrayList<>();

		// 내 빙고판
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (String str : tmp) {
				inputList.add(str);
			}
		}

		// 사회자가 불러주는 숫자를 칠하는 빙고판
		boolean[][] bingo = new boolean[N][N];
		boolean isBingoFinished = false;
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int idx = inputList.indexOf(tmp[j]);
				bingo[idx / 5][idx % 5] = true;
				if (check3bingo(bingo)) {
					isBingoFinished = true;
					System.out.println((i * 5) + (j + 1));
					break;
				}
			}
			if (isBingoFinished)	break;
		}

	}

	static boolean check3bingo(boolean[][] arr) {
//		System.out.println("가로빙고 :: " + checkRow(arr));
//		System.out.println("세로빙고 :: " + checkCol(arr));
//		System.out.println("대각선 빙고 :: " + checkDiagonal(arr));
		if (checkRow(arr) + checkCol(arr) + checkDiagonal(arr) >= 3)
			return true;
		return false;
	}

	// 가로 빙고 체크
	static int checkRow(boolean[][] arr) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!arr[i][j])
					break;
				if (j == N - 1)
					count++;
			}
		}
		return count;
	}

	// 세로 빙고 체크
	static int checkCol(boolean[][] arr) {
		int count = 0;
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (!arr[i][j])
					break;
				if (i == N - 1)
					count++;
			}
		}
		return count;
	}

	// 대각선 빙고 체크
	static int checkDiagonal(boolean[][] arr) {
		int count = 0;

		// 주대각선 (↘) 체크
		boolean mainDiagonal = true;
		for (int i = 0; i < N; i++) {
			if (!arr[i][i]) {
				mainDiagonal = false;
				break;
			}
		}
		if (mainDiagonal)
			count++;

		// 부대각선 (↙) 체크
		boolean subDiagonal = true;
		for (int i = 0; i < N; i++) {
			if (!arr[i][N - 1 - i]) {
				subDiagonal = false;
				break;
			}
		}
		if (subDiagonal)
			count++;

		return count;
	}
}

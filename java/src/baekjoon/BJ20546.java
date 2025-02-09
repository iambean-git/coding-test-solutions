package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ20546 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int money = Integer.parseInt(br.readLine());

        String input = br.readLine();
        // 공백 기준으로 문자열을 분리 후, int 배열로 변환
		String[] strArr = input.split(" ");
		int[] stockPrice = new int[14];

        for (int i = 0; i < 14; i++) {
        	stockPrice[i] = Integer.parseInt(strArr[i]); // 문자열을 정수로 변환
        }

        int bnp = getBNP(money, stockPrice);
        int timing = getTiming(money, stockPrice);
        
        if(bnp==timing)		System.out.println("SAMESAME");
        else if(bnp>timing) System.out.println("BNP");
        else 				System.out.println("TIMING");
	}
	
	//준현이 수익률 계산
	private static int getBNP(int money, int[] arr) {
		int change = money;
		int hasStock = 0;
		for(int i=0; i<arr.length; i++) {
			hasStock += change / arr[i];
			change %= arr[i];
			if(change==0)	break;
		}
		return change + hasStock * arr[arr.length-1];
	}
	
	//성민이 수익률 곗한
	private static int getTiming(int money, int[] arr) {
		int change = money;
		int hasStock = 0;
		int up = 0; int down = 0;
		
		for(int i=1; i<arr.length; i++) {
			//전날과 동일
			if(arr[i-1] == arr[i])	{
				down=0; up=0; continue;
				}
			// 전날대비 상승
			else if(arr[i-1] < arr[i] ) {
				up++;
				down = 0;
				if(up>=3) {
					change += hasStock * arr[i];
					hasStock = 0;
				}
			} 
			// 전날대비 하락
			else {
				down++;	up=0;
				if(down>=3) {
					hasStock += change / arr[i];
					change %= arr[i];
				}
			}
		}
		return change + hasStock * arr[arr.length-1];
	}
}

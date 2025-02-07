package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1018 {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String input = br.readLine();
      String[] MN = input.split(" ");
      int M = Integer.parseInt(MN[0]);
      int N = Integer.parseInt(MN[1]);
      
      String[] inputArr = new String[M];
      
      for(int i=0; i<M; i++) {
         inputArr[i] = br.readLine();
      }
      
      
      int minCount = 100;      
      for(int x=0; x<M-7; x++) {
         for(int y=0; y<N-7; y++) {
            char[] startNext = {'W', 'B'};
            
            int snIdx = 0;   int snIdx1 = 1;      // startNext 체크를 위한 인덱스         
            int count = 0;   int count1 = 0;
                   
            for(int i=x; i<x+8; i++) {
               for(int j=y; j<y+8; j++) {
//                  System.out.printf("%c & %c /",inputArr[i].charAt(j), startNext[snIdx]);
                  if(inputArr[i].charAt(j)!=startNext[snIdx])      count++;
//                  System.out.printf("%c & %c /",inputArr[i].charAt(j), startNext[snIdx1]);
                  if(inputArr[i].charAt(j)!=startNext[snIdx1])   count1++;

                  snIdx = (snIdx+1)%2; snIdx1 = (snIdx1+1)%2;
               }
               snIdx = (snIdx+1)%2; snIdx1 = (snIdx1+1)%2;
//               System.out.println();
            }
//            System.out.println("count : "+ count);
//            System.out.println("count1 : "+ count1);
            minCount = Math.min(Math.min(count, minCount), count1);
         }
      }
      System.out.println(minCount);
   }
}

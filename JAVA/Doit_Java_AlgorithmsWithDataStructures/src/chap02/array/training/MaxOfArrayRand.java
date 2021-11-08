package chap02.array.training;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {
	// 배열 a의 최댓값을 구하여 반환
		static int maxOf(int[] a) {
			int max = a[0];
			for(int i = 0; i < a.length; i++) {
				if(a[i] > max) {
					max = a[i];
				}
			}
			return max;
		}
		
		public static void main(String[] agrs) {
			Random rand = new Random();
			Scanner stdIn = new Scanner(System.in);
			
			System.out.println("키의 최댓값을 구합니다.");
			System.out.print("사람 수 :");
			int num = stdIn.nextInt();
			
			int[] height = new int[num];
			
			for(int i = 0; i < num; i++) {
											// 0~89 까지의 난수 생성
				height[i] = 100 + rand.nextInt(90); // 요소의 값을 난수로 결정 
				System.out.println("height["+i+"] :");
			}
			
			System.out.println("최댓값은 "+maxOf(height)+"입니다."); // 배열 변수 height의 값(참조)이 전달
		}
}

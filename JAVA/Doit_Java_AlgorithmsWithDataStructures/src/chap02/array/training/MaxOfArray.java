package chap02.array.training;

import java.util.Scanner;

public class MaxOfArray {
	// 배열 a의 최댓값을 구하여 반환
	static int maxOf(int[] a) { // int[] a = height; <- 매개변수는 실인수에서 초기화됨
								// main 메서드의 height와 메서드 maxOf의 a는 같은 배열 본체를 참조
		int max = a[0];
		for(int i = 0; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
	
	public static void main(String[] agrs) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 :");
		int num = stdIn.nextInt();
		
		int[] height = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.println("height["+i+"] :");
			height[i] = stdIn.nextInt();
		}
		
		System.out.println("최댓값은 "+maxOf(height)+"입니다."); // 배열 변수 height의 값(참조)이 전달
	}
}

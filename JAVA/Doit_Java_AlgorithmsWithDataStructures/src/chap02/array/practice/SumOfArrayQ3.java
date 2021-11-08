package chap02.array.practice;

import java.util.Scanner;

public class SumOfArrayQ3 {
	// 배열 요소의 모든 합계 구하기
	static int sumOf(int[] a) {
		int sum = 0;
		for (int j = 0; j < a.length; j++) {
			sum += a[j];
		}
		return sum ;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("요솟수 :");
		int num = stdIn.nextInt();

		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] :");
			x[i] = stdIn.nextInt();
		}

		System.out.println("합계 = " + sumOf(x));
	}
}

package chap01.mutipleLoops.practice;

import java.util.Scanner;

public class NumPiraQ17 {
	public static void spira(int n) {
		// 전체 행
		for (int i = 1; i <= n; i++) {
			int line = (i - 1) * 2 + 1;
			for(int j = 1; j <= n - i + 1; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= line; k++) {
				System.out.print(i % 10);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;
		do {
			System.out.print("몇 단 피라미드 입니까? : ");
			n = stdIn.nextInt();
		} while (n <= 0);

		spira(n); 
	}
}

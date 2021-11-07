package chap01.mutipleLoops.practice;

import java.util.Scanner;

public class TriangleQ15 {
	// 왼쪽 아래
	public static void triangleLB(int n) {
		System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// 왼쪽 위
	public static void triangleLU(int n) {
		System.out.println("왼쪽 위가 직각인 이등변 삼각형을 출력");
		for (int i = 1; i <= n; i++) {
			for (int j = n; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// 오른쪽 위
	public static void triangleRU(int n) {
		System.out.println("오른쪽 위가 직각인 이등변 삼각형을 출력");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i <= j) {
					System.out.print("*");
				}
				if (i > j) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	// 오른쪽 아래
	public static void triangleRB(int n) {
		System.out.println("오른쪽 아래가 직각인 이등변 삼각형을 출력");
		for (int i = 1; i <= n; i++) {
			for (int j = n; j > 0; j--) {
				if (i >= j) {
					System.out.print("*");
				}
				if (i < j) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;
		do {
			System.out.print("몇 단 삼각형 입니까? : ");
			n = stdIn.nextInt();
		} while (n <= 0);

		triangleLB(n);
		triangleLU(n);
		triangleRU(n);
		triangleRB(n);
	}
}
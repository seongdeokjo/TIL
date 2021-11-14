package chap06.shellSort.pratice;

import java.util.Scanner;

public class ShellSortEx1Q9 {
	// shell sort ver.1
	// 요소의 이동 횟수를 계산할 수 있도록 프로그램 작성
	// 셀 정렬
	static int shellSort(int[] a, int n) {
		int cnt = 0;
		for (int h = n / 2; h > 0; h /= 2) {
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
					a[j + h] = a[j];
					cnt++;
				}
				a[j + h] = tmp;
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("셸 정렬");
		System.out.print("요솟수 : ");
		int n = stdIn.nextInt();
		int[] x = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}

		int count = shellSort(x, n);

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < n; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
		System.out.println("총 요소의 이동 횟수는 ="+count);
	}
}

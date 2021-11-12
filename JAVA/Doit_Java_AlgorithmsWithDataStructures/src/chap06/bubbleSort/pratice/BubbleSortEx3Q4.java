package chap06.bubbleSort.pratice;

import java.util.Scanner;

public class BubbleSortEx3Q4 {
	// a[idx1]와 a[idx2]의 값을 바꾼다.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void bubbleSort(int[] a, int n) {
		int cnt = 0;
		int change = 0;

		int i = 1;
		int k = 0; // a[k] 보다 앞쪽은 정렬을 마친 상태
		while (k < n - 1) {
			System.out.printf("패스%d : \n", i++);
			int last = n - 1; // 마지막으로 요소를 교환한 위치
			for (int j = n - 1; j > k; j--) {
				for (int m = 0; m < n - 1; m++) {
					System.out.printf("%3d %2s", a[m], (m != j - 1) ? "" : (a[j - 1] > a[j]) ? "+" : "-");
				}
				System.out.printf("%3d\n", a[n - 1]);
				cnt++;
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					last = j;
					change++;
				}
			}
			k = last;
		}
		System.out.println("비교 : " + cnt + " / 교환 : " + change);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("버블 정렬");
		System.out.print("요솟수 : ");
		int n = stdIn.nextInt();
		int[] x = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}

		bubbleSort(x, n);

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < n; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
}

package chap06.bubbleSort.pratice;

import java.util.Scanner;

public class BubbleSortRQ1 {
	// a[idx1]와 a[idx2]의 값을 바꾼다.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 버블 정렬
	static void bubbleSort(int[] a, int n) {
		// a[n - 1], a[n -2],....., a[i] 에 대해
		for (int i = n - 1; i > 0; i--) {
			// 앞에서부터 끝쪽으로 스캔하면서 이웃하는 두 요소를 비교하고 교환한다.
			for (int j = 0; j < i; j++) {
				if (a[j + 1] < a[j]) {
					swap(a, j, j + 1);
				}
			}
		}
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
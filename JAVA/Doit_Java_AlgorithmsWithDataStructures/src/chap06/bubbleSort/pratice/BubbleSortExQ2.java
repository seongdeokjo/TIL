package chap06.bubbleSort.pratice;

import java.util.Scanner;

public class BubbleSortExQ2 {

	// a[idx1]와 a[idx2]의 값을 바꾼다.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 버블 정렬
	static void bubbleSort(int[] a, int n) {
		int cnt = 0;
		int change = 0;
		// a[i], a[i + 1], .... , a[n - 1]에 대해
		for (int i = 0; i < n - 1; i++) {
			// 끝에서부터 앞쪽으로 스캔하면서 이웃하는 두 요소를 비교하고 교환한다.
			System.out.println("패스" + (i + 1) + ":");
			for (int j = n - 1; j > i; j--) {
				for (int k = 0; k < n - 1; k++) {
					System.out.printf("%3d %2s",a[k],(k != j -1) ? "" : (a[j - 1] > a[j]) ? '+' : '-' );
				}
				System.out.printf("%3d\n",a[n - 1]);
				cnt++;
				if (a[j - 1] > a[j]) {
					change++;
					swap(a, j - 1, j);
				}
			}
			for(int m = 0; m < n; m++) {
				System.out.printf("%3d   ", a[m]);
			}
			System.out.println();
		}
		System.out.println("비교 : "+cnt + " / 교환 : "+change);
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

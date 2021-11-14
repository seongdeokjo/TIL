package chap06.quickSort.training;

import java.util.Scanner;

public class QuickSort1 {
	// 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}

	// 퀵 정렬(배열을 나누는 과정을 출력)
	static void quickSort(int[] a, int left, int right) {
		int pl = left; // 왼쪽 커서
		int pr = right; // 오른쪽 커서
		int x = a[(pl + pr) / 2];
		
		System.out.printf("a[%d]~a[%d] : {" ,left,right);
		for(int i = left; i < right; i++) {
			System.out.printf("%d, ",a[i]);
		}
		System.out.printf("%d}\n",a[right]);
		
		do {
			while (a[pl] < x) {
				pl++;
			}
			while (a[pr] > x) {
				pr--;
			}
			if (pl <= pr) {
				swap(a, pl++, pr--);
			}
		} while (pl <= pr);

		if (left < pr) {
			quickSort(a, left, pr);
		}
		if (pl < right) {
			quickSort(a, pl, right);
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("퀵 정렬");
		System.out.print("요솟수 : ");
		int n = stdIn.nextInt();
		int[] x = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		quickSort(x, 0, n - 1);
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < n; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
}

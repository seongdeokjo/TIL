package chap06.quickSort.practice;

import java.util.Scanner;

public class QuickSortEx1AQ12 {
	// 퀵 정렬 : 요소의 개수가 적은 그룹을 먼저 나누는 메서드로 수정

	// 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}

	// 퀵 정렬
	static void quickSort(int[] a, int left, int right) {
		int pl = left; // 왼쪽 커서
		int pr = right; // 오른쪽 커서
		int x = a[(pl + pr) / 2];
		System.out.println("1. x = "+x);
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
		System.out.println("pr - left = "+(pr-left)+" / right - pl = "+(right-pl));
		if(pr - left < right - pl) {
			int temp;
			temp = left;
			left = pl;
			temp = right;
			right = pr;
			pr = temp;
		}

		if (left < pr) {
			System.out.println("1. 요소의 개수가 많은 경우");
			quickSort(a, left, pr);
		}
		if (pl < right) {
			System.out.println("2. 요소의 개수가 적은 경우");
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

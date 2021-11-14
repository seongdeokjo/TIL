package chap06.quickSort.practice;

import java.util.Scanner;

import chap04.stack.training.IntStack;

public class QuickSortEx2BQ13 {
	// 퀵 정렬(비 재귀 버전)
	// 나눈 그룹의 요소 개수가 9개 이하이면 단순 삽입 정렬로 동작하는 메서드로 수정

	// 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	// 단순 삽입 정렬
	static void insertionSort(int[] a, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			int tmp = a[i];
			int j;
			for (j = i; j > 0 && a[j - 1] > tmp; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
	}

	// 퀵 정렬
	static void quickSort(int[] a, int left, int right) {
		IntStack lstack = new IntStack(right - left + 1); // 나눌 범위의 왼쪽 끝 요소의 인덱스를 저장하는 스택
		IntStack rstack = new IntStack(right - left + 1); // 나눌 범위의 오른쪽 끝 요소의 인덱스를 저장하는 스택

		lstack.push(left);
		rstack.push(right);

		while (lstack.isEmpty() != true) {
			int pl = left = lstack.pop();
			int pr = right = rstack.pop();
			int x = a[(pl + pr) / 2];
			if (right - left < 9) {
				insertionSort(a, left, right);
			} else {

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
				// 푸시 순서
				// 1. 요소의 개수가 많은 그룹을 먼저 푸시
				if (pr - left < right - pl) {
					int temp;
					temp = left;
					left = pl;
					temp = right;
					right = pr;
					pr = temp;
				}
				if (left < pr) {
					lstack.push(left); // 왼쪽 그룹 범위의
					rstack.push(pr); // 인덱스를 푸시
				}
				if (pl < right) {
					lstack.push(pl); // 오른쪽 그룹 범위의
					rstack.push(right); // 인덱스를 푸시
				}
			}
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
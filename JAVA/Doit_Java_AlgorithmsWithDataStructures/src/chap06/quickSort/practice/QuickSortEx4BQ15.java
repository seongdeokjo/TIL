package chap06.quickSort.practice;

import java.util.Scanner;

import chap04.stack.training.IntStack;

public class QuickSortEx4BQ15 {
	// 퀵 정렬(비 재귀 버전)
	// 나눈 그룹의 요소 개수가 9개 이하이면 단순 삽입 정렬로 동작하는 메서드로 수정
	// 방법 2. 머리/중앙/꼬리요소를 정렬하여 중앙값을 피벗으로 합니다. : 비재귀버전
	
	// 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	// x[a], x[b], x[c]를 sort (중앙값의 index를 반환)
	static int sort3Elem(int[] x, int a, int b, int c) {
		if (x[b] < x[a])
			swap(x, b, a);
		if (x[c] < x[b])
			swap(x, c, b);
		if (x[b] < x[a])
			swap(x, b, a);
		return b;
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
			
			if (right - left < 9) {
				insertionSort(a, left, right);
			} else {
				int x;	// 피벗
				int m = sort3Elem(a,pl,(pl + pr) / 2,pr);
				x = a[m];
				swap(a, m, right - 1);
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
package chap06.bubbleSort.training;

import java.util.Scanner;

public class BubbleSort2 {
	// 버블 정렬 ver.2

	// a[idx1]와 a[idx2]의 값을 바꾼다.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void bubbleSort(int[] a, int n) {
		for(int i = 0; i < n - 1; i++) {
			int exchg = 0;						// 패스의 교환 횟수를 기록
			for(int j = n - 1; j > i; j--) {
				if(a[j - 1] > a[j]) {
					swap(a, j -1, j);
					exchg++;
				}
			}
			System.out.println(exchg);
			if(exchg == 0) {					// 교환이 이루어지지 않으면 종료
				break;
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

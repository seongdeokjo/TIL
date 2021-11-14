package chap06.shellSort.training;

import java.util.Scanner;

public class ShellSort2 {
	// shell sort ver.2
	
	// 셸 정렬
	static void shellSort(int[] a, int n) {
		int h;
		for(h = 1; h < n / 9; h = h * 3 + 1) {	//	 h의 초깃값을 구한다. 1부터 시작하여 값을 3배하고 1을 더하면서 n/9를 넘지 않는 가장 큰 값을 h에 대입한다.
			;									
		}
		for(; h > 0; h /= 3) {					// h의 값이 변하는 방법(h 값을 3으로 나눈다). 반복하여 마지막에 h의 값은 1이 된다.
			for(int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for(j = i -h; j >= 0 && a[j] > tmp; j -= h) {
					a[j + h] = a[j];
				}
				a[j + h] = tmp;
			}
		}
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

		shellSort(x, n);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < n; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
}
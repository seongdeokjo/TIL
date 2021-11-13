package chap06.shellSort.training;

import java.util.Scanner;

public class ShellSort {
	// shell sort ver.1
	
	// 셀 정렬
	static void shellSort(int[] a, int n) {
		for(int h = n / 2; h > 0; h /= 2) {
			System.out.println("1. h = "+h);
			for(int i = h; i < n; i++) {
				System.out.println("2. i = "+i);
				int j;
				int tmp = a[i];
				System.out.println("3. tmp = "+tmp);
				for(j = i - h; j >= 0 && a[j] > tmp; j -= h) {
					System.out.println("4. j = "+j);
					a[j + h] = a[j];
					System.out.println("5. a["+(j+h)+"] = "+a[j]);
				} 
				System.out.println("6. j = "+j +" h = "+h);
				a[j + h] = tmp;
				System.out.println("7. a["+(j + h)+"] = "+tmp);
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

package chap06.insertionSort.practice;

import java.util.Scanner;

public class InsertionSortCenExQ7 {
	// 단순 삽입 정렬 (보초법 : 배열의 머리요소는 비어있다.)
		static void insertionSort(int[] a, int n) {
			for(int i = 2; i < n; i++) {
				int tmp = a[0] = a[i];
				int j = i;
				for(; a[j - 1] > tmp; j--) {
					a[j] = a[j - 1];
				}
				if(j > 0) {
					a[j] = tmp;
				}
				
			}
		}
		
		public static void main(String[] args) {
			Scanner stdIn = new Scanner(System.in);

			System.out.println("단순 삽입 정렬");
			System.out.print("요솟수 : ");
			int n = stdIn.nextInt();
			int[] x = new int[n+ 1]; // 1개 여분으로 생성

			for (int i = 1; i <= n; i++) {
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			}

			insertionSort(x, n);
			
			System.out.println("오름차순으로 정렬했습니다.");
			for (int i = 1; i <= n; i++) {
				System.out.println("x[" + i + "] = " + x[i]);
			}
		}
}

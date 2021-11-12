package chap06.selectionSort.training;

import java.util.Scanner;

public class SelectionSort {
	// 단순 선택 정렬
	// a[idx1]와 a[idx2]의 값을 바꾼다.
		static void swap(int[] a, int idx1, int idx2) {
			int t = a[idx1];
			a[idx1] = a[idx2];
			a[idx2] = t;
		}
		
		// 단순 선택 정렬
		 static void selectionSort(int[] a, int n) {
			for(int i = 0; i < n - 1; i++) {
				int min = i;					// 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 기록
				for(int j = i + 1; j < n; j++) {
					if(a[j] < a[min]) {
						min = j;
					}
				}
				swap(a, i, min);				// 아직 정렬되지 않은 부분의 첫 요소가 가장 작은 요소를 교환
			}
		}
		
		public static void main(String[] args) {
			Scanner stdIn = new Scanner(System.in);

			System.out.println("단순 선택 정렬");
			System.out.print("요솟수 : ");
			int n = stdIn.nextInt();
			int[] x = new int[n];

			for (int i = 0; i < n; i++) {
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			}

			selectionSort(x, n);
			
			System.out.println("오름차순으로 정렬했습니다.");
			for (int i = 0; i < n; i++) {
				System.out.println("x[" + i + "] = " + x[i]);
			}
		}
}

package chap06.mergeSort.training;

import java.util.Scanner;

public class MergeSort {
	// 병합 정렬
	
	static int[] buff;		// 작업용 배열
	
	// a[left]~a[right]를 재귀적으로 병합 정렬
	static void __mergeSort(int[] a, int left, int right) {
		if(left < right) {
			int i;
			int center = (left + right) / 2;
			int p = 0;
			int j = 0;
			int k = left;
		
			__mergeSort(a, left, center);		// 배열의 앞부분을 병합 정렬한다.
			__mergeSort(a, center + 1, right);	// 배열의 뒷부분을 병합 정렬한다.
			
			for(i = left; i <= center; i++) {	// 배열 a의 앞부분을 배열 buff에 복사 
				buff[p++] = a[i];
			}
			
			while(i <= right && j < p) {		// 배열 a의 뒷부분과 배열 buff를 배열 a에 병합한다.
				a[k++] = (buff[j] <= a[i])	? buff[j++] : a[i++];
			}
			
			while(j < p) {						// 배열 buff의 나머지 요소를 배열 a에 복사한다.
				a[k++] = buff[j++];
			}
		}
	}
	
	// 병합 정렬
	static void mergeSort(int[] a, int n) {
		buff = new int[n];		// 작업용 배열을 생성
		
		__mergeSort(a, 0, n - 1);	// 배열 전체를 병합 정렬
		
		buff = null;			// 작업용 배열을 해체한다.
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("병합 정렬");
		System.out.print("요솟수 : ");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = stdIn.nextInt();
		}
		
		mergeSort(x,n);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < n; i++) {
			System.out.println("x["+i+"] : "+x[i]);
		}
	}
}
package chap06.frequencySort.training;

import java.util.Scanner;

public class FSort {
	// 도수 정렬
	
	// 도수 정렬(0 이상 max 이하의 값을 입력)
	static void fSort(int[] a, int n, int max) {
		int[] f = new int[max + 1];	// 누적 도수
		int[] b = new int[n];		// 작업용 목적 배열
		
		for(int i = 0; i < n; i++) {
			f[a[i]]++;		// 1단계
		}
		for(int i = 1; i <= max; i++) {
			f[i] += f[i - 1];	// 2단계
		}
		for(int i = n - 1; i >= 0; i--) {
			b[--f[a[i]]] = a[i];	// 3단계
		}
		for(int i = 0; i < n; i++) {
			a[i] = b[i];			// 4단계
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("도수 정렬");
		System.out.print("요솟 수 : ");
		int n = stdIn.nextInt();
		int[] x	= new int[n];
		
		for(int i = 0; i < n; i++) {
			do {
				System.out.print("a["+i+"] : ");
				x[i] = stdIn.nextInt();
			}while(x[i] < 0);
		}
		
		int max = x[0];
		for(int i = 1; i < n; i++) {
			if(x[i] > max) {
				max = x[i];
			}
		}
		
		fSort(x,n,max);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < n; i++) {
			System.out.println("x["+i+"] = "+x[i]);
		}
	
	}
}
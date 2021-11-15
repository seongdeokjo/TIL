package chap06.heapSort.training;

import java.util.Scanner;

public class HeapSort {
	// 힙 정렬
	
	// 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	// a[left] ~ a[right]를 힙으로 만듭니다.
	static void downHeap(int[] a, int left, int right) {
		int temp = a[left]; 	// 루트
		int child; 				// 큰 값을 가진 노드
		int parent;				// 부모
		System.out.println("donwHeap 호출 : left = "+left + " right = "+right +" temp = "+temp);
		for(parent = left; parent < (right + 1) / 2; parent = child) {
			int cl = parent * 2 + 1;			// 왼쪽 자식
			int cr = cl + 1;					// 오른쪽 자식
			System.out.println("downHeap : cl = "+cl+" cr = "+cr);
			child = (cr <= right && a[cr] > a[cl]) ? cr : cl;		// 큰 값을 가진 노드를 자식에 대입
			System.out.println("downHeap : child = "+child);
			if(temp >= a[child]) {
				break;
			}
			a[parent] = a[child];
			System.out.println("downHeap : child = "+child);
			System.out.println("downHeap a[parent] = a[child] == >a["+parent+"] = "+a[parent]);
		}
		System.out.println("parent = "+parent);
		a[parent] = temp;
		System.out.println("downHeap a[parent] = temp ==> a["+parent+"] = "+a[parent]);
	}
	
	// 힙 정렬
	static void heapSort(int[] a, int n) {
		for(int i = (n - 1) / 2; i >= 0; i--) {				// a[i] ~ a[n - 1]를 힙으로 만들기
			System.out.println("1. heapSort -> downHeap 만들기 : i = "+i+" n - 1 = "+(n-1));
			downHeap(a, i, n - 1);
			System.out.println("---------------------------------------------------------");
		}
		for(int i = 0; i < n; i++) {
			System.out.print("a["+i+"] = "+a[i]+" ");
		}
		System.out.println();
		
		for(int i = n - 1; i > 0; i--) {
			System.out.println("2. heapSort -> swap 호출 : i = "+i);
			swap(a, 0, i);									// 가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환
			System.out.println("2. heapSort -> downHeap 만들기 : i -1 = "+(i - 1));
			downHeap(a, 0, i - 1);							// a[0] ~ a[i - 1]을 힙으로 만든다.
			System.out.println("=========================================================");
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("힙 정렬");
		System.out.print("요솟수 : ");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = stdIn.nextInt();
		}
		
		heapSort(x,n);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < n; i++) {
			System.out.println("x["+i+"] = "+x[i]);
		}
		
	}
	
	
}

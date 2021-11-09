package chap03.searchingAlgorithm.binarySearch.training;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {
	// 기본 자료형 배열에서 binarySearch 메서드로 이진 검색
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num];
		System.out.println("오름차순으로 입력");
		
		System.out.print("x[0] : ");
		x[0] = stdIn.nextInt();
		
		for(int i = 1; i < num; i++) {
			do {
				System.out.print("x["+i+"]");
				x[i] = stdIn.nextInt();
			}while(x[i] < x[i -1]);
		}
		
		System.out.print("검색할 값 : ");
		int ky = stdIn.nextInt();
		
		int idx = Arrays.binarySearch(x, ky); // 간단한 방법으로 검색할 수 있는 이유는 String클래스가 Comparable<T> 인터페이스와 compareTo메서드를 구현하고 있기 때문이다.
		
		if(idx < 0) {
			System.out.println("그 값의 요소가 없다.");
		}else {
			System.out.println(ky+"는 x["+idx+"]에 있습니다.");
		}
	}
}

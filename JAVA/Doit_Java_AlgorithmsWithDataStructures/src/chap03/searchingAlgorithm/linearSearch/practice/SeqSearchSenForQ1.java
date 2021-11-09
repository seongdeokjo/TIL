package chap03.searchingAlgorithm.linearSearch.practice;

import java.util.Scanner;

public class SeqSearchSenForQ1 {
	//선형 검색(보초법)
	
	// 요솟수가 n인 배열 a에서 key와 같은 요소를 보초법으로 선형 검색
	// while -> for문으로 변경
	static int seqSearchSen(int[] a, int n, int key) {
		int i;
		
		a[n] = key; // 보초를 추가
		
		for(i = 0; a[i] != key; i++);
		
		return i == n ? -1 : i; 	
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num + 1]; // 요솟수 num + 1
		
		for(int i =0; i < num; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = stdIn.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int ky = stdIn.nextInt();
		
		int idx = seqSearchSen(x, num, ky);
		
		if(idx == -1) {
			System.out.println("그 값의 요소가 없다.");
		}else {
			System.out.println(ky+"는 x["+idx+"]에 있다.");
		}
	}
}

package chap02.array.training;

import java.util.Scanner;

public class ArrayEqual {
	// 두 배열 a,b의 모든 요소가 같은가?
	static boolean equals(int[] a, int[] b) {
		if(a.length != b.length) {
			return false;
		}
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("배열 a의 요솟수 : ");
		int na = stdIn.nextInt();
		
		int[] a = new int[na];
		
		for(int i = 0; i < na; i++) {
			System.out.println("a["+i+"] : ");
			a[i] = stdIn.nextInt();
		}
		
		System.out.print("배열 b의 요솟수 : ");
		int nb = stdIn.nextInt();
		
		int[] b = new int[nb];
		
		for(int i = 0; i < nb; i++) {
			System.out.println("b["+i+"] : ");
			b[i] = stdIn.nextInt();
		}
		
		System.out.println("배열 a와 b는 "+ (equals(a, b) ? "같다." : "같지 않다."));
	}
}

package chap06.mergeSort.training;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysSortTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟 수 : ");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = stdIn.nextInt();
		}
		
		Arrays.sort(x);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < n; i++) {
			System.out.println("x["+i+"] : "+x[i]);
		}
	}
}

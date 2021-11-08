package chap02.array.practice;

import java.util.Scanner;

public class CopyArrayQ4 {
	// 배열 b의 요소를 배열 a에 복사
		static void copy(int[] a, int[] b) {
			int num = a.length <= b.length ? a.length : b.length;
			System.out.println("배열을 복사합니다.");
			print(a);
			for(int i = 0; i < num; i++) {
				a[i] = b[i];
			}
			System.out.println("복사 후 ");
			print(a);
		}
		
		static void print(int[] n) {
			for(int i = 0; i < n.length; i++) {
				System.out.print(n[i]+" ");
			}
			System.out.println();
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
			
			copy(a, b);
			
		}
}

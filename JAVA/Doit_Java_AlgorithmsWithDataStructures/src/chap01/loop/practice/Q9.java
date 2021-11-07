package chap01.loop.practice;

import java.util.Scanner;

public class Q9 {
	// 정수 a,b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 아래 메서드를 작성
	// a,b 대소 관계에 상관없이 합을 구한다.
	public static int sumOf(int a, int b) {
		int sum  = 0;
		int min;
		int max;
		if(a < b) {
			min = a;
			max = b;
		}else {
			min = b;
			max = a;
		}
		for(int i = min; i <= max; i++) {
			sum += i;
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("a, b 사이의 모든 정수의 합을 구한다.");
		System.out.print("a의 값：");
		int a = stdIn.nextInt();
		System.out.print("b의 값：");
		int b = stdIn.nextInt();
		System.out.println("모든 정수의 합 = "+ sumOf(a, b));
	}
}

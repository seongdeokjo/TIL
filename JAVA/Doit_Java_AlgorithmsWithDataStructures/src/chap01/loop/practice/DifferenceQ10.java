package chap01.loop.practice;

import java.util.Scanner;

public class DifferenceQ10 {
	// a,b 정수를 입력하고 b - a를 출력하는 프로그램 작성
	// b 가 a 보다 큰 값을 입력받도록
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("a 의 값 :");
		int a = stdIn.nextInt();
		
		int b = 0;
		while(true) {
			System.out.print("b의 값 :");
			b = stdIn.nextInt();
			if(b > a) {
				break;
			}
			System.out.println("a 보다 큰 값을 입력하세요.");
		}
		System.out.println("b - a = "+(b - a));
		
	}
}

package chap01.loop.practice;

import java.util.Scanner;

public class Q11 {
	// 양의 정수를 입력하고 자릿수를 출력하는 프로그램을 작성
	// ex) 135 -> 그 수는 3자리 
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("양의 정수값의 자릿수를 구합니다.");
		int n;
		do {
			System.out.print("정수 값 : ");
			n = stdIn.nextInt();
		}while(n <= 0);
		
		int no = 0; // 자릿 수
		while(n > 0) {
			n /= 10;
			no++;
		}
		System.out.println("그 수는 "+ no +"자리입니다.");
	}
}

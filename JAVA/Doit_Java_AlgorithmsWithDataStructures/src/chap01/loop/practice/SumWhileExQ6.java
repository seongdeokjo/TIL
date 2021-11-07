package chap01.loop.practice;

import java.util.Scanner;

public class SumWhileExQ6 {
	// 실습 1-4에서 while문이 종료될 때 변수 i 값이 n + 1 이 됨을 확인할 것.
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.println("n의 값: ");
		int n = stdIn.nextInt();
		
		int sum = 0; // 합
		int i = 1;
		while(i <= n) { // i가 n 이하면 반복
			sum += i; // sum에 i를 더함
			i++; 	 // i 값을 1만큼 증가
		}
		System.out.println("i = "+i); // if n = 5 -> i = 6
	}
}

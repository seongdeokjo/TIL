package chap05.recursive.practice;

import java.util.Scanner;

public class FactorialExQ1 {
	// 재귀 메서드 호출을 사용하지 않고 factorial 메서드를 작성하기
	
	static int factorial(int n) {
		int multiple = 1;
		for(int i = 1; i <= n; i++) {
			multiple *= i;
		}
		return multiple;
		// while 문 이용
//		int fact = 1;
//
//		while (n > 1)
//			fact *= n--;
//		return (fact);
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수값을 입력하세요. :");
		int num = stdIn.nextInt();
		
		System.out.println("팩토리얼 값은 "+factorial(num)+"입니다.");
	}
}

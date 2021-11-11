package chap05.recursive.training;

import java.util.Scanner;

public class RecurX1 {
	// 꼬리 재귀를 제거
	static void recur(int n) {
		if(n > 0) {
			recur(n - 1);				// 재귀 메서드를 제거하기 위해서는 현재 n의 값을 '잠시' 저장해야한다. -> 처리가 완료되면 저장했던 n을 다시 꺼내 그 값을 출력한다.
			System.out.print(n + " ");
//			recur(n - 2); -> 인자로 n-2를 전달하여 recur 메서드를 호출한다. -> n의 값을 n-2로 업데이트하고 메서드의 시작 시점으로 돌아간다.
			n = n - 2; // 꼬리 재귀(tail recursion) 제거
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요. : ");
		int x = stdIn.nextInt();
		
		recur(x);
	}
}

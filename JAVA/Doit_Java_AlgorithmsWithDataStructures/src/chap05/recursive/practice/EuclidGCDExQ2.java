package chap05.recursive.practice;

import java.util.Scanner;

public class EuclidGCDExQ2 {
	// 재귀 메서드 호출을 사용하지 않고 gcd메서드를 작성
	static int gcd(int x, int y) {
		while(y != 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}
	

	
	
}

package chap05.recursive.practice;

import java.util.Scanner;

public class GCDArrayQ3 {
	// 재귀 메서드 호출을 사용하지 않고 gcd메서드를 작성
		static int gcd(int x, int y) {
			System.out.println("gcd method 호출");
			System.out.println("start : "+x + " / start+1 : "+y);
			while(y != 0) {
				int temp = y;
				y = x % y;
				x = temp;
			}
			return x;
		}
	
	// 배열 a의 모든 요소의 최대 공약수를 구하는 메서드
	static int gcdArray(int[] a, int start, int no) {
		System.out.println("gcdArray method 호출");
		System.out.println("start : "+start+" / no : "+no);
		if(no == 1) {
			return a[start];
		}else if(no == 2) {
			return gcd(a[start],a[start+1]);
		}else {
			System.out.println("no 3개 이상");
			return gcd(a[start],gcdArray(a,start + 1, no - 1));
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("배열의 최대공약수를 구합니다.");
		System.out.print("배열의 크기를 입력하세요. : ");
		int num = stdIn.nextInt();
		int[] x = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = stdIn.nextInt();
		}
		
		System.out.println("배열의 최대 공약수는 "+gcdArray(x, 0, num) + "입니다.");
	}
}

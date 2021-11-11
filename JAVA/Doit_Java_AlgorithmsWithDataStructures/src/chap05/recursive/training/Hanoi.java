package chap05.recursive.training;

import java.util.Scanner;

public class Hanoi {
	// 하노이의 탑
	
	// no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
	static void move(int no, int x, int y) {
		System.out.println("1. no = "+no+" x = "+x + " y = "+y);
		if(no > 1) {
			System.out.println("-------------------1----------------");
			move(no - 1, x, 6 - x - y);
		}
		
		System.out.println("원반["+no+"]을 "+x+"기둥에서 "+y+"기둥으로 옮김");
		System.out.println("2. no = "+no+" x = "+x + " y = "+y);
		
		if(no > 1) {
			System.out.println("--------------------2----------------");
			move(no - 1, 6 - x - y, y);
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("하노이의 탑");
		System.out.print("원반 개수 : ");
		int n = stdIn.nextInt();
		
		move(n, 1, 3);
	}
}

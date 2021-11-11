package chap05.recursive.practice;

import java.util.Scanner;


public class RecurX3Q5 {
	// 메소드 recur의 비재귀적 구현
	static void recur3(int x) {
		int[] nstk = new int[100];
		int[] sstk = new int[100];
		int ptr = -1;
		int sw = 0;
		
		while(true) {
			if(x > 0) {
				ptr++;
				nstk[ptr] = x;
				sstk[ptr] = sw;
				
				if(sw == 0) {
					x = x - 1;
				}else if(sw == 1) {
					x = x - 2;
					sw = 0;
				}
				continue;
			}
			do {
				x = nstk[ptr];
				sw = sstk[ptr--] + 1;
				
				if(sw == 2) {
					System.out.println(x);
					if(ptr < 0) {
						return;
					}
				}
			}while(sw == 2);
		}
		
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요. : ");
		int x = stdIn.nextInt();
		
		recur3(x);
	}
}

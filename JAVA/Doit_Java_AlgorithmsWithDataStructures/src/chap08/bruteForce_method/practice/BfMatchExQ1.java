package chap08.bruteForce_method.practice;

import java.util.Scanner;

public class BfMatchExQ1 {
	// 브루트-포스법에 의한 문자열 검색(조사과정)
	// 브루트-포스법으로 문자열을 검색하는 메서드
	static int bfMatch(String txt, String pattern) {
		int pt = 0; // txt 커서
		int pp = 0; // pattern 커서
		int cnt = 0; // 카운트
		int k = -1;
		while (pt != txt.length() && pp != pattern.length()) {
			if (k == pt - pp) {
				System.out.print("  ");
			} else {
				System.out.printf("%2d ", pt - pp);
				k = pt - pp;
			}
			for(int i = 0; i < txt.length(); i++) {
				System.out.print(txt.charAt(i)+ " ");
			}
			System.out.println();
			for (int i = 0; i < pt * 2 + 4; i++) {
				System.out.print(" ");
			}
			System.out.print(txt.charAt(pt) == pattern.charAt(pp) ? '+' : '|');
			System.out.println();
			for (int i = 0; i < (pt - pp) * 2 + 4; i++) {
				System.out.print(" ");
			}
			for (int i = 0; i < pattern.length(); i++) {
				System.out.print(pattern.charAt(i) + " ");
			}
			System.out.println();
			System.out.println();
			cnt++;

			if (txt.charAt(pt) == pattern.charAt(pp)) {
				pt++;
				pp++;
			} else {
				pt = pt - pp + 1;
				pp = 0;
			}
		}
		System.out.printf("비교는 %d 회였습니다.\n",cnt);
		if (pp == pattern.length()) { // 검색 성공
			return pt - pp;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("텍스트");
		String s1 = stdIn.next();

		System.out.print("패턴");
		String s2 = stdIn.next();

		int idx = bfMatch(s1, s2);
		System.out.println("idx = " + idx);

		if (idx == -1) {
			System.out.println("텍스트에 패턴이 없습니다.");
		} else {
			int len = 0;
			for (int i = 0; i < idx; i++) {
				len += s1.substring(i, i + 1).getBytes().length;
			}
			len += s2.length();

			System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
			System.out.println("텍스트 :" + s1);
			System.out.printf(String.format("패턴 : %%%ds\n", len), s2);
		}
	}
}

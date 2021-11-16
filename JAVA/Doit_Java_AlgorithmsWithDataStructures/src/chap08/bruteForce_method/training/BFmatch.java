package chap08.bruteForce_method.training;

import java.util.Scanner;

public class BFmatch {
	// 브루트-포스법으로 문자열을 검색하는 프로그램

	// 브루트-포스법으로 문자열을 검색하는 메서드
	static int bfMatch(String txt, String pattern) {
		int pt = 0; // txt 커서
		int pp = 0; // pattern 커서

		while (pt != txt.length() && pp != pattern.length()) {
			if (txt.charAt(pt) == pattern.charAt(pp)) {
				pt++;
				pp++;
				System.out.println("일치하는 경우 : pp = "+pp+" / pt = "+pt);
			} else {
				pt = pt - pp + 1;
				System.out.println("일치하지 않는 경우 pt = "+pt);
				pp = 0;
			}
		}
		if (pp == pattern.length()) { // 검색 성공
			System.out.println("pt - pp = "+(pt - pp));
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
		System.out.println("idx = "+idx);
		
		if(idx == -1) {
			System.out.println("텍스트에 패턴이 없습니다.");
		}else {
			int len = 0;
			for(int i = 0; i < idx; i++) {
				len += s1.substring(i, i + 1).getBytes().length;
				System.out.println("1. len = "+len+" / i = "+i);
			}
			len += s2.length();
			System.out.println("2. len = "+len);
			
			System.out.println((idx + 1)+"번째 문자부터 일치합니다.");
			System.out.println("텍스트 :"+s1);
			System.out.printf(String.format("패턴 : %%%ds\n", len),s2);
		}
	}
}
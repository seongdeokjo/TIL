package chap08.bruteForce_method.practice;

import java.util.Scanner;

public class BfMatchRevQ2 {
	// 가장 뒤쪽의 인덱스를 반환하는 메스드를 작성
	static int bfMatchLast(String txt, String pat) {
		int pt = txt.length() - 1;
		int pp = pat.length() - 1;
		while (pt >= 0 && pp >= 0) {
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt--;
				pp--;
			} else {
				pt = pt + (pat.length() - pp) - 2;
				pp = pat.length() - 1;
			}
		}
		if (pp < 0) {
			return pt + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("텍스트：");
		String s1 = stdIn.next(); // 텍스트용 문자열

		System.out.print("패턴：");
		String s2 = stdIn.next(); // 패턴용 문자열

		int idx = bfMatchLast(s1, s2); // 문자열 s1에서 문자열 s2를 브루트-포스법으로 검색

		if (idx == -1)
			System.out.println("텍스트에 패턴이 없습니다.");
		else {
			int len = 0;
			for (int i = 0; i < idx; i++)
				len += s1.substring(i, i + 1).getBytes().length;
			len += s2.length();

			System.out.println((idx + 1) + "번째 문자와 일치합니다.");
			System.out.println("텍스트：" + s1);
			System.out.printf(String.format("패턴：%%%ds\n", len), s2);
		}
	}

}

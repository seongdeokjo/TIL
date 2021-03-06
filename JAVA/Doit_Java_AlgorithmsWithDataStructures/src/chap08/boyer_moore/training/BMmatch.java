package chap08.boyer_moore.training;

import java.util.Scanner;

public class BMmatch {
	// boyer-moore법으로 문자열 검색
	static int bmMatch(String txt, String pat) {
		int pt;
		int pp;
		int txtLen = txt.length();
		int patLen = pat.length();
		int[] skip = new int[Character.MAX_VALUE + 1]; // Character.MAX_VALUE -> char형으로 나타낼 수 있는 문자 수
		
		// 건너뛰기 표 만들기
		for(pt = 0; pt <= Character.MAX_VALUE; pt++) {
			skip[pt] = patLen;					
		}
		for(pt = 0; pt < patLen - 1; pt++) {
			skip[pat.charAt(pt)] = patLen - pt - 1;		// pt == patLen - 1
			System.out.println("patLen - pt - 1 = "+(patLen - pt - 1));
			System.out.println("skip["+pat.charAt(pt)+"] = "+skip[pat.charAt(pt)]);
		}
		
		// 검색
		while(pt < txtLen) {
			System.out.println("검색 ----------------------------");
			pp = patLen - 1;		// pat의 끝 문자에 주목
			System.out.println("1. pp = "+pp +", pt = "+pt);
			while(txt.charAt(pt) == pat.charAt(pp)) {
				System.out.println("txt.charAt("+pt+") = "+txt.charAt(pt)+", pat.charAt("+pp+") = "+pat.charAt(pp));
				if(pp == 0) {
					System.out.println("2. pt = "+pt);
					return pt;
				}
				pp--;
				pt--;
				System.out.println("3. pp = "+pp + ", pt = "+pt);
			}
			System.out.println("skip[txt.charAt("+pt+")] = "+skip[txt.charAt(pt)]+",  patLen - pp = "+(patLen - pp));
			pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
			System.out.println("4. pt = "+pt);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("텍스트：");
		String s1 = stdIn.next(); 					// 텍스트용 문자열 

		System.out.print("패턴：");
		String s2 = stdIn.next();					// 패턴용 문자열 

		int idx = bmMatch(s1, s2);	// 문자열 s1에서 문자열 s2를 BM법으로 검색

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
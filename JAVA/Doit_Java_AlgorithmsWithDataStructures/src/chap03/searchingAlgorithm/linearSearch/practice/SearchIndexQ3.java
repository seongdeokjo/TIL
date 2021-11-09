package chap03.searchingAlgorithm.linearSearch.practice;

import java.util.Scanner;

public class SearchIndexQ3 {
	// 요솟수가 n인 배열 a에서 key와 일치하는 모든 요소의 인덱스를 배열 idx의 맨 앞부터 순서대로 저장하고,
	// 일치한 요솟수를 반환하는 메서드를 작성하세요.

	static int SearchIndex(int[] a, int n, int key, int[] idx) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == key) {
				idx[count++] = i;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("요솟수 : ");
		int n = stdIn.nextInt();
		int[] a = new int[n];
		int[] idx = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}

		System.out.print("검색할 값 : ");
		int ky = stdIn.nextInt();

		int count = SearchIndex(a, n, ky, idx);
		if (count == 0) {
			System.out.println("해당 key를 찾지 못했습니다.");
		} else {
			System.out.println("총 발견한 갯 수는 " + count + "개 입니다.");
		}
		for(int i = 0; i < count; i++) {
			System.out.println("그 값은 x["+idx[i]+"]번에 있습니다.");
		}
	}
}

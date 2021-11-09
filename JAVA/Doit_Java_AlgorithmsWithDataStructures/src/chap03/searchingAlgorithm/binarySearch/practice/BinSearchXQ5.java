package chap03.searchingAlgorithm.binarySearch.practice;

import java.util.Scanner;

public class BinSearchXQ5 {
	// 이진 검색
	// 같은 값을 갖는 요소가 하나 이상일 경우 그 요소 중에서 맨 앞의 요소를 찾는 메서드를 작성

	// 요솟수가 n인 배열 a에서 key와 같은 요소를 이진 검색
	static int binSearchX(int[] a, int n, int key) {
		int pl = 0; // 검색 범위의 첫 인덱스
		int pr = n - 1; // 검색 범위의 끝 인덱스

		do {
			int pc = (pl + pr) / 2;
			if (a[pc] == key) {
				for(; pc > pl; pc--) {
					if(a[pc -1] < key) {
						break;
					}
				}
				return pc;
			} else if (a[pc] < key) {
				pl = pc + 1; // 검색 범위를 뒤쪽 절반으로 좁힘
			} else {
				pr = pc - 1; // 검색 범위를 앞쪽 절반으로 좁힘
			}
		} while (pl <= pr);

		return -1; // 검색 실패
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("요솟 수 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num];

		System.out.println("오름차순으로 입력하세요.");

		System.out.print("x[0] : "); // 첫 요소 입력
		x[0] = stdIn.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			} while (x[i] < x[i - 1]); // 바로 앞의 요소보다 작으면 다시 입력
		}

		System.out.print("검색할 값 : ");
		int ky = stdIn.nextInt();

		int idx = binSearchX(x, num, ky); // 배열 x에서 키 값이 ky인 요소를 입력

		if (idx == -1) {
			System.out.println("그 값의 요소가 없습니다.");
		} else {
			System.out.println(ky + "의 맨 앞 인덱스 값은 x[" + idx + "]에 있습니다.");
		}
	}
}

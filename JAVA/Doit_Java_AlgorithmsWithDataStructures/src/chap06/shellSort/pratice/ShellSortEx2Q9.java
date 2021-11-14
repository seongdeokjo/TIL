package chap06.shellSort.pratice;

import java.util.Scanner;

public class ShellSortEx2Q9 {
	// shell sort ver.2
	// 요소의 이동 횟수를 계산할 수 있도록 프로그램 작성
	// 셸 정렬
	static int shellSort(int[] a, int n) {
		int h;
		int cnt = 0;
		for (h = 1; h < n / 9; h = h * 3 + 1) { // h의 초깃값을 구한다. 1부터 시작하여 값을 3배하고 1을 더하면서 n/9를 넘지 않는 가장 큰 값을 h에 대입한다.
			;
		}
		System.out.println("1. h = "+h);
		for (; h > 0; h /= 3) { // h의 값이 변하는 방법(h 값을 3으로 나눈다). 반복하여 마지막에 h의 값은 1이 된다.
			System.out.println("2. h = "+h);
			System.out.println("------------------------------");
			for (int i = h; i < n; i++) {
				System.out.println("3. h = i = "+i);
				int j;
				int tmp = a[i];
				System.out.println("4. tmp = "+tmp);
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
					System.out.println("5. j = "+j);
					a[j + h] = a[j];
					cnt++;
				}
				a[j + h] = tmp;
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("셸 정렬");
		System.out.print("요솟수 : ");
		int n = stdIn.nextInt();
		int[] x = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}

		int count = shellSort(x, n);

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < n; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
		System.out.println("총 이동횟수는 = " + count);
	}
}

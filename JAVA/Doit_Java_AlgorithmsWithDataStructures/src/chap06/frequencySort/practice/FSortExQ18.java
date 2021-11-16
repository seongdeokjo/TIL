package chap06.frequencySort.practice;

import java.util.Scanner;

public class FSortExQ18 {
	// 도수 정렬의 각 단계(for문)에서 배열 a, b, f의 요솟값의 변화를 출력하는 프로그램을 작성

	// 도수 정렬(배열 요솟값은 0 이상 max 이하)
	static void fSort(int[] a, int n, int max) {
		int[] f = new int[max + 1]; // 누적 도수
		int[] b = new int[n]; // 작업용 목적 배열

		System.out.println("1단계 : 도수분포표 만들기");
		for (int i = 0; i < n; i++) {
			for (int k = 0; k <= max; k++) {
				System.out.printf("%3d", f[k]);
			}
			System.out.println();
			f[a[i]]++;
		}
		for (int k = 0; k <= max; k++) {
			System.out.printf("%3d", f[k]);
		}
		System.out.println();

		System.out.println("2단계 : 누적도수분포표 만들기");
		for (int i = 1; i <= max; i++) {
			for (int k = 0; k <= max; k++) {
				System.out.printf("%3d", f[k]);
			}
			System.out.println();

			f[i] += f[i - 1];
		}
		for (int k = 0; k <= max; k++) {
			System.out.printf("%3d", f[k]);
		}
		System.out.println();

		System.out.println("3단계 : 정렬");
		for (int i = n - 1; i >= 0; i--) {
			for (int k = 0; k <= max; k++) {
				System.out.printf("%3d", f[k]);
			}
			System.out.println();
			b[--f[a[i]]] = a[i];
		}
		for (int k = 0; k <= max; k++) {
			System.out.printf("%3d", f[k]);
		}
		System.out.println();

		System.out.println("4단계 : 배열복사");
		for (int i = 0; i < n; i++) {
			a[i] = b[i];
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("도수정렬 ");
		System.out.print("요솟수：");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			do {
				System.out.print("x[" + i + "]：");
				x[i] = stdIn.nextInt();
			} while (x[i] < 0);
		}

		int max = x[0];
		for (int i = 1; i < nx; i++)
			if (x[i] > max)
				max = x[i];

		fSort(x, nx, max); // 배열 x를 도수정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}

}

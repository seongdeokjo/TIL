package chap05.recursive.practice;

public class EightQueenNQ9 {
	static boolean[] flag_a = new boolean[8]; // 각 행에 퀸을 배치했는지 체크
	static boolean[] flag_b = new boolean[15]; // / 대각선 방향으로 퀸을 배치했는지 체크
	static boolean[] flag_c = new boolean[15]; // \ 대각선 방향으로 퀸을 배치했는지 체크
	static int[] pos = new int[8]; // 각 열의 퀸의 위치

	// 각 열의 퀸의 위치를 출력
	static void print() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.printf("%s", j == pos[i] ? "■" : "□");
			}
			System.out.println();
		}
		System.out.println();
	}

	// i열의 알맞은 위치에 퀸을 배치
	static void set(int i) {
		int j;
		int[] jstk = new int[8];

		Start: while (true) {
			j = 0;
			while (true) {
				while (j < 8) {
					if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) {
						pos[i] = j;
						if (i == 7) {
							print();
						} else {
							flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
							jstk[i++] = j; // i열의 행을 push
							continue Start;
						}
					}
					j++;
				}
				if (--i == -1) {
					return;
				}
				j = jstk[i]; // i열의 행을 pop
				flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		set(0);
	}
}

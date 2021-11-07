package chap01.mutipleLoops.practice;

public class Add99TableExQ13 {
	public static void main(String[] args) {
		System.out.print("   |");
		for (int k = 1; k <= 9; k++) {
			System.out.printf("%3d", k);
		}
		System.out.print("\n---+---------------------------------");
		System.out.println();
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%2d |",i);
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%3d", i + j);
			}
			System.out.println();
		}
	}
}

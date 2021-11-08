package chap02.multiDimensionalArray.training;

public class Int2DArray {
	// 2행 4열의 2차원 배열
	public static void main(String[] args) {
		int[][] x = new int[2][4]; // 2차원 배열을 선언
		
		x[0][1] = 37;
		x[0][3] = 54;
		x[1][2] = 55;
		
		for(int i =0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.println("x["+i+"] ["+j+"] = "+ x[i][j]);
			}
		}
	}
}

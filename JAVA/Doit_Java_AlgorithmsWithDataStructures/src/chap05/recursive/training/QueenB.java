package chap05.recursive.training;

// 각 열에 1개의 퀸을 배치하는 조합을 재귀적으로 나열
// 가지 뻗기(branching)
// 문제를 세분하고 세분된 작은 문제의 풀이를 결합해 전체 문제를 풀이하는 기법 : 분할 정복법(divide and conquer)
public class QueenB {
	static int[] pos = new int[8]; // 각 열의 퀸의 위치
	
	// 각 열의 퀸의 위치를 출력
	static void print() {
		for(int i = 0; i < 8; i++) {
			System.out.printf("%2d",pos[i]);
		}
		System.out.println();
	}
	
	// i열에 퀸을 놓기
	static void set(int i) {
		for(int j = 0; j < 8; j++) {
			pos[i] = j;			// 퀸을 j행에 배치
			if(i == 7) {		// 모든 열에 배치
				print();
			}else {
				set(i + 1);		// 다음 열에 퀸을 배치
			}
		}
	}
	
	public static void main(String[] args	) {
		set(0);					// 0열에 퀸을 배치
	}
	
}

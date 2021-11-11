package chap04.stack.training;

public class IntStack {
	// int형 스택
	
	private int max; // 스택 용량 : 스택에 쌓을 수 있는 최대 데이터의 수 = 배열 stk의 요솟수와 같다.
	private int ptr; // 스택 포인터 : 스택에 쌓여 있는 데이터 수를 나타내는 필드
	private int[] stk; // 스택 본체 : 푸시된 데이터를 저장하는 스택 본체의 배열 인덱스 0인 요소가 스택의 바닥(bottom), 가장 먼저 푸시된 데이터를 저장하는 곳stk[0]

	// 실행 시 에외 : 스택이 비어 있음
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}
	
	// 실행 시 예외 : 스택이 가득 참
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
	
	// 생성자
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];		// 스택 본체용 배열을 생성
		}catch(OutOfMemoryError e) {	 // 생성할 수 없음
			max = 0;
		}
	}
	// 스택에 x를 푸시
	public int push(int x) throws OverflowIntStackException{
		if(ptr >= max) {			// 스택이 가득참
			throw new OverflowIntStackException();
		}
		return stk[ptr++] = x;
	}
	
	// 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
	public int pop() throws EmptyIntStackException{
		if(ptr <= 0) {				// 스택이 비어 있음
			throw new EmptyIntStackException();
		}
		return stk[--ptr];	// 먼저 ptr의 값을 감소시키고 그때 stk[ptr]에 저장되어 있는 값을 반환
	}
	
	// 스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
	public int peek() throws EmptyIntStackException {
		if(ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[ptr -1];
	}
	
	// 스택에서 x를 찾아 인덱스(없으면 -1)를 반환
	public int indexOf(int x) {
		for(int i = ptr -1; i >= 0; i--) {		// 정상 쪽에서 선형 검색
			if(stk[i] == x) {
				return i;
			}
		}
		return -1; // 검색 실패
	}
	
	// 스택을 비움
	public void clear() {
		ptr = 0;
	}
	
	// 스택의 용량을 반환
	public int capacity() {
		return max;
	}
	
	// 스택에 쌓여 있는 데이터 수를 반환
	public int size() {
		return ptr;
	}
	
	// 스택이 비어 있는가?
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	// 스택이 가득 찾는가?
	public boolean isFull() {
		return ptr >= max;
	}
	
	// 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
	public void dump() {
		if(ptr <= 0) {
			System.out.println("스택이 비어있습니다.");
		}else {
			for(int i = 0; i < ptr; i++) {
				System.out.print(stk[i]+ " ");
			}
			System.out.println();
		}
	}
}
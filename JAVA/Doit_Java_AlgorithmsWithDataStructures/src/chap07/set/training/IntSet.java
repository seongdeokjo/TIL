package chap07.set.training;

public class IntSet {
	// int형 집합
	
	private int max; 		// 집합의 최대 개수
	private int num; 		// 집합의 요소 개수
	private int[] set; 		// 집합 본체
	
	public IntSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	// 집합의 최대 개수
	public int capacity() {
		return max;
	}
	
	// 집합의 요소 개수
	public int size() {
		return num;
	}
	
	// 집합에서 n을 검색(index 반환)
	public int indexOf(int n) {
		for(int i = 0; i < num; i++) {
			if(set[i] == n) {
				return i;
			}
		}
		return -1;
	}
	
	// 집합에 n이 있는지 없는지 확인
	public boolean contains(int n) {
		return (indexOf(n) != -1 ? true : false);
	}
	
	// 집합에 n을 추가
	public boolean add(int n) {
		if( num >= max || contains(n) == true) {
			return false;
		}else {
			set[num++] = n;
			return true;
		}
	}
	
	// 집합에서 n을 삭제
	public boolean remove(int n) {
		int idx;
		
		if(num <= 0 || (idx = indexOf(n)) == -1) { // 비어 있거나 n이 존재하지 않는다.
			return false;
		}else {
			set[idx] = set[--num];					// 마지막 요소를 삭제한 곳으로 옮긴다.
			return true;
		}
	}
	
	// 집합 s에 복사한다.
	public void copyTo(IntSet s) {
		int n = (s.max < num) ? s.max : num; // 복사할 요소 개수
		for (int i = 0; i < n; i++) {
			s.set[i] = set[i];
		}
		s.num = n;
	}

	// 집합 s를 복사한다.
	public void copyFrom(IntSet s) {
		int n = (max < s.num) ? max : s.num; // 복사할 요소 개수
		for (int i = 0; i < n; i++) {
			set[i] = s.set[i];
		}
		num = n;
	}

	// 집합 s와 가튼지 확인
	public boolean equalTo(IntSet s) {
		if (num != s.num) {
			return false;
		}

		for (int i = 0; i < num; i++) {
			int j = 0;
			for (; j < s.num; j++) {
				if (set[i] == s.set[j]) {
					break;
				}
			}
			if (j == s.num) { // set[i]는 s에 포함되지 않는다.
				return false;
			}
		}
		return true;
	}

	// 집합 s1과 s2의 합집합을 복사
	public void unionOf(IntSet s1, IntSet s2) {
		copyFrom(s1); // 집합 s1을 복사
		for (int i = 0; i < s2.num; i++) { // 집합 s2의 요소를 추가
			add(s2.set[i]);
		}
	}

	// "{a b c}" 형식의 문자열로 표현을 바꾼다.
	public String toString() {
		StringBuffer temp = new StringBuffer("{ ");
		for (int i = 0; i < num; i++) {
			temp.append(set[i] + " ");
		}
		temp.append("}");
		return temp.toString();
	}

	// 집합이 비어 있는가?
	public boolean isEmpty() {
		return num == 0;
	}

	// 집합이 가득 찼는가?
	public boolean isFull() {
		return num >= max;
	}

	// 집합을 비움(모든 요소를 삭제)
	public void clear() {
		num = 0;
	}

	// 집합 s와 합집합
	public boolean add(IntSet s) {
		boolean flag = false;
		for (int i = 0; i < num; i++) {
			if (add(set[i]) == true) {
				flag = true;
			}
		}
		return flag;
	}

	// 집합 s와 교집합
	public boolean retain(IntSet s) {
		boolean flag = false;
		for (int i = 0; i < num; i++) {
			if (s.contains(set[i]) == false) {
				remove(set[i]);
				flag = true;
			}
		}
		return flag;
	}

	// 집합 s와 차집합
	public boolean remove(IntSet s) {
		boolean flag = false;
		for (int i = 0; i < num; i++) {
			if (s.contains(set[i]) == true) {
				remove(set[i]);
				flag = true;
			}
		}
		return flag;
	}

	// 집합 s의 부분집합인가요?
	public boolean isSubsetOf(IntSet s) {
		for (int i = 0; i < num; i++) {
			int j = 0;
			for (; j < s.num; j++) {
				if (set[i] == s.set[j]) {
					break;
				}
			}
			if (j == s.num) { // set[i]는 s에 포함되지 않음
				return false;
			}
		}
		return true;
	}

	// 집합 s의 진부분집합 인가?
	public boolean isProperSubsetOf(IntSet s) {
		if (num >= s.num) { // 요솟수가 s이상이면
			return false; // s의 진부분집합이 아님
		}
		return s.isSubsetOf(s);
	}

	// 집합 s1과 s2의 교집합을 복사
	public void intersectionOf(IntSet s1, IntSet s2) {
		clear();
		for (int i = 0; i < s1.num; i++) {
			if (s2.contains(s1.set[i])) {
				add(s1.set[i]);
			}
		}
	}

	// 집합 s1과 s2의 차집합을 복사
	public void differenceOf(IntSet s1, IntSet s2) {
		clear();
		for (int i = 0; i < s1.num; i++) {
			if (!s2.contains(s1.set[i])) {
				add(s1.set[i]);
			}
		}
	}
}
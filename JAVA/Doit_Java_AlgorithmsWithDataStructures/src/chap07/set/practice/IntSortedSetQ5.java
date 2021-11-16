package chap07.set.practice;

import chap07.set.training.IntSet;

public class IntSortedSetQ5 {
	// 요소가 항상 오름차순으로 정렬되는 클래스

	private int max;
	private int num;
	private int[] set;

	// 생성자
	public IntSortedSetQ5(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max]; // 집합본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 배열의 생성에 실패
			max = 0;
		}
	}

	// 집합에서 n을 검색하여 index를 반환
	// 찾지 못한 경우 (-삽입 포인트 -1)를 반환
	public int indexOf(int n) {
		int pl = 0;
		int pr = n - 1;

		do {
			int pc = (pl + pr) / 2;
			if (set[pc] == n) {
				return pc;
			} else if (set[pc] < n) {
				pl = pc + 1;
			} else {
				pr = pc - 1;
			}
		} while (pl <= pr);

		return -pl - 1; // 검색 실패
	}

	// 집합에 n이 들어있나요?
	public boolean contains(int n) {
		return (indexOf(n) >= 0) ? true : false;
	}

	// 집합에 n을 추가
	public boolean add(int n) {
		int idx;
		if (num >= max || (idx = indexOf(n)) >= 0) {
			return false;
		} else {
			idx = -(idx + 1);
			num++;
			for (int i = num - 1; i > idx; i--) {
				set[i] = set[i - 1];
			}
			set[idx] = n;
			return true;
		}
	}

	// 집합에서 n을 삭제
	public boolean remove(int n) {
		int idx; // n이 저장된 요소의 idx
		if (num <= 0 || (idx = indexOf(n)) == -1) {
			return false;
		} else {
			num--;
			for (int i = idx; i < num; i++) {
				set[i] = set[i + 1]; // 그 다음 요소를 한 칸 앞으로 옮김
			}
			return true;
		}
	}

	// 집합 s에 복사한다.
	public void copyTo(IntSortedSetQ5 s) {
		int n = (s.max < num) ? s.max : num; // 복사할 요소 개수
		for (int i = 0; i < n; i++) {
			s.set[i] = set[i];
		}
		s.num = n;
	}

	// 집합 s를 복사한다.
	public void copyFrom(IntSortedSetQ5 s) {
		int n = (max < s.num) ? max : s.num; // 복사할 요소 개수
		for (int i = 0; i < n; i++) {
			set[i] = s.set[i];
		}
		num = n;
	}

	// 집합 s와 가튼지 확인
	public boolean equalTo(IntSortedSetQ5 s) {
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
	public void unionOf(IntSortedSetQ5 s1, IntSortedSetQ5 s2) {
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
	public boolean isSubsetOf(IntSortedSetQ5 s) {
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
	public boolean isProperSubsetOf(IntSortedSetQ5 s) {
		if (num >= s.num) { // 요솟수가 s이상이면
			return false; // s의 진부분집합이 아님
		}
		return s.isSubsetOf(s);
	}

	// 집합 s1과 s2의 교집합을 복사
	public void intersectionOf(IntSortedSetQ5 s1, IntSortedSetQ5 s2) {
		clear();
		for (int i = 0; i < s1.num; i++) {
			if (s2.contains(s1.set[i])) {
				add(s1.set[i]);
			}
		}
	}

	// 집합 s1과 s2의 차집합을 복사
	public void differenceOf(IntSortedSetQ5 s1, IntSortedSetQ5 s2) {
		clear();
		for (int i = 0; i < s1.num; i++) {
			if (!s2.contains(s1.set[i])) {
				add(s1.set[i]);
			}
		}
	}
}
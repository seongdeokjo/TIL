package chap09.linkedList.practice;

import java.util.Comparator;

// 연결 리스트 클래스 (배열 커서 버전)
public class AryCircLinkedListQ8<E> {
	// 노드
	class Node<E> {
		private E data;
		private int next;
		private int dnext;

		void set(E data, int next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E>[] n;
	private int size;
	private int max;
	private int head;
	private int tail;
	private int crnt;
	private int deleted;
	private static final int NULL = -1;

	// 생성자
	public AryCircLinkedListQ8(int capacity) {
		head = tail = crnt = max = deleted = NULL;
		try {
			n = new Node[capacity];
			for (int i = 0; i < capacity; i++) {
				n[i] = new Node<E>();
				size = capacity;
			}

		} catch (OutOfMemoryError e) {
			size = 0;
		}
	}
	
	// 다음에 삽입하는 record의 index를 구합니다.
	private int getInsertIndex() {
		if(deleted == NULL) {
			if(max < size) {
				return ++max;
			}else {
				return NULL;
			}
		}else {
			int rec = deleted;
			deleted = n[rec].dnext;
			return rec;
		}
	}

	// recode idx를 free 리스트에 등록
	private void deleteIndex(int idx) {
		if(deleted == NULL) {
			deleted = idx;
			n[idx].dnext = NULL;
		}else {
			int rec = deleted;
			deleted = idx;
			n[idx].dnext = rec;
		}
	}
	
	// 노드를 검색
	public E search(E o, Comparator<? super E> c) {
		if(head != NULL) {
			int ptr = head;
			
			do {
				if(c.compare(o, n[ptr].data) == 0) {
					crnt = ptr;
					return n[ptr].data;
				}
				ptr = n[ptr].next;
			}while(ptr != head);
		}
		return null;
	}
	
	// 머리에 노드를 삽입
	public void addFirst(E o) {
		if(head == NULL) {
			int rec = getInsertIndex();
			if(rec != NULL) {
				head = tail = crnt = rec;
				n[head].set(o, rec);
			}
		}else {
			int ptr = head;
			int rec = getInsertIndex();
			if(rec != NULL) {
				head = crnt = rec;
				n[head].set(o, ptr);
				n[tail].next = head;
			}
		}
	}
	
	// 꼬리에 노드를 삽입
	public void addLast(E o) {
		if(head == NULL) {
			addFirst(o);
		}else {
			int rec = getInsertIndex();
			if(rec != NULL) {
				n[tail].next = crnt = rec;
				n[rec].set(o, head);
				tail = rec;
			}
		}
	}
	
	// 머리 노드를 삭제
	public void removeFirst() {
		if(head != NULL) {
			if(head == tail) {
				deleteIndex(head);
				head = tail = crnt = NULL;
			}else {
				int ptr = n[head].next;
				deleteIndex(head);
				head = crnt = ptr;
				n[tail].next = head;
			}
		}
	}
	
	// 꼬리 노드를 삭제
	public void removeLast() {
		if(head != NULL) {
			if(head == tail) {
				removeFirst();
			}else {
				int ptr = head;
				int pre = head;
				
				while(n[ptr].next != head) {
					pre = ptr;
					ptr = n[ptr].next;
				}
				n[pre].next = head;
				deleteIndex(ptr);
				tail = crnt = pre;
			}
		}
	}
	
	// record p를 삭제
	public void remove(int p) {
		if(head != NULL) {
			if(p == head) {
				removeFirst();
			}else if(p == tail) {
				removeLast();
			}else {
				int ptr = head;
				
				while(n[ptr].next != p) {
					ptr = n[ptr].next;
					if(ptr == head) {
						return;
					}
				}
				n[ptr].next = n[p].next;
				deleteIndex(p);
				crnt = ptr;
			}
		}
	}
	
	
	// 선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	// 모든 노드를 삭제
	public void clear() {
		while(head != NULL) {
			removeFirst();
		}
		crnt = NULL;
	}
	
	// 선택 노드를 출력
	public void printCurrentNode() {
		if(crnt == NULL) {
			System.out.println("선택 노드가 없습니다.");
		}else {
			System.out.println(n[crnt].data.toString());
		}
	}
	
	// 모든 노드를 출력
	public void dump() {
		if(head != NULL) {
			int ptr = head;
			
			do {
				System.out.println(n[ptr].data.toString());
				ptr = n[ptr].next;
			}while(ptr != head);
		}
	}
	
	// comparator c에 의해 서로 같다고 보는 노드를 모두 삭제
	public void purge(Comparator<? super E> c) {
		if(head == NULL) {
			return;
		}
		int ptr = head;
		
		do {
			int count = 0;
			int ptr2 = ptr;
			int pre = ptr;
			
			while(n[pre].next != head) {
				ptr2 = n[pre].next;
				if(c.compare(n[ptr].data, n[ptr2].data) == 0) {
					remove(ptr2);
					count++;
				}else {
					pre = ptr2;
				}
			}
			if(count == 0) {
				ptr = n[ptr].next;
			}else {
				int temp = n[ptr].next;
				remove(ptr);
				ptr = temp;
			}
		}while(n[ptr].next != head);
		crnt = head;
	}
	
	// 머리부터 n개 뒤 노드의 데이터에 대한 참조를 반환
	public E retrieve(int n) {
		if(head != NULL) {
			int ptr = head;
			
			while(n >= 0) {
				if(--n == 0) {
					crnt = ptr;
					return this.n[ptr].data;
				}
				ptr = this.n[ptr].next;
				if(ptr == head) {
					break;
				}
			}
		}
		return null;
	}
}
package chap09.linkedList.practice;

import java.util.Comparator;


public class LinkedListTQ3<E> {
	// 꼬리 노드에 대한 참조 tail을 도입하여 꼬리 노드를 쉽게 검색할 수 있도록 클래스 작성

	// 노드
	class Node<E> {
		private E data; // 데이터
		private Node<E> next; // 뒤쪽 포인터(다음 노드 참조)

		// 생성자
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head; // 머리노드
	private Node<E> crnt; // 선택 노드
	private Node<E> tail; // 꼬리 노드

	// 생성자
	public LinkedListTQ3() {
		head = tail =crnt = null;
	}

	// 노드 검색
	public E search(E obj, Comparator<? super E> c) { // 첫 번째 매개 변수 obj : 검색할 때 key가 되는 데이터를 넣어둔 object
		Node<E> ptr = head; // 현재 스캔 중인 노드 // 두 번째 매개변수 c : 첫 번째 매개변수와 연결 리스트의 개별 노드 안에 있는 데이터를 비교하기 위한
							// comparator.comparator c에 의해 obj와
							// 선택한 노드의 데이터를 비교하여 그 결과가 0이면 검색 조건이 성립하는 것으로 본다.
		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) {
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}

	// 머리에 노드 삽입
	public void addFirst(E obj) {
		boolean empty = (tail == null);
		Node<E> ptr = head; // 삽입 전의 머리 노드
		head = crnt = new Node<E>(obj, ptr);
		if(empty) {
			tail = crnt;
		}
	}

	// 꼬리에 노드 삽입
	public void addLast(E obj) {
		if (head == null) {
			addFirst(obj);
		} else {
			tail.next = crnt = new Node<E>(obj, null);
			tail = crnt;
		}
	}

	// 머리 노드를 삭제
	public void removeFirst() {
		if (head != null) { // 리스트가 비어 있지 않으면
			head = crnt = head.next;
			if(head == null) {
				tail = null;
			}
		}
	}

	// 꼬리 노드를 삭제
	public void removeLast() {
		if (head != null) {
			if (head.next == null) { // 노드가 하나만 있으면
				removeFirst(); // 머리 노드를 삭제
			} else {
				Node<E> ptr = head; // 스캔 중인 노드
				Node<E> pre = head; // 스캔 중인 노드의 앞쪽 노드

				while (ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null; // pre는 삭제 후의 꼬리 노드
				tail = crnt = pre;
			}
		}
	}

	// 노드 p를 삭제
	public void remove(Node<E> p) {
		if (head != null) {
			if (p == head) {
				removeFirst();
			} else if(p == tail){
				removeLast();
			}else {
				Node<E> ptr = head;

				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null) {
						return; // p가 리스트에 없다.
					}
				}
				ptr.next = p.next;
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
		while (head != null) { // 노드에 아무것도 없을 때까지
			removeFirst(); // 머리 노드를 삭제
		}
		crnt = null;
	}

	// 선택 노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if (crnt == null || crnt.next == null) {
			return false; // 이동할 수 없다.
		}
		crnt = crnt.next;
		return true;
	}

	// 선택 노드를 출력
	public void printCurrentNode() {
		if (crnt == null) {
			System.out.println("선택한 노드가 없다.");
		} else {
			System.out.println(crnt.data);
		}
	}

	// 모든 노드를 출력
	public void dump() {
		Node<E> ptr = head;

		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}

	// comparator c에 의해 서로 같다고 보는 노드를 모두 삭제
	public void purge(Comparator<? super E> c) {
		Node<E> ptr = head;

		while (ptr != null) {
			int count = 0;
			Node<E> ptr2 = ptr;
			Node<E> pre = ptr;

			while (pre.next != null) {
				ptr2 = pre.next;
				if (c.compare(ptr.data, ptr2.data) == 0) {
					pre.next = ptr2.next;
					count++;
				} else {
					pre = ptr2;
				}
			}
			if (count == 0) {
				ptr = ptr.next;
			} else {
				Node<E> temp = ptr;
				remove(ptr);
				ptr = temp.next;
			}
		}
	}

	// 머리부터 n개 뒤 노드의 데이터에 대한 참조를 반환
	public E retrieve(int n) {
		Node<E> ptr = head;

		while (n >= 0 && ptr != null) {
			if (--n == 0) {
				crnt = ptr;
				return ptr.data; // 검색 성공
			}
			ptr = ptr.next;
		}
		return null;
	}
}

package chap09.linkedList.practice;

import java.util.Comparator;

//  원형 리스트 클래스 (원형 리스트 버전)
public class CircLinkedListQ7<E> {
	// 노드
	class Node<E>{
		E data;
		Node<E> next;	// 뒤쪽 포인터(다음 노드에 대한 참조)
		
		// 생성자
		Node(E data){
			this.data = data;
			this.next = this;
		}
		
		// 생성자
		Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	private Node<E> crnt;
	
	// 생성자
	public CircLinkedListQ7() {
		head = tail = crnt = null;
	}
	
	// 노드를 검색
	public E search(E o, Comparator<? super E> c) {
		if(head != null) {
			Node<E> ptr = head;
			
			do {
				if(c.compare(o, ptr.data) == 0) {
					crnt = ptr;
					return ptr.data;
				}
				ptr = ptr.next;
			}while(ptr != head);
		}
		return null;
	}
	
	// 머리에 노드를 삽입
	public void addFirst(E o) {
		if(head == null) {
			head = tail = crnt = new Node<E>(o);
		}else {
			Node<E> ptr = head;
			head = crnt = new Node<E>(o,ptr);
			tail.next = head;
		}
	}
	
	// 꼬리에 노드를 삽입
	public void addLast(E o) {
		if(head == null) {
			addFirst(o);
		}else {
			Node<E> ptr = tail;
			ptr.next = crnt = tail = new Node<E>(o, head);
		}
	}
	
	// 머리 노드를 삭제
	public void removeFirst() {
		if(head != null) {
			if(head == tail) {
				head = tail = crnt = null;
			}else {
				Node<E> ptr = head.next;
				head = crnt = ptr;
				tail.next = head;
			}
		}
	}
	
	// 꼬리 노드를 삭제
	public void removeLast() {
		if(head != null) {
			if(head == tail) {
				removeFirst();
			}else {
				Node<E> ptr = head;
				Node<E> pre = head;
				
				while(ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = head;	// pre는 삭제 뒤의 꼬리 노드
				tail = crnt = pre;
			}
		}
	}
	
	// 노드 p를 삭제
	public void remove(Node<E> p) {
		if(head != null) {
			if(p == head) {
				removeFirst();
			}else if(p == tail) {
				removeLast();
			}else {
				Node<E> ptr = head;
				
				while(ptr.next != p) {
					ptr = ptr.next;
					if(ptr == head) {
						return ;
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
		while(head != null) {
			removeFirst();
		}
		crnt = null;
	}
	
	// 선택 노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if(crnt == null || crnt.next == head) {
			return false;
		}
		crnt = crnt.next;
		return true;
	}
	
	// 선택 노드를 출력
	public void printCurrentNode() {
		if(crnt == null) {
			System.out.println("선택 노드가 없습니다.");
		}else {
			System.out.println(crnt.data.toString());
		}
	}
	
	// 모든 노드를 출력
	public void dump() {
		if(head != null) {
			Node<E> ptr = head;
			
			do{
				System.out.println(ptr.data.toString());
				ptr = ptr.next;
			}while(ptr != head);
		}
	}
	
	// comparator c에 의해 서로 같다고 보는 노드를 모두 삭제
	public void purge(Comparator<? super E> c) {
		if(head == null) {
			return;
		}
		Node<E> ptr = head;
		
		do {
			int count = 0;
			Node<E> ptr2 = ptr;
			Node<E> pre = ptr;
			
			while(pre.next != head) {
				ptr2= pre.next;
				if(c.compare(ptr.data, ptr2.data) == 0) {
					remove(ptr2);
					count++;
				}else {
					pre = ptr2;
				}
			}
			if(count == 0) {
				ptr = ptr.next;
			}else {
				Node<E> temp = ptr;
				remove(ptr);
				ptr = temp.next;
			}
		}while(ptr.next != head);
		crnt = head;
	}
	
	// 머리부터 n개 뒤 노드의 데이터에 대한 참조를 반환
	public E retrieve(int n) {
		if(head != null) {
			Node<E> ptr = head;
			
			while(n >= 0) {
				if(n-- == 0) {
					crnt= ptr;
					return ptr.data;
				}
				ptr = ptr.next;
				if(ptr == head) {
					break;
				}
			}
		}
		return null;
	}
}
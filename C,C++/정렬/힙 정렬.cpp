
/*
 힙(heap) 정렬 : 힙 트리 구조를 이용하는 정렬 방법
 힙 정렬  알고리즘의 시간 복잡도 : O(1/2N * logN) => O(N * logN)
 힙 -> 최솟값이나 최대값을 빠르게 찾아내기 위해 완전 이진 트리를 기반으로 하는 트리
 최대 힙 -> 부모 노드가 자식 노드 보다 큰 힙 
  
 이진 트리 :  컴퓨터 안에서 데이터를 표현할 때 데이터를 각 노드에 담은 뒤에 노드를 두 개씩 이어 붙이는 구조  
 +모든 노드의 자식 노드가 2개 이하인 트리 구조
 트리 최상단 -> 루트(root) , 트리 최하단 -> 리프(leaf)
 
 완전 이진 트리 -> 데이터가 루트 노드부터 시작해서 자식 노드가 왼쪽 자식 노드, 오른쪽 자식 노드로 차근차근 들어가는 구조의 이진 트리
  				-> 이진 트리의 노드가 중간에 비어있지 않고 가득 찬 구조
				-> 항상 왼쪽 자식 노드부터 데이터가 들어간다  
  




*/  

#include <stdio.h>

int number = 9;
int heap[9] = {7, 6, 5, 8, 3, 5, 9, 1, 6};

int main(void){
	// 먼저 전체 트리 구조를 최대 힙 구조로 바꿈 
	for(int i = 1; i < number; i++){
		int c = i;
		do {
			int root = (c - 1) / 2;
			if(heap[root] < heap[c]){
				int temp = heap[root];
				heap[root] = heap[c];
				heap[c] = temp;
			}
			c = root;
		}while(c != 0);
	}

	// 크기를 줄여가며 반복적으로 힙을 구성
	for(int i = number -1; i >= 0; i--){
		int temp = heap[0];
		heap[0] = heap[i];
		heap[i] = temp;
		int root = 0;
		int c = 1;
		do{
			c = 2 * root + 1;
			//자식 중에 더 큰 값을 찾기
			if(c < i -1 && heap[c] < heap[c+ 1]){
			
				c++;
			}
			
			// 루트보다 자식이 더 크다면 교환
			if(c < i  && heap[root] < heap[c]){
			
				int temp = heap[root];
				heap[root] = heap[c];
				heap[c] = temp;
			
			}
			root = c;
		
		}while(c < i);

	}
	
	for(int i = 0; i < number; i++){
		printf("%d ", heap[i]);
	}
	
	 
} 

/* 
	이진트리의 구현과 순회(traversal) 방식 :  데이터의 탐색 속도 증진을 위해 사용하는 구조
	포인터를 사용하여 구현  
	각각의 데이터 탐색 방법 : 
	1. 전위 순회(preorder traversal) : 먼저 자기 자신을 처리 -> 왼쪽 자식을 방문 -> 오른쪽 자식을 방문  
	2. 중위 순회 (inorder traversal) : 왼쪽 자식을 방문 -> 먼저 자기 자신을 처리 -> 오른쪽 자식을 방문 
	3. 후위 순회 (postorder traversal) : 왼쪽 자식을 방문 -> 오른쪽 자식을 방문 -> 먼저 자기 자신을 처리
	 
	 
*/

#include <iostream>

using namespace std;

int number = 15;

// 하나의 노드 정보를 선언
typedef struct node *treePointer;
typedef struct node {
	int data;
	treePointer leftChild, rightChild;
} node;

// 전위 순회를 구현
void preorder(treePointer ptr){
	if(ptr){
		cout << ptr->data << ' ';
		preorder(ptr->leftChild);
		preorder(ptr->rightChild);
	}
}

// 중위 순회를 구현
void inorder(treePointer ptr){
	if(ptr){
		inorder(ptr->leftChild);
		cout << ptr->data << ' ';
		inorder(ptr->rightChild);
	}
}

// 후위 순회를 구현
void postorder(treePointer ptr){
	if(ptr){
		postorder(ptr->leftChild);
		postorder(ptr->rightChild);
		cout << ptr->data << ' ';
		
	}
} 

int main(void){
	node nodes[number + 1];
	for(int i = 1; i <= number; i++){
		nodes[i].data = i;
		nodes[i].leftChild = NULL;
		nodes[i].rightChild = NULL;
	}
	
	for(int i = 1; i <= number; i++){
		if(i % 2 == 0){
			nodes[i /2].leftChild = &nodes[i];
		}else{
			nodes[i /2].rightChild = &nodes[i];
		}
	}
	preorder(&nodes[1]);
	inorder(&nodes[1]);
}



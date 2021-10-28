/* 
	합집합 찾기 (union find) :  그래프 알고리즘 , 서로소 집합 알고리즘 
	여러 개의 노드가 존재할 때 두 개의 노드를 선택해서 현재 이 두 노드가 서로 같은 그래프에 속하는지 판별하는 알고리즘 
*/

#include <stdio.h>

// 부모 노드를 찾는 함수 
int getParent(int parent[], int x){
	printf("------------------------\n getparent function call\n");
	printf("parent = %d, x = %d\n",parent[x],x);
	if(parent[x] == x){
		return x;
	}
	printf("부모 노드를 찾기위해 재귀 호출\n");
	return parent[x] = getParent(parent, parent[x]);
}

// 두 부모 노드를 합치는 함수 
int unionParent(int parent[], int a, int b){
	printf("unionFunction call\n");
	a = getParent(parent, a);
	b = getParent(parent, b);
	printf("a = %d, b = %d\n",a,b);
	if(a < b){
		parent[b] = a;
	}else{
		parent[a] = b;
	}
	printf("합친 결과 parent[a] = %d, parent[b] = %d\n",parent[a],parent[b]);
}

// 같은 부모를 가지는지 확인 
int findParent(int parent[], int a, int b){
	a = getParent(parent, a);
	b = getParent(parent, b);
	if(a == b){
		return 1;
	}
	return 0;
}

int main(void){
	int parent[11];
	for(int i = 1; i <= 10; i++){
		parent[i] = i;
	}
	
	unionParent(parent, 1, 2);
	unionParent(parent, 2, 3);
	unionParent(parent, 3, 4);
	unionParent(parent, 5, 6);
	unionParent(parent, 6, 7);
	unionParent(parent, 7, 8);

//	unionParent(parent, 1 ,5);
	printf("1과 5는 연결되어 있나요? %d\n", findParent(parent, 1,5));
	printf("5과 8는 연결되어 있나요? %d\n", findParent(parent, 5,8));
}

/* 
	������ ã�� (union find) :  �׷��� �˰��� , ���μ� ���� �˰��� 
	���� ���� ��尡 ������ �� �� ���� ��带 �����ؼ� ���� �� �� ��尡 ���� ���� �׷����� ���ϴ��� �Ǻ��ϴ� �˰��� 
*/

#include <stdio.h>

// �θ� ��带 ã�� �Լ� 
int getParent(int parent[], int x){
	printf("------------------------\n getparent function call\n");
	printf("parent = %d, x = %d\n",parent[x],x);
	if(parent[x] == x){
		return x;
	}
	printf("�θ� ��带 ã������ ��� ȣ��\n");
	return parent[x] = getParent(parent, parent[x]);
}

// �� �θ� ��带 ��ġ�� �Լ� 
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
	printf("��ģ ��� parent[a] = %d, parent[b] = %d\n",parent[a],parent[b]);
}

// ���� �θ� �������� Ȯ�� 
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
	printf("1�� 5�� ����Ǿ� �ֳ���? %d\n", findParent(parent, 1,5));
	printf("5�� 8�� ����Ǿ� �ֳ���? %d\n", findParent(parent, 5,8));
}

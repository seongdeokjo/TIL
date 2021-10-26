
/*
 ��(heap) ���� : �� Ʈ�� ������ �̿��ϴ� ���� ���
 �� ����  �˰����� �ð� ���⵵ : O(1/2N * logN) => O(N * logN)
 �� -> �ּڰ��̳� �ִ밪�� ������ ã�Ƴ��� ���� ���� ���� Ʈ���� ������� �ϴ� Ʈ��
 �ִ� �� -> �θ� ��尡 �ڽ� ��� ���� ū �� 
  
 ���� Ʈ�� :  ��ǻ�� �ȿ��� �����͸� ǥ���� �� �����͸� �� ��忡 ���� �ڿ� ��带 �� ���� �̾� ���̴� ����  
 +��� ����� �ڽ� ��尡 2�� ������ Ʈ�� ����
 Ʈ�� �ֻ�� -> ��Ʈ(root) , Ʈ�� ���ϴ� -> ����(leaf)
 
 ���� ���� Ʈ�� -> �����Ͱ� ��Ʈ ������ �����ؼ� �ڽ� ��尡 ���� �ڽ� ���, ������ �ڽ� ���� �������� ���� ������ ���� Ʈ��
  				-> ���� Ʈ���� ��尡 �߰��� ������� �ʰ� ���� �� ����
				-> �׻� ���� �ڽ� ������ �����Ͱ� ����  
  




*/  

#include <stdio.h>

int number = 9;
int heap[9] = {7, 6, 5, 8, 3, 5, 9, 1, 6};

int main(void){
	// ���� ��ü Ʈ�� ������ �ִ� �� ������ �ٲ� 
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

	// ũ�⸦ �ٿ����� �ݺ������� ���� ����
	for(int i = number -1; i >= 0; i--){
		int temp = heap[0];
		heap[0] = heap[i];
		heap[i] = temp;
		int root = 0;
		int c = 1;
		do{
			c = 2 * root + 1;
			//�ڽ� �߿� �� ū ���� ã��
			if(c < i -1 && heap[c] < heap[c+ 1]){
			
				c++;
			}
			
			// ��Ʈ���� �ڽ��� �� ũ�ٸ� ��ȯ
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

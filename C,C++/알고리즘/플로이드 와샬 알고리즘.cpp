/*
	�÷��̵� �ͼ� (floyd warshall) �˰��� :  ��� �������� ��� ���������� �ִ� ��θ� ���� �� ���Ǵ� �˰���
	Ư¡ : ���İ��� ������ �������� �ִ� �Ÿ��� ���ϴ� �� 
*/

#include <stdio.h>

int number = 4;
int INF = 10000000;

// �ڷ� �迭�� �ʱ�ȭ
int a[4][4] = {
	{0, 5, INF, 8},
	{7, 0, 9, INF},
	{2, INF, 0, 4},
	{INF, INF, 3, 0}
};

void floydWarshall(){
	// ��� �׷����� �ʱ�ȭ
	int d[number][number];
	
	for(int i = 0; i < number; i++){
		for(int j = 0; j < number; j++){
			d[i][j] = a[i][j];
		}
	}
	
	// k = ���İ��� ���
	for(int k = 0; k < number; k++){
		printf("k = %d \n",k);
		// i = ��� ���
		for(int i = 0; i < number; i++){
			// j = ���� ���
			for(int j = 0; j < number; j++){
				printf("i = %d, j = %d \n",i,j);
				if(d[i][k] + d[k][j] < d[i][j]){
					d[i][j] = d[i][k] + d[k][j];
				
				}
			} 
		} 
	} 
	
	// ����� ���
	for(int i = 0; i < number; i++){
		for(int j = 0; j < number; j++){
			printf("%3d ", d[i][j]);
		}
		printf("\n");
	} 
} 

int main(void){
	floydWarshall();
}

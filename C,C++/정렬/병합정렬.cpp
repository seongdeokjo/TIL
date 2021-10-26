#include <stdio.h>
// �������� : ��ǥ���� '���� ����' ����� ä���� �˰��� 
// ��Ȯ�� ������ �����ٴ� ������ �ð����⵵�� logN�� �����Ѵ�.
// �ϴ� ������ ������ ���߿� ���ļ� ���� 
// �ð� ���⵵ : O(N * logN) 

int number = 8;
int sorted[8]; // ���� �迭�� �ݵ�� ���������� ����.

void merge(int a[], int m, int middle, int n){
	int i = m;
	int j = middle + 1;
	int k = m;
	printf("middle = %d, m = %d, n = %d\n",middle,m,n);
	printf("merge Funtcion -> middle = %d, m = %d n = %d\n", middle,m,n);
	// ���� ������� �迭�� ���� 
	while(i <= middle && j <= n){
		printf("while�� ����\n");
		if(a[i] <= a[j]){
			sorted[k] = a[i];
			i++;
		}else{
			sorted[k] = a[j];
			j++;
		}
		k++;
		
	}
	printf("after while -> i = %d, j = %d k = %d\n", i,j,k);
	// ���� �����͵� ����
	if(i > middle){
		for(int t = j; t <= n; t++){
			sorted[k] = a[t];
			k++;
		}
	}else{
		for(int t = i; t <= middle; t++){
			sorted[k] = a[t];
			k++;
		}
	}
	
	
	// ���ĵ� �迭�� ���� 
	for(int t = m; t <= n; t++){
		a[t] = sorted[t];
		
	}
	for(int t = m; t <= n; t++){
		printf("a = %d     \n",a[t]);
	}
	

}

void mergeSort(int a[], int m, int n){
	// ũ�Ⱑ 1���� ū ��� 

	if(m < n){
		int middle = (m + n) / 2;
		printf("1.middle = %d, m = %d, n = %d\n", middle,m,n);
		mergeSort(a, m, middle);
		printf("2.middle = %d, m = %d n = %d\n", middle,m,n);
		mergeSort(a, middle + 1, n);
		printf("3.middle = %d, m = %d n = %d\n", middle,m,n);
		merge(a, m, middle, n);
		
	}

}
 

int main(void){
 	int array[number] = {7, 6, 5, 8, 3, 5, 9, 1};
	mergeSort(array, 0, number-1);
	for(int i = 0; i < number; i++ ){
		printf("%d ", array[i]);
	}  
}

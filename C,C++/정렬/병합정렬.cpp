#include <stdio.h>
// 병합정렬 : 대표적인 '분할 정복' 방법을 채택한 알고리즘 
// 정확히 반절씩 나눈다는 점에서 시간복잡도가 logN을 보장한다.
// 일단 반으로 나누고 나중에 합쳐서 정렬 
// 시간 복잡도 : O(N * logN) 

int number = 8;
int sorted[8]; // 정렬 배열은 반드시 전역변수로 선언.

void merge(int a[], int m, int middle, int n){
	int i = m;
	int j = middle + 1;
	int k = m;
	printf("middle = %d, m = %d, n = %d\n",middle,m,n);
	printf("merge Funtcion -> middle = %d, m = %d n = %d\n", middle,m,n);
	// 작은 순서대로 배열에 삽입 
	while(i <= middle && j <= n){
		printf("while문 진입\n");
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
	// 남은 데이터도 삽입
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
	
	
	// 정렬된 배열을 삽입 
	for(int t = m; t <= n; t++){
		a[t] = sorted[t];
		
	}
	for(int t = m; t <= n; t++){
		printf("a = %d     \n",a[t]);
	}
	

}

void mergeSort(int a[], int m, int n){
	// 크기가 1보다 큰 경우 

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

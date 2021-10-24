#include <stdio.h>
// 정렬 알고리즘 
// 시간 복잡도 : 10 + 9 + 8 + ....+1 => 10 * (10 +1) /2 = 55
// N * (N+1) /2 => O(N * N) 
//BigO 표기법 : 특정 알고리즘을 가장 간략하게 표현한 것 

int main(void){
	int i,j,min,index,temp;
	int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
	
	for(int i=0; i<10; i++){
		min = 9999;
		
		for(int j = i; j< 10; j++){
			if(min > array[j]){
				min = array[j];
				index = j;
			}
		}
		
		temp = array[i];
		array[i] = array[index];
		array[index] = temp;
		
	}
	for(i = 0; i<10; i++){
		printf("%d ", array[i]);
	}
	
	return 0;
}

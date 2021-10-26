/*
 계수 정렬 : 크기를 기준으로 세는 알고리즘 
 데이터의 크기가 한정되어있을 때 사용 가능 
*/

#include <stdio.h>

int main(void){
	int temp;
	int count[5];
	int array[30] = {
		1, 3, 2, 4, 3, 2, 5, 3, 1, 2,
		3, 4, 4, 3, 5, 1, 2, 3, 5, 2,
		3, 1, 4, 3, 5, 1, 2, 1, 1, 1 
	};
	// 배열 인덱스가 5 
	for(int i = 0; i<5; i++){
		count[i] = 0;
	}
	for(int i = 0; i < 30; i++){
		count[array[i] - 1]++;
	}
	for(int i = 0; i < 5; i++){
		if(count[i] != 0){
			for(int j = 0; j < count[i]; j++){
				printf("%d ", i+1 );
			}
		}
	}
	
	
	return 0;
} 

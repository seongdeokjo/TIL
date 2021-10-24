#include <stdio.h>

// 삽입 정렬 : 각 숫자를 적절한 위치에 삽입하는 방법으로 문제를 해결 -> '필요할 때만' 위치를 바꾸게 된다.
// 기본적으로 '정렬이 되어있다고 가정'을 한다는 점, 특정한 경우에 따라 굉장히 빠른 속도를 나타낸다.
// 시간 복잡도 : O(N * N)  

int main(void){
	int i,j,temp;
	int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
	for(i=0; i< 9; i++){
		j = i;
		while(array[j] > array[j+ 1]){
			temp = array[j];
			array[j] = array[j+1];
			array[j+1] = temp;
			j --;
		}
	}
	
	for(i=0; i<10; i++){
		printf("%d ", array[i]);
	}
	return 0;	
} 

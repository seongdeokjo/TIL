#include <stdio.h>

// 버블 정렬
//  바로 가까이에 있는 두 숫자끼리 비교를 해서 당장 더 작은 숫자를 앞으로 보내주는 것을 반복

int main(void){
	int i,j,temp;
	int array[10] = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
	for(i = 0; i<10; i++){
		for(j=0; j<9 -i; j++){
			if(array[j] > array[j+1]){
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
			}
		}
	}
	return 0;
}


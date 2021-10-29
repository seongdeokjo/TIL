/*
	에라토스테네스의 체 : 소수 판별 알고리즘 
*/
/*
#include <stdio.h>
 약수를 구하는 시간 복잡도 : O(N) : 모든 경우의 수를 다 돌며 약수 여부를 확인한다. -> 비효율적 
bool isPrimeNumber(int x){
	for(int i = 2; i < x; i++){
		if(x % i == 0) return false;		
	}
	return true;
}
int main(void){
	printf("%d", isPrimeNumber(97));
	
	return 0;
}
*/
/*
#include <stdio.h>
#include <math.h>

bool isPrimeNumber(int x){ // 구하는 약수가 한 개인 경우 
	int end = (int) sqrt(x); // sqrt -> 제곱근 함수
	printf("end = %d\n", end); 
	for(int i =2; i <= end; i++){
		if(x % i == 0) return false;
	}
	return true;
}

int main(void){
	printf("%d", isPrimeNumber(7));
	return 0;
}
*/

#include <stdio.h>

int number = 100000;
int a[100001];

void primeNumberSieve() {
	for(int i = 2; i <= number; i++){
		a[i] = i;
	}
	for(int i = 2; i <= number; i++){
		if(a[i] == 0) continue;
		for(int j = i + i; j <= number; j +=i){
			printf("i = %d, j = %d\n", i,j);
			a[j] = 0;
		}
	}
	for(int i = 2; i <= number; i++){
		if(a[i] != 0) printf("%d ", a[i]);
	}	
} 

int main(void){
	primeNumberSieve();
}

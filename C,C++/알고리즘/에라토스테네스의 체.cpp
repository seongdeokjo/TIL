/*
	�����佺�׳׽��� ü : �Ҽ� �Ǻ� �˰��� 
*/
/*
#include <stdio.h>
 ����� ���ϴ� �ð� ���⵵ : O(N) : ��� ����� ���� �� ���� ��� ���θ� Ȯ���Ѵ�. -> ��ȿ���� 
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

bool isPrimeNumber(int x){ // ���ϴ� ����� �� ���� ��� 
	int end = (int) sqrt(x); // sqrt -> ������ �Լ�
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

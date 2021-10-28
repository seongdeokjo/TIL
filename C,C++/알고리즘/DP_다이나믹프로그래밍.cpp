/* 
		다이나믹 프로그래밍(dynamic programming) : 하나의 문제는 단 한번만 풀도록 하는 알고리즘 
 		1번 가정, 큰 문제를 작은 문제로 나눌 수 있다.
		2번 가정, 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일하다.
		 
*/

int d[100]; 

#include <stdio.h>
// 피보나치 수열  -> 2의 N제곱만큼 시간소요 
// 해결하기 위해 메모이제이션(memoization) 기법 사용 : 이미 계산한 결과는 배열에 저장함 -> O(N)만큼만 소요  
int dp(int x){
	if(x == 1){
		return 1;
	}
	if(x == 2){
		return 1;
	}
	if(d[x] != 0){
		return d[x];
	}
	return d[x] = dp(x - 1) + dp(x - 2);
}

int main(void){
	printf("%d", dp(40));
}

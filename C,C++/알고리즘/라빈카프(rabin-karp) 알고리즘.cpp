/*
	라빈 카프(rabin-karp) 알고리즘 : 특이한 문자열 매칭 알고리즘 , 항상 빠르지는 않지만 일반적인 경우 빠르게 작동하는 간단한 구조의 문자열 매칭 알고리즘
									,해시 기법을 사용
	라빈 카프 알고리즘의 특징 : 여러 개의 문자열을 비교할 때 항상 해시 값을 구하여 비교하고,
								해시 값은 거의 일치하는 일이 없기 때문에 '긴 글'과 '부분 문자열'의 해시 값이 일치하는 경우에만
								문자열을 재검사하여 정확히 일치하는지 확인하는 알고리즘이다.									
	해시 : 긴 데이터를 그것을 상징하는 짧은 데이터롤 바꾸어주는 기법 -> 연산 속도가 O(1) 							   
		: 각 문자의 아스키 코드 값에 2의 제곱 수를 차례대로 곱하여 더해준 것, 서로 다른 문자열의 경우 일반적으로 해시 값이 다르게 나온다. 
*/

#include <iostream>

using namespace std;

void findString(string parent, string pattern){
	int parentSize = parent.size();
	int patternSize = pattern.size();
	int parentHash = 0, patternHash = 0, power = 1;
	for(int i = 0; i <= parentSize - patternSize; i++){
		if(i == 0){
			for(int j = 0; j < patternSize; j++){
				parentHash += parent[patternSize - 1 - j] * power;
				patternHash += pattern[patternSize - 1 - j] * power;
				if(j < patternSize -1) power *= 2;
			}
		}else{
			// 긴 글 해시 값 = 2 * (긴 글 해시 값 - 가장 앞에 있는 문자의 수치) + 새롭게 둘어온 문자의 수치  
			parentHash = 2 * (parentHash - parent[i - 1] * power) + parent[patternSize - 1 + i];
		}
		if(parentHash == patternHash){
			bool finded = true;
			for(int j = 0; j < patternSize; j++){
				if(parent[i + j] != pattern[j]){
					finded = false;
					break;
				}
			}
			if(finded){
				printf("%d번째에서 발견했습니다.\n",i + 1);
			}
		}
	}
}

int main(void){
	string parent = "ababacabacaabacaaba";
	string pattern = "abacaaba";
	findString(parent,pattern);
}


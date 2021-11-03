/*
	그리디(greedy) 알고리즘 : 당장 눈 앞에 보이는 최적의 상황만을 쫓는 알고리즘
	대표적인 예 -> 거스름 돈 문제 
*/

#include <iostream>

using namespace std;

int main(void){
	int n, result = 0;
	cin >> n;
	result += n / 500;
	n %= 500;
	result += n / 100;
	n %= 100;
	result += n / 50;
	n %= 50;
	result += n / 10;
	cout << result;
	return 0;
	
}

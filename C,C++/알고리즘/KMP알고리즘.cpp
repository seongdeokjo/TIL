/*
	KMP(Knuth-Morris-Pratt) 알고리즘 :  모든 경우를 다 비교하지 않아도 부분 문자열을 찾을 수 있는 알고리즘
	접두사와 접미사를 사용하여 -> 반복 되는 연산을 얼마나 줄일 수 있는지를 판변하여 매칭할 문자열을 빠르게 점프하는 기법 
	접두사와 접미사가 일치하는 최대 길이	
*/
 #include <iostream>
 #include <vector>
 
 using namespace std;
 
 // 하나씩 접두사와 접미사를 늘려가며 비교하다가 일치하지 않는 경우가 발생하면
 // 일치했던 부분까지 되돌아가서 다시 검사를 하는 방식으로 최대 일치 길이 테이블 구축 메서드  
 vector<int> makeTable(string pattern){	
 	int patternSize = pattern.size();
 	vector<int> table(patternSize, 0);
 	int j = 0;
 	for(int i = 1; i < patternSize; i++){
 		while(j > 0 && pattern[i] != pattern[j]){
 			j = table[j - 1];
		 }
		 if(pattern[i] == pattern[j]){
		 	table[i] = ++j;
		 }
	 }
	 return table;
 }

void kmp(string parent, string pattern){
	vector<int> table = makeTable(pattern);
	int parentSize = parent.size();
	int patternSize = pattern.size();
	int j = 0;
	for(int i = 0; i < parentSize; i++){
		while(j > 0 && parent[i] != pattern[j]){
			j = table[j - 1];
		}
		if(parent[i] == pattern[j]){
			if(j == patternSize -1){
				printf("%d번째에서 찾았습니다.\n",i - patternSize + 2);
				j = table[j];
			}else{
				j++;
			}
		}
	}
} 


int main(void){
	string parent = "ababacabacaabacaaba";
	string pattern = "abacaaba";
	kmp(parent,pattern);
/*	
	string pattern = "abacaaba";
	vector<int> table = makeTable(pattern);
	for(int i = 0; i < table.size(); i++){
		printf("%d ",table[i]);
	}
*/	
	return 0;
}

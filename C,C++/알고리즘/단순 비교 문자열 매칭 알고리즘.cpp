/*
	�ܼ� �� ���ڿ� ��Ī �˰��� : �ϳ��� Ȯ���ϴ� �˰��� 
*/

#include <iostream>

using namespace std;

int findString(string parent, string pattern){
	int parentSize = parent.size();
	int patternSize = pattern.size();
	printf("parentSize = %d, patternSize = %d\n",parentSize, patternSize);
	for(int i = 0; i <= parentSize - patternSize; i++){
		bool finded = true;
		for(int j =0; j < patternSize; j++){
			printf("parent[%d + %d] = %c, pattern[%d] = %c\n",i,j,parent[i+j],j,pattern[j]);
			if(parent[i + j] != pattern[j]){
				finded = false;
				break;
			}
		}
		if(finded){
			return i;
		}
	}
	return -1;
}

int main(void){
	string parent = "Hello World";
	string pattern = "llo W";
	int result = findString(parent, pattern);
	if(result == -1){
		printf("ã�� �� �����ϴ�.");
	}else{
		printf("%d��°���� ã�ҽ��ϴ�.",result);
	}
	return 0;
}

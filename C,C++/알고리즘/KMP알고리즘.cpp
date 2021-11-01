/*
	KMP(Knuth-Morris-Pratt) �˰��� :  ��� ��츦 �� ������ �ʾƵ� �κ� ���ڿ��� ã�� �� �ִ� �˰���
	���λ�� ���̻縦 ����Ͽ� -> �ݺ� �Ǵ� ������ �󸶳� ���� �� �ִ����� �Ǻ��Ͽ� ��Ī�� ���ڿ��� ������ �����ϴ� ��� 
	���λ�� ���̻簡 ��ġ�ϴ� �ִ� ����	
*/
 #include <iostream>
 #include <vector>
 
 using namespace std;
 
 // �ϳ��� ���λ�� ���̻縦 �÷����� ���ϴٰ� ��ġ���� �ʴ� ��찡 �߻��ϸ�
 // ��ġ�ߴ� �κб��� �ǵ��ư��� �ٽ� �˻縦 �ϴ� ������� �ִ� ��ġ ���� ���̺� ���� �޼���  
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
				printf("%d��°���� ã�ҽ��ϴ�.\n",i - patternSize + 2);
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

/*
	��� ī��(rabin-karp) �˰��� : Ư���� ���ڿ� ��Ī �˰��� , �׻� �������� ������ �Ϲ����� ��� ������ �۵��ϴ� ������ ������ ���ڿ� ��Ī �˰���
									,�ؽ� ����� ���
	��� ī�� �˰����� Ư¡ : ���� ���� ���ڿ��� ���� �� �׻� �ؽ� ���� ���Ͽ� ���ϰ�,
								�ؽ� ���� ���� ��ġ�ϴ� ���� ���� ������ '�� ��'�� '�κ� ���ڿ�'�� �ؽ� ���� ��ġ�ϴ� ��쿡��
								���ڿ��� ��˻��Ͽ� ��Ȯ�� ��ġ�ϴ��� Ȯ���ϴ� �˰����̴�.									
	�ؽ� : �� �����͸� �װ��� ��¡�ϴ� ª�� �����ͷ� �ٲپ��ִ� ��� -> ���� �ӵ��� O(1) 							   
		: �� ������ �ƽ�Ű �ڵ� ���� 2�� ���� ���� ���ʴ�� ���Ͽ� ������ ��, ���� �ٸ� ���ڿ��� ��� �Ϲ������� �ؽ� ���� �ٸ��� ���´�. 
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
			// �� �� �ؽ� �� = 2 * (�� �� �ؽ� �� - ���� �տ� �ִ� ������ ��ġ) + ���Ӱ� �Ѿ�� ������ ��ġ  
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
				printf("%d��°���� �߰��߽��ϴ�.\n",i + 1);
			}
		}
	}
}

int main(void){
	string parent = "ababacabacaabacaaba";
	string pattern = "abacaaba";
	findString(parent,pattern);
}


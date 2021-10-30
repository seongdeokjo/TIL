/*
	���� ����(topology sort) : ������ ������ �ִ� �۾��� ���ʷ� �����ؾ� �� �� �� ������ �������ֱ� ���� ����ϴ� �˰��� 
	*�� DAG(directed Acyclic graph)������ ���� ����, ����Ŭ�� �߻����� �ʴ� ���� �׷������ �ǹ� 
	Ư¡ : 1. ���� �׷����� ���� ������ ��������
	 	   2. ���� ������ �����ϴٸ� �� ����� ��������
	���ð� ť�� �̿��Ͽ� ���� ����
	
	ť�� �̿��ϴ� ���
	1. ���������� 0�� ������ ť�� ����
	2. ť���� ���Ҹ� ���� ����� ��� ������ ����
	3. ���� ���� ���Ŀ� ���������� 0�� �� ������ ť�� ����
	4. ť�� �� ������ 2�� ~ 3�� ������ �ݺ�. ��� ���Ҹ� �湮�ϱ� ����
		ť�� ��ٸ� ����Ŭ�� �����ϴ� ���̰�, ��� ���Ҹ� �湮�ߴٸ� ť���� ���� ������ ���� ������ ����̴�.			
*/

#include <iostream>
#include <vector>
#include <queue>
#define MAX 10

using namespace std;

int n, inDegree[MAX];
vector<int> a[MAX];

void topologySort(){
	int result[MAX];
	queue<int> q;
	// ���� ������ 0�� ��带 ť�� ����
	for(int i = 1; i <= n; i++){
		if(inDegree[i] == 0) q.push(i);
	} 
	
	// ���� ������ ������ ����Ƿ��� ��Ȯ�� N���� ��带 �湮
	for(int i = 1; i <= n; i++){
		// n���� �湮�ϱ� ���� ť�� �������� ����Ŭ�� �߻��� ��
		if(q.empty()) {
			printf("����Ŭ�� �߻�");
			return; 
		}
		
		int x = q.front();
		q.pop();
		result[i] = x;
		for(int i = 0; i < a[x].size(); i++){
			int y = a[x][i];
			// ���Ӱ� ���������� 0�� �� ������ ť�� ����
			if(--inDegree[y] == 0){
				q.push(y);
			} 
		}
	}
	
	for(int i = 1; i <= n; i++){
		printf("%d ", result[i]);
	}
}

int main(void){
	n = 7;
	a[1].push_back(2);
	inDegree[2]++;
	a[1].push_back(5);
	inDegree[5]++;
	a[2].push_back(3);
	inDegree[3]++;
	a[3].push_back(4);
	inDegree[4]++;
	a[4].push_back(6);
	inDegree[6]++;
	a[5].push_back(6);
	inDegree[6]++;
	a[6].push_back(7);
	inDegree[7]++;
	topologySort();
}



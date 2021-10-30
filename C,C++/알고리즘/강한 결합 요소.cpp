/* 
	���� ���� ���(Strongly Connected Component) : ���ϰ� ���յ� ���� ������ �ǹ� ,  SCC�˰���
	Ư¡ : SCC�� ���� SCC�� ���ϴ� �� ������ ���� ������ �����ϴ� 
	
	SCC�� �����ϴ� ��ǥ���� �˰��򿡴� �ڻ���� �˰���� Ÿ�� �˰����� �ִ�.
	 
	Ÿ�� �˰��� : ��� ������ ���� DFS�� �����Ͽ� SCC�� ã�� �˰���
	�θ�� ���ƿ� �� �ִ� ��ο� ���ؼ� SCC�� ������ �� �ִ�. 
*/

#include <iostream>
#include <vector>
#include <stack>
#define MAX 10001
using namespace std;

int id, d[MAX];
bool finished[MAX];
vector<int> a[MAX];
vector<vector<int> > SCC;
stack<int> s;

// DFS�� �� ������ ������ŭ ����ȴ�
int dfs(int x){
	printf("x = %d \n",x);
	d[x] = ++id; // ��帶�� ������ ��ȣ �Ҵ� 
	printf("d[%d] = %d \n", x,id);
	s.push(x); // ���ÿ� �ڱ� �ڽ��� �����Ѵ�
	
	int parent = d[x];
	printf("1.parent = %d\n", parent);
	printf("a[%d].size() = %d\n",x, a[x].size());
	for(int i = 0; i < a[x].size(); i++){
		printf("a[%d][%d] = %d \n", x,i,a[x][i]);
		int y = a[x][i];
		printf("y = %d \n",y);
		// �湮���� ���� �̿�
		if(d[y] == 0) {
			printf("�湮���� ���� �̿�\n");
			parent = min(parent,dfs(y));
			printf("2.parent = %d \n",parent);	
		}
		// ó�� ���� �̿�
		else if(!finished[y]) {
			printf("ó�� ���� �̿�\n");
			printf("d[%d] = %d \n",y,d[y]);
			parent = min(parent, d[y]);
			printf("3.parent = %d\n",parent);	
		}
		 
	} 
	
	// �θ� ��尡 �ڱ� �ڽ��� ���
	if(parent == d[x]){
		printf("�θ� ��尡 �ڱ� �ڽ��� ���\n parent = %d\n",parent);
		vector<int> scc;
		while(1){
			int t = s.top();
			printf("t = %d \n",t);
			s.pop();
			scc.push_back(t);
			finished[t] = true;
			if(t == x) break;
		}
		SCC.push_back(scc);
	}
	
	 // �ڽ��� �θ� ���� ��ȯ
	 return parent; 
} 

int main(void){
	int v = 11;
	a[1].push_back(2);
	a[2].push_back(3);
	a[3].push_back(1);
	a[4].push_back(2);
	a[4].push_back(5);
	a[5].push_back(7);
	a[6].push_back(5);
	a[7].push_back(6);
	a[8].push_back(5);
	a[8].push_back(9);
	a[9].push_back(10);
	a[10].push_back(11);
	a[11].push_back(3);
	a[11].push_back(8);
	
	for(int i = 1; i <= v; i++){
		printf("�ݺ��� ����\n d[%d]= %d \n", i,d[i]);
		if(d[i] == 0) dfs(i);
	}
	
	printf("SCC�� ���� : %d\n", SCC.size());
	for(int i = 0; i < SCC.size(); i++){
		printf("%d��° SCC: ",i + 1);
		for(int j = 0; j < SCC[i].size(); j++){
			printf("%d ", SCC[i][j]);
		}
		printf("\n");
	}
	return 0;
}


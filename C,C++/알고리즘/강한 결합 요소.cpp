/* 
	강한 결합 요소(Strongly Connected Component) : 강하게 결합된 정점 집합을 의미 ,  SCC알고리즘
	특징 : SCC는 같은 SCC에 속하는 두 정점은 서로 도달이 가능하다 
	
	SCC를 추출하는 대표적인 알고리즘에는 코사라주 알고리즘과 타잔 알고리즘이 있다.
	 
	타잔 알고리즘 : 모든 정점에 대해 DFS를 수행하여 SCC를 찾는 알고리즘
	부모로 돌아올 수 있는 경로에 한해서 SCC가 성립될 수 있다. 
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

// DFS는 총 정점의 갯수만큼 실행된다
int dfs(int x){
	printf("x = %d \n",x);
	d[x] = ++id; // 노드마다 고유한 번호 할당 
	printf("d[%d] = %d \n", x,id);
	s.push(x); // 스택에 자기 자신을 삽입한다
	
	int parent = d[x];
	printf("1.parent = %d\n", parent);
	printf("a[%d].size() = %d\n",x, a[x].size());
	for(int i = 0; i < a[x].size(); i++){
		printf("a[%d][%d] = %d \n", x,i,a[x][i]);
		int y = a[x][i];
		printf("y = %d \n",y);
		// 방문하지 않은 이웃
		if(d[y] == 0) {
			printf("방문하지 않은 이웃\n");
			parent = min(parent,dfs(y));
			printf("2.parent = %d \n",parent);	
		}
		// 처리 중인 이웃
		else if(!finished[y]) {
			printf("처리 중인 이웃\n");
			printf("d[%d] = %d \n",y,d[y]);
			parent = min(parent, d[y]);
			printf("3.parent = %d\n",parent);	
		}
		 
	} 
	
	// 부모 노드가 자기 자신인 경우
	if(parent == d[x]){
		printf("부모 노드가 자기 자신인 경우\n parent = %d\n",parent);
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
	
	 // 자신이 부모 값을 반환
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
		printf("반복문 시작\n d[%d]= %d \n", i,d[i]);
		if(d[i] == 0) dfs(i);
	}
	
	printf("SCC의 갯수 : %d\n", SCC.size());
	for(int i = 0; i < SCC.size(); i++){
		printf("%d번째 SCC: ",i + 1);
		for(int j = 0; j < SCC[i].size(); j++){
			printf("%d ", SCC[i][j]);
		}
		printf("\n");
	}
	return 0;
}


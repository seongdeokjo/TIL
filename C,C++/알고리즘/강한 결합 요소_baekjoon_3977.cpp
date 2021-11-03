/*
	강한 결합 요소 기초 문제 풀이
	baekjoon- 3977 : 축구 전술 
*/

#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#define MAX 100001

using namespace std;

int n, m;
int id,  d[MAX];
bool finished[MAX];
vector<int> a[MAX];
vector<vector<int> > SCC;
stack<int> s;
int group[MAX];
bool inDegree[MAX];
vector<int> result;

//항상 처음 방문하는 노드만 실행. 즉, N번 수행
int dfs(int x){
	d[x] = ++id;
	s.push(x);
	
	int result = d[x];
	for(int i = 0; i < a[x].size(); i++){
		int y = a[x][i];
		// 아직 방문하지 않은 이웃 노드인 경우
		if(d[y] == 0) result = min(result, dfs(y));
		// 방문은 했지만 아직 처리 중인 이웃 노드인 경우
		else if(!finished[y]) result = min(result, d[y]); 
	}
	
	// 부모 노드가 자기 자신인 경우 SCC를 형성
	if(result == d[x]){
		vector<int> scc;
		while(1){
			int t = s.top();
			s.pop();
			scc.push_back(t);
			group[t] = SCC.size() + 1;
			finished[t] = true;
			if(t == x) break;
		}
		SCC.push_back(scc);
	} 
	
	// 자신의 부모 값을 반환
	return result; 	
}  

int main(void){
	int t;
	scanf("%d", &t);
	while(t--){
		SCC.clear();
		fill(d, d + MAX, 0);
		fill(finished, finished + MAX, 0);
		fill(inDegree, inDegree + MAX, false);
		result.clear();
		scanf("%d %d", &n, &m);
		for(int i = 1; i <=n; i++){
			a[i].clear();
		}
		for(int i = 0; i < m; i++){
			int x, y;
			scanf("%d %d", &x, &y);
			a[x + 1].push_back(y + 1);
		}
		for(int i = 1; i <= n; i++){
			if(d[i] == 0) dfs(i);
		}
		for(int i = 1; i <= n; i++){
			for(int j = 0; j < a[i].size(); j++){
				int y = a[i][j];
				if(group[i] != group[y]){
					inDegree[group[y]] = true;
				}
			}
		}
		int count = 0;
		for(int i = 0; i < SCC.size(); i++){
			if(!inDegree[i]) {
				count++;
				for(int j = 0; j < SCC[i].size(); j++){
					result.push_back(SCC[i][j] - 1);
				}
			}
		}
		sort(result.begin(), result.end());
		if(count != 1){
			printf("Confused\n\n");	
		}else {
			for(int i = 0; i < result.size(); i++){
				printf("%d\n", result[i]);
			}
			printf("\n");
		}
	}
	return 0;
}

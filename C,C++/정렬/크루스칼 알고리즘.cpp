/*
	크루스칼 알고리즘(Kruskal algorithm) : 가장 적은 비용으로 모든 노드를 연결하기 위해 사용하는 알고리즘, 
										   최소 비용 신장 트리를 만들기 위한 대표적인 알고리즘 
	노드 = 정점 = 도시 : 그래프에서 동그라미에 해당하는 부분
	간선 = 거리 = 비용 : 그래프에서 선에 해당하는 부분 
	
	일단 모든 노드를 최대한 적은 비용으로 '연결만' 시키면 되기 때문에
	모드 간선 정보를 오름차순으로 정렬한 뒤에 비용이 적은 간선부터 차근차근 그래프에 포함시킨다.
	
	1. 정렬된 순서에 맞게 그래프에 포함시킨다.
	2. 포함시키기 전에는 사이클 테이블을 확인한다.
	3. 사이클을 형성하는 경우 간선을 포함하지 않는다.
	* 사이클 발생하는지 여부는 union-find 알고리즘 적용 
	* 사이클이란 -> 그래프가 서로 연결되어 사이클을 형성하는 경우 
	ex) 노드 : 1,2,3 -> 1,3 / 1,2 / 2,3 사이클 형성됨(x) | 1,3 / 1,2 (o)  
	
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std; 

// 부모 노드를 찾는 함수 
int getParent(int parent[], int x){
	if(parent[x] == x){
		return x;
	}

	return parent[x] = getParent(parent, parent[x]);
}

// 두 부모 노드를 합치는 함수 
int unionParent(int parent[], int a, int b){
	a = getParent(parent, a);
	b = getParent(parent, b);

	if(a < b){
		parent[b] = a;
	}else{
		parent[a] = b;
	}

}

// 같은 부모를 가지는지 확인 
int findParent(int parent[], int a, int b){
	a = getParent(parent, a);
	b = getParent(parent, b);
	if(a == b){
		return 1;
	}
	return 0;
} 

// 간선 클래스 선언
class Edge{
public:
	int node[2];
	int distance;
	Edge(int a, int b, int distance){
		this->node[0] = a;
		this->node[1] = b;
		this->distance = distance;
	}
	bool operator <(Edge & edge){
		return this->distance < edge.distance;
	}
}; 


int main(void){
	int n = 7; // 노드의 개수 
	int m = 11; // 간선의 개수 
	
	vector<Edge> v;
	v.push_back(Edge(1, 7, 12));
	v.push_back(Edge(1, 4, 28));
	v.push_back(Edge(1, 2, 67));
	v.push_back(Edge(1, 5, 17));
	v.push_back(Edge(2, 4, 24));
	v.push_back(Edge(2, 5, 62));
	v.push_back(Edge(3, 5, 20));
	v.push_back(Edge(3, 6, 37));
	v.push_back(Edge(4, 7, 13));
	v.push_back(Edge(5, 6, 45));
	v.push_back(Edge(5, 7, 73));
	
	
	// 간선의 비용을 기준으로 오름차순 정렬
	sort(v.begin(), v.end());
	
	// 각 정점이 포함된 그래프가 어디인지 저장
	int parent[n];
	for(int i = 0; i < n; i++){
		parent[i] = i;
	} 
	// 거리의 합을 0으로 초기화 
	int sum = 0;
	for(int i = 0; i < v.size(); i++) {
		// 동일한 부모를 가르키지 않는 경우, 즉 사이클이 발생하지 않는 경우 그래프에 포함
		if(!findParent(parent, v[i].node[0] - 1, v[i].node[1] - 1)){
			sum += v[i].distance;
			unionParent(parent, v[i].node[0] - 1, v[i].node[1] - 1);
		} 
	
	}
	
	printf("%d\n",sum);
	
}

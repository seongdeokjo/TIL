/*
	다익스트라(dijkstra) 알고리즘 : 최단 경로 탐색 알고리즘
	이 알고리즘이 다이나믹 프로그래밍 문제인 이유 : 최단 거리는 여러 개의 최단 거리로 이루어져 있다. 

	작동과정 :
	1. 출발 노드를 선정
	2. 출발 노드를 기준으로 각 노드의 최소 비용을 저장
	3. 방문하지 않은 노드 중에서 가장 비용이 적은 노드를 선택
	4. 해당 노드를 거쳐서 특정한 노드로 가는 경우를 고려하여 최소 비용을 갱신
	5. 위 과정에서 3번 ~ 4번을 반복 
*/

#include <stdio.h>

int number = 6;
int INF = 1000000000;
// 선형 탐색 이용 
//전체 그래프를 초기화
int a[6][6] = {
	{0, 2, 5, 1, INF,INF},
	{2, 0, 3, 2, INF, INF},
	{5, 3, 0, 3, 1, 5},
	{1, 2, 3, 0, 1, INF},
	{INF, INF, 1, 1, 0, 2},
	{INF, INF, 5, INF, 2, 0}	
};

bool v[6]; // 방문한 노드 
int d[6]; // 거리

// 가장 최소 거리를 가지는 정점을 반환
int getSmallIndex(){
	int min = INF;
	int index = 0;
	for(int i = 0; i < number; i++){
		if(d[i] < min && !v[i]){
			min = d[i];
			index = i;
		}
	}
	return index;
} 

// 다익스트라를 수행하는 함수
void dijkstra(int start){
	for(int i = 0; i < number; i++){
		d[i] = a[start][i];
	}
	v[start] = true;
	for(int i = 0; i < number -2; i++){
		int current = getSmallIndex();
		v[current] = true;
		for(int j = 0; j < 6; j++){
			if(!v[j]){
				if(d[current] + a[current][j] < d[j]){
					d[j] = d[current] + a[current][j];
				}
			}
		}
	}
}

int main(void){
	dijkstra(0);
	for(int i = 0; i < number; i++){
		printf("%d ", d[i]);
	}
} 

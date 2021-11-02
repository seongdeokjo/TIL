/*
	�̺� ��Ī ���� ���� Ǯ��
	baekjoon-1671 : ����� ���� �Ļ� 
*/

#include <iostream>
#include <vector>
#define MAX 1001

using namespace std;

vector<int> a[MAX];
int stat[MAX][3]; 
int d[MAX];
bool c[MAX];
int n;

// ��Ī�� ������ ��� true, ������ ��� false
bool dfs(int x){
	// ����� ��� ��忡 ���ؼ� ��  �� �ִ��� �õ�
	for(int i = 0; i < a[x].size(); i++){
		int t = a[x][i];
		// �̹� ó���� ���� �� �̻� �� �ʿ䰡 ����.
		if(c[t]) continue;
		c[t] = true;
		// ����ְų� ���� ��忡 �� �� ������ �ִ� ���
		if(d[t] == 0 || dfs(d[t])){
			d[t] = x;
			return true;
		}
	}
	return false; 
} 


int main(void){
	scanf("%d", &n);
	for(int i = 1; i <= n; i++){
		int a, b, c;
		scanf("%d %d %d", &stat[i][0], &stat[i][1], &stat[i][2]);
	}
	for(int i = 1; i <= n -1; i++){
		for(int j = i + 1; j <= n; j++){
			if(stat[i][0] == stat[j][0] && stat[i][1] == stat[j][1] && stat[i][2] == stat[j][2]){
				a[i].push_back(j);
			}else if(stat[i][0] >= stat[j][0] && stat[i][1] >= stat[j][1] && stat[i][2] >= stat[j][2]){
				a[i].push_back(j);
			}else if(stat[i][0] <= stat[j][0] && stat[i][1] <= stat[j][1] && stat[i][2] <= stat[j][2]){
				a[j].push_back(i);
			}
		
		}
	}
	int count = 0;
	for(int k = 0; k < 2; k++){
		for(int i = 1; i <= n; i++){
			fill(c, c + MAX, false);
			if(dfs(i)) count++;	
		}
	}	
	printf("%d\n", n - count);
	return 0;
}

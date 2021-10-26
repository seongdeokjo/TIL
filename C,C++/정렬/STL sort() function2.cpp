#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// STL sort() �Լ� �ٷ�� 2 
bool compare(pair<string, pair<int,int> > a,
			 pair<string, pair<int, int> > b){
	// ���� ������ ���ٸ�		 	
	if(a.second.first == b.second.first){
		// ��������� �� ��л��� �켱������ ���� 
		return a.second.second > b.second.second;
	}else{
		return a.second.first > b.second.first;
	}
}



int main(void){

	vector<pair<string, pair<int,int> > > v;
	v.push_back(pair<string, pair<int,int> >("��ö��", pair<int,int>(90,19901234)));
	v.push_back(pair<string, pair<int,int> >("��ö��", pair<int,int>(80,19911234)));
	v.push_back(pair<string, pair<int,int> >("��ö��", pair<int,int>(70,19921234)));
	v.push_back(pair<string, pair<int,int> >("��ö��", pair<int,int>(70,19931234)));
	v.push_back(pair<string, pair<int,int> >("��ö��", pair<int,int>(75,19941234)));
	
	sort(v.begin(), v.end(), compare);
	for(int i =0; i < v.size(); i++){
		cout << v[i].first << ' ';
	}
	
} 

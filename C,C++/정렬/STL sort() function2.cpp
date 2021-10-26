#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// STL sort() 함수 다루기 2 
bool compare(pair<string, pair<int,int> > a,
			 pair<string, pair<int, int> > b){
	// 만약 점수가 같다면		 	
	if(a.second.first == b.second.first){
		// 생년월일이 더 어린학생이 우선순위가 높다 
		return a.second.second > b.second.second;
	}else{
		return a.second.first > b.second.first;
	}
}



int main(void){

	vector<pair<string, pair<int,int> > > v;
	v.push_back(pair<string, pair<int,int> >("김철수", pair<int,int>(90,19901234)));
	v.push_back(pair<string, pair<int,int> >("박철수", pair<int,int>(80,19911234)));
	v.push_back(pair<string, pair<int,int> >("조철수", pair<int,int>(70,19921234)));
	v.push_back(pair<string, pair<int,int> >("지철수", pair<int,int>(70,19931234)));
	v.push_back(pair<string, pair<int,int> >("이철수", pair<int,int>(75,19941234)));
	
	sort(v.begin(), v.end(), compare);
	for(int i =0; i < v.size(); i++){
		cout << v[i].first << ' ';
	}
	
} 

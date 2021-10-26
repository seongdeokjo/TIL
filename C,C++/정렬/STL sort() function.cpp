
// c++ STL sort() 함수 다루기  1
#include <iostream>
#include <algorithm>

using namespace std;

class Student{
public:
	string name;
	int score;
	
	Student(string name, int score){
		this->name = name;
		this->score = score;
	}
	
	// 정렬 기준은 '점수가 작은 순서'
	bool operator <(Student & student){
		return this->score < student.score;
	} 
};

/*
bool compare(int a, int b){
	return a < b; // 오름차순 정렬 
}
*/
int main(void){
	/*
	int a[10] = {9, 3, 5, 4, 1, 10, 8, 6, 7, 2};
	// 정렬할 배열 변수, 데이터의 개수  
	sort(a, a+10, compare);
	for(int i = 0; i< 10; i++){
		cout << a[i] << ' ';
	}
	*/
		
	Student students[] = {
		Student("김철수", 90),
		Student("박나미", 80),
		Student("이순신", 87),
		Student("강감찬", 76),
		Student("세종대왕", 93)	 
	};
	
	sort(students, students + 5);
	for(int i =0; i< 5; i++){
		cout << students[i].name << ' '; 
	}
	
	
}

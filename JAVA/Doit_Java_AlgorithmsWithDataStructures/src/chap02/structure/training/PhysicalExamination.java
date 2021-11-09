package chap02.structure.training;

import java.util.Scanner;

//간단한 클래스의 정의 : class란? 임의의 데이터형을 자유로이 조합하여 만들 수 있는 자료구조
class XYZ {
	// 필드 : 데이터의 요소
	int x; // int형 필드
	long y; // long형 필드
	double z; // double형 필드
}

public class PhysicalExamination {
	// 클래스의 배열
	static final int VMAX = 21; // 시력 분포(0.0에서 0.1 단위로 21개)

	static class PhyscData {
		String name;
		int height;
		double vision;

		// 생성자
		public PhyscData(String name, int heihgt, double vision) {
			this.name = name;
			this.height = heihgt;
			this.vision = vision;
		}
	}
	
	// 키의 평균값을 구함
	static double aveHeight(PhyscData[] dat) {
		double sum = 0;
		
		for(int i = 0; i < dat.length; i++) {
			sum += dat[i].height;
		}
		return sum / dat.length;
	}
	
	// 시력 분포를 구함
	static void distVision(PhyscData[] dat, int[] dist) {
		int i = 0;
		
		dist[i] = 0;
		for(i = 0; i < dat.length; i++) {
			if(dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0) {
				dist[(int)(dat[i].vision * 10)]++;
			}
		}
	}

	public static void main(String[] args) {
		XYZ a; // 클래스 형 변수 선언
		a = new XYZ(); // 클래스의 인스턴스 실체를 생성
		XYZ b = new XYZ(); // 변수와 인스턴스 생성을 한꺼번에 선언

		Scanner stdIn = new Scanner(System.in);
		
		PhyscData[] x = {
			new PhyscData("이순신", 162, 0.3),
			new PhyscData("강감찬", 172, 0.7),
			new PhyscData("세종대왕", 180, 1.2),
			new PhyscData("이이", 184, 1.0),
			new PhyscData("장보고", 192, 1.7),
			new PhyscData("한석봉", 176, 2.0),
			new PhyscData("권율", 171, 0.9),
		};
		int[] vdist = new int[VMAX]; // 시력분포
		
		System.out.println(" 신체검사 리스트 ");
		System.out.println("이름        키   시력");
		System.out.println("=========================");
		for(int i = 0; i < x.length; i++) {
			System.out.printf("%-9s%3d%5.1f\n",x[i].name, x[i].height, x[i].vision);
		}
		
		System.out.printf("\n평균 키: %5.1fcm\n",aveHeight(x));
		
		distVision(x, vdist); // 시력 분포를 구함
		
		System.out.println("\n시력 분포");
		for(int i = 0; i < VMAX; i++) {
			System.out.printf("%3.1f~ :%2d명\n",i / 10.0, vdist[i]);
		}
	}
}

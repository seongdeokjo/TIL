package chap03.searchingAlgorithm.binarySearch.training;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {
	// 신체검사 데이터 배열에서 이진 검색하기

	// 신체 검사 데이터를 정의
	static class PhyscData {
		private String name;
		private int height;
		private double vision;

		// 생성자
		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}

		// 문자열을 반환하는 메서드
		public String toString() {
			return name + " " + height + " " + vision;
		}

		// 오름차순으로 정렬하기 위한 comparator
		public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

		private static class HeightOrderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				// 1일 경우 자리바꿈 : 앞 수 가 크기 때문에 뒤에 수와 자리바꿈 .... -> 오름차순
				return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		PhyscData[] x = {
				new PhyscData("강감찬", 162, 0.3),
				new PhyscData("이순신", 190, 0.6),
				new PhyscData("광개토", 173, 0.8),
				new PhyscData("세종대왕", 185, 1.3),
				new PhyscData("한석봉", 166, 1.5),
				new PhyscData("김유신", 178, 0.7),
				new PhyscData("계백", 189, 2.0),
		};
		
		System.out.print("몇 cm인 사람을 찾고 있나요? : ");
		int height = stdIn.nextInt();
		int idx = Arrays.binarySearch(
				x,									// 배열 x에서 
				new PhyscData("", height, 0.0), 	// 키가 height인 요소를
				PhyscData.HEIGHT_ORDER);			// HEIGHT_ORDER에 의해 검색
		
		if(idx < 0) {
			System.out.println("요소가 없습니다.");
		}else {
			System.out.println("x["+idx+"] 에 있습니다.");
			System.out.println("찾은 데이터 : "+x[idx]);
		}
	}
}
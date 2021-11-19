package chap10.binTree.training;

import java.util.Scanner;

public class BinTreeTester {
	//이진검색트리의 클래스 이용 예
	
	static Scanner stdIn = new Scanner(System.in);
	
	// 데이터(회원 번호 + 이름)
	static class Data{
		public static final int NO = 1;
		public static final int NAME = 2;
		
		private Integer no;
		private String name;
		
		// 키 값
		Integer keyCode() {
			return no;
		}
		
		// 문자열 반환
		public String toString() {
			return name;
		}
		
		// 데이터 입력
		void scanData(String guide, int sw) {
			System.out.println(guide + "할 데이터를 입력하세요.");
			
			if((sw & NO) == NO) {
				System.out.print("번호 : ");
				no = stdIn.nextInt();
			}
			if((sw & NAME) == NAME) {
				System.out.print("이름 : ");
				name = stdIn.next();
			}
		}
	}
	
	// 메뉴 열거형
	enum Menu{
		ADD( "삽입"),
		REMOVE( "삭제"),
		SEARCH( "검색"),
		PRINT( "표시"),
		TERMINATE("종료");
		
		private final String message;
		
		static Menu MenuAt(int idx) {
			for(Menu m : Menu.values()) {
				if(m.ordinal() == idx) {
					return m;
				}
			}
			return null;
		}
		
		Menu(String string){
			message = string;
		}
		
		String getMessage() {
			return message;
		}
	}
	
	static Menu SelectMenu() {
		int key;
		do {
			for(Menu m : Menu.values()) {
				System.out.printf("(%d) %s ",m.ordinal(),m.getMessage());
			}
			System.out.print(" : ");
			key = stdIn.nextInt();
		}while(key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());
		return Menu.MenuAt(key);
	}
	
	public static void main(String[] agrs) {
		Menu menu;
		Data data;
		Data ptr;
		Data temp = new Data();
		BinTree<Integer, Data> tree = new BinTree<Integer, Data>();
		
		do {
			switch(menu = SelectMenu()) {
			case ADD:
				data = new Data();
				data.scanData("삽입", Data.NO | Data.NAME);
				tree.add(data.keyCode(), data);
				break;
			
			case REMOVE:
				temp.scanData("검색", Data.NO);
				ptr = tree.search(temp.keyCode());
				if(ptr != null) {
					System.out.println("그 번호의 이름은 "+ptr+"입니다.");
				}else {
					System.out.println("해당 데이터가 없습니다.");
				}
				break;
				
			case PRINT:
				tree.print();
				break;
			}
		}while(menu != Menu.TERMINATE);
	}
}
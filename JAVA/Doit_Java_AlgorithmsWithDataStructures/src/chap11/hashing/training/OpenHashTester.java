package chap11.hashing.training;

import java.util.Scanner;

public class OpenHashTester {
	static Scanner stdIn = new Scanner(System.in);
	
	// 데이터(회원 번호 + 이름)
	static class Data{
		static final int NO = 1;
		static final int NAME = 2;
		
		private Integer no;
		private String name;
		
		// 키 값
		Integer keyCode() {
			return no;
		}
		
		// 문자열을 반환
		public String toString() {
			return name;
		}
		
		// 데이터를 입력
		void scanData(String guide, int sw) {
			System.out.println(guide+"할 데이터를 입력하세요.");
			
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
		ADD( "추가"),
		REMOVE( "삭제"),
		SEARCH( "검색"),
		DUMP( "표시"),
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
	
	// 메뉴 선택
	static Menu SelectMenu() {
		int key;
		do {
			for(Menu m : Menu.values()) {
				System.out.printf("(%d) %s ",m.ordinal(), m.getMessage());
			}
			System.out.print(" : ");
			key = stdIn.nextInt();
		}while(key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());
		
		return Menu.MenuAt(key);
	}
	
	public static void main(String[] args) {
		Menu menu;
		Data data;
		Data temp = new Data();
		
		OpenHash<Integer, Data> hash = new OpenHash<>(13);
		
		do {
			switch(menu = SelectMenu()) {
			case ADD:
				data = new Data();
				data.scanData("추가", Data.NO | Data.NAME);
				hash.add(data.keyCode(), data);
				break;
				
			case REMOVE:
				temp.scanData("삭제", Data.NO);
				hash.remove(temp.keyCode());
				break;
				
			case SEARCH:
				temp.scanData("검색", Data.NO);
				Data t = hash.search(temp.keyCode());
				if(t != null) {
					System.out.println("그 키를 갖는 데이터는 "+t+"입니다.");
				}else {
					System.out.println("그 데이터가 없습니다.");
				}
				break;
				
			case DUMP:
				hash.dump();
				break;
			}
		}while(menu != Menu.TERMINATE);
		
	}
}

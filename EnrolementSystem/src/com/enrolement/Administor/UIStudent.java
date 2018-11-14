package com.enrolement.Administor;

/**
 * 학생관리자의 학생 UI를 담당하는 클래스
 * @author 정세연
 *
 */
public class UIStudent { // 학생UI
	/**
	 * 학생관리자 시스템 시작메뉴 UI
	 * 
	 */
	public void studMenu() {
		System.out.println();
		System.out.println("----------------------------------------------------------------");
		System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★");
		System.out.println("\t	학생 관리자 시스템");
		System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★");
		System.out.println("----------------------------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println("1. [학생 추가하기]");
		System.out.println();
		System.out.println("2. [학생 수정하기]");
		System.out.println();
		System.out.println("3. [학생 삭제하기]");
		System.out.println();
		System.out.println("4. [학생 목록보기]");
		System.out.println();
		System.out.println("5. [학생 검색하기]");
		System.out.println();
		System.out.println("0. [종	료]");
		System.out.println();

		System.out.print("선	택 : ");

	}

	public static final int ADD = 1; //학생추가
	public static final int UPDATE = 2; //학생수정
	public static final int DELETE = 3; //학생삭제
	public static final int LIST = 4; //학생목록
	public static final int SEARCH = 5; //학생검색

	/**
	 * 학생 관리 작업후 띄울 각각의 메세지
	 * @param n 학생관리의 어떤 기능인가
	 */
	public void endComment(int n) {
		System.out.println();
		System.out.println("----------------------------------------------------------------");
		System.out.println();
		if (n == UIStudent.ADD) {
			System.out.println("학생정보 등록이 완료되었습니다.");
		} else if (n == UIStudent.UPDATE) {
			System.out.println("학생정보 수정이 완료되었습니다.");
		} else if (n == UIStudent.DELETE) {
			System.out.println("학생정보 삭제가 완료되었습니다.");
		} else if (n == UIStudent.LIST) {
			System.out.println("");
		} else if (n == UIStudent.SEARCH) {
			System.out.println("");
		}
		System.out.println();
		System.out.println("1.한번더 실행하기\t2.상위메뉴로 돌아가기");
		System.out.print("[번호 선택] : ");
	}

	
	public static final int NAME = 5;// 학생이름
	public static final int ID = 6; // 학번
	public static final int GRADE = 7; // 학년
	public static final int TEL = 8; // 전화번호
	public static final int AGE = 9; // 나이
	public static final int ADDRESS = 10; // 주소
	public static final int CODE = 11; // 학과코드
	/**
	 * 학생 정보 입력받을시 띄울 각각의 라벨
	 * @param m 어떤 요소 라벨인가를 구분하기위한 변수
	 */
	public void eachElement(int m) {
		if (m == UIStudent.NAME) {
			System.out.print("[학생 이름] : ");
		} else if (m == UIStudent.ID) {
			System.out.print("[학생 학번] : ");
		} else if (m == UIStudent.GRADE) {
			System.out.print("[학     년] : ");
		} else if (m == UIStudent.TEL) {
			System.out.print("[전화 번호] : ");
		} else if (m == UIStudent.AGE) {
			System.out.print("[나     이] : ");
		} else if (m == UIStudent.ADDRESS) {
			System.out.print("[주     소] : ");
		} else if (m == UIStudent.CODE) {
			System.out.print("[학과(코드)] : ");
		}
	}

	/**
	 * 학생 관리 기능별 각각의 제목
	 * @param n 어떤 기능의 제목을 띄울지 구분하기위함
	 */
	public void title(int n) {
		System.out.println("----------------------------------------------------------------");
		System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★");

		if (n == UIStudent.ADD) {
			System.out.println("\t	    학생추가");
		} else if (n == UIStudent.UPDATE) {
			System.out.println("\t	    학생수정");
		} else if (n == UIStudent.DELETE) {
			System.out.println("\t	    학생삭제");
		} else if (n == UIStudent.LIST) {
			System.out.println("\t	  학생목록보기");
		} else if (n == UIStudent.SEARCH) {
			System.out.println("\t	    학생검색");
		}

		System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★");
		System.out.println("----------------------------------------------------------------");
	}

	/**
	 * 학생관리 오류시 띄울 각각의 메세지
	 * @param n 어떤 기능의 메세지를 띄울지 결정
	 */
	public void errorComment(int n) {
		System.out.println();
		System.out.println("----------------------------------------------------------------");
		System.out.println();
		if (n == UIStudent.ADD) {
			System.out.println("추가가 완료되지 못했습니다.");
		} else if (n == UIStudent.UPDATE) {
			System.out.println("수정이 완료되지 못했습니다.");
		} else if (n == UIStudent.DELETE) {
			System.out.println("삭제가 완료되지 못했습니다.");
		} else if (n == UIStudent.LIST) {
			System.out.println("");
		} else if (n == UIStudent.SEARCH) {
			System.out.println("");
		}
		System.out.println();
		System.out.println("1.한번더 실행하기\t2.상위메뉴로 돌아가기");
		System.out.print("[번호 선택] : ");
	}

}
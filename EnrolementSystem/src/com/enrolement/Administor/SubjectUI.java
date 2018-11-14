package com.enrolement.Administor;

/**
 *
 * 수강과목 메뉴 및 각 기능별 UI와 헤더파일을 관리하는 클래스
 * @author 한종균
 */
public class SubjectUI {
	/**
	 * 과목 생성
	 */
	public static final int UiAdd =1; 
	/**
	 * 과목 수정
	 */
	public static final int UiUpdate =2; 
	/**
	 * 과목 삭제
	 */
	public static final int UiDelete=3; 
	/**
	 * 과목 목록
	 */
	public static final int UiList =4; 
	
	
	/**
	 * 수강과목 관리 메뉴 UI 호출 메소드
	 */
	public void subjectMenu() {
		System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println("\t   수강과목 관리");
		System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println();
		System.out.println("\t1. 수강과목 전공");
		System.out.println("\t2. 수강과목 교양");
		System.out.println("\t0. 상위메뉴로 돌아가기");
		System.out.print("선택 : ");
	}
	
	/**
	 * 수강과목 전공 메뉴 UI 호출 메소드
	 */
	public void UiMajorSubjectMain() {
		System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println("\t   수강과목 전공");
		System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println();
		System.out.println("\t1.[수강과목 생성(전공)]");
		System.out.println("\t2.[수강과목 수정(전공)]");
		System.out.println("\t3.[수강과목 삭제]");
		System.out.println("\t4.[수강과목 목록(전공)]");
		System.out.println("\t0.[상위메뉴로 돌아가기]");
		System.out.print("선택 : ");
	}
	
	/**
	 * 수강과목 교양 메뉴 UI 호출 메소드
	 */
	public void UiGeneralSubjectMain() {
		System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println("\t   수강과목 교양");
		System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println();
		System.out.println("\t1.[수강과목 생성(교양)]");
		System.out.println("\t2.[수강과목 수정(교양)]");
		System.out.println("\t3.[수강과목 삭제]");
		System.out.println("\t4.[수강과목 목록(교양)]");
		System.out.println("\t0.[상위메뉴로 돌아가기]");
		System.out.print("선택 : ");
	}
	
	/**
	 * 검색 타이틀 UI 호출 메솓,
	 */
	public void UiSearchMenu() {
		System.out.println("검색할 목록을 선택하시오!");
		System.out.print("1.학과 코드	2.교수코드 3.과목코드 4.상위메뉴로 돌아가기 선택 :");
	}

	
	/**
	 * 전공과목 타이틀(등록,수정,삭제,목록) UI 호출 메소드
	 * @param n 전공과목 타이틀 ui 선택
	 */
	public void MajorTitle(int n) {
		if(n==SubjectUI.UiAdd) {
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println("\t수강과목 생성(전공)");
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		}else if(n==SubjectUI.UiUpdate) {
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println("\t수강과목 수정(전공)");
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		}else if(n==SubjectUI.UiDelete) {
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println("\t수강과목 삭제");
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		}else if(n==SubjectUI.UiList) {
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println("\t수강과목 목록(전공)");
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		}
	}
	
	/**
	 * 교양과목 타이틀(등록,수정,삭제,목록) UI 호출 메소드 
	 * @param n - 교양과목 타이틀 ui 선택
	 */
	public void GeneralTitle(int n ) { 
		if(n==SubjectUI.UiAdd) {
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println("\t수강과목 생성(교양)");
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		}else if(n==SubjectUI.UiUpdate) {
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println("\t수강과목 수정(교양)");
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		}else if(n==SubjectUI.UiDelete) {
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println("\t수강과목 삭제");
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		}else if(n==SubjectUI.UiList) {
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println("\t수강과목 목록(교양)");
			System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		}	
	}
	
	
	
	
	/**
	 * 과목 종료(등록,수정,삭제,목록) 호출 메소드
	 * @param n - 종료 ui 선택
	 */
	public void subjectCompletMenu(int n) {
		if(n==SubjectUI.UiAdd) {
			System.out.println("------------------------------------------------------------------------");
			System.out.println("과목이 생성되었습니다.");
			System.out.println("------------------------------------------------------------------------");
			System.out.print("1.추가등록\t\t2.상위메뉴로 돌아가기\t\t선택 : ");
		}else if(n==SubjectUI.UiUpdate) {
			System.out.println("------------------------------------------------------------------------");
			System.out.println("과목이 수정되었습니다.");
			System.out.println("------------------------------------------------------------------------");
			System.out.print("1.추가수정\t\t2.상위메뉴로 돌아가기\t\t선택 : ");
		}else if(n==SubjectUI.UiDelete) {
			System.out.print("삭제 하시겠습니까?\t 1.Yes\t2.no\t선택 : ");
		}else if(n==SubjectUI.UiList) {
			System.out.println("목록이 출력되었습니다.");
			System.out.println("------------------------------------------------------------------------");
		}
		
		
	}
		
		
		

	

}

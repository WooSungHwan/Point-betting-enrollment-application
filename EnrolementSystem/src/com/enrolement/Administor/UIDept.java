package com.enrolement.Administor;


/**
 * 학과 관리 시스템의 기능을 가지고 있는 클래스
 * @author 정세윤
 *
 */
public class UIDept {
		/**
		 * 학과관리자 시스템 시작메뉴 UI
		 */
		public void deptMenu() {
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.println("\t	학과 관리자 시스템");
			System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			System.out.println();
			System.out.println("1. [학과 추가하기]");
			System.out.println();
			System.out.println("2. [학과 수정하기]");
			System.out.println();
			System.out.println("3. [학과 삭제하기]");
			System.out.println();
			System.out.println("4. [학과 목록보기]");
			System.out.println();
			System.out.println("5. [학과 검색하기]");
			System.out.println();
			System.out.println("0. [종	료]");
			System.out.println();
			
			System.out.print("선	택 : ");
			
		}
		
		
		public static final int ADD=1; 
		public static final int UPDATE=2;
		public static final int DELETE=3;
		public static final int LIST=4;
		public static final int SEARCH=5;
		
		/**
		 * 학과 기능 작업 완료후 띄울 각각의 메세지
		 * @param n 어떤 기능의 완료 메세지를 띄울지 지정
		 */
		public void endComment(int n) {
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			if(n==UIDept.ADD) {
				System.out.println("학과정보 등록이 완료되었습니다.");
			} else if(n==UIDept.UPDATE) {
				System.out.println("학과정보 수정이 완료되었습니다.");
			} else if(n==UIDept.DELETE) {
				System.out.println("학과정보 삭제가 완료되었습니다.");
			} else if(n==UIDept.LIST) {
				System.out.println("목록탐색 완료");
			} else if(n==UIDept.SEARCH) {
				System.out.println("정보검색 완료");
			}
			System.out.println();
			System.out.println("1.한번더 실행하기\t2.상위메뉴로 돌아가기");
			System.out.print("[번호 선택] : ");
		}
		
		public static final int NAME=5;//학생이름
		public static final int CODE=6; //학과코드
		public static final int POSITION=7; //학과사무실 위치

		
		
		/**
		 * 학과 정보를 입력받을시 띄울 각각의 라벨
		 * @param m 어떤 요소의 라벨인지 구별
		 */
		public void eachElement(int m) {
			if(m==UIDept.NAME) {
				System.out.print("[학과 이름] : ");
			} else if(m==UIDept.CODE) {
				System.out.print("[학과 코드] : ");
			} else if(m==UIDept.POSITION) {
				System.out.print("[학과사무실] : ");
			}
		}

		/**
		 * 학과 관리 기능별 제목 
		 * @param n 어떤 기능의 제목을 띄울지 구별
		 */
		public void title(int n) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★");
			
			if(n==UIDept.ADD) {
				System.out.println("\t	    학과추가");
			} else if(n==UIDept.UPDATE) {
				System.out.println("\t	    학과수정");
			} else if(n==UIDept.DELETE) {
				System.out.println("\t	    학과삭제");
			} else if(n==UIDept.LIST) {
				System.out.println("\t	  학과목록보기");
			} else if(n==UIDept.SEARCH) {
				System.out.println("\t	    학과검색");
			}
			
			System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.println("----------------------------------------------------------------");
		}
		
		/**
		 * 학과관리 기능 에러시 띄울 메세지
		 */
//		public void errorComment(int n) {
//			System.out.println();
//			System.out.println("----------------------------------------------------------------");
//			System.out.println();
//			if(n==UIDept.ADD) {
//				System.out.println("추가가 완료되지 못했습니다.");
//			} else if(n==UIStudent.UPDATE) {
//				System.out.println("수정이 완료되지 못했습니다.");
//			} else if(n==UIStudent.DELETE) {
//				System.out.println("삭제가 완료되지 못했습니다.");
//			}
//			System.out.println();
//			System.out.println("1.한번더 실행하기\t2.상위메뉴로 돌아가기");
//			System.out.print("[번호 선택] : ");
//		}
}

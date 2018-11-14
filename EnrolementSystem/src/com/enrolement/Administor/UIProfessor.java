package com.enrolement.Administor;


/**
 * 
 * @author 교수 UI 클래스입니다.
 * 
 */
public class UIProfessor {

	public static final int PROADD =1;
	public static final int PROUPDATE=2;
	public static final int PRODELETE=3;
	public static final int PROLIST=4;
	
	
	/**
	    * 메뉴시작(등록,수정,삭제,목록) 호출 메소드
	    * 
	    */
	public void menu(){
	     System.out.println("┌──────────────────────────────────────────────┐");
	     System.out.println("│                                                                                            │");
	     System.out.println("│                                ☆★☆★☆★☆★☆★☆★                                    │");
	     System.out.println("│                                   [교수관리자 시스템]                                      │");
	     System.out.println("│                                ☆★☆★☆★☆★☆★☆★                                    │");
	     System.out.println("│                                                                                            │");
	     System.out.println("└──────────────────────────────────────────────┘");
	     System.out.println("┌──────────────────────────────────────────────┐");
	     System.out.println("│                                                                                            │");
	     System.out.println("│                                                                                            │");
		 System.out.println("│     [1]. 교수 추가                                                                         │");
		 System.out.println("│                                                                                            │");
		 System.out.println("│     [2]. 교수 수정                                                                         │");
		 System.out.println("│                                                                                            │");
		 System.out.println("│     [3]. 교수 삭제                                                                         │");
		 System.out.println("│                                                                                            │");
		 System.out.println("│     [4].교수 목록 보기                                                                     │");
		 System.out.println("│                                                                                            │");
		 System.out.println("│     [0].   종 료                                                                           │");
		 System.out.println("│                                                                                            │");
		 System.out.println("└──────────────────────────────────────────────┘");
		 System.out.println("┌──────┐");
		 System.out.println("│번호 선택:  │");
		 System.out.println("└──────┘");
		
	}
	/**
	    * 검색시작(검색시작) 호출 메소드
	    *  
	    */
	public void startSearch() {
		 System.out.println("┌──────────────────────────────────────────────┐");
	     System.out.println("│                                                                                            │");
	     System.out.println("│                                ☆★☆★☆★☆★☆★☆★                                    │");
	     System.out.println("│                                    [교수 검색 하기]                                        │");
	     System.out.println("│                                ☆★☆★☆★☆★☆★☆★                                    │");
	     System.out.println("│                                                                                            │");
	     System.out.println("└──────────────────────────────────────────────┘");
	}
	/**
	    * 시작종료(검색종료) 호출 메소드
	    * 
	    */
	public void endSearch() {
		System.out.println();
		System.out.println("┌──────────────────────────────────────────────┐");
		System.out.println("│                                 [교수 검색이 완료되었습니다.]                              │");
		System.out.println("└──────────────────────────────────────────────┘");
		System.out.println("┌──────┐                  ┌───────────┐");
		System.out.println("│1. 검색하기]│                  │2.이전 메뉴로 돌아가기│");
		System.out.println("└──────┘                  └───────────┘");
		System.out.println("┌──────┐");
		System.out.println("│번호 선택:  │");
		System.out.println("└──────┘");
	}
	
	
	/**
	    * 시작(등록,수정,삭제,목록) 호출 메소드
	    * @param n UI결정변수
	    */
		public void start(int n) {
		
		
		if(n==UIProfessor.PROADD) {
		System.out.println("┌──────────────────────────────────────────────┐");	
		System.out.println("│                               ★☆★☆★☆★☆★☆★☆★☆                                 │");
		System.out.println("│                                   [교수 정보 추가하기]                                     │");
		System.out.println("│                               ★☆★☆★☆★☆★☆★☆★☆                                 │");
		System.out.println("└──────────────────────────────────────────────┘");
		}else if(n==UIProfessor.PROUPDATE) {
	    System.out.println("┌──────────────────────────────────────────────┐");	
		System.out.println("│                               ★☆★☆★☆★☆★☆★☆★☆                                 │");
		System.out.println("│                                   [교수 정보 수정하기]                                     │");
		System.out.println("│                               ★☆★☆★☆★☆★☆★☆★☆                                 │");
		System.out.println("└──────────────────────────────────────────────┘");
		}else if(n==UIProfessor.PRODELETE) {
		System.out.println("┌──────────────────────────────────────────────┐");	
		System.out.println("│                               ★☆★☆★☆★☆★☆★☆★☆                                 │");
		System.out.println("│                                   [교수 정보 삭제하기]                                     │");
		System.out.println("│                               ★☆★☆★☆★☆★☆★☆★☆                                 │");
		System.out.println("└──────────────────────────────────────────────┘");
		}else if(n==UIProfessor.PROLIST) {
		System.out.println("┌──────────────────────────────────────────────┐");	
		System.out.println("│                               ★☆★☆★☆★☆★☆★☆★☆                                 │");
		System.out.println("│                                 [교수 정보 목록 가져오기]                                  │");
		System.out.println("│                               ★☆★☆★☆★☆★☆★☆★☆                                 │");
		System.out.println("└──────────────────────────────────────────────┘");
		}
		
	}
	
		
		
		/**
		    * 종료(등록,수정,삭제,목록) 호출 메소드
		    * @param n UI 결정변수
		    */	
	public void end(int n) {
		
		if(n==UIProfessor.PROADD) {
			System.out.println();
			System.out.println("┌──────────────────────────────────────────────┐");	
			System.out.println("│                           [교수 정보가 추가되었습니다.]                                    │");
			System.out.println("└──────────────────────────────────────────────┘");
			System.out.println("┌──────┐             ┌───────────┐");
			System.out.println("│1. 검색하기]│             │2.이전 메뉴로 돌아가기│");
			System.out.println("└──────┘             └───────────┘");
			System.out.println("┌──────┐");
			System.out.println("│번호 선택:  │");
			System.out.println("└──────┘");
			
		}else if(n==UIProfessor.PROUPDATE) {
			System.out.println();
			System.out.println("┌──────────────────────────────────────────────┐");	
			System.out.println("│                           [교수 정보가 수정되었습니다.]                                    │");
			System.out.println("└──────────────────────────────────────────────┘");
			System.out.println("[1. 추가수정]             [2. 이전 메뉴로 돌아가기]          [3. 교수 목록보기]                 ");
			System.out.print("번호 선택:");
			
		}else if(n==UIProfessor.PRODELETE) {
			System.out.println();
			System.out.println("┌──────────────────────────────────────────────┐");	
			System.out.println("│                           [교수 정보가 삭제되었습니다.]                                    │");
			System.out.println("└──────────────────────────────────────────────┘");
			System.out.println("[1. 추가삭제]             [2. 이전 메뉴로 돌아가기]          [3. 교수 목록보기]                  ");
			System.out.print("번호 선택:");
			
		}else if(n==UIProfessor.PROLIST) {
			System.out.println();
			System.out.println("┌──────────────────────────────────────────────┐");	
			System.out.println("│                           [교수 정보를 가져왔습니다.]                                      │");
			System.out.println("└──────────────────────────────────────────────┘");
			System.out.println("[1. 검색하기]             [2. 이전 메뉴로 돌아가기]                                                     ");
			System.out.print("번호 선택:");
			
			}
			
		}
	

	}
	




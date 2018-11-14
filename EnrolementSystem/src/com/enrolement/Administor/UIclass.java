package com.enrolement.Administor;

/**
 * 강의실 UI 클래스
 * @author 우성환
 *
 */
public class UIclass {
	
   public static final int ADD = 1; // 강의실 추가
   public static final int List = 2; // 강의실 목록보기
   public static final int DELETE =3; // 삭제
   public static final int SEARCH =4; // 검색
   public static final int UPDATE = 5; //수정
   public static final int SEARCH2 =6; // 검색2
   
   /**
    * 강의실 모든 정보를 변경할수 있는클래스
    */
   public void classMenu() {
      System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
      System.out.println("   강의실 정보 관리");
      System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
      System.out.println("[1. 강의실 추가]");
      System.out.println("[2. 강의실 목록]");
      System.out.println("[3. 강의실 삭제]");
      System.out.println("[4. 강의실 검색]");
      System.out.println("[5. 강의실 수정]");
      System.out.println("[6. 종료]");
      System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
      System.out.println("선택(번호) :");
   }
   /**
    * 강의실 정보를 변경할때 어느 구역인지 제목이 나오게 해주는 클래스
    * @param n UI결정 변수
    */
   public void classTitle(int n) {
      if(n == UIclass.ADD) {
         System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
         System.out.println("    강의실 추가");
         System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
      }else if(n == UIclass.List) {
         System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
         System.out.println("    강의실 목록");
         System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
      }else if(n == UIclass.DELETE) {
         System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
         System.out.println("    강의실 삭제");
         System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
      }else if(n == UIclass.SEARCH) {
         System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
         System.out.println("    강의실 검색");
         System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
      }else if(n == UIclass.SEARCH2) {
         System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
         System.out.println("    학과 검색");
         System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
      }else if(n == UIclass.UPDATE) {
         System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
         System.out.println("    강의실 수정");
         System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
      }else {
            System.out.println("\n요청이 실패하였습니다.\n");
         }
   }
   
   /**
    * 변경 완료 클래스
    * @param n 강의실 변경 완료
    */
   public void classComplete(int n) {
      if(n == UIclass.ADD) {
         System.out.println("\n추가를 완료했습니다.\n");
      }else if(n == UIclass.List) {
         System.out.println("\n목록 보기를 완료했습니다.\n");
      }else if(n == UIclass.DELETE) {
         System.out.println("\n삭제 완료했습니다.\n");
      }else if(n == UIclass.SEARCH) {
         System.out.println("\n검색을 완료했습니다.\n");
      }else if(n == UIclass.UPDATE) {
         System.out.println("\n수정을 완료했습니다.\n");
      }else {
         System.out.println("\n요청이 실패하였습니다.\n");
      }
   }
   
   /**
    * 피드백을 전달해주는 클래스
    * @param n  강의실 변경정보 한번더 피드백
    */
   public void classMore(int n) {
      if(n == UIclass.ADD) {
         System.out.println("\n 더 추가 하시겠습니까? [1.YES 2.NO]\n");
      }else if(n == UIclass.DELETE) {
         System.out.println("\n더 삭제 하시겠습니까? [1.YES 2.NO]\n");
      }else if(n == UIclass.UPDATE) {
         System.out.println("\n더 수정 하시겠습니까? [1.YES 2.NO]\n");
      }else {
         System.out.println("\n요청이 실패하였습니다.\n");
      }
   }
   /**
    * 유효성검사
    * @param n 강의실 정보 변경 실패 
    */
   public void checkclass(int n) {
      if(n == UIclass.ADD) {
         System.out.println("\n 추가에 실패하였습니다.\n");
      }else if(n == UIclass.DELETE) {
         System.out.println("\n 삭제에 실패하였습니다.\n");
      }else if(n == UIclass.UPDATE) {
         System.out.println("\n 수정에 실패하였습니다.\n");
      }
   }
}

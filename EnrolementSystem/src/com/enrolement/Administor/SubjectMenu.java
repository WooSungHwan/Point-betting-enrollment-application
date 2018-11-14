package com.enrolement.Administor;

import java.util.Scanner;

/**
 * 수강과목 관리 메뉴
 * @author 한종균
 */
public class SubjectMenu {
	/**
	 * 사용자로부터 키보드 입력을 받을 스캐너
	 */
	private static Scanner scan;
	/**
	 * UI 클래스를 사용하기 위한 객체 선언
	 */
	private static SubjectUI ui;
	/**
	 * 전공과목 메뉴 및 기능을 사용하기 위한 객체선언
	 */
	private static Major major; 	
	/**
	 * 교양과목 메뉴 및 기능을 사용하기 위한 객체선언
	 */
	private static General general; 
	
	static{
		scan = new Scanner(System.in);
		ui = new SubjectUI();
		major = new Major();
		general = new General();
	}
	/**
	 * 메인메소드
	 */
	public void subject() {
		menu();

	}
	
	/**
	 * 과목 메뉴 시작 루프
	 */
	public static void menu() {
		boolean loop = true;
		
		while(loop) {
			
			ui.subjectMenu();
			
			int select = scan.nextInt();
			scan.nextLine();
			
			switch(select) {
			
			case 1:
				major.menu();
				break;
			case 2:
				general.menu();
				break;
			case 0:
				loop = false;
				break;
			default :	
				break;
			}
		}
		
	}

}

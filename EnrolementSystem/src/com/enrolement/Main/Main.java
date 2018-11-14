package com.enrolement.Main;

import java.util.Scanner;

import com.enrolement.Enrolement.Enrolement;

/**
 * 프로그램 메인클래스
 * @author 우성환
 *
 */
public class Main {
	static Scanner sc;
	static {
		sc = new Scanner(System.in);
	}
	
	
	public static void main(String[] args) {
		Enrolement e = new Enrolement();
		e.programStart();//1
//		UtilAboutFile.load();
//		AdminSide.endFinalEnrolement();
	}
}
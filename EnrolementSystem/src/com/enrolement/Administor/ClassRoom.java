package com.enrolement.Administor;

import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.enrolement.DTO.ClassroomDTO;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutFile;

/*
 * 강의실 정보 관리 클래스
 */
public class ClassRoom {

	/**
	 * UI와 Scanner 선언
	 */
	private static Scanner scan;
	private static UIclass ui;

	/**
	 * scan과 ui 정적객체 생성
	 */
	static {
		scan = new Scanner(System.in);
		ui = new UIclass();
	}

	private static boolean loop = true;

	public void classroomAdmin() {
		

		while (loop) {

			ui.classMenu();

			String room = scan.nextLine();

			switch (room) {

			case "1":
				add();
				break;
			case "2":
				list();
				break;
			case "3":
				delete();
				break;
			case "4":
				search();
				break;
			case "5":
				update();
				break;
			default:
				loop = false;
				break;
			}
		}

		System.out.println("프로그램 종료합니다.");

	}

	/**
	 * 강의실을 추가하기 위한 메소드
	 */
	public static void add() {

		ui.classTitle(UIclass.ADD);
		UtilAboutFile.load();

		System.out.println("[강의실 호수] : ");
		String classnum = scan.nextLine();
		if (classnum.length() > 4) {
			System.out.println("강의실 호수가 잘못되었습니다.");
			add();
		}

		System.out.println("[학과] : ");
		String deptcode = scan.nextLine();
		String regex = "^[가-힣]{2,10}$";

		if (Pattern.matches(regex, deptcode)) {
		} else {
			System.out.println("다시 입력해주세요.");
			add();
		}

		System.out.println("[수용인원] : ");
		String capacity = scan.nextLine();
		int capacityInt = Integer.parseInt(capacity);
		if (capacityInt > 30) {
			System.out.println("수용인원이 초과되었습니다.\n다시 입력하십시오.");
			add();
		}

		ClassroomDTO clrDTO = new ClassroomDTO(classnum, deptcode, capacity);
		ExData.classroomList.add(clrDTO);
		UtilAboutFile.classroomSave(ExData.classroomList);

		ui.classComplete(UIclass.ADD);
		ui.classMore(UIclass.ADD);

		int select = scan.nextInt();
		scan.nextLine();

		switch (select) {

		case 1:
			add();
			break;
		case 2:
			break;
		}
	}

	/**
	 * 강의실 목록을 보여주기위한 메소드
	 */
	public static void list() {

		ui.classTitle(UIclass.List);
		UtilAboutFile.load();

		Iterator<ClassroomDTO> Listiter = ExData.classroomList.iterator();
		System.out.println("[강의실 호수]\t  [학과]\t   [수용 인원]\t");
		while (Listiter.hasNext()) {
			ClassroomDTO clrDTO = Listiter.next();
			System.out.printf("%s\t\t%s\t\t%s\t\t\n", clrDTO.getClassNum(), clrDTO.getDeptCode(), clrDTO.getCapacity());
		}
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		System.out.println("  1. 강의실 호수로 검색  2. 학과로 검색 3. 메뉴로 돌아가기");
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");

		int select = scan.nextInt();
		scan.nextLine();

		switch (select) {

		case 1:
			search();
			break;
		case 2:
			search2();
			break;
		case 3:
			ui.classMenu();
			break;

		}
	}

	/**
	 * 강의실 삭제를 구현하는 메소드
	 */
	public static void delete() {

		ui.classTitle(UIclass.DELETE);
		System.out.println("1.강의실 호수 2.학과 3. 메뉴로 돌아가기");
		UtilAboutFile.load();
		String classNum = scan.nextLine();

		switch (classNum) {

		case "1":
			search();

			break;
		case "2":
			search2();
			break;
		case "3":
			ui.classMenu();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			delete();
			break;
		}

		System.out.println("======================");
		System.out.println("삭제할 강의실 입력");
		System.out.print("강의실 호수 : ");
		String subjectCode = scan.nextLine();
		String regex = "^[a-zA-Z0-9]{2,4}$";

		if (Pattern.matches(regex, subjectCode)) {
		} else {
			System.out.println("다시 입력해주세요.");
			delete();
		}

		for (int i = 0; i < ExData.classroomList.size(); i++) {
			if ((ExData.classroomList.get(i).getClassNum().equals(subjectCode))) {
				ExData.classroomList.remove(i);
				UtilAboutFile.classroomSave(ExData.classroomList);
				System.out.println("완료");
			}
		}

	}

	/**
	 * 검색할때 구현되는 메소드인데 강의실호수만 검색
	 */
	public static void search() {

		ui.classTitle(UIclass.SEARCH);

		System.out.println("강의실 호수를 입력하세요 : ");
		UtilAboutFile.load();
		String classNum = scan.nextLine();
		String regex = "^[a-zA-Z0-9]{2,4}$";

		if (Pattern.matches(regex, classNum)) {
		} else {
			System.out.println("다시 입력해주세요.");
			search();
		}

		Iterator<ClassroomDTO> Searchlist = ExData.classroomList.iterator();
		System.out.println("[강의실 호수]\t  [학과]\t   [수용 인원]\t");
		while (Searchlist.hasNext()) {
			ClassroomDTO clrDTO = Searchlist.next();
			if (clrDTO.getClassNum().indexOf(classNum) == -1) {
				continue;
			}
			System.out.printf("%s\t\t%s\t\t%s\t\t\n", clrDTO.getClassNum(), clrDTO.getDeptCode(), clrDTO.getCapacity());
		}
	}

	/**
	 * 검색할때 구현되는 메소드인데 학과만 검색
	 */
	public static void search2() {

		ui.classTitle(UIclass.SEARCH2);

		/**
		 * 강의실 학과검색 유효성 검사
		 */
		System.out.println("학과를 입력하세요 : ");
		UtilAboutFile.load();
		String deptCode = scan.nextLine();
		String regex = "^[가-힣]{2,10}$";

		if (Pattern.matches(regex, deptCode)) {
		} else {
			System.out.println("다시 입력해주세요.");
			search2();
		}
		Iterator<ClassroomDTO> Searchlist = ExData.classroomList.iterator();
		System.out.println("[강의실 호수]\t  [학과]\t   [수용 인원]\t");
		while (Searchlist.hasNext()) {
			ClassroomDTO clrDTO = Searchlist.next();
			if (clrDTO.getDeptCode().indexOf(deptCode) == -1) {
				continue;
			}

			System.out.printf("%s\t\t%s\t\t%s\t\t\n", clrDTO.getClassNum(), clrDTO.getDeptCode(), clrDTO.getCapacity());
		}
	}

	/**
	 * 강의실 정보를 수정하는 메소드
	 */
	public static void update() {

		ui.classTitle(UIclass.UPDATE);

		System.out.println("수정할 강의실 호수를 입력하시오 :");
		String classNum = scan.nextLine();

		String regex = "^[a-zA-Z0-9]{2,4}$";

		if (Pattern.matches(regex, classNum)) {
		} else {
			System.out.println("다시 입력해주세요.");
			update();
		}

		Iterator<ClassroomDTO> updatelist = ExData.classroomList.iterator();

		while (updatelist.hasNext()) {
			ClassroomDTO clrDTO = updatelist.next();

			if (clrDTO.getClassNum().equals(classNum)) {

				System.out.printf("%s\t\t%s\t\t%s\t\t\n", clrDTO.getClassNum(), clrDTO.getDeptCode(),
						clrDTO.getCapacity());
			}
		}

		Iterator<ClassroomDTO> deptlist = ExData.classroomList.iterator();
		while (deptlist.hasNext()) {
			ClassroomDTO clrDTO = deptlist.next();

			if (clrDTO.getClassNum().equals(classNum)) {

				System.out.print("[강의실 변경] : ");
				clrDTO.setClassNum(scan.nextLine());

				System.out.print("[학과 변경] : ");
				clrDTO.setDeptCode(scan.nextLine());

			}
		}
		System.out.println("수정 완료되었습니다.");
		UtilAboutFile.classroomSave(ExData.classroomList);

	}
}
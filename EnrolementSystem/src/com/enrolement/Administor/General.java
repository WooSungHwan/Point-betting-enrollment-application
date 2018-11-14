package com.enrolement.Administor;

import java.util.Iterator;
import java.util.Scanner;

import com.enrolement.DTO.GeneralSubjectDTO;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutFile;

/**
 * 교양과목 메뉴 및 각 기능 클래스
 * @author 한종균
 */
public class General {
	/**
	 * 사용자로부터 키보드 입력을 받을 스캐너
	 */
	private static Scanner scan; 
	/**
	 * UI 클래스를 사용하기 위한 객체 선언
	 */
	private static SubjectUI ui; 
	
	static{
		scan = new Scanner(System.in);
		ui = new SubjectUI();
	}
	
	/**
	 * 교양과목 메뉴 시작 루프
	 */
	public void menu() {
		boolean loop = true;
		
		while(loop) {
			
			ui.UiGeneralSubjectMain();
			
			int select = scan.nextInt();
			scan.nextLine();
			
			switch(select) {
			
			case 1:
				generalAdd();
				break;
			case 2:
				generalUpdate();
				break;
			case 3:
				generalDelete();
				break;
			case 4:
				generalList();
				break;
			case 0:
				loop = false;
				break;
			default :
				System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆☆");
				System.out.println("\t☆★정확한 값을 입력해주시기 바랍니다.☆★");
				System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				break;
			}
		}
	}

	/**
	 * 교양과목 등록 메소드
	 */
	private void generalAdd() {
		ui.GeneralTitle(ui.UiAdd);
		
		System.out.print("[과목코드] : ");
		String subjectCode = scan.nextLine();
		
		System.out.print("[교수코드] :");
		String professorCode = scan.nextLine();
		
		System.out.print("[학과코드] : ");
		String deptCode = scan.nextLine();
		
		System.out.print("[과목명] : ");
		String subjectName = scan.nextLine();
		
		System.out.print("[학점] : ");
		int grades = scan.nextInt();
		scan.nextLine();
		
		System.out.print("[강의시간] : ");
		String scheduleTime = scan.nextLine();
		
		System.out.print("[강의실] : ");
		String classNum = scan.nextLine();
		
		
		GeneralSubjectDTO m = new GeneralSubjectDTO(subjectCode, deptCode, professorCode, classNum, subjectName, grades, 30, scheduleTime, 0);
		ExData.generalSubjectList.add(m);
		UtilAboutFile.generalSubjectSave(ExData.generalSubjectList);
		
		ui.subjectCompletMenu(ui.UiAdd);
		int select = scan.nextInt();
		scan.nextLine();
		
		switch(select) {
		
		case 1:
			generalAdd();
			break;
		case 2:
			break;
		}
		
	}

	/**
	 * 교양과목 검색 및 수정 메소드
	 */
	private void generalUpdate() {
		ui.GeneralTitle(ui.UiUpdate);
		ui.UiSearchMenu();
		int searchNum = scan.nextInt();
		scan.nextLine();
		
		switch(searchNum) {
		
		case 1:
			deptSearch();
			break;
		case 2:
			professorSearch();
			break;
		case 3:
			subjectSearch();
			break;
		case 4:
			return;
		default:
			System.out.println("잘못입력하셨습니다.");
			break;
		}
		
		System.out.println("수정할 과목코드를 입력하세요");
		System.out.print("과목코드 : ");
		String subjectC = scan.nextLine();
		
		Iterator<GeneralSubjectDTO> iter = ExData.generalSubjectList.iterator();
		while(iter.hasNext()) {
			GeneralSubjectDTO subDTO = iter.next();
			if(subDTO.getSubjectCode().equals(subjectC)) {
				System.out.print("[과목코드] : ");
				subDTO.setSubjectCode(scan.nextLine());
				
				System.out.print("[교수코드] :");
				subDTO.setProfessorCode(scan.nextLine());
				
				System.out.print("[학과코드] : ");
				subDTO.setDeptCode(scan.nextLine());
				
				System.out.print("[과목명] : ");
				subDTO.setSubjectName(scan.nextLine());
				
				System.out.print("[학점] : ");
				subDTO.setGrades(scan.nextInt());
				scan.nextLine();
				
				
				System.out.print("[강의시간] : ");
				subDTO.setScheduleTime(scan.nextLine());
				
				System.out.print("[강의실] : ");
				subDTO.setClassNum(scan.nextLine());
			}
		}
		UtilAboutFile.generalSubjectSave(ExData.generalSubjectList);
		ui.subjectCompletMenu(ui.UiUpdate);
		int select = scan.nextInt();
		
		switch(select) {
		
		case 1:
			generalUpdate();
			break;
		case 2:
			break;
		}	
	}

	/**
	 * 교양과목 검색 및 삭제 메소드
	 */
	private void generalDelete() {
		ui.GeneralTitle(ui.UiDelete);
		System.out.println("검색 후 삭제할 예정입니다.");
		ui.UiSearchMenu();
		int searchNum = scan.nextInt();
		scan.nextLine();
		
		switch(searchNum) {
		
		case 1:
			deptSearch();
			break;
		case 2:
			professorSearch();
			break;
		case 3:
			subjectSearch();
			break;
		case 4:
			return;
		default:
			System.out.println("잘못입력하셨습니다.");
			break;
		}
		System.out.println("삭제할 과목 코드 입력");
		System.out.print("과목 코드 : ");
		String subjectCode = scan.nextLine();
		
		System.out.print("과목명 : ");
		String subjectName = scan.nextLine();
		
		ui.subjectCompletMenu(ui.UiDelete);
		int deleteSelect = scan.nextInt();
		scan.nextLine();
		
		switch(deleteSelect) {
		
		case 1:
			for(int i=0;i<ExData.generalSubjectList.size();i++) {
				if((ExData.generalSubjectList.get(i).getSubjectCode()).equals(subjectCode)&&
						(ExData.generalSubjectList.get(i).getSubjectName()).equals(subjectName)){
					ExData.generalSubjectList.remove(i);
					UtilAboutFile.generalSubjectSave(ExData.generalSubjectList);
					System.out.println("삭제가 완료되었습니다.");
					break;
				}else {
					continue;
				}
			}
			break;
		case 2:
			break;
		}
	}

	/**
	 * 교양과목 목록을 출력 및 검색 메소드
	 */
	private void generalList() {
		ui.GeneralTitle(ui.UiList);
		System.out.println("[과목코드]\t[학과코드]\t[교수코드]\t[과목명]\t\t[학점]\t[강의시간]\t[강의실]");
		
		Iterator<GeneralSubjectDTO> iter = ExData.generalSubjectList.iterator();
		
		while(iter.hasNext()) {
			GeneralSubjectDTO subDTO = iter.next();
			System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\t\t%s\n",subDTO.getSubjectCode()
					,subDTO.getDeptCode()
					,subDTO.getProfessorCode()
					,subDTO.getSubjectName()
					,subDTO.getGrades()
					,subDTO.getScheduleTime()
					,subDTO.getClassNum());
		}
		ui.subjectCompletMenu(ui.UiList);
		System.out.print("1.검색을 하시겠습니까? 2.상위메뉴로 돌아가기  선택 :");
		int select = scan.nextInt();
		if(select==1) {
			ui.UiSearchMenu();
			int searchSelect = scan.nextInt();
			scan.nextLine();
			
			switch(searchSelect) {
			
			case 1 :
				deptSearch();
				break;
			case 2 :
				professorSearch();
				break;
			case 3 : 
				subjectSearch();
				break;
			case 4 :
				return;
			default :
				break;
			}
		}else if(select==2) {
			return;
		}
	}

	/**
	 * 학과코드 검색 메소드
	 */
	private void deptSearch() {
		System.out.print("학과코드 : ");
		String deptCode = scan.nextLine();
		
		Iterator<GeneralSubjectDTO> iter = ExData.generalSubjectList.iterator();
		System.out.println("[과목코드]\t[학과코드]\t[교수코드]\t[과목명]\t\t[학점]\t[강의시간]\t[강의실]");
		
		while(iter.hasNext()) {
			GeneralSubjectDTO subDTO = iter.next();
			if(subDTO.getDeptCode().equals(deptCode)) {
				System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\t\t%s\n",subDTO.getSubjectCode()
					,subDTO.getDeptCode()
					,subDTO.getProfessorCode()
					,subDTO.getSubjectName()
					,subDTO.getGrades()
					,subDTO.getScheduleTime()
					,subDTO.getClassNum());
			}else {
				continue;
			}
		}
	}

	/**
	 * 교수코드 검색 메소드
	 */
	private void professorSearch() {
		System.out.print("교수코드 : ");
		String professorCode = scan.nextLine();
		
		Iterator<GeneralSubjectDTO> iter = ExData.generalSubjectList.iterator();
		System.out.println("[과목코드]\t[학과코드]\t[교수코드]\t[과목명]\t\t[학점]\t[강의시간]\t[강의실]");
		
		while(iter.hasNext()) {
			GeneralSubjectDTO subDTO = iter.next();
			if(subDTO.getProfessorCode().equals(professorCode)) {
				System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\t\t%s\n",subDTO.getSubjectCode()
					,subDTO.getDeptCode()
					,subDTO.getProfessorCode()
					,subDTO.getSubjectName()
					,subDTO.getGrades()
					,subDTO.getScheduleTime()
					,subDTO.getClassNum());
			}else {
				continue;
			}
		}
	}

	/**
	 * 교수코드 검색 메소드
	 */
	private void subjectSearch() {
		System.out.print("과목코드 : ");
		String subjectCode = scan.nextLine();
		
		Iterator<GeneralSubjectDTO> iter = ExData.generalSubjectList.iterator();
		System.out.println("[과목코드]\t[학과코드]\t[교수코드]\t[과목명]\t\t[학점]\t[강의시간]\t[강의실]");
		
		while(iter.hasNext()) {
			GeneralSubjectDTO subDTO = iter.next();
			if(subDTO.getSubjectCode().equals(subjectCode)) {
				System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\t\t%s\n",subDTO.getSubjectCode()
					,subDTO.getDeptCode()
					,subDTO.getProfessorCode()
					,subDTO.getSubjectName()
					,subDTO.getGrades()
					,subDTO.getScheduleTime()
					,subDTO.getClassNum());
			}else {
				continue;
			}
		}
		
	}
}

package com.enrolement.Administor;

import java.util.Iterator;
import java.util.Scanner;

import com.enrolement.DTO.MajorSubjectDTO;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutFile;

/**
 * 전공과목 메뉴 및 각 기능 클래스
 * @author 한종균
 */
public class Major {
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
	 * 전공과목 메뉴 시작 루프
	 */
	public  void menu() {
		boolean loop = true;
		
		while(loop) {
			
			ui.UiMajorSubjectMain();
			
			int select = scan.nextInt();
			scan.nextLine();
			
			switch(select) {
			
			case 1:
				majorAdd();
				break;
			case 2:
				majorUpdate();
				break;
			case 3:
				majorDelete();
				break;
			case 4:
				majorList();
				break;
			case 0:
				loop = false;
				break;
			default :
				System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆☆★☆★☆☆★☆★☆☆★☆★☆☆");
				System.out.println("\t☆★정확한 값을 입력해주시기 바랍니다.☆★");
				System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★★☆★☆☆★☆★☆☆★☆★☆☆");
				break;
			}
		}
	}

	/**
	 * 전공과목 목록을 출력 및 검색 메소드
	 */
	private void majorList() {
		ui.MajorTitle(ui.UiList);
		System.out.println("[과목코드]\t[학과코드]\t[교수코드]\t[과목명]\t\t[학점]\t[학년]\t[강의시간]\t[강의실]");
		
		Iterator<MajorSubjectDTO> iter = ExData.majorSubjectList.iterator();
		
		while(iter.hasNext()) {
			MajorSubjectDTO dto = iter.next();
			System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\t%s\t\t%s\n",dto.getSubjectCode()
					,dto.getDeptCode()
					,dto.getProfessorCode()
					,dto.getSubjectName()
					,dto.getGrades()
					,dto.getGrade()
					,dto.getScheduleTime()
					,dto.getClassNum());	
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
			default :
				break;
			}
		}else if(select==2) {
			return;
		}
		
	}

	/**
	 *  과목코드 검색 메소드
	 */
	private  void subjectSearch() {
		System.out.print("과목코드 : ");
		String subjectCode = scan.nextLine();
		
		Iterator<MajorSubjectDTO> iter = ExData.majorSubjectList.iterator();
		System.out.println("[과목코드]\t[학과코드]\t[교수코드]\t[과목명]\t\t[학점]\t[학년]\t[강의시간]\t[강의실]");
		
		while(iter.hasNext()) {
			MajorSubjectDTO dto = iter.next();
			
			if(dto.getSubjectCode().equals(subjectCode)) {
				System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\t%s\t\t%s\n",dto.getSubjectCode()
						,dto.getDeptCode()
						,dto.getProfessorCode()
						,dto.getSubjectName()
						,dto.getGrades()
						,dto.getGrade()
						,dto.getScheduleTime()
						,dto.getClassNum());
			}else if(!dto.getSubjectCode().equals(subjectCode)){
				continue;
			}
			
		}
		
	}

	/**
	 * 교수코드 검색 메소드
	 */
	private  void professorSearch() {
		System.out.print("교수코드 : ");
		String professorCode = scan.nextLine();
		
		Iterator<MajorSubjectDTO> iter = ExData.majorSubjectList.iterator();
		
		System.out.println("[과목코드]\t[학과코드]\t[교수코드]\t[과목명]\t\t[학점]\t[학년]\t[강의시간]\t[강의실]");
		
		while(iter.hasNext()) {
			MajorSubjectDTO dto = iter.next();
			
			if(dto.getProfessorCode().equals(professorCode)) {
				System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\t%s\t\t%s\n",dto.getSubjectCode()
						,dto.getDeptCode()
						,dto.getProfessorCode()
						,dto.getSubjectName()
						,dto.getGrades()
						,dto.getGrade()
						,dto.getScheduleTime()
						,dto.getClassNum());
			}else {
				continue;
			}
			
		}
		
	}

	/**
	 * 학과코드 검색 메소드
	 */
	private  void deptSearch() {
		System.out.print("학과코드 : ");
		String deptCode = scan.nextLine();
		
		Iterator<MajorSubjectDTO> iter = ExData.majorSubjectList.iterator();
		
		System.out.println("[과목코드]\t[학과코드]\t[교수코드]\t[과목명]\t\t[학점]\t[학년]\t[강의시간]\t[강의실]");
		
		while(iter.hasNext()) {
			MajorSubjectDTO dto = iter.next();
			
			if(dto.getDeptCode().equals(deptCode)) {
				System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\t%s\t\t%s\n",dto.getSubjectCode()
						,dto.getDeptCode()
						,dto.getProfessorCode()
						,dto.getSubjectName()
						,dto.getGrades()
						,dto.getGrade()
						,dto.getScheduleTime()
						,dto.getClassNum());
			}else {
				continue;
			}
		}
	}

	/**
	 * 전공과목 검색 및 삭제 메소드
	 */
	private  void majorDelete() {
		ui.MajorTitle(ui.UiDelete);
		System.out.println("검색후 삭제할 예정입니다");
		ui.UiSearchMenu();
		int searchNum = scan.nextInt();
		scan.nextLine();
		
		switch(searchNum) {
		
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
			System.out.println("잘못입력하셨습니다.");
			break;
		}
		
		System.out.println("=============================================================");
		System.out.println("삭제할 과목 정보 입력");
		System.out.print("과목코드 : ");
		String subjectCode = scan.nextLine();
		
		System.out.print("과목명 : ");
		String subjectName = scan.nextLine();
		
		ui.subjectCompletMenu(ui.UiDelete);
		String deleteSelect = scan.nextLine();
	
		switch(deleteSelect) {
			
		case "1" :
			for(int i=0;i<ExData.majorSubjectList.size();i++) {				
				if((ExData.majorSubjectList.get(i).getSubjectCode()).equals(subjectCode)&&
						(ExData.majorSubjectList.get(i).getSubjectName()).equals(subjectName)) {
					ExData.majorSubjectList.remove(i);
					UtilAboutFile.majorSubjectSave(ExData.majorSubjectList);
					System.out.println("삭제가 완료되었습니다.");
					break;
				}else {
					continue;
				}
			}
			break;
		case "2" :
			break;
		}
	}

	/**
	 * 전공과목 검색 및 수정 메소드
	 */
	private  void majorUpdate() {
		ui.MajorTitle(ui.UiUpdate);
		ui.UiSearchMenu();
		int searchNum = scan.nextInt();
		scan.nextLine();
		
		switch(searchNum) {
		
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
			System.out.println("잘못입력하셨습니다.");
			break;
		}

		System.out.println("수정할 과목코드를 입력하세요");
		System.out.print("과목코드 : ");
		String subjectC = scan.nextLine();
		
		Iterator<MajorSubjectDTO> iter = ExData.majorSubjectList.iterator(); 
		while(iter.hasNext()) { 
			
			MajorSubjectDTO dto = iter.next();
			if(dto.getSubjectCode().equals(subjectC)) { 
				System.out.print("[과목코드] : ");
				dto.setSubjectCode(scan.nextLine());
				
				System.out.print("[학과코드] : ");
				dto.setDeptCode(scan.nextLine());
				
				System.out.print("[교수코드] :");
				dto.setProfessorCode(scan.nextLine());
				
				System.out.print("[과목명] : ");
				dto.setSubjectName(scan.nextLine());
				
				System.out.print("[학점] : ");
				dto.setGrades(scan.nextLine());
				
				System.out.print("[학년] : ");
				dto.setGrade(scan.nextLine());
				
				System.out.print("[강의시간] : ");
				dto.setScheduleTime(scan.nextLine());
				
				System.out.print("[강의실] : ");
				dto.setClassNum(scan.nextLine());
			}
		}
		
		
		
		
		UtilAboutFile.majorSubjectSave(ExData.majorSubjectList);
		ui.subjectCompletMenu(ui.UiUpdate);
		int select = scan.nextInt();
		
		switch(select) {
		
		case 1:
			majorUpdate();
			break;
		case 2:
			break;
		}
	}
	/**
	 * 전공과목 등록 메소드
	 */
	public  void majorAdd() {
		ui.MajorTitle(ui.UiAdd);
		
		System.out.print("[과목코드] : ");
		String subjectCode = scan.nextLine();
		
		System.out.print("[학과코드] : ");
		String deptCode = scan.nextLine();
		
		System.out.print("[교수코드] :");
		String professorCode = scan.nextLine();
		
		System.out.print("[과목명] : ");
		String subjectName = scan.nextLine();
		
		System.out.print("[학점] : ");
		String grades = scan.nextLine();
		
		System.out.print("[학년] : ");
		String grade = scan.nextLine();
		
		System.out.print("[강의시간] : ");
		String scheduleTime = scan.nextLine();
		
		System.out.print("[강의실] : ");
		String classNum = scan.nextLine();
		
		MajorSubjectDTO m = new MajorSubjectDTO(subjectCode, deptCode, professorCode, subjectName, grades, grade, "30", scheduleTime, classNum);
	
		ExData.majorSubjectList.add(m);
		UtilAboutFile.majorSubjectSave(ExData.majorSubjectList);
		ui.subjectCompletMenu(ui.UiAdd);
		int select = scan.nextInt();
		scan.nextLine();
		
		switch(select) {
		
		case 1:
			majorAdd();
			break;
		case 2:
			break;
		}
		
	}

}
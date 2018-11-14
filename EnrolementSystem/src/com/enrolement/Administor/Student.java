package com.enrolement.Administor;

import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.enrolement.DTO.DepartmentDTO;
import com.enrolement.DTO.StudentDTO;
import com.enrolement.DTO.StudentLoginDTO;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutCodeFind;
import com.enrolement.Util.UtilAboutFile;
/**
 * 학생에 관련된 CURD 기능 
 * @author 정세연
 *
 */
public class Student {
	/**
	 * 입력받을시 쓰일 스캐너 객체
	 */
	private static Scanner scan;
	/*
	 * 학생UI 사용할 객체
	 */
	private static UIStudent ui; 
	/**
	 * 학생 상위 메뉴 루프 결정값
	 */
	private static boolean mainloop; 
	static {
		scan = new Scanner(System.in);
		ui = new UIStudent();
		mainloop = true;
	}
	
	/**
	 * 학생 관리자 시스템 메인메소드
	 */
	public static void student() { 

		while (mainloop) {

			//학생관리자 메인 메뉴
			ui.studMenu(); 

			int sel = scan.nextInt();
			scan.nextLine();

			switch (sel) {
			case 1:
				addStudent();
				break; // 학생추가
			case 2:
				upDateStudent();
				break; // 학생수정
			case 3:
				deleteStudent();
				break; // 학생삭제
			case 4:
				listStudent();
				break; // 학생목록
			case 5:
				searchStudent();
				break; // 학생검색
			default:
				mainloop = false;
				break;
			}
		}

		System.out.println("학생관리자 시스템 종료");

	}

	/**
	 * 학생을 등록하는 기능
	 */
	public static void addStudent() {

		ui.title(UIStudent.ADD);
		
		
		// 이름 등록------------------------------
		ui.eachElement(UIStudent.NAME);
		String studentName = scan.nextLine();

		// 유효성(형태)
		String patName = "^[가-힣]{2,4}$";

		if (!Pattern.matches(patName, studentName)) {
			System.out.println("잘못된 이름입니다. 다시시도하세요(한글,2~4자)");
			addStudent();
		}

		// 학번 등록------------------------------
		ui.eachElement(UIStudent.ID);
		String studentID = scan.nextLine();

		String patID = "^[0-9]{8}$";

		// 유효성1(형태)
		if (!Pattern.matches(patID, studentID)) {
			System.out.println("잘못된 학번입니다. 첨부터 다시시도하세요(0-9숫자 8자리)");
			addStudent();
		}

		// 유효성2(중복)
		Iterator<StudentDTO> stuIter = ExData.studentList.iterator();
		while (stuIter.hasNext()) {
			StudentDTO stuDTO = stuIter.next();
			if (stuDTO.getStudentID().equals(studentID)) {
				System.out.println("중복된 학번입니다. 첨부터 다시시도하세요");
				addStudent();
			}
		}

		// 학년 등록---------------------------------
		ui.eachElement(UIStudent.GRADE);
		String grade = scan.nextLine();

		// 유효성(형태)
		String patGrade = "[1234]{1}";

		if (!Pattern.matches(patGrade, grade)) {
			System.out.println("잘못된 학년입니다. 다시시도하세요(1~4학년)");
			addStudent();
		}

		// 전번 등록-----------------------------------
		ui.eachElement(UIStudent.TEL);
		String phoneNumber = scan.nextLine();
		phoneNumber = phoneNumber.replace("-", "");

		String patTel = "010" + "[0-9*]{8}";

		// 유효성1(형태)
		if (!Pattern.matches(patTel, phoneNumber)) {
			System.out.println("잘못된 전화번호입니다. 다시시도하세요(010~)");
			addStudent();
		}

		// 유효성2(중복)
		Iterator<StudentDTO> stuIterTel = ExData.studentList.iterator();
		while (stuIterTel.hasNext()) {
			StudentDTO stuDTO = stuIterTel.next();
			if (stuDTO.getPhoneNumber().replace("-", "").equals(phoneNumber)) {
				System.out.println("중복된 전화번호입니다. 첨부터 다시시도하세요");
				addStudent();
			}
		}

		// 나이 등록-----------------------------------
		ui.eachElement(UIStudent.AGE);
		String age = scan.nextLine();

		// 유효성(형태)
		int ageInt = Integer.parseInt(age);

		if (ageInt < 18 && ageInt > 150) {
			System.out.println("잘못된 나이입니다. 첨부터 다시시도하세요");
			addStudent();
		}

		// 주소 등록---------------------------------------
		ui.eachElement(UIStudent.ADDRESS);
		String address = scan.nextLine();

		// 유효성(형태)
		String patAddress = "[가-힣0-9-\\s]{5,50}";

		if (!Pattern.matches(patAddress, address)) {
			System.out.println("잘못된 주소입니다. 첨부터 다시시도하세요");
			addStudent();
		}

		// 학과 등록--------------------------------------
		System.out.println("학과이름을 입력하세요");
		ui.eachElement(UIStudent.CODE);
		String deptName = scan.nextLine();

		String deptCode = "";

		//학과명을 입력받아 코드로 저장하기
		Iterator<DepartmentDTO> deptIter = ExData.departmentList.iterator();

		while (deptIter.hasNext()) {
			DepartmentDTO deptDTO = deptIter.next();
			if ((deptDTO.getDeptName()).equals(deptName)) { // 입력받은 코드와 일치하는 학과명 가져오기
				deptCode = deptDTO.getDeptNumber();
			}
		}

		//입력정보들로 객체 생성
		StudentDTO stuDTO = new StudentDTO(studentID, studentName, deptCode, grade, age, phoneNumber, address);
		//학생 객체 생성을 동시에 
		StudentLoginDTO slDTO = new StudentLoginDTO(studentID, phoneNumber.substring(7 ,11 ));
		
		ExData.studentList.add(stuDTO);
		ExData.studentLoginList.add(slDTO);
		UtilAboutFile.studentSave(ExData.studentList);
		UtilAboutFile.studentLoginSave(ExData.studentLoginList);
		mainloop = false;

		ui.endComment(UIStudent.ADD);
		if (scan.nextLine().equals("1")) { // 한번더 추가기능 실행
			addStudent();

		} else {
			mainloop = true; // 상위메뉴로 돌아가기
		}

		// ui.errorComment(UIStudent.ADD);

	}


	/**
	 * 학생 수정하기
	 */
	public static void upDateStudent() {
		ui.title(UIStudent.UPDATE);
		System.out.print("수정할 학생의 이름을 입력하세요. : ");
		String name = scan.nextLine();

		Iterator<StudentDTO> nameiter = ExData.studentList.iterator();
		int count1= 0; //일치하는 이름이 없을때 경우로 사용할 카운트 변수
		while (nameiter.hasNext()) {
			StudentDTO stuDTO = nameiter.next();
			if (stuDTO.getStudentName().equals(name)) { // 입력한 이름과 가져온 객체의 이름이 같다면

				System.out.printf("%s %s [%s(학년)] %s [%s(세)] %s \n", stuDTO.getStudentID(),
						UtilAboutCodeFind.findDepartment(stuDTO.getDeptCode()).getDeptName(), stuDTO.getGrade(),
						stuDTO.getPhoneNumber(), stuDTO.getAge(), stuDTO.getAdress());
				count1++; 
			}
		}
		if(count1==0) { //일치하는 이름이 없을때
			System.out.println("일치하는 학생이 없습니다.다시시도하세요");
			upDateStudent();
		}

		System.out.print("수정할 학생의 학번을 입력하세요. : ");
		String num = scan.nextLine();
		
		Iterator<StudentDTO> IDiter = ExData.studentList.iterator();
		int count2=0; //일치하는 학번이 없을 경우로 사용할 카운트 변수
		while (IDiter.hasNext()) {
			StudentDTO stuDTO = IDiter.next();
			if (stuDTO.getStudentID().equals(num)) { // 입력한 학번의 객체에 접근한다.

				count2++;
				
				// 이름수정
				ui.eachElement(UIStudent.NAME);
				stuDTO.setStudentName(scan.nextLine());

				// 전화수정
				ui.eachElement(UIStudent.TEL);
				stuDTO.setPhoneNumber(scan.nextLine());

				// 학과수정
				System.out.println("학과 이름을 입력하세요.");
				ui.eachElement(UIStudent.CODE);

				String deptName = scan.nextLine();
				String deptCode = "";

				Iterator<DepartmentDTO> deptIter = ExData.departmentList.iterator();
				int count3 = 0;
				while (deptIter.hasNext()) {
					DepartmentDTO deptDTO = deptIter.next();
					if ((deptDTO.getDeptName()).equals(deptName)) { // 입력받은 코드와 일치하는 학과명 가져오기
						deptCode = deptDTO.getDeptNumber();
						count3++;
					} 
					
				}
				if(count3==0) {
					System.out.println("일치하는 학과가 없습니다.다시시도하세요.");
					upDateStudent();
				}
				
				stuDTO.setDeptCode(deptCode);// 이름을 통해 얻어온 학과코드를 저장

				// 나이수정
				ui.eachElement(UIStudent.AGE);
				stuDTO.setAge(scan.nextLine());

				// 학년수정
				ui.eachElement(UIStudent.GRADE);
				stuDTO.setGrade(scan.nextLine());

				// 주소수정
				ui.eachElement(UIStudent.ADDRESS);
				stuDTO.setAdress(scan.nextLine());
			
			} 
			
		}
		
		if(count2==0) {
			System.out.println("일치하는 학번이 없습니다.다시시도 하세요.");
			upDateStudent();
		}

		UtilAboutFile.studentSave(ExData.studentList);

		ui.endComment(UIStudent.UPDATE);
		if (scan.nextLine().equals("1")) { // 한번더 수정기능 실행
			upDateStudent();

		} else {
			mainloop = true; // 상위메뉴로 돌아가기
		}

	}

	
	/**
	 * 학생 삭제하기
	 */
	public static void deleteStudent() {

		ui.title(UIStudent.DELETE);

		//삭제할 학생이름을 가져와 동일한 이름을 가진 학생들 정보 띄우기
		System.out.print("삭제할 학생의 이름을 입력하세요. : ");
		String name = scan.nextLine();

		Iterator<StudentDTO> nameiter = ExData.studentList.iterator();
		int count1=0;
		while (nameiter.hasNext()) {
			StudentDTO stuDTO = nameiter.next();
			if (stuDTO.getStudentName().equals(name)) { // 입력한 이름과 가져온 객체의 이름이 같다면

				System.out.printf("%s %s [%s(학년)] %s [%s(세)] %s \n", stuDTO.getStudentID(),
						UtilAboutCodeFind.findDepartment(stuDTO.getDeptCode()).getDeptName(), stuDTO.getGrade(),
						stuDTO.getPhoneNumber(), stuDTO.getAge(), stuDTO.getAdress());
				count1++;
			} 

		}
		//입력받은 문자와 일치하는 이름의 학생이 한명도 없을경우
		if(count1==0) {
			System.out.println("일치하는 학생이 없습니다.! 다시시도 하십시오");

			ui.endComment(UIStudent.LIST);
			if (scan.nextLine().equals("1")) { // 한번더 목록보기기능 실행
				deleteStudent();

			} else {
				mainloop = true; // 상위메뉴로 돌아가기
			}
		}
		
		//삭제할 학생의 학번을 받아와 삭제
		System.out.print("삭제할 학생의 학번을 입력하세요. : ");
		String id = scan.nextLine();
		int count2=0;
		for (int i = 0; i < ExData.studentList.size(); i++) {
			if (ExData.studentList.get(i).getStudentID().equals(id)) {
				count2++;
				ExData.studentList.remove(i);
				UtilAboutFile.studentSave(ExData.studentList);
				
				break;
			}
		}
		//학번이 일치하는 객체가 하나라도 없을 경우
		if(count2==0) {
			System.out.println("일치하는 학번이 없습니다. 다시시도하세요.");
		}
		ui.endComment(UIStudent.DELETE);
		mainloop = false;

		if (scan.nextLine().equals("1")) { // 한번더 목록보기기능 실행
			deleteStudent();

		} else {
			mainloop = true; // 상위메뉴로 돌아가기
		}

	}

	/**
	 * 학생 목록보기
	 */
	public static void listStudent() {

		ui.title(UIStudent.LIST);
		//학과의 명을 입력받아 코드로 변환해 변수에 저장
		System.out.print("원하는 목록의 학과를 입력하세요. : ");
		String deptName = scan.nextLine();

		Iterator<DepartmentDTO> deptIter = ExData.departmentList.iterator();
		String deptCode = "";
		int count1=0;
		while (deptIter.hasNext()) {
			DepartmentDTO deptDTO = deptIter.next();
			if ((deptDTO.getDeptName()).equals(deptName)) { // 입력받은 코드와 일치하는 학과명 가져오기
				deptCode = deptDTO.getDeptNumber();
				count1++;
			}

		}
		
		if(count1==0) {
			System.out.println("일치하는 학과가 없습니다.! 다시시도 하십시오");

			ui.endComment(UIStudent.LIST);
			if (scan.nextLine().equals("1")) { // 한번더 목록보기기능 실행
				listStudent();

			} else {
				mainloop = true; // 상위메뉴로 돌아가기
			}
		}

		System.out.println("[학생이름]  [학생학번]  [학과(코드)]   [전화번호]      [나이] [주소]");
		//저장된 변수의 코드와 일치하는 코드를 가진 객체정보 출력
		Iterator<StudentDTO> stuiter = ExData.studentList.iterator();
		int count2 = 0;
		while (stuiter.hasNext()) {
			StudentDTO stuDTO = stuiter.next();
			if (stuDTO.getDeptCode().equals(deptCode)) {

				System.out.printf("%s      %s     %s   %s   %s     %s \n", stuDTO.getStudentName(),
						stuDTO.getStudentID(), stuDTO.getDeptCode(), stuDTO.getPhoneNumber(), stuDTO.getAge(),
						stuDTO.getAdress());
				count2++;

			} 
		}
		
		if(count2==0) {
			System.out.println("일치하는 학생이 없습니다.! 다시시도하십시오");
			
		}

		mainloop = false;

		ui.endComment(UIStudent.LIST);
		if (scan.nextLine().equals("1")) { // 한번더 목록보기기능 실행
			listStudent();

		} else {
			mainloop = true; // 상위메뉴로 돌아가기
		}
	}

	/**
	 * 학생검색하기
	 */
	public static void searchStudent() {

		ui.title(UIStudent.SEARCH);

		System.out.print("검색할 학생의 이름을 입력하세요. : ");
		String name = scan.nextLine();

		Iterator<StudentDTO> nameiter = ExData.studentList.iterator();
		int count1 = 0;
		while (nameiter.hasNext()) {
			StudentDTO stuDTO = nameiter.next();
			if (stuDTO.getStudentName().equals(name)) { // 입력한 이름과 가져온 객체의 이름이 같다면

				System.out.printf("%s %s [%s(학년)] \n", stuDTO.getStudentID(),
						UtilAboutCodeFind.findDepartment(stuDTO.getDeptCode()).getDeptName(), stuDTO.getGrade());
				count1++;
			}
		}
		if(count1==0) {
		System.out.println("일치하는 학생이 없습니다. 다시시도하세요.");
		
		searchStudent();
		}

		System.out.print("검색할 학생의 학번을 입력하세요. : ");
		String num = scan.nextLine();

		Iterator<StudentDTO> IDiter = ExData.studentList.iterator();
		System.out.println("[학생이름]  [학생학번]  [학과(코드)]   [전화번호]      [나이] [주소]");
		int count2 = 0; 
		while (IDiter.hasNext()) {
			StudentDTO stuDTO = IDiter.next();
			if (stuDTO.getStudentID().equals(num)) { // 입력한 학번의 객체에 접근한다.

				System.out.printf("%s      %s     %s          %s   %s     %s \n", stuDTO.getStudentName(),
						stuDTO.getStudentID(), stuDTO.getDeptCode(), stuDTO.getPhoneNumber(), stuDTO.getAge(),
						stuDTO.getAdress());
				count2++;
			} 
			
		}
		
		if(count2==0) {
			System.out.println("일치하는 학번이 없습니다. 다시시도하세요.");
		}

		ui.endComment(UIStudent.SEARCH);
		if (scan.nextLine().equals("1")) { // 한번더 검색기능 실행
			searchStudent();

		} else {
			mainloop = true; // 상위메뉴로 돌아가기
		}

	}

}

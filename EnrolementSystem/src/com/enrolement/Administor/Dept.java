package com.enrolement.Administor;

import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.enrolement.DTO.DepartmentDTO;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutFile;

/**
 * 학과에 관련된 CURD 기능
 * @author 정세연
 *
 */
public class Dept {
	/**
	 * 학과정보 입력받을 스캐너 객체
	 */
	private static Scanner scan;
	/**
	 * 학과UI 사용할 객체
	 */
	private static UIDept ui ; 
	/**
	 * 학과 상위 메뉴 루프 결정값
	 */
	private static boolean mainloop; 
	static {
		scan= new Scanner(System.in);
		ui= new UIDept();
		mainloop=true;
	}
	
	/**
	 * 학과 관리 시스템 메인메소드
	 */
	public void department() {
		
		while(mainloop) {
			
			ui.deptMenu();
			
			int sel = scan.nextInt(); 
			scan.nextLine();
			
			switch(sel) {
				case 1:
					addDept(); break; //학과추가
				case 2:
					upDateDept(); break; //학과수정
				case 3:
					deleteDept(); break; //학과삭제
				case 4: 
					listDept(); break; //학과목록
				case 5:
					searchDept(); break; //학과검색
				case 0:
					mainloop=false; break; //뒤로가기
				default:
					System.out.println("잘못입력");
					continue;
			}
		}
		
		System.out.println("학과관리자 시스템 종료");

	}
	
	
	/**
	 * 학과 등록하기
	 */
	public static void addDept(){
		
		ui.title(UIDept.ADD);
		
		
		
		//학과코드 등록-----------------------------------
		ui.eachElement(UIDept.CODE);
		
		String deptCode = scan.nextLine();
		
		String patCode = "D+[0-9]{3}";
		
		//유효성1(형태)
		if(!Pattern.matches(patCode, deptCode)) {
			System.out.println("잘못된 코드형식입니다. 다시시도하세요(ex: D001)");
			addDept();
		}
		
		
		//유효성2(중복)
		Iterator<DepartmentDTO> deptIter = ExData.departmentList.iterator();
		while (deptIter.hasNext()) {
			DepartmentDTO deptDTO = deptIter.next();
			if (deptDTO.getDeptNumber().equals(deptCode)) {
				System.out.println("중복된 코드입니다. 첨부터 다시시도하세요");
				addDept();
			}
		}
		

		//학과명 등록--------------------------------------
		ui.eachElement(UIDept.NAME);
		String deptName = scan.nextLine();
		
		String patName = "[가-힣a-zA-Z]{3,30}";
		
		//유효성1(형태)
		if(!Pattern.matches(patName, deptName)) {
			System.out.println("잘못된 학과형식입니다. 다시시도하세요(3~30자)");
			addDept();
		}
		
		//유효성2(중복)
		deptIter = ExData.departmentList.iterator();
		while (deptIter.hasNext()) {
			DepartmentDTO deptDTO = deptIter.next();
			if (deptDTO.getDeptName().equals(deptName)) {
				System.out.println("중복된 학과입니다. 다시시도하세요");
				addDept();
			}
		}
		
		
		//학과사무실 등록----------------------------------
		ui.eachElement(UIDept.POSITION);
		String location = scan.nextLine();
		
		String patLoc = "[가-힣a-zA-Z0-9]{3,30}";
		
		//유효성1(형태)
		if(!Pattern.matches(patLoc, location)) {
			System.out.println("잘못된 형식입니다. 다시시도하세요(3~30자)");
			addDept();
		}
		
		//유효성2(중복)
		deptIter = ExData.departmentList.iterator();
		while (deptIter.hasNext()) {
			DepartmentDTO deptDTO = deptIter.next();
			if (deptDTO.getLocation().equals(location)) {
				System.out.println("중복된 위치입니다. 다시시도하세요");
				addDept();
			}
		}
		
		
		DepartmentDTO deptDTO = new DepartmentDTO(deptCode,deptName,location);
		ExData.departmentList.add(deptDTO);
		UtilAboutFile.departmentSave(ExData.departmentList);
		
		mainloop=false;
		
		ui.endComment(UIDept.ADD);
		if(scan.nextLine().equals("1")) { //한번더 추가기능 실행
			addDept();
			
		} else {
			mainloop=true; //상위메뉴로 돌아가기
		}
		
	
		
	}
	
	
	/**
	 * 학과 수정하기
	 */
	public static void upDateDept(){
		ui.title(UIDept.UPDATE);
		
		Iterator<DepartmentDTO> nameiter = ExData.departmentList.iterator(); 

		System.out.println("[학과코드]   [학과명]   	  [학과사무실]");
		System.out.println();
		while (nameiter.hasNext()) {
			DepartmentDTO deptDTO = nameiter.next();
				
			System.out.printf("%5s       %-10s     %10s  \n"
					          ,deptDTO.getDeptNumber()
					          ,deptDTO.getDeptName()
					 		  ,deptDTO.getLocation()
							  );	
			
		}
		
		System.out.println();
		System.out.print("수정할 학과의 코드를 입력하세요. : ");
		String deptCode = scan.nextLine();
		
		Iterator<DepartmentDTO> nameIter = ExData.departmentList.iterator(); 
		int count1=0;
		while (nameIter.hasNext()) {
			DepartmentDTO deptDTO = nameIter.next();
			if(deptDTO.getDeptNumber().equals(deptCode)) { //입력한 학번의 객체에 접근한다.
				
				count1++;
				
				//학과명수정
				ui.eachElement(UIDept.NAME);
				deptDTO.setDeptName(scan.nextLine());
				
				//학과코드수정
				ui.eachElement(UIDept.CODE);
				deptDTO.setDeptNumber(scan.nextLine());
			
				//과사 위치수정
				ui.eachElement(UIDept.POSITION);
				deptDTO.setLocation(scan.nextLine());			
				
			} 

		}
		
		UtilAboutFile.departmentSave(ExData.departmentList);
		
		if(count1==0) { //일치하는 학과가 없을 경우
			System.out.println("일치하는 학과가 없습니다. 다시시도하세요.");
			System.out.println("1.한번더 실행하기\t2.상위메뉴로 돌아가기");
			System.out.print("[번호 선택] : ");
		} else { //일치하는 학과가 있을 경우
			
			ui.endComment(UIDept.UPDATE);
		}
	
		
		if(scan.nextLine().equals("1")) { //한번더 수정기능 실행
			upDateDept();
			
		} else {
			mainloop=true; //상위메뉴로 돌아가기
		}

		
	}
	
	/**
	 * 학과삭제하기
	 */
	public static void deleteDept(){
		
		ui.title(UIDept.DELETE);
		
		
		
		Iterator<DepartmentDTO> nameiter = ExData.departmentList.iterator(); 

		System.out.println("[학과코드]   [학과명]   	  [학과사무실]");
		System.out.println();
		while (nameiter.hasNext()) {
			DepartmentDTO deptDTO = nameiter.next();
			
			System.out.printf("%5s       %-10s     %10s  \n"
							,deptDTO.getDeptNumber()
							,deptDTO.getDeptName()
							,deptDTO.getLocation()
					  		);		
	
		}
		
		System.out.println();
		System.out.print("삭제할 학과의 학과코드를 입력하세요. : ");
		String id = scan.nextLine();
		int count1=0;
		for(int i =0; i<ExData.departmentList.size();i++) {
			if((ExData.departmentList.get(i).getDeptNumber()).equals(id)) {
				count1++;
				ExData.departmentList.remove(i);
				UtilAboutFile.departmentSave(ExData.departmentList);
				ui.endComment(UIDept.DELETE);
				break;
			} 
			
		}
		
		if(count1==0) {
			System.out.println("일치하는 학과코드가 없습니다.");
		}
		
		mainloop=false;
		
		if(scan.nextLine().equals("1")) { //한번더 목록보기기능 실행
			deleteDept();
			
		} else {
			mainloop=true; //상위메뉴로 돌아가기
		}
		
		
	}

	/**
	 * 학과목록보기
	 */
	public static void listDept() {
		
		ui.title(UIDept.LIST);

		
		
		Iterator<DepartmentDTO> nameiter = ExData.departmentList.iterator(); 

		System.out.println("[학과코드]   [학과명]   	  [학과사무실]");
		System.out.println();
		while (nameiter.hasNext()) {
			DepartmentDTO deptDTO = nameiter.next();
			
				
			System.out.printf("%5s       %-10s     %10s  \n"
							  ,deptDTO.getDeptNumber()
							  ,deptDTO.getDeptName()
					 		  ,deptDTO.getLocation()
							  );	
			
		}
		
		ui.endComment(UIDept.LIST);
		mainloop=false;
		
		
		if(scan.nextLine().equals("1")) { //한번더 목록보기기능 실행
			listDept();
			
		} else {
			mainloop=true; //상위메뉴로 돌아가기
		}
	}

	/**
	 * 학과검색하기
	 */
	public static void searchDept() {
		
		ui.title(UIDept.SEARCH);

		System.out.print("검색할 학과의 이름을 입력하세요. : ");
		String deptname = scan.nextLine();
		
		
		System.out.println();
		Iterator<DepartmentDTO> nameIter = ExData.departmentList.iterator(); 
		int count1=0;
		System.out.println("[학과코드]   [학과명]   	  [학과사무실]");
		
		while (nameIter.hasNext()) {
			DepartmentDTO deptDTO = nameIter.next();
			if(deptDTO.getDeptName().equals(deptname)) { //입력한 이름과 가져온 객체의 이름이 같다면 
			count1++;
			System.out.printf("%5s       %-10s     %10s  \n"
							  ,deptDTO.getDeptNumber()
							  ,deptDTO.getDeptName()
							  ,deptDTO.getLocation()
							  );
							 
			} 
			
		}
		if(count1==0) {
			System.out.println("일치하는 학과가 없습니다.다시시도하세요.");
		}
		
		ui.endComment(UIDept.SEARCH);
		if(scan.nextLine().equals("1")) { //한번더 검색기능 실행
			searchDept();
			
		} else {
			mainloop=true; //상위메뉴로 돌아가기
		}
	
	
	}
}

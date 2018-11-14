package com.enrolement.Administor;

import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.enrolement.DTO.ProfessorDTO;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutFile;

/**
 * 
 * @author 교수 클래스 입니다.
 */

public class Professor {

	/**
	 *  scan을 담을 변수.
	 */
	private static Scanner scan;  //공용데이터 사용할 scan 
	/**
	 *  ui를 담을 변수.
	 */
	private static UIProfessor ui; //공용데이터 ui

	
	
	static {

		/**
		 *  공용으로 사용할 데이터. scan
		 */
		scan = new Scanner(System.in); //공용데이터 사용할 scan 
		
		/**
		 *  공용으로 사용할 데이터. ui
		 */
		ui = new UIProfessor();	 		//공용데이터 ui
		
	} // 지역 공용데이터

	
	/**
	    * 메뉴시작(등록,수정,삭제,목록) 호출 메소드
	    *  
	    */
		public void professor() {

		/**
		 *  교수정보를 읽어온다.
		 */
		UtilAboutFile.load();  // 배열로 담아진 교수정보를 읽어온다.

		boolean loop = true;

		/**
		    * 메뉴 시작
		    * @param loop - 
		    */
		while (loop) { //메뉴 루프

			ui.menu();
			
			/**
			    * 메뉴(추가하기, 이전 메뉴로 ) 호출 메소드
			    * @param sel 
			    */
			int sel = scan.nextInt();
			scan.nextLine();

			/**
			 *  sel 입력값은 값으로 메뉴 선택
			 */
			switch (sel) { // 메뉴선택

			case 1:
				add();
				break;

			case 2:
				update();
				break;

			case 3:
				delete();
				break;

			case 4:
				list();
				break;

			default:
				loop = false;
				break;

			}

		}

		System.out.println("프로그램 종료 ");

	}

   /**
     * 교수추가(등록,수정,삭제,목록) 호출 메소드
     * @param add()  
     */
	private static void add() { // 교수님 추가하기

		/**
		 *  교수메뉴UI 호출
		 */
		ui.start(UIProfessor.PROADD);

		/**
		 *  교수 코드 입력 & 교수 코드 유효성 검사
		 */
		System.out.print("[교수코드] : ");
		String professorCode = scan.nextLine();
		String regexCode = "^[A-Za-z0-9]{2,6}$";
		if (Pattern.matches(regexCode, professorCode)) {
			System.out.println("-올바른 교수코드-");
		} else {
			System.out.println("-올바르지 않는 교수 코드입니다.-");
			add();
		}// 교수 코드 입력 & 교수 코드 유효성 검사

		/**
		 *  교수 이름 입력 & 교수 이름 유효성검사
		 */
		System.out.print("[교수이름] : ");
		String professorName = scan.nextLine();
		String regexName = "[가-힣]{2,4}";
		if (Pattern.matches(regexName, professorName)) {
			System.out.println("-올바른 이름-");
		} else {
			System.out.println("-올바르지 않는 이름입니다.-");
			add();
		}// 교수 이름 입력 & 이름 유효성검사

		/**
		 *  학과 코드 입력 & 학과코드 유효성검사
		 */
		System.out.print("[학과코드] : ");
		String deptCode = scan.nextLine();
		String regexDpCode = "^[A-Za-z0-9]{2,6}";
		if (Pattern.matches(regexDpCode, professorCode)) {
			System.out.println("-올바른 학과코드-");
		} else {
			System.out.println("-올바르지 않는 학과코드입니다.-");
			add();
		}// 학과 코드 입력 & 학과코드 유효성검사

		/**
		 *  연락처 입력 & 연락처 유효성검사
		 */
		System.out.print("[연락처] : ");
		String phoneNumber = scan.nextLine();
		String regexNumber = "[0123456789]{3}-[0123456789]{3,4}-[0123456789]{3,4}";
		if (Pattern.matches(regexNumber, phoneNumber)) {
			System.out.println("-올바른 연락처-");
		} else {
			System.out.println("-올바르지 않는 연락처 입니다.-");
			add();
		}// 연락처 입력 & 연락처 유효성검사

		/**
		 *  나이 입력 & 나이 유효성 검사
		 */
		System.out.print("[나이] : ");
		String age = scan.nextLine();
		String regexAge = "^[0-9]{1,2}";
		if (Pattern.compile(regexAge).matcher(age).find()) {
			System.out.println("-올바른 나이-");
		} else {
			System.out.println("-올바르지 않는 나이-");
			add();
		}// 나이 입력 & 나이 유효성 검사
		
		/**
		 *  연구소 입력
		 */
		System.out.print("[연구소] : ");
		String studyroom = scan.nextLine();
		// 연구소 입력

		/**
		 * ProAdd 객체 생성
		 * @param 교수코드, 교수이름, 학과코드, 핸드폰번호, 나이 ,연구소
		 *
		 */
		ProfessorDTO ProAdd = new ProfessorDTO(professorCode, professorName, deptCode, phoneNumber, age, studyroom);

		/**
		 *  교수리스트에 추가 & 저장
		 */
		ExData.professorList.add(ProAdd);
		UtilAboutFile.professorSave(ExData.professorList);

		/**
		 *  교수UI 종료.
		 */
		ui.end(UIProfessor.PROADD);

		
		/**
		    * 메뉴(추가하기, 이전 메뉴로 ) 호출 메소드
		    * @param sel 
		    */
		int sel = scan.nextInt();
		scan.nextLine();

		switch (sel) {  //메뉴 선택

		case 1:
			add();
			break;

		case 2:
			ui.menu();
			break;

		default:
			break;
		}

		System.out.println("잘못 입력 하셨습니다. ");
	}

	
	 /**
     * 교수 수정 호출 메소드
     * @param update()  
     */
	private static void update() { // 교수님 수정
		
		
		/**
		 *  교수메뉴 UI호출
		 */
		ui.start(UIProfessor.PROUPDATE);
		
		/**
		 *  iter 생성
		 */
		Iterator<ProfessorDTO> iter = ExData.professorList.iterator();

		System.out.println("[교수 코드]   [교수 이름]    [학과 코드]         [핸드폰 번호]      [교수 나이]         [연구실 위치]");

		/**
		 *  교수목록을 갖고온다.
		 */
		while (iter.hasNext()) {
			ProfessorDTO dto = iter.next();

			/**
			 *  교수 목록을 출력한다.
			 */
			System.out.printf("%s\t\t %s\t\t %s\t\t %s\t\t %s\t\t %s\n", dto.getProfessorCode(), dto.getProfessorName(),
					dto.getDeptCode(), dto.getPhoneNumber(), dto.getAge(), dto.getStudyroom());
		} // 목록보여주기
		
		System.out.println("========================================================================================================");
		System.out.println("[교수 정보 불러오기] ");
		System.out.println("========================================================================================================");
		System.out.print("[교수 코드] : ");
				
		
		
		/**
		 *  목록에서 코드 검색하기 위해 입력 & 코드 유효성 검사
		 */
		String proID = scan.nextLine();
		String regexCode = "^[A-Za-z0-9]{2,6}$";
		if (Pattern.matches(regexCode, proID)) { // 패턴이 regexCode의 조건과 ID가 맞으면 유효성 통과
			System.out.println("[올바른 교수코드]");
		} else {
			System.out.println("[올바르지 않는 교수 코드입니다.]");
			update();
		}//목록에서 코드 검색하기 위해 입력 & 코드 유효성 검사
		
		// UtilAboutFile.load();

		System.out.println(
				"========================================================================================================");
		System.out.println("[교수 코드]   [교수 이름]    [학과 코드]         [핸드폰 번호]      [교수 나이]         [연구실 위치]");
		
		/**
		 *  IDiter 생성
		 */
		Iterator<ProfessorDTO> IDiter = ExData.professorList.iterator();
		/**
		 *  iter.hasNext()-> 교수목록을 갖고온다.
		 */
		while (IDiter.hasNext()) {
			ProfessorDTO proDTO = IDiter.next();
			
			/**
			 *  교수코드와 일치하는 교수 검색
			 */
				if (proDTO.getProfessorCode().indexOf(proID) == -1) {
					continue;
				}// 검색하기
				
				/**
				 *  교수코드와 일치하는 교수 출력
				 */
				System.out.printf("%s\t\t %s\t\t %s\t\t %s\t\t %s\t\t %s\n", proDTO.getProfessorCode(), proDTO.getProfessorName(),
						proDTO.getDeptCode(), proDTO.getPhoneNumber(), proDTO.getAge(), proDTO.getStudyroom());

				System.out.println("========================================================================================================");
				System.out.println("[교수 정보를 수정하시오]");
				System.out.println("========================================================================================================");
		
				
				/**
				 *  불러온 교수코드와 같으면 수정한다.
				 */
			if (proDTO.getProfessorCode().equals(proID)) {
				
				/**
				 *  교수 코드 수정
				 */
				System.out.print("[교수코드] : ");
				proDTO.setProfessorCode(scan.nextLine());

				/**
				 *  교수 이름 수정
				 */
				System.out.print("[교수이름] : ");
				proDTO.setProfessorName(scan.nextLine());

				/**
				 *  학과 코드 수정
				 */
				System.out.print("[학과코드] : ");
				proDTO.setDeptCode(scan.nextLine());

				/**
				 *  교수 연락처 수정
				 */
				System.out.print("[연락처] : ");
				proDTO.setPhoneNumber(scan.nextLine());

				/**
				 *  교수 나이 수정
				 */
				System.out.print("[나이] : ");
				proDTO.setAge(scan.nextLine());

				/**
				 *  교수 연구소 수정
				 */
				System.out.print("[연구소] : ");
				proDTO.setStudyroom(scan.nextLine());

			}
			System.out.println("========================================================================================================");
			System.out.println("[수정이 완료되었습니다.]");
			System.out.println("========================================================================================================");
			System.out.println("[교수 코드]   [교수 이름]    [학과 코드]         [핸드폰 번호]      [교수 나이]         [연구실 위치]");
			
			
			/**
			 *   수정된 교수정보를 출력한다.
			 */
			System.out.printf("%s\t\t %s\t\t %s\t\t %s\t\t %s\t\t %s\n", proDTO.getProfessorCode(),
					proDTO.getProfessorName(), proDTO.getDeptCode(), proDTO.getPhoneNumber(), proDTO.getAge(),
					proDTO.getStudyroom()); //수정후  수정한 교수 코드 출력
			
			/**
			 *  수정된 교수정보를 저장한다.
			 */
			UtilAboutFile.professorSave(ExData.professorList);  // 수정된 교수 정보 저장
			
			System.out.println("========================================================================================================");
		
		}
		
		/**
		 *  교수UI 종료.
		 */
		ui.end(UIProfessor.PROUPDATE);

		
		/**
		    * 메뉴(추가 수정, 이전 메뉴로 ,목록) 호출 메소드
		    * @param sel 
		    */
		int sel = scan.nextInt();
		scan.nextLine();
	switch (sel) {  //메뉴 선택

		case 1:
			update();
		break;
		case 2:
			ui.menu();
			break;

		case 3:
			list();
			break;
		default:
			break;

	}
	
	

		System.out.println("잘못 입력 하셨습니다. ");

	

}
	/**
	 * 교수정보 삭제하기
	 * @param delete()
	 */
	private static void delete() { //교수 삭제하기

		/**
		 *  교수메뉴 UI호출
		 */
		ui.start(UIProfessor.PRODELETE);
		
		/**
		 *  iter생성
		 */
		Iterator<ProfessorDTO> iter = ExData.professorList.iterator();

		System.out.println("[교수 코드]   [교수 이름]    [학과 코드]         [핸드폰 번호]      [교수 나이]         [연구실 위치]");

		/**
		 *  교수목록을 갖고온다.
		 */
		while (iter.hasNext()) {
			ProfessorDTO dto = iter.next();
			
			/**
			 *  교수코드와 일치하는 교수 출력
			 */
			System.out.printf("%s\t\t %s\t\t %s\t\t %s\t\t %s\t\t %s\n", dto.getProfessorCode(), dto.getProfessorName(),
					dto.getDeptCode(), dto.getPhoneNumber(), dto.getAge(), dto.getStudyroom());
		}
		System.out.println(
				"========================================================================================================");
		System.out.println("삭제할 교수 정보 입력하시오.");
		System.out.println(
				"========================================================================================================");
		System.out.print("[교수 코드] : ");
		
		/**
		 *  교수 코드를 입력 & 교수 유효성
		 */
		String professorCode = scan.nextLine();
		String regexPrCode = "^[A-Za-z0-9]{2,6}$";
		if (Pattern.matches(regexPrCode, professorCode)) {
			System.out.println("[올바른 교수코드]");
		} else {
			System.out.println("[올바르지 않는 교수 코드입니다.]");
			delete();
		}// 교수 코드를 입력 & 교수 유효성
		
		
		/**
		 *  교수 리스트 사이즈만듬 루프 돌다가 입력한 코드 값이 리스트에있는 코드랑 같으면 삭제하고 삭제한 값을 다시 교수 리스트에 저장한다.
		 */
		for (int i = 0; i < ExData.professorList.size(); i++) {
			if ((ExData.professorList.get(i).getProfessorCode()).equals(professorCode)) {
				ExData.professorList.remove(i);
				UtilAboutFile.professorSave(ExData.professorList);

				break; // 교수 리스트 사이즈만듬 루프 돌다가 입력한 코드 값이 리스트에있는 코드랑 같으면 삭제하고 삭제한 값을 다시 교수 리스트에 저장한다.
			}

		}

		/**
		 *  교수삭제 UI출력
		 */
		ui.end(UIProfessor.PRODELETE); // 교수삭제 ui 출력

		
		/**
		    * 메뉴(추가 삭제, 이전 메뉴로 ,목록) 호출 메소드
		    * @param sel 
		    */
		int sel = scan.nextInt();
		scan.nextLine();

		switch (sel) {  //메뉴 선택

		case 1:
			delete();
			break;

		case 2:
			ui.menu();
			break;

		case 3:
			list();
			break;

		default:
			break;

		}

		System.out.println("잘못 입력 하셨습니다. ");
	}
	
	/**
	 * 교수 목록을 호출한다.
	 * @param list()
	 */
	private static void list() {
		
		
		/**
		 *  교수LIST UI호출
		 */
		ui.start(UIProfessor.PROLIST);

		
		/**
		 *  iter생성
		 */
		Iterator<ProfessorDTO> iter = ExData.professorList.iterator();
		System.out.println("========================================================================================================");
		System.out.println("[교수 코드]   [교수 이름]    [학과 코드]         [핸드폰 번호]      [교수 나이]         [연구실 위치]");
		
		/**
		 *  교수목록을 갖고온다.
		 */
		while (iter.hasNext()) {
			ProfessorDTO dto = iter.next();

			/**
			 *   교수목록 출력
			 */
			System.out.printf("%s\t\t %s\t\t %s\t\t %s\t\t %s\t\t %s\n", dto.getProfessorCode(), dto.getProfessorName(),
					dto.getDeptCode(), dto.getPhoneNumber(), dto.getAge(), dto.getStudyroom());  
		}  // 교수 목록을 출력

		/**
		 *  교수LIST UI종료
		 */
		ui.end(UIProfessor.PROLIST);

		
		/**
		    * 메뉴(추가 검색, 이전 메뉴로 ) 호출 메소드
		    * @param sel 
		    */
		int sel = scan.nextInt();
		scan.nextLine();

		switch (sel) {  // 메뉴 출력

		case 1:
			search();
			break;

		case 2:
			
			ui.menu();
			break;

		default:
			break;

		}
		System.out.println("잘못 입력 하셨습니다. ");

	}

	
	
	/**
	 * 교수 검색메소드 호출
	 * @param search()
	 */
	private static void search() { // 교수 검색하기
		
		/**
		 *  교수검색 UI출력
		 */
		ui.startSearch();

		/**
		 *  교수 코드 입력 & 교수 코드 유효성 검사
		 */
		System.out.print("[교수 코드] : ");
		String professorCode = scan.nextLine();
		String regexPrCode = "^[A-Za-z0-9]{2,6}$";
		if (Pattern.matches(regexPrCode, professorCode)) {
			System.out.println("[올바른 교수코드]");
		} else {
			System.out.println("[올바르지 않는 교수 코드입니다.]");
			search();
		}// 교수 코드 입력 & 교수 코드 유효성 검사
		
		System.out.println();
		
		
		
		/**
		 *  iter생성
		 */
		Iterator<ProfessorDTO> iter = ExData.professorList.iterator();
	
		System.out.println("========================================================================================================");
		System.out.println("[교수 코드]   [교수 이름]    [학과 코드]         [핸드폰 번호]      [교수 나이]         [연구실 위치]");
		System.out.println("========================================================================================================");
		/**
		 *  교수목록을 갖고온다.
		 */
		while (iter.hasNext()) {
			ProfessorDTO dto = iter.next();
			/**
			 *  교수 코드와 일치하는 교수를 검색.
			 */
			if (dto.getProfessorCode().indexOf(professorCode) == -1) {
				continue; 
			} // 교수 코드와 일치하는 교수를 검색
			
			/**
			 *  교수
			 */
			System.out.printf("%s\t\t %s\t\t %s\t\t %s\t\t %s\t\t %s\n", dto.getProfessorCode(), dto.getProfessorName(),
					dto.getDeptCode(), dto.getPhoneNumber(), dto.getAge(), dto.getStudyroom()); // 조건에 맞는 교수를 출력

		}
		ui.endSearch();
		
		
		/**
		    * 메뉴(추가 검색, 이전 메뉴로) 호출 메소드
		    * @param sel 
		    */
		int sel = scan.nextInt();
		scan.nextLine();

		switch (sel) {  // 메뉴 출력

		case 1:
			search();
			break;

		case 2:
			
			ui.menu();
			break;

		default:
			break;

		}
		System.out.println("잘못 입력 하셨습니다. ");

	}

}
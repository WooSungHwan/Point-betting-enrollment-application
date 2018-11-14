package com.enrolement.Enrolement;

import java.util.Iterator;
import java.util.Scanner;

import com.enrolement.DTO.AdminLoginDTO;
import com.enrolement.DTO.StudentDTO;
import com.enrolement.DTO.StudentLoginDTO;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutCodeFind;
import com.enrolement.Util.UtilAboutFile;

/**
 * 수강신청시스템의 뼈대를 구성하는 클래스.
 * @author 우성환
 *
 */
public class Enrolement {
	/**
	 * 입출력 스캐너
	 */
	Scanner sc = new Scanner(System.in);
	/**
	 * 예비수강신청 서버 개폐여부변수
	 */
	public static boolean enrolementServer1 = false;
	/**
	 * 수강신청 서버 개폐여부 변수
	 */
	public static boolean enrolementServer2 = false;
	/**
	 * 프로그램종료 여부 변수
	 */
	public static boolean programOnOff = true;
	/**
	 * 로그인한 학생의 객체를 보관하는 변수
	 */
	public static StudentDTO loginStudent;
	
	/**
	 * 생성자, 동시에 UtilAboutFile.load()메소드를 실행하여 파일에서 정보를 읽어온다.
	 */
	public Enrolement() {
		UtilAboutFile.load();
	}
	
	/**
	 * 프로그램의 메인메소드에 해당하는 메소드이다.
	 * 프로그램의 최상위 단계메소드이다.
	 */
	public void programStart() {// 2
		// 모든 프로그램.
		startScreen();
		while (programOnOff) {
			int result = login();
			if (result == 1) { // 학생 로그인.
				StudentSide s = new StudentSide();// 3
			} else if (result == 2) {// 관리자 로그인.
				AdminSide a = new AdminSide();
			} else if (result == 4) {
				ruclose();
			} else { // 0이면 둘다 결과없어서 재로그인시도해야함
				System.out.println("로그인 실패 -> 재시도");
				continue;
			}
		}

	}
	/**
	 * 수강신청 시스템 시작 스크린 메소드
	 */
	public void startScreen() {
		System.out.println("\t\t\t\t\t");
		System.out.println("\t\t\t\t\t/\\\t/\\");
		System.out.println("\t\t\t    ┌───────────┘└──────┘└──────────┐");
		System.out.println("\t\t\t    │\t          ★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆\t    │");
		System.out.println("\t\t\t    │\t         쌍용 대학교 수강신청 시스템\t    │");
		System.out.println("\t\t\t    │\t          ★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆\t    │");
		System.out.println("\t\t\t    └───────────────────────────────┘");
		pause();
	}
	
	/**
	 * 로그인을 수행하는 메소드이다. 
	 * @return 관리자로 접속하면 2, 학생으로 접속하면 1, 그이외는 0을 리턴한다.
	 */
	public int login() {
		// 로그인List에서 비교하고 해당 학번의 studentDTO객체를 가져온다.
		// 관리자와 학생버전으로 나뉜다.
		System.out.println("\t\t\t┌───────────────────────────────────────┐");
		System.out.println("\t\t\t│ (안내)프로그램을 종료하시려면 id에 0을 입력해주세요.. │ ");
		System.out.println("\t\t\t│\t\t☆★★☆★☆★☆★\t\t│");
		System.out.println("\t\t\t│\t\t☆★☆로그인☆☆\t\t│");
		System.out.println("\t\t\t│\t\t☆★★☆★☆★☆★\t\t│");
		System.out.println("\t\t\t└───────────────────────────────────────┘");
		System.out.print("\t\t\t아이디 : ");
		String id = sc.nextLine();
		if (id.equals("0"))
			return 4;
		System.out.print("\t\t\t비밀번호 : ");
		String pwd = sc.nextLine();

		/* 관리자로그인 */
		Iterator<AdminLoginDTO> iter2 = ExData.getAdminLoginList().iterator();
		while (iter2.hasNext()) {
			AdminLoginDTO admin = iter2.next();
			if (admin.getId().equals(id) && admin.getPwd().equals(pwd)) { // 관리자 정보 일치함
				return 2;
			}
		}

		/* 학생로그인 */
		// 학생로그인에 있는 파일(리스트)와 대조.

		Iterator<StudentLoginDTO> iter = ExData.getStudentLoginList().iterator();

		while (iter.hasNext()) {
			StudentLoginDTO studentData = iter.next();
			if (id.equals(studentData.getId())) { // 입력한아이디와 비밀번호가 같은 것 발견.
				if (pwd.equals(studentData.getPwd())) { // 입력한 비밀번호와 같은것도 발견.
					loginStudent = UtilAboutCodeFind.findStudent(studentData.getId());// 로그인 한 학생에 입력한 아이디를 찾아 담고 그
																						// 학번을가진 학생 객체를 찾아 대입
					System.out.println("\t\t\t");
					System.out.println("\t\t\t┌─────────────────────────────────────────────┐");
					System.out.println("\t\t\t│\t『" + loginStudent.getStudentName() + "』학생 안녕하세요. 로그인 되었습니다.\t      │");
					System.out.println("\t\t\t└─────────────────────────────────────────────┘");
					return 1;
				}
			}
		}
		return 0;
	}
	
	/**
	 * 프로그램을 종료할 것인지 여부를 물어보는 메소드이다.
	 */
	private void ruclose() {

		while (true) {
			System.out.println("\t\t\t┌──────────────────────────┐");
			System.out.print("\t\t\t프로그램을 종료하시겠습니까?(y|n)");
			
			String rucloseSystem = sc.nextLine();
			if (rucloseSystem.equals("y") || rucloseSystem.equals("Y")) {
				programOnOff = false;// 종료하겠다.
				break;
			} else if (rucloseSystem.equals("n") || rucloseSystem.equals("N")) {
				programOnOff = true;
				break;
			} else {
				System.out.println("잘못입력했습니다.");
			}
		}
	}
	
	/**
	 * 프로그램 실행중에 잠시 중단할 상황이 있을때 사용하는 메소드이다.
	 */
	public void pause() {
		System.out.println("\t\t\t┌───────────────────────────────────────┐");
		System.out.println("\t\t\t│\t  ★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆\t\t│");
		System.out.println("\t\t\t│\t  계속하시려면 엔터를 입력해주세요.\t\t│");
		System.out.println("\t\t\t│\t  ★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆\t\t│");
		System.out.println("\t\t\t└───────────────────────────────────────┘");
		sc.nextLine();
	}

}

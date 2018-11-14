package com.enrolement.Enrolement;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.enrolement.Administor.ClassRoom;
import com.enrolement.Administor.Dept;
import com.enrolement.Administor.Professor;
import com.enrolement.Administor.Student;
import com.enrolement.Administor.SubjectMenu;
import com.enrolement.DTO.FinalEnrolementDTO;
import com.enrolement.DTO.InterestSubjectListDTO;
import com.enrolement.DTO.NoticeDTO;
import com.enrolement.DTO.OpinionDTO;
import com.enrolement.DTO.PointUseDTO;
import com.enrolement.DTO.StudentDTO;
import com.enrolement.MockEnrolment.MockEnrolement;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutCodeFind;
import com.enrolement.Util.UtilAboutFile;
import com.enrolement.Util.UtilAboutSubject;

/**
 * 관리자 사이드의 모든 기능을 가지고 있는 클래스
 * @author 우성환
 *
 */
public class AdminSide {
	/**
	 * 스캐너 객체
	 */
	Scanner sc;
	
	/**
	 * AdminSide 생성자 관리자 페이지의 분기문이 들어있다.
	 */
	public AdminSide() {
		sc = new Scanner(System.in);

		while (true) {
			adminLoginUI();
			String sel = sc.nextLine();
			switch (sel) {
			case "1":
				// 학생관리
				Student st = new Student();
				st.student();
				break;

			case "2":
				// 교수관리
				Professor pro = new Professor();
				pro.professor();
				break;

			case "3":
				// 수강과목 관리
				SubjectMenu sm = new SubjectMenu();
				sm.subject();
				break;

			case "4":
				// 강의실 관리
				ClassRoom c = new ClassRoom();
				c.classroomAdmin();
				break;

			case "5":
				// 학과관리
				Dept d = new Dept();
				d.department();
				break;

			case "6": // 완료
				// 수강신청개시
				while (true) {
					enrolementStart();
					sel = sc.nextLine();
					if (sel.equals("1")) { // 예비수강 열기
						Enrolement.enrolementServer1 = true;
						System.out.println();
						System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						System.out.println("\t☆★예비수강신청서버를 열었습니다.☆★");
						System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						System.out.println();
						pause();
						break;
					} else if (sel.equals("2")) { // 수강신청열기
						Enrolement.enrolementServer1 = false;
						Enrolement.enrolementServer2 = true;
						System.out.println("수강신청 서버를 열었습니다.");
						pause();
						break;
					} else if (sel.equals("3")) { // 서버차단.
						Enrolement.enrolementServer1 = false;
						Enrolement.enrolementServer2 = false;
						System.out.println("서버를 차단하였습니다. 학생들은 로그인할 수 없습니다.");
						pause();
						break;
					} else if (sel.equals("0")) {
						return;
					} else {
						System.out.println("잘못입력하셨습니다. 정확히 입력해주시기 바랍니다.");
						pause();
						continue;
					}
				}
				break;
			case "7":
				// 공지사항 작성//학생의견함 확인
				while (true) {
					System.out.println("1. [공지사항 작성]");
					System.out.println("2. [학생 의견함 확인]");
					System.out.println("0. [뒤로가기]");
					sel = sc.nextLine();
					if (sel.equals("1")) {
						// 공지
						enroleNoticement();
						System.out.println("!!공지사항 전달 완료!!");
						pause();
						break;
					} else if (sel.equals("2")) {
						// 의견
						studentOpinionCheck();
						pause();
						break;
					} else if (sel.equals("0")) {
						// 뒤로가기
						return;
					} else {
						System.out.println("숫자를 정확히 입력해주시기 바랍니다.");
					}
				}
				break;
			case "8":
				// 모의 예비수강신청... 다른학생들 로그인한 학생 제외.
				// 수강신청상황 종료... -> 포인트 결과발표..
				boolean check = true;
				while (check) {
					
					System.out.println("\t\t\t1. [모의 예비수강신청]");
					System.out.println("\t\t\t2. [모의 수강신청]");
					System.out.println("\t\t\t3. [수강신청 결과반환]");
					System.out.println("\t\t\t0. [뒤로가기]");
					sel = sc.nextLine();
					if (sel.equals("1")) {
						// 모의 예비수강신청
						if (!Enrolement.enrolementServer1) {
							// 예비수강기간 아니면 안됨
							System.out.println("☆★☆★☆★☆★☆★☆☆★☆★☆★☆★☆★☆공지사항☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
							System.out.println("\t\t\t예비수강신청 기간이 아니므로 접근하실 수 없습니다");
							System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆☆★☆★☆★☆★☆★☆☆☆★☆★☆★☆★☆★☆★☆★☆");
							break;
						}
						MockEnrolement mock = new MockEnrolement();
						Iterator<StudentDTO> iter = ExData.studentList.iterator();
						System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆☆★☆★☆★☆★☆★☆");
						System.out.println("\t☆★\t모의 수강신청 진행\t☆★");
						System.out.println("\t☆★☆★☆★☆★☆★☆☆★☆★☆★☆★☆★☆★☆★☆");
						System.out.println();
						while (iter.hasNext()) {
							StudentDTO sDTO = iter.next();
							if (sDTO.getStudentID().equals("12468925")) {// 여기에 학번입력하면 그학생만 신청제외.
								continue;
							}

							mock.enrolement(sDTO);
						}
						System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆");
						System.out.println("\t☆★모의 수강신청 종료★☆");
						System.out.println("\t☆★☆★☆★☆★☆★☆☆★☆★");
						System.out.println();
						pause();
					} else if (sel.equals("2")) {
						// 수강신청
						System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆");
						System.out.println("\t☆★모의 수강신청 진행☆★");
						System.out.println("\t☆★☆★☆★☆★☆★☆☆★☆★");
						mockFinalEnrolement();
						System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★");
						System.out.println("\t☆★모의 수강신청 종료☆★★");
						System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★");
						pause();
					} else if (sel.equals("3")) {
						// 수강신청 종료
						endFinalEnrolement();
						System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★");
						System.out.println("\t☆★☆★수강신청 종료☆☆★★");
						System.out.println("\t☆★☆결과를확인하세요★☆★");
						System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★");
					} else if (sel.equals("0")) {
						// 뒤로가기
						check = false;
						continue;
					} else {
						System.out.println("정확한 숫자를 입력해주시기 바랍니다.");
						pause();
					}
				}
				break;
			case "9": // 포인트 관리.
				int studentNum = ExData.studentList.size();
				System.out.println("");
				int point = studentNum;
				Iterator<StudentDTO> iter2 = ExData.studentList.iterator();
				while (iter2.hasNext()) {
					StudentDTO sDTO = iter2.next();
					sDTO.setHoldingPoint(point);
				}
				System.out.println("\t☆★포인트를 모두 할당하였습니다.☆★");
				pause();
				break;
			case "0":
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
		}
	}
	
	/**
	 * 최종 과목 신청을 하고 그 결과를 파일에 저장한다.
	 */
	public void endFinalEnrolement() {
		Set<String> subjectCodeSet = new HashSet<String>(); //과목코드를 가질 임시 배열... 중복없이 코드만.
		TreeSet<PointUseDTO> pointSet = new TreeSet<PointUseDTO>();
		
		Iterator<PointUseDTO> iter = ExData.pointUseList.iterator();
		while(iter.hasNext()) {
			PointUseDTO pDTO = iter.next();
			subjectCodeSet.add(pDTO.getSubjectCode());//과목코드 집어넣고 중복없이
		}//과목코드 배열 생성
		
		
		Iterator<String> codeIter = subjectCodeSet.iterator();
		while(codeIter.hasNext()) {
			String subjectCode = codeIter.next();
			Iterator<PointUseDTO> pointIter = ExData.pointUseList.iterator();
			while(pointIter.hasNext()) {
				PointUseDTO pDTO = pointIter.next();
				if(subjectCode.equals(pDTO.getSubjectCode())) {//과목코드가 같은 것 추출...
					pointSet.add(pDTO);//내림차순으로 포인트별로 저장...
				}
			}
			//이시점에서 포인트별로 같은 과목이 신청갯수만큼 담아짐...
			//이제 정원만큼 위에서 잘라야함...
			Iterator<PointUseDTO> iter2=pointSet.iterator();
			int count=0;
			while(iter2.hasNext()) {
				PointUseDTO pDTO = iter2.next();
				if(ExData.finalEnrolementList.add(new FinalEnrolementDTO(pDTO.getStudentID(), pDTO.getSubjectCode()))) {
					//들어간거
				}else {
					//안들어간거...
				}
				
				count++;
				if(count>UtilAboutCodeFind.findGeneralSubject(pDTO.getSubjectCode()).getCheckNum()) {
					ExData.finalEnrolementList.remove(UtilAboutCodeFind.changeF(
							UtilAboutCodeFind.findGeneralSubject(pDTO.getSubjectCode())));
				}
			}
			//이쪽으로 흐른다.
		}
		UtilAboutFile.finalEnrolementSave(ExData.finalEnrolementList);
	}
	
	/**
	 * 로그인한 특정 학생을 제외하고 다른 1000여명의 학생이 일제히 모의적으로 수강신청을 진행한다. 포인트도 지불하여 추후에있을 최종 수강신청의 결과전 메소드
	 */
	private void mockFinalEnrolement() {
		// 학생들이 해당과목에 대해 전체 포인트 신청!
		Iterator<InterestSubjectListDTO> iter = ExData.interestSubjectListSet.iterator();
		while (iter.hasNext()) {
			InterestSubjectListDTO iDTO = iter.next();
			if (iDTO.getStudentID().equals("12468925")) {// 여기에 학번입력하면 그학생만 신청제외.
				continue;
			}
			if (UtilAboutCodeFind.findMajorSubject(iDTO.getSubjectCode()) == null) {
				// 전공이 아니라면 -> 교양이라면...
				String studentID = iDTO.getStudentID();
				String subjectCode = iDTO.getSubjectCode();
				Random ran = new Random();
				// 최소포인트+ Alpha랜덤숫자
				int payPoint = ran.nextInt(100)
						+ UtilAboutSubject.interestSubjectApplyCount(subjectCode);
				ExData.pointUseList.add(new PointUseDTO(studentID, subjectCode, payPoint));
				UtilAboutFile.pointUseSave(ExData.pointUseList);
			} else {
				// 전공과목....
				// 신청
				if (!Enrolement.loginStudent.getStudentID().equals(iDTO.getStudentID())) {
					ExData.finalEnrolementList.add(new FinalEnrolementDTO(iDTO.getStudentID(), iDTO.getSubjectCode()));
					UtilAboutFile.finalEnrolementSave(ExData.finalEnrolementList);
				}
			}
		}

	}
	
	/**
	 * 학생들이 작성한 의견함에서 의견을 가져와 학생명, 학과명, 학년, 의견을 출력한다.
	 */
	public void studentOpinionCheck() {
		try {
			Iterator<OpinionDTO> iter = ExData.opinionList.iterator();
			while (iter.hasNext()) {
				OpinionDTO o = iter.next();
				String studentId = o.getStudentID();
				String deptCode = UtilAboutCodeFind.findStudent(studentId).getDeptCode();
				String studentName = UtilAboutCodeFind.findStudent(studentId).getStudentName();
				String deptName = UtilAboutCodeFind.findDepartment(deptCode).getDeptName();
				String grade = UtilAboutCodeFind.findStudent(studentId).getGrade();

				String result = String.format("\t[%s %s %s학년]\n\t%s\n", studentName, deptName, grade, o.getOpinion());
				System.out.println(result);
			}
		} catch (Exception e) {
			return;
		}
		

	}
	
	/**
	 * 관리자가 공지를 등록할수있게하는 메소드
	 */
	public void enroleNoticement() {
		System.out.print("공지사항 입력 : " + "");
		String notice = sc.nextLine();
		ExData.noticeList.add(new NoticeDTO(notice));
		UtilAboutFile.noticeSave(ExData.noticeList);
	}
	
	/**
	 * UI : 등록시작하는 UI
	 */
	public void enrolementStart() {
		System.out.println("\t1. [예비수강신청 서버오픈]");
		System.out.println("\t2. [수강신청 서버오픈]");
		System.out.println("\t3. [서버차단]");
		System.out.println("\t0. [뒤로가기]");
		System.out.print("입력 : ");
	}
	
	
	/**
	 * UI : 관리자 로그인하고나서 나타나는 UI
	 */
	public void adminLoginUI() {
		System.out.println("\t★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆\r\n" + "\t쌍용 대학교 수강신청 시스템(관리자)\r\n"
				+ "\t★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆\r\n\n");
		System.out.println("\t1. [학생 관리]");
		System.out.println("\t2. [교수 관리]");
		System.out.println("\t3. [수강과목 관리]");
		System.out.println("\t4. [강의실 관리]");
		System.out.println("\t5. [학과 관리]");
		System.out.println("\t6. [수강신청 서버관리]");
		System.out.println("\t7. [공지사항 작성|학생 의견함 확인]");
		System.out.println("\t8. [모의 예비수강신청|수강신청 종료]");
		System.out.println("\t9. [포인트 할당하기]");
		System.out.println("\t0. [로그아웃]");
		System.out.print("선택 : ");
	}
	
	/**
	 * 엔터를 입력해야 다음으로 넘어가는 메소드
	 */
	public void pause() {
		System.out.println("\t---------------------------");
		System.out.println("\t계속 진행하시려면 엔터를 눌러주세요...");
		System.out.println("\t---------------------------");
		sc.nextLine();
	}
}

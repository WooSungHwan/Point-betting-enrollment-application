package com.enrolement.Enrolement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import com.enrolement.DTO.FinalEnrolementDTO;
import com.enrolement.DTO.InterestSubjectListDTO;
import com.enrolement.DTO.MajorSubjectDTO;
import com.enrolement.DTO.NoticeDTO;
import com.enrolement.DTO.OpinionDTO;
import com.enrolement.DTO.PointUseDTO;
import com.enrolement.DTO.StudentDTO;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutCodeFind;
import com.enrolement.Util.UtilAboutFile;

/**
 * 학생이 로그인했을때 다뤄지는 기능을 모아놓은 클래스
 * @author 우성환
 *
 */
public class StudentSide {
	/**
	 * 스캐너 객체
	 */
	Scanner sc = new Scanner(System.in);
	/**
	 * 전공과목을 보관할 전공과목 리스트
	 */
	public static ArrayList<MajorSubjectDTO> mlist = new ArrayList<MajorSubjectDTO>(); // 해당 학생의 전공과목이 모두 들어있다.
	/**
	 * 생성자, 학생측 흐름을 나타낸다. 생성하면 학생 페이지의 메인페이지가 나타난다
	 */
	public StudentSide() {// 4
		listUp();
		while (true) {
			System.out.println(this.mainFormat());
			int sel = 0;
			try {
				sel = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("다시 입력해주세요..");
				continue;
			}
			// 메인페이지
			switch (sel) {
			case 0:
				return;
			case 1:
				// 예비수강신청
				if (Enrolement.enrolementServer1) {
					FirstEnrolement f = new FirstEnrolement();
					f.firstEnrolement();
				}else {
					System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("\t☆★예비수강신청 기간이 아니므로 접근할 수 없습니다☆★☆");
					System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					pause();
				}
				break;
			case 2:
				// 수강신청
				if(Enrolement.enrolementServer2) {
					FinalEnrolement fe = new FinalEnrolement();
					fe.doEnrolement();
				}else {
					System.out.println("\t☆★☆★☆★☆★☆★☆공지사항★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("\t☆★수강신청 기간이 아니므로 접근하실 수 없습니다.☆★");
					System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
					pause();
				}
				break;
			case 3: // 완료
				// 교과과목확인
				SubjectListCheck subList = new SubjectListCheck();
				break;
			case 4: //완료
				// 수강신청내역확인
				if(!Enrolement.enrolementServer2) {
					System.out.println("\t☆★☆★☆★☆★☆★☆공지사항★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("\t☆★수강신청 기간이 아니므로 접근하실 수 없습니다.☆★");
					System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
					pause();
				}else {//수강신청 기간.
					//수강내역 확인하기.
					System.out.printf("\t[%s님의 수강신청 내역]\n"
							,Enrolement.loginStudent.getStudentName());
					myFinalList();
					System.out.println();
					pause();
				}
				break;
			case 5:
				// 관심과목리스트
				ShowInterestSubjectList si = new ShowInterestSubjectList();
				System.out.println(si.showInterestSubject());
				pause();
				break;
			case 6: // 완료
				// 나의 포인트 확인
				System.out.println(String.format("『 %s님의 현재 포인트는 %s점 입니다』", Enrolement.loginStudent.getStudentName(),
						Enrolement.loginStudent.getHoldingPoint()));
				System.out.println("\t  [포인트사용내역]");
				Iterator<PointUseDTO> iter = ExData.pointUseList.iterator();
				StringBuilder sb = new StringBuilder("");
				while(iter.hasNext()) {
					PointUseDTO p = iter.next();
					if(p.getStudentID().equals(Enrolement.loginStudent.getStudentID())) {//로그인한놈과 모든 이터의 학번과비교
						//같은경우.. 즉 로그인한 학번의 학생의 포인트사용내역만 출력
						String subjectName = UtilAboutCodeFind.findGeneralSubject(p.getSubjectCode()).getSubjectName();
						int point = p.getUsePoint();
						sb.append(String.format("\t[%s : %sp]\n"
								,subjectName
								,point));
					}
				}
				System.out.println(sb);
				System.out.println();
				pause();
				break;
			case 7:
				// 공지사항
				System.out.println(notice()); // 확인필요함.
				pause();
				break;
			case 8:// 완료
					// 의견제출
				opinionTrans();
				System.out.println("소중한 의견 감사드립니다...");
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
		}
	}
	
	
	/**
	 * 로그인한 학생의 최종 수강신청 과목을 출력해주는 메소드
	 */
	public void myFinalList() {
		StudentDTO thisloginStudent = Enrolement.loginStudent;
		Iterator<FinalEnrolementDTO> iter = ExData.finalEnrolementList.iterator();
		while(iter.hasNext()) {
			FinalEnrolementDTO fDTO = iter.next();
			if(thisloginStudent.getStudentID().equals(fDTO.getStudentID())) {
				if (UtilAboutCodeFind.findGeneralSubject(fDTO.getSubjectCode()) == null) {
					//전공인경우
					System.out.printf("\t-%-10s\n"
							,UtilAboutCodeFind.findMajorSubject(fDTO.getSubjectCode()).getSubjectName());
				}
				else if (UtilAboutCodeFind.findMajorSubject(fDTO.getSubjectCode()) == null) {
					//교양인경우
					
					System.out.printf("\t-%-10s\n"
							,UtilAboutCodeFind.findGeneralSubject(fDTO.getSubjectCode()).getSubjectName());
				}
			}
		}
	}
	
	
	/**
	 * 로그인한 학생이 의견을 입력하면 의견객체를 생성하고 생성된 객체를 리스트에 저장, 파일에 저장하는 메소드
	 */
	public void opinionTrans() {
		System.out.print("의견입력 : ");
		sc.nextLine();
		String opinion = sc.nextLine();
		ExData.opinionList.add(new OpinionDTO(Enrolement.loginStudent.getStudentID(), opinion));
		UtilAboutFile.opinionSave(ExData.opinionList);
	}
	
	/**
	 * 학번을 파라미터로 전달하면 해당 학번학생의 관심과목 과목명을 가지는 리스트를 반환한다.
	 * @param studentId 학번
	 * @return ArrayList 관심과목 과목명 출력..
	 */
	public ArrayList<String> findMyInterestSubject(String studentId) {
		Iterator<InterestSubjectListDTO> iter = ExData.interestSubjectListSet.iterator();
		ArrayList<String> slist = new ArrayList<String>();
		while (iter.hasNext()) {
			InterestSubjectListDTO iDTO = iter.next();
			if (iDTO.getStudentID().equals(Enrolement.loginStudent.getStudentID())) {
				String subCode = iDTO.getSubjectCode();
				if (UtilAboutCodeFind.findMajorSubject(subCode) == null) { // 교양인 경우.
					slist.add(UtilAboutCodeFind.findGeneralSubject(subCode).getSubjectName());
				} else if (UtilAboutCodeFind.findGeneralSubject(subCode) == null) { // 전공인 경우
					slist.add(UtilAboutCodeFind.findMajorSubject(subCode).getSubjectName());
				} else {
					System.out.println("절대없음.");
				}
			}
		}
		return slist;
	}
	
	/**
	 * 로그인한 학생의 전공과목을 임시 전공list에 저장해주는 역할의 메소드
	 */
	public static void listUp() {// 해당 학생의 전공과목을 넣어주는 역할
		String grade = Enrolement.loginStudent.getGrade();
		String deptCode = Enrolement.loginStudent.getDeptCode();

		Iterator<MajorSubjectDTO> iter = ExData.majorSubjectList.iterator();
		while (iter.hasNext()) {
			MajorSubjectDTO m = iter.next();
			if (m.getGrade().equals(grade) && m.getDeptCode().equals(deptCode)) {
				mlist.add(m);
			}
		}
	}
	
	/**
	 * 공지사항을 리턴해주는 메소드
	 * @return 공지사항
	 */
	public String notice() {
		Iterator<NoticeDTO> iter = ExData.noticeList.iterator();
		StringBuilder sb = new StringBuilder("");
		while (iter.hasNext()) {
			String noticeResult = iter.next().getNotice();
			sb.append(noticeResult);
			sb.append("\n-------------------------------\n");
		}
		return sb.toString();
	}
	
	/**
	 * 메인 UI 화면을 리턴해주는 메소드
	 * @return 메인UI 
	 */
	public String mainFormat() {
		return String.format("\t★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆\r\n" + "\t쌍용 대학교 수강신청 시스템\r\n" + "\t★☆ ★☆ ★☆ ★☆ ★☆ ★☆ ★☆\r\n\n"
				+ "\t1. [예비수강신청]\n\t2. [수강신청]\n\t3. [교과과목확인]\n\t4."
				+ " [수강신청 내역확인]\n\t5. [나의 관심목록 확인]\n\t6. [나의 포인트 확인]\n\t7. "
				+ "[공지사항]\n\t8. [의견제출]\n\t0. [로그아웃]\n선택 : ");
	}
	/**
	 * 프로그램 실행중에 잠시 중단하기 위한 메소드
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

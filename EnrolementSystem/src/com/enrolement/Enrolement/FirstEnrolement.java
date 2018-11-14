package com.enrolement.Enrolement;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.enrolement.DTO.GeneralSubjectDTO;
import com.enrolement.DTO.InterestSubjectListDTO;
import com.enrolement.DTO.MajorSubjectDTO;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutCodeFind;
import com.enrolement.Util.UtilAboutFile;
import com.enrolement.Util.UtilAboutSubject;

/**
 * 예비수강신청 기능을 구현하는 클래스이다.
 * @author 우성환
 *
 */
public class FirstEnrolement {
	/**
	 * 스캐너 객체
	 */
	Scanner sc = new Scanner(System.in);

	/**
	 * 관심과목 임시저장 셋(중복제거)
	 */
	Set<InterestSubjectListDTO> ilist = new HashSet<InterestSubjectListDTO>();// 해당 학생의 관심과목 리스트이다.
	// 학생들의 교양목록은 다들 같기 때문에 ExData.GeneralSubject로 한다.
	/**
	 * 생성자, 예비수강신청의 흐름을 담당한다.
	 */
	public void firstEnrolement() {
		while (true) {
			this.firstEnrolementUI();
			String sel = sc.nextLine();
			if (sel.equals("1")) { // 전공신청하기
				while (true) {
					System.out.println("\t[전공과목 목록]");
					System.out.println("----------------------\n");
					System.out.println(showMajorSubject());
					System.out.println("----------------------");
					majorUI();
					String sel2 = sc.nextLine();
					if (sel2.equals("1")) {
						// 모두신청
						majorFirstEnrolementSaveOneTime();
						pause();
						return;
					} else if (sel2.equals("2")) {
						// 하나씩 신청
						System.out.println("신청이 완료되면 \"0\"을 입력해주세요.");
						majorFirstEnrolementSaveOneAndOne();
					} else if (sel2.equals("0")) { // 뒤로가기
						return;
					} else {
						System.out.println("잘못입력하셨습니다. 다시입력해주세요");
						continue;
					}
				}
			} else if (sel.equals("2")) {// 교양신청하기
				generalSubjectApply();
			} else if (sel.equals("3")) {// 예비수강 취소하기
				prepareEnrolementCancel();
			} else if (sel.equals("0")) { // 뒤로가기
				return;
			} else {
				System.out.println("다시입력해주세요...");
			}
		}
	}

	
	@SuppressWarnings("unlikely-arg-type")
	/**
	 * 현재 신청한 목록을 띄워주고 
	 * 삭제할 과목명을 입력하여
	 * 예비수강신청 취소기능을 하는 메소드
	 */
	private void prepareEnrolementCancel() {
		Iterator<InterestSubjectListDTO> iter = ExData.interestSubjectListSet.iterator();
		String result = "";
		while (iter.hasNext()) {
			InterestSubjectListDTO i = iter.next();
			if (i.getStudentID().equals(Enrolement.loginStudent.getStudentID())) {// 수강신청한 학생객체를 찾아서 과목출력.
				if (UtilAboutCodeFind.findGeneralSubject(i.getSubjectCode()) == null) {
					result += String.format("\t%s\n",
							UtilAboutCodeFind.findMajorSubject(i.getSubjectCode()).getSubjectName());
				} else if (UtilAboutCodeFind.findMajorSubject(i.getSubjectCode()) == null) {
					result += String.format("\t%s\n",
							UtilAboutCodeFind.findGeneralSubject(i.getSubjectCode()).getSubjectName());
				}

			}
		}
		System.out.println("\t<현재 신청한 목록>");
		System.out.println(result);

		String input = search();
		Iterator<InterestSubjectListDTO> iter2 = ExData.interestSubjectListSet.iterator();
		while (iter2.hasNext()) {
			InterestSubjectListDTO i = iter2.next();

			if (UtilAboutCodeFind.findMajorSubject(i.getSubjectCode()) == null) {
				//전공이 아닌경우.. 즉 교양
				if (input.equals(UtilAboutCodeFind.findGeneralSubject(i.getSubjectCode()).getSubjectName())) {
					ilist.remove(i);
					ExData.interestSubjectListSet.remove(i);
					System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("\t☆★과목이 삭제되었습니다.☆★");
					System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					UtilAboutFile.interestSubjectSave(ExData.interestSubjectListSet);
					return;
				}
			} else if (UtilAboutCodeFind.findGeneralSubject(i.getSubjectCode()) == null) {
				if (input.equals(UtilAboutCodeFind.findMajorSubject(i.getSubjectCode()).getSubjectName())) {
					StudentSide.mlist.remove(i);
					ExData.interestSubjectListSet.remove(i);
					System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("\t☆★과목이 삭제되었습니다.☆★");
					System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					UtilAboutFile.interestSubjectSave(ExData.interestSubjectListSet);
					return;
				}
			}
		}
		
	}

	// 리스트 출력 -> 과목명 입력 -> 객체인식 ->신청.
	/**
	 * 교양과목을 신청하는 메소드이다. 과목명을입력하여 교양과목을 입력해야한다
	 * 교양과목 입력시 정확한  과목명을 입력해야한다.
	 */
	private void generalSubjectApply() {
		String sublist = "";
		int count = 0;
		Iterator<GeneralSubjectDTO> iter = ExData.generalSubjectList.iterator();
		while (iter.hasNext()) {
			GeneralSubjectDTO g = iter.next();
			String subCode = UtilAboutCodeFind.findGeneralSubject(g.getSubjectCode()).getSubjectCode();
			sublist += String.format("\t%20s[%s//%s]\n", g.getSubjectName(),
					UtilAboutSubject.interestSubjectApplyCount(subCode), g.getCheckNum());
		}
		System.out.println(sublist); // 리스트 출력
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		System.out.println("☆★신청이 완료되면 \"0\"을 입력해주세요.☆★");
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		while (true) {
			count = 0;
			String subjectName = search(); // 입력.
			if (subjectName.equals("0")) {
				System.out.println("신청을 마칩니다.");
				break;
			}
			Iterator<GeneralSubjectDTO> iter2 = ExData.generalSubjectList.iterator();
			while (iter2.hasNext()) {
				GeneralSubjectDTO g = iter2.next();
				if (g.getSubjectName().equals(subjectName)) {// 같은 과목 발견...!!->신청
					if(!ExData.interestSubjectListSet.add(UtilAboutCodeFind.change(g))) {
						System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						System.out.println("\t이미 수강신청하신 과목입니다.");
						System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						break;
					}
					System.out.println("★☆신청하였습니다.★☆");
					continue;
				}
				count++;
			}
			if (count == ExData.generalSubjectList.size()) {
				System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
				System.out.println("★☆★☆★☆★☆★잘못입력하셨습니다★☆★☆★☆★☆");
				System.out.println("★☆정확한 과목명을 입력해주시기 바랍니다.★☆");
				System.out.println();
			}
			UtilAboutFile.interestSubjectSave(ExData.interestSubjectListSet);
		}

	}

	
	/**
	 * 전공과목 목록을 리스트로 표현해주는 메소드
	 * @return 전공과목 결과
	 */
	public static String showMajorSubject() { // 전공과목 목록을 리스트로 표현해주는 메소드

		String result = "";
		for (MajorSubjectDTO k : StudentSide.mlist) {
			result += String.format("\t-%-10s\t[%s/%s]\n", k.getSubjectName(),
					UtilAboutSubject.interestSubjectApplyCount(k.getSubjectCode()), k.getCheckNum());
		}
		return result;
	}
	/**
	 * 전공과목을 신청하는 UI를 구현하는 메소드
	 */
	private void majorUI() {
		System.out.println("\t1. [전과목 신청하기]");
		System.out.println("\t2. [하나씩 신청하기]");
		System.out.println("\t0. [뒤로가기]");
		System.out.print("선택 : ");
	}
	
	/**
	 * 전공과목을 한번에 신청하기 위한 메소드이다.
	 * 로그인한 학생의 전공과목이 모두 예비수강신청된다.
	 */
	private void majorFirstEnrolementSaveOneTime() {
		//전공한꺼번에 담기...
		Iterator<MajorSubjectDTO> iter = StudentSide.mlist.iterator();
		while (iter.hasNext()) {
			MajorSubjectDTO mDTO = iter.next();
			
			if (!ExData.interestSubjectListSet.add(UtilAboutCodeFind.change(mDTO))) {
				// 이미 들어있으면...
				System.out.printf("%s : 이미 신청하신 과목입니다.\n"
						,UtilAboutCodeFind.findMajorSubject(mDTO.getSubjectCode()).getSubjectName());
				continue;
			}			
		}
		// 파일,ExData에 저장하기!!
		System.out.println("☆★전과목 신청하였습니다.☆★");
		UtilAboutFile.interestSubjectSave(ExData.interestSubjectListSet);
	}
	
	/**
	 * 전공과목의 예비수강신청을 한과목씩 신청하는 메소드이다.
	 * 과목명을 정확히 입력하여 신청해야한다.
	 */
	public void majorFirstEnrolementSaveOneAndOne() {
		while (true) {
			int count = 0;
			String subjectName = search();
			if (subjectName.equals("0")) // 0이면 종료!
				break;
			for (int i = 0; i < StudentSide.mlist.size(); i++) {
				count = 0;
				MajorSubjectDTO m = StudentSide.mlist.get(i);
				if (m.getSubjectName().equals(subjectName)) { // 검색글자가 들어간 객체..
					if(!ExData.interestSubjectListSet.add(UtilAboutCodeFind.change(m))) {
						System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						System.out.println("\t이미 수강신청하신 과목입니다.");
						System.out.println("\t★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						continue;
					}
					System.out.println("★☆신청하였습니다.★☆");
					count++;
				}
			}
			if (count == StudentSide.mlist.size())
				System.out.println("잘못입력하셨습니다.정확한 과목명을 입력해주시기 바랍니다.");
		}
		UtilAboutFile.interestSubjectSave(ExData.interestSubjectListSet);
	}
	
	/**
	 * 검색을 통해 해단 과목을 검색한다.
	 * @return 검색어
	 */
	private String search() { // 검색을 통해 해당 과목의 객체를 반환한다.
		// 전공 리스트에서는 사라지고
		// 관심과목 리스트에 추가한다.
		System.out.print("과목명 : ");
		String searchWord = sc.nextLine();
		return searchWord;
	}
	/**
	 * 예비수강신청의  서브 UI를 담당하는 메소드이다.
	 */
	private void firstEnrolementUI() {
		System.out.println("\t1. [전공과목 신청하기]");
		System.out.println("\t2. [교양과목 신청하기]");
		System.out.println("\t3. [예비수강 삭제하기]");
		System.out.println("\t0. [뒤로가기]");
		System.out.println("\t--------------------");
		System.out.print("선택 : ");
	}
	/**
	 * 프로그램 흐름상 중단이 필요할때 호출하는 메소드이다.
	 */
	public void pause() {
		System.out.println("---------------------------");
		System.out.println("계속 진행하시려면 엔터를 눌러주세요...");
		System.out.println("---------------------------");
		sc.nextLine();
	}
}

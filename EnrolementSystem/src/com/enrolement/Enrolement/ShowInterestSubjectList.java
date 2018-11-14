package com.enrolement.Enrolement;

import java.util.Iterator;

import com.enrolement.DTO.InterestSubjectListDTO;
import com.enrolement.DTO.StudentDTO;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutCodeFind;
import com.enrolement.Util.UtilAboutSubject;

/**
 * 관심과목을 보여주는 기능을 소유하는 클래스
 * @author 우성환
 *
 */
public class ShowInterestSubjectList {
	/**
	 * 로그인한 학생의 객체를 멤버변수로 갖는다.
	 */
	StudentDTO s = Enrolement.loginStudent;

	/**
	 * 로그인한 학생의 관심과목 결과를 반환한다.
	 * @return 로그인한 학생의 관심과목 String
	 */
	public String showInterestSubject() {

		StudentDTO sDTO = Enrolement.loginStudent;
		StringBuilder sb = new StringBuilder("");
		Iterator<InterestSubjectListDTO> iter = ExData.interestSubjectListSet.iterator();
		while (iter.hasNext()) {
			InterestSubjectListDTO iDTO = iter.next();
			if (sDTO.getStudentID().equals(iDTO.getStudentID())) {
				// 학번이 같고
				if (UtilAboutCodeFind.findMajorSubject(iDTO.getSubjectCode()) == null) {
					// 전공이 아니다 -> 교양이다.
					sb.append(String.format("\t-%-20s\t[%s//%s]\t최소요구point : %sp\n",
							UtilAboutCodeFind.findGeneralSubject(iDTO.getSubjectCode()).getSubjectName(),
							UtilAboutSubject.interestSubjectApplyCount(iDTO.getSubjectCode()),
							UtilAboutCodeFind.findGeneralSubject(iDTO.getSubjectCode()).getCheckNum(),
							UtilAboutSubject.interestSubjectApplyCount(iDTO.getSubjectCode())));
				}
				else if (UtilAboutCodeFind.findGeneralSubject(iDTO.getSubjectCode()) == null) {
					// 전공인 경우..
					sb.append(String.format("\t-%-20s\t[%s//%s]\n",
							UtilAboutCodeFind.findMajorSubject(iDTO.getSubjectCode()).getSubjectName(),
							UtilAboutSubject.interestSubjectApplyCount(iDTO.getSubjectCode()),
							UtilAboutCodeFind.findMajorSubject(iDTO.getSubjectCode()).getCheckNum()));
				}
			}
		}
		return sb.toString();

		// ArrayList<String> list = new ArrayList<String>(); // 이학생이 신청한 과목코드를 저장할거임
		// Iterator<InterestSubjectListDTO> iter =
		// ExData.interestSubjectListSet.iterator();
		// while (iter.hasNext()) {
		// InterestSubjectListDTO i = iter.next();
		// // 교양과목만 찾아야함
		//
		// if (i.getStudentID().equals(s.getStudentID())) {// 로그인한학생의 학번과 관심목록에 있는 학번이
		// 같은 것.
		// // 여기서 해당 학번의 과목코드를 모두 저장.
		// list.add(i.getSubjectCode());// 이학생이 예비수강한 모든 과목의 코드르 저장.
		// }
		//
		// }
		// // 과목코드 찾았음...
		// ArrayList<String> result = new ArrayList<String>();
		// Iterator<String> i2 = list.iterator();
		//
		// while (i2.hasNext()) {
		// String code = i2.next();
		//
		//
		//
		// if (UtilAboutCodeFind.findGeneralSubject(code) == null) {
		// // 전공인경우
		// result.add(
		// String.format("\t-%-10s\t[%s//%s]\n",
		// UtilAboutCodeFind.findMajorSubject(code).getSubjectName(),
		// UtilAboutSubject.interestSubjectApplyCount(code),
		// UtilAboutCodeFind.findMajorSubject(code).getCheckNum()));
		// } else if (UtilAboutCodeFind.findMajorSubject(code) == null) {
		// // 교양인경우
		// String subjectName =
		// UtilAboutCodeFind.findGeneralSubject(code).getSubjectName();
		// int applyNum = UtilAboutSubject.interestSubjectApplyCount(code);
		// int checkNum = UtilAboutCodeFind.findGeneralSubject(code).getCheckNum();
		// result.add(String.format("\t-%-10s\t[%s//%s]\t최소요구point : %sp\n",
		// subjectName,
		// applyNum,
		// checkNum,
		// applyNum));
		// }
		// }
		// System.out.println("\t★☆관심과목 목록★☆");
		// for (String k : result) {
		// System.out.println(k);
		// }
	}
}

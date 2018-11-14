package com.enrolement.MockEnrolment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.enrolement.DTO.GeneralSubjectDTO;
import com.enrolement.DTO.InterestSubjectListDTO;
import com.enrolement.DTO.MajorSubjectDTO;
import com.enrolement.DTO.StudentDTO;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutFile;

/**
 * 
 * @author 우성환
 * 학생들의 모의로 수강신청하는 기능을 담은 클래스
 *
 */
public class MockEnrolement {
	// 학생들이 모의로 수강신청
	/**
	 * 랜덤객체
	 */
	Random ran;

	// 이터값으로 여기에 들어오면... 임의로 과목을 선택...(전공, 교양)
	/**
	 * Iterator를 이용해서 파라미터에 학생객체를 전달하면 해당학생이 임의로 수강신청을 진행한다.
	 * @param student 학생객체
	 */
	public void enrolement(StudentDTO student) {
		String grade = student.getGrade();
		String deptCode = student.getDeptCode();
		String studentName = student.getStudentName();
		String studentId = student.getStudentID();

		ArrayList<MajorSubjectDTO> mlist = new ArrayList<MajorSubjectDTO>();

		// 전공추출
		Iterator<MajorSubjectDTO> iter = ExData.majorSubjectList.iterator();
		while (iter.hasNext()) {
			MajorSubjectDTO mDTO = iter.next();
			if (grade.equals(mDTO.getGrade()) && deptCode.equals(mDTO.getDeptCode())) {
				// 학과코드와 학년이 같은 전공을 선택.
				mlist.add(mDTO);
			}
		}
		// 전공을 임의로 예비수강에 집어넣는것
		ran = new Random();
		for (int i = 0; i < mlist.size(); i++) {
			int num = ran.nextInt(3);
			if (num == 0 || num == 1) {// 신청X

			} else {// 신청O
				InterestSubjectListDTO iDTO = new InterestSubjectListDTO(studentId, mlist.get(i).getSubjectCode());
				ExData.interestSubjectListSet.add(iDTO);
			}
		}
		UtilAboutFile.interestSubjectSave(ExData.interestSubjectListSet); //전공저장완료
		// 교양배정
		
		Iterator<GeneralSubjectDTO> iter2 = ExData.generalSubjectList.iterator();
		while (iter2.hasNext()) {
			GeneralSubjectDTO gDTO = iter2.next();
			int num= ran.nextInt(13);
			if(num==0) {//신청 O
				InterestSubjectListDTO iDTO = new InterestSubjectListDTO(studentId, gDTO.getSubjectCode());
				ExData.interestSubjectListSet.add(iDTO);
			}else { //신청X
				
			}
		}
		UtilAboutFile.interestSubjectSave(ExData.interestSubjectListSet);//교양저장완료

	}//메소드
	

}//클래스

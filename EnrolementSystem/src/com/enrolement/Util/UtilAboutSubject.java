package com.enrolement.Util;

import java.util.Iterator;

import com.enrolement.DTO.FinalEnrolementDTO;
import com.enrolement.DTO.InterestSubjectListDTO;

/**
 * 관심과목과 최종과목의 신청자수를 반환하는 기능을 가지고 있는 클래스
 * @author 우성환
 *
 */
public class UtilAboutSubject {
	
	
	/**
	 * 과목코드를 파라미터에 전달하면 해당 과목을 예비수강신청한 학생들의 수를 리턴한다.
	 * @param subjectCode  과목코드
	 * @return 관심과목신청자 수
	 */
	public static int interestSubjectApplyCount(String subjectCode) {
		//관심과목의 코드를 넘겨주면 신청한 횟수를 반환.
		int count =0;	//현재는 1명의 학생만이 수강신청을 진행하므로 1만나올듯.
		Iterator<InterestSubjectListDTO> iter = ExData.interestSubjectListSet.iterator();
		while(iter.hasNext()) {
			InterestSubjectListDTO i = iter.next();
			if(i.getSubjectCode().equals(subjectCode)) {//매개변수 과목코드와 같으면...
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 과목코드를 파라미터에 전달하면 해당 과목을 수강신청한 학생들의 수를 리턴한다.
	 * @param subjectCode 과목코드
	 * @return 최종과목 수강신청자수
	 */
	public static int finalSubjectApplyCount(String subjectCode) {//최종신청과목의 코드를 넘겨주면 신청한 횟수를 반환.
		int count =0;										//현재는 1명의 학생만이 수강신청을 진행하므로 1만나올듯.
		Iterator<FinalEnrolementDTO> iter = ExData.finalEnrolementList.iterator();
		while(iter.hasNext()) {
			FinalEnrolementDTO f = iter.next();
			if(f.getSubjectCode().equals(subjectCode)) {//매개변수 과목코드와 같으면...
				count++;
			}
		}
		return count;
	}
	
	
	
}

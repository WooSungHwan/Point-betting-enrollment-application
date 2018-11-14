package com.enrolement.Util;

import java.util.Iterator;

import com.enrolement.DTO.ClassroomDTO;
import com.enrolement.DTO.DepartmentDTO;
import com.enrolement.DTO.FinalEnrolementDTO;
import com.enrolement.DTO.GeneralSubjectDTO;
import com.enrolement.DTO.InterestSubjectListDTO;
import com.enrolement.DTO.MajorSubjectDTO;
import com.enrolement.DTO.ProfessorDTO;
import com.enrolement.DTO.StudentDTO;
import com.enrolement.Enrolement.Enrolement;

/**
 * 코드를 통해서 해당 코드가 가지는 객체를 반환하기 위한 기능을 소유한 클래스
 * @author 우성환
 *
 */
public class UtilAboutCodeFind {
	/**
	 * 학생객체를 처리하기 위한 변수
	 */
	private static StudentDTO student;
	/**
	 * 교수객체를 처리하기 위한 변수
	 */
	private static ProfessorDTO professor;
	/**
	 * 강의실 객체를 처리하기 위한 변수
	 */
	private static ClassroomDTO classroom;
	/**
	 * 학과객체를 처리하기 위한 변수
	 */
	private static DepartmentDTO department;
	/**
	 * 교양과목 객체를 처리하기 위한 변수
	 */
	private static GeneralSubjectDTO generalSubject;
	/**
	 * 전공과목 객체를 처리하기 위한 변수
	 */
	private static MajorSubjectDTO majorSubject;
	/**
	 * 관심과목 객체를 처리하기 위한 변수
	 */
	private static InterestSubjectListDTO interestSubject;
	
	
	/**
	 * 학생의 학번을 넣으면 학생파일을 찾아서 해당 학생의 객체를 리턴, 없으면 null
	 * @param studentId 학생의 학번
	 * @return StudentDTO객체 반환, null
	 */
	public static StudentDTO findStudent(String studentId) {
		Iterator<StudentDTO> iter = ExData.studentList.iterator();
		while (iter.hasNext()) {
			StudentDTO thisStudent = iter.next();
			if (thisStudent.getStudentID().equals(studentId)) {
				student = thisStudent;
				return student;
			}
		}
		return null;
	}
	
	/**
	 * 파라미터에 교수 코드를 넣으면 해당 교수 객체가 반환됨. 없으면 null 
	 * @param professorCode 교수코드
	 * @return 교수객체, null
	 */
	public static ProfessorDTO findProfessor(String professorCode) {
		Iterator<ProfessorDTO> iter = ExData.professorList.iterator();
		while (iter.hasNext()) {
			ProfessorDTO thisProfessor = iter.next(); // 해당교수객체 반환
			if (thisProfessor.getProfessorCode().equals(professorCode)) {
				professor = thisProfessor;
				return professor;
			}
		}
		return null;
	}
	/**
	 * 강의실 호수를 파라미터로 전달하면 강의실 객체를 반환하는 메소드
	 * @param classnum 강의실 호수
	 * @return 강의실 객체, null
	 */
	public static ClassroomDTO findClassroom(String classnum) {
		Iterator<ClassroomDTO> iter = ExData.classroomList.iterator();
		while (iter.hasNext()) {
			ClassroomDTO thisclassroom = iter.next();
			if (thisclassroom.getClassNum().equals(classnum)) {
				classroom = thisclassroom;
				return classroom;
			}
		}
		return null;
	}
	/**
	 * 학과코드를 파라미터로 전달하면 해당하는 학과 객체를 반환하는 메소드
	 * @param deptCode 학과코드
	 * @return 학과객체, null
	 */
	public static DepartmentDTO findDepartment(String deptCode) {
		Iterator<DepartmentDTO> iter = ExData.departmentList.iterator();
		while (iter.hasNext()) {
			DepartmentDTO thisDepartment = iter.next();
			if (thisDepartment.getDeptNumber().equals(deptCode)) {
				department = thisDepartment;
				return department;
			}
		}
		return null;
	}
	
	/**
	 * 과목코드를 파라미터로 전달하면 교양객체를 반환해주는 메소드
	 * @param subjectCode 과목코드
	 * @return 교양과목객체, null
	 */
	public static GeneralSubjectDTO findGeneralSubject(String subjectCode) {
		Iterator<GeneralSubjectDTO> iter = ExData.generalSubjectList.iterator();
		while (iter.hasNext()) {
			GeneralSubjectDTO thisGeneralSubject = iter.next();
			if (thisGeneralSubject.getSubjectCode().equals(subjectCode)) {
				generalSubject = thisGeneralSubject;
				return generalSubject;
			}
		}
		return null;
	}
	/**
	 * 과목코드를 파라미터로 전달하면 전공과목 객체를 반환하는 메소드
	 * @param subjectCode 과목코드 
	 * @return 전공과목 객체, null
	 */
	public static MajorSubjectDTO findMajorSubject(String subjectCode) {
		Iterator<MajorSubjectDTO> iter = ExData.majorSubjectList.iterator();
		while (iter.hasNext()) {
			MajorSubjectDTO thisMajorSubject = iter.next();
			if (thisMajorSubject.getSubjectCode().equals(subjectCode)) {
				majorSubject = thisMajorSubject;
				return majorSubject;
			}
		}
		return null;
	}
	/**
	 * 과목 코드를 파라미터로 전달하면 관심과목객체를 반환하는 메소드
	 * @param subjectCode 과목코드
	 * @return 관심과목 객체, null
	 */
	public static InterestSubjectListDTO findInterestSubject(String subjectCode) {
		Iterator<InterestSubjectListDTO> iter = ExData.interestSubjectListSet.iterator();
		while (iter.hasNext()) {
			InterestSubjectListDTO thisInterestSubject = iter.next();
			if (Enrolement.loginStudent.getStudentID().equals(thisInterestSubject.getStudentID())) {//로그인 객체의 학번. 
				if (UtilAboutCodeFind.findGeneralSubject(thisInterestSubject.getSubjectCode()) == null) {
					// 교양과목이 아니면 -> 전공과목일때
					interestSubject = thisInterestSubject;
					return interestSubject;
				} else if (UtilAboutCodeFind.findMajorSubject(thisInterestSubject.getSubjectCode()) == null) {
					// 전공과목이 아닌경우 -> 교양과목인 경우.
					interestSubject = thisInterestSubject;
					return interestSubject;
				}
			}
		}

		return null;
	}

	

//	public static InterestSubjectListDTO findInterstSubjectName(String studentId) {
//		Iterator<InterestSubjectListDTO> iter = ExData.interestSubjectListSet.iterator();
//		
//		while (iter.hasNext()) {
//			InterestSubjectListDTO thisInterestSubject = iter.next();
//			if (thisInterestSubject.getStudentID().equals(studentId)) {
//				interestSubject = thisInterestSubject;
//				return interestSubject;
//			}
//		}
//		return null;
//	}
	/**
	 * 전공과목 객체를 파라미터로 전달하면 관심과목 객체로 변환하여주는 메소드
	 * @param m 전공과목 객체
	 * @return 관심과목 객체
	 */
	public static InterestSubjectListDTO change(MajorSubjectDTO m) {
		String studentId = Enrolement.loginStudent.getStudentID();
		String subjectCode = m.getSubjectCode();

		InterestSubjectListDTO iDTO = new InterestSubjectListDTO(studentId, subjectCode);

		return iDTO;
	}
	/**
	 * 교양과목 객체를 파라미터로 전달하면 관심과목 객체로 변환하여주는 메소드
	 * @param g 교양과목 객체
	 * @return 관심과목 객체
	 */
	public static InterestSubjectListDTO change(GeneralSubjectDTO g) {
		String studentId = Enrolement.loginStudent.getStudentID();
		String subjectCode = g.getSubjectCode();

		InterestSubjectListDTO iDTO = new InterestSubjectListDTO(studentId, subjectCode);

		return iDTO;
	}
	
	/**
	 * 교양과목 객체를 파라미터로 전달하면 최종 과목 객체로 변환하여주는 메소드
	 * @param g 교양과목 객체
	 * @return 최종과목객체
	 */
	
	public static FinalEnrolementDTO changeF(GeneralSubjectDTO g) {
		String studentId = Enrolement.loginStudent.getStudentID();
		String subjectCode = g.getSubjectCode();

		FinalEnrolementDTO fDTO = new FinalEnrolementDTO(studentId, subjectCode);

		return fDTO;
	}
	/**
	 * 교양과목 객체를 파라미터로 전달하면 최종 과목객체로 변환하여주는 메소드
	 * @param g 전공과목 객체
	 * @return 최종과목 객체
	 */
	public static FinalEnrolementDTO changeF(MajorSubjectDTO g) {
		String studentId = Enrolement.loginStudent.getStudentID();
		String subjectCode = g.getSubjectCode();

		FinalEnrolementDTO fDTO = new FinalEnrolementDTO(studentId, subjectCode);

		return fDTO;
	}
	/**
	 * 관심과목 객체를 파라미터로 전달하면 최종과목 객체로 변환하여주는 메소드
	 * @param i 관심과목객체
	 * @return 최종과목 객체
	 */
	public static FinalEnrolementDTO changeF(InterestSubjectListDTO i) {
		String studentId = Enrolement.loginStudent.getStudentID();
		String subjectCode = i.getSubjectCode();

		FinalEnrolementDTO fDTO = new FinalEnrolementDTO(studentId, subjectCode);

		return fDTO;
	}

}

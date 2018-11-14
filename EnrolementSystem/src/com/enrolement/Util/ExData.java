package com.enrolement.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.enrolement.DTO.AdminLoginDTO;
import com.enrolement.DTO.ClassroomDTO;
import com.enrolement.DTO.ClassroomTimeDTO;
import com.enrolement.DTO.DepartmentDTO;
import com.enrolement.DTO.FinalEnrolementDTO;
import com.enrolement.DTO.GeneralSubjectDTO;
import com.enrolement.DTO.InterestSubjectListDTO;
import com.enrolement.DTO.MajorSubjectDTO;
import com.enrolement.DTO.NoticeDTO;
import com.enrolement.DTO.OpinionDTO;
import com.enrolement.DTO.PointUseDTO;
import com.enrolement.DTO.PreviousSemesterDTO;
import com.enrolement.DTO.ProfessorDTO;
import com.enrolement.DTO.SemesterManagementDTO;
import com.enrolement.DTO.StudentDTO;
import com.enrolement.DTO.StudentLoginDTO;
/**
 * 외부데이터의 자료를 포함하고있는 클래스.
 * @author 우성환
 *
 */
public class ExData {
	/**
	 * 교수파일에서 얻어온 ProfessorDTO객체를 저장할 리스트
	 */
	public static List<ProfessorDTO> professorList;
	/**
	 * 학생파일에서 얻어온 StudentDTO객체를 저장할 리스트
	 */
	public static List<StudentDTO> studentList;
	/**
	 * 학과파일에서 얻어온 DepartmentDTO 객체를 저장할 리스트
	 */
	public static List<DepartmentDTO> departmentList;
	/**
	 * 교양과목파일에서 얻어온 GeneralSubjectDTO 객체를 저장할 리스트
	 */
	public static List<GeneralSubjectDTO> generalSubjectList;
	/**
	 * 전공과목 파일에서 얻어온 MajorSubjectDTO 객체를 저장할 리스트
	 */
	public static List<MajorSubjectDTO> majorSubjectList;
	/**
	 * 강의실 파일에서 얻어온 ClassroomDTO 객체를 저장할 리스트
	 */
	public static List<ClassroomDTO> classroomList;
	/**
	 * 이전학기성적 파일에서 얻어온 PreviousSemesterDTO 객체를 저장할 리스트
	 */
	public static List<PreviousSemesterDTO> previousSemesterList;
	/**
	 * 관심과목 파일에서 얻어은 InterestSubjectListDTO 객체를 저장할 셋
	 */
	public static Set<InterestSubjectListDTO> interestSubjectListSet;
	/**
	 * 강의실강의시간파일에서 얻어온 ClassroomTimeDTO 객체를 저장할 리스트
	 */
	public static List<ClassroomTimeDTO> classroomTimeList;
	/**
	 * 의견게시판 파일에서 얻어온 OpinionDTO객체를 저장할 리스트
	 */
	public static List<OpinionDTO> opinionList;
	/**
	 * 공지사항 파일에서 얻어온 NoticeDTO 객체를 저장할 리스트
	 */
	public static List<NoticeDTO> noticeList;
	/**
	 * 최종수강신청 파일에서 얻어온 FinalEnrolementDTO 객체를 저장할 셋
	 */
	public static Set<FinalEnrolementDTO> finalEnrolementList;
	/**
	 * 학과관리파일에서 얻어온 SemesterManagementDTO객체를 저장할 리스트
	 */
	public static List<SemesterManagementDTO> semesterManagementList;
	/**
	 * 학생로그인 파일에서 얻어온 StudentLoginDTO 객체를 저장할 리스트
	 */
	public static List<StudentLoginDTO> studentLoginList;
	/**
	 * 관리자로그인 파일에서 얻어온 AdminLoginDTO 객체를 저장할 리스트
	 */
	public static List<AdminLoginDTO> adminLoginList;
	/**
	 * 포인트사용목록 파일에서 얻어온 PointUseDTO 객체를 저장할 리스트
	 */
	public static List<PointUseDTO> pointUseList = new ArrayList<PointUseDTO>();
	
	/**
	 * professorList getter메소드
	 * @return professorList
	 */
	public static List<ProfessorDTO> getProfessorList() {
		return professorList;
	}
	/**
	 * studentList getter 메소드
	 * @return studentList
	 */
	public static List<StudentDTO> getStudentList() {
		return studentList;
	}
	/**
	 * departmentList getter 메소드
	 * @return departmentList
	 */
	public static List<DepartmentDTO> getDepartmentList() {
		return departmentList;
	}
	/**
	 * generalSubjectList getter 메소드
	 * @return generalSubjectList
	 */
	public static List<GeneralSubjectDTO> getGeneralSubjectList() {
		return generalSubjectList;
	}
	/**
	 * majorSubjectList getter 메소드
	 * @return majorSubjectList
	 */
	public static List<MajorSubjectDTO> getMajorSubjectList() {
		return majorSubjectList;
	}
	/**
	 * classroomList getter메소드
	 * @return classroomList
	 */
	public static List<ClassroomDTO> getClassroomList() {
		return classroomList;
	}
	/**
	 * previousSemesterList getter 메소드
	 * @return previousSemesterList
	 */
	public static List<PreviousSemesterDTO> getPreviousSemesterList() {
		return previousSemesterList;
	}
	/**
	 * interestSubjectListSet getter 메소드
	 * @return interestSubjectListSet
	 */
	public static Set<InterestSubjectListDTO> getInterestSubjectListList() {
		return interestSubjectListSet;
	}
	/**
	 * classroomTimeList getter 메소드
	 * @return classroomTimeList
	 */
	public static List<ClassroomTimeDTO> getClassroomTimeList() {
		return classroomTimeList;
	}
	/**
	 * opinionList getter 메소드
	 * @return opinionList
	 */
	public static List<OpinionDTO> getOpinionList() {
		return opinionList;
	}
	/**
	 * noticeList getter 메소드
	 * @return noticeList
	 */
	public static List<NoticeDTO> getNoticeList() {
		return noticeList;
	}
	/**
	 * finalEnrolementList getter 메소드
	 * @return finalEnrolementList
	 */
	public static Set<FinalEnrolementDTO> getFinalEnrolementList() {
		return finalEnrolementList;
	}
	/**
	 * semesterManagementList getter 메소드
	 * @return semesterManagementList
	 */
	public static List<SemesterManagementDTO> getSemesterManagementList() {
		return semesterManagementList;
	}
	/**
	 * studentLoginList getter 메소드
	 * @return studentLoginList
	 */
	public static List<StudentLoginDTO> getStudentLoginList() {
		return studentLoginList;
	}
	/**
	 * adminLoginList getter 메소드
	 * @return adminLoginList
	 */
	public static List<AdminLoginDTO> getAdminLoginList() {
		return adminLoginList;
	}
}

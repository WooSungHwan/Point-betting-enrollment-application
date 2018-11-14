package com.enrolement.DTO;

/**
 * 최종과목의 정보를 가지고 있는 데이터 클래스
 * @author 우성환
 *
 */
public class FinalEnrolementDTO{
	/**
	 * 학번
	 */
	private String studentID;
	/**
	 * 과목코드
	 */
	private String subjectCode;


	/**
	 * 학번,과목코드 초기화 생성자
	 * @param studentID 학번
	 * @param subjectCode 과목코드
	 */
	public FinalEnrolementDTO(String studentID, String subjectCode) {
		super();
		this.studentID = studentID;
		this.subjectCode = subjectCode;
	}
	/**
	 * 학번 getter 메소드
	 * @return 학번
	 */
	public String getStudentID() {
		return studentID;
	}
	
	/**
	 * 학번 setter 메소드
	 * @param studentID 학번
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	/**
	 * 과목코드 getter 메소드
	 * @return 과목코드
	 */
	public String getSubjectCode() {
		return subjectCode;
	}
	
	/**
	 * 과목코드 setter메소드
	 * @param subjectCode 과목코드
	 */
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	@Override
	/**
	 * toString 오버라이딩 메소드
	 */
	public String toString() {
		return String.format("학번:%s\n,과목코드:%s\n",this.getStudentID(),this.getSubjectCode());
	}
	/**
	 * 저장포맷  반홤 메소드
	 * @return 저장포맷
	 */
	public String saveFormat() {
		return String.format("%s,%s"
				,this.getStudentID()
				,this.getSubjectCode());
	}
	
	@Override
	/**
	 * equals 오버라이딩 메소드
	 */
	public boolean equals(Object obj) {
		if(obj instanceof FinalEnrolementDTO) {
			FinalEnrolementDTO f = (FinalEnrolementDTO)obj;
			return this.hashCode()==f.hashCode();
		}
		return false;
	}
	@Override
	/**
	 * hashCode오버라이딩 메소드
	 */
	public int hashCode() {
		return (this.studentID+this.subjectCode).hashCode();
	}

}

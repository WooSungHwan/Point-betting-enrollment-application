package com.enrolement.DTO;

/**
 * 포인트 사용내역을 가지고 있는 클래스
 * @author 우성환
 *
 */
public class PointUseDTO implements Comparable<PointUseDTO>{
	/**
	 * 학번
	 */
	private String studentID;
	/**
	 * 과목코드
	 */
	private String subjectCode;
	/**
	 * 사용포인트
	 */
	private int usePoint;
	
	/**
	 * 학번 getter 메소드
	 * @return 학번
	 */
	public String getStudentID() {
		return studentID;
	}
	
	/**
	 * 학번 setter메소드
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
	 * 과목코드 getter 메소드
	 * @param subjectCode 과목코드
	 */
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	/**
	 *  사용포인트 getter 메소드
	 * @return 사용포인트
	 */
	public int getUsePoint() {
		return usePoint;
	}
	/**
	 * 사용포인트 setter 메소드
	 * @param usePoint 사용포인트
	 */
	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}
	
	/**
	 * 학번,과목코드,사용포인트 초기화 생성자
	 * @param studentID 학번
	 * @param subjectCode 과목코드
	 * @param usePoint 사용포인트
	 */
	public PointUseDTO(String studentID, String subjectCode, int usePoint) {
		super();
		this.studentID = studentID;
		this.subjectCode = subjectCode;
		this.usePoint = usePoint;
	}
	/**
	 * 저장포맷
	 * @return 저장할 포맷
	 */
	public String saveFormat() {
		return String.format("%s,%s,%s"
				,this.getStudentID()
				,this.getSubjectCode()
				,this.getUsePoint()
				);
	}

	@Override
	/**
	 * compareTo 오버라이딩 메소드 내림차순.
	 */
	public int compareTo(PointUseDTO o) {
		return o.usePoint-this.usePoint;
	}
}


package com.enrolement.DTO;

public class ProfessorDTO {
	/**
	 * 교수코드
	 */
	private String professorCode;
	/**
	 * 학과코드
	 */
	private String deptCode;
	/**
	 * 교수이름
	 */
	private String professorName;
	/**
	 * 나이
	 */
	private String age;
	/**
	 * 핸드폰번호
	 */
	private String phoneNumber;
	/**
	 * 연구소
	 */
	private String studyroom;
	
	public ProfessorDTO() {
		
	}
	/**
	 * 입력받은 정보로 교수객체 생성메소드
	 * @param professorCode 교수코드
	 * @param professorName 교수이름
	 * @param deptCode	학과코드
	 * @param phoneNumber 핸드폰번호
	 * @param age 나이
	 * @param studyroom 연구소
	 */
	public ProfessorDTO(String professorCode, String professorName, String deptCode, String phoneNumber,String age,
			String studyroom) {
		this.professorCode = professorCode;
		this.deptCode = deptCode;
		this.professorName = professorName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.studyroom = studyroom;
	}
/**
 * 교수코드 getter메소드
 * @return  교수코드
 */
	public String getProfessorCode() {
		return professorCode;
	}
	/**
	 * 교수코드 setter메소드
	 * @param professorCode 교수코드
	 */
	public void setProfessorCode(String professorCode) {
		this.professorCode = professorCode;
	}
	
	/**
	 * 학과코드 getter메소드
	 * @return  학과코드
	 */
	public String getDeptCode() {
		return deptCode;
	}
	/**
	 * 학과코드 setter메소드
	 * @param deptCode 학과코드
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	/**
	 * 교수이름 getter메소드
	 * @return  교수이름
	 */
	public String getProfessorName() {
		return professorName;
	}
	/**
	 * 교수이름 setter메소드
	 * @param professorName 교수이름
	 */
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	/**
	 * 교수나이 getter메소드
	 * @return 교수나이
	 */
	public String getAge() {
		return age;
	}
	/**
	 * 교수나이 setter메소드
	 * @param age 교수나이
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * 교수연락처 getter메소드
	 * @return 교수연락처
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 교수연락처 setter메소드 
	 * @param phoneNumber 교수연락처
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * 연구소 getter메소드
	 * @return 연구소
	 */
	public String getStudyroom() {
		return studyroom;
	}
	/**
	 * 연구소 setter메소드
	 * @param studyroom 연구소
	 */
	public void setStudyroom(String studyroom) {
		this.studyroom = studyroom;
	}
	
	
	@Override
	/**
	 * 교수정보 출력
	 */
	public String toString() {
		
		return String.format("교수코드:%s\n교수명:%s\n학과코드:%s\n전화번호:%s\n나이:%s\n연구실:%s\n"
				,this.getProfessorCode()
				,this.getProfessorName()
				,this.getDeptCode()
				,this.getPhoneNumber()
				,this.getAge()
				,this.getStudyroom());
	}
	
	/**
	 * 교수정보 저장
	 * @return 교수정보 저장
	 */
	public String saveFormat() {
		return String.format("%s,%s,%s,%s,%s,%s"
				,this.getProfessorCode()
				,this.getProfessorName()
				,this.getDeptCode()
				,this.getPhoneNumber()
				,this.getAge()
				,this.getStudyroom());
	}

}

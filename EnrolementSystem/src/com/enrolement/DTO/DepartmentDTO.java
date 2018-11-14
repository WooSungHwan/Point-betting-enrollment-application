package com.enrolement.DTO;

/**
 * 학과정보 데이터를 가지는 데이터 클래스
 * @author 우성환
 *
 */
public class DepartmentDTO {
	/**
	 * 학과코드
	 */
	private String deptNumber;
	/**
	 * 학과명
	 */
	private String deptName;
	/**
	 * 학과위치
	 */
	private String location;

	/**
	 * 학과코드,학과명,학과위치 초기화 생성자
	 * @param deptNumber 학과코드
	 * @param deptName 학과명
	 * @param location 학과위치
	 */
	public DepartmentDTO(String deptNumber, String deptName, String location) {
		super();
		this.deptNumber = deptNumber;
		this.deptName = deptName;
		this.location = location;
	}

	/**
	 * 학과코드 getter메소드
	 * @return deptNumber
	 */
	public String getDeptNumber() {
		return deptNumber;
	}
	/**
	 * 학과코드 setter메소드
	 * @param deptNumber 학과코드
	 */
	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}
	/**
	 * 학과명  getter메소드
	 * @return 학과명
	 */
	public String getDeptName() {
		return deptName;
	}
	
	/**
	 * 학과명 setter메소드
	 * @param deptName 학과명
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 학과 위치 getter메소드
	 * @return 학과위치
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 학과위치setter메소드
	 * @param location 학과위치
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * toString 오버라이딩 메소드
	 */
	@Override
	public String toString() {
		return String.format("학과코드:%s\n학과명:%s\n위치:%s\n", this.getDeptNumber(), this.getDeptName(), this.getLocation());
	}
	/**
	 * 저장포맷 메소드
	 * @return 저장포맷.
	 */
	public String saveFormat() {
		return String.format("%s,%s,%s",this.getDeptNumber(), this.getDeptName(), this.getLocation());
	}
}

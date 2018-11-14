package com.enrolement.DTO;

public class SemesterManagementDTO {
	/**
	 * 학기
	 */
	private String semester;
	


	/**
	 * 학기 getter 메소드
	 * @return 학기
	 */
	public String getSemester() {
		return semester;
	}
	
	/**
	 * 학기 setter 메소드 
	 * @param semester 학기
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}
	/**
	 * 학기 초기화 생성자
	 * @param semester 학기
	 */
	public SemesterManagementDTO(String semester) {
		super();
		this.semester = semester;
	}

	@Override
	/**
	 * toString 오버라이딩 메소드
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

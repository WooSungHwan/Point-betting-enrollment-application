package com.enrolement.DTO;

/**
 * 강의실 정보를 가지는 강의실 데이터 클래스
 * @author 우성환
 *
 */
public class ClassroomDTO {
	/**
	 * 강의실 호수 
	 */
	private String classNum;
	/**
	 * 과목코드
	 */
	private String deptCode;
	/**
	 * 강의실 수용인원
	 */
	private String capacity;

	public ClassroomDTO() {

	}
	
	/**
	 * 생성자 초기화
	 * @param classNum 강의실호수
	 * @param deptCode 학과코드
	 * @param capacity 수용인원
	 */
	public ClassroomDTO(String classNum, String deptCode, String capacity) {
		super();
		this.classNum = classNum;
		this.deptCode = deptCode;
		this.capacity = capacity;
		
	}
	/**
	 * 강의실호수 getter메소드
	 * @return classNum
	 */
	public String getClassNum() {
		return classNum;
	}
	/**
	 * classNum setter메소드
	 * @param classNum 강의실 호수
	 */
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	/**
	 * deptCode getter메소드
	 * @return deptCode
	 */
	public String getDeptCode() {
		return deptCode;
	}
	/**
	 * deptCode setter메소드
	 * @param deptCode 학과코드
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	/**
	 * capacity getter메소드
	 * @return capacity
	 */
	public String getCapacity() {
		return capacity;
	}
	/**
	 * capacity setter메소드
	 * @param capacity 수용인원
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * toString()오버라이딩 메소드
	 */
	@Override
	public String toString() {
		return String.format("강의실호수:%s\n소속학과:%s\n수용인원:%s\n"
				, this.getClassNum()
				,this.getDeptCode()
				,this.getCapacity());
	}
	/**
	 * 파일에 저장할 포맷리턴
	 * @return 저장포맷
	 */
	public String saveFormat() {
		return String.format("%s,%s,%s"
				, this.getClassNum()
				,this.getDeptCode()
				,this.getCapacity());
	}

}

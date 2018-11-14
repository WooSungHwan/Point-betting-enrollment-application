package com.enrolement.DTO;

/**
 * 강의실강의시간과 관련된 데이터를 가지는 데이터 클래스
 * @author 김태호
 *
 */
public class ClassroomTimeDTO {
	/**
	 * 강의실호수
	 */
	private String classNum;
	/**
	 * 강의시간
	 */
	private String scheduleTime;

	ClassroomTimeDTO() {

	}
	
	/**
	 * 강의실 호수, 강의시간 초기화 생성자
	 * @param classNum 강의실호수
	 * @param scheduleTime 강의시간
	 */
	public ClassroomTimeDTO(String classNum, String scheduleTime) {
		super();
		this.classNum = classNum;
		this.scheduleTime = scheduleTime;
		
	}
	/**
	 * 강의실호수 getter메소드
	 * @return classNum
	 */
	public String getClassNum() {
		return classNum;
	}
	/**
	 * 강의실 호수 setter메소드
	 * @param classNum 강의실호수
	 */
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	/**
	 * 강의스케줄 getter메소드
	 * @return scheduleTime
	 */
	public String getScheduleTime() {
		return scheduleTime;
	}
	/**
	 * scheduleTime setter메소드
	 * @param scheduleTime 강의시간
	 */
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	/**
	 * toString 오버라이딩 메소드
	 */
	@Override
	public String toString() {
		return String.format("강의실호수:%s\n강의시간:%s\n"
				,this.getClassNum()
				,this.getScheduleTime());
	}
	/**
	 * 저장포맷을 리턴하는 메소드
	 * @return 저장포맷
	 */
	public String saveFormat() {
		return String.format("%s,%s"
				,this.getClassNum()
				,this.getScheduleTime());
	}

}

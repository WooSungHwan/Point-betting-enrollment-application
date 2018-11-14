package com.enrolement.DTO;

public class PreviousSemesterDTO {
	/**
	 * 학번
	 */
	private String studentID;
	/**
	 * 학년
	 */
	private String grade;
	/**
	 * 학기
	 */
	private String semester;
	/**
	 * 성적
	 */
	private double lastTotalScore;
	
	public PreviousSemesterDTO() {
		
	}
	
	/**
	 * 학번, 학년, 학기, 지난학기성적 초기화 생성자
	 * @param studentID 학번
	 * @param grade 학년
	 * @param semester 학기
	 * @param lastTotalScore 이전학기성적
	 */
	public PreviousSemesterDTO(String studentID, String grade, String semester, double lastTotalScore) {
		super();
		this.studentID = studentID;
		this.grade = grade;
		this.semester = semester;
		this.lastTotalScore = lastTotalScore;
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
	 * 학년
	 * @return 학년
	 */
	public String getGrade() {
		return grade;
	}
	
	/**
	 * 학년 setter
	 * @param grade 학년
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
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
	 * 지난학기성적 getter 메소드
	 * @return 지난갛기 성적 메소드
	 */
	public double getLastTotalScore() {
		return lastTotalScore;
	}
	
	/**
	 * 지난학기성적 setter 메소드
	 * @param lastTotalScore 지난성적
	 */
	public void setLastTotalScore(double lastTotalScore) {
		this.lastTotalScore = lastTotalScore;
	}
	@Override
	/**
	 * toString 오버라이딩 메소드
	 */
	public String toString() {
		return String.format("학번:%s\n학년:%s\n학기:%s\n평점:%s\n"
				,this.getStudentID()
				,this.getGrade()
				,this.getSemester()
				,this.getLastTotalScore());
	}
	/**
	 *  저장포맷 반환 메소드
	 * @return 저장포맷
	 */
	public String saveFormat() {
		return String.format("%s,%s,%s,%s"
				,this.getStudentID()
				,this.getGrade()
				,this.getSemester()
				,this.getLastTotalScore());
	}
	
}

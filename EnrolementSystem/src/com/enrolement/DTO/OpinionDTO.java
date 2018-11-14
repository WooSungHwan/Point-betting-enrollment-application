package com.enrolement.DTO;

public class OpinionDTO {
	/**
	 * 학번
	 */
	private String	studentID;
	/**
	 * 의견
	 */
	private String	opinion;
	
	
	/**
	 * 초기화, 학번과 의견함을 초기화
	 * @param studentID 학번
	 * @param opinion 의견
	 */
	public OpinionDTO(String studentID, String opinion) {
		super();
		this.studentID = studentID;
		this.opinion = opinion;
		
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
	 * 의견함 getter 메소드
	 * @return 의견
	 */
	public String getOpinion() {
		return opinion;
	}
	/**
	 * 의견함 setter 메소드
	 * @param opinion 의견
	 */
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
	@Override
	/**
	 * toString 오버라이딩 메소드
	 */
	public String toString() {
		return String.format("학번:%s\n의견:%s\n\n"
				,this.getStudentID()
				,this.getOpinion());
	}
	/**
	 * 저장포맷 메소드
	 * @return 저장포맷
	 */
	public String saveFormat() {
		return String.format("%s,%s"
				,this.getStudentID()
				,this.getOpinion());
	}

	
}

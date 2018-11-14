package com.enrolement.DTO;
/**
 * 학생학번과 비밀번호로 로그인하기위한 클래스 
 * @author 정세연
 *
 */
public class StudentLoginDTO {
	private String id;
	private String pwd;

	public StudentLoginDTO() {

	}

	/**
	 * @param id 학생의 아이디 (학번)
	 * @param pwd 학생의 비밀번호(전화번호 뒤 4자리)
	 */
	public StudentLoginDTO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id 학생의 아이디(학번)
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	/**
	 * 
	 * @param pwd 학생의 비밀번호(전화번호 뒤 4자리)
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return String.format("아이디:%s\n,비밀번호:%s\n"
				,this.getId()
				,this.getPwd());
	}
	public String saveFormat() {
		return String.format("%s,%s"
				,this.getId()
				,this.getPwd());
	}

}

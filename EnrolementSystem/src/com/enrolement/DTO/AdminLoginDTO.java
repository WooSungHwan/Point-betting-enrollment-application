package com.enrolement.DTO;

/**
 * 관리자 로그인(ID,pwd)정보를 가지는 데이터 클래스
 * @author 우성환
 *
 */
public class AdminLoginDTO {
	/**
	 * 관리자아이디입니다.
	 */
	private String id;
	/**
	 * 관리자 비밀번호입니다.
	 */
	private String pwd;
	/**
	 * 
	 * @param id 관리자 id초기화
	 * @param pwd 관리자 pwd초기화
	 */
	public AdminLoginDTO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	/**
	 * id getter메소드입니다.
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * id setter메소드입니다.
	 * @param id 아이디
	 * 
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * pwd getter 메소드입니다.
	 * @return pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * pwd setter메소드입니다.
	 * @param pwd 비밀번호
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * toString() 오버라이딩 한 메소드입니다.
	 */
	@Override
	public String toString() {
		return String.format("아이디:%s\n,비밀버호:%s\n",this.getId(),this.getPwd());
	}
	/**
	 * 저장포맷을 설정하는 메소드입니다.
	 * @return 저장포맷
	 */
	public String saveFormat() {
		return String.format("%s,%s",this.getId(),this.getId());
	}
}

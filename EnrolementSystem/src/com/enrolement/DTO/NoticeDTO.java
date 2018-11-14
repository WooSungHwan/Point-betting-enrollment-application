package com.enrolement.DTO;

import java.util.Calendar;

/**
 * 공지사항을 가지고 있는 클래스
 * @author 우성환
 *
 */
public class NoticeDTO {
	/**
	 * 공지사항 
	 */
	private String notice;


	
	/**
	 * 공지사항 getter 메소드
	 * @return 공지사항
	 */
	public String getNotice() {
		return notice;
	}
	
	/**
	 * 공지사항 초기화 생성자
	 * @param notice 공지사항
	 */
	public NoticeDTO(String notice) {
		super();
		this.notice = notice;
	}
	
	/**
	 * 공지사항 setter 메소드
	 * @param notice 공지사항
	 */
	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Override
	/**
	 * toString 오버라이딩 메소드
	 */
	public String toString() {
		Calendar c= Calendar.getInstance();
		return String.format("<%tF 공지사항내용>\n%s\n",c,this.getNotice());
	}
}

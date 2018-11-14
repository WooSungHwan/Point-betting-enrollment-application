package com.enrolement.DTO;

/**
 * 학생에 관련된 DTO
 * 
 * @author 정세연
 *
 */
public class StudentDTO {
	/**
	 * 학생학번
	 */
	private String studentID;
	/**
	 * 학생이름
	 */
	private String studentName;
	/**
	 * 학생의 학과코드
	 */
	private String deptCode;
	/**
	 * 학생의 학년
	 */
	private String grade;
	/**
	 * 학생의 나이
	 */
	private String age;
	/**
	 * 학생의 전화번호
	 */
	private String phoneNumber;
	/**
	 * 학생의 주소
	 */
	private String adress;
	/**
	 * 학생의 신청학점 (디폴트:0)
	 */
	private int applyCredit = 0;
	/**
	 * 학생의 보유포인트 (디폴트:0)
	 */
	private int holdingPoint = 0;

	/**
	 * 
	 * @return 학생의 신청학점 반환
	 */
	public int getApplyCredit() {
		return applyCredit;
	}

	/**
	 * 
	 * @param applyCredit 학생의 신청 학점
	 */
	public void setApplyCredit(int applyCredit) {
		this.applyCredit = applyCredit;
	}

	/**
	 * 
	 * @return 학생의 보유 포인트 반환
	 */
	public int getHoldingPoint() {
		return holdingPoint;
	}

	/**
	 * 
	 * @param holdingPoint 학생이 보유한 포인트현황
	 */
	public void setHoldingPoint(int holdingPoint) {
		this.holdingPoint = holdingPoint;
	}

	public StudentDTO() {

	}

	/**
	 * 학생 객체 생성
	 * 
	 * @param studentID   학생의 학번
	 * @param studentName 학생의 이름
	 * @param deptCode    학생의 학과코드
	 * @param grade       학생의 학년
	 * @param age         학생의 나이
	 * @param phoneNumber 학생의 전화번호
	 * @param adress      학생의 주소
	 */
	public StudentDTO(String studentID, String studentName, String deptCode, String grade, String age,
			String phoneNumber, String adress) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.deptCode = deptCode;
		this.grade = grade;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
	}

	/**
	 * 학생의 학번을 돌려준다.
	 * 
	 * @return 학생학번 리턴
	 */
	public String getStudentID() {
		return studentID;
	}

	/**
	 * 학생의 학번을 대입
	 * 
	 * @param studentID 학생의 학번
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	/**
	 * 학생의 이름을 반환
	 * 
	 * @return studentName 학생의 이름
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * 학생의 이름을 대입
	 * 
	 * @param studentName 학생의 이름
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * 학생의 학과를 반환
	 * 
	 * @return deptCode 학생의 학과
	 */
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * 학생의 학과를 대입
	 * 
	 * @param deptCode 학생의 학과 코드
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * 학생의 학년을 반환
	 * 
	 * @return grade 학생의 학년
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 학생의 학년을 대입
	 * 
	 * @param grade 학생의 학년
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * 학생의 나이를 반환
	 * 
	 * @return age 학생의 나이
	 */
	public String getAge() {
		return age;
	}

	/**
	 * 학생의 나이를 대입
	 * 
	 * @param age 학생의 나이
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * 학생의 전화번호를 반환
	 * 
	 * @return phoneNumber 학생의 전화번호
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 학생의 전화번호 대입
	 * 
	 * @param phoneNumber 학생의 전화번호
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 학생의 주소 반환
	 * 
	 * @return 학생의 주소 리턴
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * 학생의 주소 대입
	 * 
	 * @param adress 학생의 주소
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	/**
	 * toString 오버라이딩 메소드
	 */
	public String toString() {

		return String.format("학번: %s\n이름: %s\n전화번호: %s\n학과코드: %s\n나이: %s\n학년: %s\n주소: %s\n신청학점: %d\n보유포인트: %s\n",
				this.getStudentID(), this.getStudentName(), this.getPhoneNumber(), this.getDeptCode(), this.getAge(),
				this.getGrade(), this.getAdress(), this.getApplyCredit(), this.getHoldingPoint());
	}

	public String saveFormat() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", this.getStudentID(), this.getStudentName(),
				this.getPhoneNumber(), this.getDeptCode(), this.getAge(), this.getGrade(), this.getAdress(),
				this.getApplyCredit(), this.getHoldingPoint());
	}

	/**
	 * 학생이 학점을 초과하는가를 판별하는 메소드
	 * 
	 * @param grades 학생의 학년
	 * @return 학점 초과여부
	 */
	public boolean isGradesRight(int grades) {
		if (this.applyCredit + grades <= 21) {
			return true;
		} else {
			return false;
		}
	}

}

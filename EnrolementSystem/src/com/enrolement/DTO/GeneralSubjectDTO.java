package com.enrolement.DTO;
/**
 * 교양과목 DTO
 * @author 한종균
 * 
 */
public class GeneralSubjectDTO {
	/**
	 * 과목코드
	 */
	private String subjectCode;
	/**
	 * 학과코드
	 */
	private String deptCode;
	/**
	 * 교수코드
	 */
	private String professorCode;
	/**
	 * 강의실
	 */
	private String classNum;
	/**
	 * 과목명
	 */
	private String subjectName;
	/**
	 * 학점
	 */
	private int grades;
	/**
	 * 수강인원
	 */
	private int checkNum;
	/**
	 * 강의시간
	 */
	private String scheduleTime;
	/**
	 * 관심과목인원
	 */
	private int interestNum;

	/**
	 * 교양과목 관련하여 입력된 값으로 객체 생성 하는 생성메소드
	 * @param subjectCode	과목코드
	 * @param deptCode		학과코드
	 * @param professorCode	교수코드
	 * @param classNum		강의실
	 * @param subjectName	과목명
	 * @param grades		학점
	 * @param checkNum		수강인원
	 * @param scheduleTime	강의시간
	 * @param interestNum	관심과목인원
	 */
	public GeneralSubjectDTO(String subjectCode, String deptCode, String professorCode, String classNum,
			String subjectName, int grades, int checkNum, String scheduleTime, int interestNum) {
		super();
		this.subjectCode = subjectCode;
		this.deptCode = deptCode;
		this.professorCode = professorCode;
		this.classNum = classNum;
		this.subjectName = subjectName;
		this.grades = grades;
		this.checkNum = checkNum;
		this.scheduleTime = scheduleTime;
		this.interestNum = interestNum;
	}

	/**
	 * 과목코드 getter 메소드
	 * @return 과목코드
	 */
	public String getSubjectCode() {
		return subjectCode;
	}

	/**
	 * 과목코드 setter 메소드
	 * @param subjectCode 과목코드
	 */
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	/**
	 * 학과코드 getter 메소드
	 * @return 학과코드
	 */
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * 학과코드 setter 메소드
	 * @param deptCode 학과코드
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * 교수코드 getter 메소드 
	 * @return 교수코드
	 */
	public String getProfessorCode() {
		return professorCode;
	}

	/**
	 * 교수코드 setter 메소드
	 * @param professorCode 교수코드
	 */
	public void setProfessorCode(String professorCode) {
		this.professorCode = professorCode;
	}

	/**
	 * 강의실 getter 메소드
	 * @return 강의실
	 */
	public String getClassNum() {
		return classNum;
	}

	/**
	 * 강의실 setter 메소드
	 * @param classNum 강의실
	 */
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	/**
	 * 과목명 getter 메소드
	 * @return 과목명
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * 과목명 setter 메소드
	 * @param subjectName 고목명
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/**
	 * 학점 getter 메소드
	 * @return 학점
	 */
	public int getGrades() {
		return grades;
	}

	/**
	 * 학점 setter 메소드
	 * @param grades 학점
	 */
	public void setGrades(int grades) {
		this.grades = grades;
	}

	/**
	 * 수강인원 getter 메소드
	 * @return 수강인원
	 */
	public int getCheckNum() {
		return checkNum;
	}

	/**
	 * 수강인원 setter 메소드
	 * @param checkNum 수강인원
	 */
	public void setCheckNum(int checkNum) {
		this.checkNum = checkNum;
	}

	/**
	 * 강의시간 getter 메소드
	 * @return 강의시간
	 */
	public String getScheduleTime() {
		return scheduleTime;
	}

	/**
	 * 강의시간 setter 메소드
	 * @param scheduleTime 강의시간
	 */
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	/**
	 * 관심과목인원 getter 메소드
	 * @return 관심과목인원
	 */
	public int getInterestNum() {
		return interestNum;
	}

	/**
	 * 관심과목인원 setter 메소드
	 * @param interestNum 관심과목인원
	 */
	public void setInterestNum(int interestNum) {
		this.interestNum = interestNum;
	}

	/**
	 * 교양과목 toString 오버라이딩 메소드
	 */
	@Override
	public String toString() {
		return String.format("과목코드:%s\n교수코드:%s\n학과코드:%s\n과목명:%s\n학점:%s\n강의시간:%s\n강의실:%s\n수강가능인원:%s\n관심과목인원:%s\n"
				,this.getSubjectCode()
				,this.getProfessorCode()
				,this.getDeptCode()
				,this.getSubjectName()
				,this.getGrades()
				,this.getScheduleTime()
				,this.getClassNum()
				,this.getCheckNum()
				,this.getInterestNum());
	}
	
	/**
	 * 교양과목 목록을 String 형태로 맞춰주는 메소드
	 * @return 과목코드,교수코드,학과코드,과목명,학점,강의시간,강의실,수강인원,관심과목인원
	 */
	public String savaFormat() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s"
				,this.getSubjectCode()
				,this.getProfessorCode()
				,this.getDeptCode()
				,this.getSubjectName()
				,this.getGrades()
				,this.getScheduleTime()
				,this.getClassNum()
				,this.getCheckNum()
				,this.getInterestNum());
	}
}

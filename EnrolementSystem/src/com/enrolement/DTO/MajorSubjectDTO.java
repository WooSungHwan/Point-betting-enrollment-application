package com.enrolement.DTO;
/**
 * 전공과목 DTO
 * @author 한종균
 * 
 */
public class MajorSubjectDTO {
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
	 * 과목명
	 */
	private String subjectName;
	/**
	 * 학점
	 */
	private String grades;
	/**
	 * 학년
	 */
	private String grade;
	/**
	 * 수강인원
	 */
	private String checkNum;
	/**
	 * 강의시간
	 */
	private String scheduleTime;
	/**
	 * 강의실
	 */
	private String classNum;

	/**
	 * 전공과목 관련하여 입력된 값으로 객체 생성 하는 생성메소드
	 * @param subjectCode	과목코드
	 * @param deptCode		학과코드
	 * @param professorCode	교수코드
	 * @param subjectName	과목명
	 * @param grades		학점
	 * @param grade			학년
	 * @param checkNum		수강인원
	 * @param scheduleTime	강의시간
	 * @param classNum		강의실
	 */
	public MajorSubjectDTO(String subjectCode, String deptCode, String professorCode
			, String subjectName, String grades,
			String grade, String checkNum, String scheduleTime, String classNum) {
		super();
		this.subjectCode = subjectCode;
		this.deptCode = deptCode;
		this.professorCode = professorCode;
		this.subjectName = subjectName;
		this.grades = grades;
		this.grade = grade;
		this.checkNum = checkNum;
		this.scheduleTime = scheduleTime;
		this.classNum = classNum;
		
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
	 * 과목명 getter 메소드
	 * @return 과목명
	 */
	public String getSubjectName() {
		return subjectName;
	}
	
	/**
	 * 과목명 setter 메소드
	 * @param subjectName 과목명
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/**
	 * 학점 getter 메소드
	 * @return 학점
	 */
	public String getGrades() {
		return grades;
	}

	/**
	 * 학점 setter 메소드
	 * @param grades 학점
	 */
	public void setGrades(String grades) {
		this.grades = grades;
	}

	/**
	 * 학년 getter 메소드
	 * @return 학년
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 학년 setter 메소드
	 * @param grade 학년
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * 수강인원 getter 메소드
	 * @return 수강인원
	 */
	public String getCheckNum() {
		return checkNum;
	}

	/**
	 * 수강인원 setter 메소드
	 * @param checkNum 수강인원
	 */
	public void setCheckNum(String checkNum) {
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
	 * 전공과목 toString 오버라이딩 메소드
	 */
	@Override
	public String toString() {
		return String.format("과목코드:%s\n학과코드:%s\n교수코드:%s\n과목명:%s\n학점:%s\n학년:%s\n수강인원:%s\n강의시간:%s\n강의실:%s\n"
				,this.getSubjectCode()
				,this.getDeptCode()
				,this.getProfessorCode()
				,this.getSubjectName()
				,this.getGrades()
				,this.getGrade()
				,this.getCheckNum()
				,this.getScheduleTime()
				,this.getClassNum());
	}
	/**
	 * 전공과목 목록을 String 형태로 맞춰주는 메소드
	 * @return 과목코드,학과코드,교수코드,과목명,학점,학년,수강인원,강의시간,강의실
	 */
	public String saveFormat() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s"
				,this.getSubjectCode()
				,this.getDeptCode()
				,this.getProfessorCode()
				,this.getSubjectName()
				,this.getGrades()
				,this.getGrade()
				,this.getCheckNum()
				,this.getScheduleTime()
				,this.getClassNum());
	}
}

package com.enrolement.Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.enrolement.DTO.AdminLoginDTO;
import com.enrolement.DTO.ClassroomDTO;
import com.enrolement.DTO.ClassroomTimeDTO;
import com.enrolement.DTO.DepartmentDTO;
import com.enrolement.DTO.FinalEnrolementDTO;
import com.enrolement.DTO.GeneralSubjectDTO;
import com.enrolement.DTO.InterestSubjectListDTO;
import com.enrolement.DTO.MajorSubjectDTO;
import com.enrolement.DTO.NoticeDTO;
import com.enrolement.DTO.OpinionDTO;
import com.enrolement.DTO.PointUseDTO;
import com.enrolement.DTO.PreviousSemesterDTO;
import com.enrolement.DTO.ProfessorDTO;
import com.enrolement.DTO.SemesterManagementDTO;
import com.enrolement.DTO.StudentDTO;
import com.enrolement.DTO.StudentLoginDTO;

/**
 * 저장파일과 연관되어 파일에 저장하거나 불러오는 기능을 소유하는 클래스
 * @author 우성환
 *
 */
public class UtilAboutFile {
	/**
	 * 교수관리 데이터파일의 path를 저장하는 변수
	 */
	final private static String professorPath = "dat\\교수관리.dat";
	/**
	 * 학생관리 데이터파일의 path를 저장하는 변수
	 */
	final private static String studentPath = "dat\\학생관리.dat";
	/**
	 * 학과관리 데이터파일의 path를 저장하는 변수
	 */
	final private static String departmentPath = "dat\\학과관리.dat";
	/**
	 * 교양과목 데이터파일의 path를 저장하는 변수
	 */
	final private static String generalSubjectPath = "dat\\교양과목.dat";
	/**
	 * 전공과목 데이터파일의 path를 저장하는 변수
	 */
	final private static String majorSubjectPath = "dat\\전공과목.dat";
	/**
	 * 강의실관리 데이터파일의 path를 저장하는 변수
	 */
	final private static String classroomPath = "dat\\강의실관리.dat";
	/**
	 * 이전학기성적 데이터파일의 path를 저장하는 변수
	 */
	final private static String previousSemesterPath = "dat\\이전학기성적.dat";
	/**
	 * 관심과목목록 데이터파일의 path를 저장하는 변수
	 */
	final private static String interestSubjectPath = "dat\\관심과목목록.dat";
	/**
	 * 강의실강의시간 데이터파일의 path를 저장하는 변수
	 */
	final private static String classroomTimePath = "dat\\강의실강의시간.dat";
	/**
	 * 의견게시판 데이터파일의 path를 저장하는 변수
	 */
	final private static String opinionPath = "dat\\의견게시판.dat";
	/**
	 * 공지사항 데이터파일의 path를 저장하는 변수
	 */
	final private static String noticePath = "dat\\공지사항.dat";
	/**
	 * 최종수강신청 데이터파일의 path를 저장하는 변수
	 */
	final private static String finalEnrolementPath = "dat\\최종수강신청.dat";
	/**
	 * 학기관리 데이터파일의 path를 저장하는 변수
	 */
	final private static String semesterManagementPath = "dat\\학기관리.dat";
	/**
	 * 학생로그인 데이터파일의 path를 저장하는 변수
	 */
	final private static String studentLoginPath = "dat\\학생로그인.dat";
	/**
	 * 관리자로그인 데이터파일의 path를 저장하는 변수
	 */
	final private static String adminLoginPath = "dat\\관리자로그인.dat";
	/**
	 * 포인트사용목록 데이터파일의 path를 저장하는 변수
	 */
	final private static String pointUsePath = "dat\\포인트사용목록.dat";
	
	
	/**
	 * 데이터파일로부터 파일을 읽어 객체화하여 ExData에 있는 list들에 데이터를 읽어오는 메소드
	 * 프로그램이 시작할때 호출된다.
	 */
	public static void load() {
		// ����Ʈ ��ü ����.
		ExData.professorList = new ArrayList<ProfessorDTO>();
		ExData.studentList = new ArrayList<StudentDTO>();
		ExData.departmentList = new ArrayList<DepartmentDTO>();
		ExData.generalSubjectList = new ArrayList<GeneralSubjectDTO>();
		ExData.majorSubjectList = new ArrayList<MajorSubjectDTO>();
		ExData.classroomList = new ArrayList<ClassroomDTO>();
		ExData.previousSemesterList = new ArrayList<PreviousSemesterDTO>();
		ExData.interestSubjectListSet = new HashSet<InterestSubjectListDTO>();
		ExData.classroomTimeList = new ArrayList<ClassroomTimeDTO>();
		ExData.opinionList = new ArrayList<OpinionDTO>();
		ExData.noticeList = new ArrayList<NoticeDTO>();
		ExData.finalEnrolementList = new HashSet<FinalEnrolementDTO>();
		ExData.semesterManagementList = new ArrayList<SemesterManagementDTO>();
		ExData.studentLoginList = new ArrayList<StudentLoginDTO>();
		ExData.adminLoginList = new ArrayList<AdminLoginDTO>();
		
		// ���Ͼ��� ��� �����͸� ����Ʈ�� �����ϴ� �۾�
		try {
			BufferedReader reader = new BufferedReader(new FileReader(professorPath));
			String line = "";
			// �������
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				ExData.professorList.add(new ProfessorDTO(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]));
			}
			reader.close();
			reader = new BufferedReader(new FileReader(studentPath));
			// �л����
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				ExData.studentList
						.add(new StudentDTO(temp[0], temp[1], temp[3], temp[5], temp[4], temp[2], temp[6]));
			}
			reader.close();
			// �а����
			reader = new BufferedReader(new FileReader(departmentPath));
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				ExData.departmentList.add(new DepartmentDTO(temp[0], temp[1], temp[2]));
			}
			reader.close();
			reader = new BufferedReader(new FileReader(generalSubjectPath));
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				ExData.generalSubjectList
						.add(new GeneralSubjectDTO(temp[0], temp[2], temp[1], temp[6], temp[3], 3, 30, temp[5], 0));
			}
			reader.close();
			reader = new BufferedReader(new FileReader(majorSubjectPath));
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				ExData.majorSubjectList.add(new MajorSubjectDTO(temp[0], temp[1], temp[2], temp[3],
						temp[4], temp[5], temp[6], temp[7], temp[8]));
			}
			reader.close();
			reader = new BufferedReader(new FileReader(classroomPath));
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				ExData.classroomList.add(new ClassroomDTO(temp[0], temp[1], temp[2]));
			}
			reader.close();
			reader = new BufferedReader(new FileReader(previousSemesterPath));
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				ExData.previousSemesterList
						.add(new PreviousSemesterDTO(temp[0], temp[1], temp[2], Double.parseDouble(temp[3])));
			}
			// ���ɰ����� ���ϰ��̱⶧���� �����Ͱ� ����������
			reader.close();
			reader = new BufferedReader(new FileReader(classroomTimePath));
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				ExData.classroomTimeList.add(new ClassroomTimeDTO(temp[0], temp[1]));
			}
			reader.close();
			reader = new BufferedReader(new FileReader(opinionPath));
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				ExData.opinionList.add(new OpinionDTO(temp[0], temp[1]));
			}
			reader.close();
			reader = new BufferedReader(new FileReader(noticePath));
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				ExData.noticeList.add(new NoticeDTO(temp[0]));
			}

			// finalEnrolementPath �̰͵� �׿����� �����Ϳ��� �ϱ� ������ ó���� ������...
			reader.close();
			// �б���� ����.
			
			//�л��α���
			reader = new BufferedReader(new FileReader(studentLoginPath));
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				ExData.studentLoginList.add(new StudentLoginDTO(temp[0], temp[1]));
			}
			reader.close();
			
			//�����ڷα���
			reader = new BufferedReader(new FileReader(adminLoginPath));
			while((line=reader.readLine())!=null) {
				String[] temp = line.split(",");
				ExData.adminLoginList.add(new AdminLoginDTO(temp[0], temp[1]));
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// load�޼ҵ�
	
	/**
	 * 리스트에 추가된 내용을 교수관리 파일에 저장하는 메소드
	 * @param list 교수리스트
	 */
	public static void professorSave(List<ProfessorDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(professorPath));
			Iterator<ProfessorDTO> iter = list.iterator();

			while (iter.hasNext()) {
				writer.write(iter.next().saveFormat());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 학생리스트에 추가된 내용을 학생관리 파일에 저장하는 메소드
	 * @param list 학생 리스트
	 */
	public static void studentSave(List<StudentDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(studentPath));

			Iterator<StudentDTO> iter = list.iterator();
			while (iter.hasNext()) {
				StudentDTO student = iter.next();
				writer.write(student.saveFormat());
				writer.newLine();
			}

			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// studentSave�޼ҵ�
	/**
	 * 학과리스트에 추가된 내용을 학과관리 파일에 저장하는 메소드
	 * @param list 학과 리스트
	 */
	public static void departmentSave(List<DepartmentDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(departmentPath));

			Iterator<DepartmentDTO> iter = list.iterator();
			while (iter.hasNext()) {
				writer.write(iter.next().saveFormat());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// departmentSave�޼ҵ�
	
	/**
	 * 교양과목 리스트에 추가된 내용을 교양과목 파일에 저장하는 메소드
	 * @param list 교양과목 리스트
	 */
	public static void generalSubjectSave(List<GeneralSubjectDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(generalSubjectPath));

			Iterator<GeneralSubjectDTO> iter = list.iterator();
			while (iter.hasNext()) {
				writer.write(iter.next().savaFormat());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// generalSubjectSave�޼ҵ�
	
	/**
	 * 전공과목 리스트에 추가된 내용을 전공과목 파일에 저장하는 메소드
	 * @param list 전공과목 리스트
	 */
	public static void majorSubjectSave(List<MajorSubjectDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(majorSubjectPath));
			Iterator<MajorSubjectDTO> iter = list.iterator();
			while (iter.hasNext()) {
				writer.write(iter.next().saveFormat());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// majorSubjectSave�޼ҵ�
	
	/**
	 * 강의실 리스트에 추가된 내용을 강의실관리 파일에 저장하는 메소드
	 * @param list 강의실 리스트
	 */
	public static void classroomSave(List<ClassroomDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(classroomPath));
			Iterator<ClassroomDTO> iter = list.iterator();
			while (iter.hasNext()) {
				writer.write(iter.next().saveFormat());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// classroomSave�޼ҵ�
	/**
	 * 이전학기성적리스트에 추가된 내용을 이전학기성적파일에 저장하는 메소드
	 * @param list 이전학기성적리스트
	 */
	public static void previousSemesterSave(List<PreviousSemesterDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(previousSemesterPath));
			Iterator<PreviousSemesterDTO> iter = list.iterator();
			while (iter.hasNext()) {
				writer.write(iter.next().saveFormat());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// previousSemesterSave�޼ҵ�
	
	/**
	 * 관심과목 리스트에 추가된 내용을 관심과목 파일에 저장하는 메소드
	 * @param list 관심과목 리스트
	 */
	public static void interestSubjectSave(Set<InterestSubjectListDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(interestSubjectPath));
			Iterator<InterestSubjectListDTO> iter = list.iterator();
			while (iter.hasNext()) {
				writer.write(iter.next().saveFormat());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// interestSubjectSave�޼ҵ�
	
	/**
	 * 강의실강의시간 리스트에서 추가된 내용을 파일에 저장하기 위한 메소드
	 * @param list 강의실강의시간 리스트
	 */
	public static void classroomTimeSave(List<ClassroomTimeDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(classroomTimePath));
			Iterator<ClassroomTimeDTO> iter = list.iterator();

			while (iter.hasNext()) {
				writer.write(iter.next().saveFormat());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// classroomTimeSave�޼ҵ�
	
	/**
	 * 의견게시판 리스트에 추가된 내용을 의견게시판 파일에 저장하는 기능
	 * @param list 의견게시판리스트
	 */
	public static void opinionSave(List<OpinionDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(opinionPath));
			Iterator<OpinionDTO> iter = list.iterator();

			while (iter.hasNext()) {
				writer.write(iter.next().saveFormat());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// opinionSave�޼ҵ�
	
	/**
	 * 공지사항 리스트에 추가된 내용을 공지사항 파일에 저장하는 기능
	 * @param list 공지사항리스트
	 */
	public static void noticeSave(List<NoticeDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(noticePath));

			Iterator<NoticeDTO> iter = list.iterator();
			while (iter.hasNext()) {
				NoticeDTO notice = iter.next();
				writer.write(notice.getNotice());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// noticeSave�޼ҵ�
	
	/**
	 * 최종과목 리스트에 추가된 내용을 최종과목 파일에 저장하는 기능
	 * @param list 최종과목 리스트
	 */
	public static void finalEnrolementSave(Set<FinalEnrolementDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(finalEnrolementPath));
			Iterator<FinalEnrolementDTO> iter = list.iterator();
			while (iter.hasNext()) {
				writer.write(iter.next().saveFormat());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// finalEnrolementSave�޼ҵ�
	
	/**
	 * 학생로그인 리스트에 추가된 내용을 학생로그인 파일에 저장하는 기능
	 * @param list 학생로그인 리스트
	 */
	public static void studentLoginSave(List<StudentLoginDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(studentLoginPath));
			Iterator<StudentLoginDTO> iter = list.iterator();
			while(iter.hasNext()) {
				writer.write(iter.next().saveFormat());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//studentLoginSave�޼ҵ�
	
	/**
	 * 관리자 로그인 리스트에 추가된 내용을 관리자 로그인 파일에 저장하는 기능
	 * @param list 관리자 로그인리스트
	 */
	public static void adminLoginSave(List<AdminLoginDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(adminLoginPath));
			Iterator<AdminLoginDTO> iter = list.iterator();
			while(iter.hasNext()) {
				writer.write(iter.next().saveFormat());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//adminLoginSave �޼ҵ�
	/**
	 * 포인트 사용내역 리스트에 추가된 내용을 포인트 사용내역 파일에 저장하는 기능
	 * @param list 포인트사용내역 리스트
	 */
	public static void pointUseSave(List<PointUseDTO> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(pointUsePath));
			Iterator<PointUseDTO> iter = list.iterator();
			while(iter.hasNext()) {
				writer.write(iter.next().saveFormat());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
}

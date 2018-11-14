package com.enrolement.Enrolement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.enrolement.DTO.GeneralSubjectDTO;
import com.enrolement.DTO.MajorSubjectDTO;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutCodeFind;

/**
 * 과목리스트를 확인하는 기능을 모은 클래스
 * @author 우성환
 *
 */
public class SubjectListCheck {
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 기본생성자 , while 분기문이 있음.
	 */
	public SubjectListCheck() {
		while (true) {
			selectMajorGeneralUI();
			int sel = sc.nextInt();
			if (sel == 1) {// 전공과목
				this.majorList();
				pause();
			} else if (sel == 2) { // 교양과목
				this.generalList();
				pause();
			} else if (sel == 0) {
				return;
			}
		}
	}
	
	/**
	 * 교과과목 확인하기 UI 메소드
	 */
	public void selectMajorGeneralUI() {
		System.out.println("\t\t\t\t     ┌─────────────┐");
		System.out.println("\t\t\t\t     │ 교과과목 확인하기  │");
		System.out.println("\t\t\t\t     └─────────────┘");
		System.out.println("\t\t\t┌────────────────────────────────────────┐");
		System.out.println("\t\t\t│1. [전공과목 확인하기]\t\t\t │");
		System.out.println("\t\t\t│\t\t\t\t\t │");
		System.out.println("\t\t\t│2. [교양과목 확인하기]\t\t\t │");
		System.out.println("\t\t\t│\t\t\t\t\t │");
		System.out.println("\t\t\t│0. [처음으로]\t\t\t\t │");
		System.out.println("\t\t\t└────────────────────────────────────────┘");
		System.out.print("선택 : ");
	}
	/**
	 * 전공과목 리스트를 출력하는 기능의 메소드
	 */
	public void majorList() {
		String grade = Enrolement.loginStudent.getGrade();
		String deptCode = Enrolement.loginStudent.getDeptCode();
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("\t\t\t\t ┌────────────────────────┐");
		System.out.println("\t\t\t\t │[" + UtilAboutCodeFind.findDepartment(deptCode).getDeptName() + 
				"학과] [" + grade + "학년]");
		System.out.println("\t\t\t\t └────────────────────────┘");
		
		System.out.println("\t\t\t┌─────────────────────────────────────────┐");
		for(int i =0; i<ExData.majorSubjectList.size();i++) {
			MajorSubjectDTO thisMajor = ExData.majorSubjectList.get(i);
			if (thisMajor.getGrade().equals(grade) && thisMajor.getDeptCode().equals(deptCode)) {
				if(thisMajor.getSubjectName().length()>=12) {
					System.out.println("\t\t\t│\t-"+thisMajor.getSubjectName()+"\t\t\t  │");
					continue;
				}else if(thisMajor.getSubjectName().length()>=10)
				System.out.println("\t\t\t│\t-"+thisMajor.getSubjectName()+"\t\t\t  │");
			}
		}
		System.out.println("\t\t\t└─────────────────────────────────────────┘");
		
	}
	
	/**
	 * 교양과목 리스트를 출력하는 메소드
	 */
	public void generalList() {
		StringBuilder sb = new StringBuilder("");
		Iterator<GeneralSubjectDTO> iter = ExData.generalSubjectList.iterator();
		System.out.println("\t\t\t☆★☆★☆★☆★☆");
		System.out.println("\t\t\t☆★교양과목☆★");
		System.out.println("\t\t\t☆★☆★☆★☆★☆");
		System.out.println();
		while (iter.hasNext()) {

			System.out.printf("\t-%s\n", iter.next().getSubjectName());
		}

	}
	
	/**
	 * 프로그램의 흐름을 잠시 중단시키기 위한 메소드
	 */
	public void pause() {
		System.out.println("\t\t\t---------------------------");
		System.out.println("\t\t\t계속 진행하시려면 엔터를 눌러주세요...");
		System.out.println("\t\t\t---------------------------");
		sc.nextLine();
		sc.nextLine();
	}
}

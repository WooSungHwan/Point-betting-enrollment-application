package com.enrolement.Enrolement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.enrolement.DTO.FinalEnrolementDTO;
import com.enrolement.DTO.GeneralSubjectDTO;
import com.enrolement.DTO.InterestSubjectListDTO;
import com.enrolement.DTO.MajorSubjectDTO;
import com.enrolement.DTO.PointUseDTO;
import com.enrolement.DTO.StudentDTO;
import com.enrolement.Util.ExData;
import com.enrolement.Util.UtilAboutCodeFind;
import com.enrolement.Util.UtilAboutFile;
import com.enrolement.Util.UtilAboutSubject;

/**
 * 최종수강신청의 기능을 모아놓은 클래스이다.
 * 코드의 재사용을 위해 ShowInterestSubjectList를 상속하였다.
 * @author 우성환
 *
 */
public class FinalEnrolement extends ShowInterestSubjectList {
	/**
	 * 입출력을 위한 스캐너 객체
	 */
	Scanner sc;
	/**
	 * 포인트 사용 객체를 저장하는 리스트
	 */
	public static List<PointUseDTO> pointUseList = new ArrayList<PointUseDTO>();
	
	/**
	 * 최종 수강신청을 진행하는 메소드
	 * 최종수강신청의 분기가 포함되어있다.
	 */
	public void doEnrolement() {
		sc = new Scanner(System.in);

		doEnUI();
		String sel = sc.nextLine();
		if (sel.equals("1")) { // 완료.
			// 관심과목에서 신청하기...
			System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.println("\t☆★신청이 완료되면 \"0\"을 입력해주세요☆★");
			System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			pause();
			doEnrolementFromInterest();
		} else if (sel.equals("2")) {
			// 전체과목에서 신청하기.. 전공과 교양이 분기되는형식.
			while (true) {
				System.out.println("\t1. [전공과목 신청하기]");
				System.out.println("\t2. [교양과목 신청하기]");
				System.out.println("\t0. [뒤로가기]");
				System.out.print("선택 : ");
				sel = sc.nextLine();
				if (sel.equals("0")) {
					return;
				}
				doEnrolementFromAllSubject(sel);
				pause();
			}
		} else if (sel.equals("3")) {
			// 수강취소
			finalEnrolementCancel();
		} else if (sel.equals("0")) {
			return;
		}
	}
	/**
	 * 최종수강신청을 취소하는 메소드이다. 
	 * 삭제할 과목명을 입력하면 수강신청 내역에서 입력한 과목명이 사라진다.
	 */
	private void finalEnrolementCancel() {
		Iterator<FinalEnrolementDTO> iter = ExData.finalEnrolementList.iterator();
		String result = "";
		while (iter.hasNext()) {
			FinalEnrolementDTO f = iter.next();
			if (f.getStudentID().equals(Enrolement.loginStudent.getStudentID())) {// 수강신청한 학생객체를 찾아서 과목출력.
				if (UtilAboutCodeFind.findGeneralSubject(f.getSubjectCode()) == null) {
					// 전공과목인경우
					result += String.format("\t%s\n",
							UtilAboutCodeFind.findMajorSubject(f.getSubjectCode()).getSubjectName());
				} else if (UtilAboutCodeFind.findMajorSubject(f.getSubjectCode()) == null) {
					// 교양과목인 경우
					result += String.format("\t%s\n",
							UtilAboutCodeFind.findGeneralSubject(f.getSubjectCode()).getSubjectName());
				}

			}
		}
		System.out.println("\t<현재 신청한 목록>");
		System.out.println(result);

		System.out.print("삭제할 과목명 : ");
		String input = sc.nextLine();
		Iterator<FinalEnrolementDTO> iter2 = ExData.finalEnrolementList.iterator();
		while (iter2.hasNext()) {
			FinalEnrolementDTO i = iter2.next();
			String subjectCode = UtilAboutCodeFind.findMajorSubject(i.getSubjectCode()).getSubjectCode();
			if (UtilAboutCodeFind.findMajorSubject(i.getSubjectCode()) == null) {
				// 교양인경우
				if (input.equals(UtilAboutCodeFind.findGeneralSubject(i.getSubjectCode()).getSubjectName())) {
					ExData.finalEnrolementList.remove(i);
					Enrolement.loginStudent.setHoldingPoint(Enrolement.loginStudent.getHoldingPoint()
							+ UtilAboutSubject.interestSubjectApplyCount(subjectCode));
					System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("\t☆★과목이 삭제되었습니다.☆★");
					System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					pause();
					return;
				}
			} else if (UtilAboutCodeFind.findGeneralSubject(i.getSubjectCode()) == null) {
				// 전공인경우.
				if (input.equals(UtilAboutCodeFind.findMajorSubject(i.getSubjectCode()).getSubjectName())) {
					ExData.finalEnrolementList.remove(i);
					System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("\t☆★과목이 삭제되었습니다.☆★");
					System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					pause();
					return;
				}
			}
		}
		UtilAboutFile.finalEnrolementSave(ExData.finalEnrolementList);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	/**
	 * 선택변수를 받아 분기하는 메소드이다.
	 * 전체 과목에서 수강신청을 진행하며 교양과 전공으로 나누어 진행한다
	 * 과목명을 하나씩 입력하여 수강신청을 한다.
	 * @param num 선택변수
	 */
	public void doEnrolementFromAllSubject(String num) {
		// 전체과목에서 한번에 신청 (전공, 교양) 분기
		// 여기서 포인트 도입해야한다. 숙제)
		if (num.equals("1")) {
			// 전공 myMajorlist
			// 전공 myMajorlist
			// 전공 myMajorlist
			// 전공 myMajorlist
			// 전공 myMajorlist
			
			System.out.println(FirstEnrolement.showMajorSubject());
			System.out.println("신청이 완료되면 \"0\"을 입력해주세요.");
			while (true) {
				int count = 0;
				System.out.print("과목명 : ");
				String subjectName = sc.nextLine();
				if (subjectName.equals("0"))
					break;
				for (int i = 0; i < StudentSide.mlist.size(); i++) {
					count = 0;
					MajorSubjectDTO m = StudentSide.mlist.get(i);
					if (m.getSubjectName().equals(subjectName)) { // 검색글자가 들어간 객체..
						//학점추가...
						if(Enrolement.loginStudent.isGradesRight(Integer.parseInt(UtilAboutCodeFind
								.findMajorSubject(m.getSubjectCode()).getGrades()))) {
							for(int i1 =0; i1<ExData.studentList.size();i1++) {
								StudentDTO sDTO = ExData.studentList.get(i1);
								if(Enrolement.loginStudent.equals(sDTO.getStudentID())) {
									sDTO.setApplyCredit(sDTO.getApplyCredit()
											+Integer.parseInt(UtilAboutCodeFind
													.findMajorSubject(m.getSubjectCode()).getGrades()));
									break;
								}
							}
						}else {
							System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆☆★★");
							System.out.println("\t☆★신청가능학점을 초과하였습니다☆★");
							System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
							return;
						}
						if (!ExData.finalEnrolementList.add(UtilAboutCodeFind.changeF(m))) {
							System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆");
							System.out.println("이미 수강신청하신 과목입니다.");
							System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆");
							continue;
						}
						
						System.out.println("★☆신청하였습니다.★☆");
						count++;
					}
				}
				if (count == StudentSide.mlist.size())
					System.out.println("잘못입력하셨습니다.정확한 과목명을 입력해주시기 바랍니다.");
			}
			UtilAboutFile.interestSubjectSave(ExData.interestSubjectListSet);

		} else if (num.equals("2")) {
			// 교양
			//교양
			//교양
			//교양
			//교양
			//교양
			
			String sublist = "";
			String subCode = "";
			int count = 0;
			Iterator<GeneralSubjectDTO> iter = ExData.generalSubjectList.iterator();
			while (iter.hasNext()) {
				GeneralSubjectDTO g = iter.next();
				subCode = UtilAboutCodeFind.findGeneralSubject(g.getSubjectCode()).getSubjectCode();
				sublist += String.format("\t%-20s[%s//%s]\t최소요구point : %sp\n", g.getSubjectName(),
						UtilAboutSubject.interestSubjectApplyCount(subCode), g.getCheckNum(),
						UtilAboutSubject.interestSubjectApplyCount(subCode));
			}
			System.out.println(sublist); // 리스트 출력

			System.out.println("신청이 완료되면 \"0\"을 입력해주세요.");
			while (true) {
				count = 0;
				System.out.print("과목명 : ");
				String subjectName = sc.nextLine(); // 입력.
				if (subjectName.equals("0")) {
					System.out.println("신청을 마칩니다.");
					break;
				}
				//학점추가...
				Iterator<GeneralSubjectDTO> iter3 = ExData.generalSubjectList.iterator();
				while(iter3.hasNext()) {
					//계속
					GeneralSubjectDTO g = iter3.next();
					if(subjectName.equals(UtilAboutCodeFind.findGeneralSubject(g.getSubjectCode()))) {
						//같은 과목 이름을 갖는 과목이 있으면 학점 점검하고 끝내자
						//학점기능...
						if(Enrolement.loginStudent.isGradesRight(
								UtilAboutCodeFind.findGeneralSubject(g.getSubjectCode()).getGrades())) {
							for(int i =0; i<ExData.studentList.size();i++) {
								StudentDTO sDTO = ExData.studentList.get(i);
								if(g.equals(sDTO.getStudentID())) {
									sDTO.setApplyCredit(sDTO.getApplyCredit()
											+
											UtilAboutCodeFind.findGeneralSubject(g.getSubjectCode()).getGrades());
									break;
								}
							}
						}else {
							System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆☆★★");
							System.out.println("\t☆★신청가능학점을 초과하였습니다☆★");
							System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
							return;
						}
					}
				}
				
				// 포인트 처리
				String k = "";
				while (true) {
					System.out.println("\t★☆★☆★☆★☆★☆★☆");
					System.out.println("\t★☆뒤로가기 : 0★☆");
					System.out.println("\t★☆★☆★☆★☆★☆★☆");
					System.out.print("지불할 포인트를 입력하세요(숫자만 입력하세요): ");
					k = sc.nextLine();
					if (k.equals("0"))
						return;
					try {
						Integer.parseInt(k);
					} catch (NumberFormatException e) {
						System.out.println("☆★☆★☆★☆★☆☆★☆★☆★☆★☆★☆★");
						System.out.println("☆★정확한 숫자를 입력해주세요.☆★");
						System.out.println("☆★☆★☆★☆☆★☆★☆★☆★☆★☆★☆★");
						pause();
						continue;
					}
					int payPoint = Integer.parseInt(k);
					if (isMyPointOK(payPoint)) {
						// 내가가진 포인트보다 작으면
						System.out.printf("★☆현재포인트 : %s★☆\n", Enrolement.loginStudent.getHoldingPoint());
						System.out.printf("★☆지불할 포인트가 %sp 부족합니다.",
								payPoint - Enrolement.loginStudent.getHoldingPoint());
						continue;
					}
					if (payPoint >= UtilAboutSubject.interestSubjectApplyCount(subCode)) {
						// 포인트 범위 정상...
						StudentDTO sDTO = Enrolement.loginStudent;
						sDTO.setHoldingPoint(sDTO.getHoldingPoint() - payPoint);
						Iterator<GeneralSubjectDTO> it = ExData.generalSubjectList.iterator();
						while (it.hasNext()) {
							GeneralSubjectDTO g = it.next();
							if (subjectName.equals(g.getSubjectName())) {
								ExData.pointUseList
										.add(new PointUseDTO(sDTO.getStudentID(), g.getSubjectCode(), payPoint));
								UtilAboutFile.pointUseSave(ExData.pointUseList);
								break;
							}
						}
						break;
					} else {
						// 해당 포인트가 최소포인트보다 낮으면... 신청안됨...
						System.out.println("\t☆★최소 포인트보다 높은 포인트를 지불해야 신청이 가능합니다.☆★");
						continue;
					}
				}

				Iterator<GeneralSubjectDTO> iter2 = ExData.generalSubjectList.iterator();
				while (iter2.hasNext()) {
					GeneralSubjectDTO g = iter2.next();
					if (g.getSubjectName().equals(subjectName)) {// 같은 과목 발견...!!->신청
						if (!ExData.finalEnrolementList.add(UtilAboutCodeFind.changeF(g))) {
							// 중복된 과목을 신청하는 경우
							System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆");
							System.out.println("이미 수강신청하신 과목입니다.");
							System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆");
							continue;
						}
						System.out.println("★☆신청하였습니다.★☆");
						continue;
					}
					count++;
				}
				if (count == ExData.generalSubjectList.size()) {
					System.out.println("잘못입력하셨습니다. 정확한 과목명을 입력해주시기 바랍니다.");
				}
				UtilAboutFile.finalEnrolementSave(ExData.finalEnrolementList);
			}

		} else {
			System.out.println("정확한 숫자를 입력해주시기 바랍니다.");
		}
	}
	
	/**
	 * 관심과목에서 수강신청을 진행하는 메소드이다.
	 * 과목명을 하나씩 입력하여 수강신청을 진행한다.
	 */
	public void doEnrolementFromInterest() {
		// 1번...전공 교양 한꺼번에 신청 가능
		// 관심과목에서 출력
		// 여기서도 포인트 도입해야함. 숙제
		ShowInterestSubjectList ilist = new ShowInterestSubjectList();
		System.out.println(ilist.showInterestSubject());

		while (true) {
			System.out.print("신청할 과목명 : ");
			String subjectName = sc.nextLine();
			if (subjectName.equals("0"))
				break;

			int count = 0;
			String thisStudentID = Enrolement.loginStudent.getStudentID();
			Iterator<InterestSubjectListDTO> iter = ExData.interestSubjectListSet.iterator();
			while (iter.hasNext()) {

				InterestSubjectListDTO interstDTO = iter.next();
				if (thisStudentID.equals(interstDTO.getStudentID())) { // 현재 로그인한 학생의 학번.
					if (UtilAboutCodeFind.findGeneralSubject(interstDTO.getSubjectCode()) == null) {
						// 전공
						MajorSubjectDTO mDTO = UtilAboutCodeFind.findMajorSubject(interstDTO.getSubjectCode());
						if (subjectName.equals(
								UtilAboutCodeFind.findMajorSubject(interstDTO.getSubjectCode()).getSubjectName())) {
							String subCode = interstDTO.getSubjectCode();
							//학점추가...
							if(Enrolement.loginStudent.isGradesRight(Integer.parseInt(UtilAboutCodeFind.findMajorSubject(subCode).getGrades()))) {
								for(int i =0; i<ExData.studentList.size();i++) {
									StudentDTO sDTO = ExData.studentList.get(i);
									if(thisStudentID.equals(sDTO.getStudentID())) {
										sDTO.setApplyCredit(sDTO.getApplyCredit()
												+Integer.parseInt(UtilAboutCodeFind.findMajorSubject(subCode).getGrades()));
										break;
									}
								}
							}else {
								System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆☆★★");
								System.out.println("\t☆★신청가능학점을 초과하였습니다☆★");
								System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
								return;
							}
							if (!ExData.finalEnrolementList.add(UtilAboutCodeFind.changeF(interstDTO))) {
								System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆");
								System.out.println("이미 수강신청하신 과목입니다.");
								System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆");
								continue;
							}
							System.out.println("☆★신청하였습니다.☆★");
							UtilAboutFile.finalEnrolementSave(ExData.finalEnrolementList);
							count--;
						}
					} else if (UtilAboutCodeFind.findMajorSubject(interstDTO.getSubjectCode()) == null) {
						// 교양
						if (subjectName.equals(
								UtilAboutCodeFind.findGeneralSubject(interstDTO.getSubjectCode()).getSubjectName())) {
							//학점기능...
							if(Enrolement.loginStudent.isGradesRight(
									UtilAboutCodeFind.findGeneralSubject(interstDTO.getSubjectCode()).getGrades())) {
								for(int i =0; i<ExData.studentList.size();i++) {
									StudentDTO sDTO = ExData.studentList.get(i);
									if(thisStudentID.equals(sDTO.getStudentID())) {
										sDTO.setApplyCredit(sDTO.getApplyCredit()
												+
												UtilAboutCodeFind.findGeneralSubject(interstDTO.getSubjectCode()).getGrades());
										break;
									}
								}
							}else {
								System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆☆★★");
								System.out.println("\t☆★신청가능학점을 초과하였습니다☆★");
								System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
								return;
							}
							// 포인트 처리
							String k = "";
							while (true) {
								System.out.println("\t★☆★☆★☆★☆★☆★★☆");
								System.out.println("\t★☆뒤로가기 : 0  ★☆");
								System.out.println("\t★☆★☆★☆★☆★☆★☆★");
								System.out.print("지불할 포인트를 입력하세요(숫자만 입력하세요) : ");
								k = sc.nextLine();
								try {
									Integer.parseInt(k);
									if(k.equals("0")) {
										break;
									}
								} catch (NumberFormatException e) {
									System.out.println("☆★☆★☆★☆★☆☆★☆★☆★☆★☆★☆★");
									System.out.println("☆★정확한 숫자를 입력해주세요.☆★");
									System.out.println("☆★☆★☆★☆☆★☆★☆★☆★☆★☆★☆★");
									pause();
									continue;
								}
								int payPoint = Integer.parseInt(k);
								if (isMyPointOK(payPoint)) {
									// 내가가진 포인트보다 작으면
									System.out.printf("\t★☆현재포인트 : %s★☆\n", Enrolement.loginStudent.getHoldingPoint());
									System.out.printf("\t★☆지불할 포인트가 %sp 부족합니다.★☆",
											payPoint - Enrolement.loginStudent.getHoldingPoint());
									continue;
								}
								if (payPoint >= UtilAboutSubject
										.interestSubjectApplyCount(interstDTO.getSubjectCode())) {
									// 포인트 범위 정상...
									StudentDTO sDTO = Enrolement.loginStudent;
									sDTO.setHoldingPoint(sDTO.getHoldingPoint() - payPoint);
									Iterator<GeneralSubjectDTO> it = ExData.generalSubjectList.iterator();
									while (it.hasNext()) {
										GeneralSubjectDTO g = it.next();
										if (subjectName.equals(g.getSubjectName())) {
											ExData.pointUseList.add(
													new PointUseDTO(sDTO.getStudentID(), g.getSubjectCode(), payPoint));
											UtilAboutFile.pointUseSave(ExData.pointUseList);
											break;
										}
									}
									break;
								} else {
									// 해당 포인트가 최소포인트보다 낮으면... 신청안됨...
									System.out.println("\t☆★최소 포인트보다 높은 포인트를 지불해야 신청이 가능합니다.☆★");
									continue;
								}
							}
//							//학점추가...
//							if(Enrolement.loginStudent.isGradesRight(
//									UtilAboutCodeFind.findGeneralSubject(interstDTO.getSubjectCode()).getGrades())) {
//								for(int i =0; i<ExData.studentList.size();i++) {
//									StudentDTO sDTO = ExData.studentList.get(i);
//									if(thisStudentID.equals(sDTO.getStudentID())) {
//										sDTO.setApplyCredit(sDTO.getApplyCredit()
//												+
//												UtilAboutCodeFind.findGeneralSubject(interstDTO.getSubjectCode()).getGrades());
//										break;
//									}
//								}
//							}else {
//								System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆☆★★");
//								System.out.println("\t☆★신청가능학점을 초과하였습니다☆★");
//								System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
//								return;
//							}

							if (!ExData.finalEnrolementList.add(UtilAboutCodeFind.changeF(interstDTO))) {
								System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆");
								System.out.println("이미 수강신청하신 과목입니다.");
								System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆");
								continue;
							}
							System.out.println("☆★신청하였습니다.☆★");
							UtilAboutFile.finalEnrolementSave(ExData.finalEnrolementList);
							count--;
						}
					}
				}
				count++;
				if (count == ExData.interestSubjectListSet.size()) {
					System.out.println("잘못입력하셨습니다. 정확한 과목명을 입력해주시기 바랍니다.");
				}

			}
		}
	}// 메소드
	
	/**
	 * 수강신청을 구현하는 메인 UI메소드이다.
	 */
	public void doEnUI() {
		System.out.println("1. [관심과목에서 신청하기]");
		System.out.println("2. [전체과목에서 신청하기]");
		System.out.println("3. [수강 취소하기]");
		System.out.println("0. [뒤로가기]");
		System.out.print("입력 : ");
	}
	/**
	 * 프로그램 흐름상 잠시 중단할 떄가 있을 때 사용하는 메소드이다.
	 */
	public void pause() {
		System.out.println("\t---------------------------");
		System.out.println("\t계속 진행하시려면 엔터를 눌러주세요...");
		System.out.println("\t---------------------------");
		sc.nextLine();
	}
	/**
	 * 로그인한 학생의 남은 포인트가 지불한 과목의 포인트에 유효한 범위인지를 검사한다.
	 * @param payPoint 지불포인트
	 * @return 지불포인트보다 많으면 true, 적으면 false
	 */ 
	public boolean isMyPointOK(int payPoint) {
		if (Enrolement.loginStudent.getHoldingPoint() < payPoint) {
			return true;
		} else
			return false;
	}
}

# 포인트 베팅 수강신청(Java Console)
포인트 베팅을 통한 수강신청 방식 콘솔프로그램<br>
<b>기간 : 2018.08.13~2018.08.17(40시간)</b><br>
<b>환경 : Windows 10</b><br>
<b>주제 : 대학교 수강신청 시스템</b><br>
<b>개발 : Eclipse Photon</b><br>
<b>사용 언어 : JAVA(JDK 1.8)</b><br>
<b>사용 기술 : File I/O</b>

# 프로젝트 상세내용
## 주제
<pre>
* 포인트 베팅을 통한 수강신청 방식 콘솔프로그램
</pre>

## 목적
<pre>
1. 국내 대학교의 평범한 수강신청의 형식을 벗어나 보자.<br>
2. 선착순 위주의 수강신청의 문제점인 서버 다운 현상을 줄여보자<br>
3. 선착순 위주의 수강신청이 아닌 기간 내에 심사숙고 결정할 수 있는 수강신청을 만들어보자<br>
4. 시간, 개인의 컴퓨터 속도, 장소에 구속하지 않는 수강신청.
</pre>

## 구현 목표
* 학생
<pre>
* 로그인한 학생의 정보에 따라 전공이 다르게 표시<br>
* 예비수강신청 후 관심목록에 출력<br>
* 관심목록에 최소 요구 포인트를 표시<br>
* 나의 보유 포인트 확인과 포인트 내역 동시확인<br>
* 포인트를 지출하여 수강신청<br>
* 공지사항 확인, 의견작성 후 제출
</pre>
* 관리자
<pre>
* 학생의 정보를 등록,수정,삭제,검색,읽기 할 수 있다.<br>
* 교수의 정보를 등록,수정,삭제,검색,읽기 할 수 있다.<br>
* 수강과목의 정보를 등록,수정,삭제,검색,읽기 할 수 있다.<br>
* 학과의 정보를 등록,수정,삭제,검색,읽기 할 수 있다.<br>
* 강의실의 정보를 등록,수정,삭제,검색,읽기 할 수 있다.<br>
* 다른 학생의 모의 수강신청을 진행하여 테스트할 수 있도록 한다.

</pre>

## Exerd 테이블 명세
<img src="https://github.com/WooSungHwan/Point-betting-enrollment-application/blob/master/%EC%88%98%EA%B0%95%EC%8B%A0%EC%B2%AD%20%EC%BA%A1%EC%B2%98%EC%82%AC%EC%A7%84/ERD.PNG">

## 구동 화면
* 수강신청화면 포인트 사용<br><br>
<img src="https://github.com/WooSungHwan/Point-betting-enrollment-application/blob/master/%EC%88%98%EA%B0%95%EC%8B%A0%EC%B2%AD%20%EC%BA%A1%EC%B2%98%EC%82%AC%EC%A7%84/%EC%88%98%EA%B0%95%EC%8B%A0%EC%B2%AD%ED%8F%AC%EC%9D%B8%ED%8A%B8%EC%82%AC%EC%9A%A9%ED%99%94%EB%A9%B4.PNG">
* 수강신청 완료화면<br><br>
<img src="https://github.com/WooSungHwan/Point-betting-enrollment-application/blob/master/%EC%88%98%EA%B0%95%EC%8B%A0%EC%B2%AD%20%EC%BA%A1%EC%B2%98%EC%82%AC%EC%A7%84/%EC%88%98%EA%B0%95%EC%8B%A0%EC%B2%AD%20%EC%99%84%EB%A3%8C%ED%95%9C%20%ED%99%94%EB%A9%B4.PNG">
* 포인트 사용 내역<br><br>
<img src="https://github.com/WooSungHwan/Point-betting-enrollment-application/blob/master/%EC%88%98%EA%B0%95%EC%8B%A0%EC%B2%AD%20%EC%BA%A1%EC%B2%98%EC%82%AC%EC%A7%84/%EC%88%98%EA%B0%95%EC%8B%A0%EC%B2%AD%ED%8F%AC%EC%9D%B8%ED%8A%B8%EC%82%AC%EC%9A%A9%EB%82%B4%EC%97%AD.PNG">
* 교과과목 확인하기<br><br>
<img src="https://github.com/WooSungHwan/Point-betting-enrollment-application/blob/master/수강신청%20캡처사진/교과과목%20확인하기.PNG">
* 모의수강신청<br><br>
<img src="https://github.com/WooSungHwan/Point-betting-enrollment-application/blob/master/수강신청%20캡처사진/모의수강신청진행중.PNG">

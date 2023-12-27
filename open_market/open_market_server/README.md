# spring-boot 오픈마켓 프로젝트

## Framework
- Spring-Boot 2.7.14

## Front-End Template
- Thymeleaf

## Dependency
- JPA
- Lombok
- Mysql-Connector-j
- Spring-Web
- Spring-boot-devtools

## DB
- MySQL 8.0.31
- MySQL Workbench

## IDE
- Intelli J

## 메인 기능
1. 회원가입
- 유효성검증
- 아이디 not null, PK
- 패스워드 not null, 특수문자 영대소문자, 숫자 조합 8자 이상
- 이름 not null
- 닉네임 not null
- 핸드폰번호
- 예치금

2. 로그인
- 아이디, 패스워드를 통한 로그인
- 둘 중 하나가 틀리면 로그인 정보 확인 alert 알림

3. 아이디 / 비밀번호 찾기
- (임시) 핸드폰번호를 이용해서 아이디 찾기
- (임시) 아이디, 핸드폰번호를 이용해서 비밀번호 찾기

4. 마이페이지
- 구매 내역 조회
- 판매 내역(글) 조회
- 예치금 충전, 보유 예치금 확인
- 회원 정보 수정
- 찜 내역 조회

5. 관리자페이지
- 회원 정보 조회
- 신고 접수 확인
- 게시글 삭제 권한

6. 상품 업로드
- 이미지 업로드
- 이미지 업로드는 여러 이미지를 업로드할 수 있지만, 대표 이미지는 첫번째 이미지로 설정
- 상품 설명
- 가격 설정

7. 상품 문의
- 판매글에 댓글 남기기(비밀글, 공개글 선택)

8. 상품 구매
- 상품 구매시 구매된 상품은 품절 표시
- 찜하기 기능

9. 상품 판매
- 판매자는 보유 예치금으로 판매 가격 입금받기

10. 소통 게시판
- 전체 게시글, 인기글 두가지 카테고리
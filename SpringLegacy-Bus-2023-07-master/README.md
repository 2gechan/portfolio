# bus_back_spring_legacy 팀 프로젝트
- 시외버스 API를 이용한 springLegacy Project
- 일부 노후화된 터미널이나 버스 정류장에서 탑승하는 승객들을 위해 정류하는 시외버스 시간표를 웹을 통해 언제 어디서나 편하게 갱신된 시간표를 확인하기 위한 프로젝트

## Framework
- Spring3

## IDE
- STS3

# 개발 도구

## Front-End
- JSP, CSS, JavaScript

## Back-End
- SpringFramework, MySQL, Mybatis

## Dependency
- Spring JDBC
- Commons DBCP2
- Mybatis
- Mybatis Spring
- Mysql-connector-j
- OJDBC
- SimpleJSON
- Lombok

# 프로젝트 주요 기능

## 터미널(버스정류장) 위치 조회
- 카카오 오픈 API를 이용하여 버스 정류장 이름을 통해 위치 조회

## 버스 시간표 조회
- 광주 시외버스 오픈 API를 이요하여 현재 시간 기준으로 버스 시간표 조회

## 즐겨찾기
- 자신이 자주 이용하는 버스 정류장을 즐겨찾기 기능을 통해 빠른 조회

## 회원가입, 로그인
- 즐겨찾기 기능은 회원만 가능하게 구현했기 때문에 간단한 기본정보를 입력한 회원가입, 로그인

## 예매사이트 이동
- 광주에서 시외로 나가는 버스만을 조회하도록 구현하여 광주 유스퀘어 예매사이트로 페이지 이동
# 스프링 시작
2021-12-13

## 프로젝트 생성
### java11
### IDE:IntelliJ

## 스프링 부트 스타터 사이트로 이동해서 스프링 프로젝트 생성
https://start.spring.io

## 프로젝트 선택
- Project: Gradle Project
- Spring Boot: 2.3.x
- Language: Java
- Packaging : Jar
- Java: 11
- Dependencies : Spring Web, Thymeleaf

## IntelliJ Gradle 대신에 자바 직접 실행
- 최근 IntelliJ 버전은 Gradle을 통해서 실행 하는 것이 기본 설정이다. 이렇게 하면 실행속도가 느리다. 
- 다음과 같이 변경하면 자바로 바로 실행해서 실행속도가 더 빠르다.

![setting](https://user-images.githubusercontent.com/33935620/145812896-6396e888-f6dd-4aa7-9df4-3f9bd479eebc.PNG)

스프링 부트 (위에 스프링 부트 링크로 들어갈 수 있음)
![springboot](https://user-images.githubusercontent.com/33935620/145813641-eed3f189-9656-4041-9bf8-9f7746cd426b.PNG)

## 정적 컨텐츠

현재 static/hello-static.html이 있을 때
그 파일 자체를 그대로 넘겨줌. (내용 변화 없이).

## MVC와 템플릿 엔진
MVC 스타일
관심사를 분리해야 한다.
MVC : Model View Controller
View는 화면을 그리는데 집중해야한다.
Controller는 비즈니스 로직, 내부적 처리에 집중해야 한다.

## 스프링 빈을 등록하고, 의존관계 설정
생성자에 @Autowired 가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다.
객체 의존 관계를 외부에서 넣어주는 것을 DI, 의존성 주입이라 한다.

### 스프링 빈을 등록하는 2가지 방법
- 컴포넌트 스캔과 자동 의존관계 설정
- 자바 코드로 직접 스프링 빈 등록하기

스프링은 스프링 컨테이너에 스프링 빈을 등록 할 때, 기본으로 싱클톤으로 등록한다.

## 2021-12-16
회워 서비스와 회원 레포지토리의 @Service, @Repository, @Autowired 애노테이션을 제거하고 진행
SpringConfig를 만들어서 그 안에서 등록

## JPA
- JPA는 기존의 반복 코드는 물론이고 기본적인 SQL도 JAP가 직접 만들어서 실행해준다.
- JPA를 사용하면, SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환을 할 수 있다.
- JPA를 사용하면 개발 생산성을 크게 높일 수 있다. 

## SpringDataJPA
- 인터페이스를 통한 기본적인 CRUD
- findByName(), findByEmail() 처럼 이름만으로 조회 기능 제공
- 페이징 기능 자동 제공

## AOP
- 회원가입, 회원 조회 등 핵심 관심 사항과 시간 측증하는 공통 관심 사항을 분리한다.
- 핵심 관심 사항을 깔끔하게 유지할 수 있다.
- 원하는 적용 대상을 선택 할 수 있다.
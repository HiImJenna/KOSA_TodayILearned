# 2022.12.13.TUE 📅
----------------
<br>

# 1. MAVEN ✔
- https://mvnrepository.com/
- 쿼리 기반 웹 애플리케이션을 개발할 때 가장 많이 사용되는 SQL 매퍼(Mapper) 프레임워크.
#### ✨ 쉬운 이해는 아래에서 코드 보면서!! 
<br>

### [기존]
![image](https://user-images.githubusercontent.com/111114507/207293799-0ca96d50-3bcb-493e-9ae7-7fb7faba7acc.png)
- 내가 하나하나 추가해줬어야함
- 의존성으로 인해서 관련된 모든것들을 추가해줘야 하기에 굉장히 귀찮고 불편함
<br>

### [pom.xml]
```xml
	<properties>
		<java-version>1.8</java-version>
		<org.springframework-version>5.3.6</org.springframework-version>
		<org.aspectj-version>1.6.10</org.aspectj-version>
		<org.slf4j-version>1.6.6</org.slf4j-version>
	</properties>
	<repositories>
		<repository>
			<id>oracle</id>
			<name>ORACLE JDBC Repository</name>
			<url>http://maven.jahia.org/maven2</url>
		</repository>
	</repositories>
	<dependencies>
		<!-- Spring -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${org.springframework-version}</version>
			<exclusions>
				<!-- Exclude Commons Logging in favor of SLF4j -->
				<exclusion>
					<groupId>commons-logging</groupId>
					<artifactId>commons-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${org.springframework-version}</version>
		</dependency>

```
![image](https://user-images.githubusercontent.com/111114507/207293162-d0727b04-7938-440d-b5e0-2f2e19d7de60.png)
- Maven을 사용하면 알아서 의존성을 가진 친구들까지 추가해주기 때문에 (사진처럼) 편리함!


# 2. MyBatis ✔
- 학습사이트 : https://mybatis.org/mybatis-3/ko/index.html
- 마이바티스는 개발자가 지정한 SQL, 저장프로시저 그리고 몇가지 고급 매핑을 지원하는 퍼시스턴스 프레임워크
- 마이바티스는 JDBC로 처리하는 상당부분의 코드와 파라미터 설정및 결과 매핑을 대신해준다.
- 마이바티스는 데이터베이스 레코드에 원시타입과 Map 인터페이스 그리고 자바 POJO 를 설정해서 매핑하기 위해 XML과 애노테이션을 사용할 수 있다.

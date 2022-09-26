## 2022.09.26.MON 📅
----------------
<br>

### 1. 1차프로젝트 조별 발표 ✔
<br>

### 2. Oracle ✔
<br>

#### 🔔 Oracle 버전
- [Express Edition] : 개발 및 배포가 자유로움 (무료)  
![image](https://camo.githubusercontent.com/297829349af8be25e4e0f8799452b0d0cd3a58031e5385a0a153a69deb74300e/68747470733a2f2f706f737466696c65732e707374617469632e6e65742f32303134303832385f3235332f6974755f6974755f3134303932313330323237363174336a37465f4a5045472f2542462543302542362546332543352541432542392546362543302546432542412542302543322546372543302543432543312541315f312e6a70673f747970653d7732)
<br>

- [Standard Edition One] : 현업 주로 사용  
![image](https://camo.githubusercontent.com/3c64fb2e2d5fc48254d5236813f1bbddee0db160b7bcccadf2f259f965657d99/68747470733a2f2f706f737466696c65732e707374617469632e6e65742f32303134303832385f3234342f6974755f6974755f31343039323133303233333935754d47566b5f4a5045472f2542462543302542362546332543352541432542392546362543302546432542412542302543322546372543302543432543312541315f322e6a70673f747970653d7732)
<br>

- [Standard Edition] : 현업 주로 사용  
![image](https://camo.githubusercontent.com/c60681d0573d909e511663f7c11cac47963cf44863a1f6d7fe9094b1282d6bcb/68747470733a2f2f706f737466696c65732e707374617469632e6e65742f32303134303832385f3234362f6974755f6974755f31343039323133303233313232663164786f5f4a5045472f2542462543302542362546332543352541432542392546362543302546432542412542302543322546372543302543432543312541315f332e6a70673f747970653d7732)
<br>

- [Enterprise Edition] : 큰 기업에서 사용  
![image](https://camo.githubusercontent.com/21a6854283b1de4b700a01027786e1dcf12eedb29228467790eab754a8b71cd1/68747470733a2f2f706f737466696c65732e707374617469632e6e65742f32303134303832385f3139312f6974755f6974755f313430393231333032343333337a6b6d374d5f4a5045472f2542462543302542362546332543352541432542392546362543302546432542412542302543322546372543302543432543312541315f342e6a70673f747970653d7732)
<br>

- [전체 비교]  
![image](https://camo.githubusercontent.com/c3f019cb101d8f7ea4cf4a40ba1c74f12d362d72617ee9335dc7d0cea47cc825/68747470733a2f2f706f737466696c65732e707374617469632e6e65742f32303134303832385f3139332f6974755f6974755f3134303932313330323430363148613470735f4a5045472f2542462543302542362546332543352541432542392546362543302546432542412542302543322546372543302543432543312541315f352e6a70673f747970653d7732)
<br>

#### 🔔 Oracle SQL developer
![imgae](https://user-images.githubusercontent.com/92353613/192208966-be028bbe-7c2d-4f85-981f-3287efc8cbc7.png)  
▶ 접속 허용!  
<br>  

![image](https://user-images.githubusercontent.com/92353613/192213860-f591d60c-27a5-4d83-95e3-2a9580a34fb4.png)    
▶HR의 employees 더미데이터 출력  


### 🔔 1일차 수업
1. 오라클 소프트웨어 다운로드 : 
https://www.oracle.com/technetwork/database/enterprise-edition/downloads/index.html
2. Oracle Database 11g Release 2 Express Edition for Windows 64 (무료설치)  
3. Oracle 설치(SYS, SYSTEM 계정의 대한 암호 : 1004)  
4.Sqlplus 프로그램 제공(CMD) : GUI 환경 일반개발자 사용 불편  
5.별도의 Tool 설치 무료(SqlDeveloper , https://dbeaver.io/),  
                 유료(토드 , 오렌지 , SqlGate) 프로젝트시 설치 활용 ^^  
6. SqlDeveloper 툴을 통해서 Oracle Server 접속 ....  
   -> HR 계정 : 암호 1004 , Unlock 2가지 사용가능 .... (사원관리 실습 테이블)  
   -> 새로운 계정 : KOSA  

```sql
-- USER SQL  
ALTER USER "HR" IDENTIFIED BY 1004   
DEFAULT TABLESPACE "USERS"  
TEMPORARY TABLESPACE "TEMP"  
ACCOUNT UNLOCK ;  

-- QUOTAS  
ALTER USER "HR" QUOTA UNLIMITED ON USERS;  

-- ROLES  
ALTER USER "HR" DEFAULT ROLE "RESOURCE","CONNECT";  

-- SYSTEM PRIVILEGES  

7. 현재 접속 계정 확인 : show user;   >> USER이(가) "KOSA"입니다.  

-- USER SQL  
CREATE USER "KOSA" IDENTIFIED BY "1004"    
DEFAULT TABLESPACE "USERS"  
TEMPORARY TABLESPACE "TEMP";  

-- QUOTAS  
-- ROLES  
GRANT "CONNECT" TO "KOSA" WITH ADMIN OPTION;  
GRANT "RESOURCE" TO "KOSA" WITH ADMIN OPTION;  
ALTER USER "BITUSER" DEFAULT ROLE "CONNECT","RESOURCE";  
-- SYSTEM PRIVILEGES 
``` 
<br>

### 🔔 [실습코드]

```sql
CREATE TABLE EMP
(EMPNO number not null,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR number ,
HIREDATE date,
SAL number ,
COMM number ,
DEPTNO number );
--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,200,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,'1981-04-02',2975,30,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,300,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,'1981-04-01',2850,null,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,'1981-06-01',2450,null,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,'1982-10-09',3000,null,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',null,'1981-11-17',5000,3500,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,'1983-01-12',1100,null,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,'1981-10-03',950,null,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,'1981-10-3',3000,null,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);

commit;                                                     --COMMIT 해야 데이터 입력 완료됨

select * from emp;                                          --emp 테이블 출력
```
[출력값] :   
![image](![image](https://user-images.githubusercontent.com/111114507/192230088-19b8b3bc-adac-480d-a977-d8990df4e752.png)
<br>

#### - select * from dept;
![image](https://user-images.githubusercontent.com/111114507/192231155-637ffa88-cac8-43ae-8eab-bb4f700b8377.png)
<br>

#### - select * from salgrade;
![image](https://user-images.githubusercontent.com/111114507/192232257-1c91c83b-6860-4f31-825b-30ac7ed630ad.png)
<br>


### 🔔 문법
#### - 쿼리는 대소문자 구별 x
```sql
select * from emp;
SELECT * FROM emp;
```
<br>

#### - 특정 컬럼 데이터 출력하기
```sql
select empno, ename, sal
from emp;

select ename from emp;
```
출력값 :  
![image](https://user-images.githubusercontent.com/111114507/192233496-d086cfc4-ae26-4493-8ea3-a6cb575f02c7.png)
<br>

#### - 컬럼명 가명칭(alias) 별칭 부여하기
```sql
select empno 사번, ename 이름
from emp;
```

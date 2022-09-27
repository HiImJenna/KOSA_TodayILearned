# 2022.09.27.TUE 📅
----------------
<br>

## 1. 연산자 ✔
<br>

### 🔔 비교연산자
- < , > , <= , =>
- = : 같다 (자바의 == 처럼)

### 🔔 논리연산자
- AND , OR , NOT

```sql
select empno, ename, sal
from emp
where sal >= 2000;
```
![image](https://user-images.githubusercontent.com/111114507/192404248-14a88322-56ac-4522-a030-368391467d69.png)
<br>

#### Q) 사번이 7788번인 사원의 사번, 이름, 직종, 입사일을 출력하세요.
```sql
select empno, enmae, jpb, hiredate
from empno
where empno == 7788
```
출력값 :  
![image](https://user-images.githubusercontent.com/111114507/192404435-3b0ce141-761c-465e-afc4-dd1661b362ef.png)
<br>

#### Q) 사원의 이름이 king인 사원의 사번, 이름, 급여 정보를 출력하세요.
```sql
select empno, ename, sal 
from emp
where ename = 'KING';
```
<br>

#### Q) 급여가 2000달러 이상이면서 직종이 manager인 사원의 모든 정보를 출력하세요.
```sql
select * from emp
where sal >= 2000 and job = 'MANAGER';
```

## 2. 날짜 ✔
- sysdate 사용
- DB 서버의 날짜
<br>

```sql
select sysdate from dual; --22/09/27
```
```sql
select * from nls_session_parameters;
```
![image](https://user-images.githubusercontent.com/111114507/192406201-a4c13acd-bf72-4367-abd5-0a119fbf864a.png)
▶현재 접속한 사용자(session)가 가지는 환경정보  
<br>

```sql
alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';
select sysdate from dual; --2022-09-27 09:53:19
```
- 변경정보는 현재 오라클 서버에 접속한 사용자의 작업 환경 설정
- 그래서 접속을 끊었다가 다시 연결하면 원래 상태로 복원(RR-MM-DD)
<br>

```sql
select hiredate from emp;
```
![image](https://user-images.githubusercontent.com/111114507/192407512-2b73f318-b55f-45eb-8151-ad53b1861b70.png)
<br>

```sql
select *
from emp
where hiredate = '1980-12-17';
```
▶ 날짜는 ' ' 으로 감싸기
<br>

```sql
select *
from emp
where hiredate = '1980/12/17'; --인정

select *
from emp
where hiredate = '1980.12.17'; --인정
```
```sql
select *
from emp
where hiredate = '80.12.17'; --인정 X
```
<br>

### Q) 사원의 급여가 2000 이상이고 4000 이하인 모든 사원의 정보를 출력하세요.
```sql
select * 
from emp
where sal >= 2000 and sal <= 4000;
```
▶ 중복코드  
<br>

```sql
select *
from emp
where sal between 2000 and 4000;
```
▶ between은 이상, 이하 -> 초과, 미만의 조건일 때는 사용 불가 
<br>

#### Q) 부서번호가 10번 또는 20번 또는 30번인 사원의 사번, 이름, 급여, 부서번호를 출력하세요.
```sql
select *
from emp
where depno = 10 or depno = 20 or depno = 30;
```
▶ 중복코드  
<br>

```sql
select * 
from emp
where deptno in (10, 20, 30);
```
<br>

### Q) 부서번호가 10번 또는 20번이 아닌 사원의 사번, 이름, 급여, 부서번호를 출력하세요.
```sql
select *
from emp
where deptno != 10 and deptno != 20; --두가지 조건 모두 만족

select *
from emp
where deptno where(10,20);
-- not in >> != .. and
```

## 3. creat table ... ✔
```sql
create table member(
 userid varchar2(20) not null, --null을 허용하지 않겠다 (필수입력)
 name varchar2(20) not null, -- 이름은 필수입력 받겠다. (필수입력)
 hobby varchar2(50) -- default null 허용 : 선택적 입력사항
);
```

-DML(데이터 조작어) : insert, update, delete
-오라클 실제 반영을 위해서 개발자에게 : commit, rollback 강제
-Ms-sql, Mysql default commit >> begin 명시 DML 작업 ... 

```sql
commit; --명령(insert, update, delete) 실제 반영
```
<br>

### Q) 수당(comm)을 받지 않는 모든 사원의 정보를 출력하세요.
```sql
select comm from emp where comm = null; -- 존재하지 않는 문법

--null 비교는 (is null, is not null) 
select comm from emp where comm is null;

select * from emp where comm is not null; -- 수당을 받는 사람들
```
<br>

### Q) 사원테이블에서 사번, 이름, 급여, 수당, 총급여(급여+수당)를 출력하세요.
```sql
select empno, ename, sal, comm, sal + comm as"총급여"
from emp;
```
![image](https://user-images.githubusercontent.com/111114507/192415122-1d9b3ec4-f83c-4f01-ab89-298604c3445a.png)
<br>

### 🔔 null
- null과의 모든 연산의 결과는 null ex) 100 + null = null
- 위 문제를 해결하기 위해서 함수 : nvl(), nvl2()  / ex) nvl(컬럼명, 대체값) > 치환
```sql
select 1000 + nvl(null,0) from dual;
select comm, nvl(comm, 111111) from emp;
select nvl(null, 'hello world') from dual
```

#### Q) 사원의 급여가 1000 이상이고 수당을 받지 않는 사원의 사번, 이름, 직종, 급여, 수당을 출력하세요.
```sql
select empno, ename, job, sal, comm
from emp
where sal >= 1000 and comm is null;
```
<br>

## 4. 문자열 검색 ✔
### 🔔 Like : 문자열 패턴 검색 연산자
#### [A를 포함하는 모든 데이터]
```sql
select *
from emp
where ename like '%A%';
```
<br>

#### [A로 시작]
```sql
select *
from emp
where ename like 'A%';
```
<br>

#### [A로 끝]
```sql
select *
from emp
where ename like '%A';
```
<br>

#### [AA 포함]
```sql
select *
from emp
where ename like '%AA%';
```
<br>

#### [A 떨어지든 붙든 두개]
```sql
select *
from emp
where ename like '%A%A%';
```
<br>

#### [A가 두번째]
```sql
select *
from emp
where ename like '%_A%';
```
<br>

## 5. 정렬 ✔
- order by 컬럼명 : 문자, 숫자, 날짜 정렬
- 오름차순 : asc: 낮은순 : default
- 내림차순 : desc : 높은순
- 비용cost : 많이 드는 작업
<br>

### Q) 입사일이 가장 높은 순으로 정렬해서 사번, 이름, 급여, 입사일을 출력하세요.
```sql
select empno, ename, sal, hiredate
from emp
order by hiredate desc;
```
[출력값] :  
![image](https://user-images.githubusercontent.com/111114507/192424154-b9d11705-e419-47fb-9c28-3f6d8eba9ccf.png)
<br>

```sql
select empno, ename
from emp
order by ename asc;
```
[출력값] :   
![image](https://user-images.githubusercontent.com/111114507/192424271-9082f4ba-27e6-40b7-be57-1924892c28b2.png)
<br>

[실행순서]
```sql
select 절   3
from 절     1
where 절    2
order by 절 4 (select 한 결과를 정렬)
```
<br>

```sql
select job, deptno
from emp
order by job asc, deptno desc;
-- Order by 컬럼명 asc, 컬럼명 asc ... 
```
[출력값] :  
![image](https://user-images.githubusercontent.com/111114507/192437035-c6d6e0b7-19eb-49a9-9cbd-41ccb67450fd.png)
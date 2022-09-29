# 2022.09.29. THU 📅
----------------
<br>

## 1. subquery ✔
----------------------
<br>

#### Q) 사원테이블에서 사원들의 평균 월급보다 더 많은 월급을 받는 사원의 사번, 이름, 급여
```sql
select empno, ename, sal
from emp
where sal > avg(Sal);
```
▶ 실행 안됨 -> where sal > avg(Sal) 부분 문제..   
<br>

[해결1] : avg(sal)대신 2073    
```sql
select empno, ename, sal
from emp
where sal > 2073;
```
<br>  

[해결2] : 2개의 쿼리를 하나로 통합   
```sql
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp);
```
<br>

### 🔔 single row subquery  
- 실행결과가 단일 row + 단일 colum일 경우 (한개의 반환)
- ex) select avg(sal) from emp
- 연산자 : ( = != < >)
<BR>

### 🔔 multi row subquery
- 실행결과가 단일 column + row 여러개인 경우
- ex) select sal from emp
- 연산자 : IN NOT IN ANY ALL
- ALL : SAL > 1000 AND SAL > 4000 AND ...
- ANY : SAL > 1000 OR SAL > 4000 OR ... 

### 🔔 < 문법 >
1. 괄호 안에 있어야한다 -> (SELECT MAX(SAL) FROM EMP)
2. 단일 컬럼으로 구성 >> SELECT MAX(SAL), SUM(SAL) FROM EMP(X)
3. 단독으로 실행 가능
<br>

#### Q) 사원테이블에서 jones의 급여보다 더 많은 급여를 받는 사원의 사번, 이름, 급여를 출력하세요.
[single row subquery]
```sql
select sal from emp where ename = 'JONES'; --2975

select *
from emp
where sal > (select sal from emp where ename = 'JONES') ;
```
<br>

[multi row subquery]
```sql
select *
from emp
where sal in (select sal from emp where deptno = 30);
```
▶ = 대신 in 사용
<br>

#### Q) 부하직원이 있는 사원의 사번과 이름을 출력하세요
```sql
select mgr from emp; --multi
select *
from emp
where empno in (select mgr from emp);
```
▶ where empno = 7902 or empno = 7788 or empno = null (or연산에서 null이 문제 X)
<br>

#### Q) 부하직원이 없는 사원의 사번과 이름을 출력하세요
```sql
select mgr from emp;
select *
from emp
where empno not in (select mgr from emp);
```

▶ not in을 사용했지만 실행되지 않음 
-  not in은 부정에 and

[해결] :   
```sql
select mgr from emp;
select *
from emp
where empno not in (select nvl(mgr,0) from emp);
```
<br>

#### Q) king 에게 보고하는 즉 직속상관이 king인 사원의 사번, 이름, 직종, 관리자사번을 출력하세요
```sql
select empno, ename, job, mgr
from emp
where mgr = (select empno from emp where ename='KING');
```
<br>

#### Q) 20번 부서의 사언중에서 가장 많은 급여를 받는 사원보다 더 많은 급여를 받는 사원의 사번, 이름, 급여, 부서번호를 출력하세요.
```sql
select max(sal)
from emp
where deptno = 20;

select empno, ename, sal, deptno
from emp
where sal > (select max(sal) from emp where deptno = 20);
```
<br>

#### Q) 자기 부서의 평균 월급보다 더 많은 월급을 받는 사원의 사번, 이름, 부서번호, 부서별 평균 월급을 구하세요.
```sql
select e.empno, e.ename, e.deptno, e.sal, s.svgsal
from emp e join (select deptno, round(avg(sal), 0) as avgsl from emp group by deptno)
on e.deptno = s.deptno
where e.sal > s.avgsal;
```
<br>

### 🔔 문제풀이

#### Q1) 'SMITH'보다 월급을 많이 받는 사원들의 이름과 월급을 출력하라.
```sql
select sal from emp where ename = 'SMITH';

select ename, sal
from emp
where sal > (select sal from emp where ename = 'SMITH');

```
<br>

#### Q2) 10번 부서의 사원들과 같은 월급을 받는 사원들의 이름, 월급, 부서번호를 출력하라.
```sql
select sal from emp where deptno = 10;

select ename, sal, deptno
from emp
where sal in (select sal from emp where deptno = 10);
```
<br>


#### Q3) 'BLAKE'와 같은 부서에 있는 사원들의 이름과 고용일을 뽑는데 'BLAKE'는 빼고 출력하라.
```sql
select deptno from emp where ename = 'BLAKE';

select ename, hiredate
from emp
where deptno = (select deptno from emp where ename = 'BLAKE') and ename != 'BLAKE';
```
<br>


#### Q4) 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을 출력하되, 월급이 높은 사람 순으로 출력하라.
```sql
select avg(sal) from emp;

select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
order by sal desc;
```
<br>


#### Q5) 이름에 'T'를 포함하고 있는 사원들과 같은 부서에서 근무하고 있는 사원의 사원번호와 이름을 출력하라.
```sql
select deptno from emp where ename like '%T%';

select empno, ename
from emp
where deptno in (select deptno from emp where ename like '%T%');
```
<br>


#### Q6) 30번 부서에 있는 사원들 중에서 가장 많은 월급을 받는 사원보다 많은 월급을 받는 사원들의 이름, 부서번호, 월급을 출력하라. (단, ALL(and) 또는 ANY(or) 연산자를 사용할 것)
```sql
select max(sal) from emp where deptno = 30;

select ename, deptno, sal
from emp
where ​sal > (select max(sal) from emp where deptno = 30);
```
<br>


#### Q7) 'DALLAS'에서 근무하고 있는 사원과 같은 부서에서 일하는 사원의 이름, 부서번호, 직업을 출력하라.
```sql
select deptno from dept where loc = 'DALLAS';

select e.ename, e.deptno, e.job
from emp e join dept d
on e.deptno = (select deptno from dept d where loc = 'DALLAS');
```
<br>


#### Q8) SALES 부서에서 일하는 사원들의 부서번호, 이름, 직업을 출력하라.
```sql
select deptno from dept where dname = 'SALES';
​
select e.deptno, e.ename, e.job
from emp e join dept d
on e.deptno = (select deptno from dept d where dname = 'SALES');
```
<br>


#### Q9) 'KING'에게 보고하는 모든 사원의 이름과 급여를 출력하라. king 이 사수인 사람 (mgr 데이터가 king 사번)
```sql
SELECT ENAME, SAL
FROM EMP
WHERE MGR=(SELECT EMPNO
                FROM EMP
                WHERE ENAME='KING');
```
<br>



#### Q10) 자신의 급여가 평균 급여보다 많고, 이름에 'S'가 들어가는 사원과 동일한 부서에서 근무하는 모든 사원의 사원번호, 이름, 급여를 출력하라.
```sql
SELECT ENAME, SAL
FROM EMP
WHERE MGR=(SELECT EMPNO
                FROM EMP
                WHERE ENAME='KING');
```
<br>


#### Q11) 커미션을 받는 사원과 부서번호, 월급이 같은 사원의 이름, 월급, 부서번호를 출력하라.
```sql
SELECT ENAME, SAL
FROM EMP
WHERE MGR=(SELECT EMPNO
                FROM EMP
                WHERE ENAME='KING');
```
<br>


#### Q12) 30번 부서 사원들과 월급과 커미션이 같지 않은 사원들의 이름, 월급, 커미션을 출력하라.
```sql
SELECT ENAME, SAL, COMM
FROM EMP
WHERE SAL NOT IN(SELECT SAL
                        FROM EMP
                        WHERE DEPTNO=30)
AND COMM NOT IN(SELECT NVL(COMM, 0)
                         FROM EMP
                         WHERE DEPTNO=30 and comm is not null);
 
```
<br>

## 2. DML ✔
----------------------
<br>

### 🔔 INSERT
#### [1] 가장 일반적인 insert
```sql
insert into temp(id,name)
values(100, '홍길동');

select * from temp;

commit;
```
<br>

#### [2] 컬럼 목록 생략
```sql
insert into temp
values (200,'김유신')

select * from temp;
rollback;
```
▶ 가독성이 떨어지고 유지보수가 힘듦  
<br>

#### [3] 문제
```sql
insert into temp (name)
values('아무개');          --id pk 제약 (null x)

insert into temp(id, name)
values(100, '개똥이');
```
<br>

### 🔔 대량데이터 삽입
- insert into 테이블명(컬럼리스트) values
- insert into 테이블명(컬림리스트) select 절
```sql
insert into temp5(num)
select id from temp4;
```
[출력값] :   
![image](https://user-images.githubusercontent.com/111114507/192946866-502e9aab-cd08-4823-821d-ee56907c8ba5.png)
<br>

### 🔔 대랑 insert
- 담을 테이블이 없는 경우 >> 테이블 복제(구조:스키마 + 데이터삽입)
- 단 제약정보는 복제하지 않음 (PK, FK)
- 순수한 데이터 구조 복제 + 데이터 복사
```sql
create table copyemp
as
    select * from emp;
```
```sql
create table copyemp2 
as
    select empno, ename, sal
    from emp 
    where deptno = 30;
```
<br>

#### 틀(구조)만 복제하고 데이터는 복사하고 싶지 않다면
```sql
create table copytable3
as
    select * from emp where 1=2;
```
▶ where 1=2; : false이기 때문에
<br>

### 🔔 UPDATE
<br>

[형식] :  
``sql
update 테이블명
set 컬럼명 = 값, 컬럼명2 = 값2 ...
where 조건절
```

[형식] : 
```sql
update 테이블명
set 컬럼 = (subquery)
where 컬럼명 = (subquery)
```
<br>

### 🔔 delete
```sql
delete from copyemp;
```
```sql
delete from copyemp where deptno = 10;
```
<br>

## 3. DDB ✔
----------------------
<br>

```sql
create table vtable(
no1 number,
no2 number,
no3 number GENERATED ALWAYS as (no1 + no2) VIRTUAL
);

select * from col where lower(tname) = 'vtable';
insert into vtable(no1, no2) values(100,50);

```
▶ no1, no2만 넣으면 no3가 자동으로 생성되게!
<br>

```sql
insert into vtable(no1, no2, no3) values(100,50, 10);
```
![image](https://user-images.githubusercontent.com/111114507/192957567-83678626-b8a1-47c4-a1a0-06f22ee048f5.png)
▶ no3을 지정해준다면 생기는 오류   
<BR>

### 🔔 [예제] :   

- 제품정보(입고) : 분기별 데이터 추출(4분기)
- 입고일(2022-09-10)
```sql
create table vtable2(
    no number, --순번
    p_code char(4), --제품코드(A001, B002)
    p_date char(8), --입고일(20220922)
    p_qty number, --수량
    p_bungi number(1)  GENERATED ALWAYS as (
                         CASE WHEN substr(p_date,5,2) in ('01', '02', '03') THEN 1
                              WHEN substr(p_date,5,2) in ('04', '05', '06') THEN 2
                              WHEN substr(p_date,5,2) in ('07', '08', '09') THEN 3
                              ELSE 4
                         END ) VIRTUAL
)
```
```sql
insert into vtable2(p_date) values('20190101');
insert into vtable2(p_date) values('20190501');
insert into vtable2(p_date) values('20190601');
insert into vtable2(p_date) values('20191101');
insert into vtable2(p_date) values('20191201');
commit;
```
```sql
select* from vtable2;
```
[출력값] :    
![image](https://user-images.githubusercontent.com/111114507/192960046-d80a4651-8e2b-4c94-9bc8-a1dcfbfaba05.png)
<br>

```sql
select * from vtable2 where p_bungi = 1;
```
[출력값] :  
![image](https://user-images.githubusercontent.com/111114507/192960173-1b55d944-2513-4c4c-bc3f-0f02fa886538.png)
<br>

### 🔔 DDL  테이블 만들고 수정, 삭제
#### 1. 테이블 생성
```sql
create table temp6(id number);
desc temp6;
```
<br>

#### 2. 테이블 생성 후에 컬럼 추가하기
```sql
alter table temp6
add ename varchar2(20);

desc temp6;
```
<br>

#### 3. 기존 테이블에 있는 커럼 이름 잘못 표기(ename -> username)
```sql
alter table temp6
rename column ename to username;

desc temp6;

```
<br>

#### 4. 기존 테이블에 있는 기존 컬럼의 타입 크기 수정 (기억) : modify
```sql
alter table temp6
modify (username varchar2(2000));
```
<br>

#### 5, 기존 테이블에 있는 기존 컬럼 삭제
```sql
alter table temp6
drop column username;

desc temp6;
```
<br>

#### 6. 테이블 전체가 필요 없음
- 1) delete : 데이터만 삭제
- 테이블 처음 만들면 처음 크기 -> 데이터 넣으면 데이터의 크기만큼 테이블 크기 증가
- ex) 처음 1M >> 데이터 10만건 >> 100M >> delete 10만건 삭제 >> 테이블 크기 100M
<br>

- 2) truncate : 데이터와 공간 삭제
- 단점 : where 사용 불가
- ex) 처음 1M >> 데이터 10만건 >> 100M >> delete 10만건 삭제 >> 테이블 크기 1M
<br>

- 3) 테이블삭제
```sql
drop table temp6;
```
<br>

### 🔔 insert 제약
### PRIMARY KEY(PK) : 유일하게 테이블의 각행을 식별(NOT NULL 과 UNIQUE 조건을 만족)
- 제약을 만드는 방법 (create table 안에서 생성)
- 테이블이 생성된 다음 추가 (alter table add constraint ....) 많이 사용 >> 툴..
```sql
--TIP)
--제약 정보 확인
select * from user_constraints where table_name='EMP';

create table temp7(
    --id number primary key --권장하지 않아요(제약이름 자동생성>>SYS_C006997
                          --제약 삭제시 수정시 찾기 어려움
    id number constraint pk_temp7_id primary key, --pk_temp7_id 관용적
    name varchar2(20) not null, -- constraint 표현 쓰지 마세ㅛ
    addr varchar2(50)
);
select * from user_constraints where table_name='TEMP7';

--PK(not null 하고 unique 제약)
--PK 테이블 당 1개만 사용 (컬럼1개, 여러개의 컬럼을 묶어서 1개 : 복합키)

insert into temp7(name, addr) values('홍길동', '서울시 강남구');
--annot insert NULL into ("KOSA"."TEMP7"."ID")

insert into temp7(id, name, addr) values(10, '홍길동', '서울시 강남구');
select * from temp7;

insert into temp7(id, name, addr) values(10, '아무개', '서울시 강남구');
--unique constraint (KOSA.PK_TEMP7_ID) violated
```
<br>

### UNIQUE key(UK) : 테이블의 모든 행을 유일하게 하는 값을 가진 열(NULL을 허용)
- 컬럼 수만큼 생성 가능
- null허용
- not null, unique

```sql
create table temp8(
    id number constraint pk_temp8_id primary key,
    name nvarchar2(20) not null,
    jumin nchar(6) constraint uk_temp8_jumin unique --null허용
    addr nvarchar2(100)
);
select * from user_constraints where lower(table_name) = 'temp8';
```
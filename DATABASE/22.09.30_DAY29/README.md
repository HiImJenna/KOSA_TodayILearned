# 2022.09.30. FRI 📅
----------------
<br>

## 1. DDB ✔
----------------------
<br>

### 🔔 CHECK(CK) 
- 참이어야 하는 조건을 지정함(대부분 업무 규칙을 설정
```sql
create table temp10(
id number constraint pk_temp10_id primary key,
name varchar2(20) not null,
jumin char(6) constraint uk_temp10_jumin unique,참
addr varchar2(20),
age number constraint ck_temp10_age check(age>=19) --where age >= 19
);
```
▶ age number constraint ck_temp10_age check(age>=19) : 나이가 19세 이상이어야 한다.  
<br>

```sql
insert into temp10(id, name, jumin, addr, age)
values(100, '홍길동', '123456', '서울시', 15);
```
▶ age가 조건에 충족하지 않기에 오류 발생  
<br>

### 🔔 FOREIGN KEY(FK)
- 열과 참조된 열 사이의 외래키 관계를 적용하고 설정
- not null을 강제하지 않으면 null값 허용 -> 요구사항에 따라 맞게 설계

```sql
create table c_emp -- ()
as 
    select empno, ename, deptno from emp where 1 = 2; --테이블의 구조(스키마)
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/193167325-43df116a-5a99-4757-ab43-74a55fbfadde.png)
<br>

```sql
create table c_dept
as
    select deptno, dname from dept where 1 = 2;
```
[출력값]   
![image](https://user-images.githubusercontent.com/111114507/193167370-2b56eaf1-f573-4d79-b70e-1f2b8b7dc38d.png)
<br>

```sql
alter table c_emp
add constraint fk_c_emp_deptno foreign key (deptno) references c_dept(deptno);
--ORA-02270: no matching unique or primary key for this column-list
```
- foreign key (deptno)가 성립하기 위해서는 c_dept(deptno)의 데이터가 무결성(중복, null X)임을 알려야함
- -> pk >> c_dept(deptno) -> unique, priamry key
- 반드시 c_dept에 PK 설정되어 있어야 한다
<br>

```sql
alter table c_dept
add constraint pk_c_dept_deptno primay key(deptno); --신용확보
```
<br>

### #Q1)
```sql
-영문테이블 , 영문 컬럼명

--[학생 성적 테이블]

--학번의 데이터는 중복되거나 NULL 값을 허용하면 안된다

--이름 NULL 값을 허용하지 않는다

--국어

--영어

--수학 점수 컬럼은 숫자 타입이고 NULL 값을 허용

--값을 입력하지 않으면 default로 0값을 갖는다

--총점 ,평균 컬럼은 가상컬럼으로(조합컬럼) 생성한다

--학과코드는 학과 테이블에 학과코드를 참조한다

--학번 , 이름 , 국어 , 영어 , 수학 , 총점 , 평균 , 학과코드

​
--[학과 테이블]

--학과코드 데이터는 중복되거나 NULL 값을 허용하면 안된다,

--학과명 은 null값을 허락하지 않는다

--학과코드 , 학과명
​
--샘플 데이터 insert ..

--그리고 select 결과는

--학번 , 이름 , 총점, 평균 , 학과코드 , 학과명 을 출력하세요
```
[풀이]  
```sql
create table student(
    studentno number constraint pk_student_studentno primary key,
    name nvarchar2(10) not null,
    rnr number default 0,
    dud number default 0,
    tn number default 0,
    sum number generated always as (rnr + dud + tn) virtual,
    avg number generated always as ((rnr+dud+tn)/3) virtual,
    departmentno number
);

create table department(
    departmentno number constraint pk_department_departmentno primary key,
    dname nvarchar2(20) not null
);


alter table student
add constraint fk_student_departmentno foreign key(departmentno) references department(departmentno);

insert into department(departmentno,dname) values (10,'컴퓨터');
insert into department(departmentno,dname) values (20,'사회복지');
insert into department(departmentno,dname) values (30,'영양');
insert into department(departmentno,dname) values (40,'철학');
select * from department;
commit;

select * from student;
insert into student(studentno,name,rnr,dud,tn,departmentno)
values (100,'홍길동',100,90,80,10);
insert into student(studentno,name,rnr,dud,departmentno)
values (200,'김유신',100,90,20);
insert into student(studentno,name,rnr,departmentno)
values (300,'유관순',100,30);
commit;

select s.studentno as 학번, s.name as 이름, s.sum as 총점, round(s.avg) as 평균, 
s.departmentno as 학과코드, d.dname as 학과이름
from student s join department d
on s.departmentno = d.departmentno;

select * from user_constraints where lower(table_name) = 'student';
select * from user_constraints where lower(table_name) = 'department';
```
<br>

### Q2) 
```sql
--EMP empno pk
--DEPT deptno pk
--EMP deptno FK
```
```sql
alter table emp
add constraint pk_emp_empno primary key(empno);

alter table dept
add constraint pk_dept_deptno primary key(deptno);

alter table emp
add constraint fk_dept_to_emp foreign key (empno) references dept (deptno);
```
<br>

# 2. view ✔ 
[오라클 pdf 9186]
```sql
CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW view_name [(alias[,alias,...])]
AS Subquery 
[WITH CHECK OPTION [CONSTRAINT constraint ]]
[WITH READ ONLY]
OR REPLACE 이미 존재한다면 다시 생성한다.
FORCE Base Table 유무에 관계없이 VIEW 을 만든다.
NOFORCE 기본 테이블이 존재할 경우에만 VIEW 를 생성한다.
view_name VIEW 의 이름
Alias Subquery 를 통해 선택된 값에 대한 Column 명이 된다.
Subquery SELECT 문장을 기술한다.
WITH CHECK OPTION VIEW 에 의해 액세스 될 수 있는 행만이 입력,갱신될 수 있다. 
Constraint CHECK OPTON 제약 조건에 대해 지정된 이름이다.
WITH READ ONLY 이 VIEW 에서 DML 이 수행될 수 없게 한다.
```
<br>

### 🔔 사용목적
1. 개발자 편리성 : join, query -> view 사용 (성능과 무관히)
2. query 단순화 (편리성) : 복잡한 쿼리를 미리 만들어 두고 사용
3. 보안성 (특정컬럼만노출)
<br>

### 예제
```sql
-- 30번 부서 사원들의  직종, 이름, 월급을 담는 VIEW를 만드는데,
-- 각각의 컬럼명을 직종, 사원이름, 월급으로 ALIAS를 주고 월급이
-- 300보다 많은 사원들만 추출하도록 하라.
create or replace view view101(직종,사원이름,월급)
as
   select job , ename , sal
   from emp
   where deptno=30 and sal > 300;

select * from view101;

```
- 보안성을 위해 기존에 있던 테이블에서 보여주고 싶은 정보만 담고 있는 새로운 테이블을 만드는 것이 view! (내가 이해한 바로는ㅎ)
<br>

# 3. 조별과제
### 문제 3개 만들기
```sql
--Quiz 

--아래 3개의 테이블 이용하여  문제 3개를 만드세요 

--필수사항) 함수 및 JOIN 퀴리는 반드시 필수 .....

--좋은 문제가 나온 조에게 포상 할게요 ^^

select * from employees;

select * from departments;

select * from locations;
```
[나]
```sql
1. Location_ID가 1700인 DEPARTMENT_ID를 구하고 그 부서에 속하면서 
이메일에 H가 들어가는 사원의 employee_id,  fullname(first name + last name), department_id, email를 출력하세요. (fullname 시작 알파벳 순 정렬)
```
```sql
select employee_id, 
       concat(first_name, last_name) as full_name,
       e.department_id,
       email
from employees e join departments d
on d.department_id = e.department_id
where d.location_id = 1700 or email like '%H%' 
order by full_name;
```
<br>

[조원1]  
```sql
2. 도시 별 사용 이메일 출력할 것.
   도시별로 오름차순으로 정렬 할 것.
```
```sql
create or replace view email_list
       as select e.email, e.department_id, d.location_id
          from employees e join departments d on e.department_id = d.department_id;
       
       select l.city, e.email
       from email_list e join locations l on e.location_id = l.location_id
       order by l.city;
```
<br>

[조원2]  
```sql
3. 평균 연봉이 높은 순으로 부서명과 평균연봉을 출력하되, 평균 연봉은 정수로 출력하세요.
```
```sql
select d.department_name as 부서명, round(A.avgsal, 0) as 평균연봉
from departments d join (select department_id as di, avg(salary) as avgsal
                         from employees
                         group by department_id) A
on d.department_id = A.di
order by 평균연봉 desc;
```
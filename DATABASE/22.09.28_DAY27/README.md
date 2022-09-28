# 2022.09.28.WED 📅
----------------
<br>

## 1. 문자열 타입 ✔
### 🔔 고정길이 문자열
- char(10) >> 10byte >> 한글5자, 영문자, 특수, 공백 10자 
- 공간의 변화가 없음
- char(10) >> 'abc' >> 3byte >> [a] [b] [c] [] [] [] [] [] ...
- 남,여 / 대, 중, 소 / 주민번호 --> 성능
<br>

### 🔔 가변길이 문자열
- varchar2(10) >> 10byte >> 한글5자, 영문자, 특수, 공백 10자
- 데이터 크기만큼만 공간 확보
- varchar2(10) >> 'abc' >> 3byte >> [a] [b] [c]
- 사람의 이름, 취미, 주소
<br>

### 🔔 unicode (2byte)
- 한글, 영문자, 특수문자, 공백 -> 2byte 취급
- nchar(20) : 20자 -> 2*20 -> 총 40byte
- nvarchar2(20) : 20자
<br>

```sql
select * from SYS.NLS_DATABASE_PARAMETERS;
--NLS_CHARACTERSET  : 	AL32UTF8  한글 3byte 인식
```

```sql
insert into test2(name) values('a');
insert into test2(name) values('aa');
insert into test2(name) values('가'); --한글 1자 3byte 인지
--> uvarchar 쓰기!
```
[오류] :    
![image](https://user-images.githubusercontent.com/111114507/192663329-b4a95961-8fc3-49e9-9b30-34f882bd4fe4.png)
<br>

## 2. 일반함수 ✔
- 프로그램 성격이 강한 함수
- nvl(), nvl2() : null 처리 함수
- decode() : java if문과 비슷
- case() : java switch문

### 🔔 decode()
[create table] :  
```sql
insert into t_emp(id, job) values(100, 'IT');
insert into t_emp(id, job) values(200, 'SALES');
insert into t_emp(id, job) values(300, 'MGR');
insert into t_emp(id, job) values(400);
insert into t_emp(id, job) values(500, 'MGR');
COMMIT;

select * from t_emp;
```
[예시] :   
```sql
select id, decode(id, 100, '아이티', 
                      200, '영업부', 
                      300, '관리팀', 
                           '기타부서') as 부서이름
from t_emp;
```
<br>

```sql
select empno, ename, deptno, decode(deptno, 10, '인사부',
                                            20, '관리부',
                                            30, '회계부',
                                            40, '부서',
                                                'ETC') as 부서이름
from emp;
```
▶ id가 100이라면 '영업부', 그 아래는 else if, else 처럼 
<br>

#### Q) t_emp2 테이블에서 id, jumin 데이터를 출력하되 jumin 컬럼의 앞자리가 1이면 '남성' 출력,  2이면 '여성' 3이면 '중성' 그외는  '기타' 라고 출력하세요. (컬럼명은 '성별')
```sql
select id, jumin, decode(substr(jumin, 1, 1), 1, '남성',
                                              2, '여성',
                                              3, '중성',
                                                 '기타') as 성별
from t_emp2;
```
<br>

#### Q) 부서번호가 20번인 사원중에서 SMITH 라는 이름을 가진 사원이라면 HELLO 문자 출력하고, 부서번호가 20번인 사원중에서 SMITH 라는 이름을 가진 사원이 아니라면 WORLD 문자 출력하고, 부서번호가 20번인 사원이 아니라면 ETC 라는 문자를 출력하세요.
```sql
select empno, deptno, decode(deptno, 20, decode(ename, 'SMITH', 'HELLO', 'WORLD'), 'ETC')
from emp;
```
[출력값] : 
![image](https://user-images.githubusercontent.com/111114507/192667877-b8cb77e4-3254-4357-980c-80972ac225a0.png)
<br>

### 🔔 case()
```sql
case조건식 when 결과1 then 출력1
          when 결과2 then 출력2
          when 결과3 then 출력3
          else 출력4
end "컬럼명"
```
[create table] :  
```sql
create table t_zip
(
    zipcode number(10)
);

select * from t_zip;

insert into t_zip(zipcode) values(2);
insert into t_zip(zipcode) values(31);
insert into t_zip(zipcode) values(32);
insert into t_zip(zipcode) values(41);
commit;

```
```sql
select '0' || to_char(zipcode), case zipcode when 2 then '서울'
                                             when 31 then '경기'
                                             when 41 then '제주'
                                             else '기타지역'
                                 end "지역이름"
from t_zip;
```
[출력값] :  
![image](https://user-images.githubusercontent.com/111114507/192668836-b153258d-7a50-4878-a573-d3488c547b31.png)
<br>

[예시] : 
```sql
사원테이블에서 사원급여가 1000달러 이하면 4급
1001달러 2000달러 이하면 3급
2001달러 3000달러 이하면 2급
3001달러 4000달러 이하면 1급
4001달러 이상이면 '특급'이라는 데이터를 출력하세요.
```
```sql
select case when sal <= 1000 then '4급'
            when sal between 1001 and 2000 then '3급'
            when sal between 2001 and 3000 then '2급'
            when sal between 3001 and 4000 then '1급'
            else '특급'
       end "급수"
from emp;
```
<br>

## 3. 집계함수 ✔
- count(*) : row수, count (컬럼명) -> 데이터건수 (null은 포함 x)
- sum()
- avg()
- max()
- min()
<br>

### 🔔 count()
```sql
select count(*) from emp; --14개의 row

select count(empno) from emp; --14

select count(comm) from emp; --6

select comm from emp;
```
[select comm from emp;]:  
![image](https://user-images.githubusercontent.com/111114507/192671144-3829006b-4b40-4205-b16a-26888967a535.png)
▶ null 값은 세지 않는다.
<br>

[해결] :  nvl() 사용!  
```sql
select count(nvl(comm,0)) from emp; --14
```
<br>

### 🔔 sum()
```sql
select sum(comm) from emp;
```
<br>

### 🔔 avg()
```sql
select avg(comm) from emp; --721 (null값 무시)
select trunc(avg(nvl(comm,0))) from emp; --309달러
```
▶ 둘다 정답 -> 회사의 규정에 따라 달라짐 (전체사원기준 / 받는사원기준)
<br>

### 🔔 group by ..
```sql
--부서별 평균 급여를 구하세요
select deptno, avg(sal)
from emp
group by deptno;
```
[출력값] :   
![image](https://user-images.githubusercontent.com/111114507/192675995-68fc919f-2321-46cf-8937-5fd5f5263b02.png)
<br>

```sql
--직종별 평균 급여를 구하세요
select job, trunc(avg(sal))
from emp
group by job;
```
[출력값] :    
![image](https://user-images.githubusercontent.com/111114507/192675965-ac15389f-3610-47f3-ba2e-c0118b497af2.png)
<br>

```sql
-- 직종별 평균급여, 급여합, 최대급여, 최소급여, 건수를 출력하세요
select * from emp;
select job, avg(sal), sum(sal), max(sal), min(sal), count(sal) as 최소급여, count(*) as 인원수
from emp
group by job;
```
[출력값] :   
![image](https://user-images.githubusercontent.com/111114507/192676419-3caf7688-e337-4434-a42f-71bfb358266f.png)
<br>

```sql
--부서별, 직종별 급여의 합을 구하세요
select deptno, job, sum(sal)
from emp
group by deptno, job;
```
<br>

[실행순서]     
```sql
select절             4
from절               1
where절              2
group by절           3
order by절           5
```
<br>

```sql
-- 직종별 평균급여가 3000달러 이상인 사원의 직종과 평균 급여를 출력하세요.
select job, avg(sal) as avgsal
from emp

--where 조건 --집계된 결과를 조건을 못함
group by job
having avg(sal) >= 3000; --group by 조건절
```
<br>

[실행순서]   
```sql
select             5
from               1
where              2
group by           3
having             4
order by           6
```
<br>

### Q) 사원테이블에서 직종별 급여합을 출력하되 수량은 지급받고 급여의 합이 5000 이상인 사원들의 목록 급여의 합이 낮은 순으로 출력
```sql
select job, sum(sal) as sumsal
from emp
where comm is not null
group by job
having sum(sal) >= 5000
order by sumsal asc;
```
[출력값] :   
![image](https://user-images.githubusercontent.com/111114507/192692208-d65e50bb-f3ac-4f2a-8951-1b73a92cfe7b.png)
<br>

### Q) 사원테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 출력
```sql
select deptno, count(*), sum(sal)
from emp
group by deptno
having count(*)>=4;
```
[출력값] :     

![image](https://user-images.githubusercontent.com/111114507/192692441-60ad8a22-5423-4507-86c1-b740f993779b.png)
<br>

### Q) 사원테이블에서 직종별 급여의 합이 5000을 초과하는 직종과 급여의 합을 출력. 단 판매직종 salesman 제외하고 급여합으로 내림차순 정렬
```sql
select job, sum(sal)
from emp
where job != 'SALESMAN'
group by job
having sum(sal) > 5000
order by sum(sal) desc;
```
[출력값] :   
![image](https://user-images.githubusercontent.com/111114507/192692631-de45832c-76a9-429f-901b-d756a082bacf.png)
<br>

#### 🔔 having & where
1. having
- 그룹을 나타내는 결과 집합의 행에만 적용
- 그룹을 필터링
- having 절은 Group By 절 뒤에 사용

2. where
- 개별 행에 적용
- 행을 필터링 하는데 사용
- Group By 절 앞에 사용

```sql
<요약>
Having은 그룹화 또는 집계가 발생한 후 레코드를 필터링하는데 사용된다.
Where은 그룹화 또는 집계가 발생하기 전에 레코드를 필터링하는데 사용된다.
```
<br>

## 4. JOIN ✔
- Cartesian Product 모든 가능한 행들의 Join
- Equijoin Join 조건이 정확히 일치하는 경우 사용(일반적으로 PK 와 FK 사용)
- Non-Equijoin Join 조건이 정확히 일치하지 않는 경우에 사용(등급,학점)
- Outer Join Join 조건이 정확히 일치하지 않는 경우에도 모든 행들을 출력
- Self Join 하나의 테이블에서 행들을 Join 하고자 할 경우에 사용
- Set Operators 여러 개의 SELECT 문장을 연결하여 작성한다
- union은 위 아래로 결합, join은 옆으로 결합
<br>


```sql
select *
from m join s --구문
on m.ml = s.sl; --on 조인의 조건절
```
[출력값] :   
![image](https://user-images.githubusercontent.com/111114507/192698056-7cc9e23b-9b6a-4aba-a643-0c246117805c.png)
<br>

```sql
--사원번호, 사원이름, 부서번호, 부서이름을 출력하세요
select *
from emp join dept
on emp.deptno = dept.deptno;
```
[출력값] :  
![image](https://user-images.githubusercontent.com/111114507/192698144-dff0d0ed-578e-4ac5-96d0-e7ea7cb9e65f.png)
<br>
 
 ```sql
 --SQL JOIN
select m.m1, m.m2, s.s2, x.x2
from m, s, x
where m.m1 = s.s1 and s.s1 = x.x1;
```
```sql
--ANSI 문법
select *
from m join s on m.m1 = s.s1
       join x on s.sl = x.x1;
```
<br>

#### Q) 사번, 이름(last_name), 부서번호, 부서이름을 출력(ANSI)
```sql
select cound(*) from employees; -107

select e.employee_id,
       e.last_name,
       e.department_id,
       d.department_name
from employees e join departments d
on e.department_id = d.department_id;
```
[출력값] :    
![image](https://user-images.githubusercontent.com/111114507/192704093-9a0a128f-6ee6-4a8c-9f75-c0bb40b8701f.png)
▶ 사원수는 107명인데 한명 누락됨  
<br>

```sql
select * from employees where department_id is null;
```
![image](https://user-images.githubusercontent.com/111114507/192704456-8aed53e4-2d53-4347-b794-c99fc67d7671.png)
▶ department_id가 null이라서 누락됨
<br>

#### Q) 사번, 이름(last_name), 부서번호, 부서이름, 지역코드, 도시명
```sql
select employee_id, 
       last_name, 
       department_id, 
       department_name, 
       postal_code, 
       city

from employees e join department d
on e.department_id = d.department_id
                 join locations l
on d.location_id = l.location_id;
```
<br>

### 🔔 비등가조인(non-equl join)
- 1:1 로 비교할 컬럼이 없다 
- 의미만 존재 >> 등가조인의 문법을 그대로 사용
- 1:1매핑 on emp.deptno = dept.deptno
```sql
select * from emp;
select * from salgrade;

select e.empno, e.ename, e.sal, s.grade
from emp e join salgrade s
on e.sal between s.losal and s.hisal;
```
<br>

### 🔔 outer join
- equi join 먼저 선행하고 나서 남아있는 데이터 가져오면 됨
- 주종관계 파악
- 주인이 되는 테이블의 남은 데이터를 가져올 수 있다
<br>

#### < 문법 >
- left outer join(왼쪽)
- right outer join(오른쪽)
- full outer join(left, right >> union)
<br>

```sql
select *
from m left join s
on m.m1 = s.s1;
```
[출력값] :   
![image](https://user-images.githubusercontent.com/111114507/192708656-df6a33e7-70b6-4615-b975-c9d53d7c7daf.png)
<br>

```sql
select *
from m right join s
on m.m1 = s.s1;
```
[출력값] :    
![image](https://user-images.githubusercontent.com/111114507/192708781-c261922a-a7bd-4f0c-a531-61a52d9f4078.png)
<br>

### 🔔 self join
- 자기참조
- 문법 X, 의미만 존재 -> 등가조인문법
- 하나의 테이블에 있는 컬럼이 자신의 테이블에 있는 다른 컬럼을 참조하는 경우
```sql
select e.empmo, e.ename, m.empno, m.ename
from emp e left join emp m
on e.mgr = m.empno; --13명

select * from emp where ename = 'KING';

```
[출력값] :   
![image](https://user-images.githubusercontent.com/111114507/192711623-68d81239-cd44-40a7-b244-e8c916b83be8.png)
# 2022.09.29. THU 📅
----------------
<br>

## 1. subquery
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
```
<br>



#### Q10) 자신의 급여가 평균 급여보다 많고, 이름에 'S'가 들어가는 사원과 동일한 부서에서 근무하는 모든 사원의 사원번호, 이름, 급여를 출력하라.
```sql
```
<br>


#### Q11) 커미션을 받는 사원과 부서번호, 월급이 같은 사원의 이름, 월급, 부서번호를 출력하라.
```sql
```
<br>


#### Q12) 30번 부서 사원들과 월급과 커미션이 같지 않은 사원들의 이름, 월급, 커미션을 출력하라.
```sql
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
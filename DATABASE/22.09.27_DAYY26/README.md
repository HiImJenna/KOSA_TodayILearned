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

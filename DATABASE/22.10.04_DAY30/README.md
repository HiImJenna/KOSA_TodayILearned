# 2022.10.04. TUE 📅
----------------
<br>

## 1. MAX ✔
```sql
insert into board(boardid, title)
values((select nvl(max(boardid, 0) + 1 from board), '1');

insert into board(boardid, title)
values((select nvl(max(boardid, 0) + 1 from board), '2');

insert into board(boardid, title)
values((select nvl(max(boardid, 0) + 1 from board), '3');
```
<br>

## 2. sequence ✔
- 글 번호 고민 (순번)
- 중복값이 없고 순차적인 값을 제공하는 객체
![image](https://user-images.githubusercontent.com/111114507/193710038-b43e75d6-dcac-48d5-9250-fcb5ba965959.png)
<br>

```sql
select board_num.nextval from dual;
```
[출력값]   
![image](https://user-images.githubusercontent.com/111114507/193710318-7fcae75c-0975-4655-bfc2-94152eb4bd9b.png)
<br>

```sql
create sequence kboard_num;

insert into kboard(num, title) 
values(kboard_num.nextval, '처음');

insert into kboard(num, title) 
values(kboard_num.nextval, '둘');

insert into kboard(num, title) 
values(kboard_num.nextval, '셋');

select * from kboard;
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/193710691-f5031be0-780e-43e8-a42b-63208563712e.png)
<br>

```sql
delete from kboard where num = 1;

insert into kboard(num, title) 
values(kboard_num.nextval, '넷');
```
[출력값]   
![image](https://user-images.githubusercontent.com/111114507/193710891-d0ad3b75-20f0-4427-a2e6-71836b8298e4.png)
▶ 데이터 삭제 후에도 오류 발생하지 않음!  
<br>

### 🔔 게시판을 만들때!
#### 1. 게시판을 구분하지 않고 게시글 순번을 표시하고 싶다면
- sequence 하나 생성해서 여러 게시판에서 사용 가능
- sequence 객체는 공유객체-> 테이블에 종속되지 않는다
- 하나의 sequence는 여러곳에서 자유롭게 사용가능
<br>

#### 2. 게시판을 구분하여 게시글 순번을 표시하고 싶다면
- 10개의 sequence를 만들어서 각각 사용하면 됨

#### 🔔 TIP
- MS-SQL : create table board(boardnum int identity(1,1)....
- insert into (title) values('방가'); 자동으로 (1,2,3 ...)
- mysql : create table board(boardnum int auto_increment, ... title)
- insert into board (title) values('방가');-> 자동(1,2,3,4,,,)
- mysql 만든 사람들이 open source >> mariadb
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
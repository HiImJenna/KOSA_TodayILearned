# 2022.09.02.Fri 📅
<br>

## 1. String class ✔
-----------------------------
![image](https://user-images.githubusercontent.com/111114507/188033391-7b9f837f-2c3f-4b23-8351-8cd276a946e5.png)

```java
<String 클래스 (문자열)>
 * String 수 많은 함수 ... 문자열 조작(자르고, 합치고 ... )
 * String >> static 함수 + 일반 함수(15~20개) 
 ```

## 2. String method ✔
-----------------------------
### * str.concat( ) : 문자열 붙이기
```java
String str = "hello";
String concatstr = str.concat("world");
System.out.println(concatstr);
```

```java
출력값 : hello world
```

### * str.contains( ) : 문자열 포함 여부 확인
```java
boolean bo = str.contains("ell");
System.out.println(bo);
```

``` java
출력값 : true
```
### * str.length( ) : 문자열 길이
```java
String str2 = "a b c d"; //[a] [ ] [b] [ ] [c] ...공백도 문자
System.out.println(str2.length());
```
```
출력값 : 7
```
### * str.contains( ) : 문자열 포함 여부 확인
```java
boolean bo = str.contains("ell");
System.out.println(bo);
```

### * str.length( ) : 문자열 길이

### * str.substring( ) : 문자열 자르기
```java
String result = "superman";
System.out.println(result.substring(0)); //시작 index ~
System.out.println(result.substring(1)); //uperman
System.out.println(result.substring(1, 2)); //u
```
### * str.indexOf( ) : 문자열 자르기
``` java
String filename = "hello java world";
System.out.println(filename.indexOf("h")); //몇번째에 있는지
System.out.println(filename.indexOf("java")); //단어 시작 위치
System.out.println(filename.indexOf("으악")); //-1을 return (없는 값을 배열에서 찾을 때)
```
```
출력값 : 0 , 6, -1
```

### * Quiz)
```java
//Quiz
String filename2 = "home.jpeg"; //or h.png or aaaa.h.hwp
//여기서 파일명과 확장자를 분리해서 출력
//ex) 파일명 : home / 확장자 : jpeg
//위에서 배운 함수만 사용해서 출력

//System.out.println("파일명 : " + );
int position = filename2.indexOf(".");
String name = filename2.substring(0, position + 1);
String extention = filename2.substring(position + 1, filename2.length());
```

### * str.replace( ) : 대체
```java
String str3 = "ABCDDDDDEFG";
String result3 = str3.replace("DDDDD", "오늘은 금요일");
System.out.println(result3);

result3 = str.replace("A", "a");
System.out.println(result3);
```

```
출력값 : ABC오늘은 금요일EFG, aBCDDDDDEFG
```
### * str.equalsIgnoreCase( ) : 대소문자 무시
### * str.split( ) : parameter를 기준으로 분리




protected

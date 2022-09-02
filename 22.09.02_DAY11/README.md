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
String filename = "hello java world";
System.out.println(filename.indexOf("h")); //몇번째에 있는지
System.out.println(filename.indexOf("java")); //단어 시작 위치
System.out.println(filename.indexOf("으악")); //-1을 return (없는 값을 배열에서 찾을 때)
```

```
출력값 : 0 , 6, -1
```
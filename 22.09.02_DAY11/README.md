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
### * str.trim( ) : 앞 뒤 공백 제거
```java
String str8 = "     홍길동      ";
System.out.println(">" + str8 + "<");
System.out.println(">" + str8.trim() + "<");
```
<br>

### Quiz)
```java
String jumin="123456-1234567";
//위 주민번호의 합을 구하세요_1
int sum2=0;
for(int i = 0 ; i < jumin.length() ; i++) {
String numstr =jumin.substring(i, i+1);
if(numstr.equals("-")) continue;
sum2+= Integer.parseInt(numstr);
} 
System.out.println("주민번호 합:" + sum2);

//위 주민번호의 합을 구하세요_2
//String jumin="123456-1234567";
String[] numarr2 = jumin.replace("-","").split("");
int sum3=0;
for(String i : numarr2) {
sum3+= Integer.parseInt(i);
}
System.out.println("주민번호 합2:" + sum3);

//위 주민번호의 합을 구하세요_3
String jumin4 = jumin.replace("-", "");
int sum4=0;
for(int i = 0 ; i < jumin4.length() ;i++) {
sum4+=Integer.parseInt(String.valueOf(jumin4.charAt(i)));
}
System.out.println("주민번호 합4:" + sum4);
}
```

## 3. Protected 접근제한자 ✔
-----------------

```java
상속관계에서 ... 접근자 : protected

public 
private
default (같은 폴더)
protected

protected : 양면성(박쥐) >> default , public 
>>상속이 없는 클래스 안에서 protected >> default 동일 
>>결국 상속관계에서만 의미를 가진다 >> public ㅍ
```
* public과 default 그 사이 어딘가..❓
* 접근제어자가 protected로 설정되었다면 protected가 붙은 변수, 메소드는 동일 패키지의 클래스 또는 해당 클래스를 상속받은 다른 패키지의 클래스에서만 접근이 가능하다.

![image](https://lh3.googleusercontent.com/-UFlhzuxwShg/YPUwhoHlxiI/AAAAAAAAozM/QMBNLidwB3ISagmKKcyq1evkhdsgsMq3wCLcBGAsYHQ/w406-h268/image.png)

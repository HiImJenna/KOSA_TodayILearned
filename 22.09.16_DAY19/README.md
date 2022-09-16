# 2022.09.16.Fri 📅
<br>

## 1. File List ✔
-----------------------------
<br>

< 공부 후 업로드 예정입니다 :( >

## 2. Print Writer ✔
-----------------------------
<br>

< 공부 후 업로드 예정입니다 :( >

## 3. String finder ✔
-----------------------------
<br>

< 공부 후 업로드 예정입니다 :( >

## 4. DataOutputStream ✔
-----------------------------
<br>

< 공부 후 업로드 예정입니다 :( >

## 5. Object Data I/O Stream ✔
-----------------------------
### 🔔 직렬화 & 역직렬화
<br>

#### - 직렬화 : 객체를 분해해서 줄을 세워 보내는 과정 
 * 모든 자원(class)가 직렬화 가능한것은 아님 

```java
public enum UserINfo implements Serializable{
}
```
<br>

[기본생성]
```java
FileOutputStream fos = null;
BufferedOutputStream bos = null;
ObjectOutputStream out = null; 
```
```java
FileOutputStream fos -> 혼자서도 쓰일 수 있지만 ... 
BufferedOutputStream bos  ->  보조, 성능개선!
ObjectOutputStream out = null -> 객체화를 위해서 ... 
```
[직렬화1]
```java
try {
    fos = new FileOutputStream(filename, true);
    bos = new BufferedOutputStream(fos);
    //직렬화
    out = new ObjectOutputStream(bos);
```
```java
기존 코드에 out = new ObjectOutputStream(bos);를 추가해 직렬화
```
[직렬화2]
```java
out.writeObject(u1);
out.writeObject(u2);
````
```java
분해해서 한줄로 세워서 파일에 기록
파일에 userinfo 객체 2개 직렬화해서 write
```
<br>

#### - 역직렬화 : 

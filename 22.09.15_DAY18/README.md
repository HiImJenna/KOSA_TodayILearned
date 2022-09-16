# 2022.09.15.Thu 📅
<br>

## 1. Date Format ✔
-----------------------------
<br>

```java
Date currdate = new Date();
		Calendar cal = Calendar.getInstance();
		System.out.println("date : " + currdate);
		//date : Thu Sep 15 09:20:31 KST 2022
		
		System.out.println("cal : " + cal); //문자열의 조합
		//[time=1663201231171,areFieldsSet=true,areAllFieldsSet ... 
		
		System.out.println("cal getTime()함수 : " + cal.getTime());
		//Thu Sep 15 09:21:48 KST 2022
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmm");
		
		String s = dateformat.format(currdate);
		String s2 = dateformat.format(cal.getTime());
		System.out.println(s);
		System.out.println(s2);
		
		//사이트 어떤 정보 입력
		//문자열 >> 날짜형식으로
		//"202209150925"
		String StringDate = "202209150925"; //형식에 문제 없다면
		Date stringdate = null;
		
		try { 
			stringdate = dateformat.parse(StringDate);
			
			long datelong = stringdate.getTime();
			System.out.println(datelong);
			}
			//parse 만든 설계자 (문제 발생 고민) throws .. 사용자는 예외처리
			catch (ParseException e) { e.printStackTrace();}
			finally { System.out.println(stringdate); }
		
		System.out.println();
```

### Date.getTime()
    : Date.getTime()은 Date를 밀리세컨드로 변환해서 long형 숫자 데이터로 반환합니다. 이를 이용하면 산술 연산으로 시간 차이를 쉽게 구할 수 있습니다.

```java

public class main {
    public static void main(String[] args) throws ParseException {
        String date1 = "2021/01/02"; //날짜1
        String date2 = "2021/01/01"; //날짜2
       
        Date format1 = new SimpleDateFormat("yyyy/MM/dd").parse(date1);
        Date format2 = new SimpleDateFormat("yyyy/MM/dd").parse(date2);
        
        long diffSec = (format1.getTime() - format2.getTime()) / 1000; //초 차이
        long diffMin = (format1.getTime() - format2.getTime()) / 60000; //분 차이
        long diffHor = (format1.getTime() - format2.getTime()) / 3600000; //시 차이
        long diffDays = diffSec / (24*60*60); //일자수 차이
        
        System.out.println(diffSec + "초 차이");
        System.out.println(diffMin + "분 차이");
        System.out.println(diffHor + "시 차이");
        System.out.println(diffDays + "일 차이");
    }
}
```

## 2. Decimal Format ✔
-----------------------------
<br>

![image](https://user-images.githubusercontent.com/111114507/190288732-914b74e3-f4b0-496d-9b49-c08460ddc5bd.png)

```java
double money = 123456.5678;
```
### <0.0>
```java
DecimalFormat df = new DecimalFormat("0.0");
System.out.println(df.format(money));

출력값 : 123456.6 (반올림)
```

### <0>
```java
DecimalFormat df2 = new DecimalFormat("0");
System.out.println(df2.format(money));

출력값 : 123457 (반올림)
```

### <0.000...>
```java
DecimalFormat df3 = new DecimalFormat("0.000000"); 
System.out.println(df3.format(money));

출력값 : 123456.567800 ( 없는 자리는 0으로 채움)
```
### <#.###..>
```java
DecimalFormat df4 = new DecimalFormat("#.#######"); 
System.out.println(df4.format(money));

출력값 : 123456.5678 
```
<br>

## 3. I/O Stream ✔
-----------------------------
<br>

![이미지](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbvH00I%2FbtqydR4e1Ju%2FDaCDExX0OKOaZquiHWzWLK%2Fimg.png)
- 자바에서 데이터는 스트림을 통해 입출력됨

![image](https://mblogthumb-phinf.pstatic.net/MjAxNzAzMDdfMzcg/MDAxNDg4ODc1NTU1NzYz.Jh8-r-RQcxjkX0W2LKMtVT-1BDD1kHl9MwLqEflkySgg.i0cmhOjAE8R72W9oY_VuQVCpsPAndzgmFDgnIGkDvYsg.PNG.mcm1092/%EB%B0%94%EC%9D%B4%ED%8A%B8%EC%8A%A4%ED%8A%B8%EB%A6%BC_%EB%AC%B8%EC%9E%90%EC%8A%A4%ED%8A%B8%EB%A6%BC.png?type=w800)
![image](https://user-images.githubusercontent.com/111114507/190292594-a1a3c4a2-7d58-412f-a948-65a0761d5d39.png)
- byte stream : 작은 빨대
- 문자 stream : 큰 빨대

### 🔔stream
```java
 Stream(종료)
 데이터 종류 : 이미지, 파일(바이너리) <> 문자
 
 JAVA API
 [Byte]단위의 데이터 IO
 
 추상클래스
 InputStream, OutputStream
 
 당신이 Byte 데이터 작업을 할 때
 [입력 InputStream] 상속 받는 클래스 사용하세요 : 대상
 
 대상
 1. Memory : ByteArrayInputStream ...
 2. File : FileInputStream
 
  당신이 Byte 데이터 작업을 할 때
 [출력 OutputStream] 상속 받는 클래스 사용하세요 : 대상
 
 대상
 1. Memory : ByteArrayOutputStream ...
 2. File : FileOutputStream

```
<br>

### 🔔 File Stream

```java
Byte 데이터를 read, write >> 그 대상이 >> File
FileInputStream
FileOutputStream

(이미지, 엑셀파일) read, write

File >> 1.txt, data.txt (데이터를 파일에 기록)


FileInputStream fs = null; 굳이 이렇게 하는 이유

I/O 클래스는 예외를 강제 해야하기 때문에 하는거임

I/O 자원은 개발자가 직접적으로 자원에 해제 (여러 사용자들이 접근 사용 가능)
>> close() 
```
<br>

### 🔔 Buffer
```java
 File 처리 (DISK) : 입력 출력은 Byte 단위로 (한 Byte) read, write
 
 여러 학생을 모아서 하나의 버스에 태워서 목적지 ... 놀면
 버스 : buffer
 1. I/O 성능 개선 (접근 횟수 줄이기)
 2. Line 단위 (엔터)
 
 BufferedInputStream(보조 스트림) >> 주 클래스에 의존

```
![image](https://user-images.githubusercontent.com/111114507/190366898-9cdb9209-2253-4b7d-90d2-31d4a25a276f.png)

#### - 고정 값이 아니라 가변적인 값을 받음 -> 5개의 값을 받으면 5개의 공간, 10개의 값을 받으면 10개의 공간 생성  
#### - 입력받은 값을 버퍼에 저장해두었다가 버퍼가 가득 차거나 개행 문자가 나타나면 한번에 전달


## 4. Reader & Writer ✔
-----------------------------
<br>

### Q) Lotto Class에서 값을 받는 파일 생성하기

[기본 소스]
```java
FileReader fr = null;
FileWriter fw = null;
BufferedReader br = null;
BufferedWriter bw = null;

=> 기본적으로 4개 필요
```

[쓰기]
```java
fw = new FileWriter("Lotto.txt", true);
bw = new BufferedWriter(fw);
bw.write("로또번호 : " + Arrays.toString(lotto));
SimpleDateFormat date = new SimpleDateFormat(" [yyyy년MM월dd일 HH:mm]");
String time = date.format(cal.getTime());
bw.write(time);
bw.newLine();
```
```
FileWriter를 작성하여 BufferWriter에게 넘겨준다
bw.write()를 작성하여 입력하고
bw.newLine()를 작성하여 줄띄워주고
bw.flush()를 통해 버퍼가 안차더라도 넘겨준다.
```
[읽기]
```java
fr = new FileReader("lotto.txt");
br = new BufferedReader(fr);
String line = "";
for (int i = 0; (line = br.readLine()) != null; i++) {
	System.out.println(line);
}
```

```
br.readLine()을 통해 버퍼 날라온걸 받아주고 써내려간다
for문은 while ((line=br.readLine())!=null)으로 변경할 수 있겠다고도 생각했다.
```
[전체 소스]
```java
	public void Write() {
		Calendar cal = Calendar.getInstance();

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter("Lotto.txt", true);
			bw = new BufferedWriter(fw);
			bw.write("로또번호 : " + Arrays.toString(lotto));
			SimpleDateFormat date = new SimpleDateFormat(" [yyyy년MM월dd일 HH:mm]");
			String time = date.format(cal.getTime());
			bw.write(time);
			bw.newLine();
		} catch (Exception e) {

		} finally {
			try {
				bw.close();
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public void Read() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader("lotto.txt");
			br = new BufferedReader(fr);
			String line = "";
			for (int i = 0; (line = br.readLine()) != null; i++) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				br.close();
				fr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

public class Lotto_Main {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.runLotto();
		lotto.Write();
		lotto.Read();
	}
}
```
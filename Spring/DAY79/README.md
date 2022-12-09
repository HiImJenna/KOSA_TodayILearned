# 2022.12.09.FRI 📅
----------------
<br>

## 1. 글쓰기(파일업로드) 과제 ✔

### 💡 글쓰기 화면 출력
```java
	@GetMapping("noticeReg.htm")
	public String noticeReg() {
		return "noticeReg.jsp";
	}
```
<br>

### 💡 글쓰기 기능 
#### [CustomerController]
```java
	@PostMapping("noticeReg.htm")
	public String submmit(Notice notice, HttpServletRequest request) {
		System.out.println(notice.toString());
		
		CommonsMultipartFile file = notice.getFile();
		//파일업로드 하기 위해선..


		notice.setFileSrc(file.getName());
		
		String filename = file.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/customer/upload"); //배포된 서버 경로 
		String fpath = path + "\\" + filename;
		System.out.println(fpath);
		//공식처럼 쓰임 >getRealPath 부분만 경로 수정해주면 됨


		FileOutputStream fs =null;
		try {
			     fs = new FileOutputStream(fpath);
			     fs.write(file.getBytes());
			     
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			 try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			this.noticedao.insert(notice);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "redirect:notice.htm"; 
        //F5하면 계속 insert 가 되기때문에 redirect로 경로 처리 해주기
	}
```
![image](https://user-images.githubusercontent.com/111114507/206610102-e9489f79-4df8-4d36-8b53-b2ec8bc8d5f7.png)
<br>

#### [dispatcher-servlet]
```xml
<context:annotation-config />
<context:component-scan base-package="ncontroller"  />
<bean id="multipartResolver"  class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
      <property name="maxUploadSize" value="1048760"></property>
      <property name="defaultEncoding" value="UTF-8"></property>
</bean>
```
<br>

#### [noticeReg.jsp]
```jsp
<form action="" method="post" enctype= "multipart/form-data">  
    <div id="notice-article-detail" class="article-detail margin-large" >						
        <dl class="article-detail-row">
            <dt class="article-detail-title">
                제목
            </dt>
            <dd class="article-detail-data">
                &nbsp;<input name="title"/>
            </dd>
        </dl>				
                                
        <dl class="article-detail-row">
            <dt class="article-detail-title">
                첨부파일
            </dt>
            <dd class="article-detail-data">
                &nbsp;<input type="file" id="txtFile" name="file" />
            </dd>
        </dl>

        <div class="article-content" >
            <textarea id="txtContent" class="txtContent" name="content"></textarea>
        </div>
        
    </div>
    <p class="article-comment margin-small">						
        <input class="btn-save button" type="submit" value="저장" />
        <a class="btn-cancel button" href="notice.jsp">취소</a>						
    </p>
</form>							
```
- form 태그에 'enctype= "multipart/form-data"' 추가해줘야함!
<br>

## 2. 글 수정하기 ✔
### 💡 글 수정하기 화면
#### [noticeDetail.jsp]
수정 전)
```jsp
<a class="btn-edit button" href="noticeEdit.jsp">수정</a>
<a class="btn-del button" href="noticeDel.jsp">삭제</a>
```
<br>

수정 후)
```jsp
<p class="article-comment margin-small">
    <a class="btn-list button" href="notice.htm">목록</a>						
    <a class="btn-edit button" href="noticeEdit.htm?seq=${notice.seq}">수정</a>
    <a class="btn-del button" href="noticeDel.htm?seq=${notice.seq}">삭제</a>
</p>
```
- ${notice.seq} : 글 번호 가져오기
<br>

### 💡 글 수정하기 기능
#### [CustomerController]
```java

```
<br>


## 3. AOP ✔
![image](https://user-images.githubusercontent.com/111114507/206629125-7b5d72d6-4f5b-4752-929e-e7c79f2dac58.png)
### 💡 AOP 용어
- 조인포인트(Joinpoint) : 횡단관심 모듈의 기능이 삽입되어 동작될 수 있는 위치 
- 포인트컷(PointCut) : 어떤 클래스의 조인 포인트를 사용할 것인지 결정 
- 어드바이스 (Advice) : 조인 포인트에서 삽입되어 동작되어질 코드
- 위빙, 크로스컷팅 weaving : 포인트컷에 의해서 결정된 조인포인트에 지정된 어드바이스를 삽입하는 과정 
- 애스팩트(Aspect) : 포인트 컷과 어드바이스를 합쳐놓은 것 
<br>

### 💡 예시
#### [AOP 적용 전]
```java
	public int Add(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		//
		
		//주업무
		int result = x + y;
		
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time Log Method : ADD]");
		log.info("[Time Log Method]" + sw.getTotalTimeMillis());
		
		return result;
	}
	
	public int Mul(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		//
		
		//주업무
		int result = x * y;
		
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time Log Method : MUL]");
		log.info("[Time Log Method]" + sw.getTotalTimeMillis());
		
		return result;
	}
```
- 만약 이런 함수가 100개라면 100개를 일일이 수정해야함 -> 불편
#### [Java로 AOP]
```java

public class NewCalc implements Calc {

	@Override
	public int ADD(int x, int y) {
		// 보조업무(공통업무) cross-cutting-concern
		int sum = x + y;
		// 보조업무(공통업무) cross-cutting-concern
		return sum;
	}

	@Override
	public int MUL(int x, int y) {
		// 보조업무(공통업무) cross-cutting-concern
		int mul = x * y;
		// 보조업무(공통업무) cross-cutting-concern
		return mul;
	}

	@Override
	public int SUB(int x, int y) {
		// 보조업무(공통업무) cross-cutting-concern
		int sub = x - y;
		// 보조업무(공통업무) cross-cutting-concern
		return sub;
	}

}
```
- 훨씬 간단해짐
<br>

#### [LogPrintHandler]
```java
//보조 업무(공통관심) 클래스
//실 함수를 대신해서 처리 할 수 있는 기능(대리 함수) : invoke
//invoke 함수는 여러개의 다른 함수를 대리한다
public class LogPrintHandler implements InvocationHandler {
   private Object target; // 실 객체의 주소값
   public LogPrintHandler(Object target) {
      System.out.println("logPrintHandler 생성자 호출");
      this.target = target;
   }
   
   
   //invoke 함수가(ADD MUL SUB) 함수를 대리합니다.
   //마치 진짜처럼 
   @Override
   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
   //보조 업무를 가지고 있다
      System.out.println("invoke 함수 호출");
      System.out.println("method 함수명 : " + method);
      System.out.println("method parameter 값 : " + Arrays.toString(args));
      
      //보조기능(공통관심)
      Log log = LogFactory.getLog(this.getClass());
      StopWatch sw = new StopWatch();
      log.info("[타이머 시작]");
      sw.start();
      
      //주업무 (실객체의 실제 함수 호출) : 주객체의 주함수 호출(ADD , MUL , SUB)
      int result = (int)method.invoke(this.target, args);
      
      
      //보조기능(공통관심)
      sw.stop();
      log.info("[타이머 종료]");
      log.info("[Time Log Method : ADD]");
      log.info("[Time Log Method : ]" +sw.getTotalTimeMillis());
      return null;
   }
```
- 겹치는 부분을 처리하는 클래스를 따로 빼놓는다고 생각하면 될 듯
<br>

#### [Program.java (메인)]
```java
public class Program {
	public static void main(String[] args) {
		
		//1. 실 긱체의 주소
		Calc calc = new NewCalc();
		
		//2. 가짜 생성
		Calc cal = (Calc)Proxy.newProxyInstance(calc.getClass().getClassLoader(),  //실 객체의 메타정보(내부정보)
											calc.getClass().getInterfaces(), //행위정보(인터페이스)
											new LogPrintHandler(calc)); //보조객체(공통관심) 객체정보
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		//사용자는 
		int result = cal.ADD(555, 555);
		System.out.println("result : " + result);
	}
}
```
- 사용자는 진짜처럼 사용할 수 있지만 가짜로 생성한걸 거쳐야만함
<br>

## 3. Maven ✔
- new -> Spring Legacy Project
![image](https://user-images.githubusercontent.com/111114507/206641152-1581c93f-e7a7-4503-a321-995bb12dfc30.png)
#### 만약 엑박이 뜬다면)
```
* 상황 - Spring 실습 중에 프로젝트 새로 생성했는데 프로젝트 아이콘과 pom.xml 파일의 아이콘에 빨간 X 표시 발견.
* 원인 - pom.xml에 새로운 dependency를 넣고 실행하면서 오래 걸리는 거 생각 못하고 다른 실행 흐름을 실행하다가 새로운 라이브러리를 다운로드 받지 못함.
* 해결
1. 프로젝트 폴더 클릭 후 Run As → Maven clean
2. 익스플로러 창에서 해당 프로젝트 오른쪽 마우스 클릭해서 Maven → Update Project (단축키 : Alt+F5)
3. 아래 4개 항목 체크 후 ok
Force Update of Snapshots/Releases
Update project configuration from pom.xml
Refresh workspace resources from local filesystem
Clean projects
```
- 다운로드 : https://maven.apache.org/download.cgi
- mvn archetype:generate -DgroupId=com.bit -DartifactId=boardproject -DarchetypeArtifactId=maven-archetype-quickstart
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
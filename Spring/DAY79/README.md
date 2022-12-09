# 2022.12.09.FRI 📅
----------------
<br>

## 1. 글쓰기(파일업로드) 과제

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
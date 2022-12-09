# 2022.12.08. THU 📅
----------------
<br>

# 1. Annotation ✔

### @Controller

기존 방식)

```java
이렇게 처리하면 요청 하나당 controller 하나 필요
public class HelloController implements Controller
방식은
단점: 서비스 요청 개수만큼 controller 생성
게시판: 목록보기 >> ListController
		글쓰기>> WriteController
		수정하기>> EditController
	
	
public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
```

### BUT!! controller를 이용하면

```java
@Controller
public class HelloController

method 단위로 매핑
하나의 controller 안에 여러개의 함수를 생성

게시판: 목록보기 >> public void list()
		글쓰기>> public void write()
		수정하기>> public void edit()
```

 훨씬 간단해짐.

### @RequestMapping

```java
@RequestMapping("/hello.do") //<a href="hello.do"></a> 요청이 오ㅕㄴ 함수 실행
	public ModelAndView hello() {
		System.out.println("[hello.do method call]");
		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting",getGreeting());
		mv.setViewName("Hello");
		return mv;
	}

addObject로 값을 넣어주고 greeting으로 선언해준다
setviewname.jsp 파일로 보낸다.
```

---

```java
Model안에
public class NewArticleCommand {
	private int parentId;
	private String title;
	private String content;
}

이런식으로 선언했으면 아래와 같은 방식으로 view name도 통일시켜야 편하다

<h3>*form 태그에 action 주소가 </h3>
	<form action="post">
		<input type="hidden" name="parentId" value="0">
		제목:<input type="text" name="title"><br>
		내용:<input type="text" name="content"><br>
		<input type="submit" value="전송">
	</form>
```

```java
@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {

	//@RequestMapping(method = RequestMethod.GET)  //화면보여주세요
//원래은 requestmapping 해야하지만 5.x버전부턴 getmapping으로 더 편하게 사용가능
	@GetMapping
	public String form() { 
		//****** spring 함수의 return 타입이 String view의 주소를 의미 ......
		System.out.println("GET");
		return "article/newArticleForm";
		//   /WEB-INF/views/  + article/newArticleForm + .jsp
	}
	
	//1. 데이터 받는 가장 전통적인 방법 >> HttpServletRequest request >> 코드량 증가 >> spring 음...
	//@RequestMapping(method = RequestMethod.POST) //처리해 주세요
//위와 마찬가지로 Postmapping으로 더 편하게 쓸수있음
	@PostMapping
	public ModelAndView submit(HttpServletRequest request) {
		System.out.println("POST");
		return null;
	}
}
```

## com.controller

진짜 구식방식)

```java
//1. 데이터 받는 가장 전통적인 방법 >> HttpServletRequest request >> 코드량 증가 >> spring 음...
	   //@RequestMapping(method = RequestMethod.POST) //처리해 주세요
	   @PostMapping
	   public ModelAndView submit(HttpServletRequest request) {
	      System.out.println("POST");
	      
	      NewArticleCommand article = new NewArticleCommand();
	      article.setParentId( Integer.parseInt(request.getParameter("parentId")));
	      article.setTitle(request.getParameter("title"));
	      article.setContent(request.getParameter("content"));
	      
	      //NewArticleController 가 service 필요해 
	      this.articleservice.writeArticle(article);
	      //처리완료
	      
	      ModelAndView mv = new  ModelAndView();
	      mv.addObject("newArticleCommand", article);
	      mv.setViewName("article/newArticleSubmitted");
	      
	      return mv;
   }
```

옛날방식)

```java
@PostMapping
	   public ModelAndView submit(NewArticleCommand command) {
		 //1. 자동 DTO 객체 생성 NewArticleCommand command = new NewArticleCommand()
		 //2. 넘어온 parameter 값을 DTO 에 setter 함수를 사용해서 자동 주입
		 //3. NewArticleCommand command 객체 IOC 컨테이너 안에 자동 생성 id="newArticleCommand"
		 
		 this.articleservice.writeArticle(command);
		 //처리완료
		 
		 ModelAndView mv = new  ModelAndView();
	 	 mv.addObject("newArticleCommand", command);
	 	 mv.setViewName("article/newArticleSubmitted");
	 	 
	 	 return mv;
	 }
```

최신방식)

```java
public String submit(@ModelAttribute("Articledata") NewArticleCommand command) {
		 this.articleservice.writeArticle(command);
		  /*
	        ModelAndView mv = new  ModelAndView();
	         mv.addObject("newArticleCommand", command);
	         
	         >>> @ModelAttribute("Articledata") 대체됨
	         
	         mv.setViewName("article/newArticleSubmitted");
	         >>> String submit  >>> return "article/newArticleSubmitted"
	         
	         view 까지 자동 forward
	       */
		 return "article/newArticleSubmitted";
	 }
```

# Parameter 받는방법

### 1. 전통적인 방법

```java
public ModelAndView searchExternal(HttpServletRequest request) {
		String id = request.getParameter("id")
	}
```

### 2. DTO 객체를 통한 전달 방법(게시판, 회원가입 데이터)

```java
public ModelAndView searchExternal(MemberDto member){
		/search/external.do?id=hong&name=김유신&age=100
		 
	 2.1 DTO 있는 member field 이름이 >>
	 	private String id;
	 	private String name;
	 	private int age;
	}
```

### 3. 가장 만만한 방법

```java
public ModelAndView searchExternal(String id, String name, int age){
		/search/external.do?id=hong&name=김유신&age=100
		**각각의 parameter에 자동매핑
	}
```

### 4. @RequestParam	annotation 사용하기

4.1 유효성 처리가능
4.2 기본값 처리

```java
@RequestMapping("/search/external.do")
	public ModelAndView searchExternal( @RequestParam (value="query", defaultValue="kosa") String query ,
										@RequestParam (value="p", defaultValue="10") int p) {
		
		System.out.println("param query: " + query);
		System.out.println("param p:" + p);
		
		return new ModelAndView("search/external"); // public String searchExternal()	view주소
	}
```

### 5. REST 방식 (비동기 처리) method= GET, POST, PUT, DELETE

```java
@PathVariable	>>	/member/{memberid} >> /member/100
	
	100 추출해서 parameter 사용
```

### <context:component-scan base-package="패키지명" />

- 패키지에서 필요한 bean을 xml에서 미리 선언해 자동으로 주입해줌

## 쿠키(Cookie)

```java
@Controller
public class CookieController {
	
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) {
		response.addCookie(new Cookie("auth","1004")); //servlet 동일
		return "cookie/CookieMake";
	}
	
	@RequestMapping("/cookie/view.do")
	public String view(@CookieValue(value="auth", defaultValue = "1007") String auth) {
		
		System.out.println("클라이언트에서 read한 쿠키 값: " + auth);
		return "cookie/CookieView";
	}
}
```

## 이미지파일(image)

```java
@Controller
@RequestMapping("/image/upload.do")
public class ImageController {

	@GetMapping
	public String form() {
		return "image/image"; //뷰를 보여주자
	}
	
	@PostMapping
	public String submit(Photo photo , HttpServletRequest request) {
		/*
		1. Photo DTO 타입으로 데이터 받기
		1.1 자동화 : name 속성값이 Photo 타입클래스의 member field 명과 동일
		2. public String submit(Photo photo) 내부적으로 ...  
		   >> Photo photo = new Photo();
		   >> photo.setName("홍길동");
		   >> photo.setAge(20);
		   >> photo.setImage() >> 자동 주입 안되요 >> 수동으로 >> 가공 CommonsMultipartFile 추출(이름)
		   >> photo.setFile(CommonsMultipartFile file) 파일 자동으로 들어와요
		   
		 */
		System.out.println(photo.toString());
		
		CommonsMultipartFile imagefile = photo.getFile(); //업로드한 파일 정보
		System.out.println("imagefile name : " + imagefile.getName());
		System.out.println("imagefile getContentType : " + imagefile.getContentType());
		System.out.println("imagefile getOriginalFilename : " + imagefile.getOriginalFilename());
		System.out.println("imagefile getBytes : " + imagefile.getBytes().length);
		
		
		//POINT DB 에 들어갈 파일 명 추출
		photo.setImage(imagefile.getName());
		
		//cos.jar 자동 파일 업로드 
		//실제 파일 업로드 구현 (upload 업로드)
		
				String filename = imagefile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/upload"); //배포된 서버 경로 
				String fpath = path + "\\" + filename;
				System.out.println(fpath);
				
				FileOutputStream fs =null;
				try {
					     fs = new FileOutputStream(fpath);
					     fs.write(imagefile.getBytes());
					     
				} catch (Exception e) {
					
					e.printStackTrace();
				}finally {
					 try {
						fs.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				//DB작업 .... 파일 업로드 완료
				return "image/image";
		
	}
	
}
```

- 자세한건 SpringMVC_Basic03_Annotation에 ImageController를 참조하세요
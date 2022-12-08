# 2022.12.08. THU 📅
----------------
<br>

## 1. MVC_Annotation ✔
### 💡 main
![image](https://user-images.githubusercontent.com/111114507/206369367-1a9966bb-81a9-4e48-8ff8-e233e49ffe0d.png)
```html
<h3>TEST_1</h3>
<a href="hello.do">hello.do요청하기</a>

<h3>TEST_2 : http:전송 Form : method > GET , POST > 화면 처리해줘</h3>
<a href="article/newArticle.do">글쓰기</a>

<h3>TEST_3 : http : 전송 Form : method > GET, POST >> List(collection)</h3>
<a href = "order/order.do">주문하기 화면 (order.do)</a>

<h3>TEST_4 : parameter 다루기 (@RequestParm)</h3>
Default : <a href="search/external.do">external.do</a><br>
Default : <a href="search/external.do?p">external.do</a><br>
Default : <a href="search/external.do?query=100">external.do</a><br>
Default : <a href="search/external.do?p=200">external.do</a><br>
```
### 💡 TEST_1
### (1) web.xml -> spring-servlet.xml
<br>

### (2) HelloController.java
```java
@Controller
public class HelloController {
	public HelloController() {
		System.out.println("Hello컨트롤러 생성자 호출");
	}
	
	@RequestMapping("/hello.do")  //<a href="hello.do"></a>  요청이 오면 함수 실행
	public ModelAndView hello() {
		System.out.println("[hello.do method call]");
		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting",getGreeting());
		mv.setViewName("Hello");
		return mv;
	}
	
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String data="";
		if(hour >= 6 && hour<=10) {
			data="학습시간";
		}else if(hour >= 11 && hour<=13) {
			data="배고픈 시간";
		}else if(hour >= 14 && hour<=18) {
			data="졸린 시간";
		}else {
			data="go Home";
		}
		return data;
	}
```
- mv.addObject(a, b) : b 값을 a 에 넣어줌 (getGreeting()의 data 값을 .. )
- mv.setView(a) : spring-servlet에 suffix
- @Controller : Spring에게 해당 Class가 Controller의 역할을 한다고 명시하기 위해 사용하는 Annotation
- @RequestMapping("/hello.do") : 요청 들어온 URI의 요청과 Annotation value 값("/hello.do")이 일치하면 해당 클래스나 메소드가 실행
- 
<br>

### (3) Hello.jsp
```html
<h3>VIEW : ${greeting}</h3>
```
![image](https://user-images.githubusercontent.com/111114507/206369977-87054f9a-f7d8-4c73-93d8-30e26ba2acb6.png)
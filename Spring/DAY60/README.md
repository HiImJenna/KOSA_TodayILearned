# 2022.12.06. TUE 📅
----------------
<br>

## 1. Spring 문법 ✔
### 💡 Implement - MessageBean.java
```java
public interface MessageBean {
	void sayHello(String name);
}
``` 
<br>

### 💡 MessageBean_kr.java
```java
public class MessageBean_kr implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("안녕 " + name + " !");
	}

}
```
<br>

### 💡 MessageBean_en.java
```java
public class MessageBean_en implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name + " !");
	}

}
```
<br>


### 💡 xml
```xml
<bean id="messagebean" class="DI_03_Spring.MessageBean_en"></bean>	
```
- class에 MessageBean_en을 넣어줬음
<br>

### 💡 HelloApp.java
```java
public class HelloApp {

	public static void main(String[] args) {
		/*
		//영문
		//MessageBean_en messagebean_en = new MessageBean_en();
		//messagebean_en.sayHello("hong");

		//한글
		//MessageBean_kr messagebean_kr = new MessageBean_kr();
		//messagebean_kr.sayHello("hong");
		
		//인터페이스 사용 (다형성)
		MessageBean messagebean = new MessageBean_kr(); // new MessageBean_en();
		messagebean.sayHello("hong");
		*/
		
		//Spring 통해서 객체를 생성하고 조립하는 작업
		//1. 컨테이너 생성 (메모리)
		//2. 컨테이너 안에서 생성될 객체 만들고 주입하는 작업 (xml) >> DI_03.xml
		
		// new ClassPathXmlApplicationContext("DIConfig.xml");
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
		MessageBean message = context.getBean("messagebean",MessageBean.class);
		message.sayHello("hong");
	}
}
```
- xml에서 class에 MessageBean_en을 넣어줬기에 'message.sayHello("hong");'가 영어로 출력됨
- 한국어로 바꾸고 싶다면 거기만 kr로 바꿔주면 됨!  (implement하는 장점)
- ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml") : xml을 context에 넣어주고
- MessageBean message = context.getBean("messagebean",MessageBean.class) : bean의 id 값을 가져와 message에 넣어줌

<br>

```java
ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_05_Spring/DI_05.xml");
MyBean m = context.getBean("mybean", MyBean.class);
MyBean m2 = context.getBean("mybean", MyBean.class);
MyBean m3 = context.getBean("mybean", MyBean.class);
```
- 위의 getbean들은 모두 같은 주소값을 가져옴
- <h3> getbean() </h3>
    - 컨테이너 안에 있는 객체를 리턴 (new가 아님) <br>
    - return type Object (타입에 맞는 casting) <br>
    - 스프링 컨테이너 안에 객체들은 default로 singleton 가짐 <br>
    - 예외적으로 getbean() 이 new라는 작업을 할 수도 있음 (거의 사용하지 않음) <br>

## 2. Annotation ✔
- 클래스 , 필드 , 메서드 과 같은 프로그램 요소에 다양한 종류의 정보를 주는 방법
- 장점 : 코드량 감소 
- 단점 : 가독성 
<br>

### 💡 @Autowired 
- Type 기반
- 목적 : 의존관계를 자동설정할 때 사용하며 [타입을 이용]하여 의존하는 객체를 삽입해 준다. 
- 그러므로 (IOC Container) 해당 타입의 빈객체가 존재하지 않거나 또는 2개 이상 존재할 경우 스프링은 예외를 발생시키게 된다.
- 옵션 : required - @Autowired어노테이션을 적용한 프로퍼티에 대해 굳이 설정할 필요가 없는 경우에 false값을 주며 이때 해당 프로퍼티가 존재하지 않더라도 스프링은 예외를 발생시키지 않는다. (디폴트값은 true)
<br>

### 💡 @Qualifier
- 목적 : @Autowired의 목적에서 동일 타입의 빈객체가 존재시 특정빈을 삽입할 수 있게 설정한다. 
- 설정위치 : @Autowired 어노테이션과 함께 사용된다.
- 추가설정 : 동일타입의 빈객체 설정에서 <qualifier value="[alias명]" />를 추가하여 준다.
- 옵션 : name - alias명




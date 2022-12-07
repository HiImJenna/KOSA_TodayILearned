# 2022.12.06. TUE 📅
----------------
<br>

## 1. Spring 사용법 ✔

### 스프링 사용법!

스프링에 필요한 라이브러리 필요

- beans
- core
- context
- expression

---

1. 내가 필요한 클래스를 설계한다
2. 스프링에필요한 객체들이 필요한 설정
    - xml 파일 설정 (DIConfig.xml)
    - annotation 설정
3. xml 파일에 bean 만들고 필요한곳에서 getBean으로 가져오기

---

## 결론) 개발자가 NEW를 하지 않고 생성자가 꺼내서 쓰는 방식!

```
기존)
어떤 객체가 필요하면 직접
Emp emp = enw Emp() 사용

스프링)
xml 또는 annotation을 통해서 미리 객체를 생성해 놓고 사용하기

>> 미리 모든 부품을 만들고 놓고 조립만 해라 그리고 사용해라 (스프링)
```
<br>

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

## 2. IOC/DI ✔

### IOC)

IOC 컨테이너 (제어의 역전)
내가 주도했던 코드에서 Spring 이 주체 .....

- 작은 단위의 부품을 만들고 놓고 그 것을 조립하는 행위 (레고블럭)

### DI)

[DI개념]_1 : 의존성 주입 (의존 객체 주입)

xml 설정에서 타입을 명시하지 않은 값은: 문자열

```java
기존)
어떤 객체가 필요하면 직접
Emp emp = enw Emp() 사용

스프링)
xml 또는 annotation을 통해서 미리 객체를 생성해 놓고 사용하기

>> 미리 모든 부품을 만들고 놓고 조립만 해라 그리고 사용해라 (스프링)
```

## 3. Lombok
```
@getter/setter 등을 입력하고 컨트롤 + 스페이스바를 눌러 적용한다.

@Data를 쓰면 getter/setter toString 등등 다 설정을 해준다.
```
<br>

## 4. Annotation ✔
- 클래스 , 필드 , 메서드 과 같은 프로그램 요소에 다양한 종류의 정보를 주는 방법
- 장점 : 코드량 감소 
- 단점 : 가독성 
<br>

### 💡 @Autowired 
- Type 기반
- 목적 : 의존관계를 자동설정할 때 사용하며 [타입을 이용]하여 의존하는 객체를 삽입해 준다. 
- 그러므로 (IOC Container) 해당 타입의 빈객체가 존재하지 않거나 또는 2개 이상 존재할 경우 스프링은 예외를 발생시키게 된다.
- 옵션 : required - @Autowired어노테이션을 적용한 프로퍼티에 대해 굳이 설정할 필요가 없는 경우에 false값을 주며 이때 해당 프로퍼티가 존재하지 않더라도 스프링은 예외를 발생시키지 않는다. (디폴트값은 true)
- 추가설정 : AutowiredAnnotationBeanPostProcessor 클래스를 빈으로 등록시켜줘야 한다. 
- 해당 설정 대신에 <context:annotation-config> 태그를 사용해도 된다.
 ```java
<context:annotation-config>
```
- Annotation 사용에 필요한 모든 클래스를 한방에 객체로 만들어서 컨테이너에 올려 주는 역할
- 장점 : 각각의 Annotation 사용시 별도의 빈객체 설명 할 필요 없다.
- 단점 : 사용하지 않는 bean 자동 생성 된다
 ```java
    @Autowired 정상 동작 되지 않는 경우
 ```
1. injection 되는 타입 객체가 (bean) IOC 컨테이너 안에 없는 경우
2. IOC 컨테이너 안에 같은 타입의 객체 여러개 존재하는 경우
3. IOC 컨테이너 안에 같은 타입의 객체 여러개 존재 하더라도 bean 객체의 id 값이 setter 함수의 parameter 명과 동일하면 자동 주입 성공
4. 반대 : @Resource (by name)

<br>




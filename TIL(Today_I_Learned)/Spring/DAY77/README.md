# 2022.12.07. WED 📅
----------------
<br>

# 1. Annotation

## @Qualifier

- 목적 : @Autowired의 목적에서 동일 타입의 빈객체가 존재시 특정빈을 삽입할 수 있게 설정한다.
- 설정위치 : @Autowired 어노테이션과 함께 사용된다.
- 추가설정 : 동일타입의 빈객체 설정에서 <qualifier value="[alias명]" />를 추가하여 준다.
- 옵션 : name - alias명

## @Resource

목적 : 어플리케이션에서 필요로 하는 자원을 자동 연결(의존하는 빈 객체 전달)할 때 사용

- @Autowired 와 같은 기능을 하며
- @Autowired와 차이점은
- @Autowired는 타입으로(by type),
- @Resource는 이름으로(by name)으로 연결시켜준다는 것이다.

설정위치 : 프로퍼티, setter메소드
추가설정 : CommonAnnotationBeanPostProcessor 클래스를 빈으로 등록시켜줘야 한다.
해당 설정 대신에 context:annotation-config 태그를 사용해도 된다.
옵션 : name

## 중요!

```java
@Autowired by type
@Resource by name
```

## @Configuration

해당 클래스가 스프링의 설정으로 사용됨을 지정

DI_Config.xml과 같은 역할을 하도록 만듬

```java
***************************************************************************

class MemberRegisterService{
   private MemberDao memberdao;
   public MemberRegisterService(MemberDao memberdao){
      this.memberdao = memberdao;
   }
}

1. xml 설정

<bean id="memberdao" class="MemberDao" />
<bean id="memberRegSvc" class="MemberRegisterService">
     <constructor-arg  ref="memberdao">
</bean>

 1.1 추가 : @Autowired 적용
class MemberRegisterService{
   private MemberDao memberdao;   

   @Autowired
   public MemberRegisterService(MemberDao memberdao){
      this.memberdao = memberdao;
   }
}   

xml 문서

<context:annotation-config />   
<bean id="memberRegSvc" class="MemberRegisterService"></bean>
<bean id="memberdao" class="MemberDao" />   
    

2. @Configuration
   @bean
   두개의 어노테이션을 이용해서 (java 코드 기반의 작업)

   @Configuration
   class Configcontext{
         @bean
         public MemberRegisterService memberRegSvc(){
           return new MemberRegisterService(memberdao()); //함수를 통한 주입
         } 

         @bean
         public MemberDao memberdao(){
          return new MemberDao();
         }
   }

***************************************************************************
```

## @Controller

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
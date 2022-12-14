# 2022.12.14.WED 📅
----------------
<br>

# 1. 스코프 Scope ✔
### 💡 SqlSessionFactoryBuilder
```
이 클래스는 인스턴스화되어 사용되고 던져질 수 있다. SqlSessionFactory 를 생성한 후 유지할 필요는 없다. 그러므로 SqlSessionFactoryBuilder 인스턴스의 가장 좋은 스코프는 메소드 스코프(예를들면 메소드 지역변수)이다. 여러개의 SqlSessionFactory 인스턴스를 빌드하기 위해 SqlSessionFactoryBuilder를 재사용할 수도 있지만 유지하지 않는 것이 가장 좋다.
```
### 💡 SqlSessionFactory
```
한번 만든뒤 SqlSessionFactory는 애플리케이션을 실행하는 동안 존재해야만 한다. 그래서 삭제하거나 재생성할 필요가 없다. 애플리케이션이 실행되는 동안 여러 차례 SqlSessionFactory 를 다시 빌드하지 않는 것이 가장 좋은 형태이다. 재빌드하는 형태는 결과적으로 “나쁜냄새” 가 나도록 한다. 그러므로 SqlSessionFactory 의 가장 좋은 스코프는 애플리케이션 스코프이다. 애플리케이션 스코프로 유지하기 위한 다양한 방법이 존재한다. 가장 간단한 방법은 싱글턴 패턴이나 static 싱글턴 패턴을 사용하는 것이다. 또는 구글 쥬스나 스프링과 같은 의존성 삽입 컨테이너를 선호할 수도 있다. 이러한 프레임워크는 SqlSessionFactory의 생명주기를 싱글턴으로 관리할 것이다.
```

### 💡 SqlSession
```각각의 쓰레드는 자체적으로 SqlSession인스턴스를 가져야 한다. SqlSession인스턴스는 공유되지 않고 쓰레드에 안전하지도 않다. 그러므로 가장 좋은 스코프는 요청 또는 메소드 스코프이다. SqlSession 을 static 필드나 클래스의 인스턴스 필드로 지정해서는 안된다. 그리고 서블릿 프레임워크의 HttpSession 과 같은 관리 스코프에 둬서도 안된다. 어떠한 종류의 웹 프레임워크를 사용한다면 HTTP 요청과 유사한 스코프에 두는 것으로 고려해야 한다. 달리 말해서 HTTP 요청을 받을때마다 만들고 응답을 리턴할때마다 SqlSession 을 닫을 수 있다. SqlSession 을 닫는 것은 중요하다. 언제나 finally 블록에서 닫아야만 한다. 다음은 SqlSession을 닫는 것을 확인하는 표준적인 형태다.
```
#### [나쁜냄새가 나는 코드]
```JAVA
public class SqlMapClient {
	private static SqlSession session;
	
	static {
		String resource = "SqlMapConfig.xml";
		try {
			  Reader reader =  Resources.getResourceAsReader(resource);
			  SqlSessionFactory factory=  new  SqlSessionFactoryBuilder().build(reader);
			  session = factory.openSession();
		}catch (Exception e) {
			
		}
	}
	public static SqlSession getSqlSession() {
		return session;
    }
}
```
#### [개선시킨 코드]
```java
public class SqlMapClient {
	private static SqlSessionFactory sqlsessionfactory;
	static {
		String resource = "SqlMapConfig.xml";
		try {
			 Reader reader = Resources.getResourceAsReader(resource);
			 sqlsessionfactory = new SqlSessionFactoryBuilder().build(reader);
			 
		}catch(Exception e) {
		}
	}
	 public static SqlSessionFactory getSqlSession(){
		  return sqlsessionfactory;
	  }	
}
```
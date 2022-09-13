# 2022.09.13.Tue 📅
<br>

## 1. ArrayList ✔
-----------------------------
<br>

### ArrayList와 LinkedList의 차이점
![image](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fi.stack.imgur.com%2FskN72.png%22&type=cafe_wa740)

▶ linkedlist와 arraylist의 가장큰 차이는 inkedlist 는 각 원소마다 앞,뒤 원소의 위치값을 가지고 있고,arraylist 는 index가 있다.
<br>

#### 🔔 조회(get) 

- 조회시에 arraylist는 index가 있기 때문에, 조회가 한번에 가능하다,

```java
elementData[index] = element;
```

그러나 linkedlist의 경우 처음부터 하나씩 다 타고들어가야 되기때문에 뒤에있는 놈을 찾을 수록 오래걸린다.
<br>

#### 🔔 삽입(add)

- arraylist는 마지막에 추가할경우 자체적으로 확장을 하면되고 
```java
elementData[size++] = e;
```

- 중간에 삽입이 되는 경우는 해당 위치를 기준으로 arraycopy를 진행한다.
```java
System.arraycopy(elementData, index, elementData, index + 1, size - index);elementData[index] = element;
```
<br>

#### 🔔 삭제(remove) 

- arraylist 같은경우에는 내부적으로 remove 해야되는 item을 제외하고 삽입처럼 arraycopy를 시도한다. 반면 linkedlist는 삽입과 마찬가지로 해당 item을 찾아 제거하고, 앞뒤 원소의 위치값만 조정해주면 된다.
<br>

#### <해당 함수들의 실제 수행시간>  
![image](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fwww.programcreek.com%2Fwp-content%2Fuploads%2F2013%2F03%2Farraylist-vs-linkedlist1.png%22&type=cafe_wa740)

조회시에는 arraylist가 우위지만, 삽입/삭제 시에는 linkedlist가 뛰어난 성능을 보여준다.  
즉 대량의 삽입삭제가 빈번하게 발생하는 곳에서는 linkedlist를 db에서 단순히 조회만 할 경우에는 arraylist를 사용하면 된다.

출처 : https://cafe.naver.com/kosait
<br>

## 2. Stack & Queue ✔
-----------------------------
<br>

![image](https://user-images.githubusercontent.com/111114507/189794365-dbdcc147-dda7-4f3f-92a4-ff5a0329dde7.png)
<br>

### <Stack의 실생활 속 예>
- 쌓아놓은 물건은 아래서부터 뺄수없다.  
- 인터넷을 하다가 뒤로가기를 누르면 방문한 순서대로 뒤로 간다.  
- 한글문서를 작성하다가 되돌리기를 누르면 방금전에 수행한 동작을 원래대로 되돌린다.  
<br>

### <Queue의 실생활 속 예>
- 버스정류장에서 사람들이 줄을 선대로 버스에 탄다.  
- 음식점에서 주문한 순서대로 음식을 받는다.  
<br>

출처 : https://github.com/Bamjong
<br>

### 🔔push(), pop(), boolean empty(), boolean full() 구현하기

```java
public boolean empty() {
		return(top == -1); //true
	}
	
	public boolean full() {	
		return (top == maxsize-1); //5개 방 [0] [1] [2] [3] [4]
	}
	
	public void push(Object i) {
		if(full()) {
			System.out.println("stack full ... ");
		} else {
			//POINT
			stackarr[++top] = i; //처음 top = -1 >> [0]
		}
		
	}
	
	public Object pop() {
		Object value = null;
		if(empty()) {
			System.out.println("stack empty ... ");
		} else {
			value = stackarr[top];
			top--;
		}
		return value;
	}
```
<br>


## 3. Generic ✔
-----------------------------
<br>

```java
<Generic 사용 이유>
Collection 타입의 클래스 >> 데이터의 기본 저장 공간 타입 : Object
 장점 : Object 어떤 값을 넣어도 소화(String, Emp, int)
 단점 : 큰 타입에 대한 문제, 원하는 데이터 타입으로 변경(다운캐스팅) ... 불편
 
 1. 타입을 처음부터 강제 ... 
 2. 타입의 안정성 확보 (타입 강제)
 3. 강제 형번환 필요 없다 : (Car)Object (필요 없다)
 
 제너릭 적용을 위해서는 설계도부터 적용 ... 
 ```

 ```java
 //Generic 타입 강제 : 다 먹지는 못하지만 (한 종류만) >> 
ArrayList<Person> plist = new ArrayList<Person>();
plist.add(new Person());
plist.add(new Person());

for(Person p : plist) { //장점 : 타입을 명확히 알고 있음(강제)
	System.out.println(p.age);
}

ArrayList<String> slist = new ArrayList<String>();
slist.add("문자열");
```
### 🔔 Generic Quiz)
```java
		//1. Array 사용해서 tv, audio, notebook을 담을 수 있는 cart 배열을 생성하고 제품을 담으세요.
		Product[] cart = new Product[3];
		cart[0] = new KtTv();
		cart[1] = new Audio();
		cart[2] = new NoteBook();
		//2. ArrayList Generic을 사용해서 cart 배열을 만들고 제품을 담으세요
		//ArrayList<Product> pcart = new ArrayList<Product>();
		List<Product> pcart = new ArrayList<Product>();
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new NoteBook());
		
		for(Product product : pcart) {
			System.out.println(product);
		}
		
		//3. Emp 클래스 (kr.or.kosa) - ArrayList Generic 사용해서 사원 3명을 만드세요.
		ArrayList<Emp> emplist = new ArrayList<Emp>();
		emplist.add(new Emp(1000, "김씨", "IT"));
		emplist.add(new Emp(1000, "고씨", "IT"));
		emplist.add(new Emp(1000, "손씨", "IT"));
		// 3-1. 사원의 정부를 toSTring() 사용하지 말고 사번, 이름, 직종울 출력하세요 (개선된 for문)
		for(Emp emp : emplist) {
			System.out.println(emp.getEmpno() + " / " + emp.getEname() + " / " + emplist);
		}
		//3-2. 위와 동일한데 개선된 for문이 아니고 일반 for문 사용해서 사번, 이름, 직종울 출력하세요
		for (int i = 0; i < emplist.size(); i++) {
			System.out.println(emplist.get(i).getEmpno() + " / " + emplist);
		}
		List<CopyEmp> clist = new ArrayList<CopyEmp>();
		clist.add(new CopyEmp(100, "김씨", 1000));
		clist.add(new CopyEmp(200, "고씨", 2000));
		clist.add(new CopyEmp(300, "허씨", 5000));
		
		//1. 200번 사원의 급여를 6000으로 수정하세요(일반 for문을 통해서) getter, setter
		for (int i = 0; i < clist.size(); i++) {
			if(clist.get(i).getEmpno() == 200) {
				clist.get(i).setSal(6000);
				System.out.println(clist.get(i).toString());
			}
		}
		
		//2. 300번 사원의 이름을 박씨에서 "궁금해씨"로 수정해서 그 결과를 출력하세요(개선된 for)
		for (CopyEmp emp : clist) {
			if(emp.getEmpno() == 300) {
				emp.setEname("궁금해씨");
				System.out.println(emp.toString());
			}
		}
```
<br>

## 4. Interator ✔
-----------------------------
<br>

```java
Collection FrameWork
 (수 많은 인터페이스와 그 것을 구현하고 있는 수 많은 클래스가 있어요)
 
 Interator 인터페이스
 (반복자)
 [나열된 자원에 대해 순차적으로 접근해서 값을 리턴하는 **표준**을 정의]
 추상함수로 정의하고 있다 >> ArrayList는 추상함수를 구현(표준화된)
 
  Interator 인터페이스가 가지고 있는 추상 함수
  >> hasNext(), Next(), remove() 추상
  >> ArrayList implements Interator{ hasNext()를 재정의 구현하고 있음 }
```

## 5. HashSet ✔
-----------------------------
<br>

```java
 Set  인터페이스 (원 안에 들어가세요) : 순서 보장x >> 중복 허락 x
 순서가 없고 중복을 허락하지 않는 데이터 집합
 구현하는 클래스
 HashSet, TreeSet(자료구조)
 ```

```java
//Quiz
//HashSet을 사용해 1~45까지의 난수 6개를 넣으세요
/* 예전 lotto class 활용
    int[] lotto
    lotto[i] = (int)(Math.random()*45 + 1);
    
for(int j = 0; j<i; j++) {
    if(lotto[i] == lotto[j]) {
    i--;
    break;
    }
}
```
## (1)
```java
HashSet<Integer> lotto = new HashSet<Integer>();
for (int j = 0; lotto.size()<6; j++) {
    int num = (int)(Math.random()*45 + 1);
    lotto.add(num);
    System.out.println("i : " + j + " / num : " + num);
}

System.out.println(lotto.toString());
```
## (2)
```java
Set set2 = new HashSet();
		int index = 0;
		while(set2.size() < 6) {
			int num = (int)(Math.random()*45 + 1);
			set2.add(num); // add 추상 함수를 HashSet클래스가 재정의 
		}
		System.out.println(set2.toString());
```

## 6. TreeSet ✔
-----------------------------
<br>

![imgae](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fczb0Rs%2FbtqEt6tVogn%2FKpmfrL9PfiNK9ioz0WkRq1%2Fimg.png)

```java
*Set : 순서(x), 중복(x)
      
<TreeSet>
순서(x), 중복(x), 정렬기능(o)
검색하거나 정렬 필요로 하는 자료구조(데이터 집합)
로또
중복 데이터 .... 출력 정렬(낮은 값부터)

<특징>
1. 이진 트리 구조 (나무 거꾸로 들고 보세요) : root > leaf
2. 데이터 저장시 정렬기능이 제공
```
<br>

## 7. Map ✔
-----------------------------
<br>

```java
Map인터페이스
 
 (key, value) 쌍의 구조를 갖는 배열
 ex) 지역번호(02, 서울) (031, 경기)
 
 조건)
 key 중복(x) >> Set
 value 중복(o) >> List
 
 Generic 지원 
 
 Map 인터페이스 구현하는 클래스
 구버전 : HashTable(동기화) : lock - 자원보호
 신버전 : HashMap (동기화 강제하지 않아요) 성능고려 (Thread 학습 ... ) ******
 ```

 ### 🔔 Quiz)
 ```java
*id 와 pwd 받으세요
*id는 공백 제거 >> 소문자 변환  (String 함수)
*pwd 공백제거
id(0) , pwd(0) >> 회원님 방가방가  출력하세요 while 탈출
id(0) , pwd(x) >> 아이디 , 비밀번호 확인해 주세요 입력 받게 ...

id(x) , pwd(0) >> id 재입력 하세요 출력   아이디 , 비밀번호 입력
id(x) , pwd(x) >> id 재입력 하세요 출력   아이디 , 비밀번호 입력
3가지 논리를 if문을 제어
```
```java
Scanner sc = new Scanner(System.in);

while(true) {
	System.out.println("id, pwd  입력해 주세요");
	
	System.out.println("ID");
	String id = sc.nextLine().trim().toLowerCase();
	
	System.out.println("PWD");
	String pwd = sc.nextLine().trim();
	
	if( !loginmap.containsKey(id)) {
			//id(x)
			System.out.println("id 맞지 않습니다 ... 재입력 하세요");
	}else {
			//id(0)
			if(loginmap.get(id).equals(pwd)) {
					System.out.println("회원님 방가방가 ^^");
					break;
			}else {
					System.out.println("비밀번호 확인하세요");
			}
	}
```
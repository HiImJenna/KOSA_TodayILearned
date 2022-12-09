# 2022.09.14.Wed 📅
<br>

## 1. Map_Generic ✔
-----------------------------
<br>

### Q) HashMap을 사용한 도서관리 프로그램
```
도서관리 프로그램 ... HashMap  사용해서
도서정보를 저장하는 클래스
Book  클래스 (도서번호 , 도서제목 , 도서가격)
BookManager (도서 추가 , 도서 삭제 , 도서 검색 , 도서목록 )
HashMap 활용
```
```java
public class Quiz_BookManage{
    public static void main(String[] args) {
        BookManager bookmanager = new BookManager();

        System.out.println("====================");
        System.out.println("도서 관리 프로그램");
        System.out.print("====================");

        bookmanager.run();

    }
}

class Book{ //isbn, 제목, 가격

    int isbn;
    String title;
    int price;

    public Book(int isbn, String title, int price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    } 

    @Override
    public String toString() {
        return super.toString();
    }
}

class BookManager{
    Map<Integer, Book> addBook;
    Scanner sc = new Scanner(System.in);

    BookManager() { addBook = new HashMap<Integer, Book>(); }

    void add(){

        System.out.print("추가할 도서 ISBN : ");
        int isbn = Integer.parseInt(sc.nextLine());

        System.out.print("도서 제목 : ");
        String title = sc.nextLine();

        System.out.print("가격 : ");
        int price = Integer.parseInt(sc.nextLine());

        addBook.put(isbn, new Book(isbn, title, price));

        System.out.printf("'ISBN : %d | 이름 : %s | 가격 : %d'을 생성하였습니다", isbn, title, price);
        System.out.println();
    }

    void delete(){

        System.out.print("삭제할 도서 ISBN : ");
        int isbn = Integer.parseInt(sc.nextLine());
        addBook.remove(isbn);
        System.out.println("삭제하였습니다.");
    }

    void search(){
        Set<Integer> keyList = addBook.keySet();

        System.out.print("검색할 도서 ISBN : ");
        int isbn = Integer.parseInt(sc.nextLine());

        if(addBook.containsKey(isbn) == true){
            for(Integer key : keyList){
                System.out.printf("ISBN:%d | 이름:%s | 가격:%d", addBook.get(isbn).isbn, addBook.get(isbn).title, addBook.get(isbn).price);
                System.out.println();
            }
        } 
    }

    void list (){ //도서 수, 도서번호, 도서제목 , 도서가격
        Set<Integer> keyList = addBook.keySet();
        System.out.println("<도서 목록>");
        System.out.println("도서수 :  " + keyList.size());

        for(Integer key : keyList){
            System.out.printf("ISBN:%d | 이름:%s | 가격:%d", addBook.get(key).isbn, addBook.get(key).title, addBook.get(key).price);
            System.out.println();
        }
    }

    void isbnList(){ //도서 수, 도서번호
        Set<Integer> keyList = addBook.keySet();
        System.out.println("<ISBN 목록>");
        System.out.println("도서수 :  " + keyList.size());

        for(Integer key : keyList){
            System.out.printf("ISBN : %d", addBook.get(key).isbn);
            System.out.println();
        }
    }

    void run(){
        while(true){
            System.out.println();
            System.out.print("1:추가 2:삭제 3:검색 4:도서 목록 5:ISBN 목록 0:종료 >> ");
            int choice = Integer.parseInt(sc.nextLine()); //서비스 선택
 
            if(choice == 1) {
                add();
            } else if(choice == 2){
                delete();
            } else if(choice == 3){
                search();
            } else if(choice == 4) {
                list();
            } else if(choice == 5) {
                isbnList();
            } else if (choice == 0) {
                System.out.println("프로그램을 종료합니다");
                break;
            }
        }
        

        sc.close();

        }
}
```

## 2. Properties ✔
-----------------------------
<br>

```java
 사용목적)
 1. App 전체에 사용되는 자원 관리
 2. 환경변수
 3. 프로그램 버전 관리  
 4. 파일경로
 5. 공통변수

```
```java
public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("admin", "kosa@or.kr");
		prop.setProperty("version", "1.x.x.x");
		prop.setProperty("downpath", "C:\\Temp\\images");
		//각각의 개발 페이지에서
		System.out.println(prop.getProperty("admin"));
		System.out.println(prop.getProperty("version"));
		System.out.println(prop.getProperty("downpath"));
	}
```


## 3. wrapper class ✔
-----------------------------
<br>

![image](https://postfiles.pstatic.net/MjAxNzA5MTlfNTUg/MDAxNTA1NzQ4Nzk4MDk0.N6FWHTn6Iio08ykA0n2-pys9Zr0imo036a_g2jNJd5gg.GGD_XCziPHctpYKiN1enXpO_JCsncRQJrIlb_alcKSQg.PNG.cestlavie624/1.PNG?type=w2)

```java
8가지 기본 타입에 대해서 객체 형태로 사용 가능 하도록 만든 클래스(wrapper class)
 [ 사용 ]
1. 매개변수 객체 요구될때
2. 기본형 값이 아닌 객체 형태로 저장이 필요시
3. 객체간 값 비교
4. 타입 변환시 처리 

>>generic 설계 (객체 형태) > int > Integer
```

## 4. Calendar ✔
-----------------------------
<br>

```java
* Calendar 를 상속받아 완전히 구현한 클래스는 
* GregorianCalendar 
* buddhisCalendar 있는데 getInstance()는 [시스템의 국가와 지역설정]을 [확인]해서

태국인 경우 buddhisCalendar 의 인스턴스를 반환하고 그 외에는 GregorianCalendar
의 인스턴스를 반환한다
GregorianCalendar 는 Calendar를 상속받아 오늘날 전세계 공통으로 사용하고 있는 
그레고리력에 맞게 구현한 것으로 태국을 제외한 나머지 국가에서는 GregorianCalendar 사용
그래서 인스턴스를 직접 생성해서 사용하지 않고 메서드를 통해서 인스턴스를 반환받게하는
이유는 최소의 변경으로 프로그램 동작을 하도록 하기 위함
class MyApp{
static void main(){
Calendar cal = new GregorianCalendar();
다른 종류의 역법의 사용하는 국가에서 실행하면 변경...... } }
class MyApp{
static void main(){
Calendar cal = new getInstance();
다른 종류의 역법의 사용하는 국가에서 실행하면 변경...... } }
API : 생성자 Protected Calendar() 
```
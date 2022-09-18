import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Quiz_BookManage{
    public static void main(String[] args) {
        BookManager bookmanager = new BookManager();

        System.out.println("====================");
        System.out.println("도서 관리 프로그램");
        System.out.print("====================");

        bookmanager.run();

    }
}

// 도서관리 프로그램 ... HashMap  사용해서
// 도서정보를 저장하는 클래스
// Book  클래스 (도서번호 , 도서제목 , 도서가격)
// BookManager (도서 추가 , 도서 삭제 , 도서 검색 , 도서목록 )
// HashMap 활용해서
// 1:추가 2:삭제 3:검색 4:도서 목록 5:ISBN 목록 0:종료

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

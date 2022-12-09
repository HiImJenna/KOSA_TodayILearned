package 클래스.j_Dictionary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
    }
}

class Dictionary{

    private static String [] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String [] eng = {"love", "baby", "money", "future", "hope"};

    public static String[] getKor() {
        return kor;
    }

    public static String[] getEng() {
        return eng;
    }

    public static String kor2Eng(String word) {
        return null;
    }
}

class DicApp {
    Dictionary dic = new Dictionary();
    Scanner sc = new Scanner(System.in);

    void run(){
       
        while(true) {
        System.out.println("한영 단어 검색 프로그램입니다");
        System.out.println("한글 단어 : ");
        String kword = sc.nextLine();

            if(kword == "사랑"){
                System.out.println(dic.getEng());
            } else if(kword == "아기") {

            } else if(kword == "돈") {

            } else if(kword == "미래") {

            } else if (kword == "희망") {

            } else if (kword == "그만") {
                System.out.println("프로그램을 종료합니다");
                break;
            }
        }   
    }


}
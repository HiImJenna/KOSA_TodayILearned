import java.util.Stack;

public class Ex06_Stack_Queue {

	public static void main(String[] args) {
		
		//JAVA API 제공하는 ㅋ르래스
		//Collection JAVA API 제공
		
		//Stack 자료구조 가지는 클래스 제공 받아요
		
		Stack stack = new Stack(); //LIFO 
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println();

	}

}

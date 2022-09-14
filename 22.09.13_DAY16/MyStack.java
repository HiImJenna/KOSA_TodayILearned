package kr.or.kosa;

//stack 직접 구현해보기
//1. stack 저장 공간 (Array), 저장공간 타입(Object)
//2. 위치정보 : 저장되는 값이 있는 위치 (index) hint) 전자제품 매장 cart 사용해서 처리
//3. 기능 :  push(), pop(), boolean empty(), boolean full()

public class MyStack {
	private Object[] stackarr; //저장소
	private int maxsize; //최대크기
	private int top;
	
	public MyStack(int maxsize) {
		this.maxsize = maxsize;
		stackarr = new Object[maxsize];
		top = -1; //배열의 시작값 0(index)
		
	}
	//push(), pop(), boolean empty(), boolean full()
	
//	public void push() {
//		top++;
//		stackarr = new Object[top];
//	}
//	
//	public void pop() {
//	    System.out.println(stackarr[top].toString());
//	    top--;
//	}
//	
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
}
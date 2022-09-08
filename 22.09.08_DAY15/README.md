# 2022.09.08.Thu 📅
<br>

## 1. 라이브러리와 프레임워크 ✔
-----------------------------
<br>

### 🔔 차이점
- 흐름에 대한 제어 권한이 어디에 있느냐..  
- 프레임워크는 전체적인 흐름을 자체적으로 가지고 있으며, 프로그래머가 그 안에 필요한 코드를 작성한다. => 제어의 역전이 적용되어있다.  
- 라이브러리는 사용자가 흐름에 대해 제어를 하며 필요한 상황에 가져다 쓴다.  
![image](https://images.velog.io/images/tjdud0123/post/cf64f995-0315-442a-928e-0c3a2a68d64b/framework-vs-library.png)
<br>
  
### 🔔 컬렉션 프레임워크
![image](https://mblogthumb-phinf.pstatic.net/MjAyMDAyMjVfMTI5/MDAxNTgyNjMyMjMwMTk1.9IMMEVLeWF7uPIWChIgZSKyhKrdP-UEwQNfLU8_n28kg.eqdEvrAEPmnYmlFG_xq8LkH-tS53QpteMU_XLwSwJRQg.PNG.tptptpduf/image.png?type=w800)
- #### List : 순서가 있는 데이터의 집합, 데이터의 중복을 허용한다.
- #### Set : 순서를 유지하지 않는 데이터의 집합, 데이터의 중복을 허용하지 않는다.
- #### Map : 키(key)와 값(value)의 쌍으로 이루어진 데이터의 집합으로 순서는 유지되지않으며 키는 중복을 허용하지 않고 값은 중복을 허용한다.
        -> ex) 우편번호, 지역번호
<br>

## 2. ArrayList ✔
--------------------------
![이미지](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdTm8ja%2FbtqMYaopkFc%2FuZL2zJbY7fFvX0NrF0Sudk%2Fimg.png)

<br>

- #### ArrayList는 자바의 List 인터페이스를 상속받은 여러 클래스 중 하나
- #### 일반 배열과 동일하게 연속된 메모리 공간을 사용하며 인덱스는 0부터 시작
- #### 배열이 크기가 고정인 반면 ArrayList는 크기가 가변적으로 변함

<br>

>>ArrayList 부모타입은 List 이다 (OK) >> 다형성  
>>Collection 은 ArrayList의 부모타입이다.(OK) >> 다형성
<br>

- .add(Object) : ArrayList의 마지막에 데이터 추가 / .add(int index, Object) : index 에 데이터 추가
- .set(int index, Object) : 값 변경
- .clear( ) : 모든 값 삭제
- .remove( ) : 값을 하나씩 제거
- .size( ) : 크기


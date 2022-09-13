# 2022.09.13.Tue 📅
<br>

## 1. ArrayList ✔
-----------------------------
<br>

### ArrayList와 LinkedList의 차이점
![image](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fi.stack.imgur.com%2FskN72.png%22&type=cafe_wa740)

▶ linkedlist와 arraylist의 가장큰 차이는 inkedlist 는 각 원소마다 앞,뒤 원소의 위치값을 가지고 있고,arraylist 는 index가 있다.

![image](https://cafe.naver.com/ca-fe/cafes/30787723/articles/319?page=1&boardtype=L&referrerAllArticles=true&oldPath=%2FArticleRead.nhn%3Fclubid%3D30787723%26page%3D1%26boardtype%3DL%26articleid%3D319%26referrerAllArticles%3Dtrue#)

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

<해당 함수들의 실제 수행시간>
![image](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fwww.programcreek.com%2Fwp-content%2Fuploads%2F2013%2F03%2Farraylist-vs-linkedlist1.png%22&type=cafe_wa740)

조회시에는 arraylist가 우위지만, 삽입/삭제 시에는 linkedlist가 뛰어난 성능을 보여준다.  
즉 대량의 삽입삭제가 빈번하게 발생하는 곳에서는 linkedlist를 db에서 단순히 조회만 할 경우에는 arraylist를 사용하면 된다.

출처 : 
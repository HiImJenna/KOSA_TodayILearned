# 2022.12.28.WED 📅
----------------
<br> 

## 1. 컴포넌트 ✔
```js
function Card() {
  return(
    <>
    </>
  )
}
export default Card;
```
<br>

### [어제 내가 한 것]
```js
{image.map((el, i) => {
    // let fullLink =  "https://raw.githubusercontent.com/ai-edu-pro/busan/main/t" + (i+1) + ".jpg"
    return (
    <div className='col-md-4'>
            <img src={el.image} width="80%"/>
            <h4>{el.title}</h4>
            <p>{el.content}</p>
            <p>{el.price}</p>
    </div>   
    )
})}       
```
<br>

### [Map과 화면뿌리기 나누는 버전]
```js
{
shirts.map((item,i)=>{
    return <Card shirts={shirts[i]} i={i} key={i}/>
})
}
<Card shirts={shirts}/>
```
- 부모에서 map 처리
```js
//function Card()
function Card(props){
  return(
    <div className="container">
      <div className="row">
        <div className="col-md-4">
          <img src={props.shirts.img} width={'80%'}/>
            <h4>{props.shirts.title}</h4>
            <p>{props.shirts.content}</p>
            <p>{props.shirts.price}</p>
        </div>
      </div>
    </div>
  )
}
```
- 부모 자원을 props로 가져와서 화면에 뿌리기만?
<br>

# 2. Router ✔
- 페이지 이동
### [Termimal]
```
 npm i react-router-dom@6
```
<br>

### [index.js]
```js
import { BrowserRouter } from 'react-router-dom';

root.render(

  <>
    <BrowserRouter>
     <App />
    </BrowserRouter>
  </>
);
```
<br>

### [App.js]
```js
<Routes>
    <Route path='/detail' element={<div>상세페이지</div>}/>
    <Route path='/about' element={<div>회사 정보 페이지</div>}/>
</Routes>
```
- url 뒤에가 path 값이면 ...

## 💡 Route 안에 Route & Outlet
### [App.js]
```js
<Route path='/event' element={<Event/>}>
    <Route path='one' element={<div>1+1</div>}/>
    <Route path='two' element={<div>포인트</div>}/>
</Route>
```
- /event/one
- /event/two
<br>

### [components/Event.js]
```js
import { Outlet } from "react-router-dom";
function Event() {
    return(
        <>
            <h1>Event page</h1>
            <Outlet></Outlet>
        </>
    )
}
export default Event;
```
- Outlet : App.js에서 넘겨준 element 값을 받아주는 역할
<br>

## 3. 상세페이지 및 뒤로가기 버튼 ✔
### [Detail.js]
```js
function Detail({shrits}){

    let {id} = useParams();
    let findId = shrits.find((item) => item.id == id); //검증
    let navigate = useNavigate();

    console.log(findId)

    return(
        <div className="container">
            <Box>
                <YellowBtn>Detail page</YellowBtn>
            </Box>
                <ColorwBtn>Detail page</ColorwBtn>
            <div className="col-md-4">
                <img src={findId.img} width={'80%'}/>
                <h4>{findId.title}</h4>
                <p>{findId.content}</p>
                <p>{findId.price}원</p>

                <button className="btn btn-danger">주문하기</button>
                <button onClick={() => { navigate(-1) }} className="btn btn-primary">뒤로하기</button>
                <button className="btn btn-success">홈</button>
                <button className="btn btn-dark"> 장바구니</button>
            </div>
        </div>
    )
} 
```
- find 함수는 실행될 떄 안의 값이 true 라면 그 값을 저장함
- 뒤로가기 버튼을 만들기 위해선 navigate 사용
- navigate(-1) : 한 페이지 뒤로
<br>

# 4. Lifecycle
![image](https://user-images.githubusercontent.com/111114507/209777361-a51bbb06-ce3d-4909-83b6-bb1d652d09f3.png)
- 크게 생성 될때, 업데이트 할 때, 제거할 때 세가지 유형으로 나눌 수 있음
- 마운트는 DOM이 생성되고 웹 브라우저 상에서 나타나는 것을 뜻하고, 반대로 언마운트는 DOM에서 제거되는 것을 뜻함
```js
import { Component } from "react";

class LifeCyclecom extends Component {
    componentDidMount() {
        //컴포넌트가 mount 될 때 코드 실행
    }

    componentDidUpdate() {
        //컴포넌트가 update 될 때 코드 실행
    }

    componentWillUnmount() {
        //컴포넌트가 unmount 될 때 코드 실행
    }
}
```
<br>

### 💡 useEffect()
- useEffect(() => {}) : 재렌더링마다 코드 실행
- useEffect(()=>{}, []) - 대괄호 있을때 : mount될때 1회만 실행
- useEffect(()=>{}, ['상태변수']) : 상태변수가 작동될 때 실행
- useEffect(()=>{}, return) : unmount
<br>

### 💡 증가 버튼 클릭 (update)
```js   
useEffect(() => {
    //여기에 기재하면 이 코드는 컴포넌트의 생성/업데이트/소멸 실행
    console.log('react');
})

<button onClick={() => {setCount(count+1)}}>증가</button>
{count}
```
![image](https://user-images.githubusercontent.com/111114507/209778355-a289ed60-2968-48f9-b920-a6b92b0e4bb7.png)
<br>

# 4. setTimeout ✔
- Function Component에서 Hook을 이용하여 state 관리를 진행
- 이 때, setTimeOut을 사용하면 일정 시간 후 코드를 비동기적으로 실행
```
setTimeout(function() { // Code here }, delay);
```

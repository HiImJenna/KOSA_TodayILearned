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

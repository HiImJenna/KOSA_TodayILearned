# 2022.12.30.FRI 📅
----------------
<br> 

# 1. Redux
- 컴포넌트들이 props없이 state 공유 가능
- 컴포넌트 업데이트 관련 로직을 다른 파일로 분리시켜서 더욱 효율적으로 관리할 수 있다.
- 컴포넌트끼리 똑같은 상태를 공유해야할 때도 여러 컴포넌트를 거치지 않고 손쉽게 상태 값을 전달하거나 업데이트 할 수 있음
```
npm install    @reduxjs/toolkit    react-redux 
```
<br>

### [App.js]
```js
root.render(
 // <React.StrictMode>
  <Provider store={store}>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </Provider>
 // </React.StrictMode>
);
```
<br>

### [store.js]
- 한 개의 프로젝트는 한개의 스토어만 가질 수 있다.
```js
let user =  createSlice( {  
        name :  'user',
        initialState : 'yuna',
        reducers: {
            changeName(state){
                return 'doteon ' + state;
            }
        }
})
```
<br>

### [Cart.js]
```js
  let value = useSelector((state)=>{return state})
```
- useSelector : State에 있는 값을 전부 가져온다.
- 그 값들을 변수 value에 넣어준다.
```js
<button className="btn btn-dark" onClick={() => dispatch(changeCnt())}>+</button>

```
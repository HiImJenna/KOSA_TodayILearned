# 2022.12.26.MON 📅
----------------
<br> 

# 1. REACT ✔
개발환경 구성

- 웹브라우저: Chrome
- 작업툴: Visual Studio Code
- Node.js LTS Version
- React

## 1) 설치하기

### 💡 Node.js

```java
1. https://nodejs.org/en/
2. ##.##.# LTS 버전 다운 (버전은 최신버전)
```

- LTS: 업체측에서 계속 지원을 해주는 버전
- Node를 설치하면 자동으로 NPM까지 설치완료

### 💡 Visual Studio Code

```java
1. https://code.visualstudio.com/
2. OS에 맞는 버전 다운
```

### 💡 React 프로젝트 만들기

```bash
npx create-react-app [응용프로그램이름(폴더명지정)]
npx create-react-app .
npx create-react-app daily-blog
```
<br>

### 💡 환경변수 설정하기

#### 시스템 변수에 환경변수 설정하기

![https://user-images.githubusercontent.com/92353613/209490823-7d8626f4-cb20-4c85-8076-3e527091dc17.png](https://user-images.githubusercontent.com/92353613/209490823-7d8626f4-cb20-4c85-8076-3e527091dc17.png)

```bash
C:\Program Files\nodejs
```

## 2) 폴더 설명

![https://user-images.githubusercontent.com/92353613/209490476-49dfcb04-f536-4453-9a6d-4a2dd8d7e1f0.png](https://user-images.githubusercontent.com/92353613/209490476-49dfcb04-f536-4453-9a6d-4a2dd8d7e1f0.png)

- package.json / package-lock.json
    - Spring Maven pom.xml 이랑 비슷한것이다. 이곳에서 필요한걸 적으면 node_modules에 필요한 파일들이 저장된다.
<br>

```
npm start
```
## 3) 블로그 실습
### 1. index.html
```html
  <!-- bootstrap css cdn -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css"> <!-- reset css -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>


</head>
<body>
  <noscript>You need to enable JavaScript to run this app.</noscript>
  <div id="root"></div>
</body>
```
- 여기에 cdn 걸면 자동으로 다 걸리는듯
- div id = root : root 찾아서 실행하겠다.
<br>

### 2. index.js
```js
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
    {/* <Hello /> */}
  </React.StrictMode>
);

 reportWebVitals();
```
- root로 지정해주고
- App 실행하겠다
<br>

### 3. App.js
```js
function App() {
let nickName="jenna"
let [title, setTitle] = useState(["혜화 서커스", "강남 서커스", "홍대 서커스", "종로 서커스"]);
let [like, setLike] = useState([0,0,0,0]);
let [count, setCount] = useState(0);

// function change() {
//   console.log(1);
// }

return (
  <div className="App">
  <div onClick={()=>{ setCount(count = count+1) 
    console.log(count); }}>안녕!!</div>
    <header className = "">
    <div className="nav"> 버섯 서커스단</div>
    <p>{nickName} 님 버섯 서커스에 오신 것을 환영합니다</p>
    <a href="https://www.naver.com/" rel="nooper noreferrer" target="blank">네이버</a>
    </header>
    <br></br>
    
    {title.map((el, i) => {
      return (
        <div className="list" key={i}>
          <h3>
            {el}
            <span
              onClick={() => {
                let likeCnt = [...like]; //[1,0,0,0]
                likeCnt[i]++;
                setLike(likeCnt);
              }}
            >
              👍
            </span>
            {like[i]}
          </h3>
          <p>3월 02일 발행</p>
          <hr />
        </div>
      );
    })}
)
```
![image](https://user-images.githubusercontent.com/111114507/209533484-0a6efd48-9717-4820-91c0-294a6a28800f.png)



## 4) App.js
### [실행순서]
```js
import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
```
![image](https://user-images.githubusercontent.com/111114507/209492285-641d9ab0-2c29-48df-b189-7d73d52c7a74.png)
- 저장만 하면 새로고침 없이도 바로 변경됨
<br>

## 4) 컴포넌트 만드는 방법
### 💡 class
```js
class MyComponents extends Component {
    // 상태변수 선언
    state = {
        number : 0,
        message : 'th1-703',
        validate : false,
        meessages: ['AngularJS', 'React', 'Vue', 'Ember']
    }
 
    render(){
            return(
            <>
                <h3>Hello {message}</h3>
            </>
        )
    }
}
export default MyComponents;

```
<br>

### 💡 function 
- tag는 단 하나만 들어갈 수 있음
```js
function Hello() {
    return (
        <div>Hello</div>
        <p>fdfd</p>
    )
}
```
- 태그 두개라 오류남~!
- 루트 태그를 만들고, 그 안에서 작업하여 해결
```js
function Hello() {
    return (
        <div>
            <h1> Hello Component</h1>
           <p>리액트 재미있어요!</p>
        </div>
    )
}
export default Hello;
```
- div : 루트 태그
- export .. : 밖에서도 쓰겠다 -> 다른 곳에서 import 해서 사용 가능
```js
import Hello from './Hello';
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/* <App /> */}
    <Hello />
  </React.StrictMode>
);
reportWebVitals();
```
<br>

## 5) 반복문
### map()
```js
function logArrayElements(1) { } // 배열안에 있는 각각의 데이터 처리
function logArrayElements(1,2) { }  // 1- 데이터, 2- 인덱스번호
function logArrayElements(1,2,3) { }  // 3- 배열의 전체 데이터 
 
function logArrayElements(element,index, array) {
    console.log('a[' + index + '] =    ' + element);
}
//[2,5,9].forEach(logArrayElements);
 
let arr = [2,5,9];
arr.forEach(logArrayElements);
해야할일
arr.map(할일)
arr.map(function(){  })
arr.map(()=> { return xxz  })
arr.map(()=>xxz)

```
- 두번 찍히는건 index.jsp에서 'React.StrictMode' 주석 해주기
```js
<h1>{messages.map((item,i,arr) => (console.log(item + ',' + i + " " + arr)))}</h1>
```
- item : i 번째의 배열 안에 있는 내용
- i : index
- arr : 배열 전체

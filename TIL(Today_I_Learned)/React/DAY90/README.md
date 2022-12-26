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

### 💡 환경변수 설정하기

시스템 변수에 환경변수 설정하기

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
## 3) App.js
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
- 오류남~!
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
//eslint-disable//
import './App.css';
import MyComponents from './components/MyComponents'
import Hello from './components/Hello';

function App() {
  const str = "React!!! - str";
  const name = "함수형 컴포넌트 - name"; 

  return (
    <div className="App">
      <h1> Hello world</h1>
      
      <MyComponents name={name} str = {str}/>

      <Hello kbs={name} str={str} />

    </div>
  );
}

export default App;
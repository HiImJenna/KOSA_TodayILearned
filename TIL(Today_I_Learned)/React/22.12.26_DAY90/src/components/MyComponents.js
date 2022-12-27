import {Component} from 'react';

class MyComponents extends Component{
    
    // constructor(props){ this를 적음으로서 MyComponents 생성자에게 선언한다란 뜻이다
    //     this.state ={
    //         //상태변수(state variable)
    //         number: 0,
    //         age: 10,
    //         name: 'yuna'
    //     }
    // }


    // 상태변수 선언
    state = { //state를 적음으로서 그냥 일반 변수 선언이다
        number : 0,
        message : 'th1-703',
        validate : false,
        messages : ['AngularJS', 'React', 'Vue', 'Ember'] 
    }

    render(){
        const {name, str} = this.props;
        const {message,number,validate,messages} = this.state;
        let irum = 'yuna'
        let x,y,z = 3;
        // function logArrayElements(element,index, array) {
        //     console.log('a[' + index + '] = ' + element);
        // }
        // console.log([2,5,9].forEach(logArrayElements));
        //
        //
        // messages.map((index) => (console.log(index)))

        return(
            <>
                <h3>Hello {messages}</h3>
                <p>{irum}님 반가워요!!</p>
                <span>고범종님 반가워요</span>
                <h2>{validate}</h2>
                <h3>{message}</h3>
                <h4>{number}</h4>
                <h3>{name}</h3>
                <h3>{str}</h3>

                <p>-----------------------------------------------</p>
                <h1>{messages.map((item,i,arr) => (console.log(item + ',' + i + " " + arr)))}</h1>
                <p>-----------------------------------------------</p>
                <p>{x},{y},{z}</p>
            </>
        )
    }

}

export default MyComponents;
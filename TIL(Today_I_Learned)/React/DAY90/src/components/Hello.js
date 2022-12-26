function Hello(props){
    return(
        <div>
            <h1> hello component</h1>
            <p>리액트 재미있어요!!</p>
            <div>{props.kbs}</div> 
            <div>{props.str}</div>
        </div>
    )
}

export default Hello;
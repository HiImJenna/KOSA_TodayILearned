# 2022.10.17. MON 📅
----------------
<br>

## 1. Javascript - DOM 계층트리 ✔
```js
    <script>
        window.onload=function(){
            //DOM 객체 자원 ... 
            //모든 자원에 대한 사용이 가능 ...

            //계층트리 (node 개념 접근 : 부모, 자식, 형제 개념)
            let menode;
            menode = document.getElementById("me");
            menode.style.backgroundColor = "gold";

            let parentnode = menode.parentNode; //body
            parentnode.style.backgroundColor="green";

            let grandnode = parentnode.parentNode; //html
            grandnode.style.backgroundColor="blue";

            let my = document.getElementById("mychild");
            console.log(my);
            console.log(my.firstChild.nodeName);//LI
            console.log(mt.firstChild.innerText); //LI >> AA
            //innerHTML, innerText >> value 없는 친구 >> p, div, li, span
            //BB라는 Text 값을 가지고 오고 싶으면?
            console.log(my.firstElementChild.nextSibling.innerText); //BB

            console.log(my.childNodes);
            //질문 : mychildNodes return type >> Array
            //[<li>AA</li>][<li>BB</li>][<li>CC</li>]
            console.log(my.childNodes[0]);
            console.log(my.childNodes.length);


        }
    </script>
</head>
<body>
    <div>A</div><div>B</div><div id="me">C</div><div>D</div><div>E</div>
    <ul id="mychild"><li>AA</li><li>BB</li><li>CC</li></ul>
</body>
```

## 2. Javascript - event ✔
- 하나의 요소는 여러개의 event를 가질 수 있다.
- 이벤트가 더 이상 필요하지 않다면 removeEventListner() 제거 가능 (단 addEvent 추가)
```js
<body>
    <button id="mybtn">클릭</button>
</body>
<script text="text/javascript">
    let x = document.getElementById("mybtn");

    x.addEventListener("mouseover", myFunc);
    x.addEventListener("mouseout", myFunc2);
    x.addEventListener("mouseclick", myFunc3);


    function myFunc(){
        document.getElementById("mybtn").innerHTML += "Mouse Over<br>";
    }
    function myFunc2(){
        document.getElementById("mybtn").innerHTML += "Mouse Out<br>";
    }

    function myFunc3(){
        document.getElementById("mybtn").innerHTML += "Click<br>";
    }

</script>

```
<br>

### 🔔 캠쳐링 & 버블링
- #### 캡쳐링  
![image](https://joshua1988.github.io/images/posts/web/javascript/event/event-capture.png)
<br>
 
- #### 버블링  
![image](https://joshua1988.github.io/images/posts/web/javascript/event/event-bubble.png)

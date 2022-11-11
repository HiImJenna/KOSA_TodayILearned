# 2022.11.09.WED 📅
----------------
<br>

## 1. eXERD ✓

## 리버스 엔지니어링

- 기존 DB에 연결한 후 자동으로 ERD를 만들어 주는 것

## 2. 칸반보드 ✓

[자바 스크립트: 드래그 앤 드랍 사용 기술](https://www.notion.so/f2af0ea1727a4e91b35aee257f89370d) 

[자바 스크립트 : 드래그 앤 드랍 기초](https://www.notion.so/a681b409d73f482091f5f94173d58021) 

[자바 스크립트 : Flex](https://www.notion.so/Flex-9db8eba549b54f6d9e98553f397e985c) 

Drag 파이널부분

```jsx
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="drag2.css">

    <script>
        $(function(){ //페이지가 로드 되면
            action1(); //기존의 todo에 이벤트 걸기

            $(document).on('click', "#todocreate", function(){ //todo 생성 버튼 클릭할 경우
                html = "<p class='draggable' draggable='true'>" + $("#todo").val() +"<br><button id='updat' type='button' class='btn btn-success btn-sm m-2'>수정</button><button id='del' type='button' class='btn btn-success btn-sm m-2'>삭제</button></p>";

                $("#todoboard").append(html);

                document.getElementById("createboard").className += " visually-hidden";

                action1(); //todo에 이벤트 걸기
            });

        });

        function action1(){
            const draggables = document.querySelectorAll(".draggable"); //nodeList 반환
            const containers = document.querySelectorAll(".container");

            draggables.forEach(draggable => {
                draggable.addEventListener("dragstart", () => {
                    draggable.classList.add("dragging");
                });

                draggable.addEventListener("dragend", () => {
                    draggable.classList.remove("dragging");
                });
            });

            containers.forEach(container => {
                container.addEventListener("dragover", e => {
                    e.preventDefault();
                    const afterElement = getDragAfterElement(container, e.clientX);
                    const draggable = document.querySelector(".dragging");
                    if (afterElement === undefined) {
                        container.appendChild(draggable);
                    } else {
                        container.insertBefore(draggable, afterElement); //드래그 할수 있는 위치 중 옮겨진 위치에 삽입
                    }
                });
            });

            function getDragAfterElement(container, x) {
                const draggableElements = [
                    ...container.querySelectorAll(".draggable:not(.dragging)"),
                ];

                return draggableElements.reduce(
                    (closest, child) => {
                        const box = child.getBoundingClientRect();
                        const offset = x - box.left - box.width / 2;
                        // console.log("offset: " + offset);
                        // console.log("closest: " + closest.offset);
                        if (offset < 0 && offset > closest.offset) {
                            return { offset: offset, element: child };
                        } else {
                            return closest;
                        }
                    },
                    { offset: Number.NEGATIVE_INFINITY },
                ).element;
            }

        }

        $(document).on('click', '#del', function(){
            console.log($(this).parent("p"));
            $(this).parent("p").remove();
        });

        let block = "";

        //todo 블럭의 수정을 누를 경우
        $(document).on('click', '#updat', function(){

            $('#todo1').empty(); //기존 문장 지우기

            //보이게하기 숨기기
            if(document.getElementById("createboard1").classList.item(2) == null){
                document.getElementById("createboard1").className += " visually-hidden";
            }else{
                document.getElementById("createboard1").classList.remove("visually-hidden");
            }

            //선택한 todo의 문자열 가져와서 textarea에 넣기
            $('#todo1').val($(this).parent('p').html().trim().split('<',1));

            block = $(this).parent('p');
        });

        //수정하기의 수정 버튼을 누를 경우
        $(document).on('click', '#todoupdate', function(){
            block.empty();

            html2 = $("#todo1").val() +"<br><button id='updat' type='button' class='btn btn-success btn-sm m-2'>수정</button><button id='del' type='button' class='btn btn-success btn-sm m-2'>삭제</button>"

            block.append(html2);

            document.getElementById("createboard1").className += " visually-hidden";

            action1();

        });

    </script>

</head>

<body>

    <div class="text-center my-5 header">
        <h2>1조 Board</h2>
        <button id="create" type="button" class="btn btn-success" >todo 추가하기</button>
    </div>

    <div class="board">
        <div class="container text-center" id="todoboard">
            <h3>ToDo</h3>
            <p class="draggable" draggable="true">
                과제 끝내기<br>
                <button id="updat" type="button" class="btn btn-success btn-sm m-1">수정</button>
                <button id="del" type="button" class="btn btn-success btn-sm m-1">삭제</button>
            </p>
            <p class="draggable" draggable="true">
                점심 먹기<br>
                <button id="updat" type="button" class="btn btn-success btn-sm m-1">수정</button>
                <button id="del" type="button" class="btn btn-success btn-sm m-1">삭제</button>
            </p>
        </div>
        <div class="container text-center" id="successboard">
            <h3>완료</h3>
            <p class="draggable" draggable="true">
                아침 먹기<br>
                <button id="updat" type="button" class="btn btn-success btn-sm m-1">수정</button>
                <button id="del" type="button" class="btn btn-success btn-sm m-1">삭제</button>
            </p>
            <p class="draggable" draggable="true">
                저녘 공부하기<br>
                <button id="updat" type="button" class="btn btn-success btn-sm m-1">수정</button>
                <button id="del" type="button" class="btn btn-success btn-sm m-1">삭제</button>
            </p>
        </div>
        <div class="container text-center" id="falseboard">
            <h3>실패</h3>
            <p class="draggable" draggable="true">
                아침 먹기<br>
                <button id="updat" type="button" class="btn btn-success btn-sm m-1">수정</button>
                <button id="del" type="button" class="btn btn-success btn-sm m-1">삭제</button>
            </p>
            <p class="draggable" draggable="true">
                저녘 공부하기<br>
                <button id="updat" type="button" class="btn btn-success btn-sm m-1">수정</button>
                <button id="del" type="button" class="btn btn-success btn-sm m-1">삭제</button>
            </p>
        </div>
    </div>

    <div id="createboard" class="text-center my-5 visually-hidden">
        <label for="exampleDataList" class="form-label">ToDo 만들기</label>
        <textarea class="form-control" id="todo" placeholder="할일을 작성해주세요"></textarea>
        <button id="todocreate" type="button" class="mt-2 btn btn-success" >추가</button>
    </div>

    <div id="createboard1" class="text-center my-5 visually-hidden">
        <label for="exampleDataList" class="form-label">ToDo 수정하기</label>
        <textarea class="form-control" id="todo1"></textarea>
        <button id="todoupdate" type="button" class="mt-2 btn btn-success" >수정</button>
    </div>

    <script>
        //할일 보드 생성
        document.getElementById("create").addEventListener('click', function(){
            
            if(document.getElementById("createboard").classList.item(2) == null){
                document.getElementById("createboard").className += " visually-hidden";
            }else{
                document.getElementById("createboard").classList.remove("visually-hidden");
            }
        })

        //할일 추가
        document.getElementById("todocreate").addEventListener('click', function(){
            let todo = document.getElementById("todo").value;
            console.log(todo);
        })

        document.getElementById("todo").addEventListener('click', function(){
            let todoboard = document.getElementById("todoboard");
            let p = document.createElement("p");
        })

    </script>

</body>

</html>
```
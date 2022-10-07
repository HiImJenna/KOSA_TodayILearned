# 2022.10.07. FRI 📅
----------------
<br>

## 1. CSS ✔
### 🔔 padding
- 박스 안!
- The CSS padding property defines a padding (space) between the text and the border.
```html
<!DOCTYPE html>
<html>
<head>
<style>
p {
  border: 2px solid powderblue;
  padding: 30px;
}
</style>
</head>
<body>

<h1>This is a heading</h1>

<p>This is a paragraph.</p>
<p>This is a paragraph.</p>
<p>This is a paragraph.</p>

</body>
</html>
```
![image](https://user-images.githubusercontent.com/111114507/194440232-64eb23fb-3c50-402d-9d33-26294fa7235b.png)
<br>


### 🔔 margin
- 박스 밖!
- The CSS margin property defines a margin (space) outside the border.
```html
<style>
p {
  border: 2px solid powderblue;
  margin: 50px;
}
</style>
```
![image](https://user-images.githubusercontent.com/111114507/194440357-ffcb0de8-8ad0-4cd1-ba0f-c65da445bfe2.png)
<br>

### 🔔 Links
#### < 가상 선택자 > : 의미만 존재 : :link, :visited, :hover, :active
- a:link - a normal, unvisited link
- a:visited - a link the user has visited
- a:hover - a link when the user mouses over it
- a:active - a link the moment it is clicked
<br>

### 🔔 Selectors
#### 1) element Selector
```css
p {
  text-align: center;
  color: red;
}
```
<br>

#### 2) id
```css
/*style*/
#kglim {color: gold}
/*body*/
<p id="kglim">id라는 속성을 이용해서 CSS적용</p>
```
- '#' 만든것은 id적용 page에 1개만 적용
<br>

#### 3) class
```css
/*style*/
  .hong{color: blue}
/*body*/
  <p class="hong">class라는 속성을 사용해서 CSS적용</p>
  <p class="hong">class라는 속성을 사용해서 CSS적용</p>
  <p class="hong">class라는 속성을 사용해서 CSS적용</p>

```
-  '.' 만든것은 class적용, 1 page에 여러개 적용  
<br>

[출력값]  
![image](https://user-images.githubusercontent.com/111114507/194443695-baeba570-2215-41f1-83de-e995485b5105.png)
<br>

## 2. HTML - Table ✔
<details>
<summary>코드</summary>

```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
    <style type="text/css">
        table {
            border-collapse: collapse;
            width: 70%;
        }

        /* 붕괴하다 */
        th, td {
            border: 1px solid red;
            text-align: center;
            padding: 5px;
        }
        tr:nth-child(even) {/*짝수 */
        background-color: gray;
        }
    </style>

</head>

<body>

    <h2>HTML Table</h2>

    <table>
        <tr>
            <th>Company</th>
            <th>Contact</th>
            <th>Country</th>
        </tr>
        <tr>
            <td>Alfreds Futterkiste</td>
            <td>Maria Anders</td>
            <td>Germany</td>
        </tr>
        <tr>
            <td>Centro comercial Moctezuma</td>
            <td>Francisco Chang</td>
            <td>Mexico</td>
        </tr>
        <tr>
            <td>Ernst Handel</td>
            <td>Roland Mendel</td>
            <td>Austria</td>
        </tr>
        <tr>
            <td>Island Trading</td>
            <td>Helen Bennett</td>
            <td>UK</td>
        </tr>
        <tr>
            <td>Laughing Bacchus Winecellars</td>
            <td>Yoshi Tannamuri</td>
            <td>Canada</td>
        </tr>
        <tr>
            <td>Magazzini Alimentari Riuniti</td>
            <td>Giovanni Rovelli</td>
            <td>Italy</td>
        </tr>
    </table>

</body>

</html>
```

</details>

[출력값]  
![image](https://user-images.githubusercontent.com/111114507/194447953-9326987a-6764-40bd-97bd-ba48c9f4345a.png)
- th : header (bold체)
- td : cell
- tr : row
- border-collapse: collapse; : 선 두개 겹치게 하기 (간격 collapse시킴)
<br>

### 🔔 Table 병합하기
- colspan ="x" : 가로방향으로 셀이 합쳐짐
- rowspan ="x" : 세로방향으로 셀이 합쳐짐
- 합치고 싶은 셀 수 만큼 x에 대입

<details>
<summary>코드</summary>

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>테이블 병합하기</title>

    <style type="text/css">
        table {border-collapse: collapse;}
        th, td{border: 1px solid blue;}
    </style>

</head>

<body>
    <h3>일반테이블</h3>
    <table>
            <tr>
                <td>가</td><td>나</td><td>다</td>
            </tr>
            <tr>
                <td>라</td><td>마</td><td>바</td>
            </tr>
            <tr>
                <td>사</td><td>아</td><td>자</td>
            </tr>
    </table>
    <hr>

    <h3>일반테이블2</h3>
    <table style="height: 200x; width: 500px">
            <tr>
                <td>글번호</td><td>제목</td><td>조회수</td>
            </tr>
            <tr>
                <td>1</td><td>방가방가</td><td>102</td>
            </tr>
            <tr>
                <td>2</td><td>안녕</td><td>103</td>
            </tr>

    </table>
    <hr>

    <h3>일반테이블 병합</h3>
   
    <table style="height: 200x; width: 500px">
            <tr>
                <td colspan="2">가, 나</td><td>다</td>
            </tr>
            <tr>
                <td>라</td><td>마</td><td>바</td>
            </tr>
            <tr>
                <td colspan="3">사, 아, 자</td>
            </tr>
    </table>

    <h3>일반테이블 병합2</h3>
    <table style="height: 200x; width: 500px">
            <tr>
                <td colspan="2" rowspan="2">가, 나, 라, 마</td><td>다</td>
            </tr>
            <tr>
                <td>바</td>
            </tr>
            <tr>
                <td>사</td><td>아</td><td>자</td>
            </tr>
    </table>
</body>
</html>
```
</details>
<br>

## 3. HTML - List ✔
```html
<body>
   <ul>
      <li>Coffee</li>
      <li>Tea</li>
      <li>Milk</li>
   </ul>

   <ul>
      <li>Coffee</li>
      <li>Tea
         <ul>
            <li>Black tea</li>
            <li>Green tea</li>
         </ul>
      </li>
      <li>Milk</li>
   </ul>
</body>

```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/194451875-f5634743-5dba-4e30-9273-61f9a1d1d491.png)
<br>

## 4. HTML - Layout ✔
![image](https://user-images.githubusercontent.com/111114507/194453856-97c5b2ca-f250-4491-bde9-a03054fe1d5f.png)
<br>

### 🔔 float

<details>
<summary>코드</summary>

```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="EUR-KR">
    <title>영역을 정의하는 div와 float</title>
</head>



<body>
    <div style="width: 100px; height:100px; background-color: yellow;"></div>
    <div style="width: 100px; height:100px; background-color: red;"></div>
    <div style="width: 100px; height:100px; background-color: blue;"></div>
    <hr>
    <div style="width: 100px; height:100px; background-color: yellow; float: left"></div>
    <div style="width: 120px; height:100px; background-color: red;"></div>
    <div style="width: 100px; height:100px; background-color: blue;"></div>
    <hr>
    <div style="width: 100px; height:100px; background-color: yellow; float: left"></div>
    <div style="width: 100px; height:100px; background-color: red; float: left"></div>
    <div style="width: 100px; height:220px; background-color: blue;"></div>
    <hr>
    <div style="width: 100px; height:100px; background-color: yellow; float: left"></div>
    <div style="width: 100px; height:100px; background-color: red; float: left"></div>
    <div style="width: 100px; height:100px; background-color: blue; float: left"></div>
    <hr>
    <div style="width: 100px; height:100px; background-color: yellow; float: left"></div>
    <div style="width: 100px; height:100px; background-color: red; float: left"></div>
    <div style="width: 100px; height:100px; background-color: blue; clear:both"></div>
</body>

</html>
```
</details>

### 🔔 div & float
<details>
<summary>코드</summary>

```html
<!DOCTYPE html>
<html>
<head>
   <meta charset="EUC">
   <title>Insert title here</title>
   <style type="text/css">
      #wrap {width: 600px; margin: auto;}
      #header {height: 50px; background: black;}
      #main {margin-top: 10px;}
      #left_main {
         height: 300px; 
         width: 100px; 
         background-color: gray; 
         margin-right: 10px; 
         float: left;
      }
      #right_main{
         height: 300px; 
         width: 490px; 
         background-color: gray; 
         float: left;
      }
      #m {clear: both;}
      #footer{
         height: 50px; 
         margin-top: 10px; 
         background: black;
      }
        #down{
            width: 100%;
            height: 50px;
            background-color: blue;
        }
   </style>
</head>
<body>

   <div id="wrap">
      <div id="header"></div>

      <div id="main">
         <div id="left_main">
         
         </div>
         <div id="right_main">

         </div>
      </div>

      <div id="m"></div>
      
      <div id="footer"></div>

        <div id="down"></div>

   </div>

</body>
</html>

```
</details>
<br>

## 5. HTML - Form ✔
```html
 form 태그는 전송을 담당하는 태그(클라이언트가 입력한 데이터를 가지고 서버로 가기)
        네이버 > 회원가입 요청 > 회원가입 페이지 전달 > 정보입력(id, pwd, address ... ) > 네이버 서버로 전송
        > 네이버는 전송받은 데이터를 처리 > DB 연결 > 입력한 정보를DB에 insert > 성공 > 결과전달

        form 전송수단(운송) 
        1. action =" " : 목적지 주소 >> JSP : action = "loginok.jsp"
                                   >> servlet : action="login.do"
        2. method ="" : 전송방식
         - method ="GET" : 배를 타고 가는 것 > loginok.jsp
                         ex) http://193.168.0.12:8090/WebBasic/loginok.jsp?id=hong&pwd=1004
                         >> 서버가 정보를 받아서 처리
                         >> 주소에 입력한 정보가 노출
                        **GET 전송 방식을 사용 ... (링크를 타고 가는 전송)
                        >> 게시판에 글 번호 클릭(상세보기로 가는 경우)
                        <a href = "boardconctent.jsp?num=100&category=board">100번글</a>

         - method ="POST" : 비행기 타고 가는 것 > loginok.jsp
                         ex)  http://193.168.0.12:8090/WebBasic/loginok.jsp
                              http 프로토콜 내부에 (header) 숨겨서 데이터 전송 (id=hong&pwd=
```
<br>

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Form 태그 안에 구현하는 Input 태그들</title>
</head>
    <body>
        <form action="">
            <fieldset>
                <legend>Text:Passord</legend>
                Text: <input type="text" name="userid" id="userid"><br>
                Password : <input type="password" name="pwd" maxlength="5"><br>
                <hr>
                Text : <input type="text" maxlength="10" value="기본값" size="100px">
                <hr>
                readonly(읽기전용 : 서버로 전송 가능)
                Text: <input type="text" name="userid" id="userid" value="hong" readonly = "readonly"><br>
                disabled(비활성화 : 서버 전송 불가능)
                Text: <input type="text" name="userid" id="userid" value="hong" disabled = "disabled"><br>

            </fieldset>
```
<br>

#### <checkbox>
```html
            <fieldset>
                <legend>체크박스(다중선택)</legend>
                당신의 취미는 <br>
                농구: <input type="checkbox" name="sports_1" value="A" checked=""checked>
                야구 : <input type="checkbox" name="sports_2" value="B">
                축구 : <input type="checkbox" name="sports_3" value="C">
            </fieldset>
            <!--
                get방식
                register.jsp?sports_1=A&sports_2=B&sports_2=C >> 서버로 전송

                String s = request.getParameter("sports_1");
                String s2 = request.getParameter("sports_2");
                String s3 = request.getParameter("sports_3");

                String[] sportsarr = request.getParameterValues("sports")
                sportsarr[0] = "A"
                sportsarr[1] = "B"
                sportsarr[2] = "C"
            -->
        
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/194483577-b248219d-6f03-4213-a234-dd62181ad6d9.png)
<br>

#### <select tag>
```html
<fieldset>
                <legend> select 태그 (단일 선택(년월일))</legend>
                <select name = "year">
                    <option value="2022">2022년</option>
                    <option value="2021">2021년</option>
                    <option value="2020">2020년</option>
                </select>
                <!--
                    register.jsp?year=2022 서버로 전송
                    서버에서 받는 데이터는 문자열 데이터
                    int year = Integer.parseInt(request.getParameter("year"));
                    
                -->

</fieldset>
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/194485091-3157e625-92f0-4a5b-a3b2-b58408134322.png) 
- muliple을 하면 다중 선택이 가능하지만 웹 접근성 문제로 사용하지 않는다.   

#### < radio >
```html
<fieldset>
    <legend>라디오버튼(단일선택 : 남, 여) : name 같으면 하나의 그룹</legend>
    남<input type="radio" name="gender" value="1"><br>

    여<input type="radio" name="gender" value="2"><br>
    <br>

    대<input type="radio" name="product" value="1"><br>
    중<input type="radio" name="product" value="2"><br>
    소<input type="radio" name="product" value="3"><br>

</fieldset>
```
- name = "x"에서 x가 다르면 다른 그룹으로 분류되어 다 선택이 가능하게 된다.
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/194486192-9880cf60-5705-42c7-87a2-dab0801fc8cd.png)
<br>

#### < Etc ... >
```html
<fieldset>
<legend>기타 등등</legend>
1. 화면에 출력되지 않음 (소스는 가지고 있음)
<input type="hidden" value = "1000" name = "데이터">
<hr>
2. 파일 업로드(클라이언트 파일 선택 가능
<input type="file" name="imgup">
<hr>
3. 게시판 글 쓰기 (여러줄) : 초기 화면의 크기 (rows, cols-> 몇줄에 몇칸)
<textarea rows="10" cols="50">기본크기</textarea>
<hr>
4. 각종 버튼들
<input type="button" value="나 눌러봐" onclick="alert('쉬는시간')">
<hr>
<!--
    type = "image"
    type = "submit"
    type = "reset"
-->

</fieldset>
```
[출력값]  
![image](https://user-images.githubusercontent.com/111114507/194487342-21862254-a14b-42f2-b4fd-3d064988f57d.png)
<br>

#### < HTML 5 >

- Input Type Color
```html
<input type="color" id="favcolor" name="favcolor" value="#ff0000">
```
<br>

- Input Type Date
```html
<input type="date" id="birthday" name="birthday">
```
<br>

- Input Type Datetime-local
```html
<input type="datetime-local" id="birthdaytime" name="birthdaytime">
```
<br>

- Input Type Number
```html
<input type="number" id="quantity" name="quantity" min="1" max="5">
```
<br>

- Input Type Range
```html
 <input type="range" id="vol" name="vol" min="0" max="50">
 ```
<br>

- The list Attribute
```html
<input list="browsers" name="browser">
<datalist id="browsers">
<option value="Internet Explorer">
<option value="Firefox">
<option value="Chrome">
<option value="Opera">
<option value="Safari">
```

출처 : https://www.w3schools.com/html/html_form_attributes.asp
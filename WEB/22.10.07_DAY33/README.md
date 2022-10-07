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



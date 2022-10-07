# 2022.10.07. FRI 📅
----------------
<br>

## 1. CSS ✔
### 🔔 padding
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
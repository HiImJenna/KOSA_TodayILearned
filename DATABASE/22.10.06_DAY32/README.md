# 2022.10.06. THU 📅
----------------
<br>

## 1. 모델링 예제 ✔
```
모델링과 데이터베이스의 설계 및 구축을 포함한 IT 기술을 전문적으로 강의하는 우리학원에는 강사가 10명이 있으며 각각의 강사는 자신이 담당하는 과목이 한과목인 강사도 있고 두 과목이상 강의하는 강사도 있다. 우리 학원에 개설된 과목은 총 17개의 과목이며 강의실은 6개가 존재하므로 강의 계획을 잘 수립하여야 한다. 강의가 끝나면 그 주에 강의했던 내용에 대해 수강생으로부터 설문지를 받아 다음 강의에 참고 자료로 이용한다. 매 주 1회씩 강사회의를 하여 서로의 강의내용과 수강생에 대한 이야기를 주고 받는다. 과목에 따라서는 선수과목을 듣지 않으면 수강할 수 없는 과목도 존재한다.

​엔티티 , 어트리뷰트 , 식별자 , 관계 만들어 보세요
```
[우리 조]  
![image](https://cafeptthumb-phinf.pstatic.net/MjAyMjEwMDZfMjA2/MDAxNjY1MDIyNDEyNDk2.d51ewAizsU3haqYKlstxPuOCKgyhd8BRmqSBUaKkCxwg.mlYdfE6bsT4VnXmhQQKQO41ej0-BnnDrBJQN5csR3SEg.PNG/KakaoTalk_20221006_111232886.png?type=w1600)
▶ 뭔가 하다 만 느낌이라는 교수님의 피드백..ㅠㅠ
<br>

[잘한 조]  
![image](https://cafeptthumb-phinf.pstatic.net/MjAyMjEwMDZfMTcw/MDAxNjY1MDIzMjcxMDU3.AvquY6HsqQxVeZkzXKIc1dIb-bIOfHyo0vZMSKtWInog.q_ggdSsuRZGMVMb7O7xLuQ5RK7QLl8dYeqY2uhXwjbIg.PNG/image.png?type=w1600)
<br>

## 2. HTML ✔ 
- 출처 : HTML 교육 사이트 https://www.w3schools.com/html/default.asp

### 🔔 WAS
- WEB 서버 : HTML 문서같은 정적 컨텐츠를 처리하는 것 (HTTP 프로토콜을 통해 읽힐 수 있는 문서)
- WAS 서버 : asp, php, jsp 등 개발 언어를 읽고 처리하여 동적 컨텐츠, 웹 응용 프로그램 서비스를 처리하는 것
<br>

#### <Tomcat>
- https://tomcat.apache.org/download-90.cgi
- 웹서버  :  웹브라우저의 요청을 받아서 처리한 결과를 웹브라우저에게 전달하는 역할. 만약 프로그램 처리가 필요하다면 어플리케이션 서버를 사용하거나 프로그램을 직접 호출하여 결과를 생성
- 어플리케이션서버 : 웹서버가 처리하지 못하는 결과값을 처리해야하는 연산이라던지의 처리를하고나서 결과를 웹서버에게 전달하는 역할
- 웹서버에서는 정적인것들을 처리하고, 어플리케이션서버가 프로그램기능을 제공하는 이유는 성능때문
<br>

### 🔔 HTML INTRODUCTION
#### < HTML Page Structure >
![image](https://user-images.githubusercontent.com/111114507/194275748-a2cb1850-bf17-4c55-9dae-30ed328ff7e4.png)


### 🔔 HTML BASICS (feat.Attribute)
### < Headings >
![image](https://user-images.githubusercontent.com/111114507/194248450-4cf8a562-721e-4440-9aae-d7829c83388d.png)
-----------

### < Paragraphs > 
![image](https://user-images.githubusercontent.com/111114507/194278774-0ec94217-4a59-4af5-88e2-7176d515b833.png)
```html
<!DOCTYPE html>
<html>
<body>

<p>
This paragraph
contains a lot of lines
in the source code,
but the browser 
ignores it.
</p>

<p>
This paragraph
contains      a lot of spaces
in the source     code,
but the    browser 
ignores it.
</p>

<p>
The number of lines in a paragraph depends on the size of the browser window. If you resize the browser window, the number of lines in this paragraph will change.
</p>

</body>
</html>
```
[출력값]
```html
This paragraph contains a lot of lines in the source code, but the browser ignores it.

This paragraph contains a lot of spaces in the source code, but the browser ignores it.

The number of lines in a paragraph depends on the size of the browser window. If you resize the browser window, the number of lines in this paragraph will change.
```
▶ new lines, spaces are ignored.  
▶ 처음에는 그냥 br 쓰면 되는거 아닌가 했지만 긴 문장이나 여러 문장을 묶어서 구분하고 싶을 땐 p를 쑤는게 좋겠다고 생각했다.
- hr : horizontal rule (구분선으로써 markdown에서 '------'과 같은 기능이라고 보면 됨)

----------------

### < Links >
![image](https://user-images.githubusercontent.com/111114507/194248780-33cc317d-2ca3-4e9e-8790-7dc868bfacbd.png)
- The <a> tag defines a hyperlink, which is used to link from one page to another.
- The most important attribute of the <a> element is the href attribute, which indicates the link's destination.
- href : specifies the URL of the page the link goes to
---------------

### < Images >
![image](https://user-images.githubusercontent.com/111114507/194248873-53949459-6b1d-437b-a2df-2e63dbfdc2ae.png)
- src : Specifies the path to the image
- alt : Specifies an alternate text for the image, if the image for some reason cannot be displayed
-------------------
<br>

### 🔔 Extra Attributes ... 
- #### style :
 is used to add styles to an element, such as color, font, size, and more.
```html
<p style="color:red;">This is a red paragraph.</p>
```
<br>

- #### title : 
defines some extra information about an element (마우스 가져다 두면 말풍선으로 뜨는거임!)  
```html
<!DOCTYPE html>
<html>
<body>

<h2 title="I'm a header">The title Attribute</h2>
<!--The title Attribute에 마우스 대면 I'm a header가 뜬다 -->
<p title="I'm a tooltip">Mouse over this paragraph, to display the title attribute as a tooltip.</p>

</body>
</html>
```
<br>

### 🔔 Extra Attributes ... 

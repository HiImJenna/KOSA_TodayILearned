# 2022.12.27.TUE 📅
----------------
<br> 

# 1. 과제 1 - 버튼 클릭 시 Title 변경 ✔
```js
<button onClick={()=>{ 
    (title[0] === '혜화 서커스')
    ? setTitle(["부천 서커스", "삼산 서커스", "부평 서커스", "중동 서커스"])
    : setTitle(["부천 고범종 서커스", "삼산 고범종 서커스", "부평 고범종 서커스", "중동 고범종 서커스"])
}}
class='btn btn-primary' >title chage</button>
```
<br>

# 2. 과제 2 - Tilte에 sort 적용 ✔
```js
function titleSort() {
  let titleSort = [...title].sort();
  setTitle(titleSort);
}
```
<br>

#### [sort 전]
![image](https://user-images.githubusercontent.com/111114507/209604120-caa4bcfb-269c-4833-9d6f-66ebd9e1543e.png)
<br>

#### [sort 후]
![image](https://user-images.githubusercontent.com/111114507/209604099-5093357c-186a-44fe-9af1-4b37fd64b904.png)
<br>

# 3. 과제 3 - Modal ✔
```js

```
<br>

# 4. 과제 4 - 쇼핑몰 ✔
![image](https://user-images.githubusercontent.com/111114507/209660250-2d380eef-9f96-49d1-914d-cdea30589289.png)
#### [App.js]
```js
<div className="jumbotron">
<img src={"https://www.foodandwine.com/thmb/o_G0VswYjyWy4B9epctoJ8lz9pI=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/buttermilk-crumpets-FT-RECIPE0221-6975d0b31b0f469d8ebea3ae1dcf7bfd.jpg"} width={'80%'} height ={'400px'} alt="하이"/>
<h3>Fancy a crumpet?</h3>
<p className="lead">delicious crumpets</p>
</div>

<div className="container">
<div className="row">

{image.map((el, i) => {
    // let fullLink =  "https://raw.githubusercontent.com/ai-edu-pro/busan/main/t" + (i+1) + ".jpg"
    return (
    <div className='col-md-4'>
            <img src={el.image} width="80%"/>
            <h4>{el.title}</h4>
            <p>{el.content}</p>
            <p>{el.price}</p>
    </div>   
    )
})}       
</div>
```
<br>

#### [data.js]
```js
let data = [

	{
	    id : 0,
	    title : "Black and White",
  	    content : "Born in France",
	    price : 120000,
		image : "https://raw.githubusercontent.com/ai-edu-pro/busan/main/t1.jpg"
	},
	{
	    id : 1,
	    title : "Red Knit",
  	    content : "Born in Seoul",
	    price : 110000,
		image : "https://raw.githubusercontent.com/ai-edu-pro/busan/main/t2.jpg"
	},
	{
	id : 2,
	title : "Brey Yordan",
	content : "Born in the states",
	image : "https://raw.githubusercontent.com/ai-edu-pro/busan/main/t5.jpg"
	}
]
export default data;
```
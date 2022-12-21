# 2022.12.21.WED 📅
----------------
<br> 

# 1. Ajax ✔
![image](https://user-images.githubusercontent.com/111114507/208802297-1a22f0e1-11f2-413a-b83d-194975a78272.png)
- json.kosa  / json2.kosa  / json3.kosa  / json4.kosa
<br>

### 💡 json.kosa
#### [AjaxController.java]
```java
@RequestMapping("json.kosa")
public View jsonkosa(String command, String name, String [] arr, ModelMap map) {
    
    System.out.println("command: " + command);
    System.out.println("name: " + name);
    System.out.println("arr: " + arr);
    System.out.println("Arrays.toString(): " + Arrays.toString(arr));
    ArrayList<String> list = new ArrayList<String>();
    list.add("치킨");
    list.add("맥주");
    list.add("피자");
    
    map.addAttribute("menu", list); //View단에 전달
    //{:}
    //{"menu":Array}
    
    return jsonview;
    //<bean name = "jsonview" 객체와 동일한 이름
    // map.addAttribute("menu", list); 자원을 자동으로 json 객체로 변환해서 클라이언트에게 비동기로 전달
}
```
#### [index.jsp]
```jsp
$('#ajaxBtn').click(function(){
    var array = new Array();
        array[0] = "a";
        array[1] = "b";
    $.ajax(
        { //json  방식
            type : "post",
            url  : "json.kosa",
            data : "command=AjaxTest&name=java&arr="+array,
            success : function(data){  //서버 {"menu",list}   //data > {}
            console.log(data);
            $('#menuView').empty();
            var opr="";
            $.each(data.menu,function(index,value){ //data.menu > ["치킨맥주","돈까스","치킨피자"]
                console.log(index + "/" + value);
                opr += index + "." + value + "<br>";
            });
            $('#menuView').append(opr);
            } 
        } 
        )    
});

```
- parameter에 ModelMap map을 적어줘서 json 으로 넘겨줄것임
- return jsonview; 만 해주면 알아서 Json으로 바꿈;;;
![image](https://user-images.githubusercontent.com/111114507/208802703-8465a64d-1275-4cf6-8543-5c37981ab03f.png)
<br>

### 💡 json3.kosa - Q) Employee 객체 2개 만들어서 List 형태로 반환하는 비동기 처리 함수 생성해서 테스트
#### [AjaxController.java]
```java
   @RequestMapping("json3.kosa")
   public View jsonkosa(HttpServletRequest request, HttpServletResponse response, ModelMap map) {

      Employee emp = new Employee(); //객체배열
      
      emp.setFirstname("손");
      emp.setLastname("정원");
      emp.setEmail("skygarden");
      
      List<Employee> list = new ArrayList<>();      
      list.add(emp);
      
      
      Employee emp2 = new Employee(); //객체배열
      
      emp2.setFirstname("김");
      emp2.setLastname("찬수");
      emp2.setEmail("coldbrew");
      
      list.add(emp2);

      map.addAttribute("data", list);
      //{"menu":{"beer":라거},{"food":"골뱅이"}}
	  return jsonview;
   }
```
![image](https://user-images.githubusercontent.com/111114507/208804699-e4d8a04d-b18b-45ae-8773-f275c05b0db4.png)
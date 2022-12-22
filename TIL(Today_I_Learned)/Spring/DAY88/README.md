# 2022.12.22.THU 📅
----------------
<br> 

# 1. Ajax Restful 처음부터 (Spring 19) ✔
### 💡 초기설정
```
1. pom.xml Spring18꺼 복사해서 붙이기
2. web.xml에 filter 붙여넣기 (따로 더 필요한거 있으면 봐서 붙이는거임)
3. root-context.xml에 필요한거 복붘해서 넣고 name~ 에서 필요한거 체크
4. servlet-context.xml도 마찬가지
5. 패키지 만들기 (dao, dto, service, controller, mapper)
```
<br>

### 1) Dto(Emp) 만들기
```java
package kr.or.kosa.dto;

import lombok.Data;

@Data
public class Emp {
	private int empno;
	private String ename;
	private int sal;
}
```
<br>

### 2) DAO -  CRUD interface 만들기
```java
public interface EmpDao {
	//CRUD함수
	int insert(Emp emp);
	List<Emp> select();
	Emp selectByEmpno(int empno);
	int update(Emp empno);
	int delete(int empno);
}
```
- throws로 예외처리 미리 해두면 터지는거 방지 가능. 코드량은 많아지지만 터지는것보다 낫다.
<br>

### 3) mapper 만들기 - mapper의 namespace는 interface의 이름과 동일해야한다
```xml
<mapper namespace="kr.or.kosa.dao.EmpDao">

	<insert id="insert" parameterType="dto.Emp">
		insert into emp(empno, ename, sal)
		values(#{empno}, #{ename}, #{sal})
	</insert>
		
	<select id="select">
		select empno, ename, sal from emp;
	</select>
	
	<select id="selectByEmpno">
		select empno, ename, sal from emp
		where empno = #{empno}
	</select>
	
	<update id="update">
		update emp
		set	   ename = #{ename}.
			   sal   = #{sal}
	    where empno = #{empno}
	</update>

	<delete id="delete">
		delet from emp where empno = #{empno}
	</delete>
</mapper>
```
<br>

### 4) service 만들기 
#### [MyBatis 설정 먼저]
```java
	private SqlSession sqlsession;

	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
```
<br>

# 2. Ajax + Restful로 EMP 테이블 불러오기
## 💡 전체 사원 목록 조회
### ✨ index.jsp
#### 1) 버튼 클릭 시
### [index.jsp]

```js
$('#empListBtn').click(function(){
    test();
});
```


#### 2) 비동기 함수 
```js
function test() {
            $.ajax({  
                    type : "get",
                    url  : "emp",
                    success : function(data){ 
                        $('#exp').empty();
        
                    console.log(data);
                    createTable(data, "Emp 전체 리스트");
                    }
                });
}
```
- 이렇게 함수로 빼두면 컨트롤러에서 수정 삭제 등록 등등 했을 때마다 전체조회하는 로직을 안짜도 돼서 간편
<br>

### ✨ EmpController.java
```java
//전체조회 (Restful) 
@RequestMapping(value="",method=RequestMethod.GET)
public ResponseEntity<List<Emp>> empList(){
    List<Emp> list = new ArrayList<Emp>();
    
    try {
        System.out.println("정상실행");
        list = empservice.selectAllEmpList();
        return new ResponseEntity<List<Emp>>(list,HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<List<Emp>>(list,HttpStatus.BAD_REQUEST);
    }
}
```
- 여기서 return 하는 부분이 비동기의 data로 넘어감
<br>

## 💡 사원 수정
### ✨index.jsp
#### 1) 수정 완료 버튼 클릭 시
```js
    function empupdateok(me){
        var tr = $(me).closest('tr');
        var data = JSON.stringify({
                    "empno":tr.find("td:eq(0)").children().val(),
                    "ename":tr.find("td:eq(1)").children().val(),
                    "sal":tr.find("td:eq(2)").children().val(),
                    });
        $.ajax({
            type: "put",
            url:  "emp",
            data:  data,
            dataType: 'text',
            contentType: 'application/json;charset=utf-8',
            success : function(data){ test(); } 
        })
    }
```
- dataType이 text인 이유는 Controller에서 return하는 값이 String이기 때문
- contentType : GET, PUT 등등 Mapping 안된다고 뜨는 오류를 잡기 위해서
- JSON.stringify : json 객체가 문자열로 들어가는걸 방지하기 위해서
<br>

#### 2) 수정 버튼 클릭 시
```js
function empupdate(me){
    var tr = $(me).closest('tr')
    var empno = Number(tr.children().html());
    tr.empty();
    
    $.ajax({
        type : "get",
        url:"emp/"+empno,
    
        data: {},
            success : function(data) {
                var td = "<td><input type='text' value='"+data.empno +"' readonly></td>";
                    td +="<td><input type='text' value='"+data.ename +"'></td>";
                    td +="<td><input type='text' value='"+data.sal +"'></td>";
                    td +="<td colspan='2'><input type='button'onclick='empupdateconfirm(this)' value='완료' value2="+data.empno+" /></td>";
                    $(tr).append(td); 
            }
    })
}
```
- 그 행에 있는 사원의 empno를 받아서 parameter로 넘겨주는 GET 방식
- empno를 변수로 선언 해주고 url 뒤에 붙이기! 

<br>

### ✨ EmpController.java
#### 포인트! 수정은 데이터를 받아오는 로직과, 수정처리를 하는 로직 두개로 분류가 되어있음!
#### 1) 수정버튼 눌렀을때(GET)
```java
@RequestMapping(value = "{empno}", method = RequestMethod.GET)
public Emp update(@PathVariable("empno") int empno) {
    Emp emp = null;
    try {
        System.out.println("update 실행");
        emp = empservice.selectEmpByEmpno(empno);
        return emp;
    } catch (Exception e) {
        return emp;
    }
}
```
- GET 방식으로 수정 폼 띄워주고, 그 수정폼 양식 안에 정보를 넣어줌 (사진 참고)
![image](https://user-images.githubusercontent.com/111114507/209132334-378aca9b-90db-4152-94e6-87b459ee67f4.png)
<br>

#### 2) 완료버튼 눌렀을때(POST)
```java
@RequestMapping(value="",method = RequestMethod.PUT)
public ResponseEntity<String> update(@RequestBody Emp emp) {
    try {
            System.out.println("update 실행");
            empservice.update(emp);
            return new ResponseEntity<String>("update success", HttpStatus.OK);
    } catch (Exception e) {
            return new ResponseEntity<String>("update fail", HttpStatus.BAD_REQUEST);
    }
}
```

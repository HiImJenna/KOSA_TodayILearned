# 2022.10.05. WED 📅
----------------
<br>

## 1. Transaction ✔




## 2. MVC 패턴
![image](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fm1.daumcdn.net%2Fcfile229%2FR400x0%2F1145B54A504C57D90DB1C0%22&type=cafe_wa740)
<br>

#### 1) 전체조회
```java
// select * from dept; >> return multi row
public List <Dept> getDeptAllList(){
		return null;
}
```
<br>

#### 2) 조건조회
```java
//select * from dept where deptno = ? >> return singlerow
public Dept getDeptListByDeptNo(int deptno) {
		return null;
}
```
<br>

#### 3) 데이터 삽입
```java
//insert into dept(deptno, dname, loc) values(?, ?, ?)
//public int insertDept(int deptno, String dname, String loc)
public int insertDept(Dept dept) {
		return 0;
}
```
<br>

#### 4) 데이터 수정
```java
//update dept set dname=?, loc=? where deptno=?
public int updateDept(Dept dept) {
		return 0;
}
```
<br>

#### 5) 데이터 삭제
```java
//delete from dept where deptno=?
	public int deleteDept(int deptno) {
		return 0;
}
```
<br>

## 3. JDBD 조별과제 ✔
```java
EMP 테이블대해서
전체조회  
조건조회  where empno=7788
삽입   insert into emp( ....) values(...)
삭제   delete from emp where empno=7788
수정   update emp set ename=? , job=? , sal=? , hiredate=?  where empno=?
Like 검색 이름 검색
```
[기능구현]  
```java
public class EMP_Test {

	//전체조회
	public List<Emp> getEmpAllList() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> emplist = new ArrayList<Emp>();

		try {
			Connection conn = null;
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Emp emp = new Emp(); // 하나의 row 담기 위한 객체
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setSal(rs.getInt("comm"));
				emp.setSal(rs.getInt("deptno"));
				emplist.add(emp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return emplist;
	}

	
	//조건조회
	public Emp getEmpListByEmpno(int empno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Emp emp =null;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select empno, sal, comm from emp where empno=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empno);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				emp = new Emp(); // 하나의 row 담기 위한 객체
				emp.setEmpno(rs.getInt("empno"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
        }
		return emp;
	}

	//insert
	public int insertEmp(Emp emp) {
		Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 //conn = SingletonHelper.getConnection("oracle");
			 String sql="insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?,?,?)";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setInt(1, emp.getEmpno());
			 pstmt.setString(2, emp.getEname());
			 pstmt.setString(3, emp.getJob());
			 pstmt.setInt(4, emp.getMgr());
			 pstmt.setDate(5, emp.getHiredate());
			 pstmt.setInt(6, emp.getSal());
			 pstmt.setInt(7, emp.getComm());
			 pstmt.setInt(8, emp.getDeptno());
			 
			 rowcount = pstmt.executeUpdate(); 
			 
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 return rowcount;
	}

	public int updateEmp(Emp emp) {
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 //conn = SingletonHelper.getConnection("oracle");
			 String sql="update emp set sal=?, comm=?, deptno=? where empno=?";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setInt(1, emp.getSal());
			 pstmt.setInt(2, emp.getComm());
			 pstmt.setInt(3, emp.getDeptno());
			 
			 rowcount = pstmt.executeUpdate(); 
			 
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 return rowcount;
	}

	public int deleteEmp(int deptno) {
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="delete from dept where empno=?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, deptno);
			 rowcount = pstmt.executeUpdate();
		 } catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 } finally {
			 SingletonHelper.close(pstmt);
		 }
		 return rowcount;
	}
	
	public List<Emp> getEmpAllListByEname(String ename){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//POINT
		List<Emp> emplist = new ArrayList<Emp>();

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + ename + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Emp emp = new Emp(); // 하나의 row 담기 위한 객체
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return emplist;
	}
}

```
[Get&Set]   
```java
import java.sql.Date;

public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
}
```
[Main]  
```java
import java.util.List;

import DAO.DeptDao;
import DTO.Dept;
import DTO.Emp;

public class Emp_main {

	public static void main(String[] args) {
		EMP_Test emp_test = new EMP_Test();

		System.out.println("[전체조회]");
		List<Emp> emplist = emp_test.getEmpAllList();
		if (emplist != null) {
			empPrint(emplist);
		}

		System.out.println("[조건조회]");
		Emp emp = emp_test.getEmpListByEmpno(7369);
		if (emp != null) {
			empPrint(emp);
		} else {
		}

		System.out.println("[데이터삽입]");
		// empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?,?,?)";
		Emp insertemp = new Emp();
		insertemp.setEmpno(9000);
		insertemp.setEname("JEONGWON");
		insertemp.setMgr(123456);
		insertemp.setHiredate(000316);
		insertemp.setSal(9000);
		insertemp.setComm(700);
		insertemp.setDeptno(70);

		int row = emp_test.insertEmp(insertemp);
		if (row > 0) {
			System.out.println("insert rowcount : " + row);
		}
		
		System.out.println("[방금전 insert 데이터 전체조회]*******");
		emplist =emp_test.getEmpAllList();
		//화면구성
		if(emplist != null) {
			empPrint(emplist);
		}
		
		System.out.println("[방금전 insert 데이터 수정하기]*******");
		Emp updateemp = new Emp();
		insertemp.setEmpno(9000);
		insertemp.setEname("JEONGWON_UP");
		insertemp.setMgr(123456);
		insertemp.setHiredate(000316);
		insertemp.setSal(9000);
		insertemp.setComm(700);
		insertemp.setDeptno(70);
		
		row = emp_test.updateEmp(updateemp);
		if(row > 0) {
			System.out.println("update rowcount : " + row);
		}
		
		System.out.println("[방금전 update 데이터 전체조회]*******");
		emplist = emp_test.getEmpAllList();
		//화면구성
		if(emplist != null) {
			empPrint(emplist);
		}
		
		System.out.println("[방금전 update 데이터 삭제하기]*******");
		row = emp_test.deleteEmp(9000);
		if(row > 0) {
			System.out.println("delete rowcount : " + row);
		}
		
		System.out.println("[방금전 delete 데이터 전체조회]*******");
		emplist =emp_test.getEmpAllList();
		//화면구성
		if(emplist != null) {
			empPrint(emplist);
		}
	}

	public static void empPrint(Emp emp) {
		System.out.println(emp.toString());
	}

	public static void empPrint(List<Emp> list) {
		for (Emp data : list) {
			System.out.println(data.toString());
		}
	}
}
```
<br>

## 4. Database 모델링 ✔
#### DB 모델링이란?
- 현실 세계의 업무적인 프로세서를 물리적으로 데이터베이스화 하기 위한 과정
<br>

#### DB 모델링 과정  
![image](https://t1.daumcdn.net/cfile/tistory/993267335A212E010B)
<br>

### 🔔 3가지 모델링
- 개념적 모델링: 개체와 개체들 간의 관계에서 ER다이어그램을 만드는 과정
- 논리적 모델링: ER다이어그램을 사용하여 관계 스키마 모델을 만드는 과정
- 물리적 모델링: 관계 스키마 모델의 물리적 구조를 정의하고 구현하는 과정

<br>

### 🔔 개념적 모델링  
- 개체(Entity)를 추출하고 개체들 간의 관계를 정의하여 ER다이어그램을 만드는 과정까지를 말한다.  
![imgae](https://t1.daumcdn.net/cfile/tistory/997C4B335A21306B2E)
<BR>

### 🔔 논리적 모델링  
- 개념적 모델링에서 만든 ER 다이어그램을 사용하려는 DBMS에 맞게 사상(Mapping)하여 실제 데이터베이스로 구현하기 위한 관계 스키마 모델을 만드는 과정    
![image](https://t1.daumcdn.net/cfile/tistory/99F6C3335A21306B03)
<BR>

### 🔔 물리적 모델링  
-  논리적 모델을 실제 컴퓨터의 저장 장치에 저장하기 위한 물리적 구조를 정의하고 구현하는 과정  
![image](https://t1.daumcdn.net/cfile/tistory/99BE04335A21306C27)
<BR>

출처: https://mangkyu.tistory.com/27 [MangKyu's Diary:티스토리]




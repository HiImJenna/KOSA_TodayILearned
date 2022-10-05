import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Dept;
import DTO.Emp;
import UTILS.SingletonHelper;


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
			 pstmt.setDate(5, new java.sql.Date(emp.getHiredate().getTime()));
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
				emp.setHiredate(rs.getDate("Hiredate"));
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

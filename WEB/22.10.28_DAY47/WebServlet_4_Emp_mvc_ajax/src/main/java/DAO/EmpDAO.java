package DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Emp;
import UTILS.SingletonHelper;

public class EmpDAO {
	
Connection conn = null;
	
	public EmpDAO () {
		conn = SingletonHelper.getConnection("oracle");
	}

	//1.��ü��ȸ
	public List<Emp> getEmpAllList(){
		//Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Emp> emptlist = new ArrayList<Emp>();  
		
		
		try {
			//conn = SingletonHelper.getConnection("oracle");
			String sql ="select * from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					Emp emp = new Emp();
					emp.setEmpno(rs.getInt("empno"));
					emp.setEname(rs.getString("ename"));
					emp.setJob(rs.getString("job"));
					emp.setMgr(rs.getInt("mgr"));
					emp.setHiredate(rs.getDate("hiredate"));
					emp.setSal(rs.getInt("sal"));
					emp.setComm(rs.getInt("comm"));
					emp.setDeptno(rs.getInt("deptno"));
					emptlist.add(emp);
				}while(rs.next());
					
			}else {
				System.out.println("��ȸ�� �����Ͱ� �����ϴ�.");
			}
		} catch (Exception e) {
			
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		
		return emptlist;
	}
}
	//2.������ȸ
	public Emp getEmpListByEmpNo(int deptno) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Emp emp =null;

		try {
			//conn = SingletonHelper.getConnection("oracle");
			String sql = "select * from emp where empno=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, deptno);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				emp = new Emp(); // �ϳ��� row ��� ���� ��ü
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return emp;
	}
	
	//3.����
	public int insertEmp(Emp emp) {
		 //Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 //conn = SingletonHelper.getConnection("oracle");
			 String sql="insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setInt(1, emp.getEmpno());
			 pstmt.setString(2, emp.getEname());
			 pstmt.setString(3, emp.getJob());
			 pstmt.setInt(4, emp.getMgr());
			 pstmt.setDate(5, (Date) emp.getHiredate());
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
	//4. ����
	public int updateEmp(Emp emp) {
		 //Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 //conn = SingletonHelper.getConnection("oracle");
			 String sql="update emp set ename=? ,job=?, sal=? ,hiredate=?  where empno=?";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, emp.getEname());
			 pstmt.setString(2, emp.getJob());
			 pstmt.setInt(3, emp.getSal());
			 pstmt.setDate(4, (Date) emp.getHiredate());
			 pstmt.setInt(5, emp.getEmpno());
			 
			 rowcount = pstmt.executeUpdate(); 
			 
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
	
	//5. ����
	public int deleteEmp(int empno) {
		 //Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			// conn = SingletonHelper.getConnection("oracle");
			 String sql="delete from emp where empno=?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, empno);
			 rowcount = pstmt.executeUpdate();
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
	//6. like �̸��˻�
	
	public List<Emp> getEmpAllListByEname(String ename){
		//Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//POINT
		List<Emp> emptlist = new ArrayList<Emp>();

		try {
			//conn = SingletonHelper.getConnection("oracle");
			String sql = "select * from emp where like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + ename + "%"); //like '%SEOUL%'
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				emptlist.add(emp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return emptlist;
	}
	
}

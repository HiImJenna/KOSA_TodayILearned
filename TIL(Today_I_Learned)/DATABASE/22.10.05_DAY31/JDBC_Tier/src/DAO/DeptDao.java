package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Dept;
import UTILS.SingletonHelper;

//DAO 클래스 설계하기
//1. DB연결
//2. CRUD 구현
//3. 기본적으로 함수 5개 (하나의 테이블에 대해서)
//3.1 전체조회 , 조건조회 , 삽입 , 수정 , 삭제 기능 

	
//DAO 클래스 설계하기
// 1. DB 연결
// 2. CRUD 구현
// 3. 기본적으로 함수 5개(하나의 테이블에 대해서)
//  1) 전체 조회, 조건조회, 삽입, 수정, 삭제기능
public class DeptDao {
	Connection conn = null;
	
	public DeptDao() {
		conn = SingletonHelper.getConnection("oracle");
	}
	
	
	//1. 전체조회 >> select * from dept 
		//>> return multi row
		public List<Dept> getDeptAllList(){
			//Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			//POINT
			List<Dept> deptlist = new ArrayList<Dept>();

			try {
				//conn = SingletonHelper.getConnection("oracle");
				String sql = "select deptno, dname, loc from dept";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					Dept dept = new Dept(); // 하나의 row 담기 위한 객체
					dept.setDeptno(rs.getInt("deptno"));
					dept.setDname(rs.getString("dname"));
					dept.setLoc(rs.getString("loc"));
					deptlist.add(dept); // 배열에 객체 담는 것
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				SingletonHelper.close(rs);
				SingletonHelper.close(pstmt);
			}

			return deptlist;
		}

		
		//2. 조건조회 (deptno pk) >> select * from dept where deptno=? 
		//>> return singlerow 
		public Dept getDeptListByDeptNo(int deptno) {
			
			//Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			//POINT
			Dept dept =null;

			try {
				//conn = SingletonHelper.getConnection("oracle");
				String sql = "select deptno, dname, loc from dept where deptno=?";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, deptno);
				
				rs = pstmt.executeQuery();

				while (rs.next()) {
					dept = new Dept(); // 하나의 row 담기 위한 객체
					dept.setDeptno(rs.getInt("deptno"));
					dept.setDname(rs.getString("dname"));
					dept.setLoc(rs.getString("loc"));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				SingletonHelper.close(rs);
				SingletonHelper.close(pstmt);
			}

			return dept;
		}
		
		//3. 데이터 삽입 >> insert into dept(deptno,dname,loc) values(?,?,?)
	    //public int insertDept(int deptno , String dname, String loc) {}
		public int insertDept(Dept dept) {
			 //Connection conn = null;
			 PreparedStatement pstmt=null;
			 int rowcount = 0;
			 
			 try {
				 //conn = SingletonHelper.getConnection("oracle");
				 String sql="insert into dept(deptno,dname,loc) values(?,?,?)";
				 pstmt = conn.prepareStatement(sql);
				 
				 pstmt.setInt(1, dept.getDeptno());
				 pstmt.setString(2, dept.getDname());
				 pstmt.setString(3, dept.getLoc());
				 rowcount = pstmt.executeUpdate(); 
				 
			 }catch (Exception e) {
				 e.printStackTrace();
				 System.out.println(e.getMessage());
			 }finally {
				 SingletonHelper.close(pstmt);
			 }
			 
			 return rowcount;
		}
		
		//4. 데이터 수정 >> update dept set dname=? , loc=? where depno=?
		public int updateDept(Dept dept) {
			 //Connection conn = null;
			 PreparedStatement pstmt=null;
			 int rowcount = 0;
			 
			 try {
				 //conn = SingletonHelper.getConnection("oracle");
				 String sql="update dept set dname=? , loc=? where deptno=?";
				 pstmt = conn.prepareStatement(sql);
				 
				 pstmt.setString(1, dept.getDname());
				 pstmt.setString(2, dept.getLoc());
				 pstmt.setInt(3, dept.getDeptno());
				 
				 rowcount = pstmt.executeUpdate(); 
				 
			 }catch (Exception e) {
				 e.printStackTrace();
				 System.out.println(e.getMessage());
			 }finally {
				 SingletonHelper.close(pstmt);
			 }
			 
			 return rowcount;
		}
		
		//5. 데이터 삭제 >>delete from dept where deptno=?
		public int deleteDept(int deptno) {
			 //Connection conn = null;
			 PreparedStatement pstmt=null;
			 int rowcount = 0;
			 
			 try {
				 //conn = SingletonHelper.getConnection("oracle");
				 String sql="delete from dept where deptno=?";
				 pstmt = conn.prepareStatement(sql);
				 pstmt.setInt(1, deptno);
				 rowcount = pstmt.executeUpdate();
			 }catch (Exception e) {
				 e.printStackTrace();
				 System.out.println(e.getMessage());
			 }finally {
				 SingletonHelper.close(pstmt);
			 }
			 
			 return rowcount;
		}

		//필요에 따라서
		//검색  Like ..
		//여러개의 조건조회 ....
		
		//6.
		//문제 >> 부서이름을 LIKE 검색해서 해당하는 부서번호 , 부서이름 , 부서위치 를 반환하는 
		//함수를 만드세요
		//query >> select deptno , dname , loc from dept where dname like '%SEOUL%'
		//무식하게 표현하면 >>  where dname like '%" + dname +"'%"
		public List<Dept> getDeptAllListByDname(String dname){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			//POINT
			List<Dept> deptlist = new ArrayList<Dept>();

			try {
				conn = SingletonHelper.getConnection("oracle");
				String sql = "select deptno, dname, loc from dept where like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + dname + "%");
				rs = pstmt.executeQuery();

				while (rs.next()) {
					Dept dept = new Dept(); // 하나의 row 담기 위한 객체
					dept.setDeptno(rs.getInt("deptno"));
					dept.setDname(rs.getString("dname"));
					dept.setLoc(rs.getString("loc"));
					deptlist.add(dept); // 배열에 객체 담는 것
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				SingletonHelper.close(rs);
				SingletonHelper.close(pstmt);
			}

			return deptlist;
		}

	}

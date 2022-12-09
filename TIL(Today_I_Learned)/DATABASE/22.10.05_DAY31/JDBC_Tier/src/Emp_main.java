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
		pstmt.setDate(5, new java.sql.Date(emp.getHiredate().getTime()));
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






















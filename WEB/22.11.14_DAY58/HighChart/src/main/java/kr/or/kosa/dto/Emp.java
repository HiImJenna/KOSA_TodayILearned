package kr.or.kosa.dto;


/*
 * 이름       널?       유형           
-------- -------- ------------ 
EMPNO    NOT NULL NUMBER       
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER       
HIREDATE          DATE         
SAL               NUMBER       
COMM              NUMBER       
DEPTNO            NUMBER       
 * 
 */

public class Emp {

	private String ename;
	private int sal;

	public Emp() {
		// TODO Auto-generated constructor stub
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}
	
	@Override
	public String toString() {
		return "Emp [ename=" + ename + ", sal=" + sal + "]";
	}

}

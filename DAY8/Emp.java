package kr.or.bit;
//설계도
public class Emp {
  private int empno;
  private String ename;
  
  public Emp(int empno, String ename) {
	  
	  this.empno = empno;
	  this.ename = ename;
  }

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
	//기능 출력
	public void empInfoPrint() {
		System.out.println(this.empno + " , " + this.ename);
	}
	
}


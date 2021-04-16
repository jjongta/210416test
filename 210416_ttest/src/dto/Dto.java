package dto;

public class Dto {
	private int empno;
	private String empname;
	private int empsal;
	private int empdept;
	
	public String alldata() {
		return "";
	}
	
	public Dto() {
		super();
	}

	public Dto(int empno, String empname, int empsal, int empdept) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.empsal = empsal;
		this.empdept = empdept;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getEmpsal() {
		return empsal;
	}

	public void setEmpsal(int empsal) {
		this.empsal = empsal;
	}

	public int getEmpdept() {
		return empdept;
	}

	public void setEmpdept(int empdept) {
		this.empdept = empdept;
	}

	@Override
	public String toString() {
		return "Dto [empno=" + empno + ", empname=" + empname + ", empsal=" + empsal + ", empdept=" + empdept + "]";
	}
	
	
	
	
	
	
}

package GUI1;
public class Assignment {
	private int unitNumber;
	private String grade;
	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assignment(int unitNumber, String grade) {
		super();
		this.unitNumber = unitNumber;
		this.grade = grade;
	}
	public int getUnitNumber() {
		return unitNumber;
	}
	public void setUnitNumber(int unitNumber) {
		this.unitNumber = unitNumber;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Assignment [unitNumber=" + unitNumber + ", grade=" + grade + "]";
	}
}

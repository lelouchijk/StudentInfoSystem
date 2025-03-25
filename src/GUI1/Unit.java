package GUI1;
public class Unit {
	private int unitNumber;
	private String unitName;
	public Unit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Unit(int unitNumber, String unitName) {
		super();
		this.unitNumber = unitNumber;
		this.unitName = unitName;
	}
	public int getUnitNumber() {
		return unitNumber;
	}
	public void setUnitNumber(int unitNumber) {
		this.unitNumber = unitNumber;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	@Override
	public String toString() {
		return "Unit [unitNumber=" + unitNumber + ", unitName=" + unitName + "]";
	}
}

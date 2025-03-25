package GUI1;
import java.util.ArrayList;

public class Semester {
	
	private int semesterNumber;
	private ArrayList<String> unitList;
	private int year;
	
	public Semester() {
		super();
	}
	
	public Semester(int semesterNumber, ArrayList<String> unitList, int year) {
		super();
		this.semesterNumber = semesterNumber;
		this.unitList = unitList;
		this.year = year;
	}

	public int getSemesterNumber() {
		return semesterNumber;
	}
	public void setSemesterNumber(int semesterNumber) {
		this.semesterNumber = semesterNumber;
	}
	public ArrayList<String> getUnitList() {
		return unitList;
	}
	public void setUnitList(ArrayList<String> unitList) {
		this.unitList = unitList;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Semester [semesterNumber=" + semesterNumber + ", unitList=" + unitList + ", year=" + year + "]";
	}
}

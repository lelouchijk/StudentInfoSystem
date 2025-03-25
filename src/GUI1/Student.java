package GUI1;
import java.util.ArrayList;
public class Student {
	
	private String id;
	private String name;
	private int year;
	private int semester;
	private int batchNo;
	private ArrayList<Assignment> assignmentList;
	public Student() {
		super();
	}
	public Student(String id) {
		super();
		this.id = id;
	}
	public Student(String id, String name, int year, int semester, int batchNo, ArrayList<Assignment> assignmentList) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.semester = semester;
		this.batchNo = batchNo;
		this.assignmentList = assignmentList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}
	public ArrayList<Assignment> getAssignmentList() {
		return assignmentList;
	}
	public void setAssignmentList(ArrayList<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", year=" + year + ", semester=" + semester + ", batchNo="
				+ batchNo + ", assignmentList=" + assignmentList + "]";
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Student std;
		boolean isEqual=false;
		if(obj instanceof Student)
		{
			std = (Student)obj;
			isEqual = this.id.equals(std.id);
		}
		return isEqual;
	}
	
}

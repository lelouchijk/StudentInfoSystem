package GUI1;
import java.util.ArrayList;

public class Batch {
	
	private int batchNumber;
	private ArrayList<String> studentList;
	private int year;
	private int semester;
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Batch(int batchNumber) {
		super();
		this.batchNumber = batchNumber;
	}

	public Batch(int batchNumber, ArrayList<String> studentList, int year, int semester) {
		super();
		this.batchNumber = batchNumber;
		this.studentList = studentList;
		this.year = year;
		this.semester = semester;
	}

	public int getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(int batchNumber) {
		this.batchNumber = batchNumber;
	}

	public ArrayList<String> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<String> studentList) {
		this.studentList = studentList;
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

	@Override
	public String toString() {
		return "Batch [batchNumber=" + batchNumber + ", studentList size =" + studentList.size() + ", year=" + year + ", semester="
				+ semester + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean isEqual = false;
		if(obj instanceof Batch) {
			Batch batch = (Batch)obj;
			isEqual = this.batchNumber==batch.batchNumber;
		}
		return isEqual;
	}
	
	

}

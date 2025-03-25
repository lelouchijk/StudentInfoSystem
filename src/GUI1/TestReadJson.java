package GUI1;
import java.util.ArrayList;

public class TestReadJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test unit
		/*ReadUnitsFromJson unitsReader = new ReadUnitsFromJson();
		ArrayList<Unit>unitList = unitsReader.getUnitList();
		for(Unit unit : unitList)
			System.out.println(unit);*/
		
		//test batch
		ReadBatchesFromJson batchesReader = new ReadBatchesFromJson();
		ArrayList<Batch>batchList = batchesReader.getBatchList();
		for(Batch batch : batchList)
		{
			System.out.println(batch);
			ArrayList<String> stdList = batch.getStudentList();
			for(String str : stdList)
				System.out.print(str+"\t");
			System.out.println();
		}
		
		//test semester
		/*ReadSemestersFromJson semestersReader = new ReadSemestersFromJson();
		ArrayList<Semester>semesterList = semestersReader.getSemesterList();
		for(Semester semester : semesterList)
		{
			System.out.print(semester.getSemesterNumber()+"\t"+semester.getYear()+"\t");
			ArrayList<String> stdList = semester.getUnitList();
			for(String str : stdList)
				System.out.print(str+"\t");
			System.out.println();
		}*/
		
		//test student
		/*ReadStudentsFromJson studentsReader = new ReadStudentsFromJson();
		ArrayList<Student>studentList = studentsReader.getStudentList();
		for(Student std : studentList)
		{
			System.out.print(std.getId()+"\t"+std.getBatchNo()+"\t");
			ArrayList<Assignment> assignments = std.getAssignmentList();
			for(Assignment ass : assignments)
				System.out.print(ass.getUnitNumber()+"\t"+ass.getGrade()+"\t");
			System.out.println();
		}*/
	}

}

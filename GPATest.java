/***********************************************************************
Program Name: GPATest.java
Programmer's Name: Jason Franco
Program Description: Use the StudentGPAInfo class objects to output
student's name, total grade points, number of classes and GPA.
***********************************************************************/
public class GPATest
{
	public static void main(String[] args)
	{
		// attributes variables
		String studentName = "Robert DeNiro";
		int numberOfClasses = 12;
		int totalGradePoints = 37;
	
		// StudentGPAInfo objects
		StudentGPAInfo student1 = new StudentGPAInfo("John Wick", 25, 80);
		StudentGPAInfo student2 = new StudentGPAInfo();
		
		// Initialize fields
		student2.setStudentName(studentName);
		student2.setTotalGradePoints(totalGradePoints);
		student2.setNumberOfClasses(numberOfClasses);
		
		// calculate
		student1.calculateGPA();
		student2.calculateGPA();
		
		// display output
		student1.displayStudent();
		student2.displayStudent();
	}
}
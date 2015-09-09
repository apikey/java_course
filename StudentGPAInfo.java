/***********************************************************************
Program Name: StudentGPAInfo.java
Programmer's Name: Jason Franco
Program Description: Create a class for a student and keep record of
their name, number of classes, total grade points and calculate their
GPA.
***********************************************************************/
public class StudentGPAInfo
{
	final int MIN_POINTS = 0;
	final int MAX_POINTS = 152;
	
	final int MIN_NUM_CLASS_HOURS = 0;
	final int MAX_NUM_CLASS_HOURS = 80;
	
	final String INVALID_NAME = "Unknown Name";
	
	double gpa;
	int totalGradePoints;
	int numberOfClasses;
	String studentName;
	
	// default constructor
	StudentGPAInfo()
	{
		studentName = INVALID_NAME;
		numberOfClasses = MIN_NUM_CLASS_HOURS;
		totalGradePoints = MIN_POINTS;
	}
	
	// constructor with parameters
	StudentGPAInfo(String studentName, int numberOfClasses, int totalGradePoints)
	{
		this.studentName = studentName;
		
		if (numberOfClasses >= MIN_NUM_CLASS_HOURS || numberOfClasses <= MAX_NUM_CLASS_HOURS)
			this.numberOfClasses = numberOfClasses;
		else
			this.numberOfClasses = MIN_NUM_CLASS_HOURS;
			
		if (totalGradePoints >= MIN_POINTS || totalGradePoints <= MAX_POINTS )
			this.totalGradePoints = totalGradePoints;
		else
			this.totalGradePoints = MIN_POINTS;
	}
	
	public int getTotalGradePoints()
	{
		return totalGradePoints;
	}
	
	public int getNumberOfClasses()
	{
		return numberOfClasses;
	}
	
	// used to calculate the student's grade point average
	public double calculateGPA()
	{
		this.gpa = (totalGradePoints / (double)numberOfClasses);
		return this.gpa;
	}
	
	// setter for studentName
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	
	// setter for totalGradePoints
	public void setTotalGradePoints(int totalGradePoints)
	{
		this.totalGradePoints = totalGradePoints;
	}
	
	// setter for numberOfClasses
	public void setNumberOfClasses(int numberOfClasses)
	{
		this.numberOfClasses = numberOfClasses;
	}
	
	// displayStudent method that will display all of the attributes of the StudentGPAInfo object.
	// Display the GPA with an accuracy of two decimal places (i.e. 3.25)
	public void displayStudent()
	{
		System.out.printf("%20s%s%n", "Student Name: ", this.studentName);
		System.out.printf("%20s%.2f%n", "GPA: ", this.gpa);
		System.out.printf("%20s%d%n", "Total Grade Points: ", this.totalGradePoints);
		System.out.printf("%20s%d%n", "Number of Classes: ", this.numberOfClasses);
		System.out.println();
	}
}


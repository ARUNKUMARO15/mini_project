package dao;

import packages.exams;

public class Marks extends exams
{
	public static void total()
	 {
		 System.out.println("<<<<You have scored "+exams.marks+" in your first subject>>>>");
		 System.out.println("<<<<You have scored "+exams.marks2+" in your second subject>>>>");
		 System.out.println("<<<<You have scored "+exams.marks3+" in your third subject>>>>");
//		 System.out.println("<<<<You have scored "+exams.marks4+" in your fourth subject>>>>");
//		 System.out.println("<<<<You have scored "+exams.marks5+" in your fifth subject>>>>");
		 System.out.println();
		 System.out.println("Your total marks is "+(exams.marks+exams.marks2+exams.marks3+exams.marks4+exams.marks5));
	 }
}

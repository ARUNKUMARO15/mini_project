package packages;

//import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import dao.Marks;

import java.util.*;

public class exams 
{
	
	 public static int marks=0;
	 public static int marks2=0;
	 public static int marks3=0;
	 public static int marks4=0;
	 public static int marks5=0;
//	 public static int marks3=0;
	 public  void startexam(Statement stmt) throws ClassNotFoundException,SQLException 
     {
		 Statement s=stmt;
    	 System.out.println("Enter the subject code to take exam");
    	 System.out.println(">>>>>>111>>>>>>Mathematics");
    	 System.out.println("***************************");
    	 System.out.println(">>>>>>112>>>>>>Cricket");
    	 System.out.println("***************************");
    	 System.out.println(">>>>>>113>>>>>>General Knowledge");
    	 System.out.println("***************************");

    	 Scanner scan=new Scanner(System.in);
    	 String ques="select question from questions";
    	 System.out.println();
    	 System.out.println("Instructions:");
    	 System.out.println("1.Go by Order"+"\n"+"2.Dont Skip any section"+"\n"+"3.In case of skipping,you may be disabled to attend the subject");
    	 System.out.println("4.Remember the subject General Knowledge is mandatory ,you cant skip the subject");
		 int code=scan.nextInt();
		 
		 switch(code)
		 {
	    	 case 111:
	    	 {
	    		 int z=0;
	    		 System.out.println("Hey..You have started your exam with the subject code : 111");
	    		
	        	 
	        	 System.out.println("Enter 1 to start");
	        	 z=scan.nextInt();
	        	 scan.nextLine();
	        	 if(z==1)
	        	 {
	        		 System.out.print("Answer to the following questions from the given options");
	        		 System.out.println();
	        		 System.out.println(exams.method1(s));
	        	 
	        	 }
	        	 String quesquery="Select * from maths";
	        	 ResultSet rs1ques = s.executeQuery(quesquery);
	        	 marks = 0;
	
	        	 System.out.println("The Questions are: ");
	        	 int temp=0;
	        	 while (rs1ques.next())
	        	 {
	        		System.out.println("Question: " + rs1ques.getString("question"));
	        	     int m = rs1ques.getInt(3);
	        	     String ans = scan.nextLine();
	        	     if (ans.equals(rs1ques.getString(5)))
	        	     {
	        	         marks = marks + m;
	        	     }
	        	 }
	
//	        	 System.out.println("Your marks : " + marks);
	        	 System.out.println("Now you have to move to the other subject");
//	        	 int opt=scan.nextInt();
	        	 
//	        	 break;
	        	 
	    	 }
    	 
	    	 case 112:
		    	 {
		    		 int zz=0;
		    		 System.out.println("Hey..You have started your exam with the subject code : 112");
		    		 System.out.println();
		        	 System.out.println("Enter 1 to start");
		        	 zz=scan.nextInt();
		        	 scan.nextLine();
		        	 if(zz==1)
		        	 {
		        		 System.out.print("Answer to the following questions from the given options");
		        		 System.out.println();
		        		 System.out.println(exams.method1(1,s));
		        	 }
		        	 
		        	 String quesquery2="Select * from cricket";
		        	 ResultSet rs2ques = s.executeQuery(quesquery2);
		        	 marks2 = 0;
		
		        	 System.out.println("The Questions are: ");
		        	 while (rs2ques.next())
		        	 {
		        	     System.out.println("Question: " + rs2ques.getString("question"));
		        	     int m = rs2ques.getInt(3);
		        	     String ans = scan.nextLine();
		        	     if (ans.equals(rs2ques.getString(5))) 
		        	     {
		        	         marks2 = marks2 + m;
		        	     }
		        	 }
		
//		        	 System.out.println("Your marks : " + marks2);
		        	 System.out.println("Now you have to move to the other subject");
//		        	 int opt=scan.nextInt();
//		        	 break;
		    	 }
	    	
	    	 case 113:
			    	 {
			    		 int z3=0;
			    		 System.out.println("Hey..You have started your exam with the subject code : 113");
			    		 System.out.println();
			        	 System.out.println("Enter 1 to start");
			        	 z3=scan.nextInt();
			        	 scan.nextLine();
			        	 if(z3==1)
			        	 {
			        		 System.out.println("Answer to the following questions from the given options");
			        		 System.out.println();
			        		 System.out.println(exams.method1("sjdk",s));
			        	 
			        	 }
			        	 String quesquery3="Select * from GK";
			        	 ResultSet rs3ques = s.executeQuery(quesquery3);
			        	  marks3 = 0;
			
			        	 System.out.println("The Questions are: ");
			        	 while (rs3ques.next()) 
			        	 {
			        	     System.out.println("Question: " + rs3ques.getString("question"));
			        	     int m = rs3ques.getInt(3);
			        	     String ans = scan.nextLine();
			        	     if (ans.equals(rs3ques.getString(5)))
			        	     {
			        	         marks3 = marks3 + m;
			        	     }
			        	 }
			        	 
//			        	 System.out.println("Your marks : " + marks3);
			        	 System.out.println("You have successfully completed your exams");
			        	 System.out.println();
			        	 System.out.println("Want to see your marks now??");
			        		System.out.println("Enter 6 to view marks");
			        		System.out.println();
			        		int n=scan.nextInt();
			        		scan.nextLine();
			        	    	 if(n==6)
			        	    	 {
			        	    		 System.out.println("Here you go !!!!");
			        	    		 Marks.total();
			        	    		 System.out.println("Do you wish to calculate grade..??");
			        	    		 System.out.println("If so, Enter 5");
			        	    		 int g=scan.nextInt();
			        	    		 scan.nextLine();
			        	    	 }
			    	 } 
    	 
    	 
    	 
//    	 default:
//    	 {
//    		 System.out.println("Default case of code subjects");
//    		 break;
//    	 }
		 }
        	 
     }
	public static ArrayList<String> method1(Statement s) throws SQLException
	 {
		 Statement a=s;
		 String query="select * from maths";
//		 Statement statement=null;
		 ResultSet rs1=a.executeQuery(query);
		 ArrayList<String> mathslist=new ArrayList<String>();
		 while(rs1.next())
		 {
			 String str=rs1.getString(5);
			 mathslist.add(str);
		 }
		 Collections.shuffle(mathslist);
		return mathslist;
		 
	 }
	 public static ArrayList<String> method1(int n,Statement s) throws SQLException
	 {
		 Statement a=s;
		 String query="select * from cricket";
//		 Statement statement=null;
		 ResultSet rs1=a.executeQuery(query);
		 ArrayList<String> cricketlist=new ArrayList<String>();
		 while(rs1.next())
		 {
			 String str=rs1.getString(5);
			 cricketlist.add(str);
		 }
		 Collections.shuffle(cricketlist);
		return cricketlist;
		 
	 }
	 public static ArrayList<String> method1(String st,Statement s) throws SQLException
	 {
		 Statement a=s;
		 String query="select * from GK";
//		 Statement statement=null;
		 ResultSet rs1=a.executeQuery(query);
		 ArrayList<String> GKlist=new ArrayList<String>();
		 while(rs1.next())
		 {
			 String str=rs1.getString(5);
			 GKlist.add(str);
		 }
		 Collections.shuffle(GKlist);
		return GKlist;
		 
	 }
	 public static ArrayList<String> method1(boolean f,Statement s) throws SQLException
	 {
		 Statement a=s;
		 String query="select * from cinema";
//		 Statement statement=null;
		 ResultSet rs1=a.executeQuery(query);
		 ArrayList<String> cinemalist=new ArrayList<String>();
		 while(rs1.next())
		 {
			 String str=rs1.getString(5);
			 cinemalist.add(str);
		 }
		 Collections.shuffle(cinemalist);
		return cinemalist;
		 
	 }
	 public static ArrayList<String> method1(double d,Statement s) throws SQLException
	 {
		 Statement a=s;
		 String query="select * from chemistry";
//		 Statement statement=null;
		 ResultSet rs1=a.executeQuery(query);
		 ArrayList<String> chemistrylist=new ArrayList<String>();
		 while(rs1.next())
		 {
			 String str=rs1.getString(5);
			 chemistrylist.add(str);
		 }
		 Collections.shuffle(chemistrylist);
		return chemistrylist;
		 
	 }
	 
	 
	 
	 

}

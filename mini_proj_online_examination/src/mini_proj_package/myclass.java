package mini_proj_package;
import java.sql.*;

import java.util.*;

import packages.Admin;
import packages.exams;


public class myclass
{

	public static void main(String[] args) throws Exception
	{
			Scanner sc=new Scanner(System.in);
			myclass obj=new myclass();
			System.out.println("Lets get started");
			System.out.println("Admin or Student  : A/S");
			char ch=sc.next().charAt(0);
			sc.nextLine();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","Arun@06102003");
			Statement statement=connection.createStatement();
			if(ch=='A' || ch=='a')
			{
				System.out.println("Enter your admin_id : ");
				int admin_id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter your password: ");
				String admin_pswrd=sc.nextLine();
				Admin.Admincheck(admin_id,admin_pswrd,statement);
			}
			if(ch=='S' || ch=='s')
			{
				System.out.println("*****Please enter your details here******");
				System.out.println("New user or Registerd user  :  N/R");
				int c=0;
				char inp=sc.next().charAt(0);
				sc.nextLine();
				
				if(inp=='N' || inp=='n')
				{
					System.out.println("Enter your roll_num");
					int roll_num=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter your password");
					String password=sc.nextLine();
					String add="insert into students (roll_num,password) values(?,?)";
					PreparedStatement ps=connection.prepareStatement(add);
					ps.setInt(1, roll_num);
					ps.setString(2,password);
					int changes=ps.executeUpdate();
					if(changes>0)
					{
						System.out.println("Successfully Registered");
					}
					if(changes==0)
					{
						System.out.println("Please try once more...");
					}
				}
				if(inp=='R' || inp=='r')
				{
					System.out.println("Enter your roll_num here>>>");
					int a=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter your password here>>>");
					String b=sc.nextLine();
					String query="select * from students";
					ResultSet rs=statement.executeQuery(query);
					while(rs.next())
					{
						int roll=rs.getInt(1);
						String pswd=rs.getString(2);
						if(a==roll && pswd.equals(b))
						{
							c=1;
							System.out.println("You are an existing user..");
							System.out.println();
							System.out.println();
							System.out.println();
							System.out.println("Hi "+roll+". You have logged in  successfully .");
							System.out.println();
							System.out.println(">>>Now you may start your work from here>>>");
							System.out.println();
							System.out.println();
							System.out.println("Here you grow your brain");
	//						obj.startexam();
							System.out.println("To take Exam...Enter 1");
							System.out.println();
							System.out.println("To view marks...Enter 2");
							System.out.println();
							System.out.println("Enter your option here...");
							System.out.println("Your Option ....");
							int option=sc.nextInt();
							sc.nextLine();
							if(option==1)
							{
								exams ob=new exams();
								ob.startexam(statement);
							}
	//						System.out.println("Select 1 to Take Exam");
	//						System.out.println();
							if(option==2)
							{
								System.out.println("Please take your exam to view marks you have obtained in that exams");
								System.out.println("Do you wish to take your exam ?");
								System.out.println("If so, Now enter 1");
								int ag=sc.nextInt();
								sc.nextLine();
								if(ag==1)
								{
									exams ob=new exams();
									ob.startexam(statement);
								}
								else
								{
									System.out.println("You have entered a wrong input..Please try again ");
								}
							}
							break;
						}
					}
				}
				if(inp!='N' && inp!='n' && inp!='r' && inp!='R')
				{
					System.out.println("Please enter valid character");
	//				break;
				}

			} 
	 }

}

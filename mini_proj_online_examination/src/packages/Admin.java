package packages;
import java.util.*;

import java.sql.*;


public class Admin
{
	private static int admin_id=1547;
	private static String password="arunjegajith";
	public static Statement stmt;
	
	public static int getAdmin_id() {
		return admin_id;
	}

	public static void setAdmin_id(int admin_id) {
		Admin.admin_id = admin_id;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Admin.password = password;
	}
	
	static Scanner sc=new Scanner(System.in);
	
	
	public static void Admincheck(int id,String pword,Statement inc) throws SQLException, ClassNotFoundException
	{
		int flag=0;
		
		if(admin_id == id && password.equals(pword))
		{
			System.out.println("Admin has logged in successfully");
			flag++;
		}
		
		if(flag==0)
		{
			System.out.println("The Admin credentials you've entered is fake..!!!!!");
		}
		
		if(flag==1)
		{
			Admin.operation(inc);
		}
	}
	
	public static void operation(Statement inc) throws SQLException, ClassNotFoundException
	{
		System.out.println("What operation would you like to perform from here..?????");
		while(true)
		{
		System.out.println("1.Create Test");
		System.out.println("2.Update Test");
		System.out.println("3.Delete Test");
		System.out.println("4.View Tests");
		System.out.println("Enter your option here...");
		int input=sc.nextInt();
		sc.nextLine();
		switch(input)
		{
		case 1:
		{
			System.out.println("Which test you would like to create here...");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");
            String subject = sc.nextLine();

            subject = subject.replaceAll("\\s+", "_");

            String createQuery = "CREATE TABLE " + subject + " (ques_id INT PRIMARY KEY NOT NULL, question VARCHAR(255), marks INT,ans VARCHAR(40))";
            int result = inc.executeUpdate(createQuery);

          
            if (result == 0) {
                System.out.println("Test '" + subject + "' created successfully.");
            } else {
                System.out.println("Test '" + subject + "' creation failed.");
            }
			System.out.println("It's time to insert datas to fields in the table you have created ");
			System.out.println();
			System.out.println("How many questions you would like to add");
			int times=sc.nextInt();
			
			for(int i=0;i<times;i++)
			{
			    System.out.println("Enter the ques_id here...>>>");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println();
				System.out.println("Enter the question here>>>");
				String ques=sc.nextLine();
				System.out.println("Enter the marks for this question");
				int max_marks=sc.nextInt();
//				String bool="false";
				sc.nextLine();
				System.out.println("Give the apt answer for the question you've given");
				String ans=sc.nextLine();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","Arun@06102003");
				Statement statement=connection.createStatement();
					PreparedStatement pstmt=connection.prepareStatement("insert into "+subject+" (ques_id,question,marks,ans)values (?,?,?,?)");
					 pstmt.setInt(1, id);
					 pstmt.setString(2,ques);
					 pstmt.setInt(3, max_marks);
					 pstmt.setString(4, ans);
					int r = pstmt.executeUpdate();
	
			            if (r> 0) 
			            {
			                System.out.println("Data inserted successfully.");
			            } else
			            {
			                System.out.println("Data insertion failed.");
			            }
			            
			}
	            

			System.out.println("Test "+  subject+ "has been Successfully created ");
			
			break;
		}
			case 2:
			{
				System.out.println("You have decided to update a question");
				String subject=sc.nextLine();
//				String upquery=""
				break;
			}
			case 3:
			{
				System.out.println("You have decided to delete a test entirely");
				System.out.println("Refer the available tests once...");
				String show = "SHOW TABLES";
				ResultSet rs = inc.executeQuery(show);

				while (rs.next())
				{
				    System.out.println(rs.getString(1));
				}

				System.out.println();
				System.out.println("Now enter the test you wish to delete");
				String delete = sc.nextLine();
				String deletequery = "DROP TABLE " + delete; // Add space after "TABLE"
				int res = inc.executeUpdate(deletequery);
//				System.out.print(res);-
				if (res == 0) {
				    System.out.println("The test has been successfully deleted.");
				} else {
				    System.out.println("There was an error deleting the test.");
				}

				break;
			}
			case 4:
			{	
		//			Statement stmt = null;
					String show="show tables";
					ResultSet rs=inc.executeQuery(show);
					while(rs.next())
					{
						System.out.println(rs.getString(1));
					}
					break;
		     }
			default:
			{
				System.out.println("*** Default statement ****");
				break;
			}
		}	
	}
	}
	
}

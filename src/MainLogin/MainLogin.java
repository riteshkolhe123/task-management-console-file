package MainLogin;
import java.io.IOException;
import java.util.Scanner;
import TaskManagement.TaskManagement;
import UserManagement.UserManagement;

public class MainLogin {
	
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		boolean CanIKeepRunningTheProgram = true;
		
			System.out.println("❖ Welcome To Task Management System ❖");

			System.out.print("--Login Page--");
			
			System.out.println("\n");
			
			System.out.println("Enter Login Name :");
			String Loginname = sc.nextLine();
			
			System.out.println("Enter Password :");
			String Password = sc.nextLine();
			
			if(!UserManagement.ValidateLoginnameAndPassword(Loginname,Password))
			{
				System.out.println("\n");
				System.out.println("Login Failed.");
				return;
			}
			
			while(CanIKeepRunningTheProgram == true)
			{
				System.out.println("!❖! Welcome To Task Management System !❖!");
				System.out.println("\n");
				System.out.println("What would you like to do ?");
				System.out.println("1. Task Management");
				System.out.println("2. User Management");
				System.out.println("3. Quit");
				System.out.println("\n");
				
				int OptionSelectedByUser = sc.nextInt();
				
				if(OptionSelectedByUser == 1)
				{
					TaskManagement.TaskManagement();
					System.out.println("\n");
				}
				else if(OptionSelectedByUser == 2)
				{
					UserManagement.UserManagement();
					System.out.println("\n");
				}
				else if(OptionSelectedByUser == 3)
				{
					System.out.println("..PROGRAM HAS BEEN CLOSED..");
					break;
				}
			
			
		}
	}


	}



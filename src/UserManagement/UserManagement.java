package UserManagement;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class UserManagement {
	
	static ArrayList<User> list = new ArrayList<>();
	
	static {
		try {
			loadDataFromFileToArrayList();
		}
		catch(IOException e){
			//TODO auto generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void UserManagement() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		boolean CanIKeepRunningTheProgram = true;
		
		while(CanIKeepRunningTheProgram == true)
		{
			System.out.println("!*  User Management  *!");
			System.out.println("\n");
			System.out.println("What would you like to do ?");
			System.out.println("1. Add User");
			System.out.println("2. Edit User");
			System.out.println("3. Search User");
			System.out.println("4. Delete User");
			System.out.println("5. Quit");
			
			int OptionSelectedByUser = sc.nextInt();
			
			if(OptionSelectedByUser == UserOptions.ADD_USER)
			{
				AddUser();
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == UserOptions.EDIT_USER)
			{
				System.out.println("Enter the User name which you want to edit : ");
				sc.nextLine();
				String eu = sc.nextLine();
				EditUser(eu);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == UserOptions.SEARCH_USER)
			{
				System.out.println("Enter Username which you want to search : ");
				sc.nextLine();
				String su = sc.nextLine();
				SearchUser(su);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == UserOptions.DELETE_USER)
			{
				System.out.println("Enter Username which you want to delete : ");
				sc.nextLine();
				String du = sc.nextLine();
				DeleteUser(du);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == UserOptions.QUIT)
			{
				File file = new File("C:\\Users\\rites\\eclipse-workspace\\Task Manager\\src\\UserManagement\\Users");
				FileWriter fr = new FileWriter(file,false);
				BufferedWriter br = new BufferedWriter(fr);
				for(User u : list)
				{
					System.out.println(u.Username+","+u.Loginname+","+u.Password+","+u.Userrole+"\n");
					br.write(u.Username+","+u.Loginname+","+u.Password+","+u.Userrole+"\n");
				}
				br.close();
				fr.close();
				file = null;
				
				CanIKeepRunningTheProgram = false;
				
				System.out.println("!! Program Closed !!");
			}
		}
	}
	public static void AddUser()
	{
		Scanner sc = new Scanner(System.in);
		User u = new User();
		
		System.out.println("Enter User Name : ");
		u.Username = sc.nextLine();
		
		System.out.println("Enter Login Name : ");
		u.Loginname = sc.nextLine();
		
		System.out.println("Enter Password : ");
		u.Password = sc.nextLine();
		
		System.out.println("Enter User Role : ");
		u.Userrole = sc.nextLine();
		
		System.out.println("Adding User "+u.Username+" with the details.");
		
		list.add(u);
		
	}
	public static boolean ValidateLoginnameAndPassword(String Loginname,String Password)
	{
		Iterator<User> itr = list.iterator();
		
		while(itr.hasNext())
		{
			User u = itr.next();
			
			if(u.Loginname.equalsIgnoreCase(Loginname) && u.Password.equalsIgnoreCase(Password) )
			{
				System.out.println("Login Successfull.");
				System.out.println("\n");
				return true;
			}
		}
		return false;
		
	}
	public static void EditUser(String eu)
	{
		Scanner sc = new Scanner(System.in);
		for(User u  : list)
		{
			if(u.Username.equalsIgnoreCase(eu))
			{
				System.out.println("Current Username : "+eu);
				
				System.out.println("New User Name is : ");
				String Username = sc.nextLine();
				
				System.out.println("New Login Name is : ");
				String Loginname = sc.nextLine();
				
				System.out.println("New Password is : ");
				String Password = sc.nextLine();
				
				System.out.println("New User Role is : ");
				String Userrole = sc.nextLine();
				
				System.out.println("User Information is updated.");
				return;
				
			}
		}
				System.out.println("User Not Found.");
			
		
	}
	public static void SearchUser(String su)
	{
		Scanner sc = new Scanner(System.in);
		
		for(User u : list)
		{
			if(u.Username.equalsIgnoreCase(su))
			{
				System.out.println("User Found Successfully.Following is the information of user :");
				System.out.println("Username is : "+u.Username);
				System.out.println("Loginname is : "+u.Loginname);
				System.out.println("Password is : "+u.Password);
				System.out.println("Userrole is : "+u.Userrole);
				return;
			}
		}
			
				System.out.println("User Not Found.");
			
		
	}
	public static void DeleteUser(String du)
	{
		Scanner sc = new Scanner(System.in);
		
		Iterator<User> itr = list.iterator();
		
		while(itr.hasNext())
		{
			User u = itr.next();
			
			if(u.Username.equalsIgnoreCase(du))
			{
				itr.remove();
				System.out.println("User "+u.Username+" has been deleted");
				break;
			}
			}
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\Users\\rites\\eclipse-workspace\\Task Manager\\src\\UserManagement\\Users");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while((line = br.readLine())!=null)
		{
			User v = new User();
			String [] UserDataArray = line.split(",");
			if(UserDataArray.length>3)
			{
				v.Username = UserDataArray[0];
				v.Loginname = UserDataArray[1];
				v.Password = UserDataArray[2];
				v.Userrole = UserDataArray[3];
				
				list.add(v);
				
			}
			
	}
		fr.close();
		br.close();
		file = null;
		

}
}

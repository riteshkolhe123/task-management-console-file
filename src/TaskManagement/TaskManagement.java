package TaskManagement;
import java.util.Scanner;

import UserManagement.UserOptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskManagement {
	
	static ArrayList<Task> list = new ArrayList<>();
	
	static {
		try {
			loadDataFromFileToArrayList();
		}
		catch(IOException e){
			//TODO auto generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void TaskManagement() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		boolean CanIKeepRunningTheProgram = true;
		
		while(CanIKeepRunningTheProgram == true)
		{
			System.out.println("!* Task Management  *!");
			System.out.println("\n");
			System.out.println("What would you like to do ?");
			System.out.println("1. Add Task");
			System.out.println("2. Update Task");
			System.out.println("3. Delete Task");
			System.out.println("4. Search Task");
			System.out.println("5. Quit");
			
			int OptionSelectedByUser = sc.nextInt();
			
			
			if(OptionSelectedByUser == TaskOptions.AddTask)
			{
				AddTask();
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == TaskOptions.UpdateTask)
			{
				System.out.println("Enter Task name which you want to Update : ");
				sc.nextLine();
				String ut = sc.nextLine();
				UpdateTask(ut);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == TaskOptions.DeleteTask)
			{
				System.out.println("Enter Task name which you want to Delete : ");
				sc.nextLine();
				String dt = sc.nextLine();
				DeleteTask(dt);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == TaskOptions.SearchTask)
			{
				System.out.println("Enter Task name which you want to Search : ");
				sc.nextLine();
				String st = sc.nextLine();
				SearchTask(st);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == TaskOptions.Quit)
			{
				
				File file = new File("C:\\Users\\rites\\eclipse-workspace\\Task Manager\\src\\TaskManagement\\Tasks");
				FileWriter fr = new FileWriter(file,false);
				BufferedWriter br = new BufferedWriter(fr);
				
				for(Task t : list)
				{
					System.out.println(t.Taskname+","+t.Taskid+","+t.Taskstatus+","+t.Timerequired+"\n");
					br.write(t.Taskname+","+t.Taskid+","+t.Taskstatus+","+t.Timerequired+"\n");
				}
				br.close();
				fr.close();
				file = null;
				
				CanIKeepRunningTheProgram = false;
				System.out.println("!! Program Closed !!");
				
			}
			
		}
	}
	public static void AddTask()
	{
		Scanner sc = new Scanner(System.in);
		
		Task t = new Task();
		
		System.out.println("Enter Task name : ");
		t.Taskname = sc.nextLine();
		
		System.out.println("Enter Task ID :");
		t.Taskid = sc.nextLine();
		
		System.out.println("Enter Task Status : ");
		t.Taskstatus = sc.nextLine();
		
		System.out.println("Time Required : ");
		t.Timerequired = sc.nextLine();
		
		System.out.println("Task is successfully added.");
		
		list.add(t);
		
			
				
	}
	public static void UpdateTask( String ut)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Current Task name :"+ut);
		
		for(Task t : list)
		{
			if(t.Taskname.equalsIgnoreCase(ut))
			{
				System.out.println("New Task Name : ");
				String Taskname = sc.nextLine();
				
				System.out.println("New Task ID : ");
				String Taskid = sc.nextLine();
				
				System.out.println("New Task's Status: ");
				String Taskstatus = sc.nextLine();
				
				System.out.println("New Task's Required time : ");
				String Requiredtime = sc.nextLine();
				return;
				
			}
			
		}
				System.out.println("Task Not Found.");
			
		
	}
	public static void DeleteTask(String dt)
	{
		Iterator<Task> itr = list.iterator();
		
		while(itr.hasNext())
		{
			Task t = itr.next();
			
			if(t.Taskname.equalsIgnoreCase(dt))
			{
				itr.remove();
				System.out.println("Task "+t.Taskname+" has been deleted");
				break;
			}
			
		}
	}
	public static void SearchTask(String st)
	{
		for(Task t : list)
		{
			if(t.Taskname.equalsIgnoreCase(st))
			{
				System.out.println("Task Found.Following is the information of task.");
				
				System.out.println("Task name :"+t.Taskname);
				System.out.println("Task ID :"+t.Taskid);
				System.out.println("Task Status :"+t.Taskstatus);
				System.out.println("Time Required to complete the task :"+t.Timerequired);
				
				return;
			}
			
		}
				System.out.println("Task Not Found.");
		
		
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\Users\\rites\\eclipse-workspace\\Task Manager\\src\\TaskManagement\\Tasks");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String line = " ";
		while((line = br.readLine())!=null)
		{
			Task t = new Task();
			String [] dataFromArray = line.split(",");
			if(dataFromArray.length>3)
			{
				t.Taskname = dataFromArray[0];
				t.Taskid = dataFromArray[1];
				t.Taskstatus = dataFromArray[2];
				t.Timerequired = dataFromArray[3];
				
				list.add(t);
				
			}
			
			
		}
		br.close();
		fr.close();
		file = null;
	}

}

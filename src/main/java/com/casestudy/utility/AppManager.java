package com.casestudy.utility;

import java.time.LocalDate;
import java.util.Scanner;

import com.casestudy.services.EmployeeService;
import com.training.model.Employee;

public abstract class AppManager {
	private static EmployeeService service = new EmployeeService() ; 
	private static Scanner sc = new Scanner(System.in) ; 
	
	public static void showAvailableOptions() 
	{
		// enter numbers from 1 to 7 to perform separate tasks
		// 1 -> it adds employee details
		// 2 -> it gets the list of employees by their first name 
		// 3 -> it gets the list of employees by their first name and phone number
		// 4 -> it updates the email and phone number of a particular employee
		// 5 -> it delete details of a particular employee by first name
		// 6 -> it gets the list of employees with their first name and email address whose birthday falls on the given date
		// 7 -> it get the list of employees with their first name and phone number whose wedding anniversary falls on the given date
		// 8 -> to exit
		
    	System.out.println("1) Add employee details \r\n"
    			+ "\r\n"
    			+ "2) Get the List of employees by their firstName. \r\n"
    			+ "\r\n"
    			+ "3) Get the List of employees with FirstName and Phone Number \r\n"
    			+ "\r\n"
    			+ "4) Update the email and phoneNumber of a particular employee (by Email). \r\n"
    			+ "\r\n"
    			+ "5) Delete Details of a Particular employee by firstName \r\n"
    			+ "\r\n"
    			+ "6) Get a list of employees with their firstName and emailAddress whose Birthday falls on the given date \r\n"
    			+ "\r\n"
    			+ "7) Get the list of employees with their firstName and phone Number whose Wedding Anniversary falls on the given date \r\n"
    	        + "\r\n"
		        + "8) Exit");
    }
	public static void choiceRecommendation() 
	{
		System.out.println("Please Select a number between 1 to 8!") ; 
	}
	public static void wrongChoiceAlert() 
	{
    	 System.out.println("!!! You have choosen WRONG option!!!");
	}
	
	public static void choice1() 
	{
		 
		 System.out.println("Enter Employee's firstName -> ");
		 String firstName = sc.nextLine() ;
		 
		 System.out.println("Enter Employee's lastName");
		 String lastName = sc.nextLine() ; 
		 
		 System.out.println("Enter Employee's address");
		 String address = sc.nextLine() ; 
		 
		 System.out.println("Enter Employee's email");
		 String email = sc.nextLine() ; 
		 
		 System.out.println("Enter Employee's phone number :");
		 Long phoneNumber = Long.parseLong(sc.nextLine()); 
		 
		 System.out.println("Enter Employee's date of birth in dd/mm/yyyy format");
		 String dateOfBirth = sc.nextLine() ;
		 String[] parts = dateOfBirth.split("/") ;
		 System.out.println(parts.length);
		 LocalDate dateOfBirthActual = LocalDate.of(Integer.parseInt(parts[2]) , 
				 									Integer.parseInt(parts[1]) , 
				 									Integer.parseInt(parts[0])); 
		 
		 System.out.println("Enter Employee's wedding date in dd/mm/yyyy format");
		 String dateOfWedding = sc.nextLine() ; 
		 parts = dateOfWedding.split("/"); 
		 LocalDate dateOfWeddingActual = LocalDate.of(Integer.parseInt(parts[2]) , 
													  Integer.parseInt(parts[1]) , 
													   Integer.parseInt(parts[0]));
		 service.addEmployee(
				 new Employee(firstName, lastName, address, 
				              email, phoneNumber, dateOfBirthActual, dateOfWeddingActual)
		 ) ; 
	}
	
    public static void choice2() 
    {
    	System.out.println("Enter Employee's firstName");
    	String firstName = sc.nextLine() ; 
    	service.getEmployeesByFirstName(firstName);
	}
    
    public static void choice3() 
    {
		service.getEmployeesWithFirstNameAndPhoneNumber();
	}
    
    public static void choice4() 
    {
    	System.out.println("Enter the email of the employee that you want to modify");
    	String oldEmail = sc.nextLine() ; 
    	System.out.println("Now enter New Mobile Number");
    	Long phoneNumber = Long.parseLong(sc.nextLine()) ; 
    	System.out.println("Enter New Email id");
    	String newEmail = sc.nextLine();
    	service.updateEmailAndPhoneNumberByEmail(newEmail, phoneNumber, oldEmail);
    }
    
    public static void choice5() 
    {
    	System.out.println("Enter firstName");
    	String firstName = sc.nextLine() ; 
		service.deleteEmployeeByFirstName(firstName);
    }
    
    public static void choice6() 
    {
    	System.out.println("Enter Month Number") ; 
    	int monthOfTheYear = sc.nextInt() ; 
    	System.out.println("Entger Day number of that Month");
    	int dayOfTheMonth = sc.nextInt() ; 
    	service.getEmployeesFirstNameAndEmailByBirthDate(dayOfTheMonth, monthOfTheYear);
    }
    
    public static void choice7() 
    {
    	System.out.println("Enter Month Number") ; 
    	int monthOfTheYear = sc.nextInt() ; 
    	System.out.println("Entger Day number of that Month");
    	int dayOfTheMonth = sc.nextInt() ; 
    	service.getEmployeesFirstNameAndPhoneNumberByWeddingDate(dayOfTheMonth, monthOfTheYear);
	}

	public static boolean evaluteChoice(int choice)
	{
	  switch(choice) 
	  {
        case 1: choice1(); 
            break ;
        case 2: choice2();
            break ;
        case 3: choice3();
            break ; 
        case 4: choice4();
            break ; 
        case 5: choice5();
            break ; 
        case 6: choice6();
            break ; 
        case 7: choice7();
        	break ; 
        case 8: // exit case 
        	System.out.println("Shutting down.....");
        	System.exit(0);
        	break;
        default:
        	return false ;
      } 
	  return true ; 
	}
}

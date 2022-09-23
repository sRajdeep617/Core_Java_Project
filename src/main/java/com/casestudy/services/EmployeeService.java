package com.casestudy.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.casestudy.connection.ConnectionFactory;
import com.casestudy.iface.EmployeeRepository;
import com.training.implementation.EmployeeRepositoryImp;
import com.training.model.Employee;

public class EmployeeService 
{
	private EmployeeRepository<Employee, String> repo ; 
	private Connection con ; 
	private static final Logger logger = LogManager.getRootLogger(); // it stores all logging
	
	public EmployeeService() 
	{
		super(); 
		this.con = ConnectionFactory.getMySqlConnection(); // getting MySql connection 
		this.repo = new EmployeeRepositoryImp(con); 
	}
	
	public void startConnection() 
	{
		try {
			if(this.con == null || this.con.isClosed()) {
				this.con = ConnectionFactory.getMySqlConnection() ;  
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	// closing the connection
	public void closeConnection() 
	{
		try 
		{
			if(!con.isClosed())
			    con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// getting employees by first name
	public void getEmployeesByFirstName(String firstName) 
	{
		 this.repo.findall().stream()
				.filter(emp -> emp.getFirstName().equals(firstName))
				.peek(emp -> logger.info(emp))
				.collect(Collectors.toList()); 
	}

	// getting employees with first name and phone number
	public void getEmployeesWithFirstNameAndPhoneNumber() 
	{
		System.out.println(repo.findall());
		this.repo.findall().stream()
				.peek(emp -> logger.info(emp.getFirstName() + " " + emp.getPhoneNumber()))
				.collect(Collectors.toList());  
	}
	
	// getting list employees' first name and email by birth date
    public void getEmployeesFirstNameAndEmailByBirthDate(int dayOfMonth, int monthOfYear)
    {
		this.repo.findall().stream()
				.filter(emp -> {
					return dayOfMonth == emp.getDateOfBirth().getDayOfMonth() &&
							monthOfYear == emp.getDateOfBirth().getMonthValue(); 
				})
				.peek(emp -> logger.info(emp.getFirstName() + " " + emp.getEmail()))
				.collect(Collectors.toList()); 
	} 
    
    // getting list employees' first name and email by their wedding date 
    public void getEmployeesFirstNameAndPhoneNumberByWeddingDate(int dayOfMonth, int monthOfYear) {
		this.repo.findall().stream()
				.filter(emp -> {
					return dayOfMonth == emp.getDateOfWedding().getDayOfMonth() &&
							monthOfYear == emp.getDateOfWedding().getMonthValue(); 
				})
				.peek(emp -> logger.info(emp.getFirstName() + " " + emp.getPhoneNumber()))
				.collect(Collectors.toList()); 
	} 
    
    // adding the employees data
    public void addEmployee(Employee obj) {
		 if(repo.save(obj)) {
			logger.info("1 new record added to the database");  
		 }
	}
	
    // updating email and phone number
	public void updateEmailAndPhoneNumberByEmail(String newEmail, Long newPhoneNumber, String oldEmail) {
		int changed = 0 ;
		this.repo.updatePhoneNumberByPrimaryKey(oldEmail, newPhoneNumber) ; 
		changed = this.repo.updateEmailByPrimaryKey(oldEmail, newEmail); 
		logger.info(changed + " rows updated!");
	}
	
	// delete employees details by first name
	public void deleteEmployeeByFirstName(String firstName) {
		int deleted = 0 ; 
		deleted += this.repo.deleteByFirstName(firstName) ; 
		logger.info(deleted + " rows deleted!");
	}
}

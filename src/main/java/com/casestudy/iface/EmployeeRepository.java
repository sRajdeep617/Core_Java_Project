package com.casestudy.iface;

public interface EmployeeRepository<T, P> extends CRUDRepository<T, P> {

	// update email by primary key, in this case which is employee object
	// return how many rows were updated or changed
	public int updateEmailByPrimaryKey(P primaryKey, String updatedEmail);
	
	// updates phone number by employee object
	public int updatePhoneNumberByPrimaryKey(P primaryKey, Long updatedPhoneNumber);
	
	// delete by employee's first name
	// return how may rows were deleted
	public int deleteByFirstName(String employeeName);
}

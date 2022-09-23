package com.casestudy.iface;

import java.util.*;

public interface CRUDRepository<T,P> {
	// T is the object 
	// here P is the primary key
	
	// the method to save the data
	public boolean save(T obj);

	// findAll method to find the data
	public Collection<T> findall() ;
	
	// method to delete object by primary key
	public int deleteByPrimaryKey(P obj);
}

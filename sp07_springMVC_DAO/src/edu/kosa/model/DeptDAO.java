package edu.kosa.model;

import java.util.List;

public interface DeptDAO {
	
	public List listDept();   // select
	public void insertDetp(DeptDTO dto);   // insert 
	
}

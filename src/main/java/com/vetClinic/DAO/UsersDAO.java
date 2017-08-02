package com.vetClinic.DAO;

import java.sql.SQLException;
import java.util.List;

import com.vetClinic.admin.UserMaintainer;

public interface UsersDAO {
	
	public void saveOrUpdate(UserMaintainer maintainer) throws SQLException;
    
    public void delete(int user_id);
     
    public UserMaintainer get(int user_id);
     
    public List<UserMaintainer> list();
    
}

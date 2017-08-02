package com.vetClinic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.Statement;
import com.vetClinic.admin.UserMaintainer;
import com.vetClinic.dbhelper.DBconfig;
import com.vetClinic.exception.ExceptionController;

public class UsersDAOimpl implements UsersDAO {

	private JdbcTemplate jdbcTemplate;
	private DataSource dS;
	
	public UsersDAOimpl() {
		DBconfig config = new DBconfig();
		DataSource dataSource = config.dataSource();
		jdbcTemplate = new JdbcTemplate(dataSource);
		dS = dataSource;
	}
	
	@Override
	public void saveOrUpdate(UserMaintainer maintainer) {
		
		int user_id;
		String username = maintainer.getUsername();
		boolean is_admin = maintainer.getIs_admin();
		String user_email = maintainer.getEmail();
		String password = maintainer.getPassword();
		String usernameSql = "insert into users(username, email, password) values('" +username + "','" + user_email +"','" + password + "');";
		
		try {
			Connection connection = dS.getConnection();
			PreparedStatement statement = connection.prepareStatement(usernameSql, Statement.RETURN_GENERATED_KEYS);
			
			int affected_rows = statement.executeUpdate();
			
			ResultSet generatedKeys = statement.getGeneratedKeys();
			
			if (generatedKeys.next()) {
				user_id = generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
			
			statement.close();
			
			if(maintainer.getIs_admin()) {
				jdbcTemplate.execute("insert into user_roles(user_id, role) values("+user_id+", 'ROLE_ADMIN');");
			}
			jdbcTemplate.execute("insert into user_roles(user_id, role) values("+user_id+", 'ROLE_USER');");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
			
			
	}

	@Override
	public void delete(int user_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserMaintainer get(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserMaintainer> list() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.neyo.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neyo.usermanagement.model.User;

//This Dao class  provides CRUD database operation for the table users in te database.

public class UserDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/test.user?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO user" + "(name,email,country) VALUES" + "(?,?,?);";
	
	private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id=?";
	private static final String SELECT_ALL_USERS = "select * from user";
	private static final String DELETE_USER_SQL = "delete from user where id = ?;";
	private static final String UPDATE_USER_SQL = "update user set  name = ?,email = ?, country = ?, where id =?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return connection;
	}
	
	//create or insert user
	public void insertUser(User user) throws SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement(INSERT_USERS_SQL);
		preparedstatement.setString(1, user.getName());
		preparedstatement.setString(2, user.getEmail());
		preparedstatement.setString(3, user.getCountry());	
		preparedstatement.executeUpdate();
	}
	
	//create update 
	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getCountry());	
		
		rowUpdated = statement.executeUpdate() > 0;

		return rowUpdated;
	}
	
	//select user by id
	public User selectUser(int id) {
		User user = null;
		//step 1: establish a connection
		Connection connection = getConnection();
		//step 2 : Create a statement using connection object 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID); { 
		preparedStatement.setInt(1,id);
		System.out.println(preparedStatement);
		//step 3: Execute the query or update query
		ResultSet rs = preparedStatement.executeQuery();
			
		//step: 4 process the ResultSet object.
		while(rs.next()) {
			String name = rs.getString("name");
			String email = rs.getString("email");
			String country = rs.getString("country");
			user = new User(id, name, email, country);
		}
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		}
	
	//select users
	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>(); 
		//step 1: establish a connection
		Connection connection = getConnection();
		//step 2 : Create a statement using connection object 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS); { 
	
		System.out.println(preparedStatement);
		//step 3: Execute the query or update query
		ResultSet rs = preparedStatement.executeQuery();
			
		//step: 4 process the ResultSet object.
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String country = rs.getString("country");
			 users.add(new User(id, name, email, country));
		}
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		}
	
		//delete user
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);){
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate()>0;
		} 	
			return rowDeleted;		
	}
}
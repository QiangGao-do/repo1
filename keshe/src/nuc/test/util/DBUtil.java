package nuc.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/room?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String username = "root";
			String password = "lwy980814..";
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("");
		}
		return connection;
	}


	public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {//关闭连接
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	

	public static PreparedStatement getPreparedStatement(Connection connection, String sql) {//创建链接对象
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}
	

	public static Statement getStatement(Connection connection) {//创建 Statement 对象
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}
	

	public static int excuteDML(String sql, Object...objs) {//增删通用语句
		int n = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = getPreparedStatement(connection, sql);
			for (int i = 0; i < objs.length; i++) {
				preparedStatement.setObject(i+1, objs[i]);
			}
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(null, preparedStatement, connection);
		}
		return n;
	}
	
}

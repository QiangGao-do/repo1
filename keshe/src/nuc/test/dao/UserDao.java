package nuc.test.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import nuc.test.entity.User;
import nuc.test.util.DBUtil;

public class UserDao {
	public User User_login(User user){
		User user1=new User();
		 Connection conn = DBUtil.getConnection();
		 String sql="select * from user where userID=? and password=? and utype=?";
		 PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql);
		 ResultSet rs = null;
		 try{
		 pst.setString(1, user.getuserID());
		 pst.setString(2, user.getpassword());
		 pst.setString(3, user.getutype());
		 rs=pst.executeQuery();
		 if(rs.next()){
			 user1.setuserID(rs.getString("userID"));
			 user1.setpassword(rs.getString("password"));
			 user1.setuname(rs.getString("uname"));
			 user1.setutype(rs.getString("utype"));
		 }
	 }
	 catch(Exception e){
		 System.out.println(e);
	 } 
	 return user1;
	}
	
	public List<User> Select(){    //查询普通用户    
		
	    ResultSet rs=null;
	    List<User> list=new ArrayList<User>();
	
		Connection conn = DBUtil.getConnection();		
		String sql ="select * from user where utype='0';";
		PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
   try{
		rs=pst.executeQuery();
		while(rs.next()){

			User user=new User();
			user.setuserID(rs.getString("userID"));
			user.setuname(rs.getString("uname"));
			list.add(user);
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}finally {
			DBUtil.closeAll(rs, pst, conn);
		}
	return list;
	}
	
	
public int User_delete(String userID){//用户删除
		
		int rs=0;
		try{
		    Connection conn = DBUtil.getConnection();
			
		
			String sql ="delete from meeting where  userID=?";
			String sql1="delete from user where  userID=?";
			
			PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
			PreparedStatement pst1 = DBUtil.getPreparedStatement(conn, sql1 );
			
			pst.setString(1,userID);
			
			pst1.setString(1,userID);
			
			rs=pst.executeUpdate();pst1.executeUpdate();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
public int DoYH_add(User user){//添加用户
	
	int rs=0;
	try{
		 Connection conn = DBUtil.getConnection();

		
		String sql ="insert into user(userID,password,uname,utype) values(?,?,?,?)";
		
		PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
		
		pst.setString(1,user.getuserID());
		pst.setString(2,"123456");
		pst.setString(3,user.getuname());
		pst.setString(4,"0");
		
		rs=pst.executeUpdate();
		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return rs;
}
public int PW_xiugai(String userID,String password){//修改密码
	
	int rs=0;
	try{
	    Connection conn = DBUtil.getConnection();
	    
		String sql="update user set password =? where  userID=?";
		
		PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
		pst.setString(1,password);
		pst.setString(2,userID);
		
		rs=pst.executeUpdate();
	   }
	catch(Exception e){
		e.printStackTrace();
	}
	return rs;
}
public int AM_add(User user){//管理员注册
	
	int rs=0;
	try{
		 Connection conn = DBUtil.getConnection();

		
		String sql ="insert into user(userID,password,uname,utype) values(?,?,?,?)";
		
		PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
		
		pst.setString(1,user.getuserID());
		pst.setString(2,user.getpassword());
		pst.setString(3,user.getuname());
		pst.setString(4,"1");
		
		rs=pst.executeUpdate();
		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return rs;
}
}

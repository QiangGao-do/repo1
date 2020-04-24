package nuc.test.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import nuc.test.entity.seting;
import nuc.test.util.DBUtil;

public class SetDao {
	public List<seting> S_qinfo(){//查询设备

	     
   	    
		 Connection conn = DBUtil.getConnection();
		 List<seting> list=new ArrayList<seting>();
		 String sql ="select * from seting";
		 PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
		 ResultSet rs=null;
		try{
			
		     rs=pst.executeQuery();
		     while(rs.next()){
		    	seting set=new seting();
		    	set.setsetid(rs.getString("setid"));
		    	set.setsetname(rs.getString("setname"));
			 list.add(set);
		 }
	 }
	 catch(Exception e){
		 System.out.println(e);
	 }finally {
				DBUtil.closeAll(rs, pst, conn);
			}
	 return list;
}
public int S_del(String setid){//删除设备
		
		int rs=0;
		try{
		    Connection conn = DBUtil.getConnection();
		    
		    
		
			String sql ="delete from meeting where setid=?";
			String sql1="delete from meetset where setid=?";
			String sql2="delete from seting where setid=?";
			
			PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
			PreparedStatement pst1 = DBUtil.getPreparedStatement(conn, sql1 );
			PreparedStatement pst2 = DBUtil.getPreparedStatement(conn, sql2 );
			
			pst.setString(1,setid);
			
			pst1.setString(1,setid);
			pst2.setString(1,setid);
			
			pst.executeUpdate();
			pst1.executeUpdate();
			rs=pst2.executeUpdate();
		   }
		catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}

public int DoS_add(seting set){//添加设备
	
	int rs=0;
	try{
		 Connection conn = DBUtil.getConnection();

		
		String sql ="insert into seting(setid,setname) values(?,?)";
		
		PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
		pst.setString(1,set.getsetid());
		pst.setString(2,set.getsetname());
		
		rs=pst.executeUpdate();
		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return rs;
}
}



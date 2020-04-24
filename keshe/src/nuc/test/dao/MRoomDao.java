package nuc.test.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nuc.test.entity.meetingroom;
import nuc.test.util.DBUtil;

public class MRoomDao {
	public List<meetingroom> MR_qinfo(){//查询所有会议室

  	     
   	    
  		 Connection conn = DBUtil.getConnection();
  		 List<meetingroom> list=new ArrayList<meetingroom>();
  		 String sql ="select * from meetingroom";
  		 PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
  		 ResultSet rs=null;
  		try{
  			
  		     rs=pst.executeQuery();
  		     while(rs.next()){
  		     meetingroom mroom=new meetingroom();
  			 mroom.setmeetingRoomid(rs.getString("meetingRoomid"));
  			 mroom.setmeetingRoomName(rs.getString("meetingRoomName"));
  			 mroom.setseatingAmount(rs.getString("seatingAmount"));
  			 mroom.setisuse(rs.getString("isuse"));
  			 list.add(mroom);
  		 }
  	 }
  	 catch(Exception e){
  		 System.out.println(e);
  	 }finally {
				DBUtil.closeAll(rs, pst, conn);
			}
  	 return list;
   } 
	
	public List<meetingroom> MR_info(){//查询可用会议室

 	     
   	    
 		 Connection conn = DBUtil.getConnection();
 		 List<meetingroom> list=new ArrayList<meetingroom>();
 		 String sql ="select * from meetingroom where isuse='1'";
 		 PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
 		 ResultSet rs=null;
 		try{
 			
 		     rs=pst.executeQuery();
 		     while(rs.next()){
 		     meetingroom mroom=new meetingroom();
 			 mroom.setmeetingRoomid(rs.getString("meetingRoomid"));
 			 mroom.setmeetingRoomName(rs.getString("meetingRoomName"));
 			 mroom.setseatingAmount(rs.getString("seatingAmount"));
 			 list.add(mroom);
 		 }
 	 }
 	 catch(Exception e){
 		 System.out.println(e);
 	 }finally {
				DBUtil.closeAll(rs, pst, conn);
			}
 	 return list;
  } 
	
public int MRoom_xiugai(String meetingRoomid){//状态修改为关闭
		
		int rs=0;
		try{
		    Connection conn = DBUtil.getConnection();
		    
		    
		
			String sql ="delete from meeting where  meetingRoomid=?";
			String sql1="update meetingroom set isuse='0' where  meetingRoomid=?";
			
			PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
			PreparedStatement pst1 = DBUtil.getPreparedStatement(conn, sql1 );
			
			pst.setString(1,meetingRoomid);
			
			pst1.setString(1,meetingRoomid);
			
			rs=pst.executeUpdate();
			pst1.executeUpdate();
		   }
		catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}

public int MRoom_xiukai(String meetingRoomid){//状态修改为开放
	
	int rs=0;
	try{
	    Connection conn = DBUtil.getConnection();
	    
	    
		String sql1="update meetingroom set isuse='1' where  meetingRoomid=?";
		
		PreparedStatement pst1 = DBUtil.getPreparedStatement(conn, sql1 );
		
		
		pst1.setString(1,meetingRoomid);
		
		rs=pst1.executeUpdate();
	   }
	catch(Exception e){
		e.printStackTrace();
	}
	return rs;
	}


public List<meetingroom> MR_seat(String seatingAmount) throws SQLException{//查询位置数大于参加人数的会议室

     
	    
	 Connection conn = DBUtil.getConnection();
	 List<meetingroom> list=new ArrayList<meetingroom>();
	 String sql ="select * from meetingroom where isuse='1' and seatingAmount >= ?";
	 PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
	 pst.setString(1, seatingAmount);
	 ResultSet rs=null;
	try{
		
	     rs=pst.executeQuery();
	     while(rs.next()){
	     meetingroom mroom=new meetingroom();
		 mroom.setmeetingRoomid(rs.getString("meetingRoomid"));
		 mroom.setmeetingRoomName(rs.getString("meetingRoomName"));
		 mroom.setseatingAmount(rs.getString("seatingAmount"));
		 list.add(mroom);
	 }
 }
 catch(Exception e){
	 System.out.println(e);
 }finally {
			DBUtil.closeAll(rs, pst, conn);
		}
 return list;
} 


}
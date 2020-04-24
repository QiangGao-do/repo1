package nuc.test.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import nuc.test.entity.meeting;
import nuc.test.util.DBUtil;

public class MeetDao {
	public ResultSet yixuan(String userId){
	  	 ResultSet rs=null;
	  	 try{
	  		
	  		 Connection conn = DBUtil.getConnection();
	  		 String sql ="select meetid,meetingRoomid,setid,partNumber,startDate,endDate from meeting where userID=?";
	  		 PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
	  		 pst.setString(1, userId);
	  		 rs=pst.executeQuery();
	  		
	  	 }
	  	 catch(Exception e){
	  		 System.out.println(e);
	  	 }
	  	 return rs;
	   }
		

		public int M_tuiroom(String userID,String meetid){
		  	 int rs=0;
		  	 try{
		  		 Connection conn = DBUtil.getConnection();
		  		 String sql ="delete  from meeting where userId=? and meetid=?";
		  		PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
		  		 pst.setString(1, userID);
		  		 pst.setString(2, meetid);
		  		 rs=pst.executeUpdate();
		  	 }
		  	 catch(Exception e){
		  		 System.out.println(e);
		  	 }
		  	 return rs;
		   }
		
		public int Me_add(String userID,String meetingRoomid,String setid,String partNumber,String startDate,String endDate){
			
			int rs=0;
			
			try{
				 Connection conn = DBUtil.getConnection();
				
				String sql ="insert into meeting(userID,meetingRoomid,setid,partNumber,startDate,endDate) values(?,?,?,?,?,?)";
				PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql);
			
				pst.setString(1, userID);
				pst.setString(2, meetingRoomid);
				pst.setString(3, setid);
				pst.setString(4, partNumber);	
				pst.setString(5, startDate);
				pst.setString(6, endDate);	
				
				rs=pst.executeUpdate();
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
			return rs;
		}
		
		public ResultSet M_xuanze(String meetingRoomid){//查询该会议室已有会议
		  	 ResultSet rs=null;
		  	 try{
		  		
		  		 Connection conn = DBUtil.getConnection();
		  		 String sql ="select meetid,startDate,endDate from meeting where meetingRoomid=?";
		  		 PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
		  		 pst.setString(1, meetingRoomid);
		  		 rs=pst.executeQuery();
		  		
		  	 }
		  	 catch(Exception e){
		  		 System.out.println(e);
		  	 }
		  	 return rs;
		   }
		
		public meeting ME_pan1(meeting meet){
			 meeting mee1=new meeting();
			 Connection conn = DBUtil.getConnection();
			 String sql="select t1.meetingRoomid from (select * from meeting where startDate between ? and ? or endDate between ? and ?)AS t1 inner join (select * from meeting where meetingRoomid=?)as t2 where t1.meetid=t2.meetid";
			 PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql);
			 ResultSet rs = null;
			 try{
				 pst.setString(1,meet.getStartDate());
				 pst.setString(2,meet.getEndDate());
				 pst.setString(3,meet.getStartDate());
				 pst.setString(4,meet.getEndDate());
				 pst.setString(5,meet.getMeetingRoomid());
			 rs=pst.executeQuery();
			 if(rs.next()){
				mee1.setMeetingRoomid(rs.getString("meetingRoomid"));
			 }
		 }
		 catch(Exception e){
			 System.out.println(e);
		 } 
		 return mee1;
		}
		
		public meeting ME_pan2(meeting meet){
			 meeting mee1=new meeting();
			 Connection conn = DBUtil.getConnection();
			 String sql="select * from meeting where meetingRoomid=? and startDate<? and endDate>?";
			 PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql);
			 ResultSet rs = null;
			 try{
				 pst.setString(1,meet.getMeetingRoomid());
				 pst.setString(2,meet.getStartDate());
				 pst.setString(3,meet.getEndDate());
			 rs=pst.executeQuery();
			 if(rs.next()){
				mee1.setMeetingRoomid(rs.getString("meetingRoomid"));
			 }
		 }
		 catch(Exception e){
			 System.out.println(e);
		 } 
		 return mee1;
		}
}

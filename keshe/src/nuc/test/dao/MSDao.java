package nuc.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nuc.test.entity.meetset;
import nuc.test.util.DBUtil;

public class MSDao {
	public List<meetset> MSet_qinfo(String meetingRoomid) throws SQLException{//查询该会议室所有设备

	     
   	    
		 Connection conn = DBUtil.getConnection();
		 List<meetset> list=new ArrayList<meetset>();
		 String sql ="select setid,isbad from meetset where meetingRoomid=?";
		 PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
		 pst.setString(1,meetingRoomid);
		 ResultSet rs=null;
		try{
			
		     rs=pst.executeQuery();
		     while(rs.next()){
		    	meetset mset=new meetset();
		    	mset.setsetid(rs.getString("setid"));
		    	mset.setisbad(rs.getString("isbad"));
			 list.add(mset);
		 }
	 }
	 catch(Exception e){
		 System.out.println(e);
	 }finally {
				DBUtil.closeAll(rs, pst, conn);
			}
	 return list;
 }
	
	public List<meetset> MSet_info(String meetingRoomid) throws SQLException{//查询该会议室可用设备

	     
   	    
		 Connection conn = DBUtil.getConnection();
		 List<meetset> list=new ArrayList<meetset>();
		 String sql ="select setid from meetset where meetingRoomid=? and isbad='1'";
		 PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
		 pst.setString(1,meetingRoomid);
		 ResultSet rs=null;
		try{
			
		     rs=pst.executeQuery();
		     while(rs.next()){
		    	meetset mset=new meetset();
		    	mset.setsetid(rs.getString("setid"));
			 list.add(mset);
		 }
	 }
	 catch(Exception e){
		 System.out.println(e);
	 }finally {
				DBUtil.closeAll(rs, pst, conn);
			}
	 return list;
}
	
public int Set_xiugai(String meetingRoomid,String setid){//状态修改为不可用
		
		int rs=0;
		try{
		    Connection conn = DBUtil.getConnection();
		    
		    
		
			String sql ="delete from meeting where meetingRoomid=? and setid=?";
			String sql1="update meetset set isbad='0' where  meetingRoomid=? and setid=?";
			
			PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
			PreparedStatement pst1 = DBUtil.getPreparedStatement(conn, sql1 );
			pst.setString(1,meetingRoomid);
			pst.setString(2,setid);
			pst1.setString(1,meetingRoomid);
			pst1.setString(2,setid);
			
			rs=pst.executeUpdate();
			pst1.executeUpdate();
		   }
		catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}

public int Set_xiukai(String meetingRoomid,String setid){//状态修改为可用
	
	int rs=0;
	try{
	    Connection conn = DBUtil.getConnection();
	    
		String sql1="update meetset set isbad='1' where  meetingRoomid=? and setid=?";
		
		PreparedStatement pst1 = DBUtil.getPreparedStatement(conn, sql1 );
		
		pst1.setString(1,meetingRoomid);
		pst1.setString(2,setid);
		
		rs=pst1.executeUpdate();
	   }
	catch(Exception e){
		e.printStackTrace();
	}
	return rs;
}

public int DoSet_add(meetset mset){//添加设备
	
	int rs=0;
	try{
		 Connection conn = DBUtil.getConnection();

		
		String sql ="insert into meetset(meetingRoomid,setid,isbad) values(?,?,?)";
		
		PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
		pst.setString(1,mset.getmeetingRoomid());
		pst.setString(2,mset.getsetid());
		pst.setString(3,"1");
		
		rs=pst.executeUpdate();
		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return rs;
}

public ResultSet MS_xuanze(String meetingRoomid){
 	 ResultSet rs=null;
 	 try{
 		
 		 Connection conn = DBUtil.getConnection();
 		 String sql ="select meetid from meetset where meetingRoomid=?";
 		 PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
 		 pst.setString(1, meetingRoomid);
 		 rs=pst.executeQuery();
 		
 	 }
 	 catch(Exception e){
 		 System.out.println(e);
 	 }
 	 return rs;
  }
public int Set_del(String setid,String meetingRoomid){//删除会议室设备
	
	int rs=0;
	try{
	    Connection conn = DBUtil.getConnection();
	    
	    
	
		String sql ="delete from meeting where setid=? and meetingRoomid=?";
		String sql1="delete from meetset where setid=? and meetingRoomid=?";
		
		PreparedStatement pst = DBUtil.getPreparedStatement(conn, sql );
		PreparedStatement pst1 = DBUtil.getPreparedStatement(conn, sql1 );
		
		pst.setString(1,setid);
		pst.setString(2,meetingRoomid);
		
		pst1.setString(1,setid);
		pst1.setString(2,meetingRoomid);
		
		pst.executeUpdate();
		rs=pst1.executeUpdate();
	   }
	catch(Exception e){
		e.printStackTrace();
	}
	return rs;
}
}

package nuc.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nuc.test.dao.MeetDao;

/**
 * Servlet implementation class DoStu_yixuan
 */
@WebServlet("/yixuan")
public class yixuan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public yixuan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>显示已选会议</TITLE></HEAD>");
		out.println("  <BODY>");
		try{
			String userID=session.getAttribute("userID").toString();
			MeetDao dao=new MeetDao();			
			ResultSet rs=dao.yixuan(userID);
			out.print("<table border=1 align=center>");
			out.print("<caption>已选会议</caption>");
			out.print("<tr>");
			out.print("<th>会议号</th>");
			out.print("<th>会议室号</th>");
			out.print("<th>设备号</th>");
			out.print("<th>参加人数</th>");
			out.print("<th>开始时间</th>");
			out.print("<th>结束时间</th>");
			out.print("</tr>");
			while(rs.next()){
				
				out.println("<tr><td>"+rs.getInt("meetid")+"</td>");
				out.println("<td>"+rs.getString("meetingRoomid")+"</td>");
				out.println("<td>"+rs.getString("setid")+"</td>");
				out.println("<td>"+rs.getString("partNumber")+"</td>"); 
				out.println("<td>"+rs.getString("startDate")+"</td>");
				out.println("<td>"+rs.getString("endDate")+"</td></tr>"); 
				
			}
			out.println("<tr><a href=yonghu.jsp>返回</a></tr>");
			out.print("</table>");
		}
		catch(Exception e){
			System.out.println(e);
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}

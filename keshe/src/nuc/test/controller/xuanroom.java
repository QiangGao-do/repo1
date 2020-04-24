package nuc.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nuc.test.dao.MRoomDao;
import nuc.test.entity.meetingroom;

/**
 * Servlet implementation class MR_guanli
 */
@WebServlet("/xuanroom")
public class xuanroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xuanroom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>选择会议室</TITLE></HEAD>");
		try {
					MRoomDao dao=new MRoomDao();
				   	List<meetingroom> list=new ArrayList<meetingroom>();
				   	String seatingAmount=request.getParameter("seatingAmount");
				   	list=dao.MR_seat(seatingAmount);
				   	Iterator<meetingroom> listall=list.iterator();//迭代器
			   		out.print("<table border=1 align=center>");
				   	out.print("<caption>会议室信息</caption>");
					out.print("<tr>");
					out.print("<th>会议室编号</th>");
					out.print("<th>会议室名</th>");
					out.print("<th>会议室容量</th>");
					out.print("<th>操作</th>");
					out.print("</tr>");

				   	while(listall.hasNext()){
				   		meetingroom mroom =listall.next();

					   	out.print("<tr>");
					   	out.print("<td>"+mroom.getmeetingRoomid()+"</td>");
					   	out.print("<td>"+mroom.getmeetingRoomName()+"</td>");
					   	out.print("<td>"+mroom.getseatingAmount()+"</td>");
					   	out.print("<td><a href="+"MR_xuan?meetingRoomid="+mroom.getmeetingRoomid()+"&seatingAmount="+seatingAmount+">选择 </a>&nbsp;");
				   	}
				   	   
				   	 out.print("</table>");
				   	 
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("<a href=xuanroom.jsp> 返回 </a>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}

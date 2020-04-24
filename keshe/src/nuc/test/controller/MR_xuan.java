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
//import javax.servlet.http.HttpSession;

import nuc.test.dao.MSDao;

import nuc.test.entity.meetset;

/**
 * Servlet implementation class MR_xuan
 */
@WebServlet("/MR_xuan")
public class MR_xuan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MR_xuan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		out.println("  <HEAD><TITLE>选择设备</TITLE></HEAD>");
		out.println("  <BODY>");
		String seatingAmount=request.getParameter("seatingAmount").toString();
		String meetingRoomid=request.getParameter("meetingRoomid").toString();

		try{
			MSDao dao=new MSDao();
		   	List<meetset> list=new ArrayList<meetset>();
		   	list=dao.MSet_info(meetingRoomid);
		   	Iterator<meetset> listall=list.iterator();//迭代器
			out.print("<table border=1 align=center>");
			out.print("<caption>所有设备</caption>");
			out.print("<tr>");
			out.print("<th>设备号</th>");
			out.print("<th>操作</th>");;
			out.print("</tr>");
			while(listall.hasNext()){
		   		meetset mset =listall.next();

			   	out.print("<tr>");
			   	out.print("<td>"+mset.getsetid()+"</td>");
			   	out.print("<td><a href="+"Meet_add?setid="+mset.getsetid()+"&meetingRoomid="+meetingRoomid+"&seatingAmount="+seatingAmount+">选择</a>&nbsp;");
		   	}
			out.print("</table>");
		}
		catch(Exception e){
			System.out.println(e);
		}
		out.println("<tr><a href=xuanroom.jsp>返回</a></tr>");
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush(); 
		out.close();
	}

}

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
 * Servlet implementation class MR_info
 */
@WebServlet("/MR_info")
public class MR_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MR_info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
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
		out.println("  <HEAD><TITLE>��ʾ���û�����</TITLE></HEAD>");
		out.println("  <BODY><center>");
		try{
			
			MRoomDao dao=new MRoomDao();
			List<meetingroom> list=new ArrayList<meetingroom>();
			list=dao.MR_info();
			Iterator<meetingroom> listall=list.iterator();//������
			out.print("<table border=1 align=center>");
		   	out.print("<caption>���л�����</caption>");
			out.print("<tr>");
			out.print("<th>�����ұ��</th>");
			out.print("<th>��������</th>");
			out.print("<th>����������</th>");
			out.print("</tr>");
			while(listall.hasNext()){
				
				meetingroom mroom =listall.next();
				out.print("<tr>");
			   	out.print("<td>"+mroom.getmeetingRoomid()+"</td>");
			   	out.print("<td>"+mroom.getmeetingRoomName()+"</td>");
			   	out.print("<td>"+mroom.getseatingAmount()+"</td>");
			   	out.print("</tr>");
		   	}
		   		out.print("</table>");
		   		out.println("<tr><a href=yonghu.jsp>����</a></tr>");
		 }
		catch(Exception e){
			System.out.println(e);
		}
		out.println(" </center></BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}

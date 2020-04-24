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

import nuc.test.dao.MSDao;
import nuc.test.entity.meetset;

/**
 * Servlet implementation class MR_guanli
 */
@WebServlet("/set_guanli")
public class set_guanli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_guanli() {
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
		out.println("  <HEAD><TITLE>设备管理</TITLE></HEAD>");
		try {
					MSDao dao=new MSDao();
					String meetingRoomid=request.getParameter("meetingRoomid").toString();
				   	List<meetset> list=new ArrayList<meetset>();
				   	list=dao.MSet_qinfo(meetingRoomid);
				   	Iterator<meetset> listall=list.iterator();//迭代器
			   		out.print("<table border=1 align=center>");
				   	out.print("<caption>设备信息</caption>");
				   	out.print("<a href="+"Set_add?meetingRoomid="+meetingRoomid+">添加设备</a>");
					out.print("<tr>");
					out.print("<th>设备编号</th>");
					out.print("<th>设备状态</th>");
					out.print("<th>操作</th>");
					out.print("<th>操作</th>");
					out.print("<th>操作</th>");
					out.print("</tr>");

				   	while(listall.hasNext()){
				   		meetset mset =listall.next();

					   	out.print("<tr>");
					   	out.print("<td>"+mset.getsetid()+"</td>");
					   	out.print("<td>"+mset.getisbad()+"</td>");
					   	out.print("<td><a href="+"Set_xiugai?setid="+mset.getsetid()+"&meetingRoomid="+meetingRoomid+">不可用</a>&nbsp;");
					   	out.print("<td><a href="+"Set_xiukai?setid="+mset.getsetid()+"&meetingRoomid="+meetingRoomid+">可用</a>&nbsp;");
					   	out.print("<td><a href="+"Set_del?setid="+mset.getsetid()+"&meetingRoomid="+meetingRoomid+">删除</a>&nbsp;");
				   	}
				   	   
				   	 out.print("</table>");
				   	 
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("<a href=MR_guanli> 返回 </a>	");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}

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
@WebServlet("/MR_guanli")
public class MR_guanli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MR_guanli() {
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
		out.println("  <HEAD><TITLE>�����ҹ���</TITLE></HEAD>");
		try {
			        //HttpSession session= request.getSession();
					MRoomDao dao=new MRoomDao();
				   	//String pno=session.getAttribute("pno").toString();
				   	List<meetingroom> list=new ArrayList<meetingroom>();
				   	list=dao.MR_qinfo();
				   	Iterator<meetingroom> listall=list.iterator();//������
			   		out.print("<table border=1 align=center>");
				   	out.print("<caption>��������Ϣ</caption>");
					out.print("<tr>");
					out.print("<th>�����ұ��</th>");
					out.print("<th>��������</th>");
					out.print("<th>����������</th>");
					out.print("<th>������״̬</th>");
					out.print("<th>����</th>");
					out.print("<th>����</th>");
					out.print("<th>�豸����</th>");
					out.print("</tr>");

				   	while(listall.hasNext()){
				   		meetingroom mroom =listall.next();

					   	out.print("<tr>");
					   	out.print("<td>"+mroom.getmeetingRoomid()+"</td>");
					   	out.print("<td>"+mroom.getmeetingRoomName()+"</td>");		
					   	out.print("<td>"+mroom.getseatingAmount()+"</td>");
					   	out.print("<td>"+mroom.getisuse()+"</td>");
					   	out.print("<td><a href="+"MR_xiugai?meetingRoomid="+mroom.getmeetingRoomid()+">�ر�</a>&nbsp;");
					   	out.print("<td><a href="+"MR_xiukai?meetingRoomid="+mroom.getmeetingRoomid()+">����</a>&nbsp;");
					   	out.print("<td><a href="+"set_guanli?meetingRoomid="+mroom.getmeetingRoomid()+">�豸����</a>&nbsp;");
				   	}
				   	   
				   	 out.print("</table>");
				   	 
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("<a href=guanliyuan.jsp> ���� </a>	");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}

package com.kdyzm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��ʾ֧�������ҳ��
public class BackServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String r1_Code=request.getParameter("r1_Code");
		PrintWriter pw=response.getWriter();
		if("1".equals(r1_Code))
		{
			String p1_MerId=request.getParameter("p1_MerId");
			String r3_Amt=request.getParameter("r3_Amt");
			String r6_Order=request.getParameter("r6_Order");
			String rp_PayDate=request.getParameter("rp_PayDate");
			pw.println("֧���ɹ���<br/>"
					+ "�̻���ţ�"+p1_MerId+"<br/>"
					+ "֧����"+r3_Amt+"<br/>"
					+"�̻������ţ�"+r6_Order+"<br/>"
					+"֧���ɹ�ʱ�䣺"+rp_PayDate);
		}
		else
		{
			pw.println("֧��ʧ�ܣ�");
		}
	}

}

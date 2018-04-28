/**
 * @author         zchangyu
 * @Date           2018年4月22日 下午7:37:41
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.regsystem.utils.PaymentUtil;

@Controller()
public class PayController {
	@RequestMapping("/pay")
	public void payController(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String 	p0_Cmd="Buy",
				p1_MerId="10001126856",
				p2_Order="0001",
				p3_Amt=request.getParameter("p3_Amt"),
				p4_Cur="CNY",
				p5_Pid="",
				p6_Pcat="",
				p7_Pdesc="",
				p8_Url="http://localhost:8080/RegSystem/back",
				p9_SAF="",
				pa_MP="",
				pd_FrpId=request.getParameter("pd_FrpId"),
				pr_NeedResponse="1";
		String keyValue="69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		String hmac=PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
		String url="https://www.yeepay.com/app-merchant-proxy/node?"+
		"&p0_Cmd="+p0_Cmd+
		"&p1_MerId="+p1_MerId+
		"&p2_Order="+p2_Order+
		"&p3_Amt="+p3_Amt+
		"&p4_Cur="+p4_Cur+
		"&p5_Pid="+p5_Pid+
		"&p6_Pcat="+p6_Pcat+
		"&p7_Pdesc="+p7_Pdesc+
		"&p8_Url="+p8_Url+
		"&p9_SAF="+p9_SAF+
		"&pa_MP="+pa_MP+
		"&pd_FrpId="+pd_FrpId+
		"&pr_NeedResponse="+pr_NeedResponse+
		"&hmac="+hmac;
		response.sendRedirect(url);
	}
}

/**
 * @author         zchangyu
 * @Date           2018年5月1日 下午4:07:31
 * @Description    TODO（一句话描述）
 */
package com.sxlvyou.controller;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxlvyou.pojo.Liuyan;
import com.sxlvyou.pojo.Product;
import com.sxlvyou.service.ILiuyanService;
import com.sxlvyou.service.IProductService;

@Controller
public class ManagerController {
	@Resource(name="productService")
	private IProductService productService;
	
	@Resource(name="liuyanService")
	private ILiuyanService liuyanService;
	@RequestMapping("manager")
	public String manager(){
		return "manager";
		
	}
	
	@RequestMapping("manaindex")
	public String manaindex(){
		return "manaindex";
	}
	
	@RequestMapping("conlist")
	public String content(HttpServletRequest request){
		List<Product> list=productService.selectAll();
		request.setAttribute("list", list);
		return "conlist";
		
	}
	
	@RequestMapping("deleteById")
	public String delete(HttpServletRequest request){
		String rid = request.getParameter("id");
		Integer id = Integer.valueOf(rid);
		productService.delete(id);
		
		
		List<Product> list=productService.selectAll();
		request.setAttribute("list", list);
		return "conlist";
	}
	
	@RequestMapping("add")
	public String addUI(HttpServletRequest req, HttpServletResponse resp){
		String title = null,type = null, img = null, concent = null;
		int is_hot = 0;
		boolean b = ServletFileUpload.isMultipartContent(req);
		if (b) {
			// 创建工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 上传器
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// 解析请求
				List<FileItem> requestList = upload.parseRequest(req);
				// 获取迭代器
				Iterator<FileItem> iterator = requestList.iterator();

				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();
					if (item.isFormField()) {
						// 处理普通表单元素
						String fiedName = item.getFieldName();
						String value = item.getString("utf-8");
						switch (fiedName) {
						case "title":
							title = value;
							
							break;
						case "type":
							type = value;
							
							break;
						case "content":
							concent = value;
							
							break;
						}
					} else {
						// 处理文件类型
						String uploadFieldName = item.getFieldName();
						String fileName = item.getName();
						String contentType = item.getContentType();
						long sizeInBytes = item.getSize();
						// 针对不同浏览器，绝对路径和文件名问题
						int index = fileName.lastIndexOf("\\");
						if (index != -1) {
							// 截取获取文件名
							fileName = fileName.substring(index + 1);
							
						}
				
						File upLoadFile = new File(req.getServletContext().getRealPath("images/"), fileName);
						img = fileName;
						item.write(upLoadFile);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String string="admin";
		productService.add(type,title,concent,img,string,new Date());
		List<Product> list=productService.selectAll();
		req.setAttribute("list", list);
		return "conlist";
	}
	
	@RequestMapping("addUI")
	public String addui(){
		return "add";
	}
	
	/*//留言
	@RequestMapping("doliuyan")
	public String liuyan(HttpServletRequest req){
		String tel=req.getParameter("tel");
		String name=req.getParameter("name");
		String content=req.getParameter("content");
		liuyanService.insert(tel, name, content);
		return "liuyan";
	}*/
	@RequestMapping("lyUI")
	public String lyui(HttpServletRequest req){
		List<Liuyan> list=liuyanService.selectAll();
		req.setAttribute("list", list);
		return "liuyanlist";
	}
	
	
}

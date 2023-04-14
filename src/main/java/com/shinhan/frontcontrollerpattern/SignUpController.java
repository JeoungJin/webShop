package com.shinhan.frontcontrollerpattern;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shinhan.model.AdminService;
import com.shinhan.vo.AdminVO;

public class SignUpController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest)data.get("request");
   		
   		
   		AdminService service = new AdminService();
   		int result = service.registerAdmin( doHandle(request));
   		return "redirect:loginCheck.do";
   		 
	}
	
	private AdminVO doHandle(HttpServletRequest request)	throws ServletException, IOException {		
   		AdminVO vo = new AdminVO();
		String encoding = "utf-8";		
		String currentPath = request.getServletContext().getRealPath("uploads");
        System.out.println(currentPath);
		File currentDirPath = new File(currentPath);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if (fileItem.isFormField()) {
					//input type이 file이 아닌것 
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					String colName = fileItem.getFieldName();
					String colValue = fileItem.getString(encoding);
					if(colName.equals("manager_name")) vo.setManager_name(colValue);
					if(colName.equals("email")) vo.setEmail(colValue);
					if(colName.equals("pass")) vo.setPass(colValue);
			   		
				} else {
					//<input type="file"/>
					System.out.println("input tag이름--getFieldName:" + fileItem.getFieldName());
					System.out.println("선택한 파일이름--getName:" + fileItem.getName());
					System.out.println("getSize:" + fileItem.getSize() + "bytes");

					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx + 1);
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile);
						
						//이미지이름이 DB에 저장되어야한다.
						vo.setPic(fileName);
						
					} // end if
				} // end if
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("adminvo:"+  vo);
		return vo;
}
	

}

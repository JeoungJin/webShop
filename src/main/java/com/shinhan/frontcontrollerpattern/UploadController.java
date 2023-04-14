package com.shinhan.frontcontrollerpattern;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest)data.get("request");
		String method = (String)data.get("method");
		if(method.equals("GET")) {
			 
			return "/uploadTest/uploadForm.jsp";
		}else {
			doHandle(request);
			return "/";
		}
		
	}
	
	private void doHandle(HttpServletRequest request)	throws ServletException, IOException {
		  
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
						} // end if
					} // end if
				} // end for
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}

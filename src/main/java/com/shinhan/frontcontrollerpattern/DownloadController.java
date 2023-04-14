package com.shinhan.frontcontrollerpattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest)data.get("request");
		HttpServletResponse response = (HttpServletResponse)data.get("response");
		doHandle(request, response);
		return "download";
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String file_repo = request.getServletContext().getRealPath("uploads");
		String fileName = (String) request.getParameter("fileName");
		System.out.println("fileName=" + fileName);
		OutputStream out = response.getOutputStream();
		String downFile = file_repo + "\\" + fileName;
		File f = new File(downFile);
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName);
		FileInputStream in = new FileInputStream(f);
		byte[] buffer = new byte[1024 * 8];
		while (true) {
			int count = in.read(buffer);
			if (count == -1)
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}

}

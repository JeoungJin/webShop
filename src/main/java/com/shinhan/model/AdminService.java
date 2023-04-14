package com.shinhan.model;

import java.util.List;

import com.shinhan.vo.AdminVO;

public class AdminService {
	AdminDAO dao = new AdminDAO();

	public int registerAdmin(AdminVO admin) {
		return dao.registerAdmin(admin);
	}

	public int dupCheck(String email) {

		return dao.dupCheck(email);

	}

	public AdminVO loginCheck(String email, String pass) {
		return dao.loginCheck(email, pass);
	}
	
	public List<AdminVO> adminList() {
		return dao.adminList();
	}
}

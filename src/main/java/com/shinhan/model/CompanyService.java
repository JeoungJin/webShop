package com.shinhan.model;

import java.util.List;

import com.shinhan.vo.DeptVO;
import com.shinhan.vo.EmpVO;
import com.shinhan.vo.JobVO;

public class CompanyService {

	CompanyDAO dao = new CompanyDAO();
	
	public List<EmpVO> managerSelectAll() {
		return dao.managerSelectAll();
	}
	public List<JobVO> jobSelectAll() {
		return dao.jobSelectAll();
	}
	public List<DeptVO> deptSelectAll() {
		return dao.deptSelectAll();
	}
}

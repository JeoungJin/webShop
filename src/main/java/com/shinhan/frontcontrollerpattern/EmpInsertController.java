package com.shinhan.frontcontrollerpattern;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shinhan.model.CompanyService;
import com.shinhan.model.EmpService;
import com.shinhan.util.DateUtil;
import com.shinhan.vo.EmpVO;

public class EmpInsertController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		String page = "empInsert.jsp";
		String method = (String)data.get("method");
		HttpServletRequest request = (HttpServletRequest)data.get("request");
		
		if(method.equals("POST")) {
			EmpVO emp = makeEmp(request);
			EmpService service = new EmpService();
			String result = service.empInsert(emp);
			HttpSession session = request.getSession();
			session.setAttribute("message", result);
			//재요청하기:Browser로 내려가서 새로운 요청으로 가기 
			page = "redirect:emplist.do";
		}else {
			//GET.....부서, 직책, 메니져를 선택하고자한다
			CompanyService service = new CompanyService();
			request.setAttribute("deptList", service.deptSelectAll());
			request.setAttribute("managerList", service.managerSelectAll());
			request.setAttribute("jobList", service.jobSelectAll());
		}
		return page;
	}
	
	private EmpVO makeEmp(HttpServletRequest request) throws UnsupportedEncodingException {
		//filter에서 수행하고 왔음 request.setCharacterEncoding("utf-8");
		//int empid = Integer.parseInt(request.getParameter("employee_id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		double salary = Double.parseDouble(request.getParameter("salary"));
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		double commission_pct = Double.parseDouble(request.getParameter("commission_pct"));
		Date hire_date =  DateUtil.convertToDate(request.getParameter("hire_date"));
		String job_id = request.getParameter("job_id");
		
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(commission_pct);
		emp.setDepartment_id(department_id);
		emp.setEmail(email);
		//emp.setEmployee_id(empid);
		emp.setFirst_name(first_name);
		emp.setHire_date(hire_date);
		emp.setJob_id(job_id);
		emp.setLast_name(last_name);
		emp.setManager_id(manager_id);
		emp.setPhone_number(phone_number);
		emp.setSalary(salary);
		
		System.out.println(emp);
		return emp;
	}
	

}

package com.shinhan.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.EmpService;
import com.shinhan.util.DateUtil;
import com.shinhan.vo.EmpVO;

/**
 * Servlet implementation class EmpDetailServlet
 */
//@WebServlet("/emp/empDetail.do")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		EmpService service = new EmpService();
		EmpVO emp = service.selectById(empid);
		request.setAttribute("emp", emp);
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmpVO emp = makeEmp(request);
		EmpService service = new EmpService();
		String message = service.empUpdate(emp);
		response.sendRedirect("emplist.do");
	}
	private EmpVO makeEmp(HttpServletRequest request) throws UnsupportedEncodingException {
		////filter에서 수행하고 왔음 request.setCharacterEncoding("utf-8");
		int empid = Integer.parseInt(request.getParameter("employee_id"));
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
		emp.setEmployee_id(empid);
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

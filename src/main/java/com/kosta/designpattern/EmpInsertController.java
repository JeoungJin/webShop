package com.kosta.designpattern;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kosta.dto.DeptDTO;
import com.kosta.dto.EmpVO;
import com.kosta.dto.JobVO;
import com.kosta.model.DeptService;
import com.kosta.model.EmpService;
import com.kosta.util.DateUtil;

public class EmpInsertController implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String method = request.getMethod();
		String page = null;
		if (method.equals("GET")) {
			DeptService dService = new DeptService();
			List<DeptDTO> dlist = dService.selectAll();

			EmpService eService = new EmpService();
			List<JobVO> jobList = eService.selctJobAll();
			request.setAttribute("dlist", dlist);
			request.setAttribute("jlist", jobList);
			request.setAttribute("mlist", eService.selctManagerAll());

			page = "empInsert.jsp";
		} else {
			EmpVO emp = makeEmp(request);
			EmpService eService = new EmpService();
			int result = eService.empInsert(emp);
			request.setAttribute("message", result > 0 ? "직원정보 insert성공" : "직원정보 insert실패");

			page = "result.jsp";
		}
		return page;
	}

	private EmpVO makeEmp(HttpServletRequest request) {
		EmpVO emp = new EmpVO();
		int empid = readInt(request, "employee_id");
		Integer mid = readInt(request, "manager_id");
		int did = readInt(request, "department_id");
		double salary = readDouble(request, "salary");
		double commission_pct = readDouble(request, "commission_pct");
		Date hire_date = readDate(request, "hire_date");

		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String job_id = request.getParameter("job_id");

		emp.setCommission_pct(commission_pct);
		emp.setDepartment_id(did);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(first_name);
		emp.setHire_date(hire_date);
		emp.setJob_id(job_id);
		emp.setLast_name(last_name);
		emp.setManager_id(mid);
		emp.setPhone_number(phone_number);
		emp.setSalary(salary);
		System.out.println(emp);
		return emp;
	}

	private int readInt(HttpServletRequest request, String column) {
		String data = request.getParameter(column);
		return Integer.parseInt(data);
	}

	private double readDouble(HttpServletRequest request, String column) {
		String data = request.getParameter(column);
		return Double.parseDouble(data);
	}

	private Date readDate(HttpServletRequest request, String column) {
		String data = request.getParameter(column);
		return DateUtil.convertToDate(data);
	}

}

<%@page import="com.shinhan.model.CompanyService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
CompanyService comService = new CompanyService();
request.setAttribute("deptList", comService.deptSelectAll());
request.setAttribute("managerList", comService.managerSelectAll());
request.setAttribute("jobList", comService.jobSelectAll());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
</script>
</head>
<body>
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">직원등록</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
				  
				    
					<form method="post" id="myfrm" action="${path}/emp/empinsert.do"
						class="mb-3">
						<table>
							<tr class="form-floating">
								<td><label for="employee_id">직원번호</label></td>
								<td><input class="form-control" type="number"
									name="employee_id" id="employee_id" required="required"
									placeholder="직원번호는sequence처리함" autofocus="autofocus"
									value="999" disabled="disabled"></td>
							</tr>
							<tr>
								<td>firstName</td>
								<td><input type="text" name="first_name" maxlength="20" id="my"></td>
							</tr>
							<tr>
								<td>LastName</td>
								<td><input type="text" name="last_name" required="required"></td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="email" name="email" required="required"></td>
							</tr>
							<tr>
								<td>phone</td>
								<td><input type="tel" name="phone_number"
									value="010-7896-8963" pattern="010-[0-9]{4}-[0-9]{4}"></td>
							</tr>
							<tr>
								<td>salary</td>
								<td><input type="number" name="salary"></td>
								 
							</tr>
							<tr>
								<td>부서</td>
								<td><select name="department_id">
										<c:forEach items="${deptList}" var="dept">
											<option value="${dept.department_id}">${dept.department_name}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>메니져</td>
								<td><select name="manager_id">
										<c:forEach items="${managerList}" var="manager">
											<option value="${manager.employee_id}">${manager.first_name}--${manager.first_name}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>커미션</td>
								<td><input type="text" name="commission_pct" value="0.2"></td>
							</tr>
							<tr>
								<td>입사일</td>
								<td><input type="date" name="hire_date" value="2021-01-10"
									required="required"></td>
							</tr>
							<tr>
								<td>직급</td>
								<td><select name="job_id">
										<c:forEach items="${jobList}" var="job">
											<option value="${job.job_id}">${job.job_title}</option>
										</c:forEach>
								</select>
							</tr>

						</table>
					</form>

				</div>
				<div class="modal-footer">
					<!-- Modal창의 form submit버튼 밖으로 옮김 -->
					<button type="button" onclick="call()" class="btn btn-secondary">직원등록</button>
					<button type="button" class="btn btn-secondary" id="btnclose" onclick="call2()">모달닫기(코드)</button>
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>

				</div>
			</div>
		</div>
	</div>
	<script>
		function call() {
			$("#myfrm").submit();
		}
		function call2(){
			$("#exampleModal").modal("hide");
		}
		function call3(){
			$("#exampleModal").modal("show");
		}
	</script>
</body>
</html>




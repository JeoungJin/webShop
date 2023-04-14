<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원상세보기</title>
<%@ include file="../common/commonfiles.jsp" %>

  <style>
    #container{
       
      width: 50%;
      margin: 0 auto;
    }
    input[name='email'],
    input[name='department_id'],
    input[name='job_id'],
    input[name='salary'],
    input[name='manager_id'],
    input[name='hire_date'] {
        background-color: pink;
    }
    
  </style>
</head>
<body>

<%-- ${} :getAttribute()
   ${emp}  <%=request.getAttribute("emp")  %>
   ${emp.employee_id}        <%=request.getAttribute("emp").getEmployee_id()  %>
  --%>

<%@ include file="../common/header.jsp" %>  
<div id="container">
    <h1>직원상세보기</h1>
	<form method="post"   
	   action="<%=request.getContextPath()%>/emp/empDetail.do" class="mb-3">
	<table >
	  <tr  class="form-floating">
	    <td><label for="employee_id">직원번호</label></td>
	    <td>
	    <span>${emp.employee_id }</span>
	    <input  type="hidden" name="employee_id" id="employee_id" 
	    value="${emp.employee_id }"   >
	    
	    </td>
	  </tr>
	  <tr>
	    <td>firstName</td>
	    <td><input type="text" name="first_name" 
	                value=${emp.first_name } maxlength="20" ></td>
	  </tr>
	  <tr>
	    <td>LastName</td>
	    <td><input type="text" value=${emp.last_name } name="last_name" required="required"></td>
	  </tr>
	  <tr>
	    <td>이메일</td>
	    <td><input type="text" value=${emp.email } name="email" required="required"></td>
	  </tr>
	  <tr>
	    <td>phone</td>
	    <td><input type="tel" name="phone_number"  
	    value=${emp.phone_number }  ></td>
	  </tr>
	  <tr>
	    <td>salary</td>
	    <td><input type="number" name="salary" value=${emp.salary }></td>
	  </tr>
	  <tr>
	    <td>부서</td>
	    <td>
	    <select name="department_id">
	      <c:forEach items="${deptList}" var="dept">
	        <option  ${emp.department_id==dept.department_id?"selected":"" }
                value="${dept.department_id}">${dept.department_name}</option>
	      </c:forEach>
	    </select>

	    </td>
	  </tr>
	  <tr>
	    <td>메니져</td>
	    <td>
	    <select name="manager_id">
         <c:forEach items="${managerList}" var="manager">
           <option ${emp.manager_id==manager.employee_id?"selected":"" }   
               value="${manager.employee_id}">${manager.first_name}--${manager.first_name}</option>
         </c:forEach>
       </select> 
	    </td>
	  </tr>
	  <tr>
	    <td>커미션</td>
	    <td><input type="text" name="commission_pct"  value=${emp.commission_pct }></td>
	  </tr>
	  <tr>
	    <td>입사일</td>
	    <td><input type="date" name="hire_date" 
	    value=${emp.hire_date }
	    required="required"></td>
	  </tr>
	  <tr>
	    <td>직급</td>
	    <td>
	    <select name="job_id">
        <c:forEach items="${jobList}" var="job">
			<option ${emp.job_id==job.job_id?"selected":"" }   
			        value="${job.job_id}">${job.job_title}</option>
        </c:forEach>
      </select>
	    
	    <input type="text" name="job_id" value=${emp.job_id } required="required" ></td>
	  </tr>
	  <tr style="text-align: center;">
	    <td colspan="2">
	       <input type="submit" value="직원정보수정">
	    </td>
	  </tr>
	</table>
	</form>
 </div>
</body>
</html>
    
package com.shinhan.vo;

import java.sql.Date;

import org.json.simple.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//JavaBeans기술 : 변수 접근지정자는 private, setter/getter, 기본생성자

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private double salary;
	private double commission_pct;
	private int manager_id;
	private int department_id;
	@Override
	public String toString() {
		return String.format(
				"'first_name':'%s', 'last_name':'%s'",first_name, last_name);
	}
	 
    
	 
}

package com.shinhan.controller;

import java.sql.Date;
import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
	    Date sdate = Date.valueOf(localDate);
	    System.out.println(localDate);
	    System.out.println(sdate);
	    
	    
	}

}

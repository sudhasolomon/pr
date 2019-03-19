package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.FileUpload;
import com.dao.TTDMonthlyLedgerOldDataUpdate;

@Controller
public class TestController {
	@Autowired
	public FileUpload fileUpload;
	
	@Autowired
	public TTDMonthlyLedgerOldDataUpdate monthly;

	@RequestMapping(value = "monthly.do")
	public void insertMonthlyData(HttpServletRequest request, HttpServletResponse response) {
		fileUpload.saveMonthlyCSV();
	}
	
	@RequestMapping(value = "yearly.do")
	public void insertYearlyData(HttpServletRequest request, HttpServletResponse response) {
		fileUpload.saveYearlyCSV();
	}
	
	
		
	@RequestMapping(value = "updateOBCB.do")
	public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		fileUpload.updateLoanOBCB();
	}
	
	@RequestMapping(value = "updateMonthlyOBCB.do")
	public void updateMonthlyOBCB(HttpServletRequest request, HttpServletResponse response) throws Exception {
		monthly.updateMonthlyOBCB();
	}
	
	public static void main(String[] args) {
		 int y = 1732;
		 double value=y % 100;
		 System.out.println(value);
		 int x = y - y % 100;
		 System.out.println("%%%% "+x);
		
	}
	
	
}



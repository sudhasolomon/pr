package com.dao;


public interface FileUpload {
	
	public void saveMonthlyCSV();
	public void saveYearlyCSV();
	
	public void updateLoanOBCB()throws Exception;

}

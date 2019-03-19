package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class TTDMonthlyLedgerOldDataUpdateImpl implements TTDMonthlyLedgerOldDataUpdate {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate1;
	

	@Override
	public void updateMonthlyOBCB()throws Exception{
		// TODO Auto-generated method stub
				//int chequeMonth = 5, chequeYear = 2009;
				//int chequeMonth = 5, chequeYear = 2010;
		//int chequeMonth = 5, chequeYear = 2011;
		//int chequeMonth = 5, chequeYear = 2012;
		//int chequeMonth = 5, chequeYear = 2013;
		//int chequeMonth = 5, chequeYear = 2014;
		//int chequeMonth = 5, chequeYear = 2015;
		//int chequeMonth = 5, chequeYear = 2016;
		//int chequeMonth = 5, chequeYear = 2017;
		//int chequeMonth = 5; 
		int chequeYear = 2009;
		//String financialYear="2009-2010";
		/*int chequeMonth = 4, chequeYear = 2017;*/
		
		/*String oldData1 = "SELECT gpfno,ob,cb,loanob,loancb,fy,gpfmonth,gpfyear,fy "
				+ "FROM gpf_monthly_08dec2017 where fy = '"+financialYer+"' and gpfmonth = '4' ";*/
		
		String oldData = "SELECT gpfno,ob,cb,loanob,loancb,fy,gpfmonth,gpfyear,fy,intamount "
				+ "FROM gpf_monthly_data_01032019 where gpfyear = '"+chequeYear+"' ";
		
		/*String intAmount1 = "select sum(intamount :: numeric)as intamount,gpfno from gpf_monthly_08dec2017 where fy = '"+financialYer+"' group by gpfno";*/
		
		/*String intAmount = "select sum(intamount :: numeric)as intamount,gpfno from gpf_monthly_data_21_may_2018_5thMonData where gpfmonth = '"+chequeMonth+"' and gpfyear = '"+chequeYear+"' group by gpfno";
		
		HashMap<String,String> intAmountMap=(HashMap<String, String>) jdbcTemplate1.query(intAmount, new ResultSetExtractor<Map>(){
		    @Override
		    public Map extractData(ResultSet rs) throws SQLException,DataAccessException {
		        HashMap<String,String> mapRet= new HashMap<String,String>();
		        while(rs.next()){
		            mapRet.put(rs.getString("gpfno"),rs.getString("intamount"));
		        }
		        return mapRet;
		    }
		});	*/	
				
		
		/* oldData = "SELECT b.gpfno, (select sum(a.intamount::numeric) from gpf_monthly_08dec2017 a where  a.fy = '2009-2010' and a.gpfno = b.gpfno) as intamount "
				+ ",b.ob,b.cb,b.loanob,b.loancb,b.fy,b.gpfmonth,b.gpfyear,b.fy FROM gpf_monthly_08dec2017 b where b.fy = '2009-2010' and b.gpfmonth = '4'";*/
		
		Statement stmt = jdbcTemplate1.getDataSource().getConnection().createStatement();
		ResultSet rs =  stmt.executeQuery(oldData);
		
		
		String updateQry = "update gpf_monthly_ledger_details_01032019_test set "
				+ " opening_balance = ?, closing_balance = ?, loan_ob = ?, loan_cb=?, "
				+ " interest = ?,financial_year = ?"
				+ " where cheque_month=? and cheque_year = ? and gpf_no = ?";
		
		PreparedStatement pstmt = jdbcTemplate1.getDataSource().getConnection().prepareStatement(updateQry);
		int loop=0;
		int[] count;
		while(rs.next()){
			try {
				
			
					++loop;	
			pstmt.setDouble(1, Double.parseDouble(rs.getString("ob")));
			pstmt.setDouble(2, Double.parseDouble(rs.getString("cb")));
			pstmt.setDouble(3, Double.parseDouble(rs.getString("loanob")));
			pstmt.setDouble(4, Double.parseDouble(rs.getString("loancb")));
			pstmt.setDouble(5, Double.parseDouble(rs.getString("intamount")));
			pstmt.setString(6, rs.getString("fy"));
			pstmt.setInt(7, rs.getInt("gpfmonth"));
			pstmt.setInt(8, chequeYear);
			
			pstmt.setString(9, rs.getString("gpfno"));
			pstmt.addBatch();
			/*if(loop==1){
				pstmt.executeBatch();
			}*/
			
			if(loop==2000){
				loop=0;
				count=pstmt.executeBatch();
			}
			
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		count=pstmt.executeBatch();
		System.out.println(chequeYear+"executed batch count :: "+count.length);
		 
		
		
	}


	

}

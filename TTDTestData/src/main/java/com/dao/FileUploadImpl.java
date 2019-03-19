package com.dao;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

@Repository("fileUpload")
public class FileUploadImpl extends BaseDAOImpl implements FileUpload {
	
	
	public void updateLoanOBCB() throws Exception{
		getJdbcTemplate().getDataSource().getConnection().setAutoCommit(false);
		Path wiki_path = Paths.get("C:\\Users\\srilakshmi\\Desktop","test1.txt");
		final List<String> allLines=Files.readAllLines(wiki_path, Charset.defaultCharset());
		String[] arr=allLines.get(0).split(",");
		System.out.println("starts");
		try{
		for(String gpfno:arr){
			String query="update gpf_yearly_ledger_mst_15122017 set "
					+ "loan_ob = ((select loanob from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2009-2010'  and gpfmonth = '4' and gpfyear = '2009')::numeric)" 
					+" ,loan_cb = ((select loancb from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2009-2010' and gpfmonth = '3' and gpfyear = '2010')::numeric)"
					+" where gpf_no in ("+gpfno+") and finacial_year = '2009-2010'";
			
			String query1="update gpf_yearly_ledger_mst_15122017 set "
					+ "loan_ob = ((select loanob from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2010-2011'  and gpfmonth = '4' and gpfyear = '2010')::numeric)" 
					+" ,loan_cb = ((select loancb from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2010-2011' and gpfmonth = '3' and gpfyear = '2011')::numeric)"
					+" where gpf_no in ("+gpfno+") and finacial_year = '2010-2011'";
			
			
			String query2="update gpf_yearly_ledger_mst_15122017 set "
					+ "loan_ob = ((select loanob from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2011-2012'  and gpfmonth = '4' and gpfyear = '2011')::numeric)" 
					+" ,loan_cb = ((select loancb from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2011-2012' and gpfmonth = '3' and gpfyear = '2012')::numeric)"
					+" where gpf_no in ("+gpfno+") and finacial_year = '2011-2012'";
			
			
			String query3="update gpf_yearly_ledger_mst_15122017 set "
					+ "loan_ob = ((select loanob from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2012-2013'  and gpfmonth = '4' and gpfyear = '2012')::numeric)" 
					+" ,loan_cb = ((select loancb from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2012-2013' and gpfmonth = '3' and gpfyear = '2013')::numeric)"
					+" where gpf_no in ("+gpfno+") and finacial_year = '2012-2013'";
			
			String query4="update gpf_yearly_ledger_mst_15122017 set "
					+ "loan_ob = ((select loanob from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2013-2014'  and gpfmonth = '4' and gpfyear = '2013')::numeric)" 
					+" ,loan_cb = ((select loancb from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2013-2014' and gpfmonth = '3' and gpfyear = '2014')::numeric)"
					+" where gpf_no in ("+gpfno+") and finacial_year = '2013-2014'";
			
			String query5="update gpf_yearly_ledger_mst_15122017 set "
					+ "loan_ob = ((select loanob from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2014-2015'  and gpfmonth = '4' and gpfyear = '2014')::numeric)" 
					+" ,loan_cb = ((select loancb from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2014-2015' and gpfmonth = '3' and gpfyear = '2015')::numeric)"
					+" where gpf_no in ("+gpfno+") and finacial_year = '2014-2015'";
			
			
			String query6="update gpf_yearly_ledger_mst_15122017 set "
					+ "loan_ob = ((select loanob from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2015-2016'  and gpfmonth = '4' and gpfyear = '2015')::numeric)" 
					+" ,loan_cb = ((select loancb from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2015-2016' and gpfmonth = '3' and gpfyear = '2016')::numeric)"
					+" where gpf_no in ("+gpfno+") and finacial_year = '2015-2016'";
			
			String query7="update gpf_yearly_ledger_mst_15122017 set "
					+ "loan_ob = ((select loanob from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2016-2017'  and gpfmonth = '4' and gpfyear = '2016')::numeric)" 
					+" ,loan_cb = ((select loancb from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2016-2017' and gpfmonth = '3' and gpfyear = '2017')::numeric)"
					+" where gpf_no in ("+gpfno+") and finacial_year = '2016-2017'";
			
			String query8="update gpf_yearly_ledger_mst_15122017 set "
					+ "loan_ob = ((select loanob from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2017-2018'  and gpfmonth = '4' and gpfyear = '2017')::numeric)" 
					//+" ,loan_cb = ((select loancb from gpf_monthly_08dec2017 where gpfno in ("+gpfno+") and fy = '2017-2018' and gpfmonth = '3' and gpfyear = '2016')::numeric)"
					+" where gpf_no in ("+gpfno+") and finacial_year = '2017-2018'";
			
			getJdbcTemplate().update(query);
			getJdbcTemplate().update(query1);
			getJdbcTemplate().update(query2);
			getJdbcTemplate().update(query3);
			getJdbcTemplate().update(query4);
			getJdbcTemplate().update(query5);
			getJdbcTemplate().update(query6);
			getJdbcTemplate().update(query7);
			getJdbcTemplate().update(query8);
			//getJdbcTemplate().update(query9);
			
			
		}
		getJdbcTemplate().getDataSource().getConnection().commit();
		}catch(Exception e){
			getJdbcTemplate().getDataSource().getConnection().rollback();
			System.out.println("===========>"+e.getMessage());
		}
	}
	
	
	

	public void saveMonthlyCSV() {
//chmaging table name from gpf_cheque_deails_05_august_2016 or gpf_monthly_06_dec_2017
		System.out.println("SAve CSV");
		Path wiki_path = Paths.get("C:\\Projects\\HRMS\\TTD\\DataDump\\Monthly","test123.txt");
		int batchResult[]=null;
		try {
			final List<String> allLines=Files.readAllLines(wiki_path, Charset.defaultCharset());
			//allLines.remove(0);
			String query = "insert into gpf_monthly_06_dec_2017 "
					+ "(instno,gpfno,empno,empname,desig,gpfc,gpfr,month,year,schno,scon,srec,da,dacheno,otherlbadd,othcheno,withdraw,pfw,finalset,recid,posteddate,wdchno,postedby,winlogin,rchno,gpfperiod,newrecord,recoverydeposit,rrecchno,sreccheno,srecchedt,rrecchedt,rchdt,schedt,schno1,rcheno,recoverychequeno)"					
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			batchResult = getJdbcTemplate().batchUpdate(query, new BatchPreparedStatementSetter() { 
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					
					String line= allLines.get(i);
					
					String[] result=line.split(",",-1);
					
					ps.setString(1, result[0].trim());
					ps.setString(2, result[1].trim());
					ps.setString(3, result[2].trim());
					ps.setString(4, result[3].trim());
					ps.setString(5, result[4].trim());
					ps.setString(6, result[5].trim());
					ps.setString(7, result[6].trim());
					ps.setString(8, result[7].trim());
					ps.setString(9, result[8].trim());
					ps.setString(10, result[9].trim());
					ps.setString(11, result[10].trim());
					ps.setString(12, result[11].trim());
					ps.setString(13, result[12].trim());
					ps.setString(14, result[13].trim());
					ps.setString(15, result[14].trim());
					ps.setString(16, result[15].trim());
					ps.setString(17, result[16].trim());
					ps.setString(18, result[17].trim());
					ps.setString(19, result[18].trim());
					ps.setString(20, result[19].trim());
					ps.setString(21, result[20].trim());
					ps.setString(22, result[21].trim());
					ps.setString(23, result[22].trim());
					ps.setString(24, result[23].trim());
					ps.setString(25, result[24].trim());
					ps.setString(26, result[25].trim());
					ps.setString(27, result[26].trim());
					ps.setString(28, result[27].trim());
					ps.setString(29, result[28].trim());
					ps.setString(30, result[29].trim());
					ps.setString(31, result[30].trim());
					ps.setString(32, result[31].trim());
					ps.setString(33, result[32].trim());
					ps.setString(34, result[33].trim());
					ps.setString(35, result[34].trim());
					ps.setString(36, result[35].trim());
					ps.setString(37, result[36].trim());
					
				}

				@Override
				public int getBatchSize() {
					return allLines.size();
				}
			});
			
		} catch (IOException e) {
			//TODO: srilakshmi to check exception is handled adequately
		}
	}

	@Override
	public void saveYearlyCSV() {
		System.out.println("yearly");
		//String join = "'" + StringUtils.join(arr,"','") + "'";

		System.out.println("SAve CSV");
		Path wiki_path = Paths.get("C:\\Projects\\HRMS\\TTD\\DataDump\\Yearly","test123.txt");
		int batchResult[]=null;
		try {
			final List<String> allLines=Files.readAllLines(wiki_path, Charset.defaultCharset());
			//allLines.remove(0);
			//changed table gpf_monthly_data_05_august_2016 or gpf_yearly_06_dec_2017
			String query = "insert into gpf_yearly_06_dec_2017 "
					+"(gpfno,gpfmonth,gpfyear,rcon,rrec,da,othloan,othdet,totadd,withdra,progtot,pfw,intrate,monthtot,finalset,gpfperiod,recid,posteddate,postedby,winlogin,newrecord,ob,cb,intamount,recoverydeposit,interest,calculationdate,loanob,loancb,missingmonths,fy)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			batchResult = getJdbcTemplate().batchUpdate(query, new BatchPreparedStatementSetter() { 
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					
					String line= allLines.get(i);
					
					String[] result=line.split(",",-1);
					
					ps.setString(1, result[0].trim());
					ps.setString(2, result[1].trim());
					ps.setString(3, result[2].trim());
					ps.setString(4, result[3].trim());
					ps.setString(5, result[4].trim());
					ps.setString(6, result[5].trim());
					ps.setString(7, result[6].trim());
					ps.setString(8, result[7].trim());
					ps.setString(9, result[8].trim());
					ps.setString(10, result[9].trim());
					ps.setString(11, result[10].trim());
					ps.setString(12, result[11].trim());
					ps.setString(13, result[12].trim());
					ps.setString(14, result[13].trim());
					ps.setString(15, result[14].trim());
					ps.setString(16, result[15].trim());
					ps.setString(17, result[16].trim());
					ps.setString(18, result[17].trim());
					ps.setString(19, result[18].trim());
					ps.setString(20, result[19].trim());
					ps.setString(21, result[20].trim());
					ps.setString(22, result[21].trim());
					ps.setString(23, result[22].trim());
					ps.setString(24, result[23].trim());
					ps.setString(25, result[24].trim());
					ps.setString(26, result[25].trim());
					ps.setString(27, result[26].trim());
					ps.setString(28, result[27].trim());
					ps.setString(29, result[28].trim());
					ps.setString(30, result[29].trim());
					ps.setString(31, result[30].trim());
					
				}

				@Override
				public int getBatchSize() {
					return allLines.size();
				}
			});
			
		} catch (IOException e) {
			//TODO: srilakshmi to check exception is handled adequately
		}
	
		
	}
	
	/*public static void main(String[] args) throws IOException {
		Path wiki_path = Paths.get("C:\\Projects\\TRT\\TSPSCPGT16_test","language.csv");
		final List<String> allLines=Files.readAllLines(wiki_path, Charset.defaultCharset());
		System.out.println(allLines.size());
		String langHallTicketNo= "'" + StringUtils.join(allLines.toArray(),"','") + "'";
		System.out.println(langHallTicketNo);
		
		Path wiki_path = Paths.get("C:\\Projects\\TRT\\TSPSCPGT16_test","subjects.csv");
		final List<String> allLines=Files.readAllLines(wiki_path, Charset.defaultCharset());
		System.out.println(allLines.size());
		String subHallTicketNo= "'" + StringUtils.join(allLines.toArray(),"','") + "'";
		System.out.println(subHallTicketNo);
		
		
		
		
	}*/

}

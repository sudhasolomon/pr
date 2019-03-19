package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParentClass extends BaseDAOImpl {
	
	public PreparedStatement updateQuery(int chequeMonth, int chequeYear,
			ResultSet rs) throws SQLException {
		PreparedStatement pstmt;
		String updateQry = "update gpf_monthly_ledger_details set "
				+ " opening_balance = ?, closing_balance = ?, loan_ob = ?, loan_cb=?, "
				+ " interest = ?,financial_year = ?"
				+ " where cheque_month=? and cheque_year = ? and gpf_no = ?";
		
		 pstmt = getJdbcTemplate().getDataSource().getConnection().prepareStatement(updateQry);
		
		pstmt.setDouble(1, Double.parseDouble(rs.getString("ob")));
		pstmt.setDouble(2, Double.parseDouble(rs.getString("cb")));
		pstmt.setDouble(3, Double.parseDouble(rs.getString("loanob")));
		pstmt.setDouble(4, Double.parseDouble(rs.getString("loancb")));
		pstmt.setDouble(5, Double.parseDouble(rs.getString("intamount")));
		pstmt.setString(6, rs.getString("fy"));
		pstmt.setInt(7, chequeMonth);
		pstmt.setInt(8, chequeYear);
		pstmt.setString(9, rs.getString("gpfno"));
		pstmt.addBatch();
		return pstmt;
	}


}

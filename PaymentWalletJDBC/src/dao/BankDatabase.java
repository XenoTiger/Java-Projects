package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import bean.BankDetails;
import bean.CustomerDetails;
import util.jdbcConnection;

public class BankDatabase {
	static Map<Integer, BankDetails> map = new HashMap<Integer, BankDetails>();
	static BankDetails b;
	static CustomerDetails c = new CustomerDetails();;

	public void storeBankDetailsDb(BankDetails b) {

		Connection conn = null;
		try {
			conn = (Connection) jdbcConnection.getConnection();
			String sql = "insert into CUSTOMER values(?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getC().getCustName());
			pstmt.setLong(2, b.getC().getMobileNo());
			pstmt.setString(3, b.getC().getEmailId());
			pstmt.setString(4, b.getC().getAccType());
			pstmt.setDouble(5, b.getAccNo());
			pstmt.setDouble(6, b.getBalance());
			pstmt.executeUpdate();
			System.out.println("Added into Database");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public double getBankDetailsDb(int i) {

		double balance = 0;
		Connection conn = null;
		try {
			conn = (Connection) jdbcConnection.getConnection();
			String querry = "select BALANCE from CUSTOMER where ACC_No =?";
			PreparedStatement pstmt = conn.prepareStatement(querry);
			pstmt.setDouble(1, i);
			ResultSet rs = pstmt.executeQuery();
			// CustomerDetails cd=null;
			while (rs.next()) {
				balance = rs.getDouble(1);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return balance;
	}

}

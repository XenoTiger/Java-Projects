package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bean.BankDetails;

import dao.BankDatabase;

import util.jdbcConnection;

public class BankService implements BankServiceIntf {

	BankDatabase bd = new BankDatabase();

	@Override
	public void storeDetails(BankDetails b) {
		// TODO Auto-generated method stub
		bd.storeBankDetailsDb(b);

	}

	@Override
	public double getDetails(int accNo) {
		// TODO Auto-generated method stub
		return bd.getBankDetailsDb(accNo);

	}

	@Override
	public void addBalance(int accNo, double balance) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = (Connection) jdbcConnection.getConnection();
			String querry = "update CUSTOMER SET BALANCE=? where ACC_No =?";
			PreparedStatement pstmt = conn.prepareStatement(querry);
			double amt = bd.getBankDetailsDb(accNo);
			balance = balance + amt;
			pstmt.setDouble(1, balance);
			pstmt.setInt(2, accNo);
			pstmt.executeUpdate();

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

	@Override
	public void deductBalance(int accNo, double balance) {
		// TODO Auto-generated method stub
		double amt = bd.getBankDetailsDb(accNo);
		if (amt < balance) {
			System.out.println("Insufficient Balance");
		} else {

			Connection conn = null;
			try {
				conn = (Connection) jdbcConnection.getConnection();
				String querry = "update CUSTOMER SET BALANCE=? where ACC_No =?";
				PreparedStatement pstmt = conn.prepareStatement(querry);

				balance = Math.abs(balance - amt);
				pstmt.setDouble(1, balance);
				pstmt.setInt(2, accNo);
				pstmt.executeUpdate();

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

	}

	@Override
	public void tranferAmount(int accNo1, int accNo2, double balance) {

		deductBalance(accNo1, balance);
		addBalance(accNo2, balance);

	}

}

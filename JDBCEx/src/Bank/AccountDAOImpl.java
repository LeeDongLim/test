package Bank;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC 드라이버 로드 실패!");
		}
		return conn;
	}
	
	@Override
	public List<AccountVO> getList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//	데이터 전송을 위한 리스트
		List<AccountVO> list = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT seq_id, account_seposit, " +
				"account_withdraw FROM account";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				AccountVO accountVO = new AccountVO(
						rs.getLong(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						);
				list.add(accountVO);
			}
		} catch (SQLException e) {
			System.err.println("ERROR:" + e.getMessage());
		}
		
		return list;
	}

	@Override
	public AccountVO get(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		AccountVO accountVO = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT seq_id, " +
					"account_deposit, account_withdraw " +
					"FROM account " +
					"WHERE seq_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id); // 바인딩
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				accountVO = new AccountVO(
						rs.getLong(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						);
			}
		} catch (SQLException e) {
			System.err.println("ERROR:" + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.err.println("ERROR:" + e.getMessage());
			}
		}
		return accountVO;
	}

	@Override
	public boolean insert(AccountVO accountVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO account " +
					"VALUES(SEQ_SEQ_ID.NEXTVAL, " +
					"?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountVO.getDeposit());
			pstmt.setString(2, accountVO.getWithdraw());
			pstmt.setString(3, accountVO.getBalance());
			pstmt.setString(4, accountVO.gettrDate());
			
			insertedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("ERROR:" + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.err.println("ERROR:" + e.getMessage());
			}
		}
		return insertedCount == 1;
	}

	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM account WHERE seq_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			deletedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("ERROR:" + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.err.println("ERROR:" + e.getMessage());
			}
		}
		return deletedCount == 1;
	}

	@Override
	public boolean update(AccountVO accountVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updatedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "UPDATE ACCOUNT SET " +
					"account_deposit=?, account_withdraw=? " +
					"WHERE seq_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountVO.getDeposit());
			pstmt.setString(2, accountVO.getWithdraw());
			pstmt.setLong(3, accountVO.getSeqId());
			
			updatedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("ERROR:" + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.err.println("ERROR:" + e.getMessage());
			}
		}
		return 1 == updatedCount;
	}

  @Override
  public List<AccountInfoVO> getList(String text) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    //  데이터 전송을 위한 리스트
    List<AccountInfoVO> list = new ArrayList<>();
    
    try {
      conn = getConnection();
      
      String sql = 
          " SELECT a.seq_id, \r\n" + 
          "        a.seposit, \r\n" + 
          "        a.withdraw, \r\n" + 
          "        to_char( a.tr_date,'YYYY-MM-DD'), \r\n" + 
          "        a.balance\r\n" + 
          " FROM account a\r\n" + 
          " where a.account_id =                \r\n" + 
          " and (b.         || b.      || a.blance) LIKE '%'|| ? ||'%' ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, text); // 바인딩
      rs = pstmt.executeQuery();
      
      while(rs.next()) {
        AccountInfoVO accountInfoVO = new AccountInfoVO(
            rs.getLong(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5)
            );
        list.add(accountInfoVO);
      }
    } catch (SQLException e) {
      System.err.println("ERROR:" + e.getMessage());
    }
    
    return list;
  }

}

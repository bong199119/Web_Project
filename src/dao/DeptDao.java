package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.DeptDto;
import util.ConnLocator;

public class DeptDao {
	private static DeptDao single;
	private DeptDao() {
	}

	public static DeptDao getInstance() {
		if (single == null) {
			single = new DeptDao();
		}
		return single;

	}

	public ArrayList<DeptDto> select(int start, int len) {
		ArrayList<DeptDto> list = new ArrayList<DeptDto>();
		//?ìú?ùº?ù¥Î≤ÑÎ°ú?ìúÍ∞? ?ïÑ?öî?óÜ?ã§
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 2. ?ç∞?ù¥?Ñ∞ Î≤†Ïù¥?ä§?? ?ó∞Í≤?
			con = ConnLocator.getConnection();
			
			//3. PreParedStatement Í∞ùÏ≤¥Î•? ?Éù?Ñ±
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT deptno, dname, loc ");
			sql.append("FROM dept ");
			sql.append("ORDER BY deptno ASC ");
			sql.append("LIMIT ?,? ");

			pstmt = con.prepareStatement(sql.toString());
			
			
			//4. Î∞îÏù∏?î© Î≥??àòÎ•? ?Ñ§?†ï?ïú?ã§.
			int index = 0;
			pstmt.setInt(++index, start);
			pstmt.setInt(++index, len);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				index = 0;
				int no = rs.getInt(++index);
				String name = rs.getString(++index);
				String loc = rs.getString(++index);
				list.add(new DeptDto(no, name, loc));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {

			}
		}
		return list;

	}

	public int getTotalRows() {

		int rows = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ConnLocator.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT COUNT(deptno) ");
			sql.append("FROM dept ");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			int index = 0;
			if (rs.next()) {
				rows = rs.getInt(++index);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {

			}
		}

		return rows;
	}
	
	
	
	public boolean insert(DeptDto dto){
		boolean isSuccess = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO dept(deptno,dname, loc) ");
			sql.append("VALUES ( ?,?,?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setInt(++index, dto.getNo());
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getLoc());
			
			pstmt.executeUpdate();
			
			isSuccess = true;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {

			}
		}
		
		return isSuccess;
		
	}
	
	
	
	public DeptDto select(int no) {
		DeptDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT deptno, dname, loc ");
			sql.append("FROM dept ");
			sql.append("WHERE deptno = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;

			pstmt.setInt(++index, no);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				index = 0;
				no = rs.getInt(++index);
				String name = rs.getString(++index);
				String loc = rs.getString(++index);
				dto = new DeptDto(no, name, loc);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {

			}
		}
		return dto;

	}
	
	
	public boolean update(DeptDto dto) {
		
		boolean isSuccess = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE dept ");
			sql.append("SET dname = ?, loc = ? ");
			sql.append("WHERE deptno = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index = 0;
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getLoc());
			pstmt.setInt(++index, dto.getNo());
			
			
			pstmt.executeUpdate();
			isSuccess = true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();

			} catch (SQLException e) {

			}
		}
		
		return isSuccess;
	
	}
	
	public boolean delete(int no) {
		
		boolean isSuccess = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM dept WHERE deptno = ? ");
	
			pstmt = con.prepareStatement(sql.toString());
			
			int index =0;
			pstmt.setInt(++index, no);
			
			pstmt.executeUpdate();
			
			isSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();

			} catch (SQLException e) {

			}
		}
		return isSuccess;		
		
	}
	
	
	
	
	
	
}

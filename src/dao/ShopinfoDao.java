package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.ShopinfoDto;
import util.ConnLocator;

public class ShopinfoDao {
	private static ShopinfoDao single;
	private ShopinfoDao() {
		
	}
	
	public static ShopinfoDao getInstance() {
		if(single == null) {
			single = new ShopinfoDao();
			
		}
		return single;
	}
	
	
	public ShopinfoDto select(String sname) {
		ShopinfoDto dto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT sname, opertime, loc, menu, thumb, phone ");
			sql.append("FROM shopinfo ");
			sql.append("WHERE sname = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;

			pstmt.setString(++index, sname);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				index = 0;
				String name= rs.getString(++index);
				String opertime = rs.getString(++index);
				String loc = rs.getString(++index);
				String menu = rs.getString(++index);
				String thumb = rs.getString(++index);
				String phone = rs.getString(++index);
				dto = new ShopinfoDto(name, opertime, loc, menu, thumb, phone );

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
	
		
	
}




























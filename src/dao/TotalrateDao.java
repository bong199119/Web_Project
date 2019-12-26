package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.TotalrateDto;
import util.ConnLocator;

public class TotalrateDao {
		private static TotalrateDao single;
		private TotalrateDao() {
			
		}
		public static TotalrateDao getInstance() {
			if(single ==null) {
				single = new TotalrateDao();
			}
			return single;
		}
		
		public TotalrateDto select(String sname) {
			TotalrateDto dto = null;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = ConnLocator.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT sname, mood, light, price, taste ");
				sql.append("FROM totalrate ");
				sql.append("WHERE sname = ? ");
				
				pstmt = con.prepareStatement(sql.toString());
				int index = 0;

				pstmt.setString(++index, sname);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					index = 0;
					String name= rs.getString(++index);
					double mood = rs.getDouble(++index);
					double light = rs.getDouble(++index);
					double price = rs.getDouble(++index);
					double taste = rs.getDouble(++index);
					dto = new TotalrateDto(name, mood, light, price, taste );

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

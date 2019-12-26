package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.CommentDto;
import util.ConnLocator;

public class CommentDao {
	private static CommentDao single;
	private CommentDao () {
		
	}
	
	public static CommentDao getInstance() {
		if(single == null) {
			single = new CommentDao();
		}
		return single;
	}
	
	public ArrayList<CommentDto> select(String sname) {
		ArrayList<CommentDto> list = new ArrayList<CommentDto>(); 
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT id, comm ");
			sql.append("FROM  "+sname);
			
			pstmt = con.prepareStatement(sql.toString());
			
			
			int index = 0;
			//pstmt.setString(++index, sname);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				index = 0;
				String id = rs.getString(++index);
				String comm = rs.getString(++index);
				list.add(new CommentDto(id, comm));

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
	
}

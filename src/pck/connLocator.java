package pck;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class connLocator {
//?��?�� ?��기서 커넥?�� 불러?��겠다...
	
	public static Connection getConnection() throws SQLException{
		DataSource ds = null;
		Connection con = null;
		
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/acorn");
			//커넥?�� ?? �??��?���?
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} 
		
		return con;
	}
}

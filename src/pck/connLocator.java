package pck;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class connLocator {
//?ù¥?†ú ?ó¨Í∏∞ÏÑú Ïª§ÎÑ•?Öò Î∂àÎü¨?ò§Í≤†Îã§...
	
	public static Connection getConnection() throws SQLException{
		DataSource ds = null;
		Connection con = null;
		
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/acorn");
			//Ïª§ÎÑ•?Öò ?? Í∞??†∏?ò§Í∏?
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} 
		
		return con;
	}
}

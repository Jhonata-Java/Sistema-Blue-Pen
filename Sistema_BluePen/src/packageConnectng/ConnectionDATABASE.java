package packageConnectng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDATABASE {
	private final static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String URL = "jdbc:sqlserver://localhost:51521;encrypt=false;databaseName=BluePen";
	private final static String User = "sa";
	private final static String password = "Senailab05";
	
	public static Connection getConnection() {
		try {
			Class.forName(Driver);
			System.out.println("Conexão Estabelecida");
			return DriverManager.getConnection(URL, User, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro de Conexão!", e);
		}
	}
	public static void closeConnection(Connection con) {
		try {
			if(con != null){
				con.close();
				System.out.println("Conexão Fechada!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con,stmt);
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

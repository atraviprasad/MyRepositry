package firstpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloWorld {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/EMP";

	   //  Database credentials
	  // static final String USER = "username";
	   //static final String PASS = "password";;
	   
	public static void main(String[] args) throws ClassNotFoundException {
		 Connection conn = null;
		 
	        try {
	 
	            String dbURL = "jdbc:sqlserver://localhost;databaseName=Customer;integratedSecurity=true";
	            //String user = "";
	            //String pass = "";
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            conn = DriverManager.getConnection(dbURL);
	            Statement stmt=conn.createStatement();
	            String query="Select * from cust";
	            ResultSet rs=stmt.executeQuery(query);
	            while(rs.next()){
	            	System.out.println("CustId "+rs.getInt(1));
	            	System.out.println("First Name "+rs.getString(2));
	            	System.out.println("Last Name "+rs.getString(3));
	            	System.out.println("Country "+rs.getString(4));
	            	System.out.println("Age "+rs.getString(5));
	            }
	            rs.close();
	            stmt.close();
	            conn.close();
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (conn != null && !conn.isClosed()) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	}

}

package backend;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionInstance {
	
	private ConfigEnvDatabase ENV;
	private Connection conn;
	
	public ConnectionInstance() {
		ConfigEnvDatabase initENV = new ConfigEnvDatabase();
		this.ENV = initENV;
	}
	
	/*
	 * Server Code: 
	 * 1 => SV1
	 * 2 => SV2
	 * 3 => SV3
	 */
	
	public Connection prepareServerInstance(int serverCode) {
		switch (serverCode) {
			case 1:
				System.out.println("Entering Database Server 1");
				ENV.setINSTANCE_NAME("DESKTOP-73DQM32\\MSSQLSERVER1;");
				ENV.setDATABASE_NAME("HOCBA;");
				ENV.setUSER_NAME("sa");
				ENV.setPASSWORD("123123");
				break;
			case 2:
				System.out.println("Entering Database Server 2");
				 ENV.setINSTANCE_NAME("DESKTOP-73DQM32\\MSSQLSERVER2;");
				 ENV.setDATABASE_NAME("HOCBA_SV2;");
				 ENV.setUSER_NAME("sa");
				 ENV.setPASSWORD("123123");
				 break;
			case 3:
				System.out.println("Entering Database Server 3");
				ENV.setINSTANCE_NAME("DESKTOP-73DQM32\\MSSQLSERVER3;");
				ENV.setDATABASE_NAME("HOCBA_SV3_REP;");
				ENV.setUSER_NAME("sa");
				ENV.setPASSWORD("123123");
				break;
			default:
				System.out.println("Entering Database Server Unknown");
				ENV.setINSTANCE_NAME("DESKTOP-73DQM32;");
				ENV.setDATABASE_NAME("");
				ENV.setUSER_NAME("sa");
				ENV.setPASSWORD("123123");
				break;
		}
        conn = getConnection(ENV.getDB_SQL_URL(), ENV.getUSER_NAME(), ENV.getPASSWORD());
		return conn;		
	}
	
	public Connection getConnectionInstance() {
        conn = getConnection(ENV.getDB_SQL_URL(), ENV.getUSER_NAME(), ENV.getPASSWORD());
		return conn;
	}
 
    
    /*
     * Override getConnect method for debug connection.
     */
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.err.println("");
            System.out.println("Connect to SQLServer successfully!");
        } catch (Exception ex) {
            System.err.println("");
            System.err.println("Connect failure! Check again.");
            ex.printStackTrace();
        }
        return conn;
    }
}

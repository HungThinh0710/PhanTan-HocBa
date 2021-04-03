package backend;

public class ConfigEnvDatabase {
	private String INSTANCE_NAME;
	private String DATABASE_NAME;
	private String DB_SQL_URL;
	private String USER_NAME;
	private String PASSWORD;
    
	public ConfigEnvDatabase() {
		INSTANCE_NAME = null;
		DATABASE_NAME = null;
		DB_SQL_URL = null;
		USER_NAME = null;
		PASSWORD = null;
	}
	
	public String getINSTANCE_NAME() {
		return INSTANCE_NAME;
	}
	public void setINSTANCE_NAME(String iNSTANCE_NAME) {
		INSTANCE_NAME = iNSTANCE_NAME;
	}
	public String getDATABASE_NAME() {
		return DATABASE_NAME;
	}
	public void setDATABASE_NAME(String dATABASE_NAME) {
		DATABASE_NAME = dATABASE_NAME;
	}
	public String getDB_SQL_URL() {
		return "jdbc:sqlserver://"+ INSTANCE_NAME +"databaseName="+ DATABASE_NAME +"integratedSecurity=true";
	}
	public void setDB_SQL_URL(String dB_SQL_URL) {
		DB_SQL_URL = dB_SQL_URL;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
    
    
}

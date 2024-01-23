/***********************************************************************
 * Module:  DBConfiguration.java
 * Author:  Notebook
 * Purpose: Defines the Class DBConfiguration
 ***********************************************************************/

package model.databaseAccess;

public class DBConfiguration {

	private String address;
	private String fullAddress;
	private String dbName;
	private String driver;
	private String port;
	private String url;
	private String user;
	private String password;
	private DbType dbType;

	public void setAddress(String address) {
		this.address = address;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDbType(DbType dbType) {
		this.dbType = dbType;
	}

	public String getAddress() {
		return address;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public String getDbName() {
		return dbName;
	}

	public String getPort() {
		return port;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public DbType getDbType() {
		return dbType;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	public DBConfiguration() {
	}

	public DBConfiguration(String address, String dbName, String port, String user, String password, DbType dbType) {
		this.address = address.trim();
		this.dbName = dbName.trim();
		this.port = port;
		this.user = user.trim();
		this.password = password.trim();
		this.dbType = dbType;
	}
}
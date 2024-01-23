
package model;

public class UserModel {
	private DbResultSet resultSet;
	private String oznakaDrzave;
	private String oznakaPS;
	private String userId;
	private String forename;
	private String surname;
	private String role;
	//TODO: jos polja???
	public UserModel(DbResultSet resultSet, String oznakaDrzave, String oznakaPS, String userId, String forename,
					 String surname, String role) {
		this.resultSet = resultSet;
		this.oznakaDrzave = oznakaDrzave;
		this.oznakaPS = oznakaPS;
		this.userId = userId;
		this.forename = forename;
		this.surname = surname;
		this.role = role;
	}

	public DbResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(DbResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public String getOznakaDrzave() {
		return oznakaDrzave;
	}

	public void setOznakaDrzave(String oznakaDrzave) {
		this.oznakaDrzave = oznakaDrzave;
	}

	public String getOznakaPS() {
		return oznakaPS;
	}

	public void setOznakaPS(String oznakaPS) {
		this.oznakaPS = oznakaPS;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
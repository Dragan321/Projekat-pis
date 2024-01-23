package model.command.applicationCommands;

import model.ApplicationModel;
import model.DbResultSet;
import model.UserModel;
import model.XMLModel;
import model.command.OperationCommand;
import model.databaseModel.TableModel;

import java.sql.SQLException;

public class LoginCommand extends OperationCommand {
	private String username;
	private String password;

	public LoginCommand(ApplicationModel applicationModel, String username, String password) {
		super(applicationModel);
		this.username = username;
		this.password = password;
	}

	@Override
	public void execute() {
		// naci korisnika sa tim kredencijalima i upisati u user model
		// Vector<DataModel> db = super.getApplication().getDataModel();
		// Iz xml modela dohvatiti crud

		XMLModel xmlModel = super.getApplication().getDataModel().getXmlModel();
		TableModel table = (TableModel) xmlModel.getElementsByTableName("Korisnički nalog");
		//TODO: popravi login
		DbResultSet dbResultSet = new DbResultSet(xmlModel.getDbConfiguration(), table.getCrudOperation());
		dbResultSet.login(new String[] { "username", "password" }, new String[] { username, password });

		// dbResultSet.getRs();
		// Procitati ime i prezime i rolu user-a

		try {
			if (dbResultSet.getRs().next()) {
				UserModel userModel = new UserModel(dbResultSet, dbResultSet.getRs().getString("Drž_Oznaka"),
						dbResultSet.getRs().getString("Poslovni sistem"),
						dbResultSet.getRs().getString("User ID"),
						dbResultSet.getRs().getString("Ime"), dbResultSet.getRs().getString("Prezime"), null);
				super.getApplication().setUserModel(userModel);
				
				
				TableModel tableProizvod = (TableModel) xmlModel.getElementsByTableName("Proizvod");
				super.getApplication().getDataModel().setResultSet(new DbResultSet(xmlModel.getDbConfiguration(), tableProizvod.getCrudOperation(), "Proizvod"));
				super.getApplication().getDataModel().getResultSet().retrieveAll();
			}

			//catch  | UnknownHostException
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(dbResultSet.getRs());
	}

}

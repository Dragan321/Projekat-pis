package model.databaseModel;

import java.util.Vector;

public class TableModel extends TreeElement {
	private Vector<TableModel> reference = new Vector<>();

	private CRUDOperationModel crudOperation = null;

	public TableModel() {
	}

	public void addReferenca(TableModel referenca) {
		reference.add(referenca);
	}

	public Vector<TableModel> getAllReference() {
		return this.reference;
	}

	public TableModel getRefTabelaAt(int indeks) {
		return reference.elementAt(indeks);
	}

	public CRUDOperationModel getCrudOperation() {
		return crudOperation;
	}

	public void setCrudOperation(CRUDOperationModel crudOperation) {
		this.crudOperation = crudOperation;
	}

}
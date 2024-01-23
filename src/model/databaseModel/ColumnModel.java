package model.databaseModel;

public class ColumnModel extends TreeElement {
	private Boolean nullable = false;
	private Boolean primary = false;

	public ColumnModel() {
	}

	public Boolean isNullable() {
		return nullable;
	}

	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
	}

	public Boolean isPrimary() {
		return primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

}
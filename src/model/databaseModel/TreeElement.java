package model.databaseModel;

import java.util.Vector;

public abstract class TreeElement {
	protected String kod = null;
	protected String naziv = null;

	private Vector<TreeElement> elementiStabla = new Vector<>();

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Vector<TreeElement> getElementiStabla() {
		return elementiStabla;
	}

	public void setElementiStabla(Vector<TreeElement> elementiStabla) {
		this.elementiStabla = elementiStabla;
	}

	@Override
	public String toString() {
		return this.naziv;
	}

	public int getIndeksOfElement(TreeElement el) {
		return elementiStabla.indexOf(el);
	}

	public void addElement(TreeElement element) {
		elementiStabla.add(element);
	}

	public Vector<TreeElement> getAllElemente() {
		return this.elementiStabla;
	}

	public TreeElement getElementAt(int indeks) {
		return elementiStabla.elementAt(indeks);
	}
}
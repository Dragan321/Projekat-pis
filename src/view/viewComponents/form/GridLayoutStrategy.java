package view.viewComponents.form;

import java.awt.*;

public class GridLayoutStrategy extends LayoutStrategy{

	public GridLayoutStrategy(int rows, int cols, int xgap, int ygap) {
		this.layoutManager =  new GridLayout(rows, cols, xgap, ygap);
	}

}

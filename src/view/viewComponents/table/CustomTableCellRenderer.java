package view.viewComponents.table;

import view.viewComponents.Utils.UIUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Renderer zaduzen za iscrtavanje komponente tabela.
 */
public class CustomTableCellRenderer extends DefaultTableCellRenderer
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{	
		 JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		l.setOpaque(true);
		l.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
		l.setBackground(Color.red);
		l.setIcon(null);
		l.setToolTipText(null);
		
		Color foreground, background;
		
		if(isSelected)
		{
			foreground = UIUtils.OFFWHITE;
			background = UIUtils.COLOR_INTERACTIVE_DARKER;
		}
		else
		{
				foreground = UIUtils.OFFWHITE;
				background = UIUtils.COLOR_BACKGROUND;
		}
		
		l.setForeground(foreground);
		l.setBackground(background);
		
		//TODO: Postaviti sve klase koje ce se pojaviti i njihovo formatiranje
		if(value instanceof Integer & value != null)
		{
			l.setHorizontalAlignment(JLabel.RIGHT);
			l.setText(value.toString());
		}
		else if(value instanceof BigDecimal & value != null)
		{
			l.setHorizontalAlignment(JLabel.RIGHT);
			l.setText(value.toString());
		}
		else if(value instanceof Double & value != null)
		{
			l.setHorizontalAlignment(JLabel.RIGHT);
			l.setText(value.toString());
		}
		else if(value instanceof Float & value != null)
		{
			l.setHorizontalAlignment(JLabel.RIGHT);
			l.setText(value.toString());
		}
		else if(value instanceof Long & value != null)
		{
			l.setHorizontalAlignment(JLabel.RIGHT);
			l.setText(value.toString());
		}
		else if(value instanceof Date & value != null)
		{
			l.setHorizontalAlignment(JLabel.CENTER);
			l.setText(String.format("%1$td.%1$tm.%1$tY", (Date)value));
		}
		else if(value instanceof Boolean & value != null)
		{
			l.setHorizontalAlignment(JLabel.CENTER);
			Boolean b =((Boolean) value).booleanValue();
			l.setText("");
			if (b) 
			{
				l.setIcon(new ImageIcon("img/true.png"));
			}
			else 
			{
				l.setIcon(new ImageIcon("img/false.png"));
			}
		}
		else if(value instanceof String & value != null)
		{
			if (value.toString().length() > 32) 
			{
				l.setToolTipText(value.toString());
			}
	
			l.setHorizontalAlignment(JLabel.LEFT);
			l.setText(value.toString());
		}
		else
		{
			l.setText("");
		}
		
		
		
		return l;
	}

}

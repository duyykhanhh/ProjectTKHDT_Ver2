package view;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MultiLineTableCellRenderer extends DefaultTableCellRenderer {
 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        if (table.getRowHeight(row) != table.getRowHeight()) {
            table.setRowHeight(row, table.getRowHeight());
        }

        return rendererComponent;
    }
}

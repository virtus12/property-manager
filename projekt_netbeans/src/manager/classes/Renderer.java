/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.classes;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author virtus
 */
class Renderer implements TableCellRenderer
{
    public Component getTableCellRendererComponent(JTable table,Object value,
            boolean isSelected,boolean hasValue,int row,int column)
    {
        JTextArea ta=new JTextArea();
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setRows(3);
        ta.setText((String)value);
        return ta;
    }

    
}
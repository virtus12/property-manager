/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.view.estate.panel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import manager.classes.Picture;
import manager.controller.EstateController;
import manager.model.estate.EstateModel;
import manager.model.estate.EstateTableModel;
import manager.model.Model;
import manager.view.estate.EstateDialog;

/**
 *
 * @author virtus
 */
public class TablePanel extends javax.swing.JPanel implements Observer {

    private static final int ROW_HEIGHT = 100;
    private static final int PREFERRED_WIDTH = 150;

    private EstateTableModel ptm;
    private TableRowSorter<EstateTableModel> sorter;
    private final EstateController controller;
    private int currentSelectedRowIndex;

    public TablePanel() {
        controller = null;
        ptm = null;

    }

    /**
     * Creates new form FillterPanel
     *
     * @param controller
     */
    public TablePanel(EstateController controller) {
        this.controller = controller;
        initComponents();
        setupTable();
        setupListener();
    }

    private void setupTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        sorter = new TableRowSorter<>(ptm);
        sorter.setSortsOnUpdates(true);

        jtProperties.setRowHeight(ROW_HEIGHT);
        for (int i = 0; i < ptm.getColumnCount(); i++) {
            if (i != EstateTableModel.COLUMN_PICTURE) {
                jtProperties.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }
        jtProperties.getColumnModel().getColumn(EstateTableModel.COLUMN_PICTURE).setPreferredWidth(PREFERRED_WIDTH);
        jtProperties.removeColumn(jtProperties.getColumnModel().getColumn(EstateTableModel.COLUMN_ID));
        jtProperties.setRowSorter(sorter);

    }

    private void setupListener() {
        jtProperties.addKeyListener(new TableKeyAdapter());
        jtProperties.getSelectionModel().addListSelectionListener(new TableSelectionListener());

    }

    public void fillterByPriceOD(String s) {
        RowFilter<Object, Object> rf = new RowFilter<Object, Object>() {
            @Override
            public boolean include(RowFilter.Entry entry) {
                Double number = (double) entry.getValue(EstateTableModel.COLUMN_PRICE);
                return number >= Double.parseDouble(s);
            }
        };

        sorter.setRowFilter(rf);

    }

    public void fillterByPriceDo(String s) {
        RowFilter<Object, Object> rf = new RowFilter<Object, Object>() {
            @Override
            public boolean include(RowFilter.Entry entry) {
                Double number = (double) entry.getValue(EstateTableModel.COLUMN_PRICE);
                return number <= Double.parseDouble(s);
            }
        };

        sorter.setRowFilter(rf);
    }

    public void fillterBySurfaceOd(String s) {
        RowFilter<Object, Object> rf = new RowFilter<Object, Object>() {
            @Override
            public boolean include(RowFilter.Entry entry) {
                Double number = (double) entry.getValue(EstateTableModel.COLUMN_SURFACE);
                return number >= Double.parseDouble(s);
            }
        };

        sorter.setRowFilter(rf);
    }

    public void fillterBySurfaceDo(String s) {
        RowFilter<Object, Object> rf = new RowFilter<Object, Object>() {
            @Override
            public boolean include(RowFilter.Entry entry) {
                Double number = (double) entry.getValue(EstateTableModel.COLUMN_SURFACE);
                return number <= Double.parseDouble(s);
            }
        };

        sorter.setRowFilter(rf);
    }

    public void fillterByRooms(String s) {
        RowFilter<Object, Object> rf = new RowFilter<Object, Object>() {
            @Override
            public boolean include(RowFilter.Entry entry) {
                Integer number = (int) entry.getValue(EstateTableModel.COLUMN_ROOMS);
                return number <= Integer.parseInt(s);
            }
        };

        sorter.setRowFilter(rf);
    }

    public void fillterByTid(String s) {
        RowFilter<EstateTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(s, EstateTableModel.COLUMN_TID);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }

        sorter.setRowFilter(rf);

    }

    public void fillterByNid(String s) {
        RowFilter<EstateTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(s, EstateTableModel.COLUMN_NID);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }

        sorter.setRowFilter(rf);
    }

    public void fillterByCountry(String s) {
        RowFilter<EstateTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(s, EstateTableModel.COLUMN_COUNTRY);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }

        sorter.setRowFilter(rf);
    }

    public void fillterByProvince(String s) {
        RowFilter<EstateTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(s, EstateTableModel.COLUMN_PROVINCE);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }

        sorter.setRowFilter(rf);
    }

    public void fillterByCounty(String s) {
        RowFilter<EstateTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(s, EstateTableModel.COLUMN_COUNTY);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }

        sorter.setRowFilter(rf);
    }

    public void fillterByStreet(String s) {
        RowFilter<EstateTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(s, EstateTableModel.COLUMN_STREET);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }

        sorter.setRowFilter(rf);
    }

    private class TableKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            currentSelectedRowIndex = jtProperties.getSelectedRow();
            if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                int btCancel = JOptionPane.YES_NO_OPTION;
                int dialogResult;
                dialogResult = JOptionPane.showConfirmDialog(e.getComponent(), "Czy napewno chcesz usunac te nieruchomosc?", "Uwaga!", btCancel);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    if (currentSelectedRowIndex > -1) {
                        controller.removeEstate((int) jtProperties.getModel().getValueAt(currentSelectedRowIndex, 0));
                        jtProperties.getSelectionModel().clearSelection();
                        controller.getDialog().setView(false);
                        currentSelectedRowIndex = -1;
                    }
                }
            }
        }

    }

    private class TableSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            currentSelectedRowIndex = jtProperties.getSelectedRow();
            EstateDialog dialog = controller.getDialog();
            if (e.getValueIsAdjusting()) {
                if (currentSelectedRowIndex > -1) {
                    String name = (String) ptm.getValueAt(currentSelectedRowIndex, EstateTableModel.COLUMN_NAME);
                    dialog.setView(true);
                    dialog.setResourceName(name);
                }
            }
        }
    }

    public TableRowSorter getSorter() {
        return sorter;
    }
    
    public int getCurrentId(){
          return (int)ptm.getValueAt(currentSelectedRowIndex, EstateTableModel.COLUMN_ID);
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jscProperties = new javax.swing.JScrollPane();
        ptm = new EstateTableModel();
        jtProperties = new javax.swing.JTable();
        jsepProperties = new javax.swing.JSeparator();
        jlabProperties = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        setPreferredSize(new java.awt.Dimension(796, 800));

        jscProperties.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jscProperties.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jscProperties.setToolTipText("");
        jscProperties.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jscProperties.setAutoscrolls(true);
        jscProperties.setPreferredSize(new java.awt.Dimension(452, 800));

        jtProperties.setModel(ptm);
        jtProperties.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtProperties.setFillsViewportHeight(true);
        jtProperties.setPreferredSize(new java.awt.Dimension(300, 800));
        jscProperties.setViewportView(jtProperties);

        jlabProperties.setText("Nieruchomosci:");
        jlabProperties.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsepProperties)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabProperties, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jscProperties, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlabProperties)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsepProperties, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscProperties, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlabProperties;
    private javax.swing.JScrollPane jscProperties;
    private javax.swing.JSeparator jsepProperties;
    private javax.swing.JTable jtProperties;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        switch ((Model.Flag) arg) {
            case ADDED:
                controller.getDialog().getDialogInstance().dispose();
                List<Object> tmp = new ArrayList<>();
                tmp.add(controller.getGeneratedKey());
                tmp.add(ptm.getRowCount());
                tmp.add(new ImageIcon(Picture.loadImage(((EstateModel) o).getImg(), 150, 100)));
                tmp.add(((EstateModel) o).getName());
                tmp.add(((EstateModel) o).getDescription());
                tmp.add(((EstateModel) o).getNid());
                tmp.add(((EstateModel) o).getTid());
                tmp.add(((EstateModel) o).getCountry());
                tmp.add(((EstateModel) o).getProvince());
                tmp.add("");
                tmp.add(((EstateModel) o).getCounty());
                tmp.add(((EstateModel) o).getCity());
                tmp.add(((EstateModel) o).getRooms());
                tmp.add(((EstateModel) o).getPrice());
                tmp.add(((EstateModel) o).getSurface());
                tmp.add(((EstateModel) o).getName());
                ptm.addRow(tmp);
                sorter.allRowsChanged();
                ptm.fireTableDataChanged();
                ptm.updateTable();

                break;
            case REMOVED:
                ptm.removeRow(currentSelectedRowIndex);
                sorter.allRowsChanged();
                ptm.fireTableDataChanged();
                ptm.updateTable();

                break;

        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.view.estate.panel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import manager.controller.EstateController;

/**
 *
 * @author Damian Rakowski
 * 
 */
public class FillterPanel extends javax.swing.JPanel implements Observer {

    private final EstateController controller;
    private static final int SELECTED_FIRST = 0;

     /**
     * Tworzy nowy FillterPanel i ustawia konstruktor
     *
     */
    public FillterPanel() {
        controller = null;
        initComponents();
    }

    /**
     * Tworzy nowy FillterPanel i ustawia konstruktor
     *
     * @param controller
     */
    public FillterPanel(EstateController controller) {
        this.controller = controller;
        initComponents();
        setupListener();

    }
    
    /**
     * Ustawia nasluch zdarzen na komponenty
     *
     */
    private void setupListener() {

        jcbFTid.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String name1 = ((JComboBox) e.getSource()).getSelectedItem().toString();
                controller.getTablePanel().fillterByTid(name1);
            }
        });

        jcbFNid.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String name1 = ((JComboBox) e.getSource()).getSelectedItem().toString();
                controller.getTablePanel().fillterByNid(name1);
            }
        });

        jtfPriceDo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER
                        || e.getKeyCode() == KeyEvent.VK_BACK_SPACE
                        || e.getKeyCode() == KeyEvent.VK_DELETE) {

                    String name = ((JTextField) e.getSource()).getText();
                    if (!name.equals(" ") && isNumeric(name)) {
                        controller.getTablePanel().fillterByPriceDo(name);
                    } else {
                        controller.getTablePanel().getSorter().setRowFilter(null);
                    }
                }
            }

        });

        jtfPriceOd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER
                        || e.getKeyCode() == KeyEvent.VK_BACK_SPACE
                        || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    String name = ((JTextField) e.getSource()).getText();
                    if (!name.equals(" ") && isNumeric(name)) {
                        controller.getTablePanel().fillterByPriceDo(name);
                    } else {
                        controller.getTablePanel().getSorter().setRowFilter(null);
                    }
                }
            }

        });
        jtfSurfaceDo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER
                        || e.getKeyCode() == KeyEvent.VK_BACK_SPACE
                        || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    String name = ((JTextField) e.getSource()).getText();
                    if (!name.equals(" ") && isNumeric(name)) {
                        controller.getTablePanel().fillterBySurfaceDo(name);
                    } else {
                        controller.getTablePanel().getSorter().setRowFilter(null);
                    }
                }
            }
        });

        jtfSurfaceOd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER
                        || e.getKeyCode() == KeyEvent.VK_BACK_SPACE
                        || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    String name = ((JTextField) e.getSource()).getText();
                    if (!name.equals(" ") && isNumeric(name)) {
                        controller.getTablePanel().fillterBySurfaceOd(name);
                    } else {
                        controller.getTablePanel().getSorter().setRowFilter(null);
                    }

                }
            }

        });

        jtfRoomsDo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER
                        || e.getKeyCode() == KeyEvent.VK_BACK_SPACE
                        || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    String name = ((JTextField) e.getSource()).getText();
                    if (!name.equals(" ") && isNumeric(name)) {
                        controller.getTablePanel().fillterByRooms(name);
                    } else {
                        controller.getTablePanel().getSorter().setRowFilter(null);
                    }
                }
            }

        });
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlabFillters = new javax.swing.JLabel();
        jsepFillters = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jcbFNid = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbFTid = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfSurfaceDo = new javax.swing.JTextField();
        jtfPriceDo = new javax.swing.JTextField();
        jtfPriceOd = new javax.swing.JTextField();
        jtfSurfaceOd = new javax.swing.JTextField();
        jtfRoomsDo = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        setAutoscrolls(true);

        jlabFillters.setText("Filtry:");

        jLabel1.setText("Typ nieruchomosci:");

        jcbFNid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Apartament", "Mieszkanie", "Biuro", "Dzialka", "Dom", "inne" }));

        jLabel3.setText("Od:");

        jLabel2.setText("Cena:");

        jLabel4.setText("Do:");

        jLabel5.setText("Typ transkacji:");

        jcbFTid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Sprzedaz", "Wynajem" }));

        jLabel6.setText("Powierzchnia:");

        jLabel7.setText("Od:");

        jLabel8.setText("Do:");

        jLabel9.setText("Licz.pokoi(do):");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsepFillters)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabFillters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbFNid, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbFTid, 0, 34, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jtfPriceOd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfPriceDo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfSurfaceOd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfSurfaceDo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfRoomsDo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlabFillters)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsepFillters, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jcbFTid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jcbFNid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jtfPriceDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPriceOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jtfSurfaceOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSurfaceDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jtfRoomsDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jcbFNid;
    private javax.swing.JComboBox<String> jcbFTid;
    private javax.swing.JLabel jlabFillters;
    private javax.swing.JSeparator jsepFillters;
    private javax.swing.JTextField jtfPriceDo;
    private javax.swing.JTextField jtfPriceOd;
    private javax.swing.JTextField jtfRoomsDo;
    private javax.swing.JTextField jtfSurfaceDo;
    private javax.swing.JTextField jtfSurfaceOd;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        jcbFTid.setSelectedIndex(SELECTED_FIRST);
        jcbFNid.setSelectedIndex(SELECTED_FIRST);
    }

}

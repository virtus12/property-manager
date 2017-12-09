/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.model.estate;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import manager.classes.Picture;

/**
 * Klasa odpowiedzialna za pobranie nieruchomosci z bazy danych
 * i rozmieszczenie w tabeli.
 * 
 * @author Damian Rakowski
 * 
 * @see List
 * @see AbstractTableModel
 */
public class EstateTableModel extends AbstractTableModel{

    private static final long serialVersionUID = 1L;
    /**Tablica przchowujaca nazwy kolumn */
    private final String[] columnsName;
     /**Lista przchowujaca rekordy z bazy danych */
    private final List<List> estates;
    /**
     * Numery kolumn 
     */
    public static int COLUMN_ID = 0;
    public static int COLUMN_LP = 1;
    public static int COLUMN_PICTURE = 2;
    public static int COLUMN_NAME = 3;
    public static int COLUMN_DESC = 4;
    public static int COLUMN_NID = 5;
    public static int COLUMN_TID = 6;
    public static int COLUMN_COUNTRY = 7;
    public static int COLUMN_PROVINCE = 8;
    public static int COLUMN_COMMUNE = 9;
    public static int COLUMN_COUNTY = 10;
    public static int COLUMN_CITY  = 11;
    public static int COLUMN_STREET = 12;
    public static int COLUMN_ROOMS = 13;
    public static int COLUMN_PRICE = 14;
    public static int COLUMN_SURFACE = 15;

    /**
     * Domyslny konstuktor inicalizujacy liste oraz tablie z nazwami kolumn
     * i wypelniacy liste danymi. 
     */
    public EstateTableModel() {
        this.columnsName = new String[]{"id", "#", "Zdiecie:", "Nazwa:", "Opis:", "Typ nieruchomosci:", "Typ transkacji:", "Kraj:",
            "Wojewodztwo:", "Gmina:", "Powiat:", "Miasto:", "Ulica:", "Licz.Poki:", "Cena:", "Powierzchnia:"};
        estates = new ArrayList<>();
        loadData();

    }
    //------------------------------------------------
    @Override
    public int getRowCount() {
        return estates.size();

    }
    //------------------------------------------------
    @Override
    public int getColumnCount() {
        return columnsName.length;
    }
    //------------------------------------------------
    @Override
    public String getColumnName(int column) {
        return columnsName[column];
    }
    //------------------------------------------------
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return estates.get(rowIndex).get(columnIndex);

    }
    //------------------------------------------------

    @Override
    public void setValueAt(Object value, int row, int col) {
        estates.get(row).set(col, value);
        this.fireTableRowsUpdated(row, col);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 1;
    }
    //------------------------------------------------
    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case 2:
                return Icon.class;
            default:
                return Object.class;
        }
    }
    /**
     * Metoda wypelniajaca liste danymi z bazy danych
     * 
     */
    private void loadData() {
        List<Object> tmp;
        Estate pi = new Estate();
        int currentIndex = 0;
 

        for (EstateModel pr : pi.getAllEstates()) {
            tmp = new ArrayList<>();
            currentIndex++;
            tmp = new ArrayList<>();
            tmp.add(pr.getId());
            tmp.add(currentIndex);
            tmp.add(new ImageIcon(Picture.loadImage(pr.getImg(), 150, 100)));
            tmp.add(pr.getName());
            tmp.add(pr.getDescription());
            tmp.add(pr.getNid());
            tmp.add(pr.getTid());
            tmp.add(pr.getCountry());
            tmp.add(pr.getProvince());
            tmp.add(pr.getCounty());
            tmp.add("");
            tmp.add(pr.getCity());
            tmp.add(pr.getStreet());
            tmp.add(pr.getRooms());
            tmp.add(pr.getPrice());
            tmp.add(pr.getSurface());

            estates.add(tmp);
        }

    }
 
    /**
     * Metoda czysci liste i wypelnia liste
     * 
     */
    public void updateTable() {
        estates.clear();
        loadData();
    }
  
    /**
     * Metoda dodajaca wiersz do tablicy
     * 
     * @param estate
     */
    public void addRow(List estate) {
        estates.add(estate);
        this.fireTableRowsInserted(estates.size(), estates.size());

    }
  /**
     * Metoda usuwajaca wiersz z tablicy
     * 
     * @param r
     */  
    public void removeRow(int r){
        estates.remove(estates.get(r));
        this.fireTableRowsDeleted(r, r);
      }
    
    @Override
    public void addTableModelListener(TableModelListener ml) {
    }

    @Override
    public void removeTableModelListener(TableModelListener arg0) {
    }

}

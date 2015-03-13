/*
 * 
 * DILARANG MENGHAPUS ATAU MENGEDIT COPYRIGHT INI.
 * 
 * Copyright 2008 echo.khannedy@gmail.com. 
 * All rights reserved.
 * 
 * Semua isi dalam file ini adalah hak milik dari echo.khannedy@gmail.com
 * Anda tak diperkenankan untuk menggunakan file atau mengubah file
 * ini kecuali anda tidak menghapus atau merubah lisence ini.
 * 
 * File ini dibuat menggunakan :
 * IDE        : NetBeans
 * NoteBook   : Acer Aspire 5920G
 * OS         : Windows Vista
 * Java       : Java 1.6
 * 
 */
package usu.buku.telepon.widget.table;

import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import usu.buku.telepon.data.template.Teman;

/**
 *
 * @author usu
 */
public class TableModelTeman extends AbstractTableModel {

    private static final long serialVersionUID = -1;
    private Vector<Teman> row;
    private Vector<String> column;

    /**
     * 
     */
    public TableModelTeman() {
        super();
        column = new Vector<String>();
        column.add("Nama");
        column.add("Telepon 1");
        column.add("Telepon 2");
        column.add("Telepon 3");
        column.add("Catatan");
        row = new Vector<Teman>();
    }

    public void add(List<Teman> get) {
        for (Teman t : get) {
            row.add(t);
        }
        fireTableDataChanged();
    }

    /**
     * 
     * @param index
     * @param element
     * @return
     */
    public synchronized Teman set(int index, Teman element) {
        Teman t = row.set(index, element);
        fireTableRowsUpdated(index, index);
        return t;
    }

    /**
     * 
     */
    public synchronized void removeAllElements() {
        row.removeAllElements();
        fireTableDataChanged();
    }

    /**
     * 
     * @param index
     * @return
     */
    public synchronized Teman remove(int index) {
        Teman t = row.remove(index);
        fireTableRowsDeleted(index, index);
        return t;
    }

    /**
     * 
     * @param index
     * @return
     */
    public synchronized Teman get(int index) {
        return row.get(index);
    }

    /**
     * 
     * @param e
     * @return
     */
    public synchronized boolean add(Teman e) {
        int index = row.size();
        boolean b = row.add(e);
        fireTableRowsInserted(index, index);
        return b;
    }

    @Override
    public String getColumnName(int column) {
        return this.column.get(column);
    }

    @Override
    public int getRowCount() {
        return row.size();
    }

    @Override
    public int getColumnCount() {
        return column.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return row.get(rowIndex).getNama();
        } else if (columnIndex == 1) {
            return row.get(rowIndex).getTelepon1();
        } else if (columnIndex == 2) {
            return row.get(rowIndex).getTelepon2();
        } else if (columnIndex == 3) {
            return row.get(rowIndex).getTelepon3();
        } else if (columnIndex == 4) {
            return row.get(rowIndex).getKeterangan();
        }
        return null;

    }
}

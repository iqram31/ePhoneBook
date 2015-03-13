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
package usu.buku.telepon.widget.worker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import usu.buku.telepon.data.template.Teman;
import usu.buku.telepon.sql.MySQL;
import usu.buku.telepon.widget.table.TableModelTeman;

/**
 *
 * @author usu
 */
public class WorkerTeman extends SwingWorker<List<Teman>, String> {

    private TableModelTeman tableModel;
    private ResultSet result;
    private Connection connection;
    private WorkerAction worker;

    /**
     * 
     * @param tableModel
     * @param connection
     * @param worker
     * @throws java.sql.SQLException
     */
    public WorkerTeman(Connection connection, TableModelTeman tableModel, WorkerAction worker) throws SQLException {
        this.tableModel = tableModel;
        this.connection = connection;
        result = MySQL.resultTeman(connection);
        this.worker = worker;
        this.tableModel.removeAllElements();
        this.worker.runFirst();
    }

    /**
     * 
     * @param connection
     * @param tableModel
     * @param worker
     * @param nama
     * @param telepon
     * @throws java.sql.SQLException
     */
    public WorkerTeman(Connection connection, TableModelTeman tableModel, WorkerAction worker, 
            String nama, String telepon) throws SQLException {
        this.tableModel = tableModel;
        this.connection = connection;
        result = MySQL.resultTeman(connection, nama, telepon);
        this.worker = worker;
        this.tableModel.removeAllElements();
        this.worker.runFirst();
    }

    @Override
    protected List<Teman> doInBackground() throws Exception {
        return MySQL.getListTeman(result);
    }

    @Override
    protected void done() {
        try {
            super.done();
            tableModel.add(get());
        } catch (InterruptedException ex) {
            Logger.getLogger(WorkerTeman.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(WorkerTeman.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            worker.runLast();
            try {
                result.close();
            } catch (SQLException ex) {
                Logger.getLogger(WorkerTeman.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

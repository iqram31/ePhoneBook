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
package usu.buku.telepon.exception;

/**
 *
 * @author usu
 */
public class DataNotCompleteException extends Exception {

    private static final long serialVersionUID = -1;

    /**
     * Creates a new instance of <code>DataNotCompleteException</code> without detail message.
     */
    public DataNotCompleteException() {
        super("data belum lengkap");
    }

    /**
     * Constructs an instance of <code>DataNotCompleteException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DataNotCompleteException(String msg) {
        super(msg);
    }
}

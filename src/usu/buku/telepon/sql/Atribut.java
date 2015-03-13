/*
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
 */
package usu.buku.telepon.sql;

/**
 * @author usu
 */
public interface Atribut {

   public interface TEMAN {

      static String ID_TEMAN = Entitas.TEMAN + ".ID_TEMAN";
      static String KETERANGAN = Entitas.TEMAN + ".KETERANGAN";
      static String NAMA_TEMAN = Entitas.TEMAN + ".NAMA_TEMAN";
      static String NO_TELEPON_1 = Entitas.TEMAN + ".NO_TELEPON_1";
      static String NO_TELEPON_2 = Entitas.TEMAN + ".NO_TELEPON_2";
      static String NO_TELEPON_3 = Entitas.TEMAN + ".NO_TELEPON_3";
   }
}

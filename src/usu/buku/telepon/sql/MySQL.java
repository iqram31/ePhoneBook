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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import usu.buku.telepon.data.DefaultTeman;
import usu.buku.telepon.data.template.Teman;

/**
 * @author usu
 */
public class MySQL {

   private static PreparedStatement prepare;

   /**
    * @param connection
    * @param idTeman
    * @throws java.sql.SQLException
    */
   public static void deleteTeman(final Connection connection, final int idTeman)
           throws SQLException {
      MySQL.prepare = connection.prepareStatement("DELETE FROM " + Entitas.TEMAN + " WHERE " + Atribut.TEMAN.ID_TEMAN + "=?");
      MySQL.prepare.setInt(1, idTeman);
      MySQL.prepare.executeUpdate();
      MySQL.prepare.close();
   }

   /**
    * @param result
    * @return
    * @throws java.sql.SQLException
    */
   public static List<Teman> getListTeman(final ResultSet result)
           throws SQLException {
      final ArrayList<Teman> list = new ArrayList<Teman>();
      while (result.next()) {
         final Teman data = new DefaultTeman();
         data.setId(result.getInt(Atribut.TEMAN.ID_TEMAN));
         data.setKeterangan(result.getString(Atribut.TEMAN.KETERANGAN));
         data.setNama(result.getString(Atribut.TEMAN.NAMA_TEMAN));
         data.setTelepon1(result.getString(Atribut.TEMAN.NO_TELEPON_1));
         data.setTelepon2(result.getString(Atribut.TEMAN.NO_TELEPON_2));
         data.setTelepon3(result.getString(Atribut.TEMAN.NO_TELEPON_3));
         list.add(data);
      }
      return list;
   }

   /**
    * @param connection
    * @param teman
    * @throws java.sql.SQLException
    */
   public static void insertTeman(final Connection connection, final Teman teman)
           throws SQLException {
      MySQL.prepare = connection.prepareStatement("INSERT INTO " + Entitas.TEMAN + " SET " + Atribut.TEMAN.ID_TEMAN + "=null," + Atribut.TEMAN.KETERANGAN + "=?," + Atribut.TEMAN.NAMA_TEMAN + "=?," + Atribut.TEMAN.NO_TELEPON_1 + "=?," + Atribut.TEMAN.NO_TELEPON_2 + "=?," + Atribut.TEMAN.NO_TELEPON_3 + "=?");
      MySQL.prepare.setString(1, teman.getKeterangan());
      MySQL.prepare.setString(2, teman.getNama());
      MySQL.prepare.setString(3, teman.getTelepon1());
      MySQL.prepare.setString(4, teman.getTelepon2());
      MySQL.prepare.setString(5, teman.getTelepon3());
      MySQL.prepare.executeUpdate();
      MySQL.prepare.close();
   }

   /**
    * @param connection
    * @return
    * @throws java.sql.SQLException
    */
   public static ResultSet resultTeman(final Connection connection)
           throws SQLException {
      MySQL.prepare = connection.prepareStatement("SELECT * FROM " + Entitas.TEMAN +
              " ORDER BY " + Atribut.TEMAN.NAMA_TEMAN);
      return MySQL.prepare.executeQuery();
   }

   /**
    * 
    * @param connection
    * @param nama
    * @param telepon
    * @return
    * @throws java.sql.SQLException
    */
   public static ResultSet resultTeman(final Connection connection, final String nama, final String telepon)
           throws SQLException {
      String SQL = "SELECT * FROM " + Entitas.TEMAN;
      if (nama != null || telepon != null) {
         SQL += " WHERE ";
      } else {
         return resultTeman(connection);
      }
      if (nama != null) {
         SQL += Atribut.TEMAN.NAMA_TEMAN + " LIKE ? ";
         if (telepon != null) {
            SQL += " AND ";
         }
      }
      if (telepon != null) {
         SQL += " ( ";
         SQL += Atribut.TEMAN.NO_TELEPON_1 + " LIKE ? ";
         SQL += " OR ";
         SQL += Atribut.TEMAN.NO_TELEPON_2 + " LIKE ? ";
         SQL += " OR ";
         SQL += Atribut.TEMAN.NO_TELEPON_3 + " LIKE ? ";
         SQL += " ) ";
      }
      SQL += " ORDER BY " + Atribut.TEMAN.NAMA_TEMAN;
      prepare = connection.prepareStatement(SQL);
      if (nama != null) {
         prepare.setString(1, "%" + nama + "%");
      }
      if (telepon != null) {
         prepare.setString(2, "%" + telepon + "%");
         prepare.setString(3, "%" + telepon + "%");
         prepare.setString(4, "%" + telepon + "%");
      }
      return prepare.executeQuery();
   }

   /**
    * @param connection
    * @param idTeman
    * @param teman
    * @throws java.sql.SQLException
    */
   public static void updateTeman(final Connection connection, final int idTeman, final Teman teman)
           throws SQLException {
      MySQL.prepare = connection.prepareStatement("UPDATE " + Entitas.TEMAN + " SET " + Atribut.TEMAN.KETERANGAN + "=?," + Atribut.TEMAN.NAMA_TEMAN + "=?," + Atribut.TEMAN.NO_TELEPON_1 + "=?," + Atribut.TEMAN.NO_TELEPON_2 + "=?," + Atribut.TEMAN.NO_TELEPON_3 + "=? WHERE " + Atribut.TEMAN.ID_TEMAN + "=?");
      MySQL.prepare.setString(1, teman.getKeterangan());
      MySQL.prepare.setString(2, teman.getNama());
      MySQL.prepare.setString(3, teman.getTelepon1());
      MySQL.prepare.setString(4, teman.getTelepon2());
      MySQL.prepare.setString(5, teman.getTelepon3());
      MySQL.prepare.setInt(6, idTeman);
      MySQL.prepare.executeUpdate();
      MySQL.prepare.close();
   }
}

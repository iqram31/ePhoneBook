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
package usu.buku.telepon;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import usu.buku.telepon.admin.AdminLogIn;
import usu.widget.util.WidgetUtilities;

/**
 *
 * @author usu
 */
public class MainProgram {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      WidgetUtilities.invokeLater(new Runnable() {

         @Override
         public void run() {
            try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException ex) {
               Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
               Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
               Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
               Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
               try {
                  new AdminLogIn().setVisible(true);
               } catch (IOException ex) {
                  WidgetUtilities.showErrorMessage(null, ex.getMessage());
               }
            }
         }
      });
   }
}

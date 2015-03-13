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
package usu.buku.telepon.data;

import usu.buku.telepon.data.template.Teman;

/**
 *
 * @author usu
 */
public class DefaultTeman implements Teman {

    private int id;
    private String nama;
    private String telepon1,  telepon2,  telepon3;
    private String keterangan;

    public DefaultTeman() {
    }

    public DefaultTeman(int id, String nama, String telepon1, String telepon2, String telepon3, String keterangan) {
        this.id = id;
        this.nama = nama;
        this.telepon1 = telepon1;
        this.telepon2 = telepon2;
        this.telepon3 = telepon3;
        this.keterangan = keterangan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon1() {
        return telepon1;
    }

    public void setTelepon1(String telepon1) {
        this.telepon1 = telepon1;
    }

    public String getTelepon2() {
        return telepon2;
    }

    public void setTelepon2(String telepon2) {
        this.telepon2 = telepon2;
    }

    public String getTelepon3() {
        return telepon3;
    }

    public void setTelepon3(String telepon3) {
        this.telepon3 = telepon3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DefaultTeman other = (DefaultTeman) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nama != other.nama && (this.nama == null || !this.nama.equals(other.nama))) {
            return false;
        }
        if (this.telepon1 != other.telepon1 && (this.telepon1 == null || !this.telepon1.equals(other.telepon1))) {
            return false;
        }
        if (this.telepon2 != other.telepon2 && (this.telepon2 == null || !this.telepon2.equals(other.telepon2))) {
            return false;
        }
        if (this.telepon3 != other.telepon3 && (this.telepon3 == null || !this.telepon3.equals(other.telepon3))) {
            return false;
        }
        if (this.keterangan != other.keterangan && (this.keterangan == null || !this.keterangan.equals(other.keterangan))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
        hash = 19 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        hash = 19 * hash + (this.telepon1 != null ? this.telepon1.hashCode() : 0);
        hash = 19 * hash + (this.telepon2 != null ? this.telepon2.hashCode() : 0);
        hash = 19 * hash + (this.telepon3 != null ? this.telepon3.hashCode() : 0);
        hash = 19 * hash + (this.keterangan != null ? this.keterangan.hashCode() : 0);
        return hash;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenruangmeeting;

/**
 *
 * @author WINDOWS 11 PRO
 */
public class Booking {
    String tanggal;
    String jam;
    String keperluan;
    Ruangan ruang;
    Pengguna pengguna;
 
    Booking(String tanggal, String jam, String keperluan, Ruangan ruang, Pengguna pengguna) {
        this.tanggal = tanggal;
        this.jam = jam;
        this.keperluan = keperluan;
        this.ruang = ruang;
        this.pengguna = pengguna;
    }
 
    void tampilkan(int no) {
        System.out.println(no + ". " + ruang.namaRuang + " | " + tanggal + " | " + jam
                + " | " + pengguna.nama + " | " + keperluan);
    }
}

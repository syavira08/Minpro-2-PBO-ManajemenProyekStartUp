/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenruangmeeting;

/**
 *
 * @author WINDOWS 11 PRO
 */
public abstract class Ruangan {
    String namaRuang;
    int kapasitas;
    String fasilitas;
 
    Ruangan(String namaRuang, int kapasitas, String fasilitas) {
        this.namaRuang = namaRuang;
        this.kapasitas = kapasitas;
        this.fasilitas = fasilitas;
    }
 
    abstract String jenisRuang();
 
    void tampilkan(int no) {
        System.out.println(no + ". " + namaRuang + " (" + jenisRuang() + ")"
                + " - Kapasitas: " + kapasitas + " orang"
                + " - Fasilitas: " + fasilitas);
    }
}

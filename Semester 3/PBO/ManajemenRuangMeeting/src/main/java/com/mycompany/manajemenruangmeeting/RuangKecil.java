/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenruangmeeting;

/**
 *
 * @author WINDOWS 11 PRO
 */
public class RuangKecil extends Ruangan {
    RuangKecil(String namaRuang, int kapasitas, String fasilitas) {
        super(namaRuang, kapasitas, fasilitas);
    }
 
    String jenisRuang() {
        return "Ruang Kecil";
    }
}

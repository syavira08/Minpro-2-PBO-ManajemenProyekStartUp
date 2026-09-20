/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenruangmeeting;

/**
 *
 * @author WINDOWS 11 PRO
 */
public class Pengguna {
    String nama;
    String departemen;
 
    Pengguna(String nama, String departemen) {
        this.nama = nama;
        this.departemen = departemen;
    }
 
    void tampilkan(int no) {
        System.out.println(no + ". " + nama + " - " + departemen);
    }
}

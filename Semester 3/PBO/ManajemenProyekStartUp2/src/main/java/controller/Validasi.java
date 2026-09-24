/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author WINDOWS 11 PRO
 */
public class Validasi {
 
    public static boolean isTeksValid(String teks) {
        if (teks == null) {
            return false;
        }
        if (teks.trim().length() == 0) {
            return false;
        }
        return true;
    }
 
    public static boolean isAngka(String teks) {
        if (!isTeksValid(teks)) {
            return false;
        }
        teks = teks.trim();
        for (int i = 0; i < teks.length(); i++) {
            char karakter = teks.charAt(i);
            if (karakter < '0' || karakter > '9') {
                return false;
            }
        }
        return true;
    }
 
    public static boolean isPilihanValid(String teks) {
        return isAngka(teks);
    }
 
    public static boolean isDeadlineValid(String teks) {
        if (!isTeksValid(teks)) {
            return false;
        }
 
        String[] bagian = teks.split("-");
        if (bagian.length != 3) {
            return false;
        }
 
        String tanggal = bagian[0];
        String bulan = bagian[1];
        String tahun = bagian[2];
 
        if (!isAngka(tanggal) || !isAngka(bulan) || !isAngka(tahun)) {
            return false;
        }
 
        if (tanggal.length() != 2 || bulan.length() != 2 || tahun.length() != 4) {
            return false;
        }
 
        int nilaiTanggal = Integer.parseInt(tanggal);
        int nilaiBulan = Integer.parseInt(bulan);
 
        if (nilaiTanggal < 1 || nilaiTanggal > 31) {
            return false;
        }
        if (nilaiBulan < 1 || nilaiBulan > 12) {
            return false;
        }
 
        return true;
    }
}   

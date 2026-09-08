/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author WINDOWS 11 PRO
 */
public class Proyek {
    private String idProjek;
    private String namaProjek;
    private String namaKlien;
    private String deadline;
 
    // Constructor
    public Proyek(String idProjek, String namaProjek, String namaKlien, String deadline) {
        this.idProjek = idProjek;
        this.namaProjek = namaProjek;
        this.namaKlien = namaKlien;
        this.deadline = deadline;
    }
 
    // Getter dan Setter
    public String getIdProjek() {
        return idProjek;
    }
 
    public void setIdProjek(String idProjek) {
        this.idProjek = idProjek;
    }
 
    public String getNamaProjek() {
        return namaProjek;
    }
 
    public void setNamaProjek(String namaProjek) {
        this.namaProjek = namaProjek;
    }
 
    public String getNamaKlien() {
        return namaKlien;
    }
 
    public void setNamaKlien(String namaKlien) {
        this.namaKlien = namaKlien;
    }
 
    public String getDeadline() {
        return deadline;
    }
 
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
 
    public void cetakData() {
        System.out.println("ID Proyek    : " + idProjek);
        System.out.println("Nama Proyek  : " + namaProjek);
        System.out.println("Nama Klien   : " + namaKlien);
        System.out.println("Deadline     : " + deadline);
    }
}


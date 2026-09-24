/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
 
import controller.Validasi;
 
/**
 *
 * @author WINDOWS 11 PRO
 */
public class Proyek {
    private String idProjek;
    private String namaProjek;
    private String deadline;
 
    public Proyek(String idProjek, String namaProjek, String deadline) {
        if (Validasi.isTeksValid(idProjek)) {
            this.idProjek = idProjek;
        } else {
            System.out.println("ID Proyek tidak valid!");
            this.idProjek = idProjek;
        }
        setNamaProjek(namaProjek);
        setDeadline(deadline);
    }
 
    public String getIdProjek() {
        return idProjek;
    }
 
    public String getNamaProjek() {
        return namaProjek;
    }
 
    public void setNamaProjek(String namaProjek) {
        if (Validasi.isTeksValid(namaProjek)) {
            this.namaProjek = namaProjek;
        } else {
            System.out.println("Nama proyek tidak valid!");
        }
    }
 
    public String getDeadline() {
        return deadline;
    }
 
    public void setDeadline(String deadline) {
        if (Validasi.isDeadlineValid(deadline)) {
            this.deadline = deadline;
        } else {
            System.out.println("Format deadline tidak valid!");
        }
    }
 
    public String getJenisProjek() {
        return "Umum";
    }
 
    public void cetakData() {
        System.out.println("Jenis Projek : " + getJenisProjek());
        System.out.println("ID Proyek    : " + idProjek);
        System.out.println("Nama Proyek  : " + namaProjek);
        System.out.println("Deadline     : " + deadline);
    }
}


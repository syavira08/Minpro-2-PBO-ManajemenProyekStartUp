/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import model.Proyek;
import java.util.ArrayList;

/**
 *
 * @author WINDOWS 11 PRO
 */
public class ProyekCrud {
    private ArrayList<Proyek> daftarProjek;
 
    public ProyekCrud() {
        daftarProjek = new ArrayList<Proyek>();
    }
 
    // CREATE
    public void tambahProjek(Proyek proyek) {
        daftarProjek.add(proyek);
        System.out.println("Projek berhasil ditambahkan.");
    }
 
    // READ 
    public void tampilkanSemuaProjek() {
        if (daftarProjek.size() == 0) {
            System.out.println("Belum ada data projek.");
            return;
        }
 
        System.out.println("===== DAFTAR PROJEK =====");
 
        for (int i = 0; i < daftarProjek.size(); i++) {
            Proyek p = daftarProjek.get(i);
            System.out.println("Data ke-" + (i + 1));
            p.cetakData();
            System.out.println("--------------------------");
        }
    }
 
   
    private int cariIndexById(String id) {
        for (int i = 0; i < daftarProjek.size(); i++) {
            Proyek p = daftarProjek.get(i);
            if (p.getIdProjek().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
 
    public boolean isIdSudahAda(String id) {
        int index = cariIndexById(id);
        if (index == -1) {
            return false;
        }
        return true;
    }
 
    public Proyek cariProjekById(String id) {
        int index = cariIndexById(id);
        if (index == -1) {
            return null;
        }
        return daftarProjek.get(index);
    }
 
    // UPDATE
    public boolean updateProjek(String id, String namaProjekBaru, String namaKlienBaru, String deadlineBaru) {
        int index = cariIndexById(id);
        if (index == -1) {
            return false;
        }
        Proyek p = daftarProjek.get(index);
        p.setNamaProjek(namaProjekBaru);
        p.setNamaKlien(namaKlienBaru);
        p.setDeadline(deadlineBaru);
        return true;
    }
 
    // DELETE
    public boolean hapusProjek(String id) {
        int index = cariIndexById(id);
        if (index == -1) {
            return false;
        }
        daftarProjek.remove(index);
        return true;
    }
}

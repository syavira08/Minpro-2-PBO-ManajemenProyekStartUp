/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
 
import model.Proyek;
import java.util.ArrayList;
import model.Proyek;
import model.ProyekInternal;
import model.ProyekKlien;
 
public class ProyekController {
    private ArrayList<Proyek> daftarProjek = new ArrayList<>();
 
    public ProyekController() {
    daftarProjek.add(new ProyekInternal(
            "PRJ001",
            "Sistem HR Internal",
            "30-11-2026",
            "Engineering",
            "Digitalisasi proses HR perusahaan"
    ));

    daftarProjek.add(new ProyekKlien(
            "PRJ002",
            "Website Company Profile",
            "15-12-2026",
            "PT Maju Bersama",
            "Pembuatan Website"
    ));

    daftarProjek.add(new ProyekInternal(
            "PRJ003",
            "Dashboard Analytics",
            "10-01-2027",
            "Product",
            "Monitoring performa aplikasi startup"
    ));
    }
 
    public void tambahProjek(Proyek proyek) {
        daftarProjek.add(proyek);
        System.out.println("Proyek berhasil ditambahkan!");
    }
 
    public void tampilkanSemuaProjek() {
        if (daftarProjek.size() == 0) {
            System.out.println("Belum ada data proyek!");
            return;
        }
 
        System.out.println();
        System.out.println();
        System.out.println("==================================================");
        System.out.println("           DAFTAR DATA PROYEK STARTUP");
        System.out.println("==================================================");
 
        for (int i = 0; i < daftarProjek.size(); i++) {
            Proyek p = daftarProjek.get(i);

            System.out.println();
            System.out.println("-------------------- PROYEK " + (i + 1) + " --------------------");
            p.cetakData();
            System.out.println("--------------------------------------------------");
        }

        System.out.println();
        System.out.println("Total Proyek : " + daftarProjek.size());
        System.out.println("==================================================");
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
 
    public boolean updateProjek(String id, String namaProjekBaru, String deadlineBaru) {
        int index = cariIndexById(id);
        if (index == -1) {
            return false;
        }
        Proyek p = daftarProjek.get(index);
        p.setNamaProjek(namaProjekBaru);
        p.setDeadline(deadlineBaru);
        return true;
    }
 
    public boolean hapusProjek(String id) {
        int index = cariIndexById(id);
        if (index == -1) {
            return false;
        }
        daftarProjek.remove(index);
        return true;
    }
}

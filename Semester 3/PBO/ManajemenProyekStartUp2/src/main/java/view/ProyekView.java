/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ProyekController;
import java.util.Scanner;
import model.Proyek;
import model.ProyekInternal;
import model.ProyekKlien;
import controller.Validasi;

/**
 *
 * @author WINDOWS 11 PRO
 */
public class ProyekView {
    public static void tampilkanMenu() {
        System.out.println();
        System.out.println("=============== MENU UTAMA ===============");
        System.out.println("1. Tambah Proyek");
        System.out.println("2. Tampilkan Semua Proyek");
        System.out.println("3. Update Proyek");
        System.out.println("4. Hapus Proyek");
        System.out.println("5. Keluar");
        System.out.println("==========================================");
    }
 
    public static void tambahProjek(Scanner scanner, ProyekController proyekCrud) {
        System.out.println();
        System.out.println("==========================================");
        System.out.println("              TAMBAH PROYEK");
        System.out.println("==========================================");
 
        int jenis = 0;
        while (jenis != 1 && jenis != 2) {
            System.out.println();
            System.out.println("---------- PILIH JENIS PROYEK ----------");
            System.out.println("1. Proyek Internal");
            System.out.println("2. Proyek Klien");
            System.out.println("----------------------------------------");
            System.out.print("Pilih jenis proyek : ");
            String pilihanJenis = scanner.nextLine();
 
            if (!Validasi.isPilihanValid(pilihanJenis)) {
                System.out.println("Input harus berupa angka!");
                continue;
            }
 
            jenis = Integer.parseInt(pilihanJenis.trim());
            if (jenis != 1 && jenis != 2) {
                System.out.println("Jenis tidak tersedia, pilih 1 atau 2.");
            }
        }
 
        String id = "";
        boolean idValid = false;
        while (!idValid) {
            System.out.println();
            System.out.println("------------ INFORMASI PROYEK ------------");
            System.out.print("ID Projek: ");
            id = scanner.nextLine();
            if (!Validasi.isTeksValid(id)) {
                System.out.println("ID tidak boleh kosong!");
            } else if (proyekCrud.isIdSudahAda(id)) {
                System.out.println("ID sudah digunakan, gunakan ID lain!");
            } else {
                idValid = true;
            }
        }
 
        String namaProjek = "";
        while (!Validasi.isTeksValid(namaProjek)) {
            System.out.print("Nama Proyek: ");
            namaProjek = scanner.nextLine();
            if (!Validasi.isTeksValid(namaProjek)) {
                System.out.println("Nama proyek tidak boleh kosong!");
            }
        }
 
        String deadline = "";
        while (!Validasi.isDeadlineValid(deadline)) {
            System.out.print("Deadline (format dd-mm-yyyy): ");
            deadline = scanner.nextLine();
            if (!Validasi.isDeadlineValid(deadline)) {
                System.out.println("Format deadline salah! Contoh: 21-02-2027");
            }
        }
 
        if (jenis == 1) {
            String divisiPeminta = "";
            while (!Validasi.isTeksValid(divisiPeminta)) {
                System.out.print("Divisi Peminta (Engineering/Product/Marketing/Operations): ");
                divisiPeminta = scanner.nextLine();
                if (!Validasi.isTeksValid(divisiPeminta)) {
                    System.out.println("Divisi peminta tidak boleh kosong!");
                }
            }
 
            String tujuanProjek = "";
            while (!Validasi.isTeksValid(tujuanProjek)) {
                System.out.print("Tujuan Proyek: ");
                tujuanProjek = scanner.nextLine();
                if (!Validasi.isTeksValid(tujuanProjek)) {
                    System.out.println("Tujuan proyek tidak boleh kosong!");
                }
            }
 
            ProyekInternal proyekBaru = new ProyekInternal(id, namaProjek, deadline, divisiPeminta, tujuanProjek);
            proyekCrud.tambahProjek(proyekBaru);
        } else {
            String namaKlien = "";
            while (!Validasi.isTeksValid(namaKlien)) {
                System.out.print("Nama Klien: ");
                namaKlien = scanner.nextLine();
                if (!Validasi.isTeksValid(namaKlien)) {
                    System.out.println("Nama klien tidak boleh kosong!");
                }
            }
 
            String jenisKebutuhan = "";
            while (!Validasi.isTeksValid(jenisKebutuhan)) {
                System.out.print("Jenis Kebutuhan: ");
                jenisKebutuhan = scanner.nextLine();
                if (!Validasi.isTeksValid(jenisKebutuhan)) {
                    System.out.println("Jenis kebutuhan tidak boleh kosong!");
                }
            }
 
            ProyekKlien proyekBaru = new ProyekKlien(id, namaProjek, deadline, namaKlien, jenisKebutuhan);
            proyekCrud.tambahProjek(proyekBaru);
        }
    }
 
    public static void updateProjek(Scanner scanner, ProyekController proyekCrud) {
        System.out.println();
        System.out.println("==========================================");
        System.out.println("           UPDATE DATA PROYEK");
        System.out.println("==========================================");
        System.out.print("Masukkan ID Projek yang ingin diupdate: ");
        String id = scanner.nextLine();
 
        Proyek proyek = proyekCrud.cariProjekById(id);
        if (proyek == null) {
            System.out.println("Projek dengan ID tersebut tidak ditemukan.");
            return;
        }
 
        System.out.println();
        System.out.println("------------ DATA LAMA ------------");
        proyek.cetakData();
 
        String namaProjek = "";
        while (!Validasi.isTeksValid(namaProjek)) {
            System.out.println();
            System.out.println("---------- INFORMASI PROYEK BARU ----------");
            System.out.print("Nama Proyek baru: ");
            namaProjek = scanner.nextLine();
            if (!Validasi.isTeksValid(namaProjek)) {
                System.out.println("Nama proyek tidak boleh kosong!");
            }
        }
 
        String deadline = "";
        while (!Validasi.isDeadlineValid(deadline)) {
            System.out.print("Deadline baru (format dd-mm-yyyy): ");
            deadline = scanner.nextLine();
            if (!Validasi.isDeadlineValid(deadline)) {
                System.out.println("Format deadline salah! Contoh: 21-02-2027");
            }
        }
 
        proyekCrud.updateProjek(id, namaProjek, deadline);
 
        if (proyek instanceof ProyekInternal) {
            ProyekInternal proyekInternal = (ProyekInternal) proyek;
 
            String divisiPeminta = "";
            while (!Validasi.isTeksValid(divisiPeminta)) {
                System.out.print("Divisi Peminta baru (Engineering/Product/Marketing/Operations): ");
                divisiPeminta = scanner.nextLine();
                if (!Validasi.isTeksValid(divisiPeminta)) {
                    System.out.println("Divisi peminta tidak boleh kosong!");
                }
            }
 
            String tujuanProjek = "";
            while (!Validasi.isTeksValid(tujuanProjek)) {
                System.out.print("Tujuan Proyek baru: ");
                tujuanProjek = scanner.nextLine();
                if (!Validasi.isTeksValid(tujuanProjek)) {
                    System.out.println("Tujuan proyek tidak boleh kosong!");
                }
            }
 
            proyekInternal.setDivisiPeminta(divisiPeminta);
            proyekInternal.setTujuanProjek(tujuanProjek);
        } else if (proyek instanceof ProyekKlien) {
            ProyekKlien proyekKlien = (ProyekKlien) proyek;
 
            String namaKlien = "";
            while (!Validasi.isTeksValid(namaKlien)) {
                System.out.print("Nama Klien baru: ");
                namaKlien = scanner.nextLine();
                if (!Validasi.isTeksValid(namaKlien)) {
                    System.out.println("Nama klien tidak boleh kosong!");
                }
            }
 
            String jenisKebutuhan = "";
            while (!Validasi.isTeksValid(jenisKebutuhan)) {
                System.out.print("Jenis Kebutuhan baru: ");
                jenisKebutuhan = scanner.nextLine();
                if (!Validasi.isTeksValid(jenisKebutuhan)) {
                    System.out.println("Jenis kebutuhan tidak boleh kosong!");
                }
            }
 
            proyekKlien.setNamaKlien(namaKlien);
            proyekKlien.setJenisKebutuhan(jenisKebutuhan);
        }
 
        System.out.println("Proyek berhasil diupdate!");
    }
 
    public static void hapusProjek(Scanner scanner, ProyekController proyekCrud) {
        System.out.println();
        System.out.println("==========================================");
        System.out.println("            HAPUS DATA PROYEK");
        System.out.println("==========================================");
        System.out.print("Masukkan ID Projek yang ingin dihapus: ");
        String id = scanner.nextLine();
 
        boolean berhasil = proyekCrud.hapusProjek(id);
        if (berhasil) {
            System.out.println("Proyek berhasil dihapus!");
        } else {
            System.out.println("Proyek dengan ID tersebut tidak ditemukan.");
        }
    }

}

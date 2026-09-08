/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import crud.ProyekCrud;
import model.Proyek;
import validasi.Validasi;
import java.util.Scanner;

/**
 *
 * @author WINDOWS 11 PRO
 */
public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProyekCrud proyekCrud = new ProyekCrud();
        Validasi validasi = new Validasi();
        boolean ngulang = true;
 
        System.out.println("SISTEM MANAJEMEN PROYEK STARTUP");
 
        while (ngulang) {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            String pilihan = scanner.nextLine();
 
            if (!validasi.isPilihanValid(pilihan)) {
                System.out.println("Input harus berupa angka!\n");
                continue;
            }
 
            int menu = Integer.parseInt(pilihan.trim());
 
            if (menu == 1) {
                tambahProjek(scanner, proyekCrud, validasi);
            } else if (menu == 2) {
                proyekCrud.tampilkanSemuaProjek();
            } else if (menu == 3) {
                updateProjek(scanner, proyekCrud, validasi);
            } else if (menu == 4) {
                hapusProjek(scanner, proyekCrud);
            } else if (menu == 5) {
                ngulang = false;
                System.out.println("Terima kasih, program selesai.");
            } else {
                System.out.println("Menu tidak tersedia, coba lagi.");
            }
 
            System.out.println();
        }
 
        scanner.close();
    }
 
    private static void tampilkanMenu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Tambah Projek");
        System.out.println("2. Tampilkan Semua Projek");
        System.out.println("3. Update Projek");
        System.out.println("4. Hapus Projek");
        System.out.println("5. Keluar");
        System.out.println("===========================");
    }
 
    private static void tambahProjek(Scanner scanner, ProyekCrud proyekCrud, Validasi validasi) {
        System.out.println("--- Tambah Projek ---");
 
        String id = "";
        boolean idValid = false;
        while (!idValid) {
            System.out.print("ID Projek: ");
            id = scanner.nextLine();
            if (!validasi.isTeksValid(id)) {
                System.out.println("ID tidak boleh kosong!");
            } else if (proyekCrud.isIdSudahAda(id)) {
                System.out.println("ID sudah digunakan, gunakan ID lain!");
            } else {
                idValid = true;
            }
        }
 
        String namaProjek = "";
        while (!validasi.isTeksValid(namaProjek)) {
            System.out.print("Nama Projek: ");
            namaProjek = scanner.nextLine();
            if (!validasi.isTeksValid(namaProjek)) {
                System.out.println("Nama projek tidak boleh kosong!");
            }
        }
 
        String namaKlien = "";
        while (!validasi.isTeksValid(namaKlien)) {
            System.out.print("Nama Klien: ");
            namaKlien = scanner.nextLine();
            if (!validasi.isTeksValid(namaKlien)) {
                System.out.println("Nama klien tidak boleh kosong!");
            }
        }
 
        String deadline = "";
        while (!validasi.isDeadlineValid(deadline)) {
            System.out.print("Deadline (format dd-mm-yyyy): ");
            deadline = scanner.nextLine();
            if (!validasi.isDeadlineValid(deadline)) {
                System.out.println("Format deadline salah! Contoh: 25-12-2026");
            }
        }
 
        Proyek proyekBaru = new Proyek(id, namaProjek, namaKlien, deadline);
        proyekCrud.tambahProjek(proyekBaru);
    }
 
    private static void updateProjek(Scanner scanner, ProyekCrud proyekCrud, Validasi validasi) {
        System.out.println("--- Update Projek ---");
        System.out.print("Masukkan ID Projek yang ingin diupdate: ");
        String id = scanner.nextLine();
 
        Proyek proyek = proyekCrud.cariProjekById(id);
        if (proyek == null) {
            System.out.println("Projek dengan ID tersebut tidak ditemukan.");
            return;
        }
 
        System.out.println("Data lama:");
        proyek.cetakData();
 
        String namaProjek = "";
        while (!validasi.isTeksValid(namaProjek)) {
            System.out.print("Nama Projek baru: ");
            namaProjek = scanner.nextLine();
            if (!validasi.isTeksValid(namaProjek)) {
                System.out.println("Nama projek tidak boleh kosong!");
            }
        }
 
        String namaKlien = "";
        while (!validasi.isTeksValid(namaKlien)) {
            System.out.print("Nama Klien baru: ");
            namaKlien = scanner.nextLine();
            if (!validasi.isTeksValid(namaKlien)) {
                System.out.println("Nama klien tidak boleh kosong!");
            }
        }
 
        String deadline = "";
        while (!validasi.isDeadlineValid(deadline)) {
            System.out.print("Deadline baru (format dd-mm-yyyy): ");
            deadline = scanner.nextLine();
            if (!validasi.isDeadlineValid(deadline)) {
                System.out.println("Format deadline salah! Contoh: 25-12-2026");
            }
        }
 
        proyekCrud.updateProjek(id, namaProjek, namaKlien, deadline);
        System.out.println("Projek berhasil diupdate.");
    }
 
    private static void hapusProjek(Scanner scanner, ProyekCrud proyekCrud) {
        System.out.println("--- Hapus Projek ---");
        System.out.print("Masukkan ID Projek yang ingin dihapus: ");
        String id = scanner.nextLine();
 
        boolean berhasil = proyekCrud.hapusProjek(id);
        if (berhasil) {
            System.out.println("Projek berhasil dihapus.");
        } else {
            System.out.println("Projek dengan ID tersebut tidak ditemukan.");
        }
    }
}

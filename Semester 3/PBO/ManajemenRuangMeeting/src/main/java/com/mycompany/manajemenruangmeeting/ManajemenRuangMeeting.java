/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manajemenruangmeeting;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author WINDOWS 11 PRO
 */
public class ManajemenRuangMeeting {
 
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Ruangan> daftarRuangan = new ArrayList<>();
    static ArrayList<Pengguna> daftarPengguna = new ArrayList<>();
    static ArrayList<Booking> daftarBooking = new ArrayList<>();
 
    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== SISTEM MANAJEMEN RUANG MEETING ===");
            System.out.println("1. Kelola Ruang Meeting");
            System.out.println("2. Kelola Pengguna");
            System.out.println("3. Kelola Booking");
            System.out.println("4. Tampilkan Jadwal Meeting");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();
 
            if (pilihan == 1) {
                menuRuangan();
            } else if (pilihan == 2) {
                menuPengguna();
            } else if (pilihan == 3) {
                menuBooking();
            } else if (pilihan == 4) {
                lihatBooking();
            } else if (pilihan == 5) {
                System.out.println("Terima kasih!");
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }
 
    static void menuRuangan() {
        System.out.println("\n-- Kelola Ruang Meeting --");
        System.out.println("1. Tambah Ruang");
        System.out.println("2. Lihat Ruang");
        System.out.println("3. Hapus Ruang");
        System.out.print("Pilih: ");
        int pilihan = sc.nextInt();
        sc.nextLine();
 
        if (pilihan == 1) {
            System.out.print("Nama ruang: ");
            String nama = sc.nextLine();
            System.out.print("Kapasitas: ");
            int kapasitas = sc.nextInt();
            sc.nextLine();
            System.out.print("Fasilitas: ");
            String fasilitas = sc.nextLine();
 
            if (kapasitas <= 15) {
                daftarRuangan.add(new RuangKecil(nama, kapasitas, fasilitas));
            } else {
                daftarRuangan.add(new RuangBesar(nama, kapasitas, fasilitas));
            }
            System.out.println("Ruang berhasil ditambahkan.");
 
        } else if (pilihan == 2) {
            lihatRuang();
 
        } else if (pilihan == 3) {
            lihatRuang();
            System.out.print("Hapus nomor: ");
            int no = sc.nextInt();
            if (no >= 1 && no <= daftarRuangan.size()) {
                daftarRuangan.remove(no - 1);
                System.out.println("Ruang berhasil dihapus.");
            } else {
                System.out.println("Nomor tidak ditemukan.");
            }
        }
    }
 
    static void lihatRuang() {
        System.out.println("\n-- Daftar Ruang --");
        if (daftarRuangan.isEmpty()) {
            System.out.println("Belum ada ruang.");
        }
        for (int i = 0; i < daftarRuangan.size(); i++) {
            daftarRuangan.get(i).tampilkan(i + 1);
        }
    }
 
    static void menuPengguna() {
        System.out.println("\n-- Kelola Pengguna --");
        System.out.println("1. Tambah Pengguna");
        System.out.println("2. Lihat Pengguna");
        System.out.println("3. Hapus Pengguna");
        System.out.print("Pilih: ");
        int pilihan = sc.nextInt();
        sc.nextLine();
 
        if (pilihan == 1) {
            System.out.print("Nama: ");
            String nama = sc.nextLine();
            System.out.print("Departemen: ");
            String dept = sc.nextLine();
            daftarPengguna.add(new Pengguna(nama, dept));
            System.out.println("Pengguna berhasil ditambahkan.");
 
        } else if (pilihan == 2) {
            lihatPengguna();
 
        } else if (pilihan == 3) {
            lihatPengguna();
            System.out.print("Hapus nomor: ");
            int no = sc.nextInt();
            if (no >= 1 && no <= daftarPengguna.size()) {
                daftarPengguna.remove(no - 1);
                System.out.println("Pengguna berhasil dihapus.");
            } else {
                System.out.println("Nomor tidak ditemukan.");
            }
        }
    }
 
    static void lihatPengguna() {
        System.out.println("\n-- Daftar Pengguna --");
        if (daftarPengguna.isEmpty()) {
            System.out.println("Belum ada pengguna.");
        }
        for (int i = 0; i < daftarPengguna.size(); i++) {
            daftarPengguna.get(i).tampilkan(i + 1);
        }
    }
 
    static void menuBooking() {
        System.out.println("\n-- Kelola Booking --");
        System.out.println("1. Tambah Booking");
        System.out.println("2. Lihat Booking");
        System.out.println("3. Hapus Booking");
        System.out.print("Pilih: ");
        int pilihan = sc.nextInt();
        sc.nextLine();
 
        if (pilihan == 1) {
            if (daftarRuangan.isEmpty()) {
                System.out.println("Belum ada data ruang. Tambah ruang dulu di menu Kelola Ruang Meeting.");
                return;
            }
            if (daftarPengguna.isEmpty()) {
                System.out.println("Belum ada data pengguna. Tambah pengguna dulu di menu Kelola Pengguna.");
                return;
            }
 
            lihatRuang();
            System.out.print("Pilih nomor ruang: ");
            int noRuang = sc.nextInt();
            sc.nextLine();
            if (noRuang < 1 || noRuang > daftarRuangan.size()) {
                System.out.println("Nomor ruang tidak ada di daftar.");
                return;
            }
 
            lihatPengguna();
            System.out.print("Pilih nomor pengguna: ");
            int noPengguna = sc.nextInt();
            sc.nextLine();
            if (noPengguna < 1 || noPengguna > daftarPengguna.size()) {
                System.out.println("Nomor pengguna tidak ada di daftar.");
                return;
            }
 
            System.out.print("Tanggal (dd-mm-yyyy): ");
            String tanggal = sc.nextLine();
            System.out.print("Jam (contoh 09.00-11.00): ");
            String jam = sc.nextLine();
            System.out.print("Keperluan: ");
            String keperluan = sc.nextLine();
 
            Ruangan ruang = daftarRuangan.get(noRuang - 1);
            Pengguna pengguna = daftarPengguna.get(noPengguna - 1);
            daftarBooking.add(new Booking(tanggal, jam, keperluan, ruang, pengguna));
            System.out.println("Booking berhasil ditambahkan.");
 
        } else if (pilihan == 2) {
            lihatBooking();
 
        } else if (pilihan == 3) {
            lihatBooking();
            System.out.print("Hapus nomor: ");
            int no = sc.nextInt();
            if (no >= 1 && no <= daftarBooking.size()) {
                daftarBooking.remove(no - 1);
                System.out.println("Booking berhasil dihapus.");
            } else {
                System.out.println("Nomor tidak ditemukan.");
            }
        }
    }
 
    static void lihatBooking() {
        System.out.println("\n-- Jadwal / Daftar Booking --");
        if (daftarBooking.isEmpty()) {
            System.out.println("Belum ada booking.");
        }
        for (int i = 0; i < daftarBooking.size(); i++) {
            daftarBooking.get(i).tampilkan(i + 1);
        }
    }
}

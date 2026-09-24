/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
 
import controller.ProyekController;
import controller.Validasi;
import view.ProyekView;
import java.util.Scanner;
 
/**
 *
 * @author WINDOWS 11 PRO
 */
public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProyekController proyekCrud = new ProyekController();
        boolean ngulang = true;
 
        System.out.println("==================================================");
        System.out.println("         SISTEM MANAJEMEN PROYEK STARTUP");
        System.out.println("==================================================");
        System.out.println();
 
        while (ngulang) {
            ProyekView.tampilkanMenu();
            System.out.print("Pilih menu: ");
            String pilihan = scanner.nextLine();
 
            if (!Validasi.isPilihanValid(pilihan)) {
                System.out.println("Input harus berupa angka!\n");
                continue;
            }
 
            int menu = Integer.parseInt(pilihan.trim());
 
            if (menu == 1) {
                ProyekView.tambahProjek(scanner, proyekCrud);
            } else if (menu == 2) {
                proyekCrud.tampilkanSemuaProjek();
            } else if (menu == 3) {
                ProyekView.updateProjek(scanner, proyekCrud);
            } else if (menu == 4) {
                ProyekView.hapusProjek(scanner, proyekCrud);
            } else if (menu == 5) {
                ngulang = false;
                System.out.println();
                System.out.println("==================================================");
                System.out.println("     TERIMA KASIH TELAH MENGGUNAKAN SISTEM");
                System.out.println("           MANAJEMEN PROYEK STARTUP");
                System.out.println("==================================================");
            } else {
                System.out.println("Menu tidak tersedia, coba lagi.");
            }
 
            System.out.println();
        }
 
        scanner.close();
    }
 
    }

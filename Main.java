/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Admin.Menu;
import Admin.Pesanan;

public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Menu> menuList = new ArrayList<>();
        List<Pesanan> pesananList = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Ubah Menu");
            System.out.println("3. Hapus Menu");
            System.out.println("4. Buat Pesanan");
            System.out.println("5. Lihat Menu");
            System.out.println("6. Lihat Pesanan");
            System.out.println("7. Keluar");

            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Menu: ");
                    String namaMenu = scanner.nextLine();
                    System.out.print("Harga Menu: ");
                    int hargaMenu = scanner.nextInt();
                    scanner.nextLine();
                    Menu menu = new Menu(namaMenu, hargaMenu);
                    menuList.add(menu);
                    break;

                case 2:
                    if (menuList.isEmpty()) {
                        System.out.println("Daftar menu kosong. Silakan tambahkan menu terlebih dahulu.");
                    } else {
                        System.out.print("Pilih Menu yang akan diubah (1-" + menuList.size() + "): ");
                        int pilihanUbah = scanner.nextInt();
                        scanner.nextLine();
                        if (pilihanUbah > 0 && pilihanUbah <= menuList.size()) {
                            System.out.print("Nama Menu baru: ");
                            String namaMenuBaru = scanner.nextLine();
                            System.out.print("Harga Menu baru: ");
                            int hargaMenuBaru = scanner.nextInt();
                            scanner.nextLine();
                            Menu menuUbah = menuList.get(pilihanUbah - 1);
                            menuUbah.setNama(namaMenuBaru);
                            menuUbah.setHarga(hargaMenuBaru);
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                    }
                    break;

                case 3:
                    if (menuList.isEmpty()) {
                        System.out.println("Daftar menu kosong. Silakan tambahkan menu terlebih dahulu.");
                    } else {
                        System.out.print("Pilih Menu yang akan dihapus (1-" + menuList.size() + "): ");
                        int pilihanHapus = scanner.nextInt();
                        scanner.nextLine();
                        if (pilihanHapus > 0 && pilihanHapus <= menuList.size()) {
                            menuList.remove(pilihanHapus - 1);
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                    }
                    break;

                case 4:
                    if (menuList.isEmpty()) {
                        System.out.println("Daftar menu kosong. Silakan tambahkan menu terlebih dahulu.");
                    } else {
                        System.out.println("Daftar Menu:");
                        int menuIndex = 1;
                        for (Menu m : menuList) {
                            System.out.println(menuIndex + ". " + m.getNama() + " - Rp" + m.getHarga());
                            menuIndex++;
                        }

                        System.out.print("Pilih Menu (1-" + menuList.size() + "): ");
                        int pilihanMenu = scanner.nextInt();
                        scanner.nextLine();

                        if (pilihanMenu > 0 && pilihanMenu <= menuList.size()) {
                            Menu menuPesanan = menuList.get(pilihanMenu - 1);
                            System.out.print("Jumlah Pesanan: ");
                            int jumlahPesanan = scanner.nextInt();
                            scanner.nextLine();
                            Pesanan pesanan = new Pesanan(menuPesanan, jumlahPesanan);
                            pesananList.add(pesanan);
                            System.out.println("Pesanan berhasil dibuat.");
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                    }
                    break;

                case 5:
                    if (menuList.isEmpty()) {
                        System.out.println("Daftar menu kosong. Silakan tambahkan menu terlebih dahulu.");
                    } else {
                        System.out.println("Daftar Menu:");
                        int menuIndex = 1;
                        for (Menu m : menuList) {
                            System.out.println(menuIndex + ". " + m.getNama() + " - Rp" + m.getHarga());
                            menuIndex++;
                        }
                    }
                    break;

                case 6:
                    if (pesananList.isEmpty()) {
                        System.out.println("Daftar pesanan kosong. Silakan buat pesanan terlebih dahulu.");
                    } else {
                        System.out.println("Daftar Pesanan:");
                        int pesananIndex = 1;
                        for (Pesanan p : pesananList) {
                            Menu pesananMenu = p.getMenu();
                            System.out.println(pesananIndex + ". " + pesananMenu.getNama() + " - Rp" + pesananMenu.getHarga() + " x " + p.getJumlah());
                            pesananIndex++;
                        }
                    }
                    break;

                case 7:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opsi tidak valid. Silakan pilih opsi lain.");
            }
        }
    }
}

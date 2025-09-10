/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.post_test1_pbo_moreno;

/**
 *
 * @author TUF GAMING
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Post_Test1_PBO_Moreno {
    
    private static ArrayList<Manga> daftarManga = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static class Manga {
        String judul;
        String author;
        String genre;
        int tahunRilis;

        public Manga(String judul, String author, String genre, int tahunRilis) {
            this.judul = judul;
            this.author = author;
            this.genre = genre;
            this.tahunRilis = tahunRilis;
        }

        public String getJudul() { return judul; }
        public void setJudul(String judul) { this.judul = judul; }

        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }

        public String getGenre() { return genre; }
        public void setGenre(String genre) { this.genre = genre; }

        public int getTahunRilis() { return tahunRilis; }
        public void setTahunRilis(int tahunRilis) { this.tahunRilis = tahunRilis; }

        @Override
        public String toString() {
            return "Judul: " + judul + ", Author: " + author + ", Genre: " + genre + ", Tahun: " + tahunRilis;
        }
    }

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== MENU PERPUSTAKAAN MANGA ===");
            System.out.println("1. Tambah Manga");
            System.out.println("2. Lihat Semua Manga");
            System.out.println("3. Update Manga");
            System.out.println("4. Hapus Manga");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> tambahManga();
                case 2 -> tampilkanManga();
                case 3 -> updateManga();
                case 4 -> hapusManga();
                case 5 -> System.out.println("Keluar dari program...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    public static void tambahManga() {
        System.out.print("Judul Manga: ");
        String judul = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Tahun Rilis: ");
        int tahun = scanner.nextInt();
        scanner.nextLine();

        daftarManga.add(new Manga(judul, author, genre, tahun));
        System.out.println("Manga berhasil ditambahkan!");
    }

    public static void tampilkanManga() {
        if (daftarManga.isEmpty()) {
            System.out.println("Belum ada manga yang terdaftar.");
        } else {
            System.out.println("\nDaftar Manga:");
            for (int i = 0; i < daftarManga.size(); i++) {
                System.out.println((i+1) + ". " + daftarManga.get(i));
            }
        }
    }

    public static void updateManga() {
        tampilkanManga();
        if (!daftarManga.isEmpty()) {
            System.out.print("Pilih nomor manga yang ingin diupdate: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < daftarManga.size()) {
                Manga manga = daftarManga.get(index);

                System.out.print("Judul baru (kosongkan jika tidak ingin diubah): ");
                String judul = scanner.nextLine();
                if (!judul.isEmpty()) manga.setJudul(judul);

                System.out.print("Author baru (kosongkan jika tidak ingin diubah): ");
                String author = scanner.nextLine();
                if (!author.isEmpty()) manga.setAuthor(author);

                System.out.print("Genre baru (kosongkan jika tidak ingin diubah): ");
                String genre = scanner.nextLine();
                if (!genre.isEmpty()) manga.setGenre(genre);

                System.out.print("Tahun baru (0 jika tidak ingin diubah): ");
                int tahun = scanner.nextInt();
                scanner.nextLine();
                if (tahun != 0) manga.setTahunRilis(tahun);

                System.out.println("Manga berhasil diupdate!");
            } else {
                System.out.println("Nomor tidak valid!");
            }
        }
    }

    public static void hapusManga() {
        tampilkanManga();
        if (!daftarManga.isEmpty()) {
            System.out.print("Pilih nomor manga yang ingin dihapus: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < daftarManga.size()) {
                daftarManga.remove(index);
                System.out.println("Manga berhasil dihapus!");
            } else {
                System.out.println("Nomor tidak valid!");
            }
        }
    }
}
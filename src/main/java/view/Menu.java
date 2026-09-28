package view;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void tampilkanMenuUtama() {
        System.out.println("====================================");
        System.out.println("        TOKO AL-HAFIZH");
        System.out.println("   Sistem Penjualan Produk");
        System.out.println("====================================");
        System.out.println("1. Kelola Makanan");
        System.out.println("2. Kelola Minuman");
        System.out.println("3. Kelola Handphone");
        System.out.println("4. Kelola Aksesoris Handphone");
        System.out.println("5. Tampilkan Semua Produk");
        System.out.println("6. Simulasi Pembelian Produk");
        System.out.println("0. Keluar");
        System.out.println("====================================");
        System.out.print("Pilih menu: ");
    }

    public void tampilkanMenuKategori(String namaKategori) {
        System.out.println("------------------------------------");
        System.out.println("       KELOLA " + namaKategori.toUpperCase());
        System.out.println("------------------------------------");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Lihat Data Produk");
        System.out.println("3. Update Produk");
        System.out.println("4. Hapus Produk");
        System.out.println("0. Kembali");
        System.out.println("------------------------------------");
        System.out.print("Pilih menu: ");
    }

    public void tampilkanHeaderTabelMakanan() {
        System.out.println("==========================================================================================================");
        System.out.printf("| %-4s | %-8s | %-25s | %-10s | %-6s | %-12s | %-8s | %-8s | %-15s |%n",
                "No", "Kode", "Nama", "Harga", "Stok", "Kadaluarsa", "Status", "Berat", "Kategori");
        System.out.println("==========================================================================================================");
    }

    public void tampilkanBarisMakanan(int nomor, String kode, String nama,
            double harga, int stok, String kadaluarsa,
            String statusHalal, int berat, String kategori) {

        System.out.printf("| %-4d | %-8s | %-25s | Rp%7.0f | %-6d | %-12s | %-8s | %6d gr | %-15s |%n",
                nomor, kode, nama, harga, stok, kadaluarsa, statusHalal, berat, kategori);
    }

    public void tampilkanHeaderTabelMinuman() {
        System.out.println("==========================================================================================================");
        System.out.printf("| %-4s | %-8s | %-25s | %-10s | %-6s | %-12s | %-8s | %-8s | %-10s |%n",
                "No", "Kode", "Nama", "Harga", "Stok", "Kadaluarsa", "Status", "Ukuran", "Rasa");
        System.out.println("==========================================================================================================");
    }

    public void tampilkanBarisMinuman(int nomor, String kode, String nama,
            double harga, int stok, String kadaluarsa,
            String statusHalal, String ukuran, String rasa) {

        System.out.printf("| %-4d | %-8s | %-25s | Rp%7.0f | %-6d | %-12s | %-8s | %-8s | %-10s |%n",
                nomor, kode, nama, harga, stok, kadaluarsa, statusHalal, ukuran, rasa);
    }

    public void tampilkanHeaderTabelHandphone() {
        System.out.println("========================================================================================================================");
        System.out.printf("| %-4s | %-8s | %-25s | %-12s | %-6s | %-10s | %-10s | %-4s | %-11s | %-8s |%n",
                "No", "Kode", "Nama", "Harga", "Stok", "Merek", "Garansi", "RAM", "Penyimpanan", "Warna");
        System.out.println("========================================================================================================================");
    }

    public void tampilkanBarisHandphone(int nomor, String kode, String nama,
            double harga, int stok, String merek,
            String garansi, int ram, int penyimpanan, String warna) {

        System.out.printf("| %-4d | %-8s | %-25s | Rp%9.0f | %-6d | %-10s | %-10s | %3d GB | %9d GB | %-8s |%n",
                nomor, kode, nama, harga, stok, merek, garansi, ram, penyimpanan, warna);
    }

    public void tampilkanHeaderTabelAksesoris() {
        System.out.println("========================================================================================================================");
        System.out.printf("| %-4s | %-8s | %-25s | %-12s | %-6s | %-10s | %-10s | %-20s | %-25s |%n",
                "No", "Kode", "Nama", "Harga", "Stok", "Merek", "Garansi", "Jenis", "Kompatibilitas");
        System.out.println("========================================================================================================================");
    }

    public void tampilkanBarisAksesoris(int nomor, String kode, String nama,
            double harga, int stok, String merek,
            String garansi, String jenis, String kompatibilitas) {

        System.out.printf("| %-4d | %-8s | %-25s | Rp%9.0f | %-6d | %-10s | %-10s | %-20s | %-25s |%n",
                nomor, kode, nama, harga, stok, merek, garansi, jenis, kompatibilitas);
    }

    public void tampilkanPemisah() {
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    public void tampilkanPesanKosong(String kategori) {
        System.out.println("Belum ada data " + kategori + " yang tersimpan.");
    }

    public void tampilkanPesanSukses(String pesan) {
        System.out.println(pesan);
    }

    public void tampilkanPesanError(String pesan) {
        System.out.println("Error: " + pesan);
    }

    public int inputInt(String pesan) {
        int nilai = -1;

        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();

            try {
                nilai = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
            }
        }

        return nilai;
    }

    public int inputIntDenganBatas(String pesan, int min, int max) {
        int nilai = -1;

        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();

            try {
                nilai = Integer.parseInt(input);

                if (nilai >= min && nilai <= max) {
                    break;
                } else {
                    System.out.println("Input harus antara " + min + " sampai " + max + ". Silakan coba lagi.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
            }
        }

        return nilai;
    }

    public double inputDouble(String pesan) {
        double nilai = -1;

        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();

            try {
                nilai = Double.parseDouble(input);

                if (nilai > 0) {
                    break;
                } else {
                    System.out.println("Nilai harus lebih dari 0. Silakan coba lagi.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
            }
        }

        return nilai;
    }

    public String inputString(String pesan) {
        String input;

        while (true) {
            System.out.print(pesan);
            input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                break;
            } else {
                System.out.println("Input tidak boleh kosong. Silakan coba lagi.");
            }
        }

        return input;
    }

    public boolean inputKonfirmasiHapus() {
        String konfirmasi;

        while (true) {
            System.out.print("Apakah Anda yakin ingin menghapus data ini? (ya/tidak): ");
            konfirmasi = scanner.nextLine().trim().toLowerCase();

            if (konfirmasi.equals("ya")) {
                return true;
            } else if (konfirmasi.equals("tidak")) {
                return false;
            } else {
                System.out.println("Input hanya boleh 'ya' atau 'tidak'. Silakan coba lagi.");
            }
        }
    }

    public boolean inputYaTidak(String pesan) {
        String konfirmasi;

        while (true) {
            System.out.print(pesan + " (ya/tidak): ");
            konfirmasi = scanner.nextLine().trim().toLowerCase();

            if (konfirmasi.equals("ya")) {
                return true;
            } else if (konfirmasi.equals("tidak")) {
                return false;
            } else {
                System.out.println("Input hanya boleh 'ya' atau 'tidak'. Silakan coba lagi.");
            }
        }
    }

    public void bersihkanLayar() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
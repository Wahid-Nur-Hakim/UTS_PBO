package controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.AksesorisHandphone;
import model.Handphone;
import model.Makanan;
import model.Minuman;
import model.Produk;
import view.Menu;

public class CrudProduk {
    private Scanner scanner;
    private Menu menu;

    private ArrayList<Makanan> daftarMakanan;
    private ArrayList<Minuman> daftarMinuman;
    private ArrayList<Handphone> daftarHandphone;
    private ArrayList<AksesorisHandphone> daftarAksesoris;
    private ArrayList<String> riwayatTransaksi;

    public CrudProduk(Scanner scanner, Menu menu) {
        this.scanner = scanner;
        this.menu = menu;

        daftarMakanan = new ArrayList<>();
        daftarMinuman = new ArrayList<>();
        daftarHandphone = new ArrayList<>();
        daftarAksesoris = new ArrayList<>();
        riwayatTransaksi = new ArrayList<>();

        isiDataDummy();
    }

    // =====================================================
    // DATA DUMMY
    // =====================================================

    private void isiDataDummy() {
        isiDummyMakanan();
        isiDummyMinuman();
        isiDummyHandphone();
        isiDummyAksesoris();
    }

    private void isiDummyMakanan() {
        daftarMakanan.add(new Makanan("MKN001", "Keripik Singkong", 15000, 30, "2027-06-01", true, 150, "Makanan Ringan"));
        daftarMakanan.add(new Makanan("MKN002", "Biskuit Cokelat", 12000, 40, "2027-08-15", true, 200, "Biskuit"));
        daftarMakanan.add(new Makanan("MKN003", "Roti Tawar", 18000, 25, "2026-10-05", true, 400, "Roti"));
        daftarMakanan.add(new Makanan("MKN004", "Wafer Keju", 10000, 50, "2027-03-20", true, 120, "Makanan Ringan"));
        daftarMakanan.add(new Makanan("MKN005", "Kacang Atom", 8000, 60, "2027-05-10", true, 100, "Makanan Ringan"));
    }

    private void isiDummyMinuman() {
        daftarMinuman.add(new Minuman("MNM001", "Air Mineral 600ml", 5000, 100, "2027-12-31", true, "600 ml", "Tawar"));
        daftarMinuman.add(new Minuman("MNM002", "Teh Botol", 7000, 80, "2027-10-20", true, "600 ml", "Melati"));
        daftarMinuman.add(new Minuman("MNM003", "Kopi Susu", 9000, 60, "2027-07-15", true, "330 ml", "Kopi"));
        daftarMinuman.add(new Minuman("MNM004", "Jus Jeruk", 12000, 50, "2027-09-01", true, "500 ml", "Jeruk"));
        daftarMinuman.add(new Minuman("MNM005", "Minuman Cokelat", 11000, 55, "2027-11-10", true, "500 ml", "Cokelat"));
    }

    private void isiDummyHandphone() {
        daftarHandphone.add(new Handphone("HP001", "Samsung Galaxy A15", 2500000, 8, "Samsung", 12, 6, 128, "Hitam"));
        daftarHandphone.add(new Handphone("HP002", "Xiaomi Redmi Note 13", 2300000, 10, "Xiaomi", 12, 8, 256, "Biru"));
        daftarHandphone.add(new Handphone("HP003", "Oppo A78", 2100000, 7, "Oppo", 12, 6, 128, "Ungu"));
        daftarHandphone.add(new Handphone("HP004", "Vivo Y27", 2000000, 9, "Vivo", 12, 6, 128, "Hijau"));
        daftarHandphone.add(new Handphone("HP005", "Infinix Hot 40", 1800000, 12, "Infinix", 12, 4, 128, "Emas"));
    }

    private void isiDummyAksesoris() {
        daftarAksesoris.add(new AksesorisHandphone("AKS001", "Casing Samsung A15", 35000, 30, "Samsung", 3, "Casing", "Samsung Galaxy A15"));
        daftarAksesoris.add(new AksesorisHandphone("AKS002", "Charger Fast Charge", 85000, 25, "Xiaomi", 6, "Charger", "Samsung, Xiaomi, Oppo"));
        daftarAksesoris.add(new AksesorisHandphone("AKS003", "Kabel Data Type-C", 25000, 40, "Vivo", 3, "Kabel Data", "USB Type-C"));
        daftarAksesoris.add(new AksesorisHandphone("AKS004", "Earphone 3.5mm", 45000, 35, "Oppo", 3, "Earphone", "Semua handphone 3.5mm"));
        daftarAksesoris.add(new AksesorisHandphone("AKS005", "Tempered Glass", 30000, 50, "Xiaomi", 3, "Tempered Glass", "Xiaomi Redmi Note 13"));
    }

    // =====================================================
    // MENU UTAMA
    // =====================================================

    public void jalankanProgram() {
        boolean keluar = false;

        while (!keluar) {
            menu.bersihkanLayar();
            menu.tampilkanMenuUtama();

            int pilihan = menu.inputIntDenganBatas("", 0, 6);

            switch (pilihan) {
                case 1:
                    kelolaMakanan();
                    break;
                case 2:
                    kelolaMinuman();
                    break;
                case 3:
                    kelolaHandphone();
                    break;
                case 4:
                    kelolaAksesoris();
                    break;
                case 5:
                    tampilkanSemuaProduk();
                    break;
                case 6:
                    simulasiPembelian();
                    break;
                case 0:
                    keluar = true;
                    menu.tampilkanPesanSukses("Terima kasih telah menggunakan Toko Al-Hafizh.");
                    break;
                default:
                    menu.tampilkanPesanError("Pilihan tidak tersedia.");
            }

            if (!keluar) {
                tekanEnter();
            }
        }
    }

    // =====================================================
    // SUB MENU KATEGORI
    // =====================================================

    private void kelolaMakanan() {
        boolean kembali = false;

        while (!kembali) {
            menu.bersihkanLayar();
            menu.tampilkanMenuKategori("makanan");

            int pilihan = menu.inputIntDenganBatas("", 0, 4);

            switch (pilihan) {
                case 1:
                    tambahMakanan();
                    break;
                case 2:
                    lihatMakanan();
                    break;
                case 3:
                    updateMakanan();
                    break;
                case 4:
                    hapusMakanan();
                    break;
                case 0:
                    kembali = true;
                    break;
                default:
                    menu.tampilkanPesanError("Pilihan tidak tersedia.");
            }

            if (!kembali) {
                tekanEnter();
            }
        }
    }

    private void kelolaMinuman() {
        boolean kembali = false;

        while (!kembali) {
            menu.bersihkanLayar();
            menu.tampilkanMenuKategori("minuman");

            int pilihan = menu.inputIntDenganBatas("", 0, 4);

            switch (pilihan) {
                case 1:
                    tambahMinuman();
                    break;
                case 2:
                    lihatMinuman();
                    break;
                case 3:
                    updateMinuman();
                    break;
                case 4:
                    hapusMinuman();
                    break;
                case 0:
                    kembali = true;
                    break;
                default:
                    menu.tampilkanPesanError("Pilihan tidak tersedia.");
            }

            if (!kembali) {
                tekanEnter();
            }
        }
    }

    private void kelolaHandphone() {
        boolean kembali = false;

        while (!kembali) {
            menu.bersihkanLayar();
            menu.tampilkanMenuKategori("handphone");

            int pilihan = menu.inputIntDenganBatas("", 0, 4);

            switch (pilihan) {
                case 1:
                    tambahHandphone();
                    break;
                case 2:
                    lihatHandphone();
                    break;
                case 3:
                    updateHandphone();
                    break;
                case 4:
                    hapusHandphone();
                    break;
                case 0:
                    kembali = true;
                    break;
                default:
                    menu.tampilkanPesanError("Pilihan tidak tersedia.");
            }

            if (!kembali) {
                tekanEnter();
            }
        }
    }

    private void kelolaAksesoris() {
        boolean kembali = false;

        while (!kembali) {
            menu.bersihkanLayar();
            menu.tampilkanMenuKategori("aksesoris handphone");

            int pilihan = menu.inputIntDenganBatas("", 0, 4);

            switch (pilihan) {
                case 1:
                    tambahAksesoris();
                    break;
                case 2:
                    lihatAksesoris();
                    break;
                case 3:
                    updateAksesoris();
                    break;
                case 4:
                    hapusAksesoris();
                    break;
                case 0:
                    kembali = true;
                    break;
                default:
                    menu.tampilkanPesanError("Pilihan tidak tersedia.");
            }

            if (!kembali) {
                tekanEnter();
            }
        }
    }

    // =====================================================
    // CRUD MAKANAN
    // =====================================================

    private void tambahMakanan() {
        menu.bersihkanLayar();
        System.out.println("--- TAMBAH MAKANAN ---");

        String kode = inputKodeBaru("Kode produk (contoh: MKN006): ");
        String nama = menu.inputString("Nama produk: ");
        double harga = menu.inputDouble("Harga: ");
        int stok = menu.inputIntDenganBatas("Stok: ", 0, Integer.MAX_VALUE);
        String kadaluarsa = inputTanggal("Tanggal kadaluarsa (YYYY-MM-DD): ");
        boolean halal = menu.inputYaTidak("Apakah produk halal?");
        int berat = menu.inputIntDenganBatas("Berat (gram): ", 1, Integer.MAX_VALUE);
        String kategori = menu.inputString("Kategori makanan: ");

        daftarMakanan.add(new Makanan(kode, nama, harga, stok, kadaluarsa, halal, berat, kategori));

        menu.tampilkanPesanSukses("Data makanan berhasil ditambahkan.");
    }

    private void cetakTabelMakanan() {
        menu.tampilkanHeaderTabelMakanan();

        for (int i = 0; i < daftarMakanan.size(); i++) {
            Makanan m = daftarMakanan.get(i);
            menu.tampilkanBarisMakanan(
                    i + 1,
                    m.getKodeProduk(),
                    m.getNamaProduk(),
                    m.getHarga(),
                    m.getStok(),
                    m.getTanggalKadaluarsa(),
                    m.getStatusHalal(),
                    m.getBeratGram(),
                    m.getKategoriMakanan()
            );
        }

        menu.tampilkanPemisah();
    }

    private void lihatMakanan() {
        menu.bersihkanLayar();
        System.out.println("--- DATA MAKANAN ---");

        if (daftarMakanan.isEmpty()) {
            menu.tampilkanPesanKosong("makanan");
            return;
        }

        cetakTabelMakanan();
    }

    private void updateMakanan() {
        menu.bersihkanLayar();
        System.out.println("--- UPDATE MAKANAN ---");

        if (daftarMakanan.isEmpty()) {
            menu.tampilkanPesanKosong("makanan");
            return;
        }

        lihatMakanan();

        int nomor = menu.inputIntDenganBatas("Masukkan nomor produk yang ingin diupdate: ", 1, daftarMakanan.size());
        Makanan m = daftarMakanan.get(nomor - 1);

        System.out.println("\nData yang akan diupdate:");
        System.out.println(m.tampilkanDataDasar());
        System.out.println("(Tekan Enter untuk mempertahankan nilai lama)\n");

        String nama = inputStringOpsional("Nama produk baru [" + m.getNamaProduk() + "]: ", m.getNamaProduk());
        double harga = inputDoubleOpsional("Harga baru [" + (long) m.getHarga() + "]: ", m.getHarga());
        int stok = inputIntOpsional("Stok baru [" + m.getStok() + "]: ", m.getStok(), 0);
        String kadaluarsa = inputTanggalOpsional("Tanggal kadaluarsa baru [" + m.getTanggalKadaluarsa() + "]: ", m.getTanggalKadaluarsa());
        int berat = inputIntOpsional("Berat baru [" + m.getBeratGram() + "]: ", m.getBeratGram(), 1);
        String kategori = inputStringOpsional("Kategori baru [" + m.getKategoriMakanan() + "]: ", m.getKategoriMakanan());

        m.setNamaProduk(nama);
        m.setHarga(harga);
        m.setStok(stok);
        m.setTanggalKadaluarsa(kadaluarsa);
        m.setBeratGram(berat);
        m.setKategoriMakanan(kategori);

        menu.tampilkanPesanSukses("Data makanan berhasil diupdate.");
    }

    private void hapusMakanan() {
        menu.bersihkanLayar();
        System.out.println("--- HAPUS MAKANAN ---");

        if (daftarMakanan.isEmpty()) {
            menu.tampilkanPesanKosong("makanan");
            return;
        }

        lihatMakanan();

        int nomor = menu.inputIntDenganBatas("Masukkan nomor produk yang ingin dihapus: ", 1, daftarMakanan.size());
        Makanan m = daftarMakanan.get(nomor - 1);

        System.out.println("\nData yang akan dihapus:");
        System.out.println(m.tampilkanDataDasar());

        if (menu.inputKonfirmasiHapus()) {
            daftarMakanan.remove(nomor - 1);
            menu.tampilkanPesanSukses("Data makanan berhasil dihapus.");
        } else {
            System.out.println("Penghapusan data dibatalkan.");
        }
    }

    // =====================================================
    // CRUD MINUMAN
    // =====================================================

    private void tambahMinuman() {
        menu.bersihkanLayar();
        System.out.println("--- TAMBAH MINUMAN ---");

        String kode = inputKodeBaru("Kode produk (contoh: MNM006): ");
        String nama = menu.inputString("Nama produk: ");
        double harga = menu.inputDouble("Harga: ");
        int stok = menu.inputIntDenganBatas("Stok: ", 0, Integer.MAX_VALUE);
        String kadaluarsa = inputTanggal("Tanggal kadaluarsa (YYYY-MM-DD): ");
        boolean halal = menu.inputYaTidak("Apakah produk halal?");
        String ukuran = menu.inputString("Ukuran (contoh: 600 ml): ");
        String rasa = menu.inputString("Rasa: ");

        daftarMinuman.add(new Minuman(kode, nama, harga, stok, kadaluarsa, halal, ukuran, rasa));

        menu.tampilkanPesanSukses("Data minuman berhasil ditambahkan.");
    }

    private void cetakTabelMinuman() {
        menu.tampilkanHeaderTabelMinuman();

        for (int i = 0; i < daftarMinuman.size(); i++) {
            Minuman m = daftarMinuman.get(i);
            menu.tampilkanBarisMinuman(
                    i + 1,
                    m.getKodeProduk(),
                    m.getNamaProduk(),
                    m.getHarga(),
                    m.getStok(),
                    m.getTanggalKadaluarsa(),
                    m.getStatusHalal(),
                    m.getUkuran(),
                    m.getRasa()
            );
        }

        menu.tampilkanPemisah();
    }

    private void lihatMinuman() {
        menu.bersihkanLayar();
        System.out.println("--- DATA MINUMAN ---");

        if (daftarMinuman.isEmpty()) {
            menu.tampilkanPesanKosong("minuman");
            return;
        }

        cetakTabelMinuman();
    }

    private void updateMinuman() {
        menu.bersihkanLayar();
        System.out.println("--- UPDATE MINUMAN ---");

        if (daftarMinuman.isEmpty()) {
            menu.tampilkanPesanKosong("minuman");
            return;
        }

        lihatMinuman();

        int nomor = menu.inputIntDenganBatas("Masukkan nomor produk yang ingin diupdate: ", 1, daftarMinuman.size());
        Minuman m = daftarMinuman.get(nomor - 1);

        System.out.println("\nData yang akan diupdate:");
        System.out.println(m.tampilkanDataDasar());
        System.out.println("(Tekan Enter untuk mempertahankan nilai lama)\n");

        String nama = inputStringOpsional("Nama produk baru [" + m.getNamaProduk() + "]: ", m.getNamaProduk());
        double harga = inputDoubleOpsional("Harga baru [" + (long) m.getHarga() + "]: ", m.getHarga());
        int stok = inputIntOpsional("Stok baru [" + m.getStok() + "]: ", m.getStok(), 0);
        String kadaluarsa = inputTanggalOpsional("Tanggal kadaluarsa baru [" + m.getTanggalKadaluarsa() + "]: ", m.getTanggalKadaluarsa());
        String ukuran = inputStringOpsional("Ukuran baru [" + m.getUkuran() + "]: ", m.getUkuran());
        String rasa = inputStringOpsional("Rasa baru [" + m.getRasa() + "]: ", m.getRasa());

        m.setNamaProduk(nama);
        m.setHarga(harga);
        m.setStok(stok);
        m.setTanggalKadaluarsa(kadaluarsa);
        m.setUkuran(ukuran);
        m.setRasa(rasa);

        menu.tampilkanPesanSukses("Data minuman berhasil diupdate.");
    }

    private void hapusMinuman() {
        menu.bersihkanLayar();
        System.out.println("--- HAPUS MINUMAN ---");

        if (daftarMinuman.isEmpty()) {
            menu.tampilkanPesanKosong("minuman");
            return;
        }

        lihatMinuman();

        int nomor = menu.inputIntDenganBatas("Masukkan nomor produk yang ingin dihapus: ", 1, daftarMinuman.size());
        Minuman m = daftarMinuman.get(nomor - 1);

        System.out.println("\nData yang akan dihapus:");
        System.out.println(m.tampilkanDataDasar());

        if (menu.inputKonfirmasiHapus()) {
            daftarMinuman.remove(nomor - 1);
            menu.tampilkanPesanSukses("Data minuman berhasil dihapus.");
        } else {
            System.out.println("Penghapusan data dibatalkan.");
        }
    }

    // =====================================================
    // CRUD HANDPHONE
    // =====================================================

    private void tambahHandphone() {
        menu.bersihkanLayar();
        System.out.println("--- TAMBAH HANDPHONE ---");

        String kode = inputKodeBaru("Kode produk (contoh: HP006): ");
        String nama = menu.inputString("Nama produk: ");
        double harga = menu.inputDouble("Harga: ");
        int stok = menu.inputIntDenganBatas("Stok: ", 0, Integer.MAX_VALUE);
        String merek = menu.inputString("Merek: ");
        int garansi = menu.inputIntDenganBatas("Masa garansi (bulan): ", 0, Integer.MAX_VALUE);
        int ram = menu.inputIntDenganBatas("RAM (GB): ", 1, Integer.MAX_VALUE);
        int penyimpanan = menu.inputIntDenganBatas("Penyimpanan (GB): ", 1, Integer.MAX_VALUE);
        String warna = menu.inputString("Warna: ");

        daftarHandphone.add(new Handphone(kode, nama, harga, stok, merek, garansi, ram, penyimpanan, warna));

        menu.tampilkanPesanSukses("Data handphone berhasil ditambahkan.");
    }

    private void cetakTabelHandphone() {
        menu.tampilkanHeaderTabelHandphone();

        for (int i = 0; i < daftarHandphone.size(); i++) {
            Handphone h = daftarHandphone.get(i);
            menu.tampilkanBarisHandphone(
                    i + 1,
                    h.getKodeProduk(),
                    h.getNamaProduk(),
                    h.getHarga(),
                    h.getStok(),
                    h.getMerek(),
                    h.getKeteranganGaransi(),
                    h.getRam(),
                    h.getPenyimpanan(),
                    h.getWarna()
            );
        }

        menu.tampilkanPemisah();
    }

    private void lihatHandphone() {
        menu.bersihkanLayar();
        System.out.println("--- DATA HANDPHONE ---");

        if (daftarHandphone.isEmpty()) {
            menu.tampilkanPesanKosong("handphone");
            return;
        }

        cetakTabelHandphone();
    }

    private void updateHandphone() {
        menu.bersihkanLayar();
        System.out.println("--- UPDATE HANDPHONE ---");

        if (daftarHandphone.isEmpty()) {
            menu.tampilkanPesanKosong("handphone");
            return;
        }

        lihatHandphone();

        int nomor = menu.inputIntDenganBatas("Masukkan nomor produk yang ingin diupdate: ", 1, daftarHandphone.size());
        Handphone h = daftarHandphone.get(nomor - 1);

        System.out.println("\nData yang akan diupdate:");
        System.out.println(h.tampilkanDataDasar());
        System.out.println("(Tekan Enter untuk mempertahankan nilai lama)\n");

        String nama = inputStringOpsional("Nama produk baru [" + h.getNamaProduk() + "]: ", h.getNamaProduk());
        double harga = inputDoubleOpsional("Harga baru [" + (long) h.getHarga() + "]: ", h.getHarga());
        int stok = inputIntOpsional("Stok baru [" + h.getStok() + "]: ", h.getStok(), 0);
        String merek = inputStringOpsional("Merek baru [" + h.getMerek() + "]: ", h.getMerek());
        int garansi = inputIntOpsional("Masa garansi baru (bulan) [" + h.getMasaGaransi() + "]: ", h.getMasaGaransi(), 0);
        int ram = inputIntOpsional("RAM baru [" + h.getRam() + "]: ", h.getRam(), 1);
        int penyimpanan = inputIntOpsional("Penyimpanan baru [" + h.getPenyimpanan() + "]: ", h.getPenyimpanan(), 1);
        String warna = inputStringOpsional("Warna baru [" + h.getWarna() + "]: ", h.getWarna());

        h.setNamaProduk(nama);
        h.setHarga(harga);
        h.setStok(stok);
        h.setMerek(merek);
        h.setMasaGaransi(garansi);
        h.setRam(ram);
        h.setPenyimpanan(penyimpanan);
        h.setWarna(warna);

        menu.tampilkanPesanSukses("Data handphone berhasil diupdate.");
    }

    private void hapusHandphone() {
        menu.bersihkanLayar();
        System.out.println("--- HAPUS HANDPHONE ---");

        if (daftarHandphone.isEmpty()) {
            menu.tampilkanPesanKosong("handphone");
            return;
        }

        lihatHandphone();

        int nomor = menu.inputIntDenganBatas("Masukkan nomor produk yang ingin dihapus: ", 1, daftarHandphone.size());
        Handphone h = daftarHandphone.get(nomor - 1);

        System.out.println("\nData yang akan dihapus:");
        System.out.println(h.tampilkanDataDasar());

        if (menu.inputKonfirmasiHapus()) {
            daftarHandphone.remove(nomor - 1);
            menu.tampilkanPesanSukses("Data handphone berhasil dihapus.");
        } else {
            System.out.println("Penghapusan data dibatalkan.");
        }
    }

    // =====================================================
    // CRUD AKSESORIS HANDPHONE
    // =====================================================

    private void tambahAksesoris() {
        menu.bersihkanLayar();
        System.out.println("--- TAMBAH AKSESORIS HANDPHONE ---");

        String kode = inputKodeBaru("Kode produk (contoh: AKS006): ");
        String nama = menu.inputString("Nama produk: ");
        double harga = menu.inputDouble("Harga: ");
        int stok = menu.inputIntDenganBatas("Stok: ", 0, Integer.MAX_VALUE);
        String merek = menu.inputString("Merek: ");
        int garansi = menu.inputIntDenganBatas("Masa garansi (bulan): ", 0, Integer.MAX_VALUE);
        String jenis = menu.inputString("Jenis aksesoris: ");
        String kompatibilitas = menu.inputString("Kompatibilitas: ");

        daftarAksesoris.add(new AksesorisHandphone(kode, nama, harga, stok, merek, garansi, jenis, kompatibilitas));

        menu.tampilkanPesanSukses("Data aksesoris berhasil ditambahkan.");
    }

    private void cetakTabelAksesoris() {
        menu.tampilkanHeaderTabelAksesoris();

        for (int i = 0; i < daftarAksesoris.size(); i++) {
            AksesorisHandphone a = daftarAksesoris.get(i);
            menu.tampilkanBarisAksesoris(
                    i + 1,
                    a.getKodeProduk(),
                    a.getNamaProduk(),
                    a.getHarga(),
                    a.getStok(),
                    a.getMerek(),
                    a.getKeteranganGaransi(),
                    a.getJenisAksesoris(),
                    a.getKompatibilitas()
            );
        }

        menu.tampilkanPemisah();
    }

    private void lihatAksesoris() {
        menu.bersihkanLayar();
        System.out.println("--- DATA AKSESORIS HANDPHONE ---");

        if (daftarAksesoris.isEmpty()) {
            menu.tampilkanPesanKosong("aksesoris handphone");
            return;
        }

        cetakTabelAksesoris();
    }

    private void updateAksesoris() {
        menu.bersihkanLayar();
        System.out.println("--- UPDATE AKSESORIS HANDPHONE ---");

        if (daftarAksesoris.isEmpty()) {
            menu.tampilkanPesanKosong("aksesoris handphone");
            return;
        }

        lihatAksesoris();

        int nomor = menu.inputIntDenganBatas("Masukkan nomor produk yang ingin diupdate: ", 1, daftarAksesoris.size());
        AksesorisHandphone a = daftarAksesoris.get(nomor - 1);

        System.out.println("\nData yang akan diupdate:");
        System.out.println(a.tampilkanDataDasar());
        System.out.println("(Tekan Enter untuk mempertahankan nilai lama)\n");

        String nama = inputStringOpsional("Nama produk baru [" + a.getNamaProduk() + "]: ", a.getNamaProduk());
        double harga = inputDoubleOpsional("Harga baru [" + (long) a.getHarga() + "]: ", a.getHarga());
        int stok = inputIntOpsional("Stok baru [" + a.getStok() + "]: ", a.getStok(), 0);
        String merek = inputStringOpsional("Merek baru [" + a.getMerek() + "]: ", a.getMerek());
        int garansi = inputIntOpsional("Masa garansi baru (bulan) [" + a.getMasaGaransi() + "]: ", a.getMasaGaransi(), 0);
        String jenis = inputStringOpsional("Jenis aksesoris baru [" + a.getJenisAksesoris() + "]: ", a.getJenisAksesoris());
        String kompatibilitas = inputStringOpsional("Kompatibilitas baru [" + a.getKompatibilitas() + "]: ", a.getKompatibilitas());

        a.setNamaProduk(nama);
        a.setHarga(harga);
        a.setStok(stok);
        a.setMerek(merek);
        a.setMasaGaransi(garansi);
        a.setJenisAksesoris(jenis);
        a.setKompatibilitas(kompatibilitas);

        menu.tampilkanPesanSukses("Data aksesoris berhasil diupdate.");
    }

    private void hapusAksesoris() {
        menu.bersihkanLayar();
        System.out.println("--- HAPUS AKSESORIS HANDPHONE ---");

        if (daftarAksesoris.isEmpty()) {
            menu.tampilkanPesanKosong("aksesoris handphone");
            return;
        }

        lihatAksesoris();

        int nomor = menu.inputIntDenganBatas("Masukkan nomor produk yang ingin dihapus: ", 1, daftarAksesoris.size());
        AksesorisHandphone a = daftarAksesoris.get(nomor - 1);

        System.out.println("\nData yang akan dihapus:");
        System.out.println(a.tampilkanDataDasar());

        if (menu.inputKonfirmasiHapus()) {
            daftarAksesoris.remove(nomor - 1);
            menu.tampilkanPesanSukses("Data aksesoris berhasil dihapus.");
        } else {
            System.out.println("Penghapusan data dibatalkan.");
        }
    }

    // =====================================================
    // TAMPILKAN SEMUA PRODUK
    // =====================================================

    private void tampilkanSemuaProduk() {
        menu.bersihkanLayar();
        System.out.println("=== SEMUA PRODUK TOKO AL-HAFIZH ===\n");

        System.out.println("--- MAKANAN ---");
        if (daftarMakanan.isEmpty()) {
            menu.tampilkanPesanKosong("makanan");
        } else {
            cetakTabelMakanan();
        }

        System.out.println("\n--- MINUMAN ---");
        if (daftarMinuman.isEmpty()) {
            menu.tampilkanPesanKosong("minuman");
        } else {
            cetakTabelMinuman();
        }

        System.out.println("\n--- HANDPHONE ---");
        if (daftarHandphone.isEmpty()) {
            menu.tampilkanPesanKosong("handphone");
        } else {
            cetakTabelHandphone();
        }

        System.out.println("\n--- AKSESORIS HANDPHONE ---");
        if (daftarAksesoris.isEmpty()) {
            menu.tampilkanPesanKosong("aksesoris handphone");
        } else {
            cetakTabelAksesoris();
        }
    }

    // =====================================================
    // SIMULASI PEMBELIAN
    // =====================================================

    private void simulasiPembelian() {
        menu.bersihkanLayar();
        System.out.println("--- SIMULASI PEMBELIAN PRODUK ---");

        tampilkanSemuaProduk();

        System.out.println("\nPilih kategori produk yang ingin dibeli:");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
        System.out.println("3. Handphone");
        System.out.println("4. Aksesoris Handphone");
        System.out.println("0. Kembali");
        System.out.print("Pilih menu: ");

        int kategori = menu.inputIntDenganBatas("", 0, 4);

        switch (kategori) {
            case 1:
                beliMakanan();
                break;
            case 2:
                beliMinuman();
                break;
            case 3:
                beliHandphone();
                break;
            case 4:
                beliAksesoris();
                break;
            default:
                break;
        }
    }

    private void beliMakanan() {
        if (daftarMakanan.isEmpty()) {
            menu.tampilkanPesanKosong("makanan");
            return;
        }

        lihatMakanan();

        int nomor = menu.inputIntDenganBatas("Masukkan nomor produk yang ingin dibeli: ", 1, daftarMakanan.size());
        prosesPembelian(daftarMakanan.get(nomor - 1));
    }

    private void beliMinuman() {
        if (daftarMinuman.isEmpty()) {
            menu.tampilkanPesanKosong("minuman");
            return;
        }

        lihatMinuman();

        int nomor = menu.inputIntDenganBatas("Masukkan nomor produk yang ingin dibeli: ", 1, daftarMinuman.size());
        prosesPembelian(daftarMinuman.get(nomor - 1));
    }

    private void beliHandphone() {
        if (daftarHandphone.isEmpty()) {
            menu.tampilkanPesanKosong("handphone");
            return;
        }

        lihatHandphone();

        int nomor = menu.inputIntDenganBatas("Masukkan nomor produk yang ingin dibeli: ", 1, daftarHandphone.size());
        prosesPembelian(daftarHandphone.get(nomor - 1));
    }

    private void beliAksesoris() {
        if (daftarAksesoris.isEmpty()) {
            menu.tampilkanPesanKosong("aksesoris handphone");
            return;
        }

        lihatAksesoris();

        int nomor = menu.inputIntDenganBatas("Masukkan nomor produk yang ingin dibeli: ", 1, daftarAksesoris.size());
        prosesPembelian(daftarAksesoris.get(nomor - 1));
    }

    // Satu method untuk semua jenis produk (polimorfisme):
    // hitungHargaAkhir() otomatis memakai diskon jumlah sesuai kelas produknya.
    private void prosesPembelian(Produk p) {
        System.out.println("\nProduk yang dipilih:");
        System.out.println(p.tampilkanDataDasar());

        int jumlah = menu.inputIntDenganBatas("Jumlah pembelian: ", 1, Integer.MAX_VALUE);

        if (!p.stokCukup(jumlah)) {
            menu.tampilkanPesanError("Stok tidak mencukupi.");
            return;
        }

        boolean member = menu.inputYaTidak("Apakah Anda member?");

        double subtotal = p.getHarga() * jumlah;
        double total = p.hitungHargaAkhir(jumlah, member);

        p.kurangiStok(jumlah);
        catatTransaksi(p, jumlah, total);

        System.out.println("\n=== STRUK PEMBELIAN ===");
        System.out.println("Jenis       : " + p.getJenisProduk());
        System.out.println("Produk      : " + p.getNamaProduk());
        System.out.println("Jumlah      : " + jumlah);
        System.out.println(String.format("Harga satuan: Rp%,.0f", p.getHarga()));
        System.out.println(String.format("Subtotal    : Rp%,.0f", subtotal));
        System.out.println("Member      : " + (member ? "Ya" : "Tidak"));
        System.out.println(String.format("Diskon      : Rp%,.0f", subtotal - total));
        System.out.println(String.format("Total bayar : Rp%,.0f", total));
        System.out.println("=======================");

        tampilkanRiwayatTransaksi();
    }

    private void catatTransaksi(Produk p, int jumlah, double total) {
        riwayatTransaksi.add(String.format("%s (%s) x%d = Rp%,.0f",
                p.getNamaProduk(), p.getKodeProduk(), jumlah, total));
    }

    private void tampilkanRiwayatTransaksi() {
        System.out.println("\nRiwayat transaksi sesi ini:");

        for (int i = 0; i < riwayatTransaksi.size(); i++) {
            System.out.println((i + 1) + ". " + riwayatTransaksi.get(i));
        }
    }

    // =====================================================
    // HELPER JEDA LAYAR (tanpa validasi, Enter kosong diterima)
    // =====================================================

    private void tekanEnter() {
        System.out.print("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    // =====================================================
    // HELPER VALIDASI KODE & TANGGAL
    // =====================================================

    private List<Produk> semuaProduk() {
        List<Produk> semua = new ArrayList<>();
        semua.addAll(daftarMakanan);
        semua.addAll(daftarMinuman);
        semua.addAll(daftarHandphone);
        semua.addAll(daftarAksesoris);
        return semua;
    }

    private boolean kodeSudahAda(String kode) {
        for (Produk p : semuaProduk()) {
            if (p.getKodeProduk().equalsIgnoreCase(kode)) {
                return true;
            }
        }
        return false;
    }

    // Meminta kode sampai unik di seluruh kategori.
    private String inputKodeBaru(String pesan) {
        while (true) {
            String kode = menu.inputString(pesan);

            if (kodeSudahAda(kode)) {
                menu.tampilkanPesanError("Kode produk sudah digunakan. Gunakan kode lain.");
            } else {
                return kode;
            }
        }
    }

    private boolean tanggalValid(String tanggal) {
        try {
            LocalDate.parse(tanggal);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private String inputTanggal(String pesan) {
        while (true) {
            String tanggal = menu.inputString(pesan);

            if (tanggalValid(tanggal)) {
                return tanggal;
            }

            System.out.println("Format tanggal harus YYYY-MM-DD dan tanggalnya harus valid. Silakan coba lagi.");
        }
    }

    // =====================================================
    // HELPER INPUT OPSIONAL (untuk update: Enter = nilai lama)
    // =====================================================

    private String inputStringOpsional(String pesan, String nilaiLama) {
        System.out.print(pesan);
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? nilaiLama : input;
    }

    private double inputDoubleOpsional(String pesan, double nilaiLama) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return nilaiLama;
            }

            try {
                double nilai = Double.parseDouble(input);

                if (nilai > 0) {
                    return nilai;
                }

                System.out.println("Nilai harus lebih dari 0. Silakan coba lagi.");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
            }
        }
    }

    private int inputIntOpsional(String pesan, int nilaiLama, int min) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return nilaiLama;
            }

            try {
                int nilai = Integer.parseInt(input);

                if (nilai >= min) {
                    return nilai;
                }

                System.out.println("Nilai minimal " + min + ". Silakan coba lagi.");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
            }
        }
    }

    private String inputTanggalOpsional(String pesan, String nilaiLama) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return nilaiLama;
            }

            if (tanggalValid(input)) {
                return input;
            }

            System.out.println("Format tanggal harus YYYY-MM-DD dan tanggalnya harus valid. Silakan coba lagi.");
        }
    }
}
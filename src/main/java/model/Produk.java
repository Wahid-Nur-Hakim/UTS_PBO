package model;

public abstract class Produk {
    private String kodeProduk;
    private String namaProduk;
    private double harga;
    private int stok;

    public Produk(String kodeProduk, String namaProduk, double harga, int stok) {
        setKodeProduk(kodeProduk);
        setNamaProduk(namaProduk);
        setHarga(harga);
        setStok(stok);
    }

    public String getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk) {
        if (kodeProduk == null || kodeProduk.trim().isEmpty()) {
            System.out.println("Kode produk tidak boleh kosong.");
            return;
        }

        this.kodeProduk = kodeProduk.trim().toUpperCase();
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        if (namaProduk == null || namaProduk.trim().isEmpty()) {
            System.out.println("Nama produk tidak boleh kosong.");
            return;
        }

        this.namaProduk = namaProduk.trim();
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga <= 0) {
            System.out.println("Harga produk harus lebih dari 0.");
            return;
        }

        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok < 0) {
            System.out.println("Stok produk tidak boleh kurang dari 0.");
            return;
        }

        this.stok = stok;
    }

    public double hitungHargaAkhir(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah pembelian harus lebih dari 0.");
            return 0;
        }

        return harga * jumlah;
    }

    public double hitungHargaAkhir(int jumlah, boolean member) {
        double total = hitungHargaAkhir(jumlah);

        if (member && total > 0) {
            total = total * 0.90;
        }

        return total;
    }

    public boolean stokCukup(int jumlah) {
        return jumlah > 0 && jumlah <= stok;
    }

    public void kurangiStok(int jumlah) {
        if (stokCukup(jumlah)) {
            stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi.");
        }
    }

    public abstract String getJenisProduk();

    public String tampilkanDataDasar() {
        return String.format(
                "Kode: %s | Nama: %s | Harga: Rp%,.0f | Stok: %d",
                kodeProduk,
                namaProduk,
                harga,
                stok
        );
    }
}
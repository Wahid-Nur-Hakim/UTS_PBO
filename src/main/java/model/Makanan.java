package model;

public class Makanan extends ProdukKonsumsi {
    private int beratGram;
    private String kategoriMakanan;

    public Makanan(String kodeProduk, String namaProduk,
            double harga, int stok, String tanggalKadaluarsa,
            boolean halal, int beratGram, String kategoriMakanan) {

        super(kodeProduk, namaProduk, harga, stok,
                tanggalKadaluarsa, halal);

        setBeratGram(beratGram);
        setKategoriMakanan(kategoriMakanan);
    }

    public int getBeratGram() {
        return beratGram;
    }

    public void setBeratGram(int beratGram) {
        if (beratGram <= 0) {
            System.out.println("Berat gram makanan harus lebih dari 0.");
            return;
        }

        this.beratGram = beratGram;
    }

    public String getKategoriMakanan() {
        return kategoriMakanan;
    }

    public void setKategoriMakanan(String kategoriMakanan) {
        if (kategoriMakanan == null || kategoriMakanan.trim().isEmpty()) {
            System.out.println("Kategori makanan tidak boleh kosong.");
            return;
        }

        this.kategoriMakanan = kategoriMakanan.trim();
    }

    @Override
    public String getJenisProduk() {
        return "Makanan";
    }

    @Override
    public double hitungHargaAkhir(int jumlah) {
        double total = super.hitungHargaAkhir(jumlah);

        if (jumlah >= 5) {
            total = total * 0.95;
        }

        return total;
    }

    @Override
    public double hitungHargaAkhir(int jumlah, boolean member) {
        double total = hitungHargaAkhir(jumlah);

        if (member) {
            total = total * 0.90;
        }

        return total;
    }

    @Override
    public String tampilkanDataDasar() {
        return super.tampilkanDataDasar()
                + String.format(
                        " | Berat: %d gram | Kategori: %s",
                        beratGram,
                        kategoriMakanan
                );
    }
}
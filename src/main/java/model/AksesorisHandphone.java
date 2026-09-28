package model;

public class AksesorisHandphone extends Elektronik {
    private String jenisAksesoris;
    private String kompatibilitas;

    public AksesorisHandphone(String kodeProduk, String namaProduk,
            double harga, int stok, String merek,
            int masaGaransi, String jenisAksesoris,
            String kompatibilitas) {

        super(kodeProduk, namaProduk, harga, stok,
                merek, masaGaransi);

        setJenisAksesoris(jenisAksesoris);
        setKompatibilitas(kompatibilitas);
    }

    public String getJenisAksesoris() {
        return jenisAksesoris;
    }

    public void setJenisAksesoris(String jenisAksesoris) {
        if (jenisAksesoris == null || jenisAksesoris.trim().isEmpty()) {
            System.out.println("Jenis aksesoris tidak boleh kosong.");
            return;
        }

        this.jenisAksesoris = jenisAksesoris.trim();
    }

    public String getKompatibilitas() {
        return kompatibilitas;
    }

    public void setKompatibilitas(String kompatibilitas) {
        if (kompatibilitas == null || kompatibilitas.trim().isEmpty()) {
            System.out.println("Kompatibilitas aksesoris tidak boleh kosong.");
            return;
        }

        this.kompatibilitas = kompatibilitas.trim();
    }

    @Override
    public String getJenisProduk() {
        return "Aksesoris Handphone";
    }

    @Override
    public double hitungHargaAkhir(int jumlah) {
        double total = super.hitungHargaAkhir(jumlah);

        if (jumlah >= 3) {
            total = total * 0.90;
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
                        " | Jenis: %s | Kompatibilitas: %s",
                        jenisAksesoris,
                        kompatibilitas
                );
    }
}
package model;

public class Minuman extends ProdukKonsumsi {
    private String ukuran;
    private String rasa;

    public Minuman(String kodeProduk, String namaProduk,
            double harga, int stok, String tanggalKadaluarsa,
            boolean halal, String ukuran, String rasa) {

        super(kodeProduk, namaProduk, harga, stok,
                tanggalKadaluarsa, halal);

        setUkuran(ukuran);
        setRasa(rasa);
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        if (ukuran == null || ukuran.trim().isEmpty()) {
            System.out.println("Ukuran minuman tidak boleh kosong.");
            return;
        }

        this.ukuran = ukuran.trim();
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        if (rasa == null || rasa.trim().isEmpty()) {
            System.out.println("Rasa minuman tidak boleh kosong.");
            return;
        }

        this.rasa = rasa.trim();
    }

    @Override
    public String getJenisProduk() {
        return "Minuman";
    }

    @Override
    public double hitungHargaAkhir(int jumlah) {
        double total = super.hitungHargaAkhir(jumlah);

        if (jumlah >= 10) {
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
                        " | Ukuran: %s | Rasa: %s",
                        ukuran,
                        rasa
                );
    }
}
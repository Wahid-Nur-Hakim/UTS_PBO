package model;

public abstract class Elektronik extends Produk {
    private String merek;
    private int masaGaransi;

    public Elektronik(String kodeProduk, String namaProduk,
            double harga, int stok, String merek,
            int masaGaransi) {

        super(kodeProduk, namaProduk, harga, stok);

        setMerek(merek);
        setMasaGaransi(masaGaransi);
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        if (merek == null || merek.trim().isEmpty()) {
            System.out.println("Merek elektronik tidak boleh kosong.");
            return;
        }

        this.merek = merek.trim();
    }

    public int getMasaGaransi() {
        return masaGaransi;
    }

    public void setMasaGaransi(int masaGaransi) {
        if (masaGaransi < 0) {
            System.out.println("Masa garansi tidak boleh kurang dari 0 bulan.");
            return;
        }

        this.masaGaransi = masaGaransi;
    }

    public String getKeteranganGaransi() {
        if (masaGaransi == 0) {
            return "Tidak ada garansi";
        } else {
            return masaGaransi + " bulan";
        }
    }

    @Override
    public String tampilkanDataDasar() {
        return super.tampilkanDataDasar()
                + String.format(
                        " | Merek: %s | Garansi: %s",
                        merek,
                        getKeteranganGaransi()
                );
    }
}
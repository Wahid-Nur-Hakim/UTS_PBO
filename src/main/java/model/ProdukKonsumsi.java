package model;

public abstract class ProdukKonsumsi extends Produk {
    private String tanggalKadaluarsa;
    private boolean halal;

    public ProdukKonsumsi(String kodeProduk, String namaProduk,
            double harga, int stok, String tanggalKadaluarsa,
            boolean halal) {

        super(kodeProduk, namaProduk, harga, stok);

        setTanggalKadaluarsa(tanggalKadaluarsa);
        setHalal(halal);
    }

    public String getTanggalKadaluarsa() {
        return tanggalKadaluarsa;
    }

    public void setTanggalKadaluarsa(String tanggalKadaluarsa) {
        if (tanggalKadaluarsa == null || tanggalKadaluarsa.trim().isEmpty()) {
            System.out.println("Tanggal kadaluarsa tidak boleh kosong.");
            return;
        }

        this.tanggalKadaluarsa = tanggalKadaluarsa.trim();
    }

    public boolean isHalal() {
        return halal;
    }

    public void setHalal(boolean halal) {
        this.halal = halal;
    }

    public String getStatusHalal() {
        if (halal) {
            return "Halal";
        } else {
            return "Tidak Halal";
        }
    }

    @Override
    public String tampilkanDataDasar() {
        return super.tampilkanDataDasar()
                + String.format(
                        " | Kadaluarsa: %s | Status: %s",
                        tanggalKadaluarsa,
                        getStatusHalal()
                );
    }
}
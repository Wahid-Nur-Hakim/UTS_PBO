package model;

public class Handphone extends Elektronik {
    private int ram;
    private int penyimpanan;
    private String warna;

    public Handphone(String kodeProduk, String namaProduk,
            double harga, int stok, String merek,
            int masaGaransi, int ram, int penyimpanan,
            String warna) {

        super(kodeProduk, namaProduk, harga, stok,
                merek, masaGaransi);

        setRam(ram);
        setPenyimpanan(penyimpanan);
        setWarna(warna);
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if (ram <= 0) {
            System.out.println("RAM harus lebih dari 0 GB.");
            return;
        }

        this.ram = ram;
    }

    public int getPenyimpanan() {
        return penyimpanan;
    }

    public void setPenyimpanan(int penyimpanan) {
        if (penyimpanan <= 0) {
            System.out.println("Penyimpanan harus lebih dari 0 GB.");
            return;
        }

        this.penyimpanan = penyimpanan;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        if (warna == null || warna.trim().isEmpty()) {
            System.out.println("Warna handphone tidak boleh kosong.");
            return;
        }

        this.warna = warna.trim();
    }

    @Override
    public String getJenisProduk() {
        return "Handphone";
    }

    @Override
    public double hitungHargaAkhir(int jumlah) {
        double total = super.hitungHargaAkhir(jumlah);

        if (jumlah >= 2) {
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
                        " | RAM: %d GB | Penyimpanan: %d GB | Warna: %s",
                        ram,
                        penyimpanan,
                        warna
                );
    }
}
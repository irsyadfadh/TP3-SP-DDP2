public class Obat {

    private String kategori;
    private String nama;
    private int harga;
    private int stok;
    private int jumlahTerjual;
    private int totalPendapatan;

    public Obat(String nama, int stok, String kategori){
        this.nama = nama;
        this.stok = stok;
        this.kategori = kategori;
    }

    // TODO : Implementasi method getter getKategori
    public String getKategori(){
        return this.kategori;
    }

    // TODO : Implementasi method getter getNama
    public String getNama(){
        return this.nama;
    }

    // TODO : Implementasi method getter getHarga
    public int getHarga(){
        return this.harga;
    }

    // TODO : Implementasi method getter getStok
    public int getStok(){
        return this.stok;
    }

    // TODO : Implementasi method setter setKategori
    public void setKategori(String kategori){
        this.kategori = kategori;
    }

    // TODO : Implementasi method setter setNama
    public void setStok(int stok){
        this.stok = stok;
    }

    // TODO : Implementasi method setter setHarga
    public void setHarga(int harga){
        this.harga = harga;
    }

    // tambahan
    public void setTransaksi(int jumlahTerjual, int totalPendapatan) {
        this.jumlahTerjual += jumlahTerjual;
        this.totalPendapatan += totalPendapatan;
    }

    public int getJumlahTerjual() {
        return this.jumlahTerjual;
    }

    public int getTotalPendapatan() {
        return this.totalPendapatan;
    }
}

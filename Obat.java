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

    /*Method ini digunakan untuk mendapatkan kategori obat dalam bentuk string. */
    public String getKategori(){
        return this.kategori;
    }

    /* Method ini digunakan untuk mendapatkan nama obat dalam bentuk string. */
    public String getNama(){
        return this.nama;
    }

    /*Method ini digunakan untuk mendapatkan harga obat dalam bentuk integer. */
    public int getHarga(){
        return this.harga;
    }

    /*Method ini digunakan untuk mendapatkan stok obat dalam bentuk integer. */
    public int getStok(){
        return this.stok;
    }

    /*Method ini digunakan untuk mengubah kategori obat. */
    public void setKategori(String kategori){
        this.kategori = kategori;
    }

    /*Method ini digunakan untuk mengubah stok obat. */
    public void setStok(int stok){
        this.stok = stok;
    }

    /*Method ini digunakan untuk mengubah harga obat */
    public void setHarga(int harga){
        this.harga = harga;
    }

    /*Method ini digunakan untuk mengupdate jumlah terjual dan total pendapatan obat. */
    public void setTransaksi(int jumlahTerjual, int totalPendapatan) {
        this.jumlahTerjual += jumlahTerjual;
        this.totalPendapatan += totalPendapatan;
    }
    //mendapatkan jumlah obat yang terjual dalam bentuk integer.
    public int getJumlahTerjual() {
        return this.jumlahTerjual;
    }
    //mendapatkan total pendapatan dari penjualan obat dalam bentuk integer.
    public int getTotalPendapatan() {
        return this.totalPendapatan;
    }
}

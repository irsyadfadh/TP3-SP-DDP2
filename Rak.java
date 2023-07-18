public class Rak {

    private int size;
    private String kategori;
    private Obat[] daftarObat;

    public Rak(int size, String kategori){
        this.kategori = kategori;
        this.daftarObat = new Obat[size];
        this.size = size;
    }

    /*mendapatkan kategori rak obat dalam bentuk string. */
    public String getKategoriRak() {
        return this.kategori;
    }

    /*menambahkan objek Obat ke dalam array daftarObat pada objek Rak. */
    public void tambahObat(Obat obat, int index) {
        this.daftarObat[index] = obat;
    }
    
    /*mencetak informasi rak obat, termasuk kategori rak, nama obat, dan stok obat. */
    public void printRak() {
        System.out.println(kategori);
        System.out.println("==================");
        for (int i = 0; i < size; i++) {
            if (daftarObat[i] != null) {
                System.out.print("| " + daftarObat[i].getNama() + " (stock: " + daftarObat[i].getStok() + ")");
            } else {
                System.out.print("| kosong ");
            }
        }
        System.out.println();
        System.out.println("==================");
        
    }


    /*mendapatkan array dari objek Obat yang ada pada rak. */
    public Obat[] getListObat() {
        return this.daftarObat;
    }
    
    /*mendapatkan ukuran (jumlah kolom) rak obat dalam bentuk integer. */
    public int getRakSize() {
        return this.size;
    }
    /*mencari rak obat berdasarkan kategori obat. */
    public Rak searchRak(String kategoriObat) {
        if (this.kategori.equals(kategoriObat)) {
            return this;
        }
    return null;
    }
    /*membeli obat dengan jumlah tertentu dari rak obat. */
    public boolean beliObat(Obat obat, int jumlah) {
    for (int i = 0; i < size; i++) {
        if (daftarObat[i] != null && daftarObat[i].getNama().equals(obat.getNama())) {
            if (daftarObat[i].getStok() >= jumlah) {
                daftarObat[i].setStok(daftarObat[i].getStok() - jumlah);
                return true;
            }
            return false;
        }
    }
    return false;
    }
    /*memeriksa apakah suatu objek Obat sudah ada dalam rak obat. */
    public boolean isObatExist(Obat obat) {
        for (Obat o : daftarObat) {
            if (o != null && o.getNama().equalsIgnoreCase(obat.getNama())) {
                return true;
            }
        }
        return false;
    }
    /*mencari obat berdasarkan nama obat dalam rak obat. */
    public Obat searchObat(String namaObat) {
        for (Obat obat : daftarObat) {
            if (obat != null && obat.getNama().equalsIgnoreCase(namaObat)) {
                return obat;
            }
        }
        return null;
    }

}

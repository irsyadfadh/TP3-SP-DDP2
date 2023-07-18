public class Lemari {
  
    private int ukuran;
    private Rak[] rak;

    public Lemari(int ukuran){
        this.ukuran = ukuran;
        rak = new Rak[ukuran];
    }
    /*Method ini digunakan untuk menambahkan objek Rak ke dalam array rak pada objek Lemari */
    public void addRak(Rak rak, int index){
        this.rak[index] = rak;
    }

    /*mencetak informasi dari setiap rak obat yang ada dalam lemari. */
    public void print() {
        for (int i = rak.length - 1; i >= 0; i--) {
            if (rak[i] != null) {
                rak[i].printRak();
                System.out.println();
            }
        }
    }

    /*membeli obat dengan jumlah tertentu dari rak obat yang sesuai dengan kategori obat yang dicari. */
    public boolean beliObat(Obat obat, int jumlah) {
        for (Rak r : rak) {
            if (r != null) {
                if (r.getKategoriRak().equals(obat.getKategori())) {
                    return r.beliObat(obat, jumlah);
                }
            }
        }
        return false;
    }
    

    /*Method ini digunakan untuk mencari obat berdasarkan nama obat dalam lemari. */
    public Obat searchObat(String namaObat) {
        for (Rak rak : rak) {
            if (rak != null) {
                Obat obat = rak.searchObat(namaObat);
                if (obat != null) {
                    return obat;
                }
            }
        }
        return null;
    }


    /*mendapatkan objek Rak pada indeks tertentu dalam array rak. */
    public Rak getRak(int i) {
        if (i >= 0 && i < ukuran) {
            return rak[i];
        }
        return null;
    }

    /*Method ini digunakan untuk mendapatkan ukuran lemari (jumlah rak) dalam bentuk integer. */
    public int getUkuran() {
        return this.ukuran;
    }
    /*Method ini digunakan untuk memeriksa apakah suatu objek Rak memiliki kategori obat yang valid. */
    public boolean isKategoriRakValid(Rak rak, String kategoriObat) {
        if (rak != null && kategoriObat != null) {
            return rak.getKategoriRak().equalsIgnoreCase(kategoriObat);
        }
        return false;
    }

}


public class Rak {

    private int size;
    private String kategori;
    private Obat[] daftarObat;

    public Rak(int size, String kategori){
        this.kategori = kategori;
        this.daftarObat = new Obat[size];
        this.size = size;
    }

    // TODO : Implementasi method getKategoriRak
    public String getKategoriRak() {
        return this.kategori;
    }

    // TODO : Implementasi method tambahObat
    public void tambahObat(Obat obat, int index) {
        this.daftarObat[index] = obat;
    }
    
    // TODO : Implementasi method printRak
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


    // TODO : Implementasi method getListObat
    public Obat[] getListObat() {
        return this.daftarObat;
    }
    
    // tambahan
    public int getRakSize() {
        return this.size;
    }

    public Rak searchRak(String kategoriObat) {
        if (this.kategori.equals(kategoriObat)) {
            return this;
        }
    return null;
    }

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

    public boolean isObatExist(Obat obat) {
        for (Obat o : daftarObat) {
            if (o != null && o.getNama().equalsIgnoreCase(obat.getNama())) {
                return true;
            }
        }
        return false;
    }

    public Obat searchObat(String namaObat) {
        for (Obat obat : daftarObat) {
            if (obat != null && obat.getNama().equalsIgnoreCase(namaObat)) {
                return obat;
            }
        }
        return null;
    }

}

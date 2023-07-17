public class Lemari {
  
    private int ukuran;
    private Rak[] rak;

    public Lemari(int ukuran){
        this.ukuran = ukuran;
        rak = new Rak[ukuran];
    }

    public void addRak(Rak rak, int index){
        this.rak[index] = rak;
    }

    // TODO : Implementasi method print
    public void print() {
        for (int i = rak.length - 1; i >= 0; i--) {
            if (rak[i] != null) {
                rak[i].printRak();
                System.out.println();
            }
        }
    }

    // TODO : Implementasi method beliObat
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
    

    // TODO : Implementasi method searchObat
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


    // TODO : Implementasi method getRak
    public Rak getRak(int i) {
        if (i >= 0 && i < ukuran) {
            return rak[i];
        }
        return null;
    }

    // tambahan
    public int getUkuran() {
        return this.ukuran;
    }

    public boolean isKategoriRakValid(Rak rak, String kategoriObat) {
        if (rak != null && kategoriObat != null) {
            return rak.getKategoriRak().equalsIgnoreCase(kategoriObat);
        }
        return false;
    }

}


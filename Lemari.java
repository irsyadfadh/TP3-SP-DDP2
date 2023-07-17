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
    public void print(){
        for (int i = 0; i < ukuran; i++) {
            System.out.println("Rak ke-" + (i+1) + ": " + rak[i].getKategoriRak());
            rak[i].printRak();
            System.out.println();
        }
    }

    // TODO : Implementasi method beliObat
    public boolean beliObat(Obat obat, int jumlah) {
        Obat obat = searchObat(namaObat);
        if (obat == null) {
            System.out.println("Obat tidak tersedia");
            return false;
        }
        if (obat.getStok() < jumlah) {
            System.out.println("Stok obat tidak mencukupi");
            return false;
        }
        obat.setStok(obat.getStok() - jumlah);
        return true; 
    }

    // TODO : Implementasi method searchObat
    public Obat searchObat(String namaObat) {
        for (Rak r : rak) {
            Obat[] obatList = r.getListObat();
            for (Obat obat : obatList) {
                if (obat != null && obat.getNama().equals(namaObat)) {
                    return obat;
                }
            }
        }
        return null;
    }

    // TODO : Implementasi method getRak
    public Rak getRak(int i) {
        return rak[i];
    }
}

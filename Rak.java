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
        return kategori;
    }

    // TODO : Implementasi method tambahObat
    public void tambahObat(Obat obat, int index) {
        daftarObat[index] = obat;
    }
    
    // TODO : Implementasi method printRak
    public void printRak(){
        for (int i = 0; i < size; i++) {
            if (daftarObat[i] != null) {
                System.out.println("| " + daftarObat[i].getNama() + " (stock: " + daftarObat[i].getStok() + ")");
            } else {
                System.out.println("| kosong");
            }
        }
        System.out.println("==================");
    }

    // TODO : Implementasi method getListObat
    public Obat[] getListObat() {
        return daftarObat;
    }
    
}

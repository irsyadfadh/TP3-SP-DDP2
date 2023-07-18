import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestObat {

    @Test
    public void testGetKategori() {
        Obat obat = new Obat("Paracetamol", 10, "Obat Ringan");
        assertEquals("Obat Ringan", obat.getKategori());
    }

    @Test
    public void testGetNama() {
        Obat obat = new Obat("Paracetamol", 10, "Obat Ringan");
        assertEquals("Paracetamol", obat.getNama());
    }

    @Test
    public void testGetHarga() {
        Obat obat = new Obat("Paracetamol", 10, "Obat Ringan");
        obat.setHarga(5000);
        assertEquals(5000, obat.getHarga());
    }

    @Test
    public void testGetStok() {
        Obat obat = new Obat("Paracetamol", 10, "Obat Ringan");
        assertEquals(10, obat.getStok());
    }

    @Test
    public void testSetKategori() {
        Obat obat = new Obat("Paracetamol", 10, "Obat Ringan");
        obat.setKategori("Obat Berat");
        assertEquals("Obat Berat", obat.getKategori());
    }

    @Test
    public void testSetStok() {
        Obat obat = new Obat("Paracetamol", 10, "Obat Ringan");
        obat.setStok(5);
        assertEquals(5, obat.getStok());
    }

    @Test
    public void testSetHarga() {
        Obat obat = new Obat("Paracetamol", 10, "Obat Ringan");
        obat.setHarga(5000);
        assertEquals(5000, obat.getHarga());
    }

    @Test
    public void testSetTransaksi() {
        Obat obat = new Obat("Paracetamol", 10, "Obat Ringan");
        obat.setTransaksi(5, 5000);
        assertEquals(5, obat.getJumlahTerjual());
        assertEquals(5000, obat.getTotalPendapatan());

        obat.setTransaksi(3, 3000);
        assertEquals(8, obat.getJumlahTerjual());
        assertEquals(8000, obat.getTotalPendapatan());
    }

    @Test
    public void testGetJumlahTerjual() {
        Obat obat = new Obat("Paracetamol", 10, "Obat Ringan");
        obat.setTransaksi(5, 5000);
        assertEquals(5, obat.getJumlahTerjual());
    }

    @Test
    public void testGetTotalPendapatan() {
        Obat obat = new Obat("Paracetamol", 10, "Obat Ringan");
        obat.setTransaksi(5, 5000);
        assertEquals(5000, obat.getTotalPendapatan());
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLemari {

    @Test
    public void testAddRak() {
        Lemari lemari = new Lemari(2);
        Rak rak1 = new Rak(2, "Obat Ringan");
        Rak rak2 = new Rak(3, "Obat Berat");

        lemari.addRak(rak1, 0);
        lemari.addRak(rak2, 1);

        assertEquals(rak1, lemari.getRak(0));
        assertEquals(rak2, lemari.getRak(1));
    }

    @Test
    public void testBeliObat() {
        Lemari lemari = new Lemari(1);
        Rak rak = new Rak(2, "Obat Ringan");
        Obat obat1 = new Obat("Paracetamol", 10, "Obat Ringan");
        Obat obat2 = new Obat("Amoxicillin", 5, "Obat Ringan");

        rak.tambahObat(obat1, 0);
        rak.tambahObat(obat2, 1);
        lemari.addRak(rak, 0);

        assertTrue(lemari.beliObat(obat1, 5));
        assertEquals(5, obat1.getStok());
        assertFalse(lemari.beliObat(obat2, 10));
        assertEquals(5, obat2.getStok());
        assertFalse(lemari.beliObat(obat2, 6));
        assertEquals(5, obat2.getStok());
    }

    @Test
    public void testSearchObat() {
        Lemari lemari = new Lemari(1);
        Rak rak = new Rak(2, "Obat Ringan");
        Obat obat1 = new Obat("Paracetamol", 10, "Obat Ringan");
        Obat obat2 = new Obat("Amoxicillin", 5, "Obat Ringan");

        rak.tambahObat(obat1, 0);
        rak.tambahObat(obat2, 1);
        lemari.addRak(rak, 0);

        assertEquals(obat1, lemari.searchObat("Paracetamol"));
        assertEquals(obat2, lemari.searchObat("Amoxicillin"));
        assertNull(lemari.searchObat("Ibuprofen"));
    }
}


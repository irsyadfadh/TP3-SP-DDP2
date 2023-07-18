import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRak {

    @Test
    public void testGetKategoriRak() {
        Rak rak = new Rak(3, "Obat Ringan");
        assertEquals("Obat Ringan", rak.getKategoriRak());
    }

    @Test
    public void testTambahObat() {
        Rak rak = new Rak(2, "Obat Berat");
        Obat obat1 = new Obat("Paracetamol", 10, "Obat Berat");
        Obat obat2 = new Obat("Amoxicillin", 5, "Obat Berat");

        rak.tambahObat(obat1, 0);
        rak.tambahObat(obat2, 1);

        assertEquals(obat1, rak.getListObat()[0]);
        assertEquals(obat2, rak.getListObat()[1]);
    }

    @Test
    public void testIsObatExist() {
        Rak rak = new Rak(2, "Obat Berat");
        Obat obat1 = new Obat("Paracetamol", 10, "Obat Berat");
        Obat obat2 = new Obat("Amoxicillin", 5, "Obat Berat");
        Obat obat3 = new Obat("Ibuprofen", 3, "Obat Ringan");

        rak.tambahObat(obat1, 0);
        rak.tambahObat(obat2, 1);

        assertTrue(rak.isObatExist(obat1));
        assertTrue(rak.isObatExist(obat2));
        assertFalse(rak.isObatExist(obat3));
    }

    @Test
    public void testSearchObat() {
        Rak rak = new Rak(2, "Obat Ringan");
        Obat obat1 = new Obat("Paracetamol", 10, "Obat Ringan");
        Obat obat2 = new Obat("Amoxicillin", 5, "Obat Ringan");

        rak.tambahObat(obat1, 0);
        rak.tambahObat(obat2, 1);

        assertEquals(obat1, rak.searchObat("Paracetamol"));
        assertEquals(obat2, rak.searchObat("Amoxicillin"));
        assertNull(rak.searchObat("Ibuprofen"));
    }
}


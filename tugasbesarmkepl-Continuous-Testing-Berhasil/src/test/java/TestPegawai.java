import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import model.Pegawai;
import org.junit.Test;

public class TestPegawai {

    @Test
    public void testGetNama() {
        Pegawai pegawai = new Pegawai("John Doe", 30, 5000000);
        assertEquals("John Doe", pegawai.getNama());
    }

    @Test
    public void testGetUmur() {
        Pegawai pegawai = new Pegawai("John Doe", 31, 5000000);
        assertEquals(31, pegawai.getUmur());
    }

    @Test
    public void testGetGaji() {
        Pegawai pegawai = new Pegawai("John Doe", 30, 5000000);
        assertEquals(5000000, pegawai.getGaji(), 0.0);
    }

    @Test
    public void testCompareTo() {
        Pegawai pegawai1 = new Pegawai("John Doe", 30, 5000000);
        Pegawai pegawai2 = new Pegawai("Jane Doe", 25, 6000000);
        assertTrue(pegawai1.compareTo(pegawai2) < 0);
    }

    @Test
    public void testCompareToSameGaji() {
        Pegawai pegawai1 = new Pegawai("John Doe", 30, 5000000);
        Pegawai pegawai2 = new Pegawai("Jane Doe", 25, 5000000);
        assertEquals(0, pegawai1.compareTo(pegawai2));
    }

    @Test
    public void testCompareToHigherGaji() {
        Pegawai pegawai1 = new Pegawai("John Doe", 30, 7000000);
        Pegawai pegawai2 = new Pegawai("Jane Doe", 25, 5000000);
        assertTrue(pegawai1.compareTo(pegawai2) > 0);
    }

    @Test
    public void testGetNamaDifferentNames() {
        Pegawai pegawai1 = new Pegawai("John Doe", 30, 5000000);
        Pegawai pegawai2 = new Pegawai("Jane Doe", 25, 5000000);
        assertNotEquals(pegawai1.getNama(), pegawai2.getNama());
    }

    @Test
    public void testGetUmurDifferentAges() {
        Pegawai pegawai1 = new Pegawai("John Doe", 30, 5000000);
        Pegawai pegawai2 = new Pegawai("Jane Doe", 25, 5000000);
        assertNotEquals(pegawai1.getUmur(), pegawai2.getUmur());
    }

    @Test
    public void testGetGajiDifferentSalaries() {
        Pegawai pegawai1 = new Pegawai("John Doe", 30, 5000000);
        Pegawai pegawai2 = new Pegawai("Jane Doe", 25, 6000000);
        assertNotEquals(pegawai1.getGaji(), pegawai2.getGaji());
    }

    @Test
    public void testPegawaiNamaNull() {
        Pegawai pegawai = new Pegawai(null, 30, 5000000);
        assertEquals(null, pegawai.getNama());
    }

    @Test
    public void testPegawaiNamaEmpty() {
        Pegawai pegawai = new Pegawai("", 30, 5000000);
        assertEquals("", pegawai.getNama());
    }

    @Test
    public void testPegawaiNegativeUmur() {
        Pegawai pegawai = new Pegawai("John Doe", -5, 5000000);
        assertEquals(-5, pegawai.getUmur());
    }

    @Test
    public void testPegawaiNegativeGaji() {
        Pegawai pegawai = new Pegawai("John Doe", 30, -5000000);
        assertEquals(-5000000, pegawai.getGaji(), 0.0);
    }

    @Test
    public void testCompareToEqual() {
        Pegawai pegawai1 = new Pegawai("John Doe", 30, 5000000);
        Pegawai pegawai2 = new Pegawai("John Doe", 30, 5000000);
        assertEquals(0, pegawai1.compareTo(pegawai2));
    }

    @Test
    public void testCompareToNameDifferent() {
        Pegawai pegawai1 = new Pegawai("John Doe", 30, 5000000);
        Pegawai pegawai2 = new Pegawai("John Smith", 30, 5000000);
        assertTrue(pegawai1.compareTo(pegawai2) == 0);
    }

    @Test
    public void testGetNamaNonAlphanumeric() {
        Pegawai pegawai = new Pegawai("J@ne D0e!", 30, 5000000);
        assertEquals("J@ne D0e!", pegawai.getNama());
    }

    @Test
    public void testCompareToNegativeGaji() {
        Pegawai pegawai1 = new Pegawai("John Doe", 30, -5000000);
        Pegawai pegawai2 = new Pegawai("Jane Doe", 25, 6000000);
        assertTrue(pegawai1.compareTo(pegawai2) < 0);
    }

    @Test
    public void testCompareToNegativeBothGaji() {
        Pegawai pegawai1 = new Pegawai("John Doe", 30, -5000000);
        Pegawai pegawai2 = new Pegawai("Jane Doe", 25, -6000000);
        assertTrue(pegawai1.compareTo(pegawai2) > 0);
    }

    @Test
    public void testGetNamaWithWhitespace() {
        Pegawai pegawai = new Pegawai("  John Doe  ", 30, 5000000);
        assertEquals("  John Doe  ", pegawai.getNama());
    }

    @Test
    public void testGetUmurZero() {
        Pegawai pegawai = new Pegawai("John Doe", 0, 5000000);
        assertEquals(0, pegawai.getUmur());
    }

    @Test
    public void testGetGajiZero() {
        Pegawai pegawai = new Pegawai("John Doe", 30, 0);
        assertEquals(0, pegawai.getGaji(), 0.0);
    }

    @Test
    public void testCompareToEqualAgesDifferentGaji() {
        Pegawai pegawai1 = new Pegawai("John Doe", 30, 7000000);
        Pegawai pegawai2 = new Pegawai("John Doe", 30, 5000000);
        assertTrue(pegawai1.compareTo(pegawai2) > 0);
    }

    @Test
    public void testCompareToEqualGajiDifferentAges() {
        Pegawai pegawai1 = new Pegawai("John Doe", 40, 5000000);
        Pegawai pegawai2 = new Pegawai("John Doe", 30, 5000000);
        assertEquals(0, pegawai1.compareTo(pegawai2));
    }

    @Test
    public void testGetNamaLongString() {
        String longName = "a".repeat(1000);
        Pegawai pegawai = new Pegawai(longName, 30, 5000000);
        assertEquals(longName, pegawai.getNama());
    }

    @Test
    public void testCompareToFloatingPointGaji() {
        Pegawai pegawai1 = new Pegawai("John Doe", 30, 5000000.5);
        Pegawai pegawai2 = new Pegawai("Jane Doe", 25, 6000000.5);
        assertTrue(pegawai1.compareTo(pegawai2) < 0);
    }

    @Test
    public void testCompareToLargeGajiDifference() {
        Pegawai pegawai1 = new Pegawai("John Doe", 30, 5000000);
        Pegawai pegawai2 = new Pegawai("Jane Doe", 25, 500000000);
        assertTrue(pegawai1.compareTo(pegawai2) < 0);
    }

}

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;
import model.Kantor;
import model.Pegawai;
import org.junit.Before;
import org.junit.Test;

public class TestKantor {

    /**
     *
     * @author mzaky
     */

    private Kantor kantor;

    @Before
    public void setUp() {
        kantor = new Kantor("Zaky Corporation");
        kantor.tambahPegawai(new Pegawai("Angela", 33, 8000000));
        kantor.tambahPegawai(new Pegawai("Kevin", 38, 5000000));
        kantor.tambahPegawai(new Pegawai("Stanley", 51, 10000000));
    }

    @Test
    public void testTambahPegawai() {
        Pegawai pegawai = new Pegawai("Jim", 30, 7000000);
        kantor.tambahPegawai(pegawai);
        assertTrue(kantor.getDaftarPegawai().contains(pegawai));
    }

    @Test
    public void testHapusPegawai() {
        kantor.hapusPegawai("Angela");
        List<Pegawai> pegawai = kantor.getDaftarPegawai();
        for (Pegawai p : pegawai) {
            assertNotEquals("Angela", p.getNama());
        }
    }

    @Test
    public void testUrutkanSesuaiGaji() {
        kantor.urutkanSesuaiGaji();
        List<Pegawai> pegawai = kantor.getDaftarPegawai();
        assertEquals("Kevin", pegawai.get(0).getNama());
        assertEquals("Angela", pegawai.get(1).getNama());
        assertEquals("Stanley", pegawai.get(2).getNama());
    }

    @Test
    public void testUrutkanSesuaiNama() {
        kantor.urutkanSesuaiNama();
        List<Pegawai> pegawai = kantor.getDaftarPegawai();
        assertEquals("Angela", pegawai.get(0).getNama());
        assertEquals("Kevin", pegawai.get(1).getNama());
        assertEquals("Stanley", pegawai.get(2).getNama());
    }

    @Test
    public void testGetSesuaiUmur() {
        List<Pegawai> pegawai = kantor.getSesuaiUmur(38);
        assertEquals(1, pegawai.size());
        assertEquals("Kevin", pegawai.get(0).getNama());
    }

    // Test cases tambahan
    @Test
    public void testTambahPegawaiDuplicate() {
        Pegawai pegawai = new Pegawai("Angela", 33, 8000000);
        kantor.tambahPegawai(pegawai);
        List<Pegawai> pegawaiList = kantor.getDaftarPegawai();
        int count = 0;
        for (Pegawai p : pegawaiList) {
            if (p.getNama().equals("Angela")) {
                count++;
            }
        }
        assertEquals(2, count);
    }

    @Test
    public void testHapusPegawaiNonExistent() {
        int initialSize = kantor.getDaftarPegawai().size();
        kantor.hapusPegawai("NonExistent");
        assertEquals(initialSize, kantor.getDaftarPegawai().size());
    }

    @Test
    public void testUrutkanSesuaiGajiEmpty() {
        Kantor emptyKantor = new Kantor("Empty Corp");
        emptyKantor.urutkanSesuaiGaji();
        assertTrue(emptyKantor.getDaftarPegawai().isEmpty());
    }

    @Test
    public void testUrutkanSesuaiNamaEmpty() {
        Kantor emptyKantor = new Kantor("Empty Corp");
        emptyKantor.urutkanSesuaiNama();
        assertTrue(emptyKantor.getDaftarPegawai().isEmpty());
    }

    @Test
    public void testGetSesuaiUmurNonExistent() {
        List<Pegawai> pegawai = kantor.getSesuaiUmur(100);
        assertTrue(pegawai.isEmpty());
    }

    @Test
    public void testGetDaftarPegawai() {
        List<Pegawai> pegawai = kantor.getDaftarPegawai();
        assertEquals(3, pegawai.size());
        assertEquals("Angela", pegawai.get(0).getNama());
        assertEquals("Kevin", pegawai.get(1).getNama());
        assertEquals("Stanley", pegawai.get(2).getNama());
    }

    @Test
    public void testTambahDanHapusPegawai() {
        Pegawai pegawai = new Pegawai("Jim", 30, 7000000);
        kantor.tambahPegawai(pegawai);
        assertTrue(kantor.getDaftarPegawai().contains(pegawai));
        kantor.hapusPegawai("Jim");
        assertFalse(kantor.getDaftarPegawai().contains(pegawai));
    }

    @Test
    public void testUrutkanSesuaiNamaWithDuplicates() {
        kantor.tambahPegawai(new Pegawai("Angela", 40, 6000000));
        kantor.urutkanSesuaiNama();
        List<Pegawai> pegawai = kantor.getDaftarPegawai();
        assertEquals("Angela", pegawai.get(0).getNama());
        assertEquals("Angela", pegawai.get(1).getNama());
        assertEquals("Kevin", pegawai.get(2).getNama());
        assertEquals("Stanley", pegawai.get(3).getNama());
    }

    @Test
    public void testUrutkanSesuaiGajiWithDuplicates() {
        kantor.tambahPegawai(new Pegawai("Jim", 30, 5000000));
        kantor.urutkanSesuaiGaji();
        List<Pegawai> pegawai = kantor.getDaftarPegawai();
        assertEquals("Kevin", pegawai.get(0).getNama());
        assertEquals("Jim", pegawai.get(1).getNama());
        assertEquals("Angela", pegawai.get(2).getNama());
        assertEquals("Stanley", pegawai.get(3).getNama());
    }

    @Test
    public void testHapusPegawaiAll() {
        kantor.hapusPegawai("Angela");
        kantor.hapusPegawai("Kevin");
        kantor.hapusPegawai("Stanley");
        assertTrue(kantor.getDaftarPegawai().isEmpty());
    }

    @Test
    public void testUrutkanSesuaiGajiNegativeGaji() {
        Pegawai pegawai = new Pegawai("Negative", 30, -5000000);
        kantor.tambahPegawai(pegawai);
        kantor.urutkanSesuaiGaji();
        List<Pegawai> pegawaiList = kantor.getDaftarPegawai();
        assertEquals("Negative", pegawaiList.get(0).getNama());
    }

    @Test
    public void testUrutkanSesuaiNamaSpecialCharacters() {
        Pegawai pegawai = new Pegawai("@Special&Name", 30, 5000000);
        kantor.tambahPegawai(pegawai);
        kantor.urutkanSesuaiNama();
        List<Pegawai> pegawaiList = kantor.getDaftarPegawai();
        assertEquals("@Special&Name", pegawaiList.get(0).getNama());
    }

    @Test
    public void testGetSesuaiUmurMultiple() {
        kantor.tambahPegawai(new Pegawai("Older Kevin", 38, 6000000));
        List<Pegawai> pegawai = kantor.getSesuaiUmur(38);
        assertEquals(2, pegawai.size());
        assertEquals("Kevin", pegawai.get(0).getNama());
        assertEquals("Older Kevin", pegawai.get(1).getNama());
    }

}

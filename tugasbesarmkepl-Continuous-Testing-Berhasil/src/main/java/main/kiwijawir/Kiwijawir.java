/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main.kiwijawir;

import model.Kantor;
import model.Pegawai;

/**
 *
 * @author mzaky
 */
public class Kiwijawir {

    public static void main(String[] args) {
        Kantor kantor1 = new Kantor("Zaky Corporation");

        kantor1.tambahPegawai(new Pegawai("Angela", 33, 8000000));
        kantor1.tambahPegawai(new Pegawai("Kevin", 38, 5000000));
        kantor1.tambahPegawai(new Pegawai("Stanley", 51, 10000000));
        kantor1.tambahPegawai(new Pegawai("Michael", 41, 15000000));
        kantor1.tambahPegawai(new Pegawai("Pam", 31, 4500000));
        kantor1.tambahPegawai(new Pegawai("Jim", 33, 8500000));
        kantor1.tambahPegawai(new Pegawai("Creed", 55, 7500000));
        kantor1.tambahPegawai(new Pegawai("Dwight", 33, 9000000));
        kantor1.tambahPegawai(new Pegawai("Meredith", 43, 7500000));
        kantor1.tambahPegawai(new Pegawai("Oscar", 38, 8000000));
        kantor1.tambahPegawai(new Pegawai("Phyllis", 46, 8500000));

        kantor1.getDaftarPegawai();

        System.out.println("Daftar awal Pegawai:");

        for (int i = 0; i < kantor1.getDaftarPegawai().size(); i++) {
            System.out.println((i + 1) + " " + kantor1.getDaftarPegawai().get(i).getNama()
                    + " " + kantor1.getDaftarPegawai().get(i).getUmur() + " "
                    + kantor1.getDaftarPegawai().get(i).getGaji());
        }

        System.out.println("");

        System.out.println("Setelah Angela dihapus:");

        kantor1.hapusPegawai("Angela");
        for (int i = 0; i < kantor1.getDaftarPegawai().size(); i++) {
            System.out.println((i + 1) + " " + kantor1.getDaftarPegawai().get(i).getNama() + " "
                    + kantor1.getDaftarPegawai().get(i).getUmur() + " " + kantor1.getDaftarPegawai().get(i).getGaji());
        }

        System.out.println("");

        System.out.println("Setelah diurutkan sesuai gaji:");
        System.out.println("");
        kantor1.urutkanSesuaiGaji();

        for (int i = 0; i < kantor1.getDaftarPegawai().size(); i++) {
            System.out.println((i + 1) + " " + kantor1.getDaftarPegawai().get(i).getNama() + " "
                    + kantor1.getDaftarPegawai().get(i).getUmur() + " " + kantor1.getDaftarPegawai().get(i).getGaji());
        }

        System.out.println("");

        System.out.println("Setelah diurutkan sesuai nama:");

        kantor1.urutkanSesuaiNama();

        for (int i = 0; i < kantor1.getDaftarPegawai().size(); i++) {
            System.out.println((i + 1) + " " + kantor1.getDaftarPegawai().get(i).getNama() + " "
                    + kantor1.getDaftarPegawai().get(i).getUmur() + " " + kantor1.getDaftarPegawai().get(i).getGaji());
        }

        System.out.println("");
        System.out.println("Setelah difilter sesuai umur:");

        int umur = 38;
        for (int i = 0; i < kantor1.getSesuaiUmur(umur).size(); i++) {
            System.out.println((i + 1) + " " + kantor1.getSesuaiUmur(umur).get(i).getNama() + " "
                    + kantor1.getSesuaiUmur(umur).get(i).getUmur() + " "
                    + kantor1.getSesuaiUmur(umur).get(i).getGaji());
        }
    }
}

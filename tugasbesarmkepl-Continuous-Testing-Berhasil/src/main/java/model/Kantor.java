/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import komparasi.komparatorNama;

/**
 *
 * @author mzaky
 */
public class Kantor {

    private String nama;
    private List<Pegawai> daftarPegawai;

    public Kantor(String n) {
        nama = n;
        daftarPegawai = new ArrayList<>();
    }

    public List<Pegawai> getDaftarPegawai() {
        return daftarPegawai;
    }

    public void tambahPegawai(Pegawai peg) {
        daftarPegawai.add(peg);
    }

    public void hapusPegawai(String namaPeg) {
        for (int i = 0; i < daftarPegawai.size(); i++) {
            if (daftarPegawai.get(i).getNama().equals(namaPeg)) {
                daftarPegawai.remove(i);
                break;
            }
        }
    }

    public void urutkanSesuaiGaji() {
        Collections.sort(daftarPegawai);
    }

    public void urutkanSesuaiNama() {
        Collections.sort(daftarPegawai, new komparatorNama());
    }
    

    public ArrayList<Pegawai> getSesuaiUmur(int umur) {
        return daftarPegawai.stream().filter(Pegawai -> Pegawai.getUmur() == umur).collect(Collectors.toCollection(ArrayList::new ));
    }

}

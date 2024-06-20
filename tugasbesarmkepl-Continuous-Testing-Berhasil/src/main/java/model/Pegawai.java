/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mzaky
 */
public class Pegawai implements Comparable<Pegawai>{

    private String nama;
    private int umur;
    private double gaji;

    public Pegawai(String n, int u, double g) {
        nama = n;
        umur = u;
        gaji = g;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public double getGaji() {
        return gaji;
    }

    @Override
    public int compareTo(Pegawai obj) {
        if (this.gaji < obj.gaji) {
            return -1;
        } else if (this.gaji > obj.gaji) {
            return 1;
        } else {
            return 0;
        }
    }

}
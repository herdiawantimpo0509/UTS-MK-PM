package com.herdiawan.f52124016.aplikasi_uts;

public class Pahlawan {
    private final String nama;
    private final String keterangan;
    private final String asal;
    private final int gambar;

    public Pahlawan(String nama, String keterangan, String asal, int gambar) {
        this.nama = nama;
        this.keterangan = keterangan;
        this.asal = asal;
        this.gambar = gambar;
    }

    public String getNama() { return nama; }
    public String getKeterangan() { return keterangan; }
    public String getAsal() { return asal; }
    public int getGambar() { return gambar; }
}

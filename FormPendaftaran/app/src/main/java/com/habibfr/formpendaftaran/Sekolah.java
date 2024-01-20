package com.habibfr.formpendaftaran;

import java.io.Serializable;

public class Sekolah implements Serializable {
    String tipeSekolah, namaSekolah, alamat, kodePost, profinsi, kota, noTel, email, fb;
    int id, jumlahSiswa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sekolah() {
    }

    public Sekolah(int id, String tipeSekolah, String namaSekolah, String alamat, String kodePost, String profinsi, String kota, String noTel, String email, String fb, int jumlahSiswa) {
        this.id = id;
        this.tipeSekolah = tipeSekolah;
        this.namaSekolah = namaSekolah;
        this.alamat = alamat;
        this.kodePost = kodePost;
        this.profinsi = profinsi;
        this.kota = kota;
        this.noTel = noTel;
        this.email = email;
        this.fb = fb;
        this.jumlahSiswa = jumlahSiswa;
    }

    public String getTipeSekolah() {
        return tipeSekolah;
    }

    public void setTipeSekolah(String tipeSekolah) {
        this.tipeSekolah = tipeSekolah;
    }

    public String getNamaSekolah() {
        return namaSekolah;
    }

    public void setNamaSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKodePost() {
        return kodePost;
    }

    public void setKodePost(String kodePost) {
        this.kodePost = kodePost;
    }

    public String getProfinsi() {
        return profinsi;
    }

    public void setProfinsi(String profinsi) {
        this.profinsi = profinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getNoTel() {
        return noTel;
    }

    public void setNoTel(String noTel) {
        this.noTel = noTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public int getJumlahSiswa() {
        return jumlahSiswa;
    }

    public void setJumlahSiswa(int jumlahSiswa) {
        this.jumlahSiswa = jumlahSiswa;
    }
}

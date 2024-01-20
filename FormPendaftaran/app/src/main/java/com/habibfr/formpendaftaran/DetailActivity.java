package com.habibfr.formpendaftaran;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView editTextNamaSekolah, editTextAlamat, editTextKodePos, editTextNoTel, editTextEmail, editTextFb, editTextJumlahSiswa, editTipe, editProvinsi, editKota;
    int id;
    Sekolah sekolah;
    SekolahDatabase sekolahDatabase;


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Tambahkan tombol kembali di ActionBar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Detail Sekolah");
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        editTipe = findViewById(R.id.et_detail_tipe_sekolah);
        editKota = findViewById(R.id.et_detail_kota);
        editProvinsi = findViewById(R.id.et_detail_provinsi);

        editTextNamaSekolah = findViewById(R.id.et_detail_nama_sekolah);
        editTextKodePos = findViewById(R.id.et_detail_kode_pos);
        editTextNoTel = findViewById(R.id.et_detail_no_telp);
        editTextAlamat = findViewById(R.id.et_detail_alamat);
        editTextEmail = findViewById(R.id.et_detail_email);
        editTextFb = findViewById(R.id.et_detail_facebook);
        editTextJumlahSiswa = findViewById(R.id.et_detail_jumlah_siswa);

        sekolah = new Sekolah();
        sekolahDatabase = new SekolahDatabase(getApplicationContext());

        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getIntExtra("id", -1);
            sekolah = sekolahDatabase.readSekolahById(id);

            editKota.setText(sekolah.getKota());
            editKota.setEnabled(false);
            editKota.setAlpha(1);
            editKota.setTextColor(Color.BLACK);

            editProvinsi.setText(sekolah.getProfinsi());
            editProvinsi.setEnabled(false);
            editProvinsi.setAlpha(1);
            editProvinsi.setTextColor(Color.BLACK);


            editTipe.setText(sekolah.getTipeSekolah());
            editTipe.setEnabled(false);
            editTipe.setTextColor(Color.BLACK);


            editTextNamaSekolah.setText(sekolah.getNamaSekolah().toString());
            editTextNamaSekolah.setEnabled(false);
            editTextNamaSekolah.setTextColor(Color.BLACK);


            editTextAlamat.setText(sekolah.getAlamat().toString());
            editTextAlamat.setEnabled(false);
            editTextAlamat.setTextColor(Color.BLACK);


            editTextKodePos.setText(sekolah.getKodePost());
            editTextKodePos.setEnabled(false);
            editTextKodePos.setTextColor(Color.BLACK);


            editTextNoTel.setText(sekolah.getNoTel());
            editTextNoTel.setEnabled(false);
            editTextNoTel.setTextColor(Color.BLACK);


            editTextEmail.setText(sekolah.getEmail());
            editTextEmail.setEnabled(false);
            editTextEmail.setTextColor(Color.BLACK);


            editTextFb.setText(sekolah.getFb());
            editTextFb.setEnabled(false);
            editTextFb.setTextColor(Color.BLACK);


            editTextJumlahSiswa.setText(String.valueOf(sekolah.getJumlahSiswa()));
            editTextJumlahSiswa.setEnabled(false);
            editTextJumlahSiswa.setTextColor(Color.BLACK);
        }
    }
}
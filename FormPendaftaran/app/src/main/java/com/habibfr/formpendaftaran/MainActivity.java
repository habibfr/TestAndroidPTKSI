package com.habibfr.formpendaftaran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner_tipe_sekolah, spinner_provinsi, spinner_kota;
    String[] tipe_sekolah = {"Pilih Tipe Sekolah", "Negri", "Swasta"};
    String[] provinsi = {"Pilih Provinsi Sekolah", "Jawa Timur", "Jawa Tengah", "Jawa Barat"};
    String[][] daftar_kota = {{"Kota Tidak Ditemukan"}, {"Surabaya", "Sidoarjo", "Gresik"}, {"Semarang", "Jogja", "Surakarta"}, {"Bandung", "Cikarang", "Tanggerang"}};
    ArrayAdapter ad_tipe_sekolah, ad_provinsi;
    ArrayAdapter<String> adapterKota;
    String[] kotaSelected;
    EditText editTextNamaSekolah, editTextAlamat, editTextKodePos, editTextNoTel, editTextEmail, editTextFb, editTextJumlahSiswa;

    String tipeSekolah, namaSekolah, alamat, kodePost, profinsi, kota, noTel, email, fb;
    int jumlahSiswa;
    SekolahDatabase sekolahDatabase;

    Button btnSubmit;
    ArrayList<Sekolah> sekolahArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_tipe_sekolah = findViewById(R.id.spinner_tipe_sekolah);
        spinner_provinsi = findViewById(R.id.spinner_provinsi);
        spinner_kota = findViewById(R.id.spinner_kota_kabupaten);

        editTextNamaSekolah = findViewById(R.id.et_nama_sekolah);
        editTextKodePos = findViewById(R.id.et_kode_pos);
        editTextNoTel = findViewById(R.id.et_no_telp);
        editTextAlamat = findViewById(R.id.et_alamat);
        editTextEmail = findViewById(R.id.et_email);
        editTextFb = findViewById(R.id.et_facebook);
        editTextJumlahSiswa = findViewById(R.id.et_jumlah_siswa);

        btnSubmit = findViewById(R.id.btnSubmit);

        sekolahDatabase = new SekolahDatabase(this.getApplicationContext());


        // tipe sekolah
        ad_tipe_sekolah = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tipe_sekolah);

        ad_tipe_sekolah.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tipe_sekolah.setAdapter(ad_tipe_sekolah);

        // provinsi dan kota
        ad_provinsi = new ArrayAdapter(this, android.R.layout.simple_spinner_item, provinsi);
        ad_provinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_provinsi.setAdapter(ad_provinsi);
        spinner_kota.setAdapter(adapterKota);

        spinner_provinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                kotaSelected = daftar_kota[i];

                adapterKota = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, kotaSelected);
                spinner_kota.setAdapter(adapterKota);
                adapterKota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipeSekolah = spinner_tipe_sekolah.getSelectedItem().toString();
                namaSekolah = editTextNamaSekolah.getText().toString().trim();
                alamat = editTextAlamat.getText().toString().trim();
                kodePost = editTextKodePos.getText().toString().trim();
                profinsi = spinner_provinsi.getSelectedItem().toString().trim();
                kota = spinner_kota.getSelectedItem().toString().trim();
                noTel = editTextNoTel.getText().toString().trim();
                email = editTextEmail.getText().toString().trim();
                fb = editTextFb.getText().toString();

                if (editTextJumlahSiswa.getText().toString().isEmpty() || editTextJumlahSiswa.getText().toString().equals("")) {
                    jumlahSiswa = 0;
//                    Toast.makeText(MainActivity.this, "Jumlah Siswa Tidak Valid [1-100]", Toast.LENGTH_SHORT).show();
                } else {
                    jumlahSiswa = Integer.parseInt(editTextJumlahSiswa.getText().toString().trim());
                }

                // Validate the data
                if (tipeSekolah.isEmpty() || namaSekolah.isEmpty() || alamat.isEmpty() || kodePost.isEmpty() || profinsi.isEmpty() || kota.isEmpty() || noTel.isEmpty() || email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Data Tidak Valid, Isi Semua Data", Toast.LENGTH_SHORT).show();
                } else {
                    if (jumlahSiswa < 1 || jumlahSiswa > 100) {
                        Toast.makeText(MainActivity.this, "Jumlah Siswa Tidak Valid [1-100]", Toast.LENGTH_SHORT).show();
                    } else {
                        if (fb.isEmpty()) {
                            fb = " ";
                        }

                        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                            Toast.makeText(MainActivity.this, "Email Tidak Valid", Toast.LENGTH_SHORT).show();
                        } else {
                            sekolahDatabase.addNewSekolah(tipeSekolah, namaSekolah, alamat, kodePost, profinsi, kota, noTel, email, fb, jumlahSiswa);
                            Toast.makeText(MainActivity.this, "Sukse simpan data!", Toast.LENGTH_SHORT).show();
                            reset();
                        }


                    }

                }
            }
        });


    }

    public void reset() {
        spinner_tipe_sekolah.setSelection(0);
        editTextNamaSekolah.setText("");
        editTextAlamat.setText("");
        editTextKodePos.setText("");
        spinner_provinsi.setSelection(0);
        spinner_kota.setSelection(0);
        editTextNoTel.setText("");
        editTextEmail.setText("");
        editTextFb.setText("");
        editTextJumlahSiswa.setText("");
    }
}
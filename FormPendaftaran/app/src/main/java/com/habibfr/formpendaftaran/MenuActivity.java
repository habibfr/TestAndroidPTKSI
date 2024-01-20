package com.habibfr.formpendaftaran;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btnMenuAdd, btnMenuDaftarSekolah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Tambahkan tombol kembali di ActionBar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Menu");
        actionBar.setDisplayHomeAsUpEnabled(false);

        btnMenuAdd = findViewById(R.id.btnMenuAdd);
        btnMenuDaftarSekolah = findViewById(R.id.btnMenuDaftarSekolah);

        btnMenuAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnMenuDaftarSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ReadActivity.class);
                startActivity(intent);
            }
        });
    }
}
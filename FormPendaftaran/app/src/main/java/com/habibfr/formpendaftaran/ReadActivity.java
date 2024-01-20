package com.habibfr.formpendaftaran;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {

    ListView lvDaftarListSekolah;
    ArrayList<Sekolah> sekolahArrayList;
    SekolahAdapter sekolahAdapter;

    SekolahDatabase sekolahDatabase;
    TextView test;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        // Tambahkan tombol kembali di ActionBar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Daftar Sekolah");
        actionBar.setDisplayHomeAsUpEnabled(true);

        lvDaftarListSekolah = findViewById(R.id.lvListSekolah);

        sekolahDatabase = new SekolahDatabase(getApplicationContext());
        sekolahArrayList = new ArrayList<>();

        sekolahArrayList = sekolahDatabase.readSekolah();
        sekolahAdapter = new SekolahAdapter(getApplicationContext(), sekolahArrayList);


        sekolahAdapter.notifyDataSetChanged();
        lvDaftarListSekolah.setAdapter(sekolahAdapter);

        lvDaftarListSekolah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(ReadActivity.this, "test" + i, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ReadActivity.this, DetailActivity.class);
                Integer id = sekolahArrayList.get(i).getId();
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}
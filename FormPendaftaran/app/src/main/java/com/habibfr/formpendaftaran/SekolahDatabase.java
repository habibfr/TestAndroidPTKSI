package com.habibfr.formpendaftaran;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SekolahDatabase extends SQLiteOpenHelper {

    // nama tabel
    public static final String DATABASE_NAME = "sekolah.db";
    // below int is our database version
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "tbl_sekolah";

    // kolom tabel
    public static final String COL_ID = "id";
    public static final String COL_TIPE = "tipe";
    public static final String COL_NAMA = "nama";
    public static final String COL_ALAMAT = "alamat";
    public static final String COL_KODE_POS = "kode_pos";
    public static final String COL_PROVINSI = "provinsi";
    public static final String COL_KOTA = "kota";
    public static final String COL_TELP = "no_telp";
    public static final String COL_EMAIL = "email";
    public static final String COL_FACEBOOK = "facebook";
    public static final String COL_JUMLAH_SISWA = "jumlah_siswa";

    // sql untuk membuat tabel
    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_TIPE + " TEXT," +
                    COL_NAMA + " TEXT," +
                    COL_ALAMAT + " TEXT," +
                    COL_KODE_POS + " TEXT," +
                    COL_PROVINSI + " TEXT," +
                    COL_KOTA + " TEXT," +
                    COL_TELP + " TEXT," +
                    COL_EMAIL + " TEXT," +
                    COL_FACEBOOK + " TEXT," +
                    COL_JUMLAH_SISWA + " INTEGER" +
                    ")";

    public SekolahDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public void addNewSekolah(String tipeSekolah, String namaSekolah, String alamat, String kodePos, String profinsi, String kota, String noTel, String email, String fb, int jumlahSiswa) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(COL_TIPE, tipeSekolah);
        values.put(COL_NAMA, namaSekolah);
        values.put(COL_ALAMAT, alamat);
        values.put(COL_KODE_POS, kodePos);
        values.put(COL_PROVINSI, profinsi);
        values.put(COL_KOTA, kota);
        values.put(COL_TELP, noTel);
        values.put(COL_EMAIL, email);
        values.put(COL_FACEBOOK, fb);
        values.put(COL_JUMLAH_SISWA, jumlahSiswa);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // we have created a new method for reading all the courses.
    public ArrayList<Sekolah> readSekolah() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorSekolah = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<Sekolah> sekolahModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorSekolah.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                sekolahModalArrayList.add(
                        new Sekolah(
                                cursorSekolah.getInt(0),
                                cursorSekolah.getString(1),
                                cursorSekolah.getString(2),
                                cursorSekolah.getString(3),
                                cursorSekolah.getString(4),
                                cursorSekolah.getString(5),
                                cursorSekolah.getString(6),
                                cursorSekolah.getString(7),
                                cursorSekolah.getString(8),
                                cursorSekolah.getString(9),
                                cursorSekolah.getInt(10)
                        )
                );
            } while (cursorSekolah.moveToNext());
            // moving our cursor to next.
        }

        // at last closing our cursor
        // and returning our array list.
        cursorSekolah.close();
        return sekolahModalArrayList;
    }

    public Sekolah readSekolahById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Sekolah sekolah = new Sekolah();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ID + " = ?", new String[]{String.valueOf(id)});


        if (cursor != null) {
            cursor.moveToFirst();
            sekolah = new Sekolah(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getInt(10)
            );
        }
        assert cursor != null;
        cursor.close();

        return sekolah;
    }


}
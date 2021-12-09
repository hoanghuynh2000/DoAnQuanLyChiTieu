package com.example.quanli;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.print.PrinterId;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERTION = 2;
    private static final String DATABASE_NAME = "QUANLICHITIEU";
    //Tạo SQlite
    //Bảng Đăng kí
    private static final String TABLE_DANGKI = "DANGKI";
    private static final String COL_ID = "_id";
    private static final String COL_TEN = "TEN";
    private static final String COL_SODIENTHOAI="SODIENTHOAI";
    private static final String COL_MAPIN = "MAPIN";
    private static final String COL_NHAPLAIMAPIN = "NHAPLAIMAPIN";
    private static final String COL_SODU="SODU";
    private static final String COL_THUNGAY="THUNGAY";
    private static final String COL_CHINGAY="CHINGAY";
    //Bảng Thu Chi
    private static final String TABLE_THUCHI = "THUCHI";
    public static final String COL_IDTHUCHI="_id";
    public static final String COL_THOIGIAN="THOIGIAN";
    public static final String COL_THANG="THANG";
    public static final String COL_NGAY="NGAY";
    public static final String COL_SOTIEN="SOTIEN";
    public static final String COL_PHANLOAI="PHANLOAI";
    public static final String COL_KHOANTHUCHI="KHOANTHUCHI";
    public static final String COL_GHICHU="GHICHU";


    //Tạo bảng
    private static final String SQL_CREATE_KHACHHANG = "CREATE TABLE " + TABLE_DANGKI + " (" + COL_ID +
            " INTEGER PRIMARY KEY," + COL_TEN + " TEXT," + COL_SODIENTHOAI + " TEXT," +COL_MAPIN + " TEXT,"
            + COL_NHAPLAIMAPIN + " TEXT," + COL_SODU + " TEXT," + COL_CHINGAY + " TEXT," + COL_THUNGAY +" TEXT )" ;
    private static final String SQL_CREATE_THUCHI=" CREATE TABLE " + TABLE_THUCHI + " ("+COL_IDTHUCHI+" INTEGER PRIMARY KEY, "
            +COL_THOIGIAN+" TEXT, "+COL_SOTIEN +" TEXT, "+COL_THANG+" TEXT ,"+COL_NGAY+" TEXT ,"+
            COL_PHANLOAI+" TEXT, "+COL_KHOANTHUCHI+" TEXT, "+COL_GHICHU+" TEXT )";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERTION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_KHACHHANG);
        db.execSQL(SQL_CREATE_THUCHI);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      //  db.execSQL("DROP TABLE IF EXISTS " + TABLE_DANGKI);

        onCreate(db);
    }
    public void AddThuChi( String thoigian ,String thang,String ngay, String sotien, String phanloai , String khoanthuchi, String ghichu)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_THOIGIAN, thoigian);
        values.put(COL_THANG,thang);
        values.put(COL_NGAY,ngay);
        values.put(COL_SOTIEN, sotien);
        values.put(COL_PHANLOAI,phanloai);
        values.put(COL_KHOANTHUCHI,khoanthuchi);
        values.put(COL_GHICHU,ghichu);
        // Inserting Row
        db.insert(TABLE_THUCHI, null, values);
        db.close();
    }
    public Cursor getAllThuchi(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor =db.query(TABLE_THUCHI, new String[] {COL_IDTHUCHI,COL_THOIGIAN,COL_THANG,COL_NGAY,COL_SOTIEN,COL_PHANLOAI,COL_KHOANTHUCHI,COL_GHICHU},null,null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }
    //thêm Tài khoản vào bảng
    public void AddDangKi(DoiTuong doiTuong) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ID,doiTuong.getIddangki());
        values.put(COL_TEN, doiTuong.getHoten());
        values.put(COL_SODIENTHOAI,doiTuong.getSodienthoai());
        values.put(COL_MAPIN, doiTuong.getMapin());
        values.put(COL_NHAPLAIMAPIN, doiTuong.getNhaplaimapin());
        values.put(COL_SODU,doiTuong.getSodu());
        values.put(COL_CHINGAY,doiTuong.getChingay());
        values.put(COL_THUNGAY,doiTuong.getThungay());
        db.insert(TABLE_DANGKI, null, values);
        db.close();
    }
    public boolean UdSoDu(DoiTuong doiTuong){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_SODU, doiTuong.getSodu());
        int data = db.update(TABLE_DANGKI,values,COL_ID+"=?",new String []{String.valueOf(doiTuong.getIddangki())});
        db.close();
        return data>0;
    }
    public boolean udThungay(DoiTuong doiTuong){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_THUNGAY, doiTuong.getThungay());
        int data = db.update(TABLE_DANGKI,values,COL_ID+"=?",new String []{String.valueOf(doiTuong.getIddangki())});
        db.close();
        return data>0;
    }
    public boolean udChingay(DoiTuong doiTuong){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_CHINGAY, doiTuong.getChingay());
        int data = db.update(TABLE_DANGKI,values,COL_ID+"=?",new String []{String.valueOf(doiTuong.getIddangki())});
        db.close();
        return data>0;
    }
    public ArrayList<DoiTuong> getAllKH() {
        ArrayList<DoiTuong> listKH = new ArrayList<DoiTuong>();
        String selectQuery = "SELECT  * FROM " + TABLE_DANGKI;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cs = db.rawQuery(selectQuery, null);
        if (cs.moveToFirst()) {
            do {
                DoiTuong kh = new DoiTuong();
                kh.setIddangki(Integer.parseInt(cs.getString(0)));
                kh.setHoten(cs.getString(1));
                kh.setSodienthoai(cs.getString(2));
                kh.setMapin(cs.getString(3));
                kh.setNhaplaimapin(cs.getString(4));

                listKH.add(kh);
            } while (cs.moveToNext());
        }
        return listKH;
    }

    public int getThuChiCount() {
        String countQuery = "SELECT * FROM " + TABLE_THUCHI;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getKHCount() {
        String countQuery = "SELECT  * FROM " + TABLE_DANGKI;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    public int UpdateTHUCHI(THUCHI thuchi) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_IDTHUCHI,thuchi.getIdthuchi());
        values.put(COL_THOIGIAN, thuchi.getNgayThang());
        values.put(COL_SOTIEN,thuchi.getSoTien());
        values.put(COL_PHANLOAI,thuchi.getPhanLoai());
        values.put(COL_KHOANTHUCHI, thuchi.getKhoanThuChi());

        return db.update(TABLE_THUCHI, values, COL_IDTHUCHI + "=?", new String[]{String.valueOf(thuchi.getIdthuchi())});
    }
    public DoiTuong getDoiTuong(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_DANGKI;

        Cursor cs = db.rawQuery(selectQuery, null);
        DoiTuong kh = new DoiTuong();
        if (cs.moveToFirst()) {
            do {
                int madk=Integer.parseInt(cs.getString(0));
                if(id==madk) {
                    kh.setIddangki(Integer.parseInt(cs.getString(0)));
                    kh.setHoten(cs.getString(1));
                    kh.setSodienthoai(cs.getString(2));
                    kh.setMapin(cs.getString(3));
                    kh.setNhaplaimapin(cs.getString(4));
                    kh.setSodu(cs.getString(5));
                    kh.setChingay(cs.getString(6));
                    kh.setThungay(cs.getString(7));
                    return kh;
                }
            } while (cs.moveToNext());
        }
        db.close();
        return kh;
    }
    public int UpdateKH(DoiTuong doiTuong) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_ID,doiTuong.getIddangki());
        values.put(COL_TEN, doiTuong.getHoten());
        values.put(COL_SODIENTHOAI,doiTuong.getSodienthoai());
        values.put(COL_MAPIN,doiTuong.getMapin());
        values.put(COL_NHAPLAIMAPIN, doiTuong.getNhaplaimapin());
        values.put(COL_SODU,doiTuong.getSodu());
        values.put(COL_THUNGAY,doiTuong.getThungay());
        values.put(COL_CHINGAY,doiTuong.getChingay());
        return db.update(TABLE_DANGKI, values, COL_ID + "=?", new String[]{String.valueOf(doiTuong.getIddangki())});
    }
    public int CheckSoDu(String mk) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT "+COL_ID+" ,"+COL_MAPIN+" FROM " + TABLE_DANGKI, null);
        String matKhau;
        if (cs.moveToFirst()) {
            do {
                matKhau=cs.getString(1);
                int id=Integer.parseInt(cs.getString(0));
                if (matKhau.equals(mk)){
                    db.close();
                    return  id;
                }
            } while (cs.moveToNext());
        }
        db.close();
        return 0;
    }
    public boolean Check(String mk) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT "+COL_ID+" ,"+COL_MAPIN+" FROM " + TABLE_DANGKI, null);
        String matKhau;
        if (cs.moveToFirst()) {
            do {
                matKhau=cs.getString(1);

                    if (mk.equals(matKhau)){

                        db.close();
                        return true;
                    }
            } while (cs.moveToNext());
        }
        db.close();
        return false;

    }
}

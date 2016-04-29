package com.example.admin.emergencyservicecontact;

/**
 * Created by Admin on 27/04/2016.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    //Database
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "databaseESC.db";
    private SQLiteDatabase db;
    //Table nations
    public static final String TABLE_NATIONS = "tblNations";
    public static final String COLUMN_ID_NATION = "_id";
    public static final String COLUMN_CODE_NATION = "nationCode";
    public static final String COLUMN_NAME_NATION = "nationName";
    public static final String COLUMN_SERVICETYPE_NATION = "serviceType";
    public static final String COLUMN_PHONENUMBER_NATION = "phoneNumber";
    //Table numbers
    /*
    public static final String TABLE_NUMBERS = "tblNumbers";
    public static final String COLUMN_ID_NUMBER = "_id";
    public static final String COLUMN_NATIONCODE_NUMBER = "nationCode";
    public static final String COLUMN_SERVICETYPE_NUMBER = "serviceType";
    public static final String COLUMN_PHONENUMBER_NUMBER = "phoneNumber";
    */

    public DbHandler(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table nation
        String query = "CREATE TABLE "+TABLE_NATIONS+" ("
                +COLUMN_ID_NATION+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COLUMN_CODE_NATION+" TEXT, "
                +COLUMN_NAME_NATION+" TEXT, "
                +COLUMN_SERVICETYPE_NATION+" TEXT, "
                +COLUMN_PHONENUMBER_NATION+" TEXT"
                +");";
        db.execSQL(query);

        //inputData();
        /*
        String query2 = "CREATE TABLE "+TABLE_NUMBERS+" ("
                +COLUMN_ID_NUMBER+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COLUMN_NATIONCODE_NUMBER+" TEXT, "
                +COLUMN_SERVICETYPE_NUMBER+" TEXT, "
                +COLUMN_PHONENUMBER_NUMBER+" INTEGER, "
                +"FOREIGN KEY("+COLUMN_NATIONCODE_NUMBER+") REFERENCES "+TABLE_NATIONS+"("+COLUMN_ID_NATION+")"
                +");";
        db.execSQL(query2);
        */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TABLE_NATIONS);
        //db.execSQL("DROP TABLE IF EXIST "+TABLE_NUMBERS);
        onCreate(db);
    }

    public void inputToTableNations(String nationCode, String nationName, String serviceType, String phoneNumber) {
        ContentValues values = new ContentValues();
        db = getWritableDatabase();

        values.put(COLUMN_CODE_NATION, nationCode);
        values.put(COLUMN_NAME_NATION, nationName);
        values.put(COLUMN_SERVICETYPE_NATION, serviceType);
        values.put(COLUMN_PHONENUMBER_NATION, phoneNumber);
        db.insert(TABLE_NATIONS, null, values);

        db.close();
    }

    /*
    public void inputToTableNumbers(String nationCode, String serviceType, int phoneNumber) {
        ContentValues values = new ContentValues();
        db = getWritableDatabase();

        values.put(COLUMN_NATIONCODE_NUMBER, nationCode);
        values.put(COLUMN_SERVICETYPE_NUMBER, serviceType);
        values.put(COLUMN_PHONENUMBER_NUMBER, phoneNumber);
        db.insert(TABLE_NUMBERS, null, values);

        db.close();
    }
    */

    public void inputData() {
        //inputting data to table nations
        inputToTableNations("AFG","Afghanistan","Police","119");
        inputToTableNations("AFG","Afghanistan","Medical","102");
        inputToTableNations("AFG","Afghanistan","Fire","119");
        inputToTableNations("ALB","Albania","Police","129");
        inputToTableNations("ALB","Albania","Medical","127");
        inputToTableNations("ALB","Albania","Fire","128");
        inputToTableNations("DZA","Algeria","Police","17");
        inputToTableNations("DZA","Algeria","Medical","14");
        inputToTableNations("DZA","Algeria","Fire","14");
        inputToTableNations("ARG","Argentina","Police","101");
        inputToTableNations("ARG","Argentina","Medical","107");
        inputToTableNations("ARG","Argentina","Fire","100");
        inputToTableNations("ARM","Armenia","Police","102");
        inputToTableNations("ARM","Armenia","Medical","103");
        inputToTableNations("ARM","Armenia","Fire","101");
        inputToTableNations("AUS","Australia","General","000");
        inputToTableNations("AUT","Austria","General","112");
        inputToTableNations("AUT","Austria","Police","133");
        inputToTableNations("AUT","Austria","Medical","144");
        inputToTableNations("AUT","Austria","Fire","122");
        inputToTableNations("BHR","Bahrain","General","999");
        inputToTableNations("BGD","Bangladesh","Police","999");
        //timi input
        inputToTableNations("BRB","Bsrbados","Police","211");
        inputToTableNations("BRB","Barbados","Medical","511");
        inputToTableNations("BRB","Barbados","Fire","311");
        inputToTableNations("BLR","Belarus","Police","102");
        inputToTableNations("BLR","Belarus","Medical","103");
        inputToTableNations("BLR","Belarus","Fire","101");
        inputToTableNations("BEL","Belgium","General","112");
        inputToTableNations("BEL","Belgium","Police","101");
        inputToTableNations("BEL","Belgium","Medical","100");
        inputToTableNations("BEL","Belgium","Fire","100");
        inputToTableNations("BOL","Bolivia","Police","110");
        inputToTableNations("BOL","Bolivia","Medical","118");
        inputToTableNations("BOL","Bolivia","Fire","119");
        inputToTableNations("BIH","Bosnia and Herzegovina","General","112");
        inputToTableNations("BIH","Bosnia and Herzegovina","Police","122");
        inputToTableNations("BIH","Bosnia and Herzegovina","Medical","124");
        inputToTableNations("BIH","Bosnia and Herzegovina","Fire","123");
        inputToTableNations("BRA","Brazil","Police","190");
        inputToTableNations("BRA","Brazil","Medical","192");
        inputToTableNations("BRA","Brazil","Fire","193");
        inputToTableNations("BGR","Bulgaria","General","112");
        inputToTableNations("BGR","Bulgaria","Police","192");
        inputToTableNations("BGR","Bulgaria","Medical","194");
        inputToTableNations("BGR","Bulgaria","Fire","193");
        inputToTableNations("CAN","Canada","General","911");
        inputToTableNations("CYM","Cayman Islands","General","911");
        inputToTableNations("TCD","Chad","Police","17");
        inputToTableNations("TCD","Chad","Medical","22514242");
        inputToTableNations("CHL","Chile","Police","113");
        inputToTableNations("CHL","Chile","Medical","131");
        inputToTableNations("CHL","Chile","Fire","132");
        inputToTableNations("CHN","China","General","112");
        inputToTableNations("CHN","China","Police","110");
        inputToTableNations("CHN","China","Medical","120");
        inputToTableNations("COL","Colombia","General","123");
        inputToTableNations("COL","Colombia","Police","112");
        inputToTableNations("COL","Colombia","Medical","125");
        inputToTableNations("COL","Colombia","Fire","119");
        inputToTableNations("CRI","Costa Rica","General","911");
        inputToTableNations("HRV","Croatia","General","112");
        inputToTableNations("HRV","Croatia","Police","192");
        inputToTableNations("HRV","Croatia","Medical","194");
        inputToTableNations("HRV","Croatia","Fire","193");
        inputToTableNations("CYP","Cyprus","General","112");

        inputToTableNations("CZE","R. Czech","General","112");
        inputToTableNations("CZE","R. Czech","Police","158");
        inputToTableNations("CZE","R. Czech","Medical","155");
        inputToTableNations("CZE","R. Czech","Fire","150");
        inputToTableNations("DNK","Denmark","General","112");
        inputToTableNations("DJI","Djibouti","Police","17");
        inputToTableNations("DJI","Djibouti","Medical","19");
        inputToTableNations("DOM","R. Dominican","General","911");
        inputToTableNations("ECU","Ecuador","General","911");
        inputToTableNations("ECU","Ecuador","Police","101");
        inputToTableNations("ECU","Ecuador","Medical","131");
        inputToTableNations("ECU","Ecuador","Fire","102");
        inputToTableNations("EGY","Egypt","Police","122");
        inputToTableNations("EGY","Egypt","Medical","123");
        inputToTableNations("EGY","Egypt","Fire","180");
        inputToTableNations("SLV","El Salvador","Police","911");
        inputToTableNations("EST","Estonia","General","112");
        inputToTableNations("FRO","Faroe Islands","General","112");
        inputToTableNations("FJI","Fiji","General","0");
        inputToTableNations("FIN","Finland","General","112");
        inputToTableNations("FRA","France","General","112");
        inputToTableNations("FRA","France","Police","17");
        inputToTableNations("FRA","France","Medical","15");
        inputToTableNations("FRA","France","Fire","18");
        inputToTableNations("GUF","French Guiana","Police","17");
        inputToTableNations("GUF","French Guiana","Medical","15");
        inputToTableNations("GUF","French Guiana","Fire","18");
        //stop dulu
        /*inputToTableNations("BGR","Bulgaria","Medical","194");
        inputToTableNations("BGR","Bulgaria","Fire","193");
        inputToTableNations("CAN","Canada","General","911");
        inputToTableNations("CYM","Cayman Islands","General","911");
        inputToTableNations("TCD","Chad","Police","17");
        inputToTableNations("TCD","Chad","Medical","22514242");
        inputToTableNations("CHL","Chile","Police","113");
        inputToTableNations("CHL","Chile","Medical","131");
        inputToTableNations("CHL","Chile","Fire","132");
        inputToTableNations("CHN","China, People's Republic of","General","112");
        inputToTableNations("CHN","China, People's Republic of","Police","110");
        inputToTableNations("CHN","China, People's Republic of","Medical","120");
        inputToTableNations("COL","Colombia","General","123");
        inputToTableNations("COL","Colombia","Police","112");
        inputToTableNations("COL","Colombia","Medical","125");
        inputToTableNations("COL","Colombia","Fire","119");
        inputToTableNations("CRI","Costa Rica","General","911");
        inputToTableNations("HRV","Croatia","General","112");
        inputToTableNations("HRV","Croatia","Police","192");
        inputToTableNations("HRV","Croatia","Medical","194");
        inputToTableNations("HRV","Croatia","Fire","193");
        inputToTableNations("CYP","Cyprus","General","112");
        inputToTableNations("BGR","Bulgaria","General","112");
        inputToTableNations("BGR","Bulgaria","Police","192");
        inputToTableNations("BGR","Bulgaria","Medical","194");
        inputToTableNations("BGR","Bulgaria","Fire","193");
        inputToTableNations("CAN","Canada","General","911");
        inputToTableNations("CYM","Cayman Islands","General","911");
        inputToTableNations("TCD","Chad","Police","17");
        inputToTableNations("TCD","Chad","Medical","22514242");
        inputToTableNations("CHL","Chile","Police","113");
        inputToTableNations("CHL","Chile","Medical","131");
        inputToTableNations("CHL","Chile","Fire","132");
        inputToTableNations("CHN","China, People's Republic of","General","112");
        inputToTableNations("CHN","China, People's Republic of","Police","110");
        inputToTableNations("CHN","China, People's Republic of","Medical","120");
        inputToTableNations("COL","Colombia","General","123");
        inputToTableNations("COL","Colombia","Police","112");
        inputToTableNations("COL","Colombia","Medical","125");
        inputToTableNations("COL","Colombia","Fire","119");
        inputToTableNations("CRI","Costa Rica","General","911");
        inputToTableNations("HRV","Croatia","General","112");
        inputToTableNations("HRV","Croatia","Police","192");
        inputToTableNations("HRV","Croatia","Medical","194");
        inputToTableNations("HRV","Croatia","Fire","193");
        inputToTableNations("CYP","Cyprus","General","112");
        inputToTableNations("BGR","Bulgaria","General","112");
        inputToTableNations("BGR","Bulgaria","Police","192");
        inputToTableNations("BGR","Bulgaria","Medical","194");
        inputToTableNations("BGR","Bulgaria","Fire","193");
        inputToTableNations("CAN","Canada","General","911");
        inputToTableNations("CYM","Cayman Islands","General","911");
        inputToTableNations("TCD","Chad","Police","17");
        inputToTableNations("TCD","Chad","Medical","22514242");
        inputToTableNations("CHL","Chile","Police","113");
        inputToTableNations("CHL","Chile","Medical","131");
        inputToTableNations("CHL","Chile","Fire","132");
        inputToTableNations("CHN","China, People's Republic of","General","112");
        inputToTableNations("CHN","China, People's Republic of","Police","110");
        inputToTableNations("CHN","China, People's Republic of","Medical","120");
        inputToTableNations("COL","Colombia","General","123");
        inputToTableNations("COL","Colombia","Police","112");
        inputToTableNations("COL","Colombia","Medical","125");
        inputToTableNations("COL","Colombia","Fire","119");
        inputToTableNations("CRI","Costa Rica","General","911");
        inputToTableNations("HRV","Croatia","General","112");
        inputToTableNations("HRV","Croatia","Police","192");
        inputToTableNations("HRV","Croatia","Medical","194");
        inputToTableNations("HRV","Croatia","Fire","193");
        inputToTableNations("CYP","Cyprus","General","112");
        inputToTableNations("BGR","Bulgaria","General","112");
        inputToTableNations("BGR","Bulgaria","Police","192");
        inputToTableNations("BGR","Bulgaria","Medical","194");
        inputToTableNations("BGR","Bulgaria","Fire","193");
        inputToTableNations("CAN","Canada","General","911");
        inputToTableNations("CYM","Cayman Islands","General","911");
        inputToTableNations("TCD","Chad","Police","17");
        inputToTableNations("TCD","Chad","Medical","22514242");
        inputToTableNations("CHL","Chile","Police","113");
        inputToTableNations("CHL","Chile","Medical","131");
        inputToTableNations("CHL","Chile","Fire","132");
        inputToTableNations("CHN","China, People's Republic of","General","112");
        inputToTableNations("CHN","China, People's Republic of","Police","110");
        inputToTableNations("CHN","China, People's Republic of","Medical","120");
        inputToTableNations("COL","Colombia","General","123");
        inputToTableNations("COL","Colombia","Police","112");
        inputToTableNations("COL","Colombia","Medical","125");
        inputToTableNations("COL","Colombia","Fire","119");
        inputToTableNations("CRI","Costa Rica","General","911");
        inputToTableNations("HRV","Croatia","General","112");
        inputToTableNations("HRV","Croatia","Police","192");
        inputToTableNations("HRV","Croatia","Medical","194");
        inputToTableNations("HRV","Croatia","Fire","193");
        inputToTableNations("CYP","Cyprus","General","112");
        inputToTableNations("BGR","Bulgaria","General","112");
        inputToTableNations("BGR","Bulgaria","Police","192");
        inputToTableNations("BGR","Bulgaria","Medical","194");
        inputToTableNations("BGR","Bulgaria","Fire","193");
        inputToTableNations("CAN","Canada","General","911");
        inputToTableNations("CYM","Cayman Islands","General","911");
        inputToTableNations("TCD","Chad","Police","17");
        inputToTableNations("TCD","Chad","Medical","22514242");
        inputToTableNations("CHL","Chile","Police","113");
        inputToTableNations("CHL","Chile","Medical","131");
        inputToTableNations("CHL","Chile","Fire","132");
        inputToTableNations("CHN","China, People's Republic of","General","112");
        inputToTableNations("CHN","China, People's Republic of","Police","110");
        inputToTableNations("CHN","China, People's Republic of","Medical","120");
        inputToTableNations("COL","Colombia","General","123");
        inputToTableNations("COL","Colombia","Police","112");
        inputToTableNations("COL","Colombia","Medical","125");
        inputToTableNations("COL","Colombia","Fire","119");
        inputToTableNations("CRI","Costa Rica","General","911");
        inputToTableNations("HRV","Croatia","General","112");
        inputToTableNations("HRV","Croatia","Police","192");
        inputToTableNations("HRV","Croatia","Medical","194");
        inputToTableNations("HRV","Croatia","Fire","193");
        inputToTableNations("CYP","Cyprus","General","112");
        inputToTableNations("BGR","Bulgaria","General","112");
        inputToTableNations("BGR","Bulgaria","Police","192");
        inputToTableNations("BGR","Bulgaria","Medical","194");
        inputToTableNations("BGR","Bulgaria","Fire","193");
        inputToTableNations("CAN","Canada","General","911");
        inputToTableNations("CYM","Cayman Islands","General","911");
        inputToTableNations("TCD","Chad","Police","17");
        inputToTableNations("TCD","Chad","Medical","22514242");
        inputToTableNations("CHL","Chile","Police","113");
        inputToTableNations("CHL","Chile","Medical","131");
        inputToTableNations("CHL","Chile","Fire","132");
        inputToTableNations("CHN","China, People's Republic of","General","112");
        inputToTableNations("CHN","China, People's Republic of","Police","110");
        inputToTableNations("CHN","China, People's Republic of","Medical","120");
        inputToTableNations("COL","Colombia","General","123");
        inputToTableNations("COL","Colombia","Police","112");
        inputToTableNations("COL","Colombia","Medical","125");
        inputToTableNations("COL","Colombia","Fire","119");
        inputToTableNations("CRI","Costa Rica","General","911");
        inputToTableNations("HRV","Croatia","General","112");
        inputToTableNations("HRV","Croatia","Police","192");
        inputToTableNations("HRV","Croatia","Medical","194");
        inputToTableNations("HRV","Croatia","Fire","193");
        inputToTableNations("CYP","Cyprus","General","112");
        inputToTableNations("BGR","Bulgaria","General","112");
        inputToTableNations("BGR","Bulgaria","Police","192");
        inputToTableNations("BGR","Bulgaria","Medical","194");
        inputToTableNations("BGR","Bulgaria","Fire","193");
        inputToTableNations("CAN","Canada","General","911");
        inputToTableNations("CYM","Cayman Islands","General","911");
        inputToTableNations("TCD","Chad","Police","17");
        inputToTableNations("TCD","Chad","Medical","22514242");
        inputToTableNations("CHL","Chile","Police","113");
        inputToTableNations("CHL","Chile","Medical","131");
        inputToTableNations("CHL","Chile","Fire","132");
        inputToTableNations("CHN","China, People's Republic of","General","112");
        inputToTableNations("CHN","China, People's Republic of","Police","110");
        inputToTableNations("CHN","China, People's Republic of","Medical","120");
        inputToTableNations("COL","Colombia","General","123");
        inputToTableNations("COL","Colombia","Police","112");
        inputToTableNations("COL","Colombia","Medical","125");
        inputToTableNations("COL","Colombia","Fire","119");
        inputToTableNations("CRI","Costa Rica","General","911");
        inputToTableNations("HRV","Croatia","General","112");
        inputToTableNations("HRV","Croatia","Police","192");
        inputToTableNations("HRV","Croatia","Medical","194");
        inputToTableNations("HRV","Croatia","Fire","193");
        inputToTableNations("CYP","Cyprus","General","112");
        inputToTableNations("BGR","Bulgaria","General","112");
        inputToTableNations("BGR","Bulgaria","Police","192");
        inputToTableNations("BGR","Bulgaria","Medical","194");
        inputToTableNations("BGR","Bulgaria","Fire","193");
        inputToTableNations("CAN","Canada","General","911");
        inputToTableNations("CYM","Cayman Islands","General","911");
        inputToTableNations("TCD","Chad","Police","17");
        inputToTableNations("TCD","Chad","Medical","22514242");
        inputToTableNations("CHL","Chile","Police","113");
        inputToTableNations("CHL","Chile","Medical","131");
        inputToTableNations("CHL","Chile","Fire","132");
        inputToTableNations("CHN","China, People's Republic of","General","112");
        inputToTableNations("CHN","China, People's Republic of","Police","110");
        inputToTableNations("CHN","China, People's Republic of","Medical","120");
        inputToTableNations("COL","Colombia","General","123");
        inputToTableNations("COL","Colombia","Police","112");
        inputToTableNations("COL","Colombia","Medical","125");
        inputToTableNations("COL","Colombia","Fire","119");
        inputToTableNations("CRI","Costa Rica","General","911");
        inputToTableNations("HRV","Croatia","General","112");
        inputToTableNations("HRV","Croatia","Police","192");
        inputToTableNations("HRV","Croatia","Medical","194");
        inputToTableNations("HRV","Croatia","Fire","193");
        inputToTableNations("CYP","Cyprus","General","112");
        inputToTableNations("BGR","Bulgaria","General","112");
        inputToTableNations("BGR","Bulgaria","Police","192");
        inputToTableNations("BGR","Bulgaria","Medical","194");
        inputToTableNations("BGR","Bulgaria","Fire","193");
        inputToTableNations("CAN","Canada","General","911");
        inputToTableNations("CYM","Cayman Islands","General","911");
        inputToTableNations("TCD","Chad","Police","17");
        inputToTableNations("TCD","Chad","Medical","22514242");
        inputToTableNations("CHL","Chile","Police","113");
        inputToTableNations("CHL","Chile","Medical","131");
        inputToTableNations("CHL","Chile","Fire","132");
        inputToTableNations("CHN","China, People's Republic of","General","112");
        inputToTableNations("CHN","China, People's Republic of","Police","110");
        inputToTableNations("CHN","China, People's Republic of","Medical","120");
        inputToTableNations("COL","Colombia","General","123");
        inputToTableNations("COL","Colombia","Police","112");
        inputToTableNations("COL","Colombia","Medical","125");
        inputToTableNations("COL","Colombia","Fire","119");
        inputToTableNations("CRI","Costa Rica","General","911");
        inputToTableNations("HRV","Croatia","General","112");
        inputToTableNations("HRV","Croatia","Police","192");
        inputToTableNations("HRV","Croatia","Medical","194");
        inputToTableNations("HRV","Croatia","Fire","193");
        inputToTableNations("CYP","Cyprus","General","112");*/
        //inputting data to table numbers
    }

    //utk populate data dalam spinner
    public ArrayList<String> getNationName () {
        ArrayList<String> list = new ArrayList<String>();
        db = getReadableDatabase();

        try {
            String query = "SELECT DISTINCT nationName FROM tblNations";
            Cursor cursor = db.rawQuery(query, null);
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    String nationname = cursor.getString(cursor.getColumnIndex("nationName"));
                    list.add(nationname);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        db.close();
        return list;
    }

    //ambil data utk ditaruh di listview service page (dynamic) sesuai nation yang dipilih
    public ArrayList<ListData> getData(String nation) {

        db = getReadableDatabase();
        ArrayList<ListData> myListData = new ArrayList<ListData>();
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        try {
            String query =  "SELECT serviceType, phoneNumber " +
                            "FROM tblNations " +
                            "WHERE nationName= \""+nation+"\"";
            Cursor cursor = db.rawQuery(query, null);
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    String servicetype = cursor.getString(cursor.getColumnIndex("serviceType"));
                    String phonenumber = cursor.getString(cursor.getColumnIndex("phoneNumber"));

                    ListData listdata = new ListData(servicetype, phonenumber);
                    myListData.add(listdata);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        db.close();
        return myListData;
    }
}

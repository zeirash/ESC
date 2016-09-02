package com.example.admin.emergencyservicecontact;

/**
 * Created by Admin on 27/04/2016.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
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

    public void inputData() {
        //inputting data to table nations
        //============================== A =============================
        inputToTableNations("AFG","Afghanistan","Police","119");
        inputToTableNations("AFG","Afghanistan","Medical","102");
        inputToTableNations("AFG","Afghanistan","Fire","119");
        inputToTableNations("ALA","Alan Islands","General","112");
        inputToTableNations("ALB","Albania","General","112");
        inputToTableNations("ALB","Albania","Police","129");
        inputToTableNations("ALB","Albania","Medical","127");
        inputToTableNations("ALB","Albania","Fire","128");
        inputToTableNations("DZA","Algeria","Police","17");
        inputToTableNations("DZA","Algeria","Medical","14");
        inputToTableNations("DZA","Algeria","Fire","14");
        inputToTableNations("ASM","American Samoa","General","911");
        inputToTableNations("AND","Andorra","General","112");
        inputToTableNations("AND","Andorra","Police","110");
        inputToTableNations("AND","Andorra","Medical","118");
        inputToTableNations("AND","Andorra","Fire","118");
        inputToTableNations("AGO","Angola","Police","113");
        inputToTableNations("AGO","Angola","Medical","112");
        inputToTableNations("AGO","Angola","Fire","115");
        inputToTableNations("ATA","Antarctica","General","911");
        inputToTableNations("ATG","Antigua & Barbuda","General","911");
        inputToTableNations("ARG","Argentina","General","911");
        inputToTableNations("ARG","Argentina","Police","101");
        inputToTableNations("ARG","Argentina","Medical","107");
        inputToTableNations("ARG","Argentina","Fire","100");
        inputToTableNations("ARM","Armenia","General","112");
        inputToTableNations("ARM","Armenia","Police","102");
        inputToTableNations("ARM","Armenia","Medical","103");
        inputToTableNations("ARM","Armenia","Fire","101");
        inputToTableNations("ABW","Aruba","General","911");
        inputToTableNations("SHA","Ascension Island","General","999");
        inputToTableNations("AUS","Australia","General","000");
        inputToTableNations("AUT","Austria","General","112");
        inputToTableNations("AUT","Austria","Police","133");
        inputToTableNations("AUT","Austria","Medical","144");
        inputToTableNations("AUT","Austria","Fire","122");
        inputToTableNations("AZE","Azerbaijan","General","112");
        inputToTableNations("AZE","Azerbaijan","Police","102");
        inputToTableNations("AZE","Azerbaijan","Medical","103");
        inputToTableNations("AZE","Azerbaijan","Fire","101");
        //============================== B =============================
        inputToTableNations("BHS","Bahamas","General","911");
        inputToTableNations("BHR","Bahrain","General","999");
        inputToTableNations("BGD","Bangladesh","Police","999");
        inputToTableNations("BRB","Barbados","General","911");
        inputToTableNations("BRB","Barbados","Police","211");
        inputToTableNations("BRB","Barbados","Medical","511");
        inputToTableNations("BRB","Barbados","Fire","311");
        inputToTableNations("BLR","Belarus","Police","102");
        inputToTableNations("BLR","Belarus","Medical","103");
        inputToTableNations("BLR","Belarus","Fire","101");
        inputToTableNations("BEL","Belgium","General","112");
        inputToTableNations("BEL","Belgium","Police","101");
        inputToTableNations("BEL","Belgium","Medical","100");
        inputToTableNations("BEL","Belgium","Fire","100");
        inputToTableNations("BEN","Benin","Police","117");
        inputToTableNations("BEN","Benin","Medical","112");
        inputToTableNations("BEN","Benin","Fire","118");
        inputToTableNations("BMU","Bermuda","General","911");
        inputToTableNations("BTN","Bhutan","Police","113");
        inputToTableNations("BTN","Bhutan","Medical","112");
        inputToTableNations("BTN","Bhutan","Fire","110");
        inputToTableNations("BOL","Bolivia","General","911");
        inputToTableNations("BOL","Bolivia","Police","110");
        inputToTableNations("BOL","Bolivia","Medical","118");
        inputToTableNations("BOL","Bolivia","Fire","119");
        inputToTableNations("BES","Bonaire","General","911");
        inputToTableNations("BIH","Bosnia and Herzegovina","General","112");
        inputToTableNations("BIH","Bosnia and Herzegovina","Police","122");
        inputToTableNations("BIH","Bosnia and Herzegovina","Medical","124");
        inputToTableNations("BIH","Bosnia and Herzegovina","Fire","123");
        inputToTableNations("BWA","Botswana","General","911");
        inputToTableNations("BWA","Botswana","Police","999");
        inputToTableNations("BWA","Botswana","Medical","997");
        inputToTableNations("BWA","Botswana","Fire","998");
        inputToTableNations("BRA","Brazil","Police","190");
        inputToTableNations("BRA","Brazil","Medical","192");
        inputToTableNations("BRA","Brazil","Fire","193");
        inputToTableNations("VGB","British Virgin Islands","General","911");
        inputToTableNations("BRN","Brunei Darussalam","Police","993");
        inputToTableNations("BRN","Brunei Darussalam","Medical","991");
        inputToTableNations("BRN","Brunei Darussalam","Fire","995");
        inputToTableNations("BGR","Bulgaria","General","112");
        inputToTableNations("BGR","Bulgaria","Police","192");
        inputToTableNations("BGR","Bulgaria","Medical","194");
        inputToTableNations("BGR","Bulgaria","Fire","193");
        inputToTableNations("BFA","Burkina Faso","Police","17");
        inputToTableNations("BFA","Burkina Faso","Medical","112");
        inputToTableNations("BFA","Burkina Faso","Fire","18");
        inputToTableNations("BDI","Burundi","Police","117");
        inputToTableNations("BDI","Burundi","Medical","112");
        inputToTableNations("BDI","Burundi","Fire","118");
        //============================== C =============================
        inputToTableNations("KHM","Cambodia","Police","117");
        inputToTableNations("KHM","Cambodia","Medical","119");
        inputToTableNations("KHM","Cambodia","Fire","118");
        inputToTableNations("CMR","Cameroon","General","112");
        inputToTableNations("CMR","Cameroon","Police","117");
        inputToTableNations("CMR","Cameroon","Medical","119");
        inputToTableNations("CMR","Cameroon","Fire","118");
        inputToTableNations("CAN","Canada","General","911");
        inputToTableNations("CPV","Cape Verde","Police","132");
        inputToTableNations("CPV","Cape Verde","Medical","130");
        inputToTableNations("CPV","Cape Verde","Fire","131");
        inputToTableNations("CYM","Cayman Islands","General","911");
        inputToTableNations("CAF","Central African Republic","Police","117");
        inputToTableNations("CAF","Central African Republic","Medical","1220");
        inputToTableNations("CAF","Central African Republic","Fire","118");
        inputToTableNations("TCD","Chad","Police","17");
        inputToTableNations("TCD","Chad","Medical","22514242");
        inputToTableNations("TCD","Chad","Fire","18");
        inputToTableNations("CHL","Chile","Police","113");
        inputToTableNations("CHL","Chile","Medical","131");
        inputToTableNations("CHL","Chile","Fire","132");
        inputToTableNations("CHN","China","General","112");
        inputToTableNations("CHN","China","Police","110");
        inputToTableNations("CHN","China","Medical","120");
        inputToTableNations("CHN","China","Fire","119");
        inputToTableNations("COL","Colombia","General","123");
        inputToTableNations("COL","Colombia","Police","112");
        inputToTableNations("COL","Colombia","Medical","125");
        inputToTableNations("COL","Colombia","Fire","119");
        inputToTableNations("COM","Comoros","Police","17");
        inputToTableNations("COM","Comoros","Medical","7720373");
        inputToTableNations("COG","Congo Republic","Police","117");
        inputToTableNations("COG","Congo Republic","Fire","118");
        inputToTableNations("COD","Congo Democratic Rep.","Police","112");
        inputToTableNations("COD","Congo Democratic Rep.","Fire","118");
        inputToTableNations("COK","Cook Islands","Police","999");
        inputToTableNations("COK","Cook Islands","Medical","998");
        inputToTableNations("COK","Cook Islands","Fire","996");
        inputToTableNations("CRI","Costa Rica","General","911");
        inputToTableNations("HRV","Croatia","General","112");
        inputToTableNations("HRV","Croatia","Police","192");
        inputToTableNations("HRV","Croatia","Medical","194");
        inputToTableNations("HRV","Croatia","Fire","193");
        inputToTableNations("CUB","Cuba","Police","106");
        inputToTableNations("CUB","Cuba","Medical","104");
        inputToTableNations("CUB","Cuba","Fire","105");
        inputToTableNations("CYP","Cyprus","General","112");
        inputToTableNations("CZE","Czech Republic","General","112");
        inputToTableNations("CZE","Czech Republic","Police","158");
        inputToTableNations("CZE","Czech Republic","Medical","155");
        inputToTableNations("CZE","Czech Republic","Fire","150");
        //============================== D =============================
        inputToTableNations("DNK","Denmark","General","112");
        inputToTableNations("DJI","Djibouti","Police","17");
        inputToTableNations("DJI","Djibouti","Medical","19");
        inputToTableNations("DJI","Djibouti","Fire","18");
        inputToTableNations("DMA","Dominica","General","999");
        inputToTableNations("DOM","Dominican Republic","General","911");
        //============================== E =============================
        inputToTableNations("ECU","Ecuador","General","911");
        inputToTableNations("ECU","Ecuador","Police","101");
        inputToTableNations("ECU","Ecuador","Medical","131");
        inputToTableNations("ECU","Ecuador","Fire","102");
        inputToTableNations("EGY","Egypt","Police","122");
        inputToTableNations("EGY","Egypt","Medical","123");
        inputToTableNations("EGY","Egypt","Fire","180");
        inputToTableNations("SLV","El Salvador","Police","911");
        inputToTableNations("SLV","El Salvador","Medical","132");
        inputToTableNations("SLV","El Salvador","Fire","913");
        inputToTableNations("GNQ","Equatorial Guinea","Police","114");
        inputToTableNations("GNQ","Equatorial Guinea","Medical","112");
        inputToTableNations("GNQ","Equatorial Guinea","Fire","115");
        inputToTableNations("ERI","Eritrea","Police","113");
        inputToTableNations("ERI","Eritrea","Medical","114");
        inputToTableNations("ERI","Eritrea","Fire","116");
        inputToTableNations("EST","Estonia","General","112");
        inputToTableNations("ETH","Ethiopia","General","911");
        inputToTableNations("ETH","Ethiopia","Police","991");
        inputToTableNations("ETH","Ethiopia","Medical","907");
        inputToTableNations("ETH","Ethiopia","Fire","938");
        //============================== F =============================
        inputToTableNations("FLK","Falkland Islands","General","112");
        inputToTableNations("FRO","Faroe Islands","General","112");
        inputToTableNations("FJI","Fiji","General","0");
        inputToTableNations("FIN","Finland","General","112");
        inputToTableNations("FRA","France","General","112");
        inputToTableNations("FRA","France","Police","17");
        inputToTableNations("FRA","France","Medical","15");
        inputToTableNations("FRA","France","Fire","18");
        inputToTableNations("GUF","French Guiana","General","112");
        inputToTableNations("GUF","French Guiana","Police","17");
        inputToTableNations("GUF","French Guiana","Medical","15");
        inputToTableNations("GUF","French Guiana","Fire","18");
        inputToTableNations("PYF","French Polynesia","General","112");
        inputToTableNations("PYF","French Polynesia","Police","17");
        inputToTableNations("PYF","French Polynesia","Medical","15");
        inputToTableNations("PYF","French Polynesia","Fire","18");
        //============================== G =============================
        inputToTableNations("GAB","Gabon","Police","1730");
        inputToTableNations("GAB","Gabon","Medical","1300");
        inputToTableNations("GAB","Gabon","Fire","18");
        inputToTableNations("GMB","Gambia","Police","117");
        inputToTableNations("GMB","Gambia","Medical","116");
        inputToTableNations("GMB","Gambia","Fire","118");
        inputToTableNations("GEO","Georgia","General","112");
        inputToTableNations("DEU","Germany","General","112");
        inputToTableNations("DEU","Germany","Police","110");
        inputToTableNations("GHA","Ghana","General","999");
        inputToTableNations("GHA","Ghana","Police","191");
        inputToTableNations("GHA","Ghana","Medical","193");
        inputToTableNations("GHA","Ghana","Fire","192");
        inputToTableNations("GIB","Gibraltar","General","112");
        inputToTableNations("GIB","Gibraltar","Police","199");
        inputToTableNations("GIB","Gibraltar","Medical","190");
        inputToTableNations("GIB","Gibraltar","Fire","190");
        inputToTableNations("GRC","Greece","General","112");
        inputToTableNations("GRC","Greece","Police","100");
        inputToTableNations("GRC","Greece","Medical","166");
        inputToTableNations("GRC","Greece","Fire","199");
        inputToTableNations("GRL","Greenland","General","112");
        inputToTableNations("GRD","Grenada","General","911");
        inputToTableNations("GUM","Guam","General","911");
        inputToTableNations("GTM","Guatemala","Police","110");
        inputToTableNations("GTM","Guatemala","Medical","128");
        inputToTableNations("GTM","Guatemala","Fire","122");
        inputToTableNations("GLP","Guadeloupe","General","112");
        inputToTableNations("GLP","Guadeloupe","Police","17");
        inputToTableNations("GLP","Guadeloupe","Medical","15");
        inputToTableNations("GLP","Guadeloupe","Fire","18");
        inputToTableNations("GIN","Guinea","Police","112");
        inputToTableNations("GIN","Guinea","Medical","442020");
        inputToTableNations("GIN","Guinea","Fire","1717");
        inputToTableNations("GNB","Guinea-Bissau","General","112");
        inputToTableNations("GNB","Guinea-Bissau","Police","117");
        inputToTableNations("GNB","Guinea-Bissau","Medical","119");
        inputToTableNations("GNB","Guinea-Bissau","Fire","118");
        inputToTableNations("GGY","Guernsey","General","112");
        inputToTableNations("GUY","Guyana","General","999");
        inputToTableNations("GUY","Guyana","Police","911");
        inputToTableNations("GUY","Guyana","Medical","913");
        inputToTableNations("GUY","Guyana","Fire","912");
        //============================== H =============================
        inputToTableNations("HTI","Haiti","Police","114");
        inputToTableNations("HTI","Haiti","Medical","116");
        inputToTableNations("HTI","Haiti","Fire","115");
        inputToTableNations("HND","Honduras","General","199");
        inputToTableNations("HKG","Hong Kong","General","999");
        inputToTableNations("HUN","Hungary","General","112");
        inputToTableNations("HUN","Hungary","Police","107");
        inputToTableNations("HUN","Hungary","Medical","104");
        inputToTableNations("HUN","Hungary","Fire","105");
        //============================== I =============================
        inputToTableNations("ISL","Iceland","General","112");
        inputToTableNations("IND","India","General","112");
        inputToTableNations("IDN","Indonesia","General","112");
        inputToTableNations("IDN","Indonesia","Police","110");
        inputToTableNations("IDN","Indonesia","Medical","118");
        inputToTableNations("IDN","Indonesia","Fire","113");
        inputToTableNations("IRN","Iran","Police","110");
        inputToTableNations("IRN","Iran","Medical","115");
        inputToTableNations("IRN","Iran","Fire","125");
        inputToTableNations("IRQ","Iraq","General","112");
        inputToTableNations("IRQ","Iraq","Police","104");
        inputToTableNations("IRQ","Iraq","Medical","122");
        inputToTableNations("IRQ","Iraq","Fire","115");
        inputToTableNations("IRL","Ireland","General","112");
        inputToTableNations("IMN","Isle of Man","General","112");
        inputToTableNations("ISR","Israel","General","112");
        inputToTableNations("ISR","Israel","Police","100");
        inputToTableNations("ISR","Israel","Medical","101");
        inputToTableNations("ISR","Israel","Fire","102");
        inputToTableNations("ITA","Italy","General","112");
        inputToTableNations("ITA","Italy","Police","113");
        inputToTableNations("ITA","Italy","Medical","118");
        inputToTableNations("ITA","Italy","Fire","115");
        inputToTableNations("CIV","Ivory Coast","Police","111");
        inputToTableNations("CIV","Ivory Coast","Medical","185");
        inputToTableNations("CIV","Ivory Coast","Fire","180");
        //============================== J =============================
        inputToTableNations("JAM","Jamaica","Police","119");
        inputToTableNations("JAM","Jamaica","Medical","110");
        inputToTableNations("JAM","Jamaica","Fire","110");
        inputToTableNations("JPN","Japan","Police","110");
        inputToTableNations("JPN","Japan","Medical","119");
        inputToTableNations("JPN","Japan","Fire","119");
        inputToTableNations("JEY","Jersey","General","112");
        inputToTableNations("JOR","Jordan","General","911");
        //============================== K =============================
        inputToTableNations("KAZ","Kazakhstan","General","112");
        inputToTableNations("KAZ","Kazakhstan","Police","102");
        inputToTableNations("KAZ","Kazakhstan","Medical","103");
        inputToTableNations("KAZ","Kazakhstan","Fire","101");
        inputToTableNations("KEN","Kenya","General","112");
        inputToTableNations("KIR","Kiribati","General","999");
        inputToTableNations("KIR","Kiribati","Police","192");
        inputToTableNations("KIR","Kiribati","Medical","194");
        inputToTableNations("KIR","Kiribati","Fire","194");
        inputToTableNations("SCG","Kosovo","General","112");
        inputToTableNations("SCG","Kosovo","Police","192");
        inputToTableNations("SCG","Kosovo","Medical","194");
        inputToTableNations("SCG","Kosovo","Fire","193");
        inputToTableNations("KWT","Kuwait","General","112");
        inputToTableNations("KGZ","Kyrqyzstan","Police","102");
        inputToTableNations("KGZ","Kyrqyzstan","Medical","103");
        inputToTableNations("KGZ","Kyrqyzstan","Fire","101");
        //============================== L =============================
        inputToTableNations("LVA","Latvia","General","112");
        inputToTableNations("LVA","Latvia","Police","110");
        inputToTableNations("LVA","Latvia","Medical","113");
        inputToTableNations("LBN","Lebanon","Police","112");
        inputToTableNations("LBN","Lebanon","Medical","140");
        inputToTableNations("LBN","Lebanon","Fire","175");
        inputToTableNations("LSO","Lesotho","Police","123");
        inputToTableNations("LSO","Lesotho","Medical","121");
        inputToTableNations("LSO","Lesotho","Fire","122");
        inputToTableNations("LBR","Liberia","General","911");
        inputToTableNations("LBY","Libya","General","1515");
        inputToTableNations("LBY","Libya","Medical","193");
        inputToTableNations("LIE","Liechtenstein","General","112");
        inputToTableNations("LIE","Liechtenstein","Police","117");
        inputToTableNations("LIE","Liechtenstein","Medical","144");
        inputToTableNations("LIE","Liechtenstein","Fire","118");
        inputToTableNations("LTU","Lithuania","General","112");
        inputToTableNations("LUX","Luxembourg","General","112");
        inputToTableNations("LUX","Luxembourg","Police","113");
        //============================== M =============================
        inputToTableNations("MAC","Macao","General","999");
        inputToTableNations("MKD","Macedonia","General","112");
        inputToTableNations("MKD","Macedonia","Police","192");
        inputToTableNations("MKD","Macedonia","Medical","194");
        inputToTableNations("MKD","Macedonia","Fire","193");
        inputToTableNations("MDG","Madagascar","Police","117");
        inputToTableNations("MDG","Madagascar","Medical","124");
        inputToTableNations("MDG","Madagascar","Fire","118");
        inputToTableNations("MWI","Malawi","Police","997");
        inputToTableNations("MWI","Malawi","Medical","998");
        inputToTableNations("MWI","Malawi","Fire","999");
        inputToTableNations("MYS","Malaysia","General","999");
        inputToTableNations("MDV","Maldives","Police","119");
        inputToTableNations("MDV","Maldives","Medical","102");
        inputToTableNations("MDV","Maldives","Fire","118");
        inputToTableNations("MLI","Mali","Police","17");
        inputToTableNations("MLI","Mali","Medical","15");
        inputToTableNations("MLI","Mali","Fire","18");
        inputToTableNations("MLT","Malta","General","112");
        inputToTableNations("MLT","Malta","Police","191");
        inputToTableNations("MLT","Malta","Medical","196");
        inputToTableNations("MLT","Malta","Fire","199");
        inputToTableNations("MHL","Marshall Islands","General","911");
        inputToTableNations("MTQ","Martinique","General","112");
        inputToTableNations("MTQ","Martinique","Police","17");
        inputToTableNations("MTQ","Martinique","Medical","15");
        inputToTableNations("MTQ","Martinique","Fire","18");
        inputToTableNations("MUS","Mauritius","Police","112");
        inputToTableNations("MUS","Mauritius","Medical","114");
        inputToTableNations("MUS","Mauritius","Fire","115");
        inputToTableNations("MRT","Mauritania","Police","117");
        inputToTableNations("MRT","Mauritania","Medical","101");
        inputToTableNations("MRT","Mauritania","Fire","118");
        inputToTableNations("MYT","Mayotte","General","112");
        inputToTableNations("MYT","Mayotte","Police","17");
        inputToTableNations("MYT","Mayotte","Medical","15");
        inputToTableNations("MYT","Mayotte","Fire","18");
        inputToTableNations("MEX","Mexico","General","66");
        inputToTableNations("MEX","Mexico","Police","80");
        inputToTableNations("MEX","Mexico","Medical","65");
        inputToTableNations("MEX","Mexico","Fire","68");
        inputToTableNations("FSM","Micronesia","General","911");
        inputToTableNations("MDA","Moldova","Police","903");
        inputToTableNations("MDA","Moldova","Medical","902");
        inputToTableNations("MDA","Moldova","Fire","901");
        inputToTableNations("MCO","Monaco","General","112");
        inputToTableNations("MCO","Monaco","Police","17");
        inputToTableNations("MCO","Monaco","Medical","15");
        inputToTableNations("MCO","Monaco","Fire","18");
        inputToTableNations("MNG","Mongolia","General","105");
        inputToTableNations("MNG","Mongolia","Police","102");
        inputToTableNations("MNG","Mongolia","Medical","103");
        inputToTableNations("MNG","Mongolia","Fire","101");
        inputToTableNations("MNE","Montenegro","General","112");
        inputToTableNations("MNE","Montenegro","Police","122");
        inputToTableNations("MNE","Montenegro","Medical","124");
        inputToTableNations("MNE","Montenegro","Fire","123");
        inputToTableNations("MSR","Montserrat","General","911");
        inputToTableNations("MAR","Morocco","Police","19");
        inputToTableNations("MAR","Morocco","Medical","15");
        inputToTableNations("MAR","Morocco","Fire","15");
        inputToTableNations("MOZ","Mozambique","Police","119");
        inputToTableNations("MOZ","Mozambique","Medical","117");
        inputToTableNations("MOZ","Mozambique","Fire","198");
        inputToTableNations("MMR","Myanmar (Burma)","General","999");
        inputToTableNations("MMR","Myanmar (Burma)","Police","199");
        inputToTableNations("MMR","Myanmar (Burma)","Medical","192");
        inputToTableNations("MMR","Myanmar (Burma)","Fire","191");
        //============================== N =============================
        inputToTableNations("NAM","Namibia","General","112");
        inputToTableNations("NRU","Nauru","Police","110");
        inputToTableNations("NRU","Nauru","Medical","111");
        inputToTableNations("NRU","Nauru","Fire","112");
        inputToTableNations("NPL","Nepal","General","112");
        inputToTableNations("NPL","Nepal","Police","100");
        inputToTableNations("NPL","Nepal","Medical","102");
        inputToTableNations("NPL","Nepal","Fire","101");
        inputToTableNations("NLD","Netherlands","General","112");
        inputToTableNations("NCL","New Caledonia","General","112");
        inputToTableNations("NCL","New Caledonia","Police","17");
        inputToTableNations("NCL","New Caledonia","Medical","15");
        inputToTableNations("NCL","New Caledonia","Fire","18");
        inputToTableNations("NZL","New Zealand","General","111");
        inputToTableNations("NIC","Nicaragua","Police","118");
        inputToTableNations("NIC","Nicaragua","Medical","128");
        inputToTableNations("NIC","Nicaragua","Fire","115");
        inputToTableNations("NER","Niger","Police","17");
        inputToTableNations("NER","Niger","Medical","15");
        inputToTableNations("NER","Niger","Fire","18");
        inputToTableNations("NGA","Nigeria","General","112");
        inputToTableNations("PRK","North Korea","General","119");
        inputToTableNations("NOR","Norway","Police","112");
        inputToTableNations("NOR","Norway","Medical","113");
        inputToTableNations("NOR","Norway","Fire","110");
        //============================== O =============================
        inputToTableNations("OMN","Oman","General","999");
        //============================== P =============================
        inputToTableNations("PAK","Pakistan","Police","15");
        inputToTableNations("PAK","Pakistan","Medical","115");
        inputToTableNations("PAK","Pakistan","Fire","16");
        inputToTableNations("PLW","Palau","General","911");
        inputToTableNations("PAN","Panama","General","911");
        inputToTableNations("PAN","Panama","Police","104");
        inputToTableNations("PAN","Panama","Fire","103");
        inputToTableNations("PNG","Papua New Guinea","Police","112");
        inputToTableNations("PNG","Papua New Guinea","Medical","111");
        inputToTableNations("PNG","Papua New Guinea","Fire","110");
        inputToTableNations("PRY","Paraguay","General","911");
        inputToTableNations("PRY","Paraguay","Police","912");
        inputToTableNations("PRY","Paraguay","Medical","141");
        inputToTableNations("PRY","Paraguay","Fire","132");
        inputToTableNations("PER","Peru","General","911");
        inputToTableNations("PER","Peru","Police","105");
        inputToTableNations("PER","Peru","Medical","116");
        inputToTableNations("PER","Peru","Fire","116");
        inputToTableNations("PHL","Philippines","General","117");
        inputToTableNations("POL","Poland","General","112");
        inputToTableNations("POL","Poland","Police","997");
        inputToTableNations("POL","Poland","Medical","999");
        inputToTableNations("POL","Poland","Fire","998");
        inputToTableNations("PRT","Portugal","General","112");
        inputToTableNations("PRI","Puerto Rico","General","911");
        //============================== Q =============================
        inputToTableNations("QAT","Qatar","General","999");
        //============================== R =============================
        inputToTableNations("REU","Reunion","General","112");
        inputToTableNations("REU","Reunion","Police","17");
        inputToTableNations("REU","Reunion","Medical","15");
        inputToTableNations("REU","Reunion","Fire","18");
        inputToTableNations("ROU","Romania","General","112");
        inputToTableNations("RUS","Russian Federation","General","112");
        inputToTableNations("RUS","Russian Federation","Police","102");
        inputToTableNations("RUS","Russian Federation","Medical","103");
        inputToTableNations("RUS","Russian Federation","Fire","101");
        inputToTableNations("ROW","Rwanda","Police","112");
        inputToTableNations("ROW","Rwanda","Medical","912");
        inputToTableNations("ROW","Rwanda","Fire","112");
        //============================== S =============================
        inputToTableNations("SHN","St.Helena","Police","999");
        inputToTableNations("SHN","St.Helena","Medical","911");
        inputToTableNations("SHN","St.Helena","Fire","999");
        inputToTableNations("KNA","St. Kitts & Nevis","General","911");
        inputToTableNations("LCA","St. Lucia","General","911");
        inputToTableNations("SPM","St.Pierre & Miquelon","General","112");
        inputToTableNations("SPM","St.Pierre & Miquelon","Police","17");
        inputToTableNations("SPM","St.Pierre & Miquelon","Medical","15");
        inputToTableNations("SPM","St.Pierre & Miquelon","Fire","18");
        inputToTableNations("VCT","St. Vincent & Grenadines","General","911");
        inputToTableNations("WSM","Samoa","General","999");
        inputToTableNations("WSM","Samoa","General","999");
        inputToTableNations("WSM","Samoa","Police","995");
        inputToTableNations("WSM","Samoa","Medical","996");
        inputToTableNations("WSM","Samoa","Fire","994");
        inputToTableNations("SMR","San Marino","General","112");
        inputToTableNations("SMR","San Marino","Police","113");
        inputToTableNations("SMR","San Marino","Medical","118");
        inputToTableNations("SMR","San Marino","Fire","115");
        inputToTableNations("STP","Sao Tome & Principe","General","112");
        inputToTableNations("SAU","Saudi Arabia","General","112");
        inputToTableNations("SAU","Saudi Arabia","Police","999");
        inputToTableNations("SAU","Saudi Arabia","Medical","997");
        inputToTableNations("SAU","Saudi Arabia","Fire","998");
        inputToTableNations("SEN","Senegal","Police","17");
        inputToTableNations("SEN","Senegal","Medical","15");
        inputToTableNations("SEN","Senegal","Fire","18");
        inputToTableNations("SRB","Serbia","General","112");
        inputToTableNations("SRB","Serbia","Police","192");
        inputToTableNations("SRB","Serbia","Medical","194");
        inputToTableNations("SRB","Serbia","Fire","193");
        inputToTableNations("SYC","Seychelles","General","112");
        inputToTableNations("SYC","Seychelles","Police","133");
        inputToTableNations("SYC","Seychelles","Medical","151");
        inputToTableNations("SLE","Sierra Leone","Police","19");
        inputToTableNations("SLE","Sierra Leone","Medical","999");
        inputToTableNations("SLE","Sierra Leone","Fire","999");
        inputToTableNations("SGP","Singapore","Police","999");
        inputToTableNations("SGP","Singapore","Medical","995");
        inputToTableNations("SGP","Singapore","Fire","995");
        inputToTableNations("SVK","Slovakia","General","112");
        inputToTableNations("SVK","Slovakia","Police","158");
        inputToTableNations("SVK","Slovakia","Medical","155");
        inputToTableNations("SVK","Slovakia","Fire","150");
        inputToTableNations("SVN","Slovenia","General","112");
        inputToTableNations("SVN","Slovenia","Police","113");
        inputToTableNations("SLB","Solomon Islands","General","911");
        inputToTableNations("SOM","Somalia","Police","888");
        inputToTableNations("SOM","Somalia","Medical","999");
        inputToTableNations("SOM","Somalia","Police","555");
        inputToTableNations("ZAF","South Africa","General","112");
        inputToTableNations("ZAF","South Africa","Police","10111");
        inputToTableNations("ZAF","South Africa","Medical","10177");
        inputToTableNations("ZAF","South Africa","Fire","10177");
        inputToTableNations("KOR","South Korea","Police","112");
        inputToTableNations("KOR","South Korea","Medical","119");
        inputToTableNations("KOR","South Korea","Fire","119");
        inputToTableNations("SSD","South Sudan","General","999");
        inputToTableNations("ESP","Spain","General","112");
        inputToTableNations("ESP","Spain","Police","91");
        inputToTableNations("ESP","Spain","Medical","61");
        inputToTableNations("ESP","Spain","Fire","80");
        inputToTableNations("LKA","Sri Lanka","Police","119");
        inputToTableNations("LKA","Sri Lanka","Medical","110");
        inputToTableNations("LKA","Sri Lanka","Fire","110");
        inputToTableNations("SDN","Sudan","General","999");
        inputToTableNations("SUR","Suriname","General","112");
        inputToTableNations("SUR","Suriname","Police","111");
        inputToTableNations("SUR","Suriname","Medical","113");
        inputToTableNations("SUR","Suriname","Fire","110");
        inputToTableNations("SWE","Sweden","General","112");
        inputToTableNations("SWZ","Swaziland","Police","999");
        inputToTableNations("SWZ","Swaziland","Medical","977");
        inputToTableNations("SWZ","Swaziland","Fire","933");
        inputToTableNations("CHE","Switzerland","General","112");
        inputToTableNations("CHE","Switzerland","Police","117");
        inputToTableNations("CHE","Switzerland","Medical","144");
        inputToTableNations("CHE","Switzerland","Fire","118");
        inputToTableNations("SYR","Syrian Arab Republic","Police","112");
        inputToTableNations("SYR","Syrian Arab Republic","Medical","110");
        inputToTableNations("SYR","Syrian Arab Republic","Fire","113");
        //============================== T =============================
        inputToTableNations("TWN","Taiwan","Police","110");
        inputToTableNations("TWN","Taiwan","Medical","119");
        inputToTableNations("TWN","Taiwan","Fire","119");
        inputToTableNations("TJK","Tajikistan","General","112");
        inputToTableNations("TJK","Tajikistan","Police","102");
        inputToTableNations("TJK","Tajikistan","Medical","103");
        inputToTableNations("TJK","Tajikistan","Fire","101");
        inputToTableNations("TZA","Tanzania","Police","112");
        inputToTableNations("TZA","Tanzania","Medical","115");
        inputToTableNations("TZA","Tanzania","Fire","114");
        inputToTableNations("THA","Thailand","Police","191");
        inputToTableNations("THA","Thailand","Medical","1669");
        inputToTableNations("THA","Thailand","Fire","199");
        inputToTableNations("TGO","Togo","Police","117");
        inputToTableNations("TGO","Togo","Medical","8200");
        inputToTableNations("TGO","Togo","Fire","118");
        inputToTableNations("TON","Tonga","General","911");
        inputToTableNations("TON","Tonga","Police","992");
        inputToTableNations("TON","Tonga","Medical","933");
        inputToTableNations("TON","Tonga","Fire","999");
        inputToTableNations("TTO","Trinidad & Tobago","Police","911");
        inputToTableNations("TTO","Trinidad & Tobago","Medical","990");
        inputToTableNations("TTO","Trinidad & Tobago","Fire","990");
        inputToTableNations("SHT","Tristan da Cunha","Police","999");
        inputToTableNations("SHT","Tristan da Cunha","Medical","911");
        inputToTableNations("SHT","Tristan da Cunha","Fire","999");
        inputToTableNations("TUN","Tunisia","Police","197");
        inputToTableNations("TUN","Tunisia","Medical","190");
        inputToTableNations("TUN","Tunisia","Fire","198");
        inputToTableNations("TUR","Turkey","Police","112");
        inputToTableNations("TUR","Turkey","Medical","155");
        inputToTableNations("TUR","Turkey","Fire","110");
        inputToTableNations("TKM","Turkmenistan","General","112");
        inputToTableNations("TKM","Turkmenistan","Police","102");
        inputToTableNations("TKM","Turkmenistan","Medical","103");
        inputToTableNations("TKM","Turkmenistan","Fire","101");
        inputToTableNations("TUV","Tuvalu","General","991");
        //============================== U =============================
        inputToTableNations("UGA","Uganda","Police","112");
        inputToTableNations("UGA","Uganda","Medical","911");
        inputToTableNations("UGA","Uganda","Fire","112");
        inputToTableNations("UKR","Ukraine","General","112");
        inputToTableNations("UKR","Ukraine","Police","102");
        inputToTableNations("UKR","Ukraine","Medical","103");
        inputToTableNations("UKR","Ukraine","Fire","101");
        inputToTableNations("ARE","United Arab Emirates","Police","999");
        inputToTableNations("ARE","United Arab Emirates","Medical","998");
        inputToTableNations("ARE","United Arab Emirates","Fire","997");
        inputToTableNations("GBR","United Kingdom","General","112");
        inputToTableNations("USA","United States","General","911");
        inputToTableNations("URY","Uruguay","General","911");
        inputToTableNations("URY","Uruguay","Police","109");
        inputToTableNations("URY","Uruguay","Medical","105");
        inputToTableNations("URY","Uruguay","Fire","104");
        inputToTableNations("VIR","US Virgin Islands","General","911");
        inputToTableNations("UZB","Uzbekistan","General","112");
        inputToTableNations("UZB","Uzbekistan","Police","102");
        inputToTableNations("UZB","Uzbekistan","Medical","103");
        inputToTableNations("UZB","Uzbekistan","Fire","101");
        //============================== V =============================
        inputToTableNations("HRV","Vanuatu","General","112");
        inputToTableNations("VAT","Vatican City","General","112");
        inputToTableNations("VAT","Vatican City","Police","113");
        inputToTableNations("VAT","Vatican City","Medical","118");
        inputToTableNations("VAT","Vatican City","Fire","115");
        inputToTableNations("CYP","Venezuela","General","911");
        inputToTableNations("COL","Vietnam","Police","113");
        inputToTableNations("COL","Vietnam","Medical","115");
        inputToTableNations("CRI","Vietnam","Fire","114");
        //============================== W =============================
        inputToTableNations("ESH","Western Sahara","General","112");
        inputToTableNations("ESH","Western Sahara","Police","911");
        inputToTableNations("ESH","Western Sahara","Medical","992");
        inputToTableNations("ESH","Western Sahara","Fire","993");
        //============================== Y =============================
        inputToTableNations("YEM","Yemen","Police","194");
        inputToTableNations("YEM","Yemen","Medical","191");
        inputToTableNations("YEM","Yemen","Fire","191");
        //============================== Z =============================
        inputToTableNations("HRV","Zambia","General","999");
        inputToTableNations("HRV","Zambia","Police","911");
        inputToTableNations("HRV","Zambia","Medical","992");
        inputToTableNations("HRV","Zambia","Fire","993");
        inputToTableNations("HRV","Zimbabwe","General","999");
        inputToTableNations("CYP","Zimbabwe","Police","995");
        inputToTableNations("BGR","Zimbabwe","Medical","994");
        inputToTableNations("BGR","Zimbabwe","Fire","993");

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
        try {
            String query =  "SELECT DISTINCT serviceType, phoneNumber " +
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

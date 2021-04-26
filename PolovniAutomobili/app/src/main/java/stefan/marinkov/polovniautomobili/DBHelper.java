package stefan.marinkov.polovniautomobili;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "automobil.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "automobili";
    private static final String COLUMN_BRAND = "Marka";
    private static final String COLUMN_MODEL = "Model";
    private static final String COLUMN_YEAR = "GodinaProizvodnje";
    private static final String COLUMN_KM = "Kilometraza";
    private static final String COLUMN_ID = "ID";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_BRAND + " TEXT, "   +
                COLUMN_MODEL + " TEXT, "   +
                COLUMN_YEAR  + " INTEGER," +
                COLUMN_KM    + " INTEGER," +
                COLUMN_ID    + " INTEGER);");
    }

    public Car[] readAllCars() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if(cursor.getCount() <= 0){
            db.close();
            return null;
        }

        Car[] cars  = new Car[cursor.getCount()];
        int i = 0;
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            cars[i++] = createCar(cursor);
        }

        db.close();
        return cars;
    }

    public Car[] readCarsLKM(int KM) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_KM + "<?", new String[] {String.valueOf(KM)}, null, null, null);
        if(cursor.getCount() <= 0){
            db.close();
            return null;
        }

        Car[] cars  = new Car[cursor.getCount()];

        int i = 0;
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Car car = createCar(cursor);
            if (car.getmKM() < KM) {
                cars[i++] = car;
            }
        }

        db.close();
        return cars;
    }

    public Car[] readCarsGYear(int year) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_YEAR + ">?", new String[] {String.valueOf(year)}, null, null, null);
        if(cursor.getCount() <= 0){
            db.close();
            return null;
        }

        Car[] cars  = new Car[cursor.getCount()];
        int i = 0;
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Car car = createCar(cursor);
            if (car.getmYear() > year) {
                cars[i++] = car;
            }
        }

        db.close();
        return cars;
    }

    private Car createCar (Cursor cursor) {
        String brand = cursor.getString(cursor.getColumnIndex(COLUMN_BRAND)); // vraca sta se nalazi u koloni u kojoj je column_first_name
        String model = cursor.getString(cursor.getColumnIndex(COLUMN_MODEL));
        int year  = cursor.getInt(cursor.getColumnIndex(COLUMN_YEAR));
        int km  = cursor.getInt(cursor.getColumnIndex(COLUMN_KM));
        int ID  = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
        return new Car(brand, model, year, km, ID);
    }

    public void insertCar (Car car) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_BRAND, car.getmBrand());
        values.put(COLUMN_MODEL, car.getmModel());
        values.put(COLUMN_YEAR, car.getmYear());
        values.put(COLUMN_KM, car.getmKM());
        values.put(COLUMN_ID, car.getmID());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void deleteCar(int id) {
       SQLiteDatabase db = getWritableDatabase();
       db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[] {String.valueOf(id)});
       db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

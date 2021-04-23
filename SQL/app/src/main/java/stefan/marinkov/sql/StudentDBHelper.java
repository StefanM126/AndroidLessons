package stefan.marinkov.sql;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Students.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Student";
    public static final String COLUMN_FIRST_NAME = "firstName";
    public static final String COLUMN_LAST_NAME = "lastName";
    public static final String COLUMN_INDEX = "indexNum";

    public StudentDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_FIRST_NAME + " TEXT, " +
                COLUMN_LAST_NAME  + " TEXT, " +
                COLUMN_INDEX      + " TEXT);");
    }



    public void insert (Student student) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, student.getIme());
        values.put(COLUMN_LAST_NAME, student.getPrezime());
        values.put(COLUMN_INDEX, student.getIndex());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Student[] readAllStudents () {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if(cursor.getCount() <= 0){
            db.close();
            return null;
        }

        Student[] students  = new Student[cursor.getCount()];
        int i = 0;
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
          students[i++] = createStudent(cursor);
        }

        db.close();
        return students;
    }

    private Student createStudent (Cursor cursor) {
        String firstName = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME)); // vraca sta se nalazi u koloni u kojoj je column_first_name
        String lastName = cursor.getString(cursor.getColumnIndex(COLUMN_LAST_NAME));
        String index = cursor.getString(cursor.getColumnIndex(COLUMN_INDEX));
        return new Student(firstName, lastName, index);
    }

    public Student findStudentByIndex(String index) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_INDEX + "=?", new String[] {index}, null, null, null);

        if(cursor.getCount() <= 0){
            db.close();
            return null;
        }

        cursor.moveToFirst();
        db.close();
        return createStudent(cursor);
    }

    public void deleteStudent(String index) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_INDEX + "=?", new String[] {index});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}



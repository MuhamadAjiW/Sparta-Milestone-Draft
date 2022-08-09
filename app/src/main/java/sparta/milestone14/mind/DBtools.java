package sparta.milestone14.mind;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBtools extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBtools(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase LoginData) {
        LoginData.execSQL("create Table users(username TEXT primary key, password TEXT, name TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase LoginData, int i, int i1) {
        LoginData.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password, String name){
        SQLiteDatabase LoginData = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("name", name);
        long result = LoginData.insert("users", null, contentValues);
        return result != -1;
    }

    public Boolean checkUsername(String username){
        SQLiteDatabase LoginData = this.getWritableDatabase();
        Cursor cursor = LoginData.rawQuery("Select * from users where username = ?", new String[] {username});
        if (cursor.getCount()>0){
            cursor.close();
            return true;
        }
        else{
            cursor.close();
            return false;
        }
    }

    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase LoginData = this.getWritableDatabase();
        Cursor cursor = LoginData.rawQuery("select * from users where username = ? and password = ?", new String[] {username,password});
        if (cursor.getCount()>0){
            cursor.close();
            return true;
        }
        else{
            cursor.close();
            return false;
        }
    }

    public String getName(String username){
        SQLiteDatabase LoginData = this.getWritableDatabase();
        Cursor cursor = LoginData.rawQuery("Select * from users where username = ?", new String[] {username});

        cursor.moveToFirst();
        String result = cursor.getString(cursor.getColumnIndex("name"));

        cursor.close();
        return result;
    }

}

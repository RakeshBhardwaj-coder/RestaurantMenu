package rakesh.app.restaurantmenu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FoodDetailsData";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_TABLENAME = "foodDetailsTable";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME =  "name";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + DATABASE_TABLENAME +
                "("+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT " + ")";
        db.execSQL(createTableQuery);

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Handle database schema changes here.
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLENAME);
        onCreate(db);
    }

    public void addContant(String foodName){


        SQLiteDatabase db = this.getWritableDatabase();

        // Insert data
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, foodName);


        db.insert(DATABASE_TABLENAME, null, values);

    }
//
//    public List<FoodModel> getAllFoodDetails() {
//        List<FoodModel> foodList = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(DATABASE_TABLENAME,null,null,null,null,null,null);
//        if(cursor.moveToNext()){
//            do{
//                long id = cursor.getLong(cursor.getColumnIndex(KEY_NAME));
//
//                String foodName = cursor.getString(cursor.getColumnIndex(KEY_ID));
//                //long id2 = Long.parseLong(cursor.getColumnName(0));
//                //String foodName2 = cursor.getColumnName(1);
//
//                FoodModel foodModel = new FoodModel(id,foodName);
//                foodList.add(foodModel);
//
//
//            }while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return foodList;
//    }
}

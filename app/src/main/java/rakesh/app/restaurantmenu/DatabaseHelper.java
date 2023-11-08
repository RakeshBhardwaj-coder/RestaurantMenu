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
    private static final String KEY_NAME =  "foodName";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME+".db", null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + DATABASE_TABLENAME +
                "("+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT " + ")";
        db.execSQL(createTableQuery);

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

    public void UpdateFoodDetails(FoodModel foodModel){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_NAME, foodModel.foodName);
        sqLiteDatabase.update(DATABASE_TABLENAME,contentValues,KEY_ID+" = "+ foodModel.id,null);


    }
    public void DeleteFoodDetails(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(DATABASE_TABLENAME,KEY_ID + " = ? ", new String[]{String.valueOf(id)});



    }

    public List<FoodModel> GetFoodDetails(){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+ DATABASE_TABLENAME,null);

        ArrayList<FoodModel> listOfFoods = new ArrayList<>();

        while (cursor.moveToNext()){
            FoodModel foodModel = new FoodModel();

            foodModel.id = cursor.getInt(0);
            foodModel.foodName = cursor.getString(1);

            listOfFoods.add(foodModel);
        }
        return listOfFoods;
    }

}

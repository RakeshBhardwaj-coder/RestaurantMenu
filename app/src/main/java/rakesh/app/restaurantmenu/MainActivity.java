package rakesh.app.restaurantmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<FoodModel> listOfFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        //databaseHelper.addContant("Rajesh");
        //databaseHelper.addContant("Ramu");
        // Query data
        //Cursor cursor = db.query("your_table_name", null, null, null, null, null, null);

        listOfFood = new ArrayList<>();

        // for data Update
//        FoodModel foodModel = new FoodModel();
//        foodModel.id = 1;
//        foodModel.foodName = "Roja sharma";
//
//        databaseHelper.UpdateFoodDetails(foodModel);

        // data deletion
        databaseHelper.DeleteFoodDetails(8);
        listOfFood = databaseHelper.GetFoodDetails();


        // Close the database when you're done with it.


        recyclerView = findViewById(R.id.amRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        FoodModelAdapter foodModelAdapter = new FoodModelAdapter(listOfFood);
        recyclerView.setAdapter(foodModelAdapter);


        //listOfFood.clear();


    }
}
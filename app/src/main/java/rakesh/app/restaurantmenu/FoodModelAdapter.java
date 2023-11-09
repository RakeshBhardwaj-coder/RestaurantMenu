package rakesh.app.restaurantmenu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodModelAdapter extends RecyclerView.Adapter<FoodModelAdapter.ViewHolder> {

    private List<FoodModel> listOfFood;
    public FoodModelAdapter(){

    }
    public FoodModelAdapter(List<FoodModel> listOfFood) {
        this.listOfFood = listOfFood;
    }

    @NonNull
    @Override
    public FoodModelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_designs,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FoodModelAdapter.ViewHolder holder, int position) {
        FoodModel foodModel = listOfFood.get(position);
        holder.foodNameTxt.setText(""+foodModel.getFoodName());
        holder.timeToReceiveTxt.setText(""+foodModel.getFoodTiming());

    }

    @Override
    public int getItemCount() {
        return listOfFood.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodNameTxt, timeToReceiveTxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodNameTxt = itemView.findViewById(R.id.idFoodName);
            timeToReceiveTxt = itemView.findViewById(R.id.idTimeToReceive);
        }
    }
}

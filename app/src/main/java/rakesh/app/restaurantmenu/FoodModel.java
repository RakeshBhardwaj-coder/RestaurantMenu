package rakesh.app.restaurantmenu;

public class FoodModel {
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public FoodModel(String foodName) {
        this.foodName = foodName;
    }

    private String foodName;

}

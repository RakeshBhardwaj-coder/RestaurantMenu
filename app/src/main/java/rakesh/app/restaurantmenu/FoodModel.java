package rakesh.app.restaurantmenu;

public class FoodModel {

    long id;
    private String foodName;
    private String foodReceivingTime;
    private double foodPrice;


    public FoodModel(long id, String foodName) {
        this.id = id;
        this.foodName = foodName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}

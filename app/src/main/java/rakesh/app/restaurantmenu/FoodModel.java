package rakesh.app.restaurantmenu;

public class FoodModel {

    long id;
     String foodName;
     String foodTiming;
     String foodRating;
     String foodPrice;
    private String foodReceivingTime;

    public FoodModel() {
    }

    public FoodModel(long id, String foodName, String foodTiming, String foodRating, String foodPrice, String foodReceivingTime) {
        this.id = id;
        this.foodName = foodName;
        this.foodTiming = foodTiming;
        this.foodRating = foodRating;
        this.foodPrice = foodPrice;
        this.foodReceivingTime = foodReceivingTime;
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

    public String getFoodTiming() {
        return foodTiming;
    }

    public void setFoodTiming(String foodTiming) {
        this.foodTiming = foodTiming;
    }

    public String getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(String foodRating) {
        this.foodRating = foodRating;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodReceivingTime() {
        return foodReceivingTime;
    }

    public void setFoodReceivingTime(String foodReceivingTime) {
        this.foodReceivingTime = foodReceivingTime;
    }
}

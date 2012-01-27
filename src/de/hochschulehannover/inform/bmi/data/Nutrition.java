package data;

/**
 *
 * @author stumpenhausen
 */
public class Nutrition {
    
    private String id;
    private String name;
    private String us_serving;
    private String metric_serving;
    private String calories;
    private String carbohydrates;
    private String cholesterol;
    private String fat_poly;
    private String fat_sat;
    private String fat_trans;
    private String protein;
    private String sodium;
    private String sugar;
    private String[] type;

    public Nutrition(String id, String name, String serving) {
        this.id = id;
        this.name = name;
        this.us_serving = serving;
    }
    
    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(String carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getFat_poly() {
        return fat_poly;
    }

    public void setFat_poly(String fat_poly) {
        this.fat_poly = fat_poly;
    }

    public String getFat_sat() {
        return fat_sat;
    }

    public void setFat_sat(String fat_sat) {
        this.fat_sat = fat_sat;
    }

    public String getFat_trans() {
        return fat_trans;
    }

    public void setFat_trans(String fat_trans) {
        this.fat_trans = fat_trans;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMetric_serving() {
        return metric_serving;
    }

    public void setMetric_serving(String metric_serving) {
        this.metric_serving = metric_serving;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getSodium() {
        return sodium;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getUs_serving() {
        return us_serving;
    }

    public void setUs_serving(String us_serving) {
        this.us_serving = us_serving;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }
    
}

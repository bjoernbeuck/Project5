package data;

import data.FoodItem;
import java.util.Date;
import java.util.List;

/**
 *
 * @author stumpenhausen
 */
public class ListNutrition
{
    public Date LastUpdate;
    public List<FoodItem> Items;

    public List<FoodItem> getItems() {
        return Items;
    }

    public void setItems(List<FoodItem> Items) {
        this.Items = Items;
    }

    public Date getLastUpdate() {
        return LastUpdate;
    }

    public void setLastUpdate(Date LastUpdate) {
        this.LastUpdate = LastUpdate;
    }
    
}

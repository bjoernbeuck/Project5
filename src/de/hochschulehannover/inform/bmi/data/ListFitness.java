package data;

import data.ActivityItem;
import java.util.Date;
import java.util.List;

/**
 *
 * @author stumpenhausen
 */
public class ListFitness
{
    public Date LastUpdate;
    public List<ActivityItem> Items;

    public List<ActivityItem> getItems() {
        return Items;
    }

    public void setItems(List<ActivityItem> Items) {
        this.Items = Items;
    }

    public Date getLastUpdate() {
        return LastUpdate;
    }

    public void setLastUpdate(Date LastUpdate) {
        this.LastUpdate = LastUpdate;
    }
    
}

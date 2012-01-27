package de.hochschulehannover.inform.bmi.comm;

import java.util.List;
import de.hochschulehannover.inform.bmi.data.WeightHistoryItem;

/**
 *
 * @author stumpenhausen
 */
public class TrackWeight {
    
    public List<WeightHistoryItem> Items;

    public List<WeightHistoryItem> getItems() {
        return Items;
    }

    public void setItems(List<WeightHistoryItem> Items) {
        this.Items = Items;
    }
    
}

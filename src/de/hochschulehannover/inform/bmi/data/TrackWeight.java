package data;

import data.WeightHistoryItem;
import java.util.List;

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

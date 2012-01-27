package data;

/**
 *
 * @author stumpenhausen
 */
public class WeightHistory {
    
    private String response;
    private int size;
    private WeightItem items;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public WeightItem getItems() {
        return items;
    }

    public void setItems(WeightItem items) {
        this.items = items;
    }
    
}

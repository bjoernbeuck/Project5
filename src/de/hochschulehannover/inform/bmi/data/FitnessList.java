package data;

/**
 *
 * @author stumpenhausen
 */
public class FitnessList {
    
    private String response;
    private int size;
    private String lastupdate;
    private Fitness[] items;

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

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

    public Fitness[] getItems() {
        return items;
    }

    public void setItems(Fitness[] items) {
        this.items = items;
    }
    
}

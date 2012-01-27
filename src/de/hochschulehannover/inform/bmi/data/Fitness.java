package data;

/**
 *
 * @author stumpenhausen
 */
public class Fitness {
    
    private String id;
    private String name;
    private String light_cal;
    private String moderate_cal;
    private String intense_cal;
    private String[] e_type;

    public Fitness(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntense_cal() {
        return intense_cal;
    }

    public void setIntense_cal(String intense_cal) {
        this.intense_cal = intense_cal;
    }

    public String getLight_cal() {
        return light_cal;
    }

    public void setLight_cal(String light_cal) {
        this.light_cal = light_cal;
    }

    public String getModerate_cal() {
        return moderate_cal;
    }

    public void setModerate_cal(String moderate_cal) {
        this.moderate_cal = moderate_cal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getE_type() {
        return e_type;
    }

    public void setE_type(String[] e_type) {
        this.e_type = e_type;
    }
    
}

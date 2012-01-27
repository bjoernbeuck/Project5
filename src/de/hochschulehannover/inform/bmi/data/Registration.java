package data;

/**
 *
 * @author stumpenhausen
 */
public class Registration
{
    public String Username;
    public String Password_1;
    public String Password_2;
    public String Email_1;
    public String Email_2;
    public String Gender;
    public String Unit;
    public double Weight;
    public int Height;
    public String Birthdate;

    public Registration(String Username, String Password_1, String Password_2, String Email_1, String Email_2, String Gender, String Unit, int Weight, int Height, String Birthdate) {
        this.Username = Username;
        this.Password_1 = Password_1;
        this.Password_2 = Password_2;
        this.Email_1 = Email_1;
        this.Email_2 = Email_2;
        this.Gender = Gender;
        this.Unit = Unit;
        this.Weight = Weight;
        this.Height = Height;
        this.Birthdate = Birthdate;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public String getEmail_1() {
        return Email_1;
    }

    public String getEmail_2() {
        return Email_2;
    }

    public String getGender() {
        return Gender;
    }

    public int getHeight() {
        return Height;
    }

    public String getPassword_1() {
        return Password_1;
    }

    public String getPassword_2() {
        return Password_2;
    }

    public String getUnit() {
        return Unit;
    }

    public String getUsername() {
        return Username;
    }

    public double getWeight() {
        return Weight;
    }

    public void setBirthdate(String Birthdate) {
        this.Birthdate = Birthdate;
    }

    public void setEmail_1(String Email_1) {
        this.Email_1 = Email_1;
    }

    public void setEmail_2(String Email_2) {
        this.Email_2 = Email_2;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }

    public void setPassword_1(String Password_1) {
        this.Password_1 = Password_1;
    }

    public void setPassword_2(String Password_2) {
        this.Password_2 = Password_2;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setWeight(double Weight) {
        this.Weight = Weight;
    }
    
}

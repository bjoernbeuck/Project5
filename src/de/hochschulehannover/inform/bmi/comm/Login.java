package de.hochschulehannover.inform.bmi.comm;

/**
 *
 * @author stumpenhausen
 */
public class Login
{
    public int UserId;
    public String Auth;

    public String getAuth() {
        return Auth;
    }

    public void setAuth(String Auth) {
        this.Auth = Auth;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
    
}

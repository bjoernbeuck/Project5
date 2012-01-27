package comm;

import data.Registration;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stumpenhausen
 */
public class BMIComm {

    public String register(Registration reg)    
    {
        String param = "request=register"
            + "&username=" + reg.Username + "&password_1=" + reg.Password_1 + "&password_2=" + reg.Password_2
             + "&email_1=" + reg.Email_1 + "&email_2=" + reg.Email_2 + "&gender=" + reg.Gender + "&unit=" + reg.Unit
              + "&weight=" + reg.Weight + "&height=" + reg.Height + "&birthdate=" + reg.Birthdate;
        return runRequest(param);
    }
    public String login(String user, String password)
    {
        String param = "request=login" + "&username=" + user + "&password=" + password;
        return runRequest(param);
    }
    
    public String getUserData(int userid, String authKey)
    {
        String param = "request=user_data" + "&userid=" + userid + "&auth=" + authKey;
        return runRequest(param);
    }

    public String getNutrition()
    {
        String param = "request=list_nutrition";
        return runRequest(param);
    }
    public String getFitness()
    {
        String param = "request=list_fitness";
        return runRequest(param);
    }
    
    public String updateGoal(int userid, String authKey, int id, long startdate, long enddate, double weight)
    {
        String param = "request=update_goal" + "&userid=" + userid + "&auth=" + authKey 
            + "&id=" + id + "&startdate=" + (new Date(startdate)) + "&enddate=" + (new Date(enddate)) 
              + "&weight=" + weight;
        return runRequest(param);
    }
    public String updateWeight(int userid, String authKey, long date, double weight)
    {
        String param = "request=update_weight" + "&userid=" + userid + "&auth=" + authKey 
            + "&date=" + (new Date(date)) + "&weight=" + weight;
        return runRequest(param);
    }
    public String updateDiet(int userid, String authKey, long date, int id, double amount, String meal)
    {
        String param = "request=update_diet" + "&userid=" + userid + "&auth=" + authKey 
            + "&date=" + (new Date(date)) + "&id=" + id + "&amount=" + amount + "&meal=" + meal;
        return runRequest(param);
    }
    public String updateFitness(int userid, String authKey, long date, int id, int duration, double amount, String intensity)
    {
        String param = "request=update_fitness" + "&userid=" + userid + "&auth=" + authKey 
            + "&date=" + (new Date(date)) + "&id=" + id + "timeframe" + duration 
             + "&amount=" + amount + "&intensity=" + intensity;
        return runRequest(param);
    }

    public String trackWeight(int userid, String authKey, long startDate, long endDate)
    {
        String param = "request=track_weight" + "&userid=" + userid + "&auth=" + authKey 
            + "&startdate=" + (new Date(startDate)) + "&enddate=" + (new Date(endDate));
        return runRequest(param);
    }
    public String trackDiet(int userid, String authKey, long startDate, long endDate)
    {
        String param = "request=track_diet" + "&userid=" + userid + "&auth=" + authKey 
            + "&startdate=" + (new Date(startDate)) + "&enddate=" + (new Date(endDate));
        return runRequest(param);
    }
    public String trackFitness(int userid, String authKey, long startDate, long endDate)
    {
        String param = "request=track_fitness" + "&userid=" + userid + "&auth=" + authKey 
            + "&startdate=" + (new Date(startDate)) + "&enddate=" + (new Date(endDate));
        return runRequest(param);
    }

    public String runRequest(String requestParam)
    {
        try 
        {
            URL url = new URL( "http://ashley.versvik.net/capstone/request.php" );

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod( "POST" );
            connection.setDoInput( true );
            connection.setDoOutput( true );
            connection.setUseCaches( false );
            connection.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded" );
            connection.setRequestProperty( "Content-Length", String.valueOf(requestParam.length()) );

            OutputStreamWriter writer = new OutputStreamWriter( connection.getOutputStream() );
            writer.write( requestParam );
            writer.flush();

            BufferedReader reader = new BufferedReader( new InputStreamReader(connection.getInputStream()) );

            String line = reader.readLine();
//            for ( String line; (line = reader.readLine()) != null; )
//                { System.out.println( line ); }
            writer.close();
            reader.close();

            return line;
  
        } catch (IOException ex) 
        {
            Logger.getLogger(BMIComm.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}


package comm;

import com.google.gson.Gson;
import data.FitnessList;
import data.Login;
import data.Nutrition;
import data.NutritionList;
import data.User;
import data.WeightHistory;

/**
 *
 * @author stumpenhausen
 */
public class BMIParser {
 
        Gson gson = new Gson();

        public Login login(String loginStr) {
            Login login = gson.fromJson(loginStr, Login.class);
            return login;
        }

        public User getUserData(String userStr) {
            User user = gson.fromJson(userStr, User.class);
            return user;
        }
        
        public NutritionList getNutrition(String nutrition) {
            NutritionList foodList = gson.fromJson(nutrition, NutritionList.class);
            return foodList;
        }

        public FitnessList getFitness(String fitness) {
            FitnessList fitnessList = gson.fromJson(fitness, FitnessList.class);
            return fitnessList;
        }

//        public String updateWeight(int userid, String auth) {
//            String updateWeight = comm.updateWeight(userid, auth, System.currentTimeMillis(), 74);
//            System.out.println(updateWeight);
//            return updateWeight;
//        }
        public String updateDiet(Nutrition meal) {
            String mealJSON = gson.toJson(meal, Nutrition.class);
            System.out.println(mealJSON);
            return mealJSON;
        }
//        public String updateFitness(int userid, String auth) {
//            String updateFitness = comm.updateFitness(userid, auth, System.currentTimeMillis(), 1, 20, 2.0, "light");
//            System.out.println(updateFitness);
//            return updateFitness;
//        }

        public WeightHistory trackWeight(String trackWeight) {
            WeightHistory weightHistory = gson.fromJson(trackWeight, WeightHistory.class);
            return weightHistory;
        }
        
//        public void trackDiet(int userid, String auth) {
//            String trackDiet = comm.trackDiet(userid, auth, System.currentTimeMillis(), System.currentTimeMillis());
//            FoodHistory foodHistory = new FoodHistory();
//            foodHistory = gson.fromJson(trackDiet, FoodHistory.class);
//            System.out.println(foodHistory.getResponse());
//            System.out.println(foodHistory.getSize());
//        }

//        public void trackFitness(int userid, String auth) {
//            String trackFitness = comm.trackFitness(userid, auth, System.currentTimeMillis(), System.currentTimeMillis());
//            FitnessHistory fitnessHistory = new FitnessHistory();
//            fitnessHistory = gson.fromJson(trackFitness, FitnessHistory.class);
//            System.out.println(fitnessHistory.getResponse());
//            System.out.println(fitnessHistory.getSize());
//        }

}
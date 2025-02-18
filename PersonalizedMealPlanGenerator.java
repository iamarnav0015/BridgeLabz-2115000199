import java.util.ArrayList;
import java.util.List;

// Interface representing a meal plan
interface MealPlan {
    String getMealType();
}

// Specific meal plans
class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {

        return "High-Protein";
    }
}

// Generic Meal class with bounded type parameter
class Meal<T extends MealPlan> {
    private String mealName;
    private T mealType;

    public Meal(String mealName, T mealType) {
        this.mealName = mealName;
        this.mealType = mealType;
    }

    public String getMealName() {
        return mealName;
    }

    public T getMealType() {
        return mealType;
    }

    @Override
    public String toString() {
        return mealName + " (Type: " + mealType.getMealType() + ")";
    }
}

// Utility class for meal plan validation
class MealPlanUtils {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("Generated meal plan: " + meal);
    }
}

// Meal Plan Manager class
class MealPlanManager {
    private List<Meal<?>> meals = new ArrayList<>();

    public void addMeal(Meal<?> meal) {
        meals.add(meal);


    }

    public void displayMeals() {
        for (Meal<?> meal : meals) {
            System.out.println(meal);
        }
    }
}

public class PersonalizedMealPlanGenerator
{
    public static void main(String[] args) {
        MealPlanManager manager = new MealPlanManager();

        Meal<VegetarianMeal> vegMeal = new Meal<>("Grilled Vegetables", new
                VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>("Tofu Salad", new
                VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>("Keto Chicken Bowl", new
                KetoMeal());
        Meal<HighProteinMeal> proteinMeal = new Meal<>("Steak with Eggs",
                new HighProteinMeal());

        manager.addMeal(vegMeal);
        manager.addMeal(veganMeal);
        manager.addMeal(ketoMeal);
        manager.addMeal(proteinMeal);

        System.out.println("Personalized Meal Plans:");
        manager.displayMeals();

        System.out.println("\nGenerating meal plans:");
        MealPlanUtils.generateMealPlan(vegMeal);
        MealPlanUtils.generateMealPlan(veganMeal);
        MealPlanUtils.generateMealPlan(ketoMeal);
        MealPlanUtils.generateMealPlan(proteinMeal);
    }
}
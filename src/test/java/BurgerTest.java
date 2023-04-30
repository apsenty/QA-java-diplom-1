import org.junit.Test;
import praktikum.*;
import java.util.List;
import static org.junit.Assert.*;

public class BurgerTest {
    Burger burger = new Burger();
    //Database database = new Database();
    //List<Bun> buns = database.availableBuns();
    //List<Ingredient> ingredients = database.availableIngredients();

    @Test
    public void addIngredientListShouldGrow() {
        //burger.addIngredient(ingredients.get(0));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "test_ingredient", 100));
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientListShouldGetSmaller() {
        //burger.addIngredient(ingredients.get(0));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "test_ingredient", 100));
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientShouldChangeIndex() {
        //burger.addIngredient(ingredients.get(0));//0
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "test_ingredient", 100));
        //Ingredient newIngredient = ingredients.get(1);
        Ingredient newIngredient = new Ingredient(IngredientType.SAUCE, "test_2_ingredient", 200);
        burger.addIngredient(newIngredient); //1
        burger.moveIngredient(1,0);
        assertEquals(0, burger.ingredients.indexOf(newIngredient));
    }

    /* @Test
    public void setBunsPositiveCheck() {
        burger.setBuns(buns.get(1));
        assertEquals("Значение должно быть white bun","white bun", burger.bun.getName());
    }

    @Test
    public void getPricePositiveCheck() {
        burger.setBuns(buns.get(0)); //100*2 = 200
        burger.addIngredient(ingredients.get(0)); //100
        assertEquals("Значение должно быть 300", 300, burger.getPrice(), 0);
    } */
}

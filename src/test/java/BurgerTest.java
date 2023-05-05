import org.junit.Test;
import praktikum.*;
import static org.junit.Assert.*;

public class BurgerTest {
    Burger burger = new Burger();

    @Test
    public void addIngredientListShouldGrow() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "test_ingredient", 100));
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientListShouldGetSmaller() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "test_ingredient", 100));
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientShouldChangeIndex() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "test_ingredient", 100));
        Ingredient newIngredient = new Ingredient(IngredientType.SAUCE, "test_2_ingredient", 200);
        burger.addIngredient(newIngredient); //1
        burger.moveIngredient(1,0);
        assertEquals(0, burger.ingredients.indexOf(newIngredient));
    }
}

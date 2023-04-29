import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.*;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "TestIngredientName", 100);

    @Test
    public void getPriceShouldReturn100() {
        assertEquals("Значение должно быть 100", 100, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameShouldReturnTestIngredientName(){
        assertEquals("Значение должно быть TestIngredientName",
                "TestIngredientName", ingredient.getName());
    }

    @Test
    public void getTypeShouldReturnIngredientType() {
        assertEquals("SAUCE", String.valueOf(ingredient.getType()));
    }
}

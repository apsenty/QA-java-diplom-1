import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;


@RunWith(Parameterized.class)
public class BurgerParameterizedPositiveTest {

    private final Bun bun;
    private final Ingredient ingredient;
    private final float price;

    public BurgerParameterizedPositiveTest(Bun bun, Ingredient ingredient, float price) {
        this.bun = bun;
        this.ingredient = ingredient;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setBurger() {
        return new Object[][] {
                {new Bun("Bun 1", 100),
                        new Ingredient(IngredientType.SAUCE, "ingredient 1", 200),
                        400},
                {new Bun("Bun 2", 200),
                        new Ingredient(IngredientType.FILLING, "ingredient 2", 300),
                        700},
        };
    }

    @Test
    public void getReceiptParametrizedPositiveTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        MatcherAssert.assertThat(burger.getReceipt(), allOf(containsString(bun.name), containsString(ingredient.type.toString().toLowerCase()),
                containsString(ingredient.name), containsString(String.format("Price: %f", price))));
    }
}

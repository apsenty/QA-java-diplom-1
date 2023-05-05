import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String ingredientType;

    public IngredientTypeTest(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] setIngredientType() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void checkIsTypeInEnum() {
        String actualResult = String.valueOf(IngredientType.valueOf(ingredientType));
        assertEquals(ingredientType, actualResult);
    }
}

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsCheckCreateBun() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Мок-булочка");
        burger.setBuns(bun);
        assertEquals("Мок-булочка", burger.bun.getName());
    }

    @Test
    public void getPriceShouldReturnMockPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(150F);
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        assertEquals("Значение должно быть 500", 500, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptShouldReturnMockReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(150F);
        Mockito.when(bun.getName()).thenReturn("testBun");
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("testIngredient");
        MatcherAssert.assertThat(burger.getReceipt(), allOf(containsString("testBun"),
                containsString("testIngredient"), containsString(String.format("Price: %f", 500F))));
    }

    @Test
    public void getReceiptInvokeGetPrice() {
        Burger burger = new Burger();
        Burger burgerSpy = Mockito.spy(burger);
        burgerSpy.setBuns(bun);
        burgerSpy.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(150F);
        Mockito.when(bun.getName()).thenReturn("testBun");
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("testIngredient");
        burgerSpy.getReceipt();
        Mockito.verify(burgerSpy, Mockito.times(1)).getPrice();
    }
}

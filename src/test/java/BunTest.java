import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.*;

public class BunTest {
    Bun bun = new Bun("TestName", 100);

    @Test
    public void getNameShouldReturnTestName() {
        assertEquals("Значение должно быть TestName","TestName", bun.getName());
    }

    @Test
    public void getPriceShouldReturn100() {
        assertEquals("Значение должно быть 100",100, bun.getPrice(), 0);
    }
}

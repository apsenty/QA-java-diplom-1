import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.*;

public class BunTest {


    @Test
    public void getNameShouldReturnTestName() {
        Bun bun = new Bun("TestName", 100);
        assertEquals("Значение должно быть TestName","TestName", bun.getName());
    }

    @Test
    public void getNameNullNameShouldReturnNull() {
        Bun bun = new Bun(null, 100);
        assertNull("Значение должно быть null", bun.getName());
    }

    @Test
    public void getNameEmptyNameShouldReturnEmpty() {
        Bun bun = new Bun("", 100);
        assertEquals("Должна вернуться пустая строка", "", bun.getName());
    }

    @Test
    public void getNameNameWithSpacesShouldReturnCorrectly() {
        String expectedName = "Тестовая булочка с пробелами";
        Bun bun = new Bun("Тестовая булочка с пробелами", 100);
        assertEquals("Значение должно быть \"Тестовая булочка с пробелами\"", expectedName, bun.getName());
    }

    @Test
    public void getNameTooLongNameWithNumbersShouldReturnCorrectly() {
        String expectedName = "7FXWbИnИТЛxхкzвлщ1цafd9гEЮGzЧLвlхwВqЗЛй49ФЦткхgyх4ОjА5Ъ3МКЙнwCUKс61hVкОk" +
                "IырЧ2DIZъю8eшAiTyцN8UIуХТЪ7ХныйЯю2цTйmККьпЩБйюPWтoЯ9пкuБcДябъГМqvХЧбQ0HхmFаюМFnмxшUаЖФИB" +
                "ч3ШЖ7ut6ХщGЕгU0яHКяDЖ2dDiОСfЛdЦzCрЬBкuGРЛЮПлфЮЫЛнмpHнАгHOйзОЧSвk4дЪрOmЮgGг0SBРsтовGлxРЗh" +
                "ъSэ8вЕФdXЪмьwcчНЗм6ЭфdDх0IьcьsюGUэГоЗ5лЭzмйБоMсoXЩclREиXЙsОHшOзkтlЙпLГйwЦъL3Е1цmЫкxЮКfYР" +
                "HyнpWrХAEaИтл8GяhжvРьrтшЩйЛgйakх2PчгвzНБшЩоGelДжnЪРy1ПGXUУтгEGпщЙьЩлgqzaYMhуWApшКvЦKCПОM" +
                "ьКiLPАЧeсДeБ3sЩ8YРФfGяшхЬНСкlЫpзXOчф8зщkq0дСwndGкdmБжRmМkлrЕUCОOалсYB6ЕТlш6cяMHчdWyЛZ3fЛ" +
                "aъoЪqАlAдVГчXnамфe4пJKВOWБSМфlC82БH0iiRкfи6GiNЦExPVfЩСEfБ28ФЦтчжbVwBлГсСД130Qht0в5payFУа" +
                "а2ВоyлаДacГЭфtКдyxхlЕiЧoРAбkНNZЩDЖыA0УШИУpzCgGaYЖс5FыыgАСЛegеsщ1йЖjЖЩmyнgРТxr4хrтЗKщкУйY" +
                "fPХрJreЫцaыeуy3LаR5КlЛUфOQqSPZщDD5БИДа0зgм4m3UGeзрОытDсыФЙHИ0AзtЩ6RСцЗйчsЛсSьhуеоРг7зЩMс" +
                "oPDfЦоАC9ЗdсАvЖxXОЧIqЪwюWЕVОaЮшиoйbИФЬEwрJдгwхЧЬn3hХSяiЭkTжоюфУБдЖbУ4Jэ7xiXзАVOИ9Eя9ВЭЛe" +
                "ГzлрQvZькЯЙж47WМeокPT4bdэХыцjюcФtTям";
        Bun bun = new Bun(expectedName, 100);
        assertEquals("Значение должно соответствовать переменной expectedName", expectedName, bun.getName());
    }

    @Test
    public void getNameNameWithSpecSymbolsShouldReturnCorrectly() {
        String expectedName = "uWs.jisy!vE%ziQBK&KnqnddEo@cTK*S@PHuG@pz=ZiEOQ%(GSkE@FWPI!XN-K!gHCbzXMkP(X" +
                "ncigfXMNaImFuqEeAiA=jCP@pL";
        Bun bun = new Bun(expectedName, 100);
        assertEquals("Значение должно соответствовать переменной expectedName", expectedName, bun.getName());
    }

    @Test
    public void getPriceShouldReturn100() {
        Bun bun = new Bun("TestName", 100);
        assertEquals("Значение должно быть 100",100, bun.getPrice(), 0);
    }

    @Test
    public void getPriceDecimalPriceShouldReturnCorrectly() {
        Bun bun = new Bun("Test bun", 10.34F);
        assertEquals("Значение должно быть 10.34", 10.34F, bun.getPrice(), 0);
    }

    @Test
    public void getPriceMaxNegativeNumberShouldReturnCorrectly() {
        float expectedPrice = 1.175494351e-38F;
        Bun bun = new Bun("Test bun", expectedPrice);
        assertEquals("Значение должно быть -100", expectedPrice, bun.getPrice(), 0);
    }

    @Test
    public void getPriceZeroPriceShouldReturnZero() {
        Bun bun = new Bun("Test bun", 0);
        assertEquals("Значение должно быть 0", 0, bun.getPrice(), 0);
    }

    @Test
    public void getPriceMaxFloatPriceShouldReturnCorrectly() {
        float expectedPrice = 3.402823466e+38F;
        Bun bun = new Bun("Test bun", expectedPrice);
        assertEquals("Значение должно соответствовать переменной expectedPrice", expectedPrice, bun.getPrice(), 0);
    }
}
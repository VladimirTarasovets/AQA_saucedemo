import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BeAfAll {

    @BeforeEach
    public void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

}

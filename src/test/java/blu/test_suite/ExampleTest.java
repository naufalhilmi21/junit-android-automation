package blu.test_suite;

import blu.TestInstrument;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExampleTest extends TestInstrument {

    @Test
    @Order(1)
    @DisplayName("Login Test")
    public void loggedInTest() throws InterruptedException {
        blu.loginPage().loginWithUser("Hilmi123");
        blu.homePage().isInHomePage();
    }

    @Test
    @Order(2)
    @DisplayName("New Transfer BCA")
    public void newTransferBca() throws InterruptedException {
        blu.homePage().isInHomePage();
        blu.homePage().newTransactionWithTransfer();
        blu.transferPage().newTransferBca("6630498048");
        blu.transferPage().validateAccountName("NAUFAL HILMI");
        blu.transferPage().submitTransfer("10000");
        blu.transferPage().confirmTransfer();
        blu.transferPage().submitPin("482610");
    }
}

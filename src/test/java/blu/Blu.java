package blu;

import blu.page_objects.HomePage;
import blu.page_objects.LoginPage;
import blu.page_objects.TransferPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Blu {
    private final AndroidDriver<AndroidElement> driver;

    public Blu(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public LoginPage loginPage() {
        return new LoginPage(driver);
    }

    public HomePage homePage() {
        return new HomePage(driver);
    }

    public TransferPage transferPage() {
        return new TransferPage(driver);
    }
}

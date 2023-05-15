package blu.page_objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    By masukButton = MobileBy.xpath("//*[contains(@text, 'Masuk')]");
    By usePasswordButton = MobileBy.xpath("//*[contains(@text, 'Gunakan Password')]");
    By passwordFieldText = MobileBy.AccessibilityId("mfa_password_input:field");

    public LoginPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void loginWithUser(String password) {
        waitForVisibilityOf(masukButton, 5);
        driver.findElement(masukButton).click();

        waitForVisibilityOf(usePasswordButton, 5);
        driver.findElement(usePasswordButton).click();

        waitForVisibilityOf(passwordFieldText, 5);
        driver.findElement(passwordFieldText).sendKeys(password);
        driver.findElement(masukButton).click();
    }

}

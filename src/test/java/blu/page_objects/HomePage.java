package blu.page_objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    By saldoText = MobileBy.xpath("//*[contains(@text, 'Saldo')]");
    By transactionButton = MobileBy.xpath("(//*[contains(@text, 'Transaksi')])[3]");
    By transferButton = MobileBy.xpath("//*[contains(@text, 'Transfer')]");

    public HomePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void isInHomePage() {
        waitForVisibilityOf(saldoText, 10);
    }

    public void newTransactionWithTransfer(){
        driver.findElement(transactionButton).click();

        waitForVisibilityOf(transferButton, 5);
        driver.findElement(transferButton).click();
    }

}

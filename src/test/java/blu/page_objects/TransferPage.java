package blu.page_objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class TransferPage extends BasePage {
    By transferBaruButton = MobileBy.xpath("//*[contains(@text, 'Transfer Baru')]");
    By namaBankPlaceholder = MobileBy.xpath("//*[contains(@text, 'Nama Bank')]");
    By BCAOption = MobileBy.xpath("//*[@text = 'BCA']");
    By noRekeningField = MobileBy.AccessibilityId("transfer_new_beneficiary_account_number:field");
    By cekButton = MobileBy.xpath("//*[contains(@text, 'Cek')]");
    By nominalTransferField = MobileBy.xpath("//*[contains(@resource-id, 'transfer_detail_amount')]");
    By lanjutButton = MobileBy.xpath("//*[contains(@text, 'Lanjut')]");
    By transferSekarangButton = MobileBy.xpath("//*[contains(@text, 'Transfer Sekarang')]");
    By masukkanPinText = MobileBy.xpath("//*[contains(@text, 'Masukkan PIN')]");

    public TransferPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void newTransferBca(String accountNumber) {
        waitForVisibilityOf(transferBaruButton, 5);
        driver.findElement(transferBaruButton).click();

        waitForVisibilityOf(namaBankPlaceholder, 5);
        driver.findElement(namaBankPlaceholder).click();

        waitForVisibilityOf(BCAOption, 5);
        driver.findElement(BCAOption).click();

        waitForVisibilityOf(noRekeningField, 5);
        driver.findElement(noRekeningField).sendKeys(accountNumber);
        driver.findElement(cekButton).click();
    }

    public void validateAccountName(String accountName) {
        By accountNameText = MobileBy.xpath("//*[contains(@text, '" + accountName + "')]");
        waitForVisibilityOf(accountNameText, 5);
    }

    public void submitTransfer(String nominal) {
        waitForVisibilityOf(nominalTransferField, 5);
        driver.findElement(nominalTransferField).sendKeys(nominal);

        tapElementWithSwipe(lanjutButton);
        driver.findElement(lanjutButton).click();
    }

    public void confirmTransfer() {
        waitForVisibilityOf(transferSekarangButton, 5);
        driver.findElement(transferSekarangButton).click();
    }

    public void validatePin() {
        waitForVisibilityOf(masukkanPinText, 5);
    }
}

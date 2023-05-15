package blu.page_objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected AndroidDriver<AndroidElement> driver;
    public BasePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    protected void waitForVisibilityOf(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected boolean isElementPresent(MobileElement element, int timeout){
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void delay(int milliseconds) {
        try {
            Thread.sleep((long)milliseconds);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;

        private Direction() {
        }
    }

    public void tapElementWithSwipe(By elementLocator) {
        int i = 0;
        int maxSwipeCount = 5;

        while(i < maxSwipeCount) {
            try {
                if (i == maxSwipeCount - 1) {
                    Assertions.fail("Element with locator : " + elementLocator + " doesn't exist!");
                }

                this.driver.findElement(elementLocator).click();
                break;
            } catch (NoSuchElementException | AssertionError | InvalidElementStateException err) {
                this.swipe(Direction.UP);
                this.delay(500);
                ++i;
            }
        }
    }

    public void swipe(Direction direction) {
        Dimension size = this.driver.manage().window().getSize();
        TouchAction touchAction = new TouchAction(this.driver);
        int y0 = (int)((double)size.height * 0.7D);
        int y1 = (int)((double)size.height * 0.3D);
        int x = size.width / 2;

        switch(direction) {
            case UP:
                touchAction.press((new PointOption()).withCoordinates(x, y0)).waitAction((new WaitOptions()).withDuration(Duration.ofMillis(500L))).moveTo((new PointOption()).withCoordinates(x, y1)).release().perform();
                break;
            case DOWN:
                touchAction.press((new PointOption()).withCoordinates(x, y1)).waitAction((new WaitOptions()).withDuration(Duration.ofMillis(500L))).moveTo((new PointOption()).withCoordinates(x, y0)).release().perform();
                break;
            default:
                throw new NotFoundException("Couldn't find direction");
        }
    }
}

package blu;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestInstrument {

    public static final Dotenv dotenv = Dotenv.load();
    private static final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    private static AndroidDriver<AndroidElement> androidDriver;
    protected static Blu blu;

    @BeforeAll
    public static void setUp() {
//        setupDeviceCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:appPackage", "com.bcadigital.blu");
        desiredCapabilities.setCapability("appium:appium:appActivity", "com.bcadigital.blu.MainActivity");
        desiredCapabilities.setCapability("appium:platformVersion", "11.0");
        desiredCapabilities.setCapability("appium:noReset", true);
        desiredCapabilities.setCapability("appium:autoGrantPermissions", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        try {
            androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:3030/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        blu = new Blu(androidDriver);
    }

    private static void setupDeviceCapabilities() {
    }
}

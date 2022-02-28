import com.google.common.collect.ImmutableMap;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.offset.PointOption;
import jdk.internal.instrumentation.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Random;


public class BasePage extends BaseTest {


    @Step("<wait> saniye kadar bekle")
    public void waitForseconds(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
    }

    @Step("id <id> li elementine tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        System.out.println(id + "elementine tıklandı");
    }

    @Step("xpath <xpath> li elementine tıkla")
    public void clickByxpath(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        System.out.println(xpath + "elementine tıklandı");
    }

    @Step("<Sayfada scroll yap>")
    public void scroll(String scroll) {
        TouchAction ts = new TouchAction(appiumDriver);
        ts.press(PointOption.point(540, 1540)).moveTo(PointOption.point(540, 422)).release().perform();
        logger.info("Scroll yapıldı.");
    }


    @Step("Rastgele ürün seçimi yap")
    public void selectRondamproduct() {
        Random rdn = new Random();
        List<MobileElement> us = appiumDriver.findElements(By.xpath("//*[@resource-id = 'com.ozdilek.ozdilekteyim:id/recyclerView']/android.widget.FrameLayout"));
        System.out.println("pd" + us);
        MobileElement element = us.get(rdn.nextInt(us.size()));
        System.out.println("element" + element);
        element.click();

    }
    @Step("Kullanici adi - element <id> write <text>")
    public void sendKeysID(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
    }

    @Step("Sifre - element <id> write <text>")
    public void sendKeysPassword(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
    }

    @Step("Onceki Sayfa - Click to the element with id <id>")
    public void clickBackButton(String id){
        appiumDriver.findElement(By.id(id)).click();
    }
    }



